/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package red_biblio_equipo3.main;

import controlador.CtrlInicioSesion;
import controlador.CtrlMulta;
import controlador.CtrlPrestamo;
import controlador.CtrlRenovacion;
import modelo.CrudMulta;
import modelo.CrudPrestamo;
import modelo.CrudRenovacion;
import modelo.CrudInicioSesion;
import modelo.InicioSesion;
import modelo.Multa;
import modelo.Prestamo;
import modelo.Renovacion;
import vista.Vista_emergenteMulta;
import vista.Vista_emergenteRenovacion;
import vista.Vista_gestionPrestamo;
import vista.Vista_inicioSesion;
import vista.Vista_principal;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;*/

/**
 *
 * @author scocl
 */
public class main {

    public static void main(String[] args) {
        
        
        Vista_inicioSesion vistaInicioS = new Vista_inicioSesion();
        InicioSesion inicioSesion = new InicioSesion();
        CrudInicioSesion crudInicioSesion = new CrudInicioSesion();
        Vista_principal vistaPrincipal = new Vista_principal();
        
        CtrlInicioSesion controlInicioSesion = new CtrlInicioSesion(vistaInicioS, inicioSesion,crudInicioSesion,vistaPrincipal);
        controlInicioSesion.iniciar();
        
        vistaInicioS.setVisible(true);    
        
    /*  Prestamo modP = new Prestamo();
        CRUDPrestamo modCP = new CRUDPrestamo();
        Vista_gestionPrestamo vistaPres = new Vista_gestionPrestamo();
        
        CtrlPrestamo ctrlPres = new CtrlPrestamo(modP,modCP,vistaPres);
        ctrlPres.iniciar();
        vistaPres.setVisible(true);*/
    /*  Multa modM = new Multa();
      CRUDMulta modCM = new CRUDMulta();
      Vista_emergenteMulta vistaMult = new Vista_emergenteMulta();
      
      CtrlMulta ctrlMult = new CtrlMulta(modM,modCM,vistaMult);
      ctrlMult.iniciar();
      vistaMult.setVisible(true);*/
    /*Renovacion modR = new Renovacion();
    CRUDRenovacion modCR = new CRUDRenovacion();
    Vista_emergenteRenovacion vistaRen = new Vista_emergenteRenovacion();
    
    CtrlRenovacion ctrlRen = new CtrlRenovacion(modR,modCR,vistaRen);
    ctrlRen.iniciar();
    vistaRen.setVisible(true);*/
    
         /*OBJETO DE LIBRO
        Libro modL = new Libro();
        CrudLibro modCrudL = new CrudLibro();
        Vista_gestionLibros visL = new Vista_gestionLibros();
        
        ControladorLibro ctrlL = new ControladorLibro(modL, modCrudL, visL);
        ctrlL.iniciar();
        visL.setVisible(true);*/
         //Ejemplar
        /*Ejemplar modE = new Ejemplar();
        CrudEjemplar modCrudE = new CrudEjemplar();
        Vista_gestionEjemplar visE = new Vista_gestionEjemplar();
        
        ControladorEjemplar ctrlE = new ControladorEjemplar(modE, modCrudE, visE);
        ctrlE.iniciar();
        visE.setVisible(true);*/
        
        /*OBJETO DE BIBLIOTECA
        Biblioteca mod = new Biblioteca();
        CrudBiblioteca modCrud = new CrudBiblioteca();
        Vista_gestionBiblioteca vis = new Vista_gestionBiblioteca();
        
        ControladorBiblioteca ctrl = new ControladorBiblioteca(mod, modCrud, vis);
        ctrl.iniciar();
        vis.setVisible(true);*/
    }
}
