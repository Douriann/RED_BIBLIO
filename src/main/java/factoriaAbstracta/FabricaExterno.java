/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package factoriaAbstracta;

import modelo.CrudExterno;
import modelo.Externo;
//Fabrica concreta
public class FabricaExterno implements FabricaAbstracta{

    //Sobre escritura de los metodos de fabricacion para instanciar las clases usuario externo y su crud
    @Override
    public UsuarioAbstracto crearUsuario() {
        return new Externo();
    }

    @Override
    public CrudAbstracto crearCrud() {
        return new CrudExterno();
    }
    
}
