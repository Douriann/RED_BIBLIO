package modelo;

public class Ejemplar {
    
    private int idEjemplar;
    private int idEstadoEj;
    private String ubicacion;
    private int idLibro; // Profesora este no va es solo para esta fase mientras implementamos la funcionalidad  listas desplegables
    private Libro libro;
    
    public Ejemplar() {
    }

    public Ejemplar(int idEjemplar, int idEstadoEj, String ubicacion, int idLibro, Libro libro) {
        this.idEjemplar = idEjemplar;
        this.idEstadoEj = idEstadoEj;
        this.ubicacion = ubicacion;
        this.idLibro = idLibro;
        this.libro = libro;
    }

    
    public int getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(int idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public int getIdEstadoEj() {
        return idEstadoEj;
    }

    public void setIdEstadoEj(int idEstadoEj) {
        this.idEstadoEj = idEstadoEj;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }
    
    public Libro getLibro() {
        return libro;
    }
    

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
}
