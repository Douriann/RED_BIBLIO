/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package vista;

import controlador.CtrlPrestamo;
import modelo.CrudPrestamo;
import modelo.Prestamo;

/**
 *
 * @author HP
 */
public class Vista_emergenteRenovacion extends javax.swing.JFrame {

    /**
     * Creates new form Vista_emergenteRenovacion
     */
    public Vista_emergenteRenovacion() {
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
        lblRenovacion = new javax.swing.JLabel();
        lblIdRenovPrest = new javax.swing.JLabel();
        lblIdPrestamoPrest = new javax.swing.JLabel();
        txtIdRenov = new javax.swing.JTextField();
        txtIdPrestRenv = new javax.swing.JTextField();
        btnRegistrarRenPrest = new javax.swing.JButton();
        btnModificarRenPrest = new javax.swing.JButton();
        btnEliminarRenPrest = new javax.swing.JButton();
        btnLimpiarRenPrest = new javax.swing.JButton();
        btnBuscarIdRenPrest = new javax.swing.JButton();
        btnBuscarIdPrest = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRenovPrest = new javax.swing.JTable();
        lblIdEstRen = new javax.swing.JLabel();
        txtIdEstadoRen = new javax.swing.JTextField();
        lblIdRenovPrest1 = new javax.swing.JLabel();
        btnRegresarPrest = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        lblRenovacion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lblRenovacion.setForeground(new java.awt.Color(255, 255, 255));
        lblRenovacion.setText("Renovación");

        lblIdRenovPrest.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblIdRenovPrest.setForeground(new java.awt.Color(255, 255, 255));
        lblIdRenovPrest.setText("Id Renovación:");

        lblIdPrestamoPrest.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblIdPrestamoPrest.setForeground(new java.awt.Color(255, 255, 255));
        lblIdPrestamoPrest.setText("Id Prestamo:");

        txtIdRenov.setBackground(new java.awt.Color(204, 204, 204));
        txtIdRenov.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtIdRenov.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtIdPrestRenv.setBackground(new java.awt.Color(204, 204, 204));
        txtIdPrestRenv.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtIdPrestRenv.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnRegistrarRenPrest.setBackground(new java.awt.Color(153, 153, 255));
        btnRegistrarRenPrest.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnRegistrarRenPrest.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarRenPrest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-registro-20.png"))); // NOI18N
        btnRegistrarRenPrest.setText("Registrar");
        btnRegistrarRenPrest.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnRegistrarRenPrest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnModificarRenPrest.setBackground(new java.awt.Color(255, 102, 153));
        btnModificarRenPrest.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnModificarRenPrest.setForeground(new java.awt.Color(255, 255, 255));
        btnModificarRenPrest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-modificar.png"))); // NOI18N
        btnModificarRenPrest.setText("Modificar");
        btnModificarRenPrest.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnModificarRenPrest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnEliminarRenPrest.setBackground(new java.awt.Color(153, 0, 0));
        btnEliminarRenPrest.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnEliminarRenPrest.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarRenPrest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-20.png"))); // NOI18N
        btnEliminarRenPrest.setText("Eliminar");
        btnEliminarRenPrest.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEliminarRenPrest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnLimpiarRenPrest.setBackground(new java.awt.Color(51, 255, 102));
        btnLimpiarRenPrest.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnLimpiarRenPrest.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiarRenPrest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-limpiar-20.png"))); // NOI18N
        btnLimpiarRenPrest.setText("Limpiar");
        btnLimpiarRenPrest.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnLimpiarRenPrest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnBuscarIdRenPrest.setBackground(new java.awt.Color(0, 204, 255));
        btnBuscarIdRenPrest.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnBuscarIdRenPrest.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarIdRenPrest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-búsqueda-15.png"))); // NOI18N
        btnBuscarIdRenPrest.setText("Buscar");
        btnBuscarIdRenPrest.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBuscarIdRenPrest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarIdRenPrest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarIdRenPrestActionPerformed(evt);
            }
        });

        btnBuscarIdPrest.setBackground(new java.awt.Color(0, 204, 255));
        btnBuscarIdPrest.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        btnBuscarIdPrest.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarIdPrest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-búsqueda-15.png"))); // NOI18N
        btnBuscarIdPrest.setText("Buscar");
        btnBuscarIdPrest.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnBuscarIdPrest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tblRenovPrest.setBackground(new java.awt.Color(51, 51, 51));
        tblRenovPrest.setForeground(new java.awt.Color(255, 255, 255));
        tblRenovPrest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Renovacion", "Id Prestamo", "Fecha de Inicio", "Fecha de Vencimiento", "Id Estado Renovación", "Nombre Estado Renovacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRenovPrest.setSelectionBackground(new java.awt.Color(13, 104, 116));
        jScrollPane1.setViewportView(tblRenovPrest);

        lblIdEstRen.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblIdEstRen.setForeground(new java.awt.Color(255, 255, 255));
        lblIdEstRen.setText("Id Estado Renovacion:");

        txtIdEstadoRen.setBackground(new java.awt.Color(204, 204, 204));
        txtIdEstadoRen.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        txtIdEstadoRen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblIdRenovPrest1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        lblIdRenovPrest1.setForeground(new java.awt.Color(255, 255, 255));
        lblIdRenovPrest1.setText("Mostrar Registros:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblIdEstRen)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(lblIdPrestamoPrest)
                                    .addGap(71, 71, 71)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lblIdRenovPrest)
                                .addGap(57, 57, 57)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtIdRenov)
                                    .addComponent(txtIdPrestRenv)
                                    .addComponent(txtIdEstadoRen))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarIdRenPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnRegistrarRenPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnModificarRenPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnEliminarRenPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnLimpiarRenPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(144, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblRenovacion)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIdRenovPrest1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarIdPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblRenovacion)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdRenovPrest)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdRenov, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarIdRenPrest)))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdPrestamoPrest)
                    .addComponent(txtIdPrestRenv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdEstRen)
                    .addComponent(txtIdEstadoRen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarRenPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificarRenPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarRenPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarRenPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdRenovPrest1)
                    .addComponent(btnBuscarIdPrest, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 810, 460));

        btnRegresarPrest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-atrás.png"))); // NOI18N
        btnRegresarPrest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegresarPrestMouseClicked(evt);
            }
        });
        jPanel1.add(btnRegresarPrest, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoEmerg.jpeg"))); // NOI18N
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 540));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarPrestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarPrestMouseClicked
        Prestamo modP = new Prestamo();
        CrudPrestamo modCP = new CrudPrestamo();
        Vista_gestionPrestamo vistaPres = new Vista_gestionPrestamo();
        
        CtrlPrestamo ctrlPres = new CtrlPrestamo(modP,modCP,vistaPres);
        ctrlPres.iniciar();
        this.setVisible(false);
    }//GEN-LAST:event_btnRegresarPrestMouseClicked

    private void btnBuscarIdRenPrestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarIdRenPrestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarIdRenPrestActionPerformed

    /*Evento para mover la vista de Renovacion del escritorio*/
    int xx, xy;
    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        
        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_jLabel2MouseDragged

    
    
    
    
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
            java.util.logging.Logger.getLogger(Vista_emergenteRenovacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista_emergenteRenovacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista_emergenteRenovacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista_emergenteRenovacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista_emergenteRenovacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscarIdPrest;
    public javax.swing.JButton btnBuscarIdRenPrest;
    public javax.swing.JButton btnEliminarRenPrest;
    public javax.swing.JButton btnLimpiarRenPrest;
    public javax.swing.JButton btnModificarRenPrest;
    public javax.swing.JButton btnRegistrarRenPrest;
    private javax.swing.JLabel btnRegresarPrest;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIdEstRen;
    private javax.swing.JLabel lblIdPrestamoPrest;
    private javax.swing.JLabel lblIdRenovPrest;
    private javax.swing.JLabel lblIdRenovPrest1;
    private javax.swing.JLabel lblRenovacion;
    public javax.swing.JTable tblRenovPrest;
    public javax.swing.JTextField txtIdEstadoRen;
    public javax.swing.JTextField txtIdPrestRenv;
    public javax.swing.JTextField txtIdRenov;
    // End of variables declaration//GEN-END:variables
}
