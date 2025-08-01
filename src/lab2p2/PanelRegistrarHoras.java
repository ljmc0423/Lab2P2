package lab2p2;


import javax.swing.*;
import java.awt.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adrianaguilar
 */


public class PanelRegistrarHoras extends JFrame {

    private JLabel lblTitulo, lblCodigo, lblHoras;
    private JTextField txtCodigo, txtHoras;
    private JButton btnRegistrar, btnCancelar;

    public PanelRegistrarHoras() {
        setTitle("Registrar Horas Trabajadas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Título
        lblTitulo = new JLabel("Registrar Horas Trabajadas");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(0, 51, 102));

        lblCodigo = new JLabel("Código del Empleado:");
        lblHoras = new JLabel("Horas trabajadas:");

        txtCodigo = new JTextField(15);
        txtHoras = new JTextField(15);

        btnRegistrar = new JButton("Registrar");
        btnCancelar = new JButton("Cancelar");

        // Estilo de botones
        btnRegistrar.setBackground(new Color(0, 153, 76));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);

        btnCancelar.setBackground(new Color(204, 0, 0));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);

        // Ubicación
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 1;
        add(lblCodigo, gbc);
        gbc.gridx = 1;
        add(txtCodigo, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(lblHoras, gbc);
        gbc.gridx = 1;
        add(txtHoras, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(btnRegistrar, gbc);
        gbc.gridx = 1;
        add(btnCancelar, gbc);

        setVisible(true);
    }

    // Getters para lógica
    public String getCodigo() {
        return txtCodigo.getText();
    }

    public int getHoras() {
        try {
            return Integer.parseInt(txtHoras.getText());
        } catch (Exception e) {
            return 0;
        }
    }

    public JButton getBtnRegistrar() { return btnRegistrar; }
    public JButton getBtnCancelar() { return btnCancelar; }
}
