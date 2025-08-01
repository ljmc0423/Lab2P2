package lab2p2;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class VentanaRegistrarEmpleado extends JFrame {

    private Empresa empresa;

    private JComboBox<String> cbTipoEmpleado;
    private JTextField txtCodigo, txtNombre, txtSalario, txtTasaComision;
    private JSpinner spnFechaContratacion, spnFechaFinContrato;
    private JButton btnGuardar, btnCancelar;

    private JLabel lblTasaComision, lblFechaFinContrato;

    public VentanaRegistrarEmpleado(Empresa empresa) {
        this.empresa = empresa;

        setTitle("Registrar Empleados");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        // Tipo empleado
        JLabel lblTipoEmpleado = new JLabel("Tipo de Empleado:");
        cbTipoEmpleado = new JComboBox<>(new String[]{"Estándar", "Temporal", "Ventas"});

        // Campos comunes
        JLabel lblCodigo = new JLabel("Código:");
        txtCodigo = new JTextField(15);

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(15);

        JLabel lblSalario = new JLabel("Salario Base:");
        txtSalario = new JTextField(15);

        JLabel lblFechaContratacion = new JLabel("Fecha de Contratación:");
        spnFechaContratacion = new JSpinner(new SpinnerDateModel());
        spnFechaContratacion.setEditor(new JSpinner.DateEditor(spnFechaContratacion, "dd/MM/yyyy"));
        spnFechaContratacion.setValue(new Date());

        // Campos específicos
        lblFechaFinContrato = new JLabel("Fecha Fin Contrato:");
        spnFechaFinContrato = new JSpinner(new SpinnerDateModel());
        spnFechaFinContrato.setEditor(new JSpinner.DateEditor(spnFechaFinContrato, "dd/MM/yyyy"));
        spnFechaFinContrato.setValue(new Date());

        lblTasaComision = new JLabel("Tasa Comisión (%):");
        txtTasaComision = new JTextField(15);

        // Botones
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        // Agregar componentes al layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblTipoEmpleado, gbc);
        gbc.gridx = 1;
        add(cbTipoEmpleado, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblCodigo, gbc);
        gbc.gridx = 1;
        add(txtCodigo, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblNombre, gbc);
        gbc.gridx = 1;
        add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblSalario, gbc);
        gbc.gridx = 1;
        add(txtSalario, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblFechaContratacion, gbc);
        gbc.gridx = 1;
        add(spnFechaContratacion, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblFechaFinContrato, gbc);
        gbc.gridx = 1;
        add(spnFechaFinContrato, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(lblTasaComision, gbc);
        gbc.gridx = 1;
        add(txtTasaComision, gbc);

        gbc.gridx = 0; gbc.gridy++;
        add(btnGuardar, gbc);
        gbc.gridx = 1;
        add(btnCancelar, gbc);

        // Mostrar/ocultar campos según tipo empleado
        cbTipoEmpleado.addActionListener(e -> actualizarCamposSegunTipo());

        // Inicialmente ajusta campos
        actualizarCamposSegunTipo();

        // Acción botón Guardar
        btnGuardar.addActionListener(e -> {
            try {
                int codigo = Integer.parseInt(txtCodigo.getText().trim());
                String nombre = txtNombre.getText().trim();
                double salario = Double.parseDouble(txtSalario.getText().trim());

                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
                    return;
                }
                if (salario <= 0) {
                    JOptionPane.showMessageDialog(this, "El salario debe ser mayor a cero.");
                    return;
                }

                Date fechaContratacionDate = (Date) spnFechaContratacion.getValue();
                Calendar fechaContratacionCal = Calendar.getInstance();
                fechaContratacionCal.setTime(fechaContratacionDate);

                String tipo = (String) cbTipoEmpleado.getSelectedItem();

                Empleado nuevoEmpleado = null;

                switch (tipo) {
                    case "Estándar":
                        // Crear empleado estándar
                        nuevoEmpleado = new Empleado(codigo, nombre, salario);
                        nuevoEmpleado.fechaContratacion = fechaContratacionCal;
                        break;

                    case "Temporal":
                        Date fechaFinDate = (Date) spnFechaFinContrato.getValue();
                        Calendar fechaFinCal = Calendar.getInstance();
                        fechaFinCal.setTime(fechaFinDate);

                        if (fechaFinCal.before(fechaContratacionCal)) {
                            JOptionPane.showMessageDialog(this, "La fecha fin de contrato no puede ser anterior a la fecha de contratación.");
                            return;
                        }

                        EmpleadoTemporal empTemp = new EmpleadoTemporal(codigo, nombre, salario);
                        empTemp.fechaContratacion = fechaContratacionCal;
                        empTemp.nuevaFechaFin(fechaFinCal);
                        nuevoEmpleado = empTemp;
                        break;

                    case "Ventas":
                        String tasaStr = txtTasaComision.getText().trim();
                        double tasaComision = 0.05; 
                        if (!tasaStr.isEmpty()) {
                            tasaComision = Double.parseDouble(tasaStr) / 100.0;
                            if (tasaComision < 0 || tasaComision > 1) {
                                JOptionPane.showMessageDialog(this, "La tasa de comisión debe estar entre 0 y 100.");
                                return;
                            }
                        }

                        EmpleadoVentas empVentas = new EmpleadoVentas(codigo, nombre, salario);
                        empVentas.fechaContratacion = fechaContratacionCal;
                        empVentas.tasaComision = tasaComision;  // Necesitarás modificar el campo para hacerlo público o crea setter
                        nuevoEmpleado = empVentas;
                        break;

                    default:
                        JOptionPane.showMessageDialog(this, "Tipo de empleado inválido.");
                        return;
                }

                // Intentar agregar el empleado
                if (!empresa.agregarEmpleado(nuevoEmpleado)) {
                    JOptionPane.showMessageDialog(this, "Código de empleado ya existe. Use otro código.");
                    return;
                }

                JOptionPane.showMessageDialog(this, "Empleado registrado con éxito.");
                this.dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Código, salario y tasa de comisión (si aplica) deben ser números válidos.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage());
            }
        });

        btnCancelar.addActionListener(e -> this.dispose());

        setVisible(true);
    }

    private void actualizarCamposSegunTipo() {
        String tipo = (String) cbTipoEmpleado.getSelectedItem();
        boolean esTemporal = "Temporal".equals(tipo);
        boolean esVentas = "Ventas".equals(tipo);

        lblFechaFinContrato.setVisible(esTemporal);
        spnFechaFinContrato.setVisible(esTemporal);

        lblTasaComision.setVisible(esVentas);
        txtTasaComision.setVisible(esVentas);
    }
}
