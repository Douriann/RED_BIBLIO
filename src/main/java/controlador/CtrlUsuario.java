
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.CrudUsuario;
import modelo.Usuario;
import vista.Vista_gestionUsuario;

public class CtrlUsuario implements ActionListener {
    
    //Objetos de las clases vista, modelo y consultas al modelo de Usuario
    private final Vista_gestionUsuario vistaU;
    private final Usuario modeloU;
    private final CrudUsuario consultasU;

    public CtrlUsuario(Vista_gestionUsuario vistaU, Usuario modeloU, CrudUsuario consultasU) {
        this.vistaU = vistaU;
        this.modeloU = modeloU;
        this.consultasU = consultasU;
        
        //Escuchadores de evento para botones crud y radioButtons
        this.vistaU.btnRegistrarUsu.addActionListener(this);
        this.vistaU.btnModificarUsu.addActionListener(this);
        this.vistaU.btnEliminarUsu.addActionListener(this);
        this.vistaU.btnLimpiarUsu.addActionListener(this);
        this.vistaU.btnBuscarUsu.addActionListener(this);
        this.vistaU.radioBtnAdminUsu.addActionListener(this);
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
            modeloU.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
            modeloU.setNombre(vistaU.txtNombreUsu.getText());
            modeloU.setApellido(vistaU.txtApellidoUsu.getText());
            modeloU.setTipo(4);
            modeloU.setContacto(vistaU.txtTelefUsu.getText());
            modeloU.setContraseña(vistaU.txtContrasUsu.getText());
            modeloU.setIdBiblioteca(Integer.parseInt(vistaU.txtBibliotUsu.getText()));
            
            
            if(consultasU.registrarUsuario(modeloU)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            } 
        }
        
        if(e.getSource() == vistaU.btnModificarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloU.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
            modeloU.setNombre(vistaU.txtNombreUsu.getText());
            modeloU.setApellido(vistaU.txtApellidoUsu.getText());
            modeloU.setContacto(vistaU.txtTelefUsu.getText());
            modeloU.setContraseña(vistaU.txtContrasUsu.getText());
            modeloU.setIdBiblioteca(Integer.parseInt(vistaU.txtBibliotUsu.getText()));
            
            
            if(consultasU.modificarUsuario(modeloU)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            } 
        }
        
        if(e.getSource() == vistaU.btnEliminarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloU.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
             
            if(consultasU.eliminarUsuario(modeloU)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro eliminado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            } 
        }
        
        if(e.getSource() == vistaU.btnBuscarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloU.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
             
            if(consultasU.BuscarUsuario(modeloU)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO ENCONTRO EL REGISTRO
            {
                vistaU.txtCedulaUsu.setText(String.valueOf(modeloU.getCedula()));
                vistaU.txtNombreUsu.setText(modeloU.getNombre());
                vistaU.txtApellidoUsu.setText(modeloU.getApellido());
                vistaU.txtTelefUsu.setText(modeloU.getContacto());
                vistaU.txtContrasUsu.setText(modeloU.getContraseña());
                vistaU.txtBibliotUsu.setText(String.valueOf(modeloU.getIdBiblioteca()));
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
            vistaU.radioBtnAdminUsu.setSelected(false);
            vistaU.txtTelefUsu.setText(null);
            vistaU.txtContrasUsu.setText(null);
            vistaU.txtBibliotUsu.setText(null);
        }
}
