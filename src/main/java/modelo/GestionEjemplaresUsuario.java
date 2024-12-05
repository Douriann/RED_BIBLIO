package modelo;

//APLICACIÓN PATRÓN DE DISEÑO DE COMPORTAMIENTO - TEMPLATE METHOD
//SubClase Concreta de la Clase GestionEjemplaresTemplate 
//que implementara y sobrescribirá los métodos en caso de que el tipoUsuario 
//sea un usuario diferente a Administrador o sea Estudiante, Profesor o Externo

public class GestionEjemplaresUsuario extends GestionEjemplaresTemplate {

    @Override
    public boolean puedeRegistrar() {
        return false; // No tiene permisos para registrar
    }

    @Override
    public boolean puedeModificar() {
        return false;  // No tiene permisos para modificar 
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
    public boolean registrar(Ejemplar ejemplar) {
        return false; // No tiene permisos para registrar
    }

    @Override
    public boolean modificar(Ejemplar ejemplar) {
        return false; // No tiene permisos para modificar
    }

    @Override
    public boolean eliminar(Ejemplar ejemplar) {
        return false; // No tiene permisos para eliminar
    }

    @Override
    public boolean consultar(Ejemplar ejemplar) {
        return crudEjemplar.buscarEjemplar(ejemplar); // Tiene permisos para consultar ejecuta consulta
    }
}
