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
public class Multa {
    private String idMulta;
    private Date fechaInicio;
    private Date fechaFin;
    private Biblioteca biblioteca;
    private Prestamo prestamo;

    public Multa() {
    }

    public Multa(String idMulta, Date fechaInicio, Date fechaFin, Biblioteca biblioteca, Prestamo prestamo) {
        this.idMulta = idMulta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.biblioteca = biblioteca;
        this.prestamo = prestamo;
    }

    public String getIdMulta() {
        return idMulta;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setIdMulta(String idMulta) {
        this.idMulta = idMulta;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
    
    
}
