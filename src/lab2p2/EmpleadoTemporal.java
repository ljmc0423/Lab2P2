/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2p2;
import java.time.LocalDate;
/**
 *
 * @author ljmc2
 */
public class EmpleadoTemporal extends Empleado{
    
    private LocalDate fechaFinDeContrato;
    
    public EmpleadoTemporal(int codigo, String nombre, double salario) {
        super(codigo, nombre, salario);
    }
    
    
    @Override
    public double calcularPago(){
        
        LocalDate hoy = LocalDate.now();
        
        if(hoy.isAfter(fechaFinDeContrato)){
            
            return 0;
            
        } else{ 
            return super.calcularPago();
        
        }}
        
        
     
        public void NuevaFechaFin(LocalDate nuevaFecha){
            
            this.fechaFinDeContrato = nuevaFecha;
        }
        
        
        public String mostrarInfo() {
            
            return super.mostrarInfo() + "El contrato finalizo en " + fechaFinDeContrato;
        }
    
    
    
}

