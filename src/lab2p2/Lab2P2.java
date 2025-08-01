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
import javax.swing.JFrame;

/**
 *
 * @author ljmc2
 */
public class Lab2P2 extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        JPanel panelLogin = new JPanel();
        JLabel labelLogin = new JLabel("GESTIÓN DE EMPLEADOS");

        JButton registrarButton = new JButton("Registro de Empleados");
        JButton horasButton = new JButton("Registro de Horas");
        JButton ventasButton = new JButton("Registro de Ventas");
        JButton contratoButton = new JButton("Actualizar Contrato");
        JButton calculoButton = new JButton("Calculo de Pagos");
        JButton reporteButton = new JButton("REPORTE");
        JButton salirButton = new JButton("SALIR SISTEMA");
        
        ventana.setSize(500, 500);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ventana.setLayout(null);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Gestion de Empleados");
        panelLogin.setBounds(0, 0, 500, 500);
        panelLogin.setBackground(Color.WHITE);
        panelLogin.setLayout(null);

        labelLogin.setBounds(109, 10, 300, 100);
        labelLogin.setFont(new Font("Verdana", Font.BOLD, 20));
        labelLogin.setForeground(Color.BLACK);

        registrarButton.setBounds(26, 152, 224, 30);
        registrarButton.setFont(new Font("Verdana", Font.BOLD, 14));
        registrarButton.setForeground(Color.BLACK);

        horasButton.setBounds(256, 152, 200, 30);
        horasButton.setFont(new Font("Verdana", Font.BOLD, 14));
        horasButton.setForeground(Color.BLACK);
        
        ventasButton.setBounds(26, 202, 224, 30);
        ventasButton.setFont(new Font("Verdana", Font.BOLD, 14));
        ventasButton.setForeground(Color.BLACK);

        contratoButton.setBounds(256, 202, 200, 30);
        contratoButton.setFont(new Font("Verdana", Font.BOLD, 14));
        contratoButton.setForeground(Color.BLACK);
        
        calculoButton.setBounds(26, 252, 224, 30);
        calculoButton.setFont(new Font("Verdana", Font.BOLD, 14));
        calculoButton.setForeground(Color.BLACK);

        reporteButton.setBounds(256, 252, 200, 30);
        reporteButton.setFont(new Font("Verdana", Font.BOLD, 14));
        reporteButton.setForeground(Color.BLACK);
        
        salirButton.setBounds(150, 302, 200, 30);
        salirButton.setFont(new Font("Verdana", Font.BOLD, 14));
        salirButton.setForeground(Color.BLACK);
        salirButton.addActionListener(e->{
           System.exit(0);
       });
       
        ventana.add(panelLogin);
        panelLogin.add(labelLogin);
        panelLogin.add(registrarButton);
        panelLogin.add(horasButton);
        panelLogin.add(ventasButton);
        panelLogin.add(contratoButton);
        panelLogin.add(calculoButton);
        panelLogin.add(reporteButton);
        panelLogin.add(salirButton);
        
    }
}
