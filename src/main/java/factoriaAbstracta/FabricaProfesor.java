/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package factoriaAbstracta;

import modelo.CrudProfesor;
import modelo.Profesor;

//Fabrica concreta de profesor
public class FabricaProfesor implements FabricaAbstracta{

    // sobre escritura de los metodos fabrica para instanciar las clases de Profesor y CrudProfesor
    @Override
    public UsuarioAbstracto crearUsuario() {
        return new Profesor();
    }

    @Override
    public CrudAbstracto crearCrud() {
        return new CrudProfesor();
    }
    
}
