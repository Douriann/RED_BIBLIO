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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.CrudEjemplar;
import modelo.Ejemplar;
import modelo.GestionEjemplaresTemplate;
import modelo.GestionEjemplaresAdministrador;
import modelo.GestionEjemplaresUsuario;
import vista.Vista_gestionEjemplar;

public class CtrlEjemplar implements ActionListener {

    private final Ejemplar modE;
    private final CrudEjemplar modCrudE;
    private final Vista_gestionEjemplar visE;
    private GestionEjemplaresTemplate gestionEjemplares;

    public CtrlEjemplar(Ejemplar modE, CrudEjemplar modCrudE, Vista_gestionEjemplar visE, int tipoUsuario) {
        this.modE = modE;
        this.modCrudE = modCrudE;
        this.visE = visE;

        switch (tipoUsuario) {
            case 3: // Administrador
                this.gestionEjemplares = new GestionEjemplaresAdministrador();
                break;
            case 1: // Estudiante
            case 2: // Profesor
            case 4: // Externo
                this.gestionEjemplares = new GestionEjemplaresUsuario();
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuario no válido");
        }

        this.visE.btnRegistrarEjem.addActionListener(this);
        this.visE.btnModificarEjem.addActionListener(this);
        this.visE.btnEliminarEjem.addActionListener(this);
        this.visE.btnBuscarEjem.addActionListener(this);
        this.visE.btnLimpiarEjem.addActionListener(this);
        this.visE.btnBuscarRegisEjem.addActionListener(this);
        
        this.visE.combxEstadoEjemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                combxEstadoEjemplarActionPerformed(evt);
            }
        });
        
        this.visE.combxLibEjemplar.addActionListener(new ActionListener() { 
            @Override 
            public void actionPerformed(ActionEvent evt) { 
                combxLibEjemplarActionPerformed(evt); 
            } 
        });
    }

    public void iniciar() {
        visE.setTitle("Ejemplar");
        visE.setLocationRelativeTo(null);
        visE.txtIdEjemplarEjem.setVisible(true);
        modCrudE.llenarComboBoxEstadoEjemplar(visE.combxEstadoEjemplar); // Llenar el ComboBox de estado al iniciar
        modCrudE.llenarComboBoxLibroEjemplar(visE.combxLibEjemplar); // Llenar el ComboBox de libros al iniciar
    }

   private void combxEstadoEjemplarActionPerformed(ActionEvent evt) { 
       String selectedEstadoEjemplar = (String) visE.combxEstadoEjemplar.getSelectedItem(); 
       Integer idEstadoEjemplar = modCrudE.getIdEstadoEjemplar(selectedEstadoEjemplar); 
       if (idEstadoEjemplar != null) { 
           visE.txtEstadoEjem.setText(idEstadoEjemplar.toString()); 
       } else { 
           visE.txtEstadoEjem.setText(""); 
       } 
   }
    
   private void combxLibEjemplarActionPerformed(ActionEvent evt) { 
       String selectedLibro = (String) visE.combxLibEjemplar.getSelectedItem(); 
       Integer idLibro = modCrudE.getIdLibro(selectedLibro); 
       if (idLibro != null) { 
           visE.txtIdLibroEjem.setText(idLibro.toString()); 
       } else { 
           visE.txtIdLibroEjem.setText(""); 
       } 
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == visE.btnRegistrarEjem) {
            modE.setIdEstadoEj(Integer.parseInt(visE.txtEstadoEjem.getText()));
            modE.setIdLibro(Integer.parseInt(visE.txtIdLibroEjem.getText()));
            modE.setUbicacion(visE.txtUbicacionEjem.getText());

            if (gestionEjemplares.puedeRegistrar()) {
                if (gestionEjemplares.registrar(modE)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tiene permisos para registrar");
            }
            limpiar();
        }

        if (e.getSource() == visE.btnModificarEjem) {
            modE.setIdEjemplar(Integer.parseInt(visE.txtIdEjemplarEjem.getText()));
            modE.setIdEstadoEj(Integer.parseInt(visE.txtEstadoEjem.getText()));
            modE.setIdLibro(Integer.parseInt(visE.txtIdLibroEjem.getText()));
            modE.setUbicacion(visE.txtUbicacionEjem.getText());

            if (gestionEjemplares.puedeModificar()) {
                if (gestionEjemplares.modificar(modE)) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el registro");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tiene permisos para modificar");
            }
            limpiar();
        }

        if (e.getSource() == visE.btnEliminarEjem) {
            modE.setIdEjemplar(Integer.parseInt(visE.txtIdEjemplarEjem.getText()));

            if (gestionEjemplares.puedeEliminar()) {
                if (gestionEjemplares.eliminar(modE)) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tiene permisos para eliminar");
            }
            limpiar();
        }

        if (e.getSource() == visE.btnBuscarEjem) {
            modE.setIdEjemplar(Integer.parseInt(visE.txtIdEjemplarEjem.getText()));

            if (gestionEjemplares.puedeConsultar()) {
                if (gestionEjemplares.consultar(modE)) {
                    visE.txtEstadoEjem.setText(String.valueOf(modE.getIdEstadoEj()));
                    visE.txtIdLibroEjem.setText(String.valueOf(modE.getIdLibro()));
                    visE.txtUbicacionEjem.setText(modE.getUbicacion());
                    
                    // Actualizar ComboBox basado en el resultado de la consulta 
                    String nomEstadoEjemplar = modCrudE.getEstadoEjemplarMap().entrySet().stream() 
                            .filter(entry -> entry.getValue().equals(modE.getIdEstadoEj())) 
                            .map(Map.Entry::getKey) 
                            .findFirst() 
                            .orElse(null); 
                    visE.combxEstadoEjemplar.setSelectedItem(nomEstadoEjemplar);
                    
                    // Actualizar ComboBox basado en el resultado de la consulta para Libro 
                    String titulo = modCrudE.getLibroMap().entrySet().stream() 
                            .filter(entry -> entry.getValue().equals(modE.getIdLibro())) 
                            .map(Map.Entry::getKey) 
                            .findFirst() 
                            .orElse(null); 
                    visE.combxLibEjemplar.setSelectedItem(titulo);
                    
                    JOptionPane.showMessageDialog(null, "Registro Consultado");
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el registro");
                    limpiar();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tiene permisos para consultar");
                limpiar();
            }
            
        }

        if (e.getSource() == visE.btnBuscarRegisEjem) {
            try {
                listarEjemplar(visE.tblEjemplarEjem);
            } catch (ParseException ex) {
                Logger.getLogger(CtrlEjemplar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == visE.btnLimpiarEjem) {
            limpiar();
        }
    }

    public void listarEjemplar(JTable tblEjemplarEjem) throws ParseException {
        DefaultTableModel modelo = (DefaultTableModel) tblEjemplarEjem.getModel();
        modelo.setRowCount(0);
        ArrayList<Ejemplar> listaEjemplar = modCrudE.listarEjemplar(modE);
        Object[] objeto = new Object[4];
        for (int i = 0; i < listaEjemplar.size(); i++) {
            objeto[0] = listaEjemplar.get(i).getIdEjemplar();
            objeto[1] = listaEjemplar.get(i).getIdLibro();
            objeto[2] = listaEjemplar.get(i).getIdEstadoEj();
            objeto[3] = listaEjemplar.get(i).getUbicacion();
            modelo.addRow(objeto);
        }
        visE.tblEjemplarEjem.setModel(modelo);
    }

    public void limpiar() {
        visE.txtIdEjemplarEjem.setText(null);
        visE.txtIdLibroEjem.setText(null);
        visE.txtEstadoEjem.setText(null);
        visE.txtUbicacionEjem.setText(null);
        visE.combxEstadoEjemplar.setSelectedIndex(0); // Repone el ComboBox a su estado inicial
        visE.combxLibEjemplar.setSelectedIndex(0); // Repone el ComboBox a su estado inicial
    }
}
