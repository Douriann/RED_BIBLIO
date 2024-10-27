/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author scocl
 */
public class Biblioteca {
    
    private int idBiblioteca;
    private String nomBiblioteca;
    private String direccion;
    private Libro[] libros;

    public Biblioteca() {
    }

    public Biblioteca(int idBiblioteca, String nomBiblioteca, String direccion, Libro[] libros) {
        this.idBiblioteca = idBiblioteca;
        this.nomBiblioteca = nomBiblioteca;
        this.direccion = direccion;
        this.libros = libros;
    }
    
    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public String getNomBiblioteca() {
        return nomBiblioteca;
    }

    public void setNomBiblioteca(String nomBiblioteca) {
        this.nomBiblioteca = nomBiblioteca;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Libro[] getLibros() {
        return libros;
    }

    public void setLibros(Libro[] libros) {
        this.libros = libros;
    }
    
}