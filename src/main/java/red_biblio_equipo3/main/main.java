/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */

package red_biblio_equipo3.main;

import controlador.CtrlInicioSesion;
import modelo.CrudInicioSesion;
import modelo.InicioSesion;
import vista.Vista_inicioSesion;
import vista.Vista_principal;
public class main {

    public static void main(String[] args) {
        
        // LLAMADO E INICIALIZACION DE LOS PARAMETROS NECESARIOS PARA ABRIR EL CONTROLADOR
        Vista_inicioSesion vistaInicioS = new Vista_inicioSesion();
        InicioSesion inicioSesion = new InicioSesion();
        CrudInicioSesion crudInicioSesion = new CrudInicioSesion();
        Vista_principal vistaPrincipal = new Vista_principal();
        
        CtrlInicioSesion controlInicioSesion = new CtrlInicioSesion(vistaInicioS, inicioSesion,crudInicioSesion,vistaPrincipal);
        controlInicioSesion.iniciar();
        // MOSTRAR VENTANA
        vistaInicioS.setVisible(true);
    }
}
