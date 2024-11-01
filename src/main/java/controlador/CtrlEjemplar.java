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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Biblioteca;
import modelo.CrudEjemplar;
import modelo.Ejemplar;
import vista.Vista_gestionEjemplar;


public class CtrlEjemplar implements ActionListener{
    //Instrucciones para que podamos detectar click en los botones y
    //Enviar los valores de la caja de texto y que se pueda insertar a la base de datos
    
    // DECLARAR VARIABLES. Faltaba la palabra clave final en la declaracion de atributos
    private final Ejemplar modE;
    private final CrudEjemplar modCrudE;
    private final Vista_gestionEjemplar visE;
    
    // CONSTRUCTOR. RECIBE OBJETOS DE MODELO Y VISTA
    public CtrlEjemplar(Ejemplar modE, CrudEjemplar modCrudE, Vista_gestionEjemplar visE)
    {
        //IGUALAR ATRIBUTOS CON OBJETOS QUE ESTAMOS RECIBIENDO
        this.modE = modE;
        this.modCrudE = modCrudE;
        this.visE = visE;
        
        // AGREGAR METODOS ESCUCHADORES DE EVENTOS A LOS BOTONES
        this.visE.btnRegistrarEjem.addActionListener(this);
        this.visE.btnModificarEjem.addActionListener(this);
        this.visE.btnEliminarEjem.addActionListener(this);
        this.visE.btnBuscarEjem.addActionListener(this);
        this.visE.btnLimpiarEjem.addActionListener(this);
        this.visE.btnBuscarRegisEjem.addActionListener(this);
        
    }
    
    //METODO QUE INICIA VENTANA
    public void iniciar()
    {
        visE.setTitle("Ejemplar");
        visE.setLocationRelativeTo(null);
        visE.txtIdEjemplarEjem.setVisible(true); //ojo
    }
    
    //METODO PARA SABER QUE BOTON SE PULSO Y HACER DETERMINADA ACCION
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource() == visE.btnRegistrarEjem) //HICIERON CLICK AL BOTON REGISTRAR
        {
            //TOMAR VALORES DE LAS CAJAS DE TEXTO, METERLOS AL MODELO, LLAMAR AL METODO DE REGISTRAR E INSERTAR DATOS A BASE
            
            //PASAR VALORES RECIBIDOS EN CAJAS DE TEXTO A ATRIBUTOS DE LA CLASE BIBLIOTECA
            //mod.setIdBiblioteca(Integer.parseInt(vis.txtIdBiblioBiblio.getText())); EL ID NO ES NECESARIO. NO SE INGRESA EN FORMULARIO
            modE.setIdEstadoEj(Integer.parseInt(visE.txtEstadoEjem.getText()));
            modE.setIdLibro(Integer.parseInt(visE.txtIdLibroEjem.getText()));
            modE.setUbicacion((visE.txtUbicacionEjem.getText()));
            
            if(modCrudE.registrarEjemplar(modE)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            } 
        } 
        
        if(e.getSource() == visE.btnModificarEjem) //HICIERON CLICK AL BOTON MODIFICAR
        {
            modE.setIdEjemplar(Integer.parseInt(visE.txtIdEjemplarEjem.getText()));
            modE.setIdEstadoEj(Integer.parseInt(visE.txtEstadoEjem.getText()));
            modE.setIdLibro(Integer.parseInt(visE.txtIdLibroEjem.getText()));
            modE.setUbicacion((visE.txtUbicacionEjem.getText()));
            
            if(modCrudE.modificarEjemplar(modE)) //EL METODO MODIFICAR RETORNA TRUE, POR LO TANTO SE MODIFICO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            } 
        }
        
        if(e.getSource() == visE.btnEliminarEjem) //HICIERON CLICK AL BOTON ELIMINAR
        {
            //TOMAR id DE LA CAJA DE TEXTO
            
            //PASAR VALORES RECIBIDOS EN CAJAS DE TEXTO A ATRIBUTOS DE LA CLASE BIBLIOTECA
            modE.setIdEjemplar(Integer.parseInt(visE.txtIdEjemplarEjem.getText()));
            
            if(modCrudE.eliminarEjemplar(modE)) //EL METODO ELIMINAR RETORNA TRUE, POR LO TANTO SE ELIMINO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            } 
        } 
        
        if(e.getSource() == visE.btnBuscarEjem) //HICIERON CLICK AL BOTON BUSCAR
        {
            //TOMAR id DE LA CAJA DE TEXTO
            
            //PASAR VALORES RECIBIDOS EN CAJAS DE TEXTO A ATRIBUTOS DE LA CLASE 
            modE.setIdEjemplar(Integer.parseInt(visE.txtIdEjemplarEjem.getText()));

            if(modCrudE.buscarEjemplar(modE)) //EL METODO BUSCAR RETORNA TRUE, POR LO TANTO SE ENCONTRO UN REGISTRO
            {
           
            
            //Se debe hacer esto.
            //A las cajas de texto  se le pasa los valores que tienen
            //los atributos mediante el metodo get.
            
            visE.txtEstadoEjem.setText(String.valueOf(modE.getIdEstadoEj()));
            visE.txtIdLibroEjem.setText(String.valueOf(modE.getIdLibro()));
            visE.txtUbicacionEjem.setText(modE.getUbicacion());
            } 
            else {
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
                limpiar();
            } 
    }
        
        if(e.getSource() == visE.btnLimpiarEjem)
            {
                limpiar();
            }
        // al accionar boton, se listan los registros a la tabla
        if(e.getSource()== visE.btnBuscarRegisEjem){
            try {
                listarEjemp(visE.tblEjemplarEjem);
            } catch (ParseException ex) {
                Logger.getLogger(CtrlEjemplar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    // METODO PARA LISTAR LOS ARREGLOS DEL OBJETO EN LA TABLA
    public void listarEjemp(JTable tblEjemplarEjem) throws ParseException{
        DefaultTableModel modelo = (DefaultTableModel)tblEjemplarEjem.getModel();
        // LLAMA Y CREA UN METODO PARA TRANSFORMAR EL ARREGLO EN LA TABLA
        modelo.setRowCount(0);
        // LLAMA Y CREA EL ARREGLO DE LOS OBJETOS
        ArrayList<Ejemplar> listaEjemplar = modCrudE.listarEjemplar(modE);
        // SE ASIGNAN LAS COLUMNAS DE LA TABLA
        Object[] objeto = new Object[4];
        // SE REALIZA UN RECORRIDO PARA OBTENER LOS VALORES Y ASIGNARLOS A LA TABLA
        for(int i=0; i< listaEjemplar.size();i++){
            objeto[0] = listaEjemplar.get(i).getIdEjemplar();
            objeto[1] = listaEjemplar.get(i).getIdLibro();
            objeto[2] = listaEjemplar.get(i).getIdEstadoEj();
            objeto[3] = listaEjemplar.get(i).getUbicacion();
            modelo.addRow(objeto);
        }
        visE.tblEjemplarEjem.setModel(modelo);
    }
    
    //METODO PARA limpiar ventana
    public void limpiar()
        {
            visE.txtIdEjemplarEjem.setText(null);
            visE.txtIdLibroEjem.setText(null);
            visE.txtEstadoEjem.setText(null);
            visE.txtUbicacionEjem.setText(null);
        }
    
}
