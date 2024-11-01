
package controlador;

import modelo.CrudLibro;
import modelo.Libro;
import vista.Vista_gestionLibros;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlLibro implements ActionListener{
    
    // DECLARAR VARIABLES. se debe colocar la palabra clave final en la declaracion de atributos
    private final Libro modL;
    private final CrudLibro modCrudL;
    private final Vista_gestionLibros visL;
    
    public CtrlLibro(Libro modL, CrudLibro modCrudL, Vista_gestionLibros visL)
    {
        //IGUALAR ATRIBUTOS CON OBJETOS QUE ESTAMOS RECIBIENDO
        this.modL = modL;
        this.modCrudL = modCrudL;
        this.visL = visL;
        
        // AGREGAR METODOS ESCUCHADORES DE EVENTOS A LOS BOTONES
        this.visL.btnRegistrarLib.addActionListener(this);
        this.visL.btnModificarLib.addActionListener(this);
        this.visL.btnEliminarLib.addActionListener(this);
        this.visL.btnBuscarLib.addActionListener(this);
        this.visL.btnLimpiarLib.addActionListener(this);
        
    }  
    
    //METODO QUE INICIA VENTANA
    public void iniciar()
    {
        visL.setTitle("Libro");
        visL.setLocationRelativeTo(null);
        visL.txtIdLibroLib.setVisible(true); //ojo true
    }
    
    //METODO PARA SABER QUE BOTON SE PULSO Y HACER DETERMINADA ACCION
    @Override
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource() == visL.btnRegistrarLib) //HICIERON CLICK AL BOTON REGISTRAR
        {
            //TOMAR VALORES DE LAS CAJAS DE TEXTO, METERLOS AL MODELO, LLAMAR AL METODO DE REGISTRAR E INSERTAR DATOS A BASE
            
            //PASAR VALORES RECIBIDOS EN CAJAS DE TEXTO A ATRIBUTOS DE LA CLASE BIBLIOTECA
            //modL.setIdBiblioteca(Integer.parseInt(vis.txtIdBiblioBiblio.getText())); EL ID NO ES NECESARIO CAMBIARON A AUTOINCREMENTABLE. NO SE INGRESA EN FORMULARIO
            modL.setTitulo(visL.txtTituloLib.getText());
            modL.setAutor((visL.txtAutorLib.getText()));
            modL.setAño(Integer.parseInt(visL.txtAnnoLib.getText()));
            modL.setIdCategoria(Integer.parseInt(visL.txtCategLibros.getText()));
                       
            
            if(modCrudL.registrarLibro(modL)) //EL METODO REGISTRAR RETORNA TRUE, POR LO TANTO INSERTO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            } 
        } 
        
        if(e.getSource() == visL.btnModificarLib) //HICIERON CLICK AL BOTON MODIFICAR
        {
            modL.setIdLibro(Integer.parseInt(visL.txtIdLibroLib.getText()));
            modL.setTitulo(visL.txtTituloLib.getText());
            modL.setAutor((visL.txtAutorLib.getText()));
            modL.setAño(Integer.parseInt(visL.txtAnnoLib.getText()));
            modL.setIdCategoria(Integer.parseInt(visL.txtCategLibros.getText()));
            
            if(modCrudL.modificarLibro(modL)) //EL METODO MODIFICAR RETORNA TRUE, POR LO TANTO SE MODIFICO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            } 
        }
        
        if(e.getSource() == visL.btnEliminarLib) //HICIERON CLICK AL BOTON ELIMINAR
        {
            //TOMAR id DE LA CAJA DE TEXTO
            
            //PASAR VALORES RECIBIDOS EN CAJAS DE TEXTO A ATRIBUTOS DE LA CLASE BIBLIOTECA
            modL.setIdLibro(Integer.parseInt(visL.txtIdLibroLib.getText()));

            if(modCrudL.eliminarLibro(modL)) //EL METODO ELIMINAR RETORNA TRUE, POR LO TANTO SE ELIMINO EL REGISTRO
            {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            } 
        } 
        
        if(e.getSource() == visL.btnBuscarLib) //HICIERON CLICK AL BOTON BUSCAR
        {
            //TOMAR id DE LA CAJA DE TEXTO
            
            //PASAR VALORES RECIBIDOS EN CAJAS DE TEXTO A ATRIBUTOS DE LA CLASE BIBLIOTECA
            modL.setIdLibro(Integer.parseInt(visL.txtIdLibroLib.getText()));

            if(modCrudL.buscarLibro(modL)) //EL METODO BUSCAR RETORNA TRUE, POR LO TANTO SE ENCONTRO UN REGISTRO
            {
               
            //Se debe hacer esto.
            //A las cajas de texto de nombre biblioteca y direccion biblioteca se le pasa los valores que tienen
            //los atributos mediante el metodo get.
            
            visL.txtTituloLib.setText(modL.getTitulo()); 
            visL.txtAutorLib.setText(modL.getAutor());
            visL.txtAnnoLib.setText(String.valueOf(modL.getAño()));
            visL.txtCategLibros.setText(String.valueOf(modL.getIdCategoria()));
            } 
            else {
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
                limpiar();
            } 
        }
        
        // BUSCAR CANTIDAD DE EJEMPLARES 
        if(e.getSource() == visL.btnBuscarCantEj) //HICIERON CLICK AL BOTON BUSCAR CANTIDAD DE EJEMPLARES
        {
            //TOMAR id DE LA CAJA DE TEXTO
            
            //PASAR VALORES RECIBIDOS EN CAJAS DE TEXTO A ATRIBUTOS DE LA CLASE 
            modL.setIdBibliotecaLibro(Integer.parseInt(visL.txtBiblioLib.getText()));

            if(modCrudL.buscarCantEjemplares(modL)) //EL METODO BUSCAR RETORNA TRUE, POR LO TANTO SE ENCONTRO UN REGISTRO
            {
               
            //Se debe hacer esto.
            //A las cajas de texto se le pasa los valores que tienen
            //los atributos mediante el metodo get.
            
            visL.txtCantidadLib.setText(String.valueOf(modL.getCantEjemplares())); 
            } 
            else {
                JOptionPane.showMessageDialog(null, "No se encontro el registro");
                limpiar();
            } 
        }
        
        
        
        if(e.getSource() == visL.btnLimpiarLib)
            {
                limpiar();
            }
    }
    
    //METODO PARA limpiar ventana
    public void limpiar()
        {
            visL.txtIdLibroLib.setText(null);
            visL.txtTituloLib.setText(null);
            visL.txtAutorLib.setText(null);
            visL.txtAnnoLib.setText(null);
            visL.txtCategLibros.setText(null);
        }
}
