/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2;

import java.util.Calendar;

public class EmpleadoTemporal extends Empleado {
    
    private Calendar fechaFinDeContrato;

    public EmpleadoTemporal(int codigo, String nombre, double salario) {
        super(codigo, nombre, salario);
    }
    
    @Override
    public double calcularPago() {
        Calendar hoy = Calendar.getInstance();
        
        if (fechaFinDeContrato != null && hoy.after(fechaFinDeContrato)) {
            return 0;
        } else {
            return super.calcularPago();
        }
    }

    public void nuevaFechaFin(Calendar nuevaFecha) {
        this.fechaFinDeContrato = nuevaFecha;
    }

    @Override
    public String mostrarInfo() {
        String finContrato = (fechaFinDeContrato != null)
                ? fechaFinDeContrato.get(Calendar.DAY_OF_MONTH) + "/" 
                  + (fechaFinDeContrato.get(Calendar.MONTH) + 1) + "/" 
                  + fechaFinDeContrato.get(Calendar.YEAR)
                : "No asignada";
        
        return super.mostrarInfo() + "\nContrato finaliza: " + finContrato;
    }
}
