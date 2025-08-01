package lab2p2;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author adrianaguilar
 */
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;

public class PanelRegistrarHoras extends JPanel {

    private JLabel lblTitulo, lblCodigo, lblHoras;
    private JTextField txtCodigo, txtHoras;
    private JButton btnRegistrar, btnCancelar;

    public PanelRegistrarHoras() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

    
        lblTitulo = new JLabel("Registrar Horas Trabajadas");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));

        lblCodigo = new JLabel("Código del Empleado:");
        lblHoras = new JLabel("Horas trabajadas:");

        txtCodigo = new JTextField(15);
        txtHoras = new JTextField(15);

        btnRegistrar = new JButton("Registrar");
        btnCancelar = new JButton("Cancelar");

       
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
    }

    
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

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }
}
