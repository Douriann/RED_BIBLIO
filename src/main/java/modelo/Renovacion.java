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

// LLAMANDO ATRIBUTOS
public class Renovacion {
    private int idRenovacion;
    private Date fechaSalida;
    private Date fechaVence;
    private int idEstadoRen;
    private Prestamo prestamo;
    private String nomEstRen;
// CREACION DE CONSTRUCTORES
    public Renovacion() {
    }
    
    public Renovacion(int idRenovacion, Date fechaSalida, Date fechaVence, int idEstadoRen, Prestamo prestamo) {
        this.idRenovacion = idRenovacion;
        this.fechaSalida = fechaSalida;
        this.fechaVence = fechaVence;
        this.idEstadoRen = idEstadoRen;
        this.prestamo = prestamo;
    }
// DEFINIENDO SETTERS Y GETTERS
    public int getIdRenovacion() {
        return idRenovacion;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public Date getFechaVence() {
        return fechaVence;
    }

    public int getIdEstadoRen() {
        return idEstadoRen;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setIdRenovacion(int idRenovacion) {
        this.idRenovacion = idRenovacion;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setFechaVence(Date fechaVence) {
        this.fechaVence = fechaVence;
    }

    public void setIdEstadoRen(int idEstadoRen) {
        this.idEstadoRen = idEstadoRen;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public String getNomEstRen() {
        return nomEstRen;
    }

    public void setNomEstRen(String nomEstRen) {
        this.nomEstRen = nomEstRen;
    }
    
    
    
    public void generarReporteRenovaciones(){
        
    }
    
}
