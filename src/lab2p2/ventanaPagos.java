package lab2p2;

import javax.swing.*;
import java.awt.*;

public class ventanaPagos extends JFrame {

    private Empresa empresa; 
    private JTextField codigoText;
    private JLabel resultadoLabel;
   

    public ventanaPagos(Empresa empresa) {
        this.empresa = empresa;

        setTitle("Cálculo de Pago Mensual");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel codigoLabel = new JLabel("Código de Empleado:");
        codigoLabel.setBounds(30, 30, 150, 30);
        add(codigoLabel);

        codigoText = new JTextField();
        codigoText.setBounds(180, 30, 150, 30);
        add(codigoText);
        
        

        JButton calcularButton = new JButton("Calcular Pago");
        calcularButton.setBounds(120, 80, 150, 30);
        add(calcularButton);
        
        JButton salirButton = new JButton("Regresar");
        salirButton.setBounds(120, 120, 150, 30);
        add(salirButton);

        resultadoLabel = new JLabel("");
        resultadoLabel.setBounds(30, 130, 320, 30);
        resultadoLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        add(resultadoLabel);

        
        salirButton.addActionListener(e->{
          this.dispose();
          Lab2P2 ventanaMain = new Lab2P2();
          ventanaMain.setVisible(true);
       });
        
        calcularButton.addActionListener(e -> calcularPago());
    }

    private void calcularPago() {
        String codigoStr = codigoText.getText();
        try {
            int codigo = Integer.parseInt(codigoStr);
            double pago = empresa.calcularPago(codigo);
            if (pago >= 0) {
                resultadoLabel.setText("Pago mensual: L. " + String.format("%.2f", pago));
            } else {
                resultadoLabel.setText("Empleado no encontrado.");
            }
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Código inválido.");
        }
    }
    
    public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
             Empresa empresaDePrueba = new Empresa();
        ventanaPagos ventana = new ventanaPagos(empresaDePrueba);
        ventana.setVisible(true);
    });
    }
}
