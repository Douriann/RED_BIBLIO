/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package modelo;
// CREANDO ATRIBUTOS Y HEREDANDO USUARIO

import factoriaAbstracta.UsuarioAbstracto;

public class Externo extends Usuario implements UsuarioAbstracto{
    
    private String direccion;
// CREANDO SETTERS Y GETTERS
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        System.out.println("Direccion: " + direccion);
    }

}
