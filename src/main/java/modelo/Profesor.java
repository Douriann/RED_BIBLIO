/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package modelo;
// CLASE PROFESOR HEREDA DE USUARIO, JUNTO A SUS ATRIBUTOS INDIVIDUALES

import factoriaAbstracta.UsuarioAbstracto;

public class Profesor extends Usuario implements UsuarioAbstracto{
    
    private int idTituloAcad;
    private int idDepartamento;

    public int getIdTituloAcad() {
        return idTituloAcad;
    }

    public void setIdTituloAcad(int idTituloAcad) {
        this.idTituloAcad = idTituloAcad;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    @Override
    public void mostrarUsuario() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Cedula: " + cedula);
        System.out.println("Tipo: " + tipo);
        System.out.println("Departamento: " + idDepartamento);
    }

}
