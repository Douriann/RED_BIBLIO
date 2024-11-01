/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.CrudRenovacion;
import modelo.Prestamo;
import modelo.Renovacion;
import vista.Vista_emergenteRenovacion;


/**
 *
 * @author scocl
 */
public class CtrlRenovacion implements ActionListener{
    private Renovacion modR;
    private CrudRenovacion modCR;
    private Vista_emergenteRenovacion vistaRen;

    public CtrlRenovacion(Renovacion modR, CrudRenovacion modCR, Vista_emergenteRenovacion vistaRen) {
        this.modR = modR;
        this.modCR = modCR;
        this.vistaRen = vistaRen;
        vistaRen.btnRegistrarRenPrest.addActionListener(this);
        vistaRen.btnModificarRenPrest.addActionListener(this);
        vistaRen.btnEliminarRenPrest.addActionListener(this);
        vistaRen.btnLimpiarRenPrest.addActionListener(this);
        vistaRen.btnBuscarIdRenPrest.addActionListener(this);
        vistaRen.btnBuscarIdPrest.addActionListener(this);
        //DefaultTableModel modelo = new DefaultTableModel();
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
        else if(e.getSource() == vistaRen.btnBuscarIdPrest){
            try {
                listarRen(vistaRen.tblRenovPrest);
            } catch (ParseException ex) {
                Logger.getLogger(CtrlRenovacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void limpiarRen(){
        vistaRen.txtIdRenov.setText(null);
        vistaRen.txtIdPrestRenv.setText(null);
        vistaRen.txtIdEstadoRen.setText(null);
    }
    
    public void listarRen(JTable tblRenovPrest) throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DefaultTableModel modelo = (DefaultTableModel)tblRenovPrest.getModel();
        modelo.setRowCount(0);
        ArrayList<Renovacion> listaRen = modCR.listarRenovacion(modR);
        Object[] objeto = new Object[6];
        for(int i=0; i< listaRen.size();i++){
            objeto[0] = listaRen.get(i).getIdRenovacion();
            objeto[1] = listaRen.get(i).getPrestamo().getIdPrestamo();
            objeto[2] = dateFormat.format(listaRen.get(i).getFechaSalida());
            objeto[3] = dateFormat.format(listaRen.get(i).getFechaVence());
            objeto[4] = listaRen.get(i).getIdEstadoRen();
            objeto[5] = listaRen.get(i).getNomEstRen();
            modelo.addRow(objeto);
        }
        vistaRen.tblRenovPrest.setModel(modelo);
    }
    
}
