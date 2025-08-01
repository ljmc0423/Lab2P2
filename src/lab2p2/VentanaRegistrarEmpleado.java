/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2;


import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class VentanaRegistrarEmpleado extends JFrame {

    private JLabel lblTitulo, lblCodigo, lblNombre, lblSalario, lblFechaContratacion, lblFechaFin;
    private JTextField txtCodigo, txtNombre, txtSalario;
    private JSpinner spnContratacion, spnFin;
    private JButton btnGuardar, btnCancelar;

    public VentanaRegistrarEmpleado() {
        setTitle("Registrar Empleado Temporal");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Título
        lblTitulo = new JLabel("Registrar Empleado Temporal");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(0, 51, 102)); 

        lblCodigo = new JLabel("Código:");
        lblNombre = new JLabel("Nombre:");
        lblSalario = new JLabel("Salario Base:");
        lblFechaContratacion = new JLabel("Fecha de Contratación:");
        lblFechaFin = new JLabel("Fecha de Fin de Contrato:");

        txtCodigo = new JTextField(15);
        txtNombre = new JTextField(15);
        txtSalario = new JTextField(15);

        
        spnContratacion = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor1 = new JSpinner.DateEditor(spnContratacion, "dd/MM/yyyy");
        spnContratacion.setEditor(editor1);
        spnContratacion.setValue(new Date());

       
        spnFin = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(spnFin, "dd/MM/yyyy");
        spnFin.setEditor(editor2);

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

       
        btnGuardar.setBackground(new Color(0, 153, 76));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.setFocusPainted(false);

        btnCancelar.setBackground(new Color(204, 0, 0));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);

       
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 1;
        add(lblCodigo, gbc);
        gbc.gridx = 1;
        add(txtCodigo, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(lblNombre, gbc);
        gbc.gridx = 1;
        add(txtNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(lblSalario, gbc);
        gbc.gridx = 1;
        add(txtSalario, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        add(lblFechaContratacion, gbc);
        gbc.gridx = 1;
        add(spnContratacion, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        add(lblFechaFin, gbc);
        gbc.gridx = 1;
        add(spnFin, gbc);

        gbc.gridx = 0; gbc.gridy = 6;
        add(btnGuardar, gbc);
        gbc.gridx = 1;
        add(btnCancelar, gbc);

        setVisible(true);
    }

   
    public int getCodigo() {
        try { return Integer.parseInt(txtCodigo.getText()); }
        catch (Exception e) { return 0; }
    }

    public String getNombre() { return txtNombre.getText(); }

    public double getSalario() {
        try { return Double.parseDouble(txtSalario.getText()); }
        catch (Exception e) { return 0.0; }
    }

    public Calendar getFechaContratacion() {
        Date fecha = (Date) spnContratacion.getValue();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal;
    }

    public Calendar getFechaFin() {
        Date fecha = (Date) spnFin.getValue();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal;
    }

    public JButton getBtnGuardar() { return btnGuardar; }
    public JButton getBtnCancelar() { return btnCancelar; }
}
