/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package factoriaAbstracta;

import modelo.Administrador;
import modelo.CrudAdmin;

public class FabricaAdmin implements FabricaAbstracta{

    // Sobre escritura de los metodos de fabricacion para crear objetos de la clase Administrador y su Crud
    @Override
    public UsuarioAbstracto crearUsuario() {
        return new Administrador();
    }

    @Override
    public CrudAbstracto crearCrud() {
        return new CrudAdmin();
    }
    
}
