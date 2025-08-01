/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author adrianaguilar
 */


public class RegistrarVentas extends JFrame {

    private JLabel lblTitulo, lblCodigo, lblMonto;
    private JTextField txtCodigo, txtMonto;
    private JButton btnRegistrar, btnCancelar;

    public RegistrarVentas() {
        setTitle("Registrar Ventas - Empleado de Ventas");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        
        lblTitulo = new JLabel("Registrar Ventas");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(0, 51, 102));

        lblCodigo = new JLabel("Código del Empleado:");
        lblMonto = new JLabel("Monto de la Venta:");

        txtCodigo = new JTextField(15);
        txtMonto = new JTextField(15);

        btnRegistrar = new JButton("Registrar");
        btnCancelar = new JButton("Cancelar");

       
        btnRegistrar.setBackground(new Color(0, 153, 76));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);

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
        add(lblMonto, gbc);
        gbc.gridx = 1;
        add(txtMonto, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(btnRegistrar, gbc);
        gbc.gridx = 1;
        add(btnCancelar, gbc);

        setVisible(true);
    }

    
    public String getCodigo() {
        return txtCodigo.getText();
    }

    public double getMonto() {
        try {
            return Double.parseDouble(txtMonto.getText());
        } catch (Exception e) {
            return 0.0;
        }
    }

    public JButton getBtnRegistrar() { return btnRegistrar; }
    public JButton getBtnCancelar() { return btnCancelar; }
    

}

