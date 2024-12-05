package controlador;

import modelo.CrudLibro;
import modelo.Libro;
import vista.Vista_gestionLibros;
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
import modelo.Biblioteca;
import modelo.GestionLibrosTemplate;
import modelo.GestionLibrosAdministrador;
import modelo.GestionLibrosUsuario;

public class CtrlLibro implements ActionListener {

    private final Libro modL;
    private final CrudLibro modCrudL;
    private final Vista_gestionLibros visL;
    private GestionLibrosTemplate gestionLibros;

    public CtrlLibro(Libro modL, CrudLibro modCrudL, Vista_gestionLibros visL, int tipoUsuario) {
        this.modL = modL;
        this.modCrudL = modCrudL;
        this.visL = visL;

        switch (tipoUsuario) {
            case 3: // Administrador
                this.gestionLibros = new GestionLibrosAdministrador();
                break;
            case 1: // Estudiante
            case 2: // Profesor
            case 4: // Externo
                this.gestionLibros = new GestionLibrosUsuario();
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuario no válido");
        }

        this.visL.btnRegistrarLib.addActionListener(this); 
        this.visL.btnModificarLib.addActionListener(this); 
        this.visL.btnEliminarLib.addActionListener(this); 
        this.visL.btnBuscarLib.addActionListener(this); 
        this.visL.btnLimpiarLib.addActionListener(this); 
        this.visL.btnBuscarRegisLib.addActionListener(this); 
        this.visL.btnBuscarCantEj.addActionListener(this);

        this.visL.combxCategLib.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                combxCategLibActionPerformed(evt);
            }
        });

        this.visL.combxBiblioLib.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                combxBiblioLibActionPerformed(evt);
            }
        });
    }

    public void iniciar() {
        visL.setTitle("Gestión de Libros");
        visL.setLocationRelativeTo(null);
        visL.txtIdLibroLib.setVisible(true);
        modCrudL.llenarComboBoxCategoria(visL.combxCategLib); // Llenar el ComboBox de categorías al iniciar
        modCrudL.llenarComboBoxBiblioteca(visL.combxBiblioLib); // Llenar el ComboBox de bibliotecas al iniciar
    }

    private void combxCategLibActionPerformed(ActionEvent evt) {
        String selectedCategory = (String) visL.combxCategLib.getSelectedItem();
        Integer idCategoria = modCrudL.getIdCategoria(selectedCategory);
        if (idCategoria != null) {
            visL.txtCategLibros.setText(idCategoria.toString());
        } else {
            visL.txtCategLibros.setText("");
        }
    }

    private void combxBiblioLibActionPerformed(ActionEvent evt) {
        String selectedBiblioteca = (String) visL.combxBiblioLib.getSelectedItem();
        Integer idBiblioteca = modCrudL.getIdBiblioteca(selectedBiblioteca);
        if (idBiblioteca != null) {
            visL.txtBiblioLib.setText(idBiblioteca.toString());
        } else {
            visL.txtBiblioLib.setText("");
        }
    }

    // Método para buscar el nombre de la categoría basada en el idCategoria
    private String buscarNombreCategoria(int idCategoria) {
        for (Map.Entry<String, Integer> entry : modCrudL.getCategoriaMap().entrySet()) {
            if (entry.getValue().equals(idCategoria)) {
                return entry.getKey();
            }
        }
        return null;
    }

    // Método para buscar el nombre de la Biblioteca basada en el idBiblioteca
    private String buscarNombreBiblioteca(int idBiblioteca) {
        for (Map.Entry<String, Integer> entry : modCrudL.getBibliotecaMap().entrySet()) {
            if (entry.getValue().equals(idBiblioteca)) {
                return entry.getKey();
            }
        }
        return null;
    }


    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == visL.btnRegistrarLib) {
            modL.setTitulo(visL.txtTituloLib.getText());
            modL.setAutor(visL.txtAutorLib.getText());
            modL.setAño(Integer.parseInt(visL.txtAnnoLib.getText()));
            modL.setIdCategoria(Integer.parseInt(visL.txtCategLibros.getText()));
            modL.getBiblioteca().setIdBiblioteca(Integer.parseInt(visL.txtBiblioLib.getText()));

            if (gestionLibros.puedeRegistrar()) {
                if (gestionLibros.registrar(modL)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar el registro");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tiene permisos para registrar");
            }
            limpiar();
        }

        if (e.getSource() == visL.btnModificarLib) {
            modL.setIdLibro(Integer.parseInt(visL.txtIdLibroLib.getText()));
            modL.setTitulo(visL.txtTituloLib.getText());
            modL.setAutor(visL.txtAutorLib.getText());
            modL.setAño(Integer.parseInt(visL.txtAnnoLib.getText()));
            modL.setIdCategoria(Integer.parseInt(visL.txtCategLibros.getText()));
            modL.getBiblioteca().setIdBiblioteca(Integer.parseInt(visL.txtBiblioLib.getText()));

            if (gestionLibros.puedeModificar()) {
                if (gestionLibros.modificar(modL)) {
                    JOptionPane.showMessageDialog(null, "Registro Modificado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el registro");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tiene permisos para modificar");
            }
            limpiar();
        }

        if (e.getSource() == visL.btnEliminarLib) {
            modL.setIdLibro(Integer.parseInt(visL.txtIdLibroLib.getText()));

            if (gestionLibros.puedeEliminar()) {
                if (gestionLibros.eliminar(modL)) {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el registro");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No tiene permisos para eliminar");
            }
            limpiar();
        }

        if (e.getSource() == visL.btnBuscarLib) {
            modL.setIdLibro(Integer.parseInt(visL.txtIdLibroLib.getText()));

            if (gestionLibros.puedeConsultar()) {
                if (gestionLibros.consultar(modL)) {
                    visL.txtTituloLib.setText(modL.getTitulo());
                    visL.txtAutorLib.setText(modL.getAutor());
                    visL.txtAnnoLib.setText(String.valueOf(modL.getAño()));
                    visL.txtCategLibros.setText(String.valueOf(modL.getIdCategoria()));
                    visL.txtBiblioLib.setText(String.valueOf(modL.getBiblioteca().getIdBiblioteca()));

                    // Buscar y seleccionar la categoría en el ComboBox
                    int idCategoria = modL.getIdCategoria();
                    String nomCategoria = buscarNombreCategoria(idCategoria);
                    visL.combxCategLib.setSelectedItem(nomCategoria);

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

        // Buscar cantidad de ejemplares btnBuscarCantEj1
        if (e.getSource() == visL.btnBuscarCantEj) {
            
            // Obtener el idBiblioteca desde el campo de texto
            int idBiblioteca = Integer.parseInt(visL.txtBiblioLib.getText());
            modL.getBiblioteca().setIdBiblioteca(idBiblioteca);
            modL.setIdBibliotecaLibro(idBiblioteca);

            System.out.println("Prueba 2 entra buscar ejemplares");
            System.out.println("idBiblioteca: " + idBiblioteca);
            System.out.println("txtBiblioLib: " + visL.txtBiblioLib.getText());
            System.out.println("txtIdLibroLib: " + visL.txtIdLibroLib.getText());

            // Ejecutar la consulta para buscar la cantidad de ejemplares
            if (modCrudL.buscarCantEjemplares(modL)) {
                visL.txtCantidadLib.setText(String.valueOf(modL.getCantEjemplares()));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el registro");
                limpiar();
            }
        }

        
        if (e.getSource() == visL.btnLimpiarLib) {
            limpiar();
        }

        if (e.getSource() == visL.btnBuscarRegisLib) {
            try {
                listarLibro(visL.tblLibrosLib);
            } catch (ParseException ex) {
                Logger.getLogger(CtrlLibro.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void listarLibro(JTable tblLibrosLib) throws ParseException {
        DefaultTableModel modelo = (DefaultTableModel) tblLibrosLib.getModel();
        modelo.setRowCount(0);
        ArrayList<Libro> listaLibro = modCrudL.listarLibro(modL);
        Object[] objeto = new Object[5];
        for (int i = 0; i < listaLibro.size(); i++) {
            objeto[0] = listaLibro.get(i).getIdLibro();
            objeto[1] = listaLibro.get(i).getTitulo();
            objeto[2] = listaLibro.get(i).getAutor();
            objeto[3] = listaLibro.get(i).getAño();
            objeto[4] = listaLibro.get(i).getIdCategoria();
            modelo.addRow(objeto);
        }
        visL.tblLibrosLib.setModel(modelo);
    }

    public void limpiar() {
        visL.txtIdLibroLib.setText(null);
        visL.txtTituloLib.setText(null);
        visL.txtAutorLib.setText(null);
        visL.txtAnnoLib.setText(null);
        // Solo reposicionar el ComboBox en la posición cero sin borrar elementos 
        visL.combxCategLib.setSelectedIndex(0);
        visL.txtCategLibros.setText(null);
        
        // Reposicionar el ComboBox de bibliotecas en la posición cero 
        visL.combxBiblioLib.setSelectedIndex(0);
        visL.txtBiblioLib.setText(null);
        
        visL.txtCantidadLib.setText(null);
    }
}
