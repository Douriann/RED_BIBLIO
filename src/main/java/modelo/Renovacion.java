/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.Date;

/**
 *
 * @author scocl
 */
public class Renovacion {
    private String idRenovacion;
    private Date fechaSalida;
    private Date fechaVence;
    private String idEstadoRen;
    private Prestamo prestamo;

    public Renovacion() {
    }

    public Renovacion(String idRenovacion, Date fechaSalida, Date fechaVence, String idEstadoRen, Prestamo prestamo) {
        this.idRenovacion = idRenovacion;
        this.fechaSalida = fechaSalida;
        this.fechaVence = fechaVence;
        this.idEstadoRen = idEstadoRen;
        this.prestamo = prestamo;
    }

    public String getIdRenovacion() {
        return idRenovacion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public Date getFechaVence() {
        return fechaVence;
    }

    public String getIdEstadoRen() {
        return idEstadoRen;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setIdRenovacion(String idRenovacion) {
        this.idRenovacion = idRenovacion;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setFechaVence(Date fechaVence) {
        this.fechaVence = fechaVence;
    }

    public void setIdEstadoRen(String idEstadoRen) {
        this.idEstadoRen = idEstadoRen;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
    
    public void generarReporteRenovaciones(){
        
    }
    
}
