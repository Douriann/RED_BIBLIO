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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Prestamo;
import modelo.CrudPrestamo;
import modelo.Usuario;
import modelo.Ejemplar;
import vista.Vista_gestionPrestamo;
import java.util.Date; 
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Renovacion;

// CREANDO LA CLASE Y LLAMANDO LOS ATRIBUTOS NECESARIOS PARA SU FUNCIONAMIENTO
public class CtrlPrestamo implements ActionListener{
    private Prestamo modP;
    private CrudPrestamo modCP;
    private Vista_gestionPrestamo vistaPres;
    // LLAMANDO AL CONSTRUCTOR EN CONJUNTO A TODOS LOS PARAMETROS PARTICIPANTES EN EL ACTION LISTENER
    public CtrlPrestamo(Prestamo modP, CrudPrestamo modCP, Vista_gestionPrestamo vistaPres){
        this.modP = modP;
        this.modCP = modCP;
        this.vistaPres = vistaPres;
        
        this.vistaPres.btnRegistrarPrest.addActionListener(this);
        this.vistaPres.btnModificarPrest.addActionListener(this);
        this.vistaPres.btnEliminarPrest.addActionListener(this);
        this.vistaPres.btnLimpiarPrest.addActionListener(this);
        this.vistaPres.btnBuscarIdPrest.addActionListener(this);
        this.vistaPres.btnBuscarRegisPrest.addActionListener(this);
    }
    
    public void iniciar(){
        vistaPres.setTitle("Prestamo");
        vistaPres.setLocationRelativeTo(null);
    }
   // METODO QUE PROCEDE A REALIZAR ACCIONES DEPENDIENDO DEL BOTON 
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == vistaPres.btnRegistrarPrest)
        {   // VERIFICA Y REVISA SI HAY EJEMPLARES DISPONIBLES EN LA BIBLIOTECA
            int cant = buscarEjemplar();
            if(cant > 0){
                try {
                    // LLAMA E INSERTA TODOS LOS ATRIBUTOS AL OBJETO PARA REALIZAR EL METODO DE REGISTRO
                    // ALGUNOS ATRIBUTOS LOS OBTIENE DE LOS TEXTBOX
                    Usuario usuario = new Usuario();
                    usuario.setCedula(Integer.parseInt(vistaPres.txtCedulaPrest.getText()));
                    
                    Ejemplar ejemplar = new Ejemplar();
                    ejemplar.setIdEjemplar(Integer.parseInt(vistaPres.txtIdEjemplarPrest.getText()));
                    
                    Date fechaActual = new Date();
                    // IMPORTA CLASE Y METODO DE CALENDAR PARA OBTENER LA FECHA ACTUAL
                    Calendar calendario = Calendar.getInstance();
                    calendario.setTime(fechaActual);
                    // DEL IMPORTA, SE REALIZA OPERACION PARA OBTENER LA FECHA LIMITE DE ENTREGA EN EL PRESTAMO
                    calendario.add(Calendar.DAY_OF_YEAR, 2);
                    Date fechaSalida = calendario.getTime();
                    // INSERTANDO DATOS AL OBJETO
                    modP.setUsuario(usuario);
                    modP.setEjemplar(ejemplar);
                    modP.setFechaSalida(new java.sql.Date(fechaActual.getTime()));
                    modP.setFechaVence(new java.sql.Date(fechaSalida.getTime()));
                    modP.setFechaEntrego(new java.sql.Date(fechaSalida.getTime()));
                    modP.setIdEstadoPre(Integer.parseInt(vistaPres.txtIdEjemplarPrest.getText()));
                    
                    if(modCP.registrarPrestamo(modP) && modCP.actualizarEjemplarPres(modP)){
                        JOptionPane.showMessageDialog(null, "Registro guardado");
                        limpiarPre();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Error al guardar");
                        limpiarPre();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlPrestamo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "No hay ejemplares");
                limpiarPre();
            }

        }
        
        else if(e.getSource() == vistaPres.btnModificarPrest)
        {  // LLAMA E INSERTA TODOS LOS ATRIBUTOS AL OBJETO PARA REALIZAR EL METODO DE MODIFICACION
            Usuario usuario = new Usuario();
            usuario.setCedula(Integer.parseInt(vistaPres.txtCedulaPrest.getText()));
            
            Ejemplar ejemplar = new Ejemplar();
            ejemplar.setIdEjemplar(Integer.parseInt(vistaPres.txtIdEjemplarPrest.getText()));
            // INSERTANDO DATOS AL OBJETO
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
            // SOLICITA EL ATRIBUTO NECESARIO PARA PROCEDER A LA ELIMINACION
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
            // SOLICITA EL ATRIBUTO NECESARIO PARA PROCEDER A LA BUSQUEDA
            modP.setIdPrestamo(Integer.parseInt(vistaPres.txtIdPrest.getText()));
            /*
            SI SE CUMPLE, SE SOLICITAN LOS ATRIBUTOS DEL OBJETO PARA MOSTRARLOS POR PANTALLA
            EN LOS TEXTBOX
            */
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
        else if(e.getSource() == vistaPres.btnBuscarRegisPrest){
            // METODO PARA LISTAR LOS REGISTRO EN LA TABLA
            try {
                listarRen(vistaPres.tblPrestamoPrest);
            } catch (ParseException ex) {
                Logger.getLogger(CtrlPrestamo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // METODO PARA LIMPIAR LOS TEXTBOX
    public void limpiarPre(){
        vistaPres.txtIdPrest.setText(null);
        vistaPres.txtCedulaPrest.setText(null);
        vistaPres.txtIdEjemplarPrest.setText(null);
        vistaPres.txtEstadoPrest.setText(null);
    }
    // METODO QUE BUSCA EL VALOR DEL EJEMPLAR SOLICITADO PARA EL PRESTAMO
    public int buscarEjemplar(){
        // SOLICITA LOS ATRIBUTOS NECESARIOS DE LOS TEXTBOX PARA PROCEDER A LA CONSULTA
        Usuario usuario = new Usuario();
        usuario.setCedula(Integer.parseInt(vistaPres.txtCedulaPrest.getText()));
        Ejemplar ejemplar = new Ejemplar();
        ejemplar.setIdEjemplar(Integer.parseInt(vistaPres.txtIdEjemplarPrest.getText()));
        modP.setUsuario(usuario);
        modP.setEjemplar(ejemplar);
        int cantidad = modCP.buscarEjemplar(modP);
        //JOptionPane.showMessageDialog(null, "Cantidad de ejemplares: " + cantidad);
        return cantidad;
    }
    // METODO PARA LISTAR LOS ARREGLOS DEL OBJETO EN LA TABLA
    public void listarRen(JTable tblPrestamoPrest) throws ParseException{
        // LLAMA AL SIMPLEDATEFORMAT PARA PARSEAR LOS RESULTADOS OBTENIDOS EN STRING A DATOS DATE
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // LLAMA Y CREA UN METODO PARA TRANSFORMAR EL ARREGLO EN TABLA
        DefaultTableModel modelo = (DefaultTableModel)tblPrestamoPrest.getModel();
        modelo.setRowCount(0);
        // LLAMA Y CREA EL ARREGLO DE LOS OBJETOS
        ArrayList<Prestamo> listaPres = modCP.listarPrestamo(modP);
        // SE ASIGNAN LAS COLUMNAS DE LA TABLA
        Object[] objeto = new Object[8];
        // SE REALIZA UN RECORRIDO PARA OBTENER LOS VALORES Y ASIGNARLOS A LA TABLA
        for(int i=0; i< listaPres.size();i++){
            objeto[0] = listaPres.get(i).getIdPrestamo();
            objeto[1] = listaPres.get(i).getUsuario().getCedula();
            objeto[2] = listaPres.get(i).getEjemplar().getIdEjemplar();
            objeto[3] = dateFormat.format(listaPres.get(i).getFechaSalida());
            objeto[4] = dateFormat.format(listaPres.get(i).getFechaVence());
            objeto[5] = dateFormat.format(listaPres.get(i).getFechaEntrego());
            objeto[6] = listaPres.get(i).getIdEstadoPre();
            objeto[7] = listaPres.get(i).getNomEstadoPre();
            modelo.addRow(objeto);
        }
        vistaPres.tblPrestamoPrest.setModel(modelo);
    }
}
