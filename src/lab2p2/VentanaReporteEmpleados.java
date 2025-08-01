package lab2p2;

import javax.swing.*;
import java.awt.*;

public class VentanaReporteEmpleados extends JFrame {

    private Empresa empresa;  
    private JTextArea areaReporte;

    public VentanaReporteEmpleados(Empresa empresa) {
        this.empresa = empresa;

        setTitle("Reporte de Empleados");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

      
        areaReporte = new JTextArea();
        areaReporte.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaReporte);
        add(scrollPane, BorderLayout.CENTER);

      
        JPanel panelBotones = new JPanel();
        JButton btnGenerar = new JButton("Generar Reporte");
        JButton btnRegresar = new JButton("Regresar");

        panelBotones.add(btnGenerar);
        panelBotones.add(btnRegresar);

        add(panelBotones, BorderLayout.SOUTH);

 
        btnGenerar.addActionListener(e -> {
            String reporte = empresa.generarReporte();
            areaReporte.setText(reporte);
        });

        btnRegresar.addActionListener(e -> {
            this.dispose();
            new Lab2P2().setVisible(true);
        });
    }

   
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
       

        SwingUtilities.invokeLater(() -> {
            VentanaReporteEmpleados ventana = new VentanaReporteEmpleados(empresa);
            ventana.setVisible(true);
        });
    }
}