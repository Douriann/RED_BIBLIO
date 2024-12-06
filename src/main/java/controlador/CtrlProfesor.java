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
import factoriaAbstracta.CrudAbstracto;
import modelo.CrudProfesor;
import modelo.Profesor;
import factoriaAbstracta.UsuarioAbstracto;
import vista.Vista_gestionUsuario;

public class CtrlProfesor implements ActionListener {
    
    //Objetos de las clases vista, modelo y consultas al modelo de Usuario
    private final Vista_gestionUsuario vistaU;
    private final Profesor modeloP;
    private final CrudProfesor consultasP;

    public CtrlProfesor(Vista_gestionUsuario vistaU, UsuarioAbstracto modeloP, CrudAbstracto consultasP) {
        this.vistaU = vistaU;
        this.modeloP = (Profesor) modeloP;
        this.consultasP = (CrudProfesor) consultasP;
        
        //Escuchadores de evento para botones crud
        this.vistaU.btnRegistrarUsu.addActionListener(this);
        this.vistaU.btnModificarUsu.addActionListener(this);
        this.vistaU.btnEliminarUsu.addActionListener(this);
        this.vistaU.btnLimpiarUsu.addActionListener(this);
        this.vistaU.btnBuscarUsu.addActionListener(this);
    }
    
    //METODO QUE INICIA VENTANA
    public void iniciar()
    {
        vistaU.setTitle("Usuario");
        vistaU.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        //Verificar que boton se cliquea
        if(e.getSource() == vistaU.btnRegistrarUsu){
            
                //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloP.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
            modeloP.setNombre(vistaU.txtNombreUsu.getText());
            modeloP.setApellido(vistaU.txtApellidoUsu.getText());
            modeloP.setTipo(2);
            modeloP.setContacto(vistaU.txtTelefUsu.getText());
            modeloP.setContraseña(vistaU.txtContrasUsu.getText());
            modeloP.setIdBiblioteca(Integer.parseInt(vistaU.txtBibliotUsu.getText()));
            modeloP.setIdTituloAcad(Integer.parseInt(vistaU.txtIdTitAcadUsu.getText()));
            modeloP.setIdDepartamento(Integer.parseInt(vistaU.txtIdDepUsu.getText()));
            
            if(consultasP.registrarProfesor(modeloP)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            } 
        }
        
        if(e.getSource() == vistaU.btnModificarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloP.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
            modeloP.setNombre(vistaU.txtNombreUsu.getText());
            modeloP.setApellido(vistaU.txtApellidoUsu.getText());
            modeloP.setContacto(vistaU.txtTelefUsu.getText());
            modeloP.setContraseña(vistaU.txtContrasUsu.getText());
            modeloP.setIdBiblioteca(Integer.parseInt(vistaU.txtBibliotUsu.getText()));
            modeloP.setIdTituloAcad(Integer.parseInt(vistaU.txtIdTitAcadUsu.getText()));
            modeloP.setIdDepartamento(Integer.parseInt(vistaU.txtIdDepUsu.getText()));
            
            if(consultasP.modificarProfesor(modeloP)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            } 
        }
        
        if(e.getSource() == vistaU.btnEliminarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloP.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
             
            if(consultasP.eliminarProfesor(modeloP)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro eliminado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            } 
        }
        
        if(e.getSource() == vistaU.btnBuscarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloP.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
             
            if(consultasP.BuscarProfesor(modeloP)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO ENCONTRO EL REGISTRO
            {
                vistaU.txtCedulaUsu.setText(String.valueOf(modeloP.getCedula()));
                vistaU.txtNombreUsu.setText(modeloP.getNombre());
                vistaU.txtApellidoUsu.setText(modeloP.getApellido());
                vistaU.txtTelefUsu.setText(modeloP.getContacto());
                vistaU.txtContrasUsu.setText(modeloP.getContraseña());
                vistaU.txtBibliotUsu.setText(String.valueOf(modeloP.getIdBiblioteca()));
                vistaU.txtIdTitAcadUsu.setText(String.valueOf(modeloP.getIdTituloAcad()));
                vistaU.txtIdDepUsu.setText(String.valueOf(modeloP.getIdDepartamento()));
                JOptionPane.showMessageDialog(null, "Registro Encontrado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al buscar");
            } 
        }
        
        if(e.getSource() == vistaU.btnLimpiarUsu)
        {
            limpiar();
        }
    }
        
    public void limpiar(){
            vistaU.txtCedulaUsu.setText(null);
            vistaU.txtNombreUsu.setText(null);
            vistaU.txtApellidoUsu.setText(null);
            vistaU.radioBtnProfUsu.setSelected(false);
            vistaU.txtTelefUsu.setText(null);
            vistaU.txtContrasUsu.setText(null);
            vistaU.txtBibliotUsu.setText(null);
            vistaU.txtIdTitAcadUsu.setText(null);
            vistaU.txtIdDepUsu.setText(null);
        }
    
    public void removerActionListeners() {
        for (ActionListener al : vistaU.btnRegistrarUsu.getActionListeners()) {
            vistaU.btnRegistrarUsu.removeActionListener(al);
        }
        for (ActionListener al : vistaU.btnModificarUsu.getActionListeners()) {
            vistaU.btnModificarUsu.removeActionListener(al);
        }
        for (ActionListener al : vistaU.btnBuscarUsu.getActionListeners()) {
            vistaU.btnBuscarUsu.removeActionListener(al);
        }
        for (ActionListener al : vistaU.btnEliminarUsu.getActionListeners()) {
            vistaU.btnEliminarUsu.removeActionListener(al);
        }
    }
}
