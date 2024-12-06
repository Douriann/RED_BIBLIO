/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package factoriaAbstracta;

import modelo.CrudEstudiante;
import modelo.Estudiante;
 //Fabrica concreta
public class FabricaEstudiante implements FabricaAbstracta {

    //Sobre escribe los metodos de fabricacion retornando el objeto producto de interes
    @Override
    public UsuarioAbstracto crearUsuario() {
        return new Estudiante();
    }

    @Override
    public CrudAbstracto crearCrud() {
        return new CrudEstudiante();
    }
    
}
