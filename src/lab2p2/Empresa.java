/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author ljmc2
 */
public class Empresa {

    private ArrayList<Empleado> empleados = new ArrayList<>();

    public boolean agregarEmpleado(Empleado e) {
        for (Empleado emp : empleados) {
            if (emp.codigoEmpleado == (e.codigoEmpleado)) {
                return false;
            }
        }
        empleados.add(e);
        return true;
    }

    private Empleado buscarEmpleado(int codigo) {
        for (Empleado e : empleados) {
            if (e.codigoEmpleado == (codigo)) {
                return e;
            }
        }
        return null;
    }

    public boolean registrarHoras(int codigo, int horas) {
        Empleado e = buscarEmpleado(codigo);
        if (e != null) {
            e.registrarHoras(horas);
            return true;
        }
        return false;
    }

    public boolean registrarVentas(int codigo, double monto) {
        Empleado e = buscarEmpleado(codigo);
        if (e instanceof EmpleadoVentas) {
            ((EmpleadoVentas) e).registrarVenta(monto);
            return true;
        }
        return false;
    }

    public boolean actualizarFechaContrato(int codigo, Calendar nuevaFecha) {
        Empleado e = buscarEmpleado(codigo);
        if (e instanceof EmpleadoTemporal) {
            ((EmpleadoTemporal) e).nuevaFechaFin(nuevaFecha);
            return true;
        }
        return false;
    }

    public Double calcularPago(int codigo) {
        Empleado e = buscarEmpleado(codigo);
        if (e != null) {
            return e.calcularPago();
        }
        return null;
    }

    public String generarReporte() {
        StringBuilder sb = new StringBuilder();
        int est = 0, temp = 0, vent = 0;

        for (Empleado e : empleados) {
            sb.append(e.mostrarInfo())
                    .append(" | Pago Mensual: ")
                    .append(e.calcularPago())
                    .append("\n");

            if (e instanceof EmpleadoVentas) {
                vent++;
            } else if (e instanceof EmpleadoTemporal) {
                temp++;
            } else {
                est++;
            }
        }

        sb.append("\nTotales: Estándar=").append(est)
                .append(", Temporales=").append(temp)
                .append(", Ventas=").append(vent);
        return sb.toString();
    }
}
