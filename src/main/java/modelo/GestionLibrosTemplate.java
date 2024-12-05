
package modelo;

//APLICACIÓN PATRÓN DE DISEÑO DE COMPORTAMIENTO - TEMPLATE METHOD
//Esta es la clase abstracta que define la Plantilla que contiene el esqueleto 
//de los métodos que las subclases concretas implementan y sobrescriben sin cambiar su estructura o plantilla

public abstract class GestionLibrosTemplate {

    protected CrudLibro crudLibro;

    public GestionLibrosTemplate() {
        this.crudLibro = new CrudLibro();
    }

    // Método plantilla
    public final void gestionarLibro(Libro libro) {
        if (puedeRegistrar()) {
            registrar(libro);
        }
        if (puedeModificar()) {
            modificar(libro);
        }
        if (puedeEliminar()) {
            eliminar(libro);
        }
        if (puedeConsultar()) {
            consultar(libro);
        }
    }

    // Métodos abstractos que serán implementados por las subclases concretas
    public abstract boolean puedeRegistrar();
    public abstract boolean puedeModificar();
    public abstract boolean puedeEliminar();
    public abstract boolean puedeConsultar();

    public abstract boolean registrar(Libro libro);
    public abstract boolean modificar(Libro libro);
    public abstract boolean eliminar(Libro libro);
    public abstract boolean consultar(Libro libro);
}
