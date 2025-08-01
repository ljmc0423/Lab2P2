/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2;

import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

/**
 *
 * @author hnleo
 */
public class ventanaContrato extends JFrame {
     public ventanaContrato(){
       
        JPanel panelLogin = new JPanel();
        JLabel labelLogin = new JLabel("PAGOS DE EMPLEADOS");

        JLabel codigoLabel = new JLabel("Código de Empleado: ");
        JTextField codigoText = new JTextField();
        JButton actButton = new JButton("ACTUALIZAR");
        JButton salirButton = new JButton("REGRESAR");
     
        
        this.setSize(500, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Actualizar Contrato");
        panelLogin.setBounds(0, 0, 500, 500);
        panelLogin.setBackground(Color.WHITE);
        panelLogin.setLayout(null);

        labelLogin.setBounds(109, 10, 300, 100);
        labelLogin.setFont(new Font("Verdana", Font.BOLD, 16));
        labelLogin.setForeground(Color.BLACK);

        codigoLabel.setBounds(46, 115, 224, 30);
        codigoLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        codigoLabel.setForeground(Color.BLACK);
       
        codigoText.setBounds(226, 122, 200, 25);
        codigoText.setFont(new Font("Verdana", Font.BOLD, 14));
        codigoText.setForeground(Color.BLACK);
        
        actButton.setBounds(226, 152, 200, 30);
        actButton.setFont(new Font("Verdana", Font.BOLD, 12));
        actButton.setForeground(Color.BLACK);


        salirButton.setBounds(330, 400, 130, 30);
        salirButton.setFont(new Font("Verdana", Font.BOLD, 12));
        salirButton.setForeground(Color.BLACK);
        salirButton.addActionListener(e->{
          this.dispose();
          Lab2P2 ventanaMain = new Lab2P2();
          ventanaMain.setVisible(true);
       });
        
        actButton.addActionListener(e -> {
            int codigo = Integer.parseInt(codigoText.getText());
            Calendar nuevaFecha = Calendar.getInstance();
            JSpinner spFecha = new JSpinner(new SpinnerDateModel());
            nuevaFecha.setTime((Date) spFecha.getValue());
            Empresa emp=new Empresa();
            boolean ok = emp.actualizarFechaContrato(codigo, nuevaFecha);
            JOptionPane.showMessageDialog(this, ok ? "Fecha actualizada" : "Empleado no encontrado o no es temporal");
        });
       
        this.add(panelLogin);
        panelLogin.add(labelLogin);
        panelLogin.add(codigoLabel);
        panelLogin.add(codigoText);
        panelLogin.add(actButton);
        
        panelLogin.add(salirButton);
        
        
        
    }
     
    
}