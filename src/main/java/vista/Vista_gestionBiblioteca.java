/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.Color;

/**
 *
 * @author HP
 */
public class Vista_gestionBiblioteca extends javax.swing.JFrame {

    /**
     * Creates new form Vista_gestionBiblioteca
     */
    public Vista_gestionBiblioteca() {
        initComponents();
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
        logo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        pnlPrestamoBiblio = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblPrestamoBiblio = new javax.swing.JLabel();
        pnlEjemplarBiblio = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblEjemplarBiblio = new javax.swing.JLabel();
        pnlLibrosBiblio = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblLibrosBiblio = new javax.swing.JLabel();
        pnlBiblioBiblio = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblBiblioBiblio = new javax.swing.JLabel();
        pnlUsuarioBiblio = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblUsuarioBiblio = new javax.swing.JLabel();
        pnlPrincipalBiblio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblPrincipalBiblio = new javax.swing.JLabel();
        PanelMenu = new javax.swing.JLabel();
        PanelSup = new javax.swing.JLabel();
        lblBiblioteca = new javax.swing.JLabel();
        lblIdBiblioBiblio = new javax.swing.JLabel();
        lblNombreBiblio = new javax.swing.JLabel();
        lblDireccBiblio = new javax.swing.JLabel();
        txtIdBiblioBiblio = new javax.swing.JTextField();
        txtNombreBiblio = new javax.swing.JTextField();
        txtDireccBiblio = new javax.swing.JTextField();
        btnRegistrarBiblio = new javax.swing.JButton();
        btnModificarBiblio = new javax.swing.JButton();
        btnEliminarBiblio = new javax.swing.JButton();
        btnLimpiarBiblio = new javax.swing.JButton();
        txtBuscarBiblio = new javax.swing.JTextField();
        btnBuscarBiblio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBibliotecaBiblio = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgLogoBiblio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        jPanel1.add(imgLogoBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 100, 100));

        logo.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        logo.setForeground(new java.awt.Color(0, 204, 204));
        logo.setText("Bibliotecas");
        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 150, 40));

        btnCerrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("X");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        jPanel1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, -1, -1));

        pnlPrestamoBiblio.setBackground(new java.awt.Color(13, 104, 116));
        pnlPrestamoBiblio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlPrestamoBiblio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPrestamoBiblioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlPrestamoBiblioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlPrestamoBiblioMouseExited(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-libroPrestamo.png"))); // NOI18N

        lblPrestamoBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        lblPrestamoBiblio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrestamoBiblio.setText("Prestamo");

        javax.swing.GroupLayout pnlPrestamoBiblioLayout = new javax.swing.GroupLayout(pnlPrestamoBiblio);
        pnlPrestamoBiblio.setLayout(pnlPrestamoBiblioLayout);
        pnlPrestamoBiblioLayout.setHorizontalGroup(
            pnlPrestamoBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrestamoBiblioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPrestamoBiblio)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        pnlPrestamoBiblioLayout.setVerticalGroup(
            pnlPrestamoBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrestamoBiblioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlPrestamoBiblioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblPrestamoBiblio)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(pnlPrestamoBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 240, 50));

        pnlEjemplarBiblio.setBackground(new java.awt.Color(13, 104, 116));
        pnlEjemplarBiblio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlEjemplarBiblio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlEjemplarBiblioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlEjemplarBiblioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlEjemplarBiblioMouseExited(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-libroEjemplar.png"))); // NOI18N

        lblEjemplarBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        lblEjemplarBiblio.setForeground(new java.awt.Color(255, 255, 255));
        lblEjemplarBiblio.setText("Ejemplar");

        javax.swing.GroupLayout pnlEjemplarBiblioLayout = new javax.swing.GroupLayout(pnlEjemplarBiblio);
        pnlEjemplarBiblio.setLayout(pnlEjemplarBiblioLayout);
        pnlEjemplarBiblioLayout.setHorizontalGroup(
            pnlEjemplarBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEjemplarBiblioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEjemplarBiblio)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        pnlEjemplarBiblioLayout.setVerticalGroup(
            pnlEjemplarBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlEjemplarBiblioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblEjemplarBiblio)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1.add(pnlEjemplarBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 240, 50));

        pnlLibrosBiblio.setBackground(new java.awt.Color(13, 104, 116));
        pnlLibrosBiblio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlLibrosBiblio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlLibrosBiblioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlLibrosBiblioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlLibrosBiblioMouseExited(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-libro.png"))); // NOI18N

        lblLibrosBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        lblLibrosBiblio.setForeground(new java.awt.Color(255, 255, 255));
        lblLibrosBiblio.setText("Libros");

        javax.swing.GroupLayout pnlLibrosBiblioLayout = new javax.swing.GroupLayout(pnlLibrosBiblio);
        pnlLibrosBiblio.setLayout(pnlLibrosBiblioLayout);
        pnlLibrosBiblioLayout.setHorizontalGroup(
            pnlLibrosBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLibrosBiblioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(lblLibrosBiblio)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        pnlLibrosBiblioLayout.setVerticalGroup(
            pnlLibrosBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLibrosBiblioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlLibrosBiblioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblLibrosBiblio)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(pnlLibrosBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 240, 50));

        pnlBiblioBiblio.setBackground(new java.awt.Color(13, 104, 116));
        pnlBiblioBiblio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlBiblioBiblio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlBiblioBiblioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlBiblioBiblioMouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-biblioteca.png"))); // NOI18N

        lblBiblioBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        lblBiblioBiblio.setForeground(new java.awt.Color(255, 255, 255));
        lblBiblioBiblio.setText("Biblioteca");

        javax.swing.GroupLayout pnlBiblioBiblioLayout = new javax.swing.GroupLayout(pnlBiblioBiblio);
        pnlBiblioBiblio.setLayout(pnlBiblioBiblioLayout);
        pnlBiblioBiblioLayout.setHorizontalGroup(
            pnlBiblioBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBiblioBiblioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblBiblioBiblio)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        pnlBiblioBiblioLayout.setVerticalGroup(
            pnlBiblioBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBiblioBiblioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlBiblioBiblioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblBiblioBiblio)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(pnlBiblioBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 240, 50));

        pnlUsuarioBiblio.setBackground(new java.awt.Color(13, 104, 116));
        pnlUsuarioBiblio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlUsuarioBiblio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlUsuarioBiblioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlUsuarioBiblioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlUsuarioBiblioMouseExited(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoclaro.png"))); // NOI18N

        lblUsuarioBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        lblUsuarioBiblio.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioBiblio.setText("Usuario");

        javax.swing.GroupLayout pnlUsuarioBiblioLayout = new javax.swing.GroupLayout(pnlUsuarioBiblio);
        pnlUsuarioBiblio.setLayout(pnlUsuarioBiblioLayout);
        pnlUsuarioBiblioLayout.setHorizontalGroup(
            pnlUsuarioBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioBiblioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(lblUsuarioBiblio)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        pnlUsuarioBiblioLayout.setVerticalGroup(
            pnlUsuarioBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioBiblioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlUsuarioBiblioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblUsuarioBiblio)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(pnlUsuarioBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 240, 50));

        pnlPrincipalBiblio.setBackground(new java.awt.Color(13, 104, 116));
        pnlPrincipalBiblio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlPrincipalBiblio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlPrincipalBiblioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlPrincipalBiblioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlPrincipalBiblioMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-casa.png"))); // NOI18N

        lblPrincipalBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 20)); // NOI18N
        lblPrincipalBiblio.setForeground(new java.awt.Color(255, 255, 255));
        lblPrincipalBiblio.setText("Principal");

        javax.swing.GroupLayout pnlPrincipalBiblioLayout = new javax.swing.GroupLayout(pnlPrincipalBiblio);
        pnlPrincipalBiblio.setLayout(pnlPrincipalBiblioLayout);
        pnlPrincipalBiblioLayout.setHorizontalGroup(
            pnlPrincipalBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalBiblioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblPrincipalBiblio)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        pnlPrincipalBiblioLayout.setVerticalGroup(
            pnlPrincipalBiblioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalBiblioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pnlPrincipalBiblioLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblPrincipalBiblio)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1.add(pnlPrincipalBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 240, 50));

        PanelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/PanelMenu.jpeg"))); // NOI18N
        jPanel1.add(PanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 600));

        PanelSup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoHorizontal .PNG"))); // NOI18N
        jPanel1.add(PanelSup, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 810, 90));

        lblBiblioteca.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblBiblioteca.setForeground(new java.awt.Color(255, 255, 255));
        lblBiblioteca.setText("Bibliotecas");
        jPanel1.add(lblBiblioteca, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        lblIdBiblioBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblIdBiblioBiblio.setForeground(new java.awt.Color(255, 255, 255));
        lblIdBiblioBiblio.setText("Id Bliblioteca:");
        jPanel1.add(lblIdBiblioBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        lblNombreBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblNombreBiblio.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreBiblio.setText("Nombre:");
        jPanel1.add(lblNombreBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, -1));

        lblDireccBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblDireccBiblio.setForeground(new java.awt.Color(255, 255, 255));
        lblDireccBiblio.setText("Dirección:");
        jPanel1.add(lblDireccBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, -1));

        txtIdBiblioBiblio.setBackground(new java.awt.Color(204, 204, 204));
        txtIdBiblioBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtIdBiblioBiblio.setForeground(new java.awt.Color(0, 0, 0));
        txtIdBiblioBiblio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtIdBiblioBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 470, 20));

        txtNombreBiblio.setBackground(new java.awt.Color(204, 204, 204));
        txtNombreBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtNombreBiblio.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreBiblio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtNombreBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 470, 20));

        txtDireccBiblio.setBackground(new java.awt.Color(204, 204, 204));
        txtDireccBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtDireccBiblio.setForeground(new java.awt.Color(0, 0, 0));
        txtDireccBiblio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtDireccBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 470, 20));

        btnRegistrarBiblio.setBackground(new java.awt.Color(153, 153, 255));
        btnRegistrarBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnRegistrarBiblio.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarBiblio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-registro-20.png"))); // NOI18N
        btnRegistrarBiblio.setText("Registrar");
        btnRegistrarBiblio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRegistrarBiblio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnRegistrarBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 100, 30));

        btnModificarBiblio.setBackground(new java.awt.Color(255, 102, 153));
        btnModificarBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnModificarBiblio.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarBiblio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-modificar.png"))); // NOI18N
        btnModificarBiblio.setText("Modificar");
        btnModificarBiblio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnModificarBiblio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnModificarBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 100, 30));

        btnEliminarBiblio.setBackground(new java.awt.Color(153, 0, 0));
        btnEliminarBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnEliminarBiblio.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarBiblio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-20.png"))); // NOI18N
        btnEliminarBiblio.setText("Eliminar");
        btnEliminarBiblio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEliminarBiblio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnEliminarBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 90, 30));

        btnLimpiarBiblio.setBackground(new java.awt.Color(51, 255, 102));
        btnLimpiarBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnLimpiarBiblio.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarBiblio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-limpiar-20.png"))); // NOI18N
        btnLimpiarBiblio.setText("Limpiar");
        btnLimpiarBiblio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLimpiarBiblio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnLimpiarBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 280, 90, 30));

        txtBuscarBiblio.setBackground(new java.awt.Color(204, 204, 204));
        txtBuscarBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtBuscarBiblio.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscarBiblio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(txtBuscarBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 600, 30));

        btnBuscarBiblio.setBackground(new java.awt.Color(0, 204, 255));
        btnBuscarBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnBuscarBiblio.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarBiblio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-búsqueda.png"))); // NOI18N
        btnBuscarBiblio.setText("Buscar");
        btnBuscarBiblio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBuscarBiblio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(btnBuscarBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, 90, 30));

        tblBibliotecaBiblio.setBackground(new java.awt.Color(51, 51, 51));
        tblBibliotecaBiblio.setForeground(new java.awt.Color(255, 255, 255));
        tblBibliotecaBiblio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Biblioteca", "Nombre", "Dirección"
            }
        ));
        tblBibliotecaBiblio.setSelectionBackground(new java.awt.Color(13, 104, 116));
        jScrollPane1.setViewportView(tblBibliotecaBiblio);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, 710, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void pnlPrestamoBiblioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPrestamoBiblioMouseEntered
        pnlPrestamoBiblio.setBackground(Color.decode("#0a9aa0"));
    }//GEN-LAST:event_pnlPrestamoBiblioMouseEntered

    private void pnlPrestamoBiblioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPrestamoBiblioMouseExited
        pnlPrestamoBiblio.setBackground(Color.decode("#0d6874"));
    }//GEN-LAST:event_pnlPrestamoBiblioMouseExited

    private void pnlEjemplarBiblioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEjemplarBiblioMouseEntered
        pnlEjemplarBiblio.setBackground(Color.decode("#0a9aa0"));
    }//GEN-LAST:event_pnlEjemplarBiblioMouseEntered

    private void pnlEjemplarBiblioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEjemplarBiblioMouseExited
        pnlEjemplarBiblio.setBackground(Color.decode("#0d6874"));
    }//GEN-LAST:event_pnlEjemplarBiblioMouseExited

    private void pnlLibrosBiblioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLibrosBiblioMouseEntered
        pnlLibrosBiblio.setBackground(Color.decode("#0a9aa0"));
    }//GEN-LAST:event_pnlLibrosBiblioMouseEntered

    private void pnlLibrosBiblioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLibrosBiblioMouseExited
        pnlLibrosBiblio.setBackground(Color.decode("#0d6874"));
    }//GEN-LAST:event_pnlLibrosBiblioMouseExited

    private void pnlBiblioBiblioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBiblioBiblioMouseEntered
        pnlBiblioBiblio.setBackground(Color.decode("#0a9aa0"));
    }//GEN-LAST:event_pnlBiblioBiblioMouseEntered

    private void pnlBiblioBiblioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlBiblioBiblioMouseExited
        pnlBiblioBiblio.setBackground(Color.decode("#0d6874"));
    }//GEN-LAST:event_pnlBiblioBiblioMouseExited

    private void pnlUsuarioBiblioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlUsuarioBiblioMouseEntered
        pnlUsuarioBiblio.setBackground(Color.decode("#0a9aa0"));
    }//GEN-LAST:event_pnlUsuarioBiblioMouseEntered

    private void pnlUsuarioBiblioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlUsuarioBiblioMouseExited
        pnlUsuarioBiblio.setBackground(Color.decode("#0d6874"));
    }//GEN-LAST:event_pnlUsuarioBiblioMouseExited

    private void pnlPrincipalBiblioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPrincipalBiblioMouseEntered
        pnlPrincipalBiblio.setBackground(Color.decode("#0a9aa0"));
    }//GEN-LAST:event_pnlPrincipalBiblioMouseEntered

    private void pnlPrincipalBiblioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPrincipalBiblioMouseExited
        pnlPrincipalBiblio.setBackground(Color.decode("#0d6874"));
    }//GEN-LAST:event_pnlPrincipalBiblioMouseExited

    private void pnlPrincipalBiblioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPrincipalBiblioMouseClicked
        Vista_principal vp = new Vista_principal();
        vp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pnlPrincipalBiblioMouseClicked

    private void pnlUsuarioBiblioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlUsuarioBiblioMouseClicked
        Vista_gestionUsuario vu = new Vista_gestionUsuario();
        vu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pnlUsuarioBiblioMouseClicked

    private void pnlLibrosBiblioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLibrosBiblioMouseClicked
        Vista_gestionLibros vl = new Vista_gestionLibros();
        vl.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pnlLibrosBiblioMouseClicked

    private void pnlEjemplarBiblioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlEjemplarBiblioMouseClicked
        Vista_gestionEjemplar ve = new Vista_gestionEjemplar();
        ve.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pnlEjemplarBiblioMouseClicked

    private void pnlPrestamoBiblioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlPrestamoBiblioMouseClicked
        Vista_gestionPrestamo vp = new Vista_gestionPrestamo();
        vp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pnlPrestamoBiblioMouseClicked

    
    
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
            java.util.logging.Logger.getLogger(Vista_gestionBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_gestionBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_gestionBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_gestionBiblioteca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_gestionBiblioteca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PanelMenu;
    private javax.swing.JLabel PanelSup;
    private javax.swing.JButton btnBuscarBiblio;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnEliminarBiblio;
    private javax.swing.JButton btnLimpiarBiblio;
    private javax.swing.JButton btnModificarBiblio;
    private javax.swing.JButton btnRegistrarBiblio;
    private javax.swing.JLabel imgLogoBiblio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBiblioBiblio;
    private javax.swing.JLabel lblBiblioteca;
    private javax.swing.JLabel lblDireccBiblio;
    private javax.swing.JLabel lblEjemplarBiblio;
    private javax.swing.JLabel lblIdBiblioBiblio;
    private javax.swing.JLabel lblLibrosBiblio;
    private javax.swing.JLabel lblNombreBiblio;
    private javax.swing.JLabel lblPrestamoBiblio;
    private javax.swing.JLabel lblPrincipalBiblio;
    private javax.swing.JLabel lblUsuarioBiblio;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel pnlBiblioBiblio;
    private javax.swing.JPanel pnlEjemplarBiblio;
    private javax.swing.JPanel pnlLibrosBiblio;
    private javax.swing.JPanel pnlPrestamoBiblio;
    private javax.swing.JPanel pnlPrincipalBiblio;
    private javax.swing.JPanel pnlUsuarioBiblio;
    private javax.swing.JTable tblBibliotecaBiblio;
    private javax.swing.JTextField txtBuscarBiblio;
    private javax.swing.JTextField txtDireccBiblio;
    private javax.swing.JTextField txtIdBiblioBiblio;
    private javax.swing.JTextField txtNombreBiblio;
    // End of variables declaration//GEN-END:variables
}