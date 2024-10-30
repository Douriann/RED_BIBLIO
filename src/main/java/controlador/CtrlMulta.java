
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.CRUDMulta;
import modelo.Ejemplar;
import modelo.Multa;
import modelo.Prestamo;
import modelo.Renovacion;
import modelo.Usuario;
import vista.Vista_emergenteMulta;


public class CtrlMulta implements ActionListener{
    private Multa modM;
    private CRUDMulta modCM;
    private Vista_emergenteMulta vistaMult;

    public CtrlMulta(Multa modM, CRUDMulta modCM, Vista_emergenteMulta vistaMult) {
        this.modM = modM;
        this.modCM = modCM;
        this.vistaMult = vistaMult;
        this.vistaMult.btnRegistrarMulPrest.addActionListener(this);
        this.vistaMult.btnModificarMultPrest.addActionListener(this);
        this.vistaMult.btnEliminarMulPrest.addActionListener(this);
        this.vistaMult.btnLimpiarMulPrest.addActionListener(this);
        this.vistaMult.btnBuscarIdMulPrest.addActionListener(this);
        this.vistaMult.btnBuscarRegisMult.addActionListener(this);
    }    
    
        public void iniciar(){
        vistaMult.setTitle("Multas");
        vistaMult.setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vistaMult.btnRegistrarMulPrest)
        {
            Prestamo prestamo = new Prestamo();
            prestamo.setIdPrestamo(Integer.parseInt(vistaMult.txtIdPrestamoPrest.getText()));
            
            Date fechaActualMult = new Date();
            
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fechaActualMult);
            calendario.add(Calendar.DAY_OF_YEAR, 2);
            Date fechaSalidaMult = calendario.getTime();
            
            modM.setPrestamo(prestamo);
            modM.setFechaInicio(new java.sql.Date(fechaActualMult.getTime()));
            modM.setFechaFin(new java.sql.Date(fechaSalidaMult.getTime()));
            
            
            if(modCM.registrarMulta(modM)){
                JOptionPane.showMessageDialog(null, "Registro guardado");
                limpiarMult();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiarMult();
            }
        }
        
        else if(e.getSource() == vistaMult.btnModificarMultPrest)
        {
            Prestamo prestamo = new Prestamo();
            prestamo.setIdPrestamo(Integer.parseInt(vistaMult.txtIdPrestamoPrest.getText()));
            
            modM.setIdMulta(Integer.parseInt(vistaMult.txtIdMultaPrest.getText()));
            modM.setPrestamo(prestamo);
        
            if(modCM.modificarMulta(modM)){
                JOptionPane.showMessageDialog(null, "Registro modificado");
                limpiarMult();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiarMult();
            }
        }
        else if(e.getSource() == vistaMult.btnEliminarMulPrest){
            modM.setIdMulta(Integer.parseInt(vistaMult.txtIdMultaPrest.getText()));
            if(modCM.eliminarMulta(modM)){
                JOptionPane.showMessageDialog(null, "Registro eliminado");
                limpiarMult();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiarMult();
            }
        }
        else if(e.getSource() == vistaMult.btnLimpiarMulPrest){
            limpiarMult();
        }
        else if(e.getSource() == vistaMult.btnBuscarIdMulPrest){
            modM.setIdMulta(Integer.parseInt(vistaMult.txtIdMultaPrest.getText()));
            if(modCM.buscarMulta(modM)){
                vistaMult.txtIdPrestamoPrest.setText(String.valueOf(modM.getPrestamo().getIdPrestamo()));
            }
            else{
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
                limpiarMult();
            }
        }
        else if(e.getSource() == vistaMult.btnBuscarRegisMult){
            try {
                listarMult(vistaMult.tblMultaPrest);
            } catch (ParseException ex) {
                Logger.getLogger(CtrlMulta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void limpiarMult(){
        vistaMult.txtIdMultaPrest.setText(null);
        vistaMult.txtIdPrestamoPrest.setText(null);
    }
    
    public void listarMult(JTable tblMultaPrest) throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DefaultTableModel modelo = (DefaultTableModel)tblMultaPrest.getModel();
        modelo.setRowCount(0);
        ArrayList<Multa> listaMult = modCM.listarMulta(modM);
        Object[] objeto = new Object[4];
        for(int i=0; i< listaMult.size();i++){
            objeto[0] = listaMult.get(i).getIdMulta();
            objeto[1] = listaMult.get(i).getPrestamo().getIdPrestamo();
            objeto[2] = dateFormat.format(listaMult.get(i).getFechaInicio());
            objeto[3] = dateFormat.format(listaMult.get(i).getFechaFin());
            modelo.addRow(objeto);
        }
        vistaMult.tblMultaPrest.setModel(modelo);
    }
    
}
