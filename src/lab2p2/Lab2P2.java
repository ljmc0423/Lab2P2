/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2p2;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ljmc2
 */
public class Lab2P2 extends JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        JPanel panelLogin = new JPanel();
        JLabel labelLogin = new JLabel("GESTIÓN DE EMPLEADOS");
        JTextField tusuario = new JTextField();
        JPasswordField tpassword = new JPasswordField();
        JButton iniciarButton = new JButton("ENTRAR");
        JButton salirButton = new JButton("SALIR");


        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Gestion de Empleados");
        panelLogin.setBounds(0, 0, 800, 600);
        panelLogin.setBackground(Color.WHITE);
        panelLogin.setLayout(null);

        labelLogin.setBounds(86, 10, 250, 100);
        labelLogin.setFont(new Font("Verdana", Font.BOLD, 20));
        labelLogin.setForeground(Color.BLACK);


        iniciarButton.setBounds(86, 222, 111, 30);
        iniciarButton.setFont(new Font("Verdana", Font.BOLD, 14));
        iniciarButton.setForeground(Color.BLACK);

      
        salirButton.setBounds(206, 222, 100, 30);
        salirButton.setFont(new Font("Verdana", Font.BOLD, 14));
        salirButton.setForeground(Color.BLACK);

 

        ventana.add(panelLogin);
        panelLogin.add(labelLogin);
        panelLogin.add(iniciarButton);
        panelLogin.add(salirButton);

    }
    
}
