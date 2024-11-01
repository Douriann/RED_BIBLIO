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
import modelo.CrudMulta;
import modelo.Ejemplar;
import modelo.Multa;
import modelo.Prestamo;
import modelo.Renovacion;
import modelo.Usuario;
import vista.Vista_emergenteMulta;

// CREANDO LA CLASE Y LLAMANDO LOS ATRIBUTOS NECESARIOS PARA SU FUNCIONAMIENTO
public class CtrlMulta implements ActionListener{
    private Multa modM;
    private CrudMulta modCM;
    private Vista_emergenteMulta vistaMult;
// LLAMANDO AL CONSTRUCTOR EN CONJUNTO A TODOS LOS PARAMETROS PARTICIPANTES EN EL ACTION LISTENER
    public CtrlMulta(Multa modM, CrudMulta modCM, Vista_emergenteMulta vistaMult) {
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
    // METODO QUE PROCEDE AL REALIZAR ACCIONES DEPENDIENDO DEL BOTON
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vistaMult.btnRegistrarMulPrest)
        {   // LLAMA E INSERTA TODOS LOS ATRIBUTOS AL OBJETO PARA REALIZAR EL METODO DE REGISTRO
            // ALGUNOS ARIBUTOS LOS OBTIENE DE LOS TEXTBOX
            Prestamo prestamo = new Prestamo();
            prestamo.setIdPrestamo(Integer.parseInt(vistaMult.txtIdPrestamoPrest.getText()));
            
            Date fechaActualMult = new Date();
            // IMPORTA CLASE Y METODOS DE CALENDAR PARA OBTENER LA FECHA ACTUAL
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fechaActualMult);
            //DEL IMPORTE, SE REALIZA OPERACION PARA ESTIMAR LA SANCION LIMITE
            calendario.add(Calendar.DAY_OF_YEAR, 2);
            Date fechaSalidaMult = calendario.getTime();
            // INSERTANDO DATOS AL OBJETO
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
        {   // LLAMA E INSERTA TODOS LOS ATRIBUTOS AL OBJETO PARA REALIZAR EL METODO DE MODIFICACION
            Prestamo prestamo = new Prestamo();
            prestamo.setIdPrestamo(Integer.parseInt(vistaMult.txtIdPrestamoPrest.getText()));
            // INSERTANDO DATOS AL OBJETO
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
            // SOLICITA EL ATRIBUTO NECESARIO PARA PROCEDER A LA ELIMINACION
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
            // SOLICITA EL ATRIBUTTO NECESARIO PARA PROCEDER A LA BUSQUEDA
            modM.setIdMulta(Integer.parseInt(vistaMult.txtIdMultaPrest.getText()));
            if(modCM.buscarMulta(modM)){
                /*
                SI SE CUMPLE, SE SOLICITAN LOS ATRIBUTOS DEL OBJETO PARA MOSTRARLOS POR PANTALLA
                EN LOS TEXTBOX
                */
                vistaMult.txtIdPrestamoPrest.setText(String.valueOf(modM.getPrestamo().getIdPrestamo()));
            }
            else{
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
                limpiarMult();
            }
        }
        else if(e.getSource() == vistaMult.btnBuscarRegisMult){
            try {
                // METODO PARA LISTAR LOS REGISTROS EN LA TABLA
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
    // METODO PARA LISTAR LOS ARREGLOS DEL OBJETO EN LA TABLA
    public void listarMult(JTable tblMultaPrest) throws ParseException{
        // LLAMA AL SIMPLEDATEFORMAT PARA PARSEAR LOS RESULTADOS OBTENIDOS EN STRING A DATOS DATE
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // LLAMA Y CREA UN METODO PARA TRANSFORMAR EL ARREGLO EN LA TABLA
        DefaultTableModel modelo = (DefaultTableModel)tblMultaPrest.getModel();
        modelo.setRowCount(0);
        // LLAMA Y CREA EL ARREGLO DE LOS OBJETOS
        ArrayList<Multa> listaMult = modCM.listarMulta(modM);
        // SE ASIGNAN LAS COLUMNAS DE LA TABLA
        Object[] objeto = new Object[4];
        // SE REALIZA UN RECORRIDO PARA OBTENER LSO VALORES Y ASIGNARLOS A LA TABLA
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
