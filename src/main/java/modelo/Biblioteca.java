/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package modelo;
// CREACION DE ATRIBUTOS
public class Biblioteca {
    
    private int idBiblioteca;
    private String nomBiblioteca;
    private String direccion;
// CREACION DE CONSTRUCTORES
    public Biblioteca() {
    }

    public Biblioteca(int idBiblioteca, String nomBiblioteca, String direccion, Libro[] libros) {
        this.idBiblioteca = idBiblioteca;
        this.nomBiblioteca = nomBiblioteca;
        this.direccion = direccion;
    }
// CREACION DE SETTERS Y GETTERS    
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
}