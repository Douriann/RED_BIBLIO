package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
