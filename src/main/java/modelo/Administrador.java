/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package modelo;
// CLASE HEREDADORA DE ATRIBUTOS USUARIO

import factoriaAbstracta.UsuarioAbstracto;

public class Administrador extends Usuario implements UsuarioAbstracto{
    @Override
    public void mostrarUsuario() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Cedula: " + cedula);
        System.out.println("Tipo: " + tipo);
    }

}
