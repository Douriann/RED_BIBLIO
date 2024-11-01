
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
// Clases necesarias
import modelo.InicioSesion;
import vista.Vista_inicioSesion;
import modelo.CrudInicioSesion;
import vista.Vista_principal;

public class CtrlInicioSesion implements ActionListener{
    
    private final Vista_inicioSesion interfazInicioS;
    private final InicioSesion modeloInicioS;
    private final CrudInicioSesion consultasInicioS;
    private final Vista_principal ventanaPrincipal;

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
        }
        else if (consultasInicioS.buscarEstudiante(modeloInicioS) || consultasInicioS.buscarProfesor(modeloInicioS) || consultasInicioS.buscarExterno(modeloInicioS)){
            //Se encontro un estudiante, profesor o externo. Se le da acceso al sistema
            JOptionPane.showMessageDialog(null, "Bienvenido al sistema " + modeloInicioS.getNombreUsuario());
            
            interfazInicioS.setVisible(false);
            CtrlPrincipal controlPrincipal = new CtrlPrincipal(ventanaPrincipal);
            ventanaPrincipal.setVisible(true);
        }
        else{ 
            //Las credenciales no coinciden con las credenciales de algun registro en tabla usuario
            //El usuario no esta registrado o sus credenciales estan incorrectas y no se le da acceso
            JOptionPane.showMessageDialog(null, "Acceso Denegado \n Por favor ingrese sus datos nuevamente \n o registrese en sistema");
        }
    }
    
}
