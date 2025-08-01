/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

import java.awt.*;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author adrianaguilar
 */
public class VentanaRegistrarEmpleado extends JPanel {

    
    private JLabel lblTitulo, lblCodigo, lblNombre, lblSalario, lblFechaContratacion, lblFechaFin;
    
    private JTextField txtCodigo, txtNombre, txtSalario;
    
    private JSpinner spnContratacion, spnFin;
    
    private JButton btnGuardar, btnCancelar;

    public VentanaRegistrarEmpleado() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        
        lblTitulo = new JLabel("Registrar Empleado Temporal");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        lblCodigo = new JLabel("Código:");
        lblNombre = new JLabel("Nombre:");
        lblSalario = new JLabel("Salario Base:");
        lblFechaContratacion = new JLabel("Fecha de Contratación:");
        lblFechaFin = new JLabel("Fecha de Fin de Contrato:");

        txtCodigo = new JTextField(15);
        txtNombre = new JTextField(15);
        txtSalario = new JTextField(15);

        
        spnContratacion = new JSpinner(new SpinnerDateModel());
        spnContratacion.setEditor(new JSpinner.DateEditor(spnContratacion, "dd/MM/yyyy"));
        spnContratacion.setValue(new Date()); 

        spnFin = new JSpinner(new SpinnerDateModel());
        spnFin.setEditor(new JSpinner.DateEditor(spnFin, "dd/MM/yyyy"));

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");

        
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 1;

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

    public LocalDate getFechaContratacion() {
        Date fecha = (Date) spnContratacion.getValue();
        return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public LocalDate getFechaFin() {
        Date fecha = (Date) spnFin.getValue();
        return fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public JButton getBtnGuardar() { return btnGuardar; }
    public JButton getBtnCancelar() { return btnCancelar; }
    
   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaRegistrarEmpleado(); // Ejecuta la GUI
        });
    }
}