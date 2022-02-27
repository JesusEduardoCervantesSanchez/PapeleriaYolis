/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package submenus;

import java.awt.Color;


public class RegistrarProductoNuevo extends javax.swing.JFrame {

    int xmouse,ymouse;
    public RegistrarProductoNuevo() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        Barra = new javax.swing.JPanel();
        BtnSalir = new javax.swing.JPanel();
        txtSalir = new javax.swing.JLabel();
        BtnRegistrar = new javax.swing.JPanel();
        txtRegistrar = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MarcaProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        NombreProducto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PrecioProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PrecioMayoreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Categoria = new javax.swing.JTextField();
        ClaveProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CargarImagen = new javax.swing.JLabel();
        FondoColor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 500));

        Fondo.setBackground(new java.awt.Color(255, 255, 255));
        Fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Barra.setBackground(new java.awt.Color(255, 255, 255));
        Barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BarraMouseDragged(evt);
            }
        });
        Barra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BarraMousePressed(evt);
            }
        });

        BtnSalir.setBackground(new java.awt.Color(255, 255, 255));

        txtSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSalir.setText("X");
        txtSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout BtnSalirLayout = new javax.swing.GroupLayout(BtnSalir);
        BtnSalir.setLayout(BtnSalirLayout);
        BtnSalirLayout.setHorizontalGroup(
            BtnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        BtnSalirLayout.setVerticalGroup(
            BtnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BarraLayout = new javax.swing.GroupLayout(Barra);
        Barra.setLayout(BarraLayout);
        BarraLayout.setHorizontalGroup(
            BarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraLayout.createSequentialGroup()
                .addContainerGap(551, Short.MAX_VALUE)
                .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BarraLayout.setVerticalGroup(
            BarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraLayout.createSequentialGroup()
                .addComponent(BtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        Fondo.add(Barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 40));

        BtnRegistrar.setBackground(new java.awt.Color(228, 95, 28));

        txtRegistrar.setBackground(new java.awt.Color(228, 95, 28));
        txtRegistrar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRegistrar.setText("Registrar");
        txtRegistrar.setToolTipText("");
        txtRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtRegistrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout BtnRegistrarLayout = new javax.swing.GroupLayout(BtnRegistrar);
        BtnRegistrar.setLayout(BtnRegistrarLayout);
        BtnRegistrarLayout.setHorizontalGroup(
            BtnRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        BtnRegistrarLayout.setVerticalGroup(
            BtnRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        Fondo.add(BtnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, -1, 30));

        Titulo.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 255, 255));
        Titulo.setText("Producto Nuevo");
        Fondo.add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 250, 30));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Marca del producto");
        Fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 250, -1));

        MarcaProducto.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        MarcaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MarcaProductoActionPerformed(evt);
            }
        });
        Fondo.add(MarcaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 250, -1));

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre del producto");
        Fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 250, -1));

        NombreProducto.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        NombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreProductoActionPerformed(evt);
            }
        });
        Fondo.add(NombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 250, -1));

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Precio del producto");
        Fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 250, -1));

        PrecioProducto.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        PrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecioProductoActionPerformed(evt);
            }
        });
        Fondo.add(PrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 250, -1));

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Precio de mayoreo");
        Fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 250, -1));

        PrecioMayoreo.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        PrecioMayoreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecioMayoreoActionPerformed(evt);
            }
        });
        Fondo.add(PrecioMayoreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 250, -1));

        jLabel5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Categoria");
        Fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 250, -1));

        Categoria.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        Categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriaActionPerformed(evt);
            }
        });
        Fondo.add(Categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 250, -1));

        ClaveProducto.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        ClaveProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClaveProductoActionPerformed(evt);
            }
        });
        Fondo.add(ClaveProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 250, -1));

        jLabel6.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Clave Producto");
        Fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 250, -1));

        CargarImagen.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        CargarImagen.setText("Cargar Imagen...");
        CargarImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CargarImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CargarImagenMouseEntered(evt);
            }
        });
        Fondo.add(CargarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        FondoColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondos.png"))); // NOI18N
        Fondo.add(FondoColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 600, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraMousePressed
xmouse=evt.getX();
ymouse=evt.getY();
    }//GEN-LAST:event_BarraMousePressed

    private void BarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraMouseDragged
       int x=evt.getXOnScreen();
       int y=evt.getYOnScreen();
        this.setLocation(x-xmouse,y-ymouse);
    }//GEN-LAST:event_BarraMouseDragged

    private void txtSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_txtSalirMouseClicked

    private void txtSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseEntered
        BtnSalir.setBackground(Color.red);
        txtSalir.setForeground(Color.white);
    }//GEN-LAST:event_txtSalirMouseEntered

    private void txtSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseExited
        BtnSalir.setBackground(Color.white);
        txtSalir.setForeground(Color.black);
    }//GEN-LAST:event_txtSalirMouseExited

    private void txtRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegistrarMouseEntered
        BtnRegistrar.setBackground(new Color(1,176,243));
        txtRegistrar.setForeground(Color.white);
    }//GEN-LAST:event_txtRegistrarMouseEntered

    private void txtRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtRegistrarMouseExited
        BtnRegistrar.setBackground(new Color(228,95,28));
        txtRegistrar.setForeground(Color.white);
    }//GEN-LAST:event_txtRegistrarMouseExited

    private void MarcaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MarcaProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MarcaProductoActionPerformed

    private void NombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreProductoActionPerformed

    private void PrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecioProductoActionPerformed

    private void PrecioMayoreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecioMayoreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecioMayoreoActionPerformed

    private void CategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CategoriaActionPerformed

    private void ClaveProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClaveProductoActionPerformed
        
    }//GEN-LAST:event_ClaveProductoActionPerformed

    private void CargarImagenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CargarImagenMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CargarImagenMouseEntered

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
            java.util.logging.Logger.getLogger(RegistrarProductoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarProductoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarProductoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarProductoNuevo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarProductoNuevo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra;
    private javax.swing.JPanel BtnRegistrar;
    private javax.swing.JPanel BtnSalir;
    private javax.swing.JLabel CargarImagen;
    private javax.swing.JTextField Categoria;
    private javax.swing.JTextField ClaveProducto;
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel FondoColor;
    private javax.swing.JTextField MarcaProducto;
    private javax.swing.JTextField NombreProducto;
    private javax.swing.JTextField PrecioMayoreo;
    private javax.swing.JTextField PrecioProducto;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel txtRegistrar;
    private javax.swing.JLabel txtSalir;
    // End of variables declaration//GEN-END:variables
}
