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
public class Prestamo {
    private String idPrestamo;
    private Date fechaSalida;
    private Date fechaVence;
    private Date fechaEntrego;
    private String idEstadoPre;
    private Biblioteca biblioteca;
    private Usuario usuario;
    private Ejemplar ejemplar;

    public Prestamo() {
    }

    public Prestamo(String idPrestamo, Date fechaSalida, Date fechaVence, Date fechaEntrego, String idEstadoPre, Biblioteca biblioteca, Usuario usuario, Ejemplar ejemplar) {
        this.idPrestamo = idPrestamo;
        this.fechaSalida = fechaSalida;
        this.fechaVence = fechaVence;
        this.fechaEntrego = fechaEntrego;
        this.idEstadoPre = idEstadoPre;
        this.biblioteca = biblioteca;
        this.usuario = usuario;
        this.ejemplar = ejemplar;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaVence() {
        return fechaVence;
    }

    public void setFechaVence(Date fechaVence) {
        this.fechaVence = fechaVence;
    }

    public Date getFechaEntrego() {
        return fechaEntrego;
    }

    public void setFechaEntrego(Date fechaEntrego) {
        this.fechaEntrego = fechaEntrego;
    }

    public String getIdEstadoPre() {
        return idEstadoPre;
    }

    public void setIdEstadoPre(String idEstadoPre) {
        this.idEstadoPre = idEstadoPre;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }
    
    public void prestar(){
    }
    
    public void devolver(){
        
    }
    
    public void generarReportePrestamos(){
        
    }
}
