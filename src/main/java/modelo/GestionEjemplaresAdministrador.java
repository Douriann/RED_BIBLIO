package modelo;

//APLICACIÓN PATRÓN DE DISEÑO DE COMPORTAMIENTO - TEMPLATE METHOD
//SubClase Concreta de la Clase GestionEjemplaresTemplate 
//que implementara y sobrescribirá los métodos en caso de que el tipoUsuario sea Administrador

public class GestionEjemplaresAdministrador extends GestionEjemplaresTemplate {

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
    public boolean registrar(Ejemplar ejemplar) {
        return crudEjemplar.registrarEjemplar(ejemplar);
    }

    @Override
    public boolean modificar(Ejemplar ejemplar) {
        return crudEjemplar.modificarEjemplar(ejemplar);
    }

    @Override
    public boolean eliminar(Ejemplar ejemplar) {
        return crudEjemplar.eliminarEjemplar(ejemplar);
    }

    @Override
    public boolean consultar(Ejemplar ejemplar) {
        return crudEjemplar.buscarEjemplar(ejemplar);
    }
}
