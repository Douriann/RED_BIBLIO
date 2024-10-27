/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author scocl
 */
public class Ejemplar {
    
    private int idEjemplar;
    private int idEstadoEj;
    private String ubicacion;
    private Libro libro;
    
    public Ejemplar() {
    }

    public Ejemplar(int idEjemplar, int idEstadoEj, String ubicacion, Libro libro) {
        this.idEjemplar = idEjemplar;
        this.idEstadoEj = idEstadoEj;
        this.ubicacion = ubicacion;
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

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
}
