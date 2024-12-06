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
import modelo.CrudExterno;
import modelo.Externo;
import factoriaAbstracta.UsuarioAbstracto;
import vista.Vista_gestionUsuario;

public class CtrlExterno implements ActionListener {
    
    //Objetos de las clases vista, modelo y consultas al modelo de Externo
    private final Vista_gestionUsuario vistaU;
    private final Externo modeloEx;
    private final CrudExterno consultasEx;

    public CtrlExterno(Vista_gestionUsuario vistaU, UsuarioAbstracto modeloEx, CrudAbstracto consultasEx) {
        this.vistaU = vistaU;
        this.modeloEx = (Externo) modeloEx;
        this.consultasEx = (CrudExterno) consultasEx;
        
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
            modeloEx.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
            modeloEx.setNombre(vistaU.txtNombreUsu.getText());
            modeloEx.setApellido(vistaU.txtApellidoUsu.getText());
            modeloEx.setTipo(4);
            modeloEx.setContacto(vistaU.txtTelefUsu.getText());
            modeloEx.setContraseña(vistaU.txtContrasUsu.getText());
            modeloEx.setIdBiblioteca(Integer.parseInt(vistaU.txtBibliotUsu.getText()));
            modeloEx.setDireccion(vistaU.txtDireccUsu.getText());
            
            
            if(consultasEx.registrarExterno(modeloEx)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            } 
        }
        
        if(e.getSource() == vistaU.btnModificarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloEx.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
            modeloEx.setNombre(vistaU.txtNombreUsu.getText());
            modeloEx.setApellido(vistaU.txtApellidoUsu.getText());
            modeloEx.setContacto(vistaU.txtTelefUsu.getText());
            modeloEx.setContraseña(vistaU.txtContrasUsu.getText());
            modeloEx.setIdBiblioteca(Integer.parseInt(vistaU.txtBibliotUsu.getText()));
            modeloEx.setDireccion(vistaU.txtDireccUsu.getText());
            
            if(consultasEx.modificarExterno(modeloEx)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO MODIFICO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            } 
        }
        
        if(e.getSource() == vistaU.btnEliminarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloEx.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
             
            if(consultasEx.eliminarExterno(modeloEx)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO ELIMINO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro eliminado");    
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
            } 
        }
        
        if(e.getSource() == vistaU.btnBuscarUsu){
            
            //Establecer los datos que entran por las cajas de texto a los atributos de modelo
            modeloEx.setCedula(Integer.parseInt(vistaU.txtCedulaUsu.getText()));
             
            if(consultasEx.BuscarExterno(modeloEx)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO ENCONTRO EL REGISTRO
            {
                vistaU.txtCedulaUsu.setText(String.valueOf(modeloEx.getCedula()));
                vistaU.txtNombreUsu.setText(modeloEx.getNombre());
                vistaU.txtApellidoUsu.setText(modeloEx.getApellido());
                vistaU.txtTelefUsu.setText(modeloEx.getContacto());
                vistaU.txtContrasUsu.setText(modeloEx.getContraseña());
                vistaU.txtBibliotUsu.setText(String.valueOf(modeloEx.getIdBiblioteca()));
                vistaU.txtDireccUsu.setText(modeloEx.getDireccion());
            } else {
                JOptionPane.showMessageDialog(null, "Registro Encontrado");    
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
            vistaU.radioBtnExtUsu.setSelected(false);
            vistaU.txtTelefUsu.setText(null);
            vistaU.txtContrasUsu.setText(null);
            vistaU.txtBibliotUsu.setText(null);
            vistaU.txtDireccUsu.setText(null);
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
