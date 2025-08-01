package lab2p2;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Lab2P2 extends JFrame {

    public Lab2P2() {
       
        JPanel panelLogin = new JPanel();
        JLabel labelLogin = new JLabel("GESTIÓN DE EMPLEADOS");

        JButton registrarButton = new JButton("Registro de Empleados");
        JButton horasButton = new JButton("Registro de Horas");
        JButton ventasButton = new JButton("Registro de Ventas");
        JButton contratoButton = new JButton("Actualizar Contrato");
        JButton calculoButton = new JButton("Calculo de Pagos");
        JButton reporteButton = new JButton("REPORTE");
        JButton salirButton = new JButton("SALIR SISTEMA");

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Gestion de Empleados");

        panelLogin.setBounds(0, 0, 500, 500);
        panelLogin.setBackground(Color.WHITE);
        panelLogin.setLayout(null);

        labelLogin.setBounds(109, 10, 300, 100);
        labelLogin.setFont(new Font("Verdana", Font.BOLD, 20));

        registrarButton.setBounds(26, 152, 224, 30);
        registrarButton.setFont(new Font("Verdana", Font.BOLD, 14));
        registrarButton.addActionListener(e -> {
            VentanaRegistrarEmpleado ventana1 = new VentanaRegistrarEmpleado();
            ventana1.setVisible(true);
        });

        horasButton.setBounds(256, 152, 200, 30);
        horasButton.setFont(new Font("Verdana", Font.BOLD, 14));

        ventasButton.setBounds(26, 202, 224, 30);
        ventasButton.setFont(new Font("Verdana", Font.BOLD, 14));

        contratoButton.setBounds(256, 202, 200, 30);
        contratoButton.setFont(new Font("Verdana", Font.BOLD, 14));
        contratoButton.addActionListener(e -> {
            this.setVisible(false);
            new ventanaContrato().setVisible(true);
        });

        calculoButton.setBounds(26, 252, 224, 30);
        reporteButton.setBounds(256, 252, 200, 30);
        salirButton.setBounds(150, 302, 200, 30);

        salirButton.addActionListener(e -> System.exit(0));

        panelLogin.add(labelLogin);
        panelLogin.add(registrarButton);
        panelLogin.add(horasButton);
        panelLogin.add(ventasButton);
        panelLogin.add(contratoButton);
        panelLogin.add(calculoButton);
        panelLogin.add(reporteButton);
        panelLogin.add(salirButton);

        this.add(panelLogin);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Lab2P2 ventanaMain = new Lab2P2();
            ventanaMain.setVisible(true);
        });
    }
}
