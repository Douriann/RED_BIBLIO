/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package vista;

import controlador.CtrlUsuario;
import controlador.CtrlBiblioteca;
import controlador.CtrlEjemplar;
import controlador.CtrlInicioSesion;
import controlador.CtrlLibro;
import controlador.CtrlPrestamo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Biblioteca;
import modelo.CrudPrestamo;
import modelo.CrudBiblioteca;
import modelo.CrudEjemplar;
import modelo.CrudLibro;
import modelo.CrudUsuario;
import modelo.Ejemplar;
import modelo.Libro;
import modelo.Prestamo;
import modelo.Usuario;

public class Vista_gestionUsuario extends javax.swing.JFrame {

    /**
     * Creates new form Vista_gestionUsuario
     */
    public Vista_gestionUsuario() {
        initComponents();
        
 
        //Llenar caja de texto de idBiblioteca segun la eleccion en comboBox
        combxBiblioUsu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                //Obtener item seleccionado
                String selectedItem = (String) combxBiblioUsu.getSelectedItem();
                
                switch(selectedItem)
                {
                    case "Biblioteca Decanato de Ciencias y Tecnologia" -> txtBibliotUsu.setText("1");
                    case "Biblioteca Decanato de Ciencias de la Salud" -> txtBibliotUsu.setText("2");
                    case "Biblioteca Decanato de Economia" -> txtBibliotUsu.setText("3");
                    case "Biblioteca Decanato de Agronomia" -> txtBibliotUsu.setText("4");
                    case "Biblioteca Decanato de Ingenieria Civil" -> txtBibliotUsu.setText("5");
                    case "Biblioteca Decanato Experimental de Humanidades" -> txtBibliotUsu.setText("6");
                    case "Biblioteca Decanato de Medicina Veterinaria" -> txtBibliotUsu.setText("7");
                    case "Biblioteca Decanato de Administracion" -> txtBibliotUsu.setText("8");
                    case "Biblioteca Decanato de Psicologia" -> txtBibliotUsu.setText("9");   
                }
            }
        });
        
        //Llenar caja de texto de idTituloAcademico segun la eleccion en comboBox
        combxTitAcadUsu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Obtener item seleccionado
                String selectedItem = (String) combxTitAcadUsu.getSelectedItem();

                switch (selectedItem) {
                    case "Ingeniero en Informatica" ->
                        txtIdTitAcadUsu.setText("1");
                    case "Licenciado en Matematicas" ->
                        txtIdTitAcadUsu.setText("2");
                    case "Licenciado en Psicologia" ->
                        txtIdTitAcadUsu.setText("3");
                }
            }

        });
        //Llenar caja de texto de idDepartamento segun la eleccion en comboBox
        combxDepUsu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Obtener item seleccionado
                String selectedItem = (String) combxDepUsu.getSelectedItem();

                switch (selectedItem) {
                    case "Matematica" ->
                        txtIdDepUsu.setText("1");
                    case "Fisica" ->
                        txtIdDepUsu.setText("2");
                    case "Estadistica" ->
                        txtIdDepUsu.setText("3");
                    case "Contabilidad" ->
                        txtIdDepUsu.setText("4");
                    case "Economia" ->
                        txtIdDepUsu.setText("5");
                    case "Derecho" ->
                        txtIdDepUsu.setText("6");
                    case "Administracion" ->
                        txtIdDepUsu.setText("7");
                    case "Pediatria" ->
                        txtIdDepUsu.setText("8");
                    case "Patologia" ->
                        txtIdDepUsu.setText("9");
                    case "Farmacologia" ->
                        txtIdDepUsu.setText("10");
                }
            }
        });
        
        //Llenar caja de texto de idCarrera segun la eleccion en comboBox
        combxCarrUsu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Obtener item seleccionado
                String selectedItem = (String) combxCarrUsu.getSelectedItem();

                switch (selectedItem) {
                    case "Ingenieria Informatica" ->
                        txtIdCarrUsu.setText("1");
                    case "Ingenieria de Produccion" ->
                        txtIdCarrUsu.setText("2");
                    case "Medico Cirujano" ->
                        txtIdCarrUsu.setText("3");
                    case "Medicina Veterinaria" ->
                        txtIdCarrUsu.setText("4");
                    case "Ingenieria Civil" ->
                        txtIdCarrUsu.setText("5");
                    case "Ingenieria Agronomica" ->
                        txtIdCarrUsu.setText("6");
                    case "Analisis en Sistemas" ->
                        txtIdCarrUsu.setText("7");
                    case "Ingenieria Telematica" ->
                        txtIdCarrUsu.setText("8");
                    case "Licenciatura en Enfermeria" ->
                        txtIdCarrUsu.setText("9");
                    case "Psicologia" ->
                        txtIdCarrUsu.setText("10");
                    case "Musica" ->
                        txtIdCarrUsu.setText("11");
                    case "Artes Plasticas" ->
                        txtIdCarrUsu.setText("12");
                    case "Urbanismo" ->
                        txtIdCarrUsu.setText("13");
                    case "Economia" ->
                        txtIdCarrUsu.setText("14");
                    case "Contaduria Publica" ->
                        txtIdCarrUsu.setText("15");
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        imgLogoBiblio = new javax.swing.JLabel();
        logoUsuario = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        btn_prestamo = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblPrestamoUsu = new javax.swing.JLabel();
        btn_ejemplar = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblEjemplarUsu = new javax.swing.JLabel();
        btn_libros = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblLibrosUsu = new javax.swing.JLabel();
        btn_biblio = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblBiblioUsu = new javax.swing.JLabel();
        btn_usuario = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblUsuarioUsu = new javax.swing.JLabel();
        btn_principal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblPrincipalUsu = new javax.swing.JLabel();
        PanelMenu = new javax.swing.JLabel();
        PanelSup = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblCedulaUsu = new javax.swing.JLabel();
        txtCedulaUsu = new javax.swing.JTextField();
        txtNombreUsu = new javax.swing.JTextField();
        lblNombreUsu = new javax.swing.JLabel();
        txtApellidoUsu = new javax.swing.JTextField();
        lblApellidoUsu = new javax.swing.JLabel();
        txtTelefUsu = new javax.swing.JTextField();
        lblTelefUsu = new javax.swing.JLabel();
        txtContrasUsu = new javax.swing.JTextField();
        lblContrasUsu = new javax.swing.JLabel();
        txtBibliotUsu = new javax.swing.JTextField();
        lblBibliotUsu = new javax.swing.JLabel();
        lblMostrarRegisUsu = new javax.swing.JLabel();
        lblTipUsu = new javax.swing.JLabel();
        radioBtnEstUsu = new javax.swing.JRadioButton();
        radioBtnProfUsu = new javax.swing.JRadioButton();
        radioBtnExtUsu = new javax.swing.JRadioButton();
        radioBtnAdminUsu = new javax.swing.JRadioButton();
        lblEstudianteUsu = new javax.swing.JLabel();
        combxTitAcadUsu = new javax.swing.JComboBox<>();
        txtIdTitAcadUsu = new javax.swing.JTextField();
        combxDepUsu = new javax.swing.JComboBox<>();
        txtIdDepUsu = new javax.swing.JTextField();
        combxCarrUsu = new javax.swing.JComboBox<>();
        txtIdCarrUsu = new javax.swing.JTextField();
        lblProfUsu = new javax.swing.JLabel();
        btnBuscarUsu = new javax.swing.JButton();
        btnModificarUsu = new javax.swing.JButton();
        btnEliminarUsu = new javax.swing.JButton();
        btnLimpiarUsu = new javax.swing.JButton();
        combxBiblioUsu = new javax.swing.JComboBox<>();
        txtDireccUsu = new javax.swing.JTextField();
        btnRegistrarUsu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarioUsu = new javax.swing.JTable();
        lblDireccUsu1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgLogoBiblio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        jPanel1.add(imgLogoBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 100, 100));

        logoUsuario.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        logoUsuario.setForeground(new java.awt.Color(0, 204, 204));
        logoUsuario.setText("Bibliotecas");
        jPanel1.add(logoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 150, 40));

        btnCerrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("X");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, -1, -1));

        btn_prestamo.setBackground(new java.awt.Color(13, 104, 116));
        btn_prestamo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_prestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_prestamoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_prestamoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_prestamoMouseExited(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-libroPrestamo.png"))); // NOI18N

        lblPrestamoUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        lblPrestamoUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblPrestamoUsu.setText("Prestamo");

        javax.swing.GroupLayout btn_prestamoLayout = new javax.swing.GroupLayout(btn_prestamo);
        btn_prestamo.setLayout(btn_prestamoLayout);
        btn_prestamoLayout.setHorizontalGroup(
            btn_prestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_prestamoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPrestamoUsu)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        btn_prestamoLayout.setVerticalGroup(
            btn_prestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_prestamoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btn_prestamoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblPrestamoUsu)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(btn_prestamo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 250, 50));

        btn_ejemplar.setBackground(new java.awt.Color(13, 104, 116));
        btn_ejemplar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ejemplar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ejemplarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ejemplarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ejemplarMouseExited(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-libroEjemplar.png"))); // NOI18N

        lblEjemplarUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        lblEjemplarUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblEjemplarUsu.setText("Ejemplar");

        javax.swing.GroupLayout btn_ejemplarLayout = new javax.swing.GroupLayout(btn_ejemplar);
        btn_ejemplar.setLayout(btn_ejemplarLayout);
        btn_ejemplarLayout.setHorizontalGroup(
            btn_ejemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_ejemplarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEjemplarUsu)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        btn_ejemplarLayout.setVerticalGroup(
            btn_ejemplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(btn_ejemplarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblEjemplarUsu)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1.add(btn_ejemplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 250, 50));

        btn_libros.setBackground(new java.awt.Color(13, 104, 116));
        btn_libros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_libros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_librosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_librosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_librosMouseExited(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-libro.png"))); // NOI18N

        lblLibrosUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        lblLibrosUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblLibrosUsu.setText("Libros");

        javax.swing.GroupLayout btn_librosLayout = new javax.swing.GroupLayout(btn_libros);
        btn_libros.setLayout(btn_librosLayout);
        btn_librosLayout.setHorizontalGroup(
            btn_librosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_librosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(lblLibrosUsu)
                .addContainerGap(120, Short.MAX_VALUE))
        );
        btn_librosLayout.setVerticalGroup(
            btn_librosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_librosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btn_librosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblLibrosUsu)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(btn_libros, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 250, 50));

        btn_biblio.setBackground(new java.awt.Color(13, 104, 116));
        btn_biblio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_biblio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_biblioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_biblioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_biblioMouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-biblioteca.png"))); // NOI18N

        lblBiblioUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        lblBiblioUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblBiblioUsu.setText("Biblioteca");

        javax.swing.GroupLayout btn_biblioLayout = new javax.swing.GroupLayout(btn_biblio);
        btn_biblio.setLayout(btn_biblioLayout);
        btn_biblioLayout.setHorizontalGroup(
            btn_biblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_biblioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblBiblioUsu)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        btn_biblioLayout.setVerticalGroup(
            btn_biblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_biblioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btn_biblioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblBiblioUsu)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(btn_biblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 250, 50));

        btn_usuario.setBackground(new java.awt.Color(13, 104, 116));
        btn_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_usuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_usuarioMouseExited(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoclaro.png"))); // NOI18N

        lblUsuarioUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        lblUsuarioUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioUsu.setText("Usuario");

        javax.swing.GroupLayout btn_usuarioLayout = new javax.swing.GroupLayout(btn_usuario);
        btn_usuario.setLayout(btn_usuarioLayout);
        btn_usuarioLayout.setHorizontalGroup(
            btn_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_usuarioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblUsuarioUsu)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        btn_usuarioLayout.setVerticalGroup(
            btn_usuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_usuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btn_usuarioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblUsuarioUsu)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(btn_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 250, 50));

        btn_principal.setBackground(new java.awt.Color(13, 104, 116));
        btn_principal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_principal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_principalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_principalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_principalMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-casa.png"))); // NOI18N

        lblPrincipalUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        lblPrincipalUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblPrincipalUsu.setText("Principal");

        javax.swing.GroupLayout btn_principalLayout = new javax.swing.GroupLayout(btn_principal);
        btn_principal.setLayout(btn_principalLayout);
        btn_principalLayout.setHorizontalGroup(
            btn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_principalLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblPrincipalUsu)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        btn_principalLayout.setVerticalGroup(
            btn_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_principalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btn_principalLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblPrincipalUsu)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(btn_principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 250, 50));

        PanelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PanelMenu2.jpeg"))); // NOI18N
        jPanel1.add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 820));

        PanelSup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoHorizontal .PNG"))); // NOI18N
        jPanel1.add(PanelSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 820, 90));

        lblUsuario.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("Usuario");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        lblCedulaUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblCedulaUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblCedulaUsu.setText("Cedula:");
        jPanel1.add(lblCedulaUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        txtCedulaUsu.setBackground(new java.awt.Color(204, 204, 204));
        txtCedulaUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtCedulaUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtCedulaUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 550, 20));

        txtNombreUsu.setBackground(new java.awt.Color(204, 204, 204));
        txtNombreUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtNombreUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtNombreUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 550, 20));

        lblNombreUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblNombreUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreUsu.setText("Nombre:");
        jPanel1.add(lblNombreUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        txtApellidoUsu.setBackground(new java.awt.Color(204, 204, 204));
        txtApellidoUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtApellidoUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtApellidoUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 550, 20));

        lblApellidoUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblApellidoUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblApellidoUsu.setText("Apellido:");
        jPanel1.add(lblApellidoUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, -1));

        txtTelefUsu.setBackground(new java.awt.Color(204, 204, 204));
        txtTelefUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtTelefUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtTelefUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 550, 20));

        lblTelefUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblTelefUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefUsu.setText("Telefono:");
        jPanel1.add(lblTelefUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, -1, -1));

        txtContrasUsu.setBackground(new java.awt.Color(204, 204, 204));
        txtContrasUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtContrasUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtContrasUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 550, 20));

        lblContrasUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblContrasUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblContrasUsu.setText("Contraseña:");
        jPanel1.add(lblContrasUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, -1, -1));

        txtBibliotUsu.setBackground(new java.awt.Color(204, 204, 204));
        txtBibliotUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtBibliotUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtBibliotUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 250, 20));

        lblBibliotUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblBibliotUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblBibliotUsu.setText("Bibliotecas:");
        jPanel1.add(lblBibliotUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, -1, -1));

        lblMostrarRegisUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblMostrarRegisUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblMostrarRegisUsu.setText("Mostrar Registro:");
        jPanel1.add(lblMostrarRegisUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 550, -1, 30));

        lblTipUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblTipUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblTipUsu.setText("Tipo de Usuario:");
        jPanel1.add(lblTipUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, -1));

        radioBtnEstUsu.setBackground(new java.awt.Color(0, 204, 204));
        radioBtnEstUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        radioBtnEstUsu.setText("Estudiante");
        jPanel1.add(radioBtnEstUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, -1));

        radioBtnProfUsu.setBackground(new java.awt.Color(0, 204, 204));
        radioBtnProfUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        radioBtnProfUsu.setText("Profesor");
        jPanel1.add(radioBtnProfUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 350, -1, -1));

        radioBtnExtUsu.setBackground(new java.awt.Color(0, 204, 204));
        radioBtnExtUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        radioBtnExtUsu.setText("Externo");
        jPanel1.add(radioBtnExtUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, -1, -1));

        radioBtnAdminUsu.setBackground(new java.awt.Color(0, 204, 204));
        radioBtnAdminUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        radioBtnAdminUsu.setText("Administrador");
        jPanel1.add(radioBtnAdminUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 350, -1, -1));

        lblEstudianteUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblEstudianteUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblEstudianteUsu.setText("Estudiante:");
        jPanel1.add(lblEstudianteUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, -1));

        combxTitAcadUsu.setBackground(new java.awt.Color(204, 204, 204));
        combxTitAcadUsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Titulo Academico", "Ingeniero en Informatica", "Licenciado en Matematicas", "Licenciado en Psicologia" }));
        combxTitAcadUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(combxTitAcadUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 150, 20));

        txtIdTitAcadUsu.setBackground(new java.awt.Color(204, 204, 204));
        txtIdTitAcadUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtIdTitAcadUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtIdTitAcadUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, 120, 20));

        combxDepUsu.setBackground(new java.awt.Color(204, 204, 204));
        combxDepUsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Departamento", "Matematica", "Fisica", "Estadistica", "Contabilidad", "Economia", "Derecho", "Administracion", "Pediatria", "Patologia", "Farmacologia" }));
        combxDepUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(combxDepUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, 130, 20));

        txtIdDepUsu.setBackground(new java.awt.Color(204, 204, 204));
        txtIdDepUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtIdDepUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtIdDepUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 380, 110, -1));

        combxCarrUsu.setBackground(new java.awt.Color(204, 204, 204));
        combxCarrUsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carrera", "Ingenieria Informatica", "Ingenieria de Produccion", "Medico Cirujano", "Medicina Veterinaria", "Ingenieria Civil", "Ingenieria Agronomica", "Analisis en Sistemas", "Ingenieria Telematica", "Licenciatura en Enfermeria", "Psicologia", "Musica", "Artes Plasticas", "Urbanismo", "Economia", "Contaduria Publica" }));
        combxCarrUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(combxCarrUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 150, 20));

        txtIdCarrUsu.setBackground(new java.awt.Color(204, 204, 204));
        txtIdCarrUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtIdCarrUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtIdCarrUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 120, 20));

        lblProfUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblProfUsu.setForeground(new java.awt.Color(255, 255, 255));
        lblProfUsu.setText("Profesor:");
        jPanel1.add(lblProfUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, -1, -1));

        btnBuscarUsu.setBackground(new java.awt.Color(0, 204, 255));
        btnBuscarUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnBuscarUsu.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-búsqueda.png"))); // NOI18N
        btnBuscarUsu.setText("Buscar");
        btnBuscarUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBuscarUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnBuscarUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 180, 30));

        btnModificarUsu.setBackground(new java.awt.Color(255, 102, 153));
        btnModificarUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnModificarUsu.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-modificar.png"))); // NOI18N
        btnModificarUsu.setText("Modificar");
        btnModificarUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnModificarUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnModificarUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 480, 110, 30));

        btnEliminarUsu.setBackground(new java.awt.Color(153, 0, 0));
        btnEliminarUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnEliminarUsu.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-20.png"))); // NOI18N
        btnEliminarUsu.setText("Eliminar");
        btnEliminarUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEliminarUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnEliminarUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, 110, 30));

        btnLimpiarUsu.setBackground(new java.awt.Color(51, 255, 102));
        btnLimpiarUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnLimpiarUsu.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-limpiar-20.png"))); // NOI18N
        btnLimpiarUsu.setText("Limpiar");
        btnLimpiarUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLimpiarUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnLimpiarUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 480, 100, 30));

        combxBiblioUsu.setBackground(new java.awt.Color(204, 204, 204));
        combxBiblioUsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biblioteca", "Biblioteca Decanato de Ciencias y Tecnologia", "Biblioteca Decanato de Ciencias de la Salud", "Biblioteca Decanato de Economia", "Biblioteca Decanato de Agronomia", "Biblioteca Decanato de Ingenieria Civil", "Biblioteca Decanato Experimental de Humanidades", "Biblioteca Decanato de Medicina Veterinaria", "Biblioteca Decanato de Administracion", "Biblioteca Decanato de Psicologia" }));
        combxBiblioUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(combxBiblioUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 280, 20));

        txtDireccUsu.setBackground(new java.awt.Color(204, 204, 204));
        txtDireccUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtDireccUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtDireccUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 550, 20));

        btnRegistrarUsu.setBackground(new java.awt.Color(153, 153, 255));
        btnRegistrarUsu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnRegistrarUsu.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarUsu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-registro-20.png"))); // NOI18N
        btnRegistrarUsu.setText("Registrar");
        btnRegistrarUsu.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRegistrarUsu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnRegistrarUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 110, 30));

        tblUsuarioUsu.setBackground(new java.awt.Color(51, 51, 51));
        tblUsuarioUsu.setForeground(new java.awt.Color(255, 255, 255));
        tblUsuarioUsu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Apellido", "Telefono", "ID Biblioteca", "Tipo de Usuario", "Titulo Academico", "Departamento", "Carrera", "Dirección"
            }
        ));
        jScrollPane1.setViewportView(tblUsuarioUsu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 590, 750, 200));

        lblDireccUsu1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblDireccUsu1.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccUsu1.setText("Dirección:");
        jPanel1.add(lblDireccUsu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_principalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_principalMouseExited
        btn_principal.setBackground(Color.decode("#0d6874"));
    }//GEN-LAST:event_btn_principalMouseExited

    private void btn_principalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_principalMouseEntered
        btn_principal.setBackground(Color.decode("#0a9aa0"));
    }//GEN-LAST:event_btn_principalMouseEntered

    private void btn_usuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_usuarioMouseExited
        btn_usuario.setBackground(Color.decode("#0d6874"));
    }//GEN-LAST:event_btn_usuarioMouseExited

    private void btn_usuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_usuarioMouseEntered
        btn_usuario.setBackground(Color.decode("#0a9aa0"));
    }//GEN-LAST:event_btn_usuarioMouseEntered

    private void btn_biblioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_biblioMouseExited
        btn_biblio.setBackground(Color.decode("#0d6874"));
    }//GEN-LAST:event_btn_biblioMouseExited

    private void btn_biblioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_biblioMouseEntered
        btn_biblio.setBackground(Color.decode("#0a9aa0"));
    }//GEN-LAST:event_btn_biblioMouseEntered

    private void btn_librosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_librosMouseExited
        btn_libros.setBackground(Color.decode("#0d6874"));
    }//GEN-LAST:event_btn_librosMouseExited

    private void btn_librosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_librosMouseEntered
        btn_libros.setBackground(Color.decode("#0a9aa0"));
    }//GEN-LAST:event_btn_librosMouseEntered

    private void btn_ejemplarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ejemplarMouseExited
        btn_ejemplar.setBackground(Color.decode("#0d6874"));
    }//GEN-LAST:event_btn_ejemplarMouseExited

    private void btn_ejemplarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ejemplarMouseEntered
        btn_ejemplar.setBackground(Color.decode("#0a9aa0"));
    }//GEN-LAST:event_btn_ejemplarMouseEntered

    private void btn_prestamoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_prestamoMouseExited
        btn_prestamo.setBackground(Color.decode("#0d6874"));
    }//GEN-LAST:event_btn_prestamoMouseExited

    private void btn_prestamoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_prestamoMouseEntered
        btn_prestamo.setBackground(Color.decode("#0a9aa0"));
    }//GEN-LAST:event_btn_prestamoMouseEntered

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btn_principalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_principalMouseClicked
        Vista_principal vp = new Vista_principal();
        vp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_principalMouseClicked

    private void btn_biblioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_biblioMouseClicked
        Biblioteca mod = new Biblioteca();
        CrudBiblioteca modCrud = new CrudBiblioteca();
        Vista_gestionBiblioteca vis = new Vista_gestionBiblioteca();
        
        CtrlBiblioteca ctrl = new CtrlBiblioteca(mod, modCrud, vis);
        ctrl.iniciar();
        vis.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_biblioMouseClicked

    private void btn_librosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_librosMouseClicked
        Libro modL = new Libro();
        CrudLibro modCrudL = new CrudLibro();
        Vista_gestionLibros visL = new Vista_gestionLibros();

        CtrlLibro ctrlL = new CtrlLibro(modL, modCrudL, visL, CtrlInicioSesion.tipoUsuario);
        ctrlL.iniciar();
        visL.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_librosMouseClicked

    private void btn_ejemplarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ejemplarMouseClicked
        Ejemplar modE = new Ejemplar();
        CrudEjemplar modCrudE = new CrudEjemplar();
        Vista_gestionEjemplar visE = new Vista_gestionEjemplar();
        
        CtrlEjemplar ctrlE = new CtrlEjemplar(modE, modCrudE, visE, CtrlInicioSesion.tipoUsuario);
        ctrlE.iniciar();
        visE.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ejemplarMouseClicked

    private void btn_prestamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_prestamoMouseClicked
        Prestamo modP = new Prestamo();
        CrudPrestamo modCP = new CrudPrestamo();
        Vista_gestionPrestamo vistaPres = new Vista_gestionPrestamo();
        
        CtrlPrestamo ctrlPres = new CtrlPrestamo(modP,modCP,vistaPres);
        ctrlPres.iniciar();
        vistaPres.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_prestamoMouseClicked

    
                
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista_gestionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_gestionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_gestionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_gestionUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_gestionUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PanelMenu;
    private javax.swing.JLabel PanelSup;
    public javax.swing.JButton btnBuscarUsu;
    private javax.swing.JLabel btnCerrar;
    public javax.swing.JButton btnEliminarUsu;
    public javax.swing.JButton btnLimpiarUsu;
    public javax.swing.JButton btnModificarUsu;
    public javax.swing.JButton btnRegistrarUsu;
    private javax.swing.JPanel btn_biblio;
    private javax.swing.JPanel btn_ejemplar;
    private javax.swing.JPanel btn_libros;
    private javax.swing.JPanel btn_prestamo;
    private javax.swing.JPanel btn_principal;
    private javax.swing.JPanel btn_usuario;
    public javax.swing.JComboBox<String> combxBiblioUsu;
    public javax.swing.JComboBox<String> combxCarrUsu;
    public javax.swing.JComboBox<String> combxDepUsu;
    public javax.swing.JComboBox<String> combxTitAcadUsu;
    private javax.swing.JLabel imgLogoBiblio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellidoUsu;
    private javax.swing.JLabel lblBiblioUsu;
    private javax.swing.JLabel lblBibliotUsu;
    private javax.swing.JLabel lblCedulaUsu;
    private javax.swing.JLabel lblContrasUsu;
    public javax.swing.JLabel lblDireccUsu1;
    private javax.swing.JLabel lblEjemplarUsu;
    public javax.swing.JLabel lblEstudianteUsu;
    private javax.swing.JLabel lblLibrosUsu;
    private javax.swing.JLabel lblMostrarRegisUsu;
    private javax.swing.JLabel lblNombreUsu;
    private javax.swing.JLabel lblPrestamoUsu;
    private javax.swing.JLabel lblPrincipalUsu;
    public javax.swing.JLabel lblProfUsu;
    private javax.swing.JLabel lblTelefUsu;
    private javax.swing.JLabel lblTipUsu;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuarioUsu;
    private javax.swing.JLabel logoUsuario;
    public javax.swing.JRadioButton radioBtnAdminUsu;
    public javax.swing.JRadioButton radioBtnEstUsu;
    public javax.swing.JRadioButton radioBtnExtUsu;
    public javax.swing.JRadioButton radioBtnProfUsu;
    public javax.swing.JTable tblUsuarioUsu;
    public javax.swing.JTextField txtApellidoUsu;
    public javax.swing.JTextField txtBibliotUsu;
    public javax.swing.JTextField txtCedulaUsu;
    public javax.swing.JTextField txtContrasUsu;
    public javax.swing.JTextField txtDireccUsu;
    public javax.swing.JTextField txtIdCarrUsu;
    public javax.swing.JTextField txtIdDepUsu;
    public javax.swing.JTextField txtIdTitAcadUsu;
    public javax.swing.JTextField txtNombreUsu;
    public javax.swing.JTextField txtTelefUsu;
    // End of variables declaration//GEN-END:variables
}
