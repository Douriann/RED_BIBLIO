
package modelo;

public class Biblioteca {
    
    private int idBiblioteca;
    private String nomBiblioteca;
    private String direccion;

    public Biblioteca() {
    }

    public Biblioteca(int idBiblioteca, String nomBiblioteca, String direccion, Libro[] libros) {
        this.idBiblioteca = idBiblioteca;
        this.nomBiblioteca = nomBiblioteca;
        this.direccion = direccion;
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
}