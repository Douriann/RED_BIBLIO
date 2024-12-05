
package modelo;

//APLICACIÓN PATRÓN DE DISEÑO DE COMPORTAMIENTO - TEMPLATE METHOD
//Esta es la clase abstracta que define la Plantilla que contiene el esqueleto 
//de los métodos que las subclases concretas implementan y sobrescriben sin cambiar su estructura o plantilla

public abstract class GestionEjemplaresTemplate {

    protected CrudEjemplar crudEjemplar;

    public GestionEjemplaresTemplate() {
        this.crudEjemplar = new CrudEjemplar();
    }

    // Método plantilla
    public final void gestionarEjemplar(Ejemplar ejemplar) {
        if (puedeRegistrar()) {
            registrar(ejemplar);
        }
        if (puedeModificar()) {
            modificar(ejemplar);
        }
        if (puedeEliminar()) {
            eliminar(ejemplar);
        }
        if (puedeConsultar()) {
            consultar(ejemplar);
        }
    }

    // Métodos abstractos que serán implementados por las subclases concretas
    public abstract boolean puedeRegistrar();
    public abstract boolean puedeModificar();
    public abstract boolean puedeEliminar();
    public abstract boolean puedeConsultar();

    public abstract boolean registrar(Ejemplar ejemplar);
    public abstract boolean modificar(Ejemplar ejemplar);
    public abstract boolean eliminar(Ejemplar ejemplar);
    public abstract boolean consultar(Ejemplar ejemplar);
}
