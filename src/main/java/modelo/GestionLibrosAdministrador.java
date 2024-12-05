package modelo;

//APLICACIÓN PATRÓN DE DISEÑO DE COMPORTAMIENTO - TEMPLATE METHOD
//SubClase Concreta de la Clase GestionLibrosTemplate 
//que implementara y sobrescribirá los métodos en caso de que el tipoUsuario sea Administrador

public class GestionLibrosAdministrador extends GestionLibrosTemplate {

    @Override
    public boolean puedeRegistrar() {
        return true;
    }

    @Override
    public boolean puedeModificar() {
        return true;
    }

    @Override
    public boolean puedeEliminar() {
        return true;
    }

    @Override
    public boolean puedeConsultar() {
        return true;
    }

    @Override
    public boolean registrar(Libro libro) {
        return crudLibro.registrarLibro(libro);
    }

    @Override
    public boolean modificar(Libro libro) {
        return crudLibro.modificarLibro(libro);
    }

    @Override
    public boolean eliminar(Libro libro) {
        return crudLibro.eliminarLibro(libro);
    }

    @Override
    public boolean consultar(Libro libro) {
        return crudLibro.buscarLibro(libro);
    }
}
