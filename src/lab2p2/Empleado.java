/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author ljmc2
 */
public class Empleado {

    protected int codigoEmpleado;
    protected String nombreEmpleado;
    protected Calendar fechaContratacion;
    protected double salarioBase;
    protected int horasTrabajadas;

    public Empleado(int codigo, String nombre, double salario) {
        codigoEmpleado = codigo;
        nombreEmpleado = nombre;
        fechaContratacion = Calendar.getInstance();
        salarioBase = salario;
        horasTrabajadas = 0;
    }

    public void registrarHoras(int horas) {
        horasTrabajadas += horas;
    }

    public double calcularPago() {
        double pago = (salarioBase * horasTrabajadas) / 160;
        return pago - (pago * 0.035);
    }

    public String mostrarInfo() {
        int dia = fechaContratacion.get(Calendar.DAY_OF_MONTH);
        int mes = fechaContratacion.get(Calendar.MONTH) + 1;

        int anno = fechaContratacion.get(Calendar.YEAR);

        int year = fechaContratacion.get(Calendar.YEAR);


        return "Código: " + codigoEmpleado
                + "\nNombre: " + nombreEmpleado
                + "\nFecha de contratación: " + dia + "/" + mes + "/"
                + anno;
    }

}
