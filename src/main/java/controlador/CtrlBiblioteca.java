/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package controlador;

import modelo.CrudBiblioteca;
import modelo.Biblioteca;
import vista.Vista_gestionBiblioteca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CtrlBiblioteca implements ActionListener{
    //Instrucciones para que podamos detectar click en los botones y
    //Enviar los valores de la caja de texto y que se pueda insertar a la base de datos
    
    // DECLARAR VARIABLES
    private final Biblioteca mod;
    private final CrudBiblioteca modCrud;
    private final Vista_gestionBiblioteca vis;
    
    // CONSTRUCTOR. RECIBE OBJETOS DE MODELO Y VISTA
    public CtrlBiblioteca(Biblioteca mod, CrudBiblioteca modCrud, Vista_gestionBiblioteca vis)
    {
        //IGUALAR ATRIBUTOS CON OBJETOS QUE ESTAMOS RECIBIENDO
        this.mod = mod;
        this.modCrud = modCrud;
        this.vis = vis;
        
        // AGREGAR METODOS ESCUCHADORES DE EVENTOS A LOS BOTONES
        this.vis.btnRegistrarBiblio.addActionListener(this);
        this.vis.btnModificarBiblio.addActionListener(this);
        this.vis.btnEliminarBiblio.addActionListener(this);
        this.vis.btnBuscarBiblio.addActionListener(this);
        this.vis.btnLimpiarBiblio.addActionListener(this);
        this.vis.btnBuscarRegisBiblio.addActionListener(this);
        
    }
    
    //METODO QUE INICIA VENTANA
    public void iniciar()
    {
        vis.setTitle("Biblioteca");
        vis.setLocationRelativeTo(null);
        vis.txtIdBiblioBiblio.setVisible(true); //ojo
    }
    
    //METODO PARA SABER QUE BOTON SE PULSO Y HACER DETERMINADA ACCION
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource() == vis.btnRegistrarBiblio) //HICIERON CLICK AL BOTON REGISTRAR
        {
            //TOMAR VALORES DE LAS CAJAS DE TEXTO, METERLOS AL MODELO, LLAMAR AL METODO DE REGISTRAR E INSERTAR DATOS A BASE
            
            //PASAR VALORES RECIBIDOS EN CAJAS DE TEXTO A ATRIBUTOS DE LA CLASE BIBLIOTECA
            mod.setNomBiblioteca(vis.txtNombreBiblio.getText());
            mod.setDireccion((vis.txtDireccBiblio.getText()));
            
            if(modCrud.registrarBiblioteca(mod)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            } 
        } 
        
        if(e.getSource() == vis.btnModificarBiblio) //HICIERON CLICK AL BOTON MODIFICAR
        {
            mod.setIdBiblioteca(Integer.parseInt(vis.txtIdBiblioBiblio.getText()));
            mod.setNomBiblioteca(vis.txtNombreBiblio.getText());
            mod.setDireccion((vis.txtDireccBiblio.getText()));
            
            if(modCrud.modificarBiblioteca(mod)) //EL METODO MODIFICAR RETORNA TRUE, POR LO TANTO SE MODIFICO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            } 
        }
        
        if(e.getSource() == vis.btnEliminarBiblio) //HICIERON CLICK AL BOTON ELIMINAR
        {
            //TOMAR id DE LA CAJA DE TEXTO
            
            //PASAR VALORES RECIBIDOS EN CAJAS DE TEXTO A ATRIBUTOS DE LA CLASE BIBLIOTECA
            mod.setIdBiblioteca(Integer.parseInt(vis.txtIdBiblioBiblio.getText()));

            if(modCrud.eliminarBiblioteca(mod)) //EL METODO ELIMINAR RETORNA TRUE, POR LO TANTO SE ELIMINO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            } 
        } 
        
        if(e.getSource() == vis.btnBuscarBiblio) //HICIERON CLICK AL BOTON BUSCAR
        {
            //TOMAR id DE LA CAJA DE TEXTO
            
            //PASAR VALORES RECIBIDOS EN CAJAS DE TEXTO A ATRIBUTOS DE LA CLASE BIBLIOTECA
            mod.setIdBiblioteca(Integer.parseInt(vis.txtIdBiblioBiblio.getText()));

            if(modCrud.buscarBiblioteca(mod)) //EL METODO BUSCAR RETORNA TRUE, POR LO TANTO SE ENCONTRO UN REGISTRO
            {           
            vis.txtNombreBiblio.setText(mod.getNomBiblioteca()); 
            vis.txtDireccBiblio.setText(mod.getDireccion());
            } 
            else {
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
                limpiar();
            } 
    }
        
        if(e.getSource() == vis.btnLimpiarBiblio)
            {
                limpiar();
            }
        // AL ACCIONAR BOTON, SE LISTAN LOS REGISTROS A LA TABLA
        if(e.getSource() == vis.btnBuscarRegisBiblio){
            try {
                listarBiblio(vis.tblBibliotecaBiblio);
            } catch (ParseException ex) {
                Logger.getLogger(CtrlBiblioteca.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
        // METODO PARA LISTAR LOS ARREGLOS DEL OBJETO EN LA TABLA
        public void listarBiblio(JTable tblBibliotecaBiblio) throws ParseException{
            // LLAMA Y CREA UN METODO PARA TRANSFORMAR EL ARREGLO EN LA TABLA
        DefaultTableModel modelo = (DefaultTableModel)tblBibliotecaBiblio.getModel();
        modelo.setRowCount(0);
            // LLAMA Y CREA EL ARREGLO DE LOS OBJETOS
        ArrayList<Biblioteca> listaBiblio = modCrud.listarBiblioteca(mod);
        // SE ASIGNAN LAS COLUMNAS DE LA TABLA
        Object[] objeto = new Object[3];
        // SE REALIZA UN RECORRIDO PARA OBTENER LOS VALORES Y ASIGNARLOS A LA TABLA
        for(int i=0; i< listaBiblio.size();i++){
            objeto[0] = listaBiblio.get(i).getIdBiblioteca();
            objeto[1] = listaBiblio.get(i).getNomBiblioteca();
            objeto[2] = listaBiblio.get(i).getDireccion();
            modelo.addRow(objeto);
        }
        vis.tblBibliotecaBiblio.setModel(modelo);
    }
    
    //METODO PARA limpiar ventana
    public void limpiar()
        {
            vis.txtIdBiblioBiblio.setText(null);
            vis.txtNombreBiblio.setText(null);
            vis.txtDireccBiblio.setText(null);
        }
}