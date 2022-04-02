/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package papeleriayolis;

/**
 *
 * @author CSjes
 */
public class MenuInventario extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public MenuInventario() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jpMenu = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jbRegresarMP = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jbDesplegarMenu = new javax.swing.JButton();
        jbCerrrar = new javax.swing.JButton();
        jpAlmacenador = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(1, 159, 220));
        setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(1, 159, 220));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpMenu.setBackground(new java.awt.Color(252, 195, 20));
        jpMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(252, 195, 20));
        jButton2.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar32px.png"))); // NOI18N
        jButton2.setText("Agregar Categoria");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jpMenu.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 387, 260, 40));

        jbRegresarMP.setBackground(new java.awt.Color(252, 195, 20));
        jbRegresarMP.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jbRegresarMP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hogar32px.png"))); // NOI18N
        jbRegresarMP.setText("Regresar al menu principal");
        jbRegresarMP.setBorder(null);
        jbRegresarMP.setContentAreaFilled(false);
        jbRegresarMP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbRegresarMP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRegresarMPMouseClicked(evt);
            }
        });
        jbRegresarMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRegresarMPActionPerformed(evt);
            }
        });
        jpMenu.add(jbRegresarMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 445, 260, 40));

        jButton6.setBackground(new java.awt.Color(252, 195, 20));
        jButton6.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/management_inventory_icon_216505 (1).png"))); // NOI18N
        jButton6.setText("Inventario");
        jButton6.setBorder(null);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jpMenu.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 260, 40));

        jLabel1.setFont(new java.awt.Font("Blackadder ITC", 0, 36)); // NOI18N
        jLabel1.setText("Papeleria");
        jpMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Blackadder ITC", 0, 36)); // NOI18N
        jLabel2.setText("Yolis");
        jpMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        jButton7.setBackground(new java.awt.Color(252, 195, 20));
        jButton7.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visualizacion32px.png"))); // NOI18N
        jButton7.setText("Visualizar");
        jButton7.setBorder(null);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jpMenu.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 329, 260, 40));

        jPanel5.add(jpMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-260, 0, -1, 520));

        jbDesplegarMenu.setBackground(new java.awt.Color(1, 159, 220));
        jbDesplegarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Menu_icon_2_icon-icons.com_71856.png"))); // NOI18N
        jbDesplegarMenu.setBorder(null);
        jbDesplegarMenu.setContentAreaFilled(false);
        jbDesplegarMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbDesplegarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDesplegarMenuActionPerformed(evt);
            }
        });
        jPanel5.add(jbDesplegarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 40, 40));

        jbCerrrar.setBackground(new java.awt.Color(2, 159, 220));
        jbCerrrar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jbCerrrar.setForeground(new java.awt.Color(255, 255, 255));
        jbCerrrar.setText("X");
        jbCerrrar.setBorder(null);
        jbCerrrar.setContentAreaFilled(false);
        jbCerrrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrrarActionPerformed(evt);
            }
        });
        jPanel5.add(jbCerrrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 40, 40));

        jpAlmacenador.setBackground(new java.awt.Color(2, 159, 220));
        jpAlmacenador.setLayout(new javax.swing.BoxLayout(jpAlmacenador, javax.swing.BoxLayout.LINE_AXIS));
        jPanel5.add(jpAlmacenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 670, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbDesplegarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDesplegarMenuActionPerformed
        int posicion = jbDesplegarMenu.getX();
        if(posicion>5)
        {
            Animacion.Animacion.mover_izquierda(261, 5, 2, 2, jbDesplegarMenu);
            Animacion.Animacion.mover_izquierda(5, -260, 2, 2, jpMenu);
        }
        else
        {
            Animacion.Animacion.mover_derecha(5, 260, 2, 2, jbDesplegarMenu);
            Animacion.Animacion.mover_derecha(-260, 0, 2, 2, jpMenu);
        }
    }//GEN-LAST:event_jbDesplegarMenuActionPerformed

    private void jbCerrrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jbCerrrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new CambiaPanel(jpAlmacenador, new Productos());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jbRegresarMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRegresarMPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbRegresarMPActionPerformed

    private void jbRegresarMPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRegresarMPMouseClicked
        dispose();
        MenuPrincipal obmp = new MenuPrincipal();
        obmp.setVisible(true);
    }//GEN-LAST:event_jbRegresarMPMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new CambiaPanel(jpAlmacenador, new InventarioPapeleria());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbCerrrar;
    private javax.swing.JButton jbDesplegarMenu;
    private javax.swing.JButton jbRegresarMP;
    private javax.swing.JPanel jpAlmacenador;
    private javax.swing.JPanel jpMenu;
    // End of variables declaration//GEN-END:variables

}
