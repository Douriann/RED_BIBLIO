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
public class Prestamo {
    private int idPrestamo;
    private Date fechaSalida;
    private Date fechaVence;
    private Date fechaEntrego;
    private int idEstadoPre;
    private String nomEstadoPre;
    private Biblioteca biblioteca;
    private Usuario usuario;
    private Ejemplar ejemplar;
// CREANDO CONSTRUCTORES
    public Prestamo() {
    }

    public Prestamo(int idPrestamo, Date fechaSalida, Date fechaVence, Date fechaEntrego, int idEstadoPre, Biblioteca biblioteca, Usuario usuario, Ejemplar ejemplar) {
        this.idPrestamo = idPrestamo;
        this.fechaSalida = fechaSalida;
        this.fechaVence = fechaVence;
        this.fechaEntrego = fechaEntrego;
        this.idEstadoPre = idEstadoPre;
        this.biblioteca = biblioteca;
        this.usuario = usuario;
        this.ejemplar = ejemplar;
    }
// CREANDO SETTERS Y GETTERS
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
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

    public int getIdEstadoPre() {
        return idEstadoPre;
    }

    public void setIdEstadoPre(int idEstadoPre) {
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

    public String getNomEstadoPre() {
        return nomEstadoPre;
    }

    public void setNomEstadoPre(String nomEstadoPre) {
        this.nomEstadoPre = nomEstadoPre;
    }
    
    public void prestar(){
    }
    
    public void devolver(){
        
    }
    
    public void generarReportePrestamos(){
        
    }
}
