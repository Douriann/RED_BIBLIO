/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package modelo;
import java.util.Date;
// CREANDO ATRIBUTOS
public class Multa {
    private int idMulta;
    private Date fechaInicio;
    private Date fechaFin;
    private Biblioteca biblioteca;
    private Prestamo prestamo;
// CREANDO CONSTRUCTORES
    public Multa() {
    }

    public Multa(int idMulta, Date fechaInicio, Date fechaFin, Biblioteca biblioteca, Prestamo prestamo) {
        this.idMulta = idMulta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.biblioteca = biblioteca;
        this.prestamo = prestamo;
    }
// CREANDO SETTERS Y GETTERS
    public int getIdMulta() {
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

    public void setIdMulta(int idMulta) {
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
