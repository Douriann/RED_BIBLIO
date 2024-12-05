package modelo;

//APLICACIÓN PATRÓN DE DISEÑO DE COMPORTAMIENTO - TEMPLATE METHOD
//SubClase Concreta de la Clase GestionLibrosTemplate 
//que implementara y sobrescribirá los métodos en caso de que el tipoUsuario 
//sea un usuario diferente a Administrador o sea Estudiante, Profesor o Externo

public class GestionLibrosUsuario extends GestionLibrosTemplate {

    @Override
    public boolean puedeRegistrar() {
        return false; // No tiene permisos para registrar
    }

    @Override
    public boolean puedeModificar() {
        return false; // No tiene permisos para modificar
    }

    @Override
    public boolean puedeEliminar() {
        return false; // No tiene permisos para eliminar
    }

    @Override
    public boolean puedeConsultar() {
        return true; // Tiene permisos para consultar
    }

    @Override
    public boolean registrar(Libro libro) {
        return false; // No tiene permisos para registrar
    }

    @Override
    public boolean modificar(Libro libro) {
        return false; // No tiene permisos para modificar
    }

    @Override
    public boolean eliminar(Libro libro) {
        return false; // No tiene permisos para eliminar
    }

    @Override
    public boolean consultar(Libro libro) {
        return crudLibro.buscarLibro(libro);  // Tiene permisos para consultar ejecuta consulta
    }
}
