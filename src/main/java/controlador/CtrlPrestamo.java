
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Prestamo;
import modelo.CRUDPrestamo;
import modelo.Usuario;
import modelo.Ejemplar;
import vista.Vista_gestionPrestamo;
import java.util.Date; 
import java.util.Calendar;


public class CtrlPrestamo implements ActionListener{
    private Prestamo modP;
    private CRUDPrestamo modCP;
    private Vista_gestionPrestamo vistaPres;
    
    public CtrlPrestamo(Prestamo modP, CRUDPrestamo modCP, Vista_gestionPrestamo vistaPres){
        this.modP = modP;
        this.modCP = modCP;
        this.vistaPres = vistaPres;
        
        this.vistaPres.btnRegistrarPrest.addActionListener(this);
        this.vistaPres.btnModificarPrest.addActionListener(this);
        this.vistaPres.btnEliminarPrest.addActionListener(this);
        this.vistaPres.btnLimpiarPrest.addActionListener(this);
        this.vistaPres.btnBuscarIdPrest.addActionListener(this);
    }
    
    public void iniciar(){
        vistaPres.setTitle("Prestamo");
        vistaPres.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vistaPres.btnRegistrarPrest)
        {
            Usuario usuario = new Usuario();
            usuario.setCedula(Integer.parseInt(vistaPres.txtCedulaPrest.getText()));
            
            Ejemplar ejemplar = new Ejemplar();
            ejemplar.setIdEjemplar(Integer.parseInt(vistaPres.txtIdEjemplarPrest.getText()));
            
            Date fechaActual = new Date();
            
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fechaActual);
            calendario.add(Calendar.DAY_OF_YEAR, 2);
            Date fechaSalida = calendario.getTime();
            
            modP.setUsuario(usuario);
            modP.setEjemplar(ejemplar);
            modP.setFechaSalida(new java.sql.Date(fechaActual.getTime()));
            modP.setFechaVence(new java.sql.Date(fechaSalida.getTime()));
            modP.setFechaEntrego(new java.sql.Date(fechaSalida.getTime()));
            modP.setIdEstadoPre(Integer.parseInt(vistaPres.txtIdEjemplarPrest.getText()));
            
            if(modCP.registrarPrestamo(modP)){
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiarPre();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiarPre();
            }
        }
        
        else if(e.getSource() == vistaPres.btnModificarPrest)
        {
            Usuario usuario = new Usuario();
            usuario.setCedula(Integer.parseInt(vistaPres.txtCedulaPrest.getText()));
            
            Ejemplar ejemplar = new Ejemplar();
            ejemplar.setIdEjemplar(Integer.parseInt(vistaPres.txtIdEjemplarPrest.getText()));
            
            modP.setIdPrestamo(Integer.parseInt(vistaPres.txtIdPrest.getText()));
            modP.setUsuario(usuario);
            modP.setEjemplar(ejemplar);
            modP.setIdEstadoPre(Integer.parseInt(vistaPres.txtIdEjemplarPrest.getText()));
            
            if(modCP.modificarPrestamo(modP)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiarPre();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiarPre();
            }
        }
        else if(e.getSource() == vistaPres.btnEliminarPrest){
            modP.setIdPrestamo(Integer.parseInt(vistaPres.txtIdPrest.getText()));
            if(modCP.eliminarPrestamo(modP)){
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiarPre();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiarPre();
            }
        }
        else if(e.getSource() == vistaPres.btnLimpiarPrest){
            limpiarPre();
        }
        else if(e.getSource() == vistaPres.btnBuscarIdPrest){
            modP.setIdPrestamo(Integer.parseInt(vistaPres.txtIdPrest.getText()));
            if(modCP.buscarPrestamo(modP)){
                vistaPres.txtCedulaPrest.setText(String.valueOf(modP.getUsuario().getCedula()));
                vistaPres.txtIdEjemplarPrest.setText(String.valueOf(modP.getEjemplar().getIdEjemplar()));
                vistaPres.txtEstadoPrest.setText(String.valueOf(modP.getIdEstadoPre()));
            }
            else{
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
                limpiarPre();
            }
        }
    }
    
    public void limpiarPre(){
        vistaPres.txtIdPrest.setText(null);
        vistaPres.txtCedulaPrest.setText(null);
        vistaPres.txtIdEjemplarPrest.setText(null);
        vistaPres.txtFchEntregaPrest.setText(null);
        vistaPres.txtEstadoPrest.setText(null);
    }
}
