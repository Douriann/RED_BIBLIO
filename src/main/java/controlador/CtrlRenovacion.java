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
// CREANDO LA CLASE Y LLAMANDO LOS ATRIBUTOS NECESARIOS PARA SU FUNCIONAMIENTO
public class CtrlRenovacion implements ActionListener{
    private Renovacion modR;
    private CrudRenovacion modCR;
    private Vista_emergenteRenovacion vistaRen;
// LLAMANDO AL CONSTRUCTOR EN CONJUNTO A TODOS LOS PARAMETROS PARTICIPANTES EN EL ACTION LISTENER
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
    }
    
    public void iniciar(){
        vistaRen.setTitle("Renovacion");
        vistaRen.setLocationRelativeTo(null);
    }
// METODO QUE PROCEDE A REALIZAR ACCIONES DEPENDIENDO DEL BOTON    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vistaRen.btnRegistrarRenPrest)
        {
            // LLAMA E INSERTA TODOS LOS ATRIBUTOS AL OBJETO PARA REALIZAR EL METODO DE REGISTRO
            // ALGUNOS ATRIBUTOS LOS OBTIENE DE LOS TEXTBOX
            Prestamo prestamo = new Prestamo();
            prestamo.setIdPrestamo(Integer.parseInt(vistaRen.txtIdPrestRenv.getText()));
            
            Date fechaActualRen = new Date();
            // IMPORTA CLASE Y METODOS DE CALENDAR PARA OBTENER LA FECHA ACTUAL
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fechaActualRen);
            // DEL IMPORTE, SE REALIZA OPERACION PARA OBTENER LA FECHA LIMITE DE ENTREGA EN EL PRESTAMO
            calendario.add(Calendar.DAY_OF_YEAR, 2);
            Date fechaVenceRen = calendario.getTime();
            // INSERTANDO DATOS AL OBJETO
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
            // LLAMA E INSERTA TODOS LOS ATRIBUTOS AL OBJETO PARA REALIZAR EL METODO DE MODIFICACION
            Prestamo prestamo = new Prestamo();
            prestamo.setIdPrestamo(Integer.parseInt(vistaRen.txtIdPrestRenv.getText()));
            // INSERTANDO DATOS AL OBJETO
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
            // SOLICITA EL ATRIBUTO NECESARIO PARA PROCEDER A LA ELIMINACION
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
            // SOLICITA EL ATRIBUTO NECESARIO PARA PROCEDER A LA BUSQUEDA
            modR.setIdRenovacion(Integer.parseInt(vistaRen.txtIdRenov.getText()));
            /*
            SI SE CUMPLE, SE SOLICITAN LOS ATRIBUTOS DEL OBJETO PARA MOSTRARLOS POR PANTALLA
            EN LOS TEXTBOX
            */
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
            // METODO PARA LISTAR LOS REGISTROS EN LA TABLA
            try {
                listarRen(vistaRen.tblRenovPrest);
            } catch (ParseException ex) {
                Logger.getLogger(CtrlRenovacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /*
        METODO PARA LIMPIAR TEXTBOX
    */
    public void limpiarRen(){
        vistaRen.txtIdRenov.setText(null);
        vistaRen.txtIdPrestRenv.setText(null);
        vistaRen.txtIdEstadoRen.setText(null);
    }
        // METODO PARA LISTAR LOS ARREGLOS DEL OBJETO EN LA TABLA
    public void listarRen(JTable tblRenovPrest) throws ParseException{
        // LLAMA AL SIMPLEDATEFORMAT PARA PARSEAR LOS RESULTADOS OBTENIDOS EN STRING A DATOS DATE
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // LLAMA Y CREA UN METODO PARA TRANSFORMAR EL ARREGLO EN TABLA
        DefaultTableModel modelo = (DefaultTableModel)tblRenovPrest.getModel();
        modelo.setRowCount(0);
        // LLAMA Y CREA EL ARREGLO DE LOS OBJETOS
        ArrayList<Renovacion> listaRen = modCR.listarRenovacion(modR);
        // SE ASIGNAN LAS COLUMNAS DE LA TABLA
        Object[] objeto = new Object[6];
        // SE REALIZA UN RECORRIDO PARA OBTENER LOS VALORES Y ASIGNARLOS A LA TABLA
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
