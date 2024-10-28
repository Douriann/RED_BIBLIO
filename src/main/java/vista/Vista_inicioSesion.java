/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

/**
 *
 * @author HP
 */
public class Vista_inicioSesion extends javax.swing.JFrame {

    /**
     * Creates new form ventana_inicioSesion
     */
    public Vista_inicioSesion() {
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
        jPanel2 = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        lblLogoBiblio = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblInicioSesion = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnInicioSes = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txtContrasena = new javax.swing.JTextField();
        iconUsuario = new javax.swing.JLabel();
        iconContrasena = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        facebook = new javax.swing.JLabel();
        instagram = new javax.swing.JLabel();
        cuentaX = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo.png"))); // NOI18N
        jPanel2.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 90, 80));

        lblLogoBiblio.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lblLogoBiblio.setForeground(new java.awt.Color(0, 204, 204));
        lblLogoBiblio.setText("Bibliotecas");
        jPanel2.add(lblLogoBiblio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 140, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoVector.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lblInicioSesion.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        lblInicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        lblInicioSesion.setText("Inicio Sesión");
        jPanel2.add(lblInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 46, -1, 51));

        txtUsuario.setBackground(new java.awt.Color(0, 204, 204));
        txtUsuario.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setBorder(null);
        txtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 133, 241, -1));

        btnInicioSes.setBackground(new java.awt.Color(0, 204, 204));
        btnInicioSes.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnInicioSes.setForeground(new java.awt.Color(255, 255, 255));
        btnInicioSes.setText("Iniciar Sesión");
        btnInicioSes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        btnInicioSes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioSesActionPerformed(evt);
            }
        });
        jPanel2.add(btnInicioSes, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 272, 241, 32));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 155, 241, 10));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 217, 241, 10));

        txtContrasena.setBackground(new java.awt.Color(0, 204, 204));
        txtContrasena.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtContrasena.setForeground(new java.awt.Color(255, 255, 255));
        txtContrasena.setBorder(null);
        jPanel2.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 195, 241, -1));

        iconUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoclaro.png"))); // NOI18N
        jPanel2.add(iconUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 121, -1, -1));

        iconContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bloqueoclaro.png"))); // NOI18N
        jPanel2.add(iconContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 184, 31, 31));

        btnCerrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("X");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        jPanel2.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        facebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-facebook.png"))); // NOI18N
        jPanel2.add(facebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(376, 338, -1, -1));

        instagram.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-instagram.png"))); // NOI18N
        jPanel2.add(instagram, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 338, -1, -1));

        cuentaX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-twitterx.png"))); // NOI18N
        jPanel2.add(cuentaX, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 338, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInicioSesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioSesActionPerformed
        Vista_principal vp = new Vista_principal();
        vp.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnInicioSesActionPerformed

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMouseClicked

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
            java.util.logging.Logger.getLogger(Vista_inicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_inicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_inicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_inicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_inicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnInicioSes;
    private javax.swing.JLabel cuentaX;
    private javax.swing.JLabel facebook;
    private javax.swing.JLabel iconContrasena;
    private javax.swing.JLabel iconUsuario;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel instagram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblInicioSesion;
    private javax.swing.JLabel lblLogoBiblio;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
