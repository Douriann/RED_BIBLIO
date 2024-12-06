/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package controlador;

import factoriaAbstracta.CrudAbstracto;
import factoriaAbstracta.UsuarioAbstracto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.CrudAdmin;
import vista.Vista_gestionUsuario;

public class CtrlAdmin implements ActionListener {
    
    //Objetos de las clases vista, modelo y consultas al modelo de Usuario
    private final Vista_gestionUsuario vistaU;
    private final Administrador modeloA;
    private final CrudAdmin consultasA;

    public CtrlAdmin(Vista_gestionUsuario vistaU, UsuarioAbstracto modeloA, CrudAbstracto consultasA) {
        this.vistaU = vistaU;
        this.modeloA = (Administrador) modeloA;
        this.consultasA = (CrudAdmin) consultasA;
        
        //Escuchadores de evento para botones crud y radioButtons
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
            modeloA.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
            modeloA.setNombre(vistaU.txtNombreUsu.getText());
            modeloA.setApellido(vistaU.txtApellidoUsu.getText());
            modeloA.setTipo(3);
            modeloA.setContacto(vistaU.txtTelefUsu.getText());
            modeloA.setContraseña(vistaU.txtContrasUsu.getText());
            modeloA.setIdBiblioteca(Integer.parseInt(vistaU.txtBibliotUsu.getText()));
            
            
            if(consultasA.registrarAdmin(modeloA)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            } 
        }
        
        if(e.getSource() == vistaU.btnModificarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloA.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
            modeloA.setNombre(vistaU.txtNombreUsu.getText());
            modeloA.setApellido(vistaU.txtApellidoUsu.getText());
            modeloA.setContacto(vistaU.txtTelefUsu.getText());
            modeloA.setContraseña(vistaU.txtContrasUsu.getText());
            modeloA.setIdBiblioteca(Integer.parseInt(vistaU.txtBibliotUsu.getText()));
            
            
            if(consultasA.modificarAdmin(modeloA)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            } 
        }
        
        if(e.getSource() == vistaU.btnEliminarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloA.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
             
            if(consultasA.eliminarAdmin(modeloA)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro eliminado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            } 
        }
        
        if(e.getSource() == vistaU.btnBuscarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloA.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
             
            if(consultasA.BuscarAdmin(modeloA)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO ENCONTRO EL REGISTRO
            {
                vistaU.txtCedulaUsu.setText(String.valueOf(modeloA.getCedula()));
                vistaU.txtNombreUsu.setText(modeloA.getNombre());
                vistaU.txtApellidoUsu.setText(modeloA.getApellido());
                vistaU.txtTelefUsu.setText(modeloA.getContacto());
                vistaU.txtContrasUsu.setText(modeloA.getContraseña());
                vistaU.txtBibliotUsu.setText(String.valueOf(modeloA.getIdBiblioteca()));
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

