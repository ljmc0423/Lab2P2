/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2;

import java.util.Calendar;

/**
 *
 * @author ljmc2
 */
public class EmpleadoVentas extends Empleado {

    private double ventasMensuales[];
    private double tasaComision;
    private int mesActual;

    public EmpleadoVentas(int codigo, String nombre, double salario) {
        super(codigo, nombre, salario);
        this.ventasMensuales = new double[12];
        this.tasaComision = 0.05;
    }

    public boolean registrarVenta(double monto) {
        mesActual = Calendar.getInstance().get(Calendar.MONTH);
        if (monto > 0) {
            ventasMensuales[mesActual] += monto;
            return true;
        }
        return false;
    }

    public double calculoComision() {
        mesActual = Calendar.getInstance().get(Calendar.MONTH);
        return ventasMensuales[mesActual] * tasaComision;
    }

    @Override

    public double calcularPago() {
        return super.calcularPago() + calculoComision();
    }

    public double totalVentas() {
        double total = 0;
        for (double i : ventasMensuales) {
            total += i;
        }

        return total;
    }
    
    @Override
    
    public String mostrarInfo(){
        return super.mostrarInfo() + "\nVentas Anuales: " + String.format("%.2f", totalVentas()) + " Lps";
    }

}
