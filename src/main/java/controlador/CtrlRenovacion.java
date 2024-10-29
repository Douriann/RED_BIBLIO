/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.CRUDRenovacion;
import modelo.Prestamo;
import modelo.Renovacion;
import vista.Vista_emergenteRenovacion;


/**
 *
 * @author scocl
 */
public class CtrlRenovacion implements ActionListener{
    private Renovacion modR;
    private CRUDRenovacion modCR;
    private Vista_emergenteRenovacion vistaRen;

    public CtrlRenovacion(Renovacion modR, CRUDRenovacion modCR, Vista_emergenteRenovacion vistaRen) {
        this.modR = modR;
        this.modCR = modCR;
        this.vistaRen = vistaRen;
        vistaRen.btnRegistrarRenPrest.addActionListener(this);
        vistaRen.btnModificarRenPrest.addActionListener(this);
        vistaRen.btnEliminarRenPrest.addActionListener(this);
        vistaRen.btnLimpiarRenPrest.addActionListener(this);
        vistaRen.btnBuscarIdRenPrest.addActionListener(this);
    }
    
    public void iniciar(){
        vistaRen.setTitle("Renovacion");
        vistaRen.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vistaRen.btnRegistrarRenPrest)
        {
            Prestamo prestamo = new Prestamo();
            prestamo.setIdPrestamo(Integer.parseInt(vistaRen.txtIdPrestRenv.getText()));
            
            Date fechaActualRen = new Date();
            
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fechaActualRen);
            calendario.add(Calendar.DAY_OF_YEAR, 2);
            Date fechaVenceRen = calendario.getTime();
            
            modR.setPrestamo(prestamo);
            modR.setFechaSalida(new java.sql.Date(fechaActualRen.getTime()));
            modR.setFechaVence(new java.sql.Date(fechaVenceRen.getTime()));
            modR.setIdEstadoRen(Integer.parseInt(vistaRen.txtIdEstadoRen.getText()));
            
            
            if(modCR.registrarRenovacion(modR)){
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiarRen();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiarRen();
            }
        }
        
        else if(e.getSource() == vistaRen.btnModificarRenPrest)
        {
            Prestamo prestamo = new Prestamo();
            prestamo.setIdPrestamo(Integer.parseInt(vistaRen.txtIdPrestRenv.getText()));
            
            
            modR.setPrestamo(prestamo);
            modR.setIdEstadoRen(Integer.parseInt(vistaRen.txtIdEstadoRen.getText()));
            modR.setIdRenovacion(Integer.parseInt(vistaRen.txtIdRenov.getText()));
        
            if(modCR.modificarRenovacion(modR)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiarRen();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiarRen();
            }
        }
        else if(e.getSource() == vistaRen.btnEliminarRenPrest){
            modR.setIdRenovacion(Integer.parseInt(vistaRen.txtIdRenov.getText()));
            if(modCR.eliminarRenovacion(modR)){
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiarRen();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiarRen();
            }
        }
        else if(e.getSource() == vistaRen.btnLimpiarRenPrest){
            limpiarRen();
        }
        else if(e.getSource() == vistaRen.btnBuscarIdRenPrest){
            modR.setIdRenovacion(Integer.parseInt(vistaRen.txtIdRenov.getText()));
            if(modCR.buscarRenovacion(modR)){
                vistaRen.txtIdPrestRenv.setText(String.valueOf(modR.getPrestamo().getIdPrestamo()));
                vistaRen.txtIdEstadoRen.setText(String.valueOf(modR.getIdEstadoRen()));
            }
            else{
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
                limpiarRen();
            }
        }
    }
    
    public void limpiarRen(){
        vistaRen.txtIdRenov.setText(null);
        vistaRen.txtIdPrestRenv.setText(null);
        vistaRen.txtIdEstadoRen.setText(null);
    }
    
    
    
}
