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
import modelo.CrudEstudiante;
import modelo.Estudiante;
import factoriaAbstracta.UsuarioAbstracto;
import vista.Vista_gestionUsuario;

public class CtrlEstudiante implements ActionListener {
    
    //Objetos de las clases vista, modelo y consultas al modelo de Usuario
    private final Vista_gestionUsuario vistaU;
    private final Estudiante modeloEs;
    private final CrudEstudiante consultasEs;

    public CtrlEstudiante(Vista_gestionUsuario vistaU, UsuarioAbstracto modeloEs, CrudAbstracto consultasEs) {
        this.vistaU = vistaU;
        this.modeloEs = (Estudiante) modeloEs;
        this.consultasEs = (CrudEstudiante)consultasEs;
        
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
            modeloEs.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
            modeloEs.setNombre(vistaU.txtNombreUsu.getText());
            modeloEs.setApellido(vistaU.txtApellidoUsu.getText());
            modeloEs.setTipo(1);
            modeloEs.setContacto(vistaU.txtTelefUsu.getText());
            modeloEs.setContraseña(vistaU.txtContrasUsu.getText());
            modeloEs.setIdBiblioteca(Integer.parseInt(vistaU.txtBibliotUsu.getText()));
            modeloEs.setIdCarrera(Integer.parseInt(vistaU.txtIdCarrUsu.getText()));
            
            
            if(consultasEs.registrarEstudiante(modeloEs)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            } 
        }
        
        if(e.getSource() == vistaU.btnModificarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloEs.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
            modeloEs.setNombre(vistaU.txtNombreUsu.getText());
            modeloEs.setApellido(vistaU.txtApellidoUsu.getText());
            modeloEs.setContacto(vistaU.txtTelefUsu.getText());
            modeloEs.setContraseña(vistaU.txtContrasUsu.getText());
            modeloEs.setIdBiblioteca(Integer.parseInt(vistaU.txtBibliotUsu.getText()));
            modeloEs.setIdCarrera(Integer.parseInt(vistaU.txtIdCarrUsu.getText()));
            
            if(consultasEs.modificarEstudiante(modeloEs)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            } 
        }
        
        if(e.getSource() == vistaU.btnEliminarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloEs.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
             
            if(consultasEs.eliminarEstudiante(modeloEs)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro eliminado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            } 
        }
        
        if(e.getSource() == vistaU.btnBuscarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloEs.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
             
            if(consultasEs.BuscarEstudiante(modeloEs)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO ENCONTRO EL REGISTRO
            {
                vistaU.txtCedulaUsu.setText(String.valueOf(modeloEs.getCedula()));
                vistaU.txtNombreUsu.setText(modeloEs.getNombre());
                vistaU.txtApellidoUsu.setText(modeloEs.getApellido());
                vistaU.txtTelefUsu.setText(modeloEs.getContacto());
                vistaU.txtContrasUsu.setText(modeloEs.getContraseña());
                vistaU.txtBibliotUsu.setText(String.valueOf(modeloEs.getIdBiblioteca()));
                vistaU.txtIdCarrUsu.setText(String.valueOf(modeloEs.getIdCarrera()));
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
            vistaU.radioBtnEstUsu.setSelected(false);
            vistaU.txtTelefUsu.setText(null);
            vistaU.txtContrasUsu.setText(null);
            vistaU.txtBibliotUsu.setText(null);
            vistaU.txtIdCarrUsu.setText(null);
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
