package modelo;

public class Libro {
    private int idLibro;
    private String titulo;
    private String autor;
    private int año;
    private int idCategoria;
    private int idBibliotecaLibro; // tabla intermedia
    private int cantEjemplares; // tabla intermedia
    private Biblioteca biblioteca;

    public Libro() {
    }

    public Libro(int idLibro, String titulo, String autor, int año, int idCategoria, Biblioteca biblioteca) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.idCategoria = idCategoria;
        this.biblioteca = biblioteca;
    }
    
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdBibliotecaLibro() {
        return idBibliotecaLibro;
    }

    public void setIdBibliotecaLibro(int idBibliotecaLibro) {
        this.idBibliotecaLibro = idBibliotecaLibro;
    }

    public int getCantEjemplares() {
        return cantEjemplares;
    }

    public void setCantEjemplares(int cantEjemplares) {
        this.cantEjemplares = cantEjemplares;
    }
    
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    
}
