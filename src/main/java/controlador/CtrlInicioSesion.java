/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
// Clases necesarias
import modelo.InicioSesion;
import vista.Vista_inicioSesion;
import modelo.CrudInicioSesion;
import modelo.Reportes;
import vista.Vista_principal;

public class CtrlInicioSesion implements ActionListener{
    
    private final Vista_inicioSesion interfazInicioS;
    private final InicioSesion modeloInicioS;
    private final CrudInicioSesion consultasInicioS;
    private final Vista_principal ventanaPrincipal;
    // Variable que guardara tipo de usuario
    public static int tipoUsuario;

    
    public CtrlInicioSesion(Vista_inicioSesion interfazInicioS, InicioSesion modeloInicioS, CrudInicioSesion consultasInicioS, Vista_principal ventanaPrincipal) {
        this.interfazInicioS = interfazInicioS;   //Inicializo atributos
        this.modeloInicioS = modeloInicioS;
        this.consultasInicioS = consultasInicioS;
        this.ventanaPrincipal = ventanaPrincipal;
        
        this.interfazInicioS.btnInicioSes.addActionListener(this); //Agrego escuchador de accion a boton iniciar sesion
    }
    
        public void iniciar() {
        interfazInicioS.setTitle("Inicio Sesion");
        interfazInicioS.setLocationRelativeTo(null);
    }
    
    @Override
        public void actionPerformed(ActionEvent e) {
            
        //Inicializo modelo con datos que entran de la vista
        modeloInicioS.setNombreUsuario(interfazInicioS.txtUsuario.getText()); 
        modeloInicioS.setContrasena(interfazInicioS.txtContrasena.getText());
        
        //Invocar los metodos buscar de la clase de consultas 
        if (consultasInicioS.buscarAdministrador(modeloInicioS)){ 
            //Se encontro un administrador. Se le da acceso al sistema
            JOptionPane.showMessageDialog(null, "Bienvenido al sistema " + modeloInicioS.getNombreUsuario());
            CtrlPrincipal controlPrincipal = new CtrlPrincipal(ventanaPrincipal);
            ventanaPrincipal.setVisible(true);
            interfazInicioS.setVisible(false);
            Reportes reporte = new Reportes();
            int contPres = reporte.contTotalPrestamosMes();
            ventanaPrincipal.numTotalPrest.setText(String.valueOf(contPres));
            int contMult = reporte.contTotalMultadosMes();
            ventanaPrincipal.numTotalSan.setText(String.valueOf(contMult));
            int contLib = reporte.contTotalLibrosDisp();
            ventanaPrincipal.numTotalLib.setText(String.valueOf(contLib));
            //Damos valor inicial a variable que guardara el tipo de usuario
            tipoUsuario = 3;
        }
        else if (consultasInicioS.buscarEstudiante(modeloInicioS)){
            //Se encontro un estudiante. Se le da acceso al sistema
            JOptionPane.showMessageDialog(null, "Bienvenido al sistema " + modeloInicioS.getNombreUsuario());
            
            interfazInicioS.setVisible(false);
            CtrlPrincipal controlPrincipal = new CtrlPrincipal(ventanaPrincipal);
            ventanaPrincipal.setVisible(true);
            ventanaPrincipal.btn_prestamo.setVisible(false);
            ventanaPrincipal.btn_usuario.setVisible(false);
            ventanaPrincipal.btn_biblio.setVisible(false);
            ventanaPrincipal.numTotalLib.setVisible(false);
            ventanaPrincipal.numTotalSan.setVisible(false);
            ventanaPrincipal.numTotalPrest.setVisible(false);
            ventanaPrincipal.lblDisp.setVisible(false);
            ventanaPrincipal.lblSanc.setVisible(false);
            ventanaPrincipal.lblTtlDe.setVisible(false);
            ventanaPrincipal.lblTtlLibros.setVisible(false);
            ventanaPrincipal.lblTtlPrest.setVisible(false);
            //Damos valor inicial a variable que guardara el tipo de usuario
            tipoUsuario = 1;
        }
        else if(consultasInicioS.buscarProfesor(modeloInicioS)){
            //Se encontro un profesor. Se le da acceso al sistema
            JOptionPane.showMessageDialog(null, "Bienvenido al sistema " + modeloInicioS.getNombreUsuario());
            
            interfazInicioS.setVisible(false);
            CtrlPrincipal controlPrincipal = new CtrlPrincipal(ventanaPrincipal);
            ventanaPrincipal.setVisible(true);
            ventanaPrincipal.btn_prestamo.setVisible(false);
            ventanaPrincipal.btn_usuario.setVisible(false);
            ventanaPrincipal.btn_biblio.setVisible(false);
            ventanaPrincipal.numTotalLib.setVisible(false);
            ventanaPrincipal.numTotalSan.setVisible(false);
            ventanaPrincipal.numTotalPrest.setVisible(false);
            ventanaPrincipal.lblDisp.setVisible(false);
            ventanaPrincipal.lblSanc.setVisible(false);
            ventanaPrincipal.lblTtlDe.setVisible(false);
            ventanaPrincipal.lblTtlLibros.setVisible(false);
            ventanaPrincipal.lblTtlPrest.setVisible(false);            
            //Damos valor inicial a variable que guardara el tipo de usuario
            tipoUsuario = 2;
        }
        else if(consultasInicioS.buscarExterno(modeloInicioS)) {
            //Se encontro un externo. Se le da acceso al sistema
            JOptionPane.showMessageDialog(null, "Bienvenido al sistema " + modeloInicioS.getNombreUsuario());
            
            interfazInicioS.setVisible(false);
            CtrlPrincipal controlPrincipal = new CtrlPrincipal(ventanaPrincipal);
            ventanaPrincipal.setVisible(true);
            ventanaPrincipal.btn_prestamo.setVisible(false);
            ventanaPrincipal.btn_usuario.setVisible(false);
            ventanaPrincipal.btn_biblio.setVisible(false);
            //Damos valor inicial a variable que guardara el tipo de usuario
            tipoUsuario = 4;
        }
        else{ 
            //Las credenciales no coinciden con las credenciales de algun registro en tabla usuario
            //El usuario no esta registrado o sus credenciales estan incorrectas y no se le da acceso
            JOptionPane.showMessageDialog(null, "Acceso Denegado \n Por favor ingrese sus datos nuevamente \n o registrese en sistema");
        }
    }
    
}
