
package submenus;

import java.awt.Color;


public class CerrarSecion extends javax.swing.JPanel {

   int xmouse,ymouse;
    public CerrarSecion() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnAceptar = new javax.swing.JPanel();
        txtAceptar = new javax.swing.JLabel();
        Barra = new javax.swing.JPanel();
        btnSalir = new javax.swing.JPanel();
        txtSalir = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtnNegar = new javax.swing.JPanel();
        txtNegar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnAceptar.setBackground(new java.awt.Color(6, 154, 224));

        txtAceptar.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        txtAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtAceptar.setText("SI");
        txtAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtAceptarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout BtnAceptarLayout = new javax.swing.GroupLayout(BtnAceptar);
        BtnAceptar.setLayout(BtnAceptarLayout);
        BtnAceptarLayout.setHorizontalGroup(
            BtnAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        BtnAceptarLayout.setVerticalGroup(
            BtnAceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        add(BtnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 210, 70));

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

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));

        txtSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSalir.setText("X");
        txtSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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

        javax.swing.GroupLayout btnSalirLayout = new javax.swing.GroupLayout(btnSalir);
        btnSalir.setLayout(btnSalirLayout);
        btnSalirLayout.setHorizontalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );
        btnSalirLayout.setVerticalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BarraLayout = new javax.swing.GroupLayout(Barra);
        Barra.setLayout(BarraLayout);
        BarraLayout.setHorizontalGroup(
            BarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraLayout.createSequentialGroup()
                .addGap(0, 630, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BarraLayout.setVerticalGroup(
            BarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraLayout.createSequentialGroup()
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(Barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 30));

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel2.setText("¿Seguro que quieres cerrar sesión?");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        BtnNegar.setBackground(new java.awt.Color(6, 154, 224));

        txtNegar.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        txtNegar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtNegar.setText("NO");
        txtNegar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtNegar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtNegarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtNegarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout BtnNegarLayout = new javax.swing.GroupLayout(BtnNegar);
        BtnNegar.setLayout(BtnNegarLayout);
        BtnNegarLayout.setHorizontalGroup(
            BtnNegarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
            .addGroup(BtnNegarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BtnNegarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txtNegar, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        BtnNegarLayout.setVerticalGroup(
            BtnNegarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
            .addGroup(BtnNegarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(BtnNegarLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txtNegar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        add(BtnNegar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 190, -1));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Fondo2.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, 430));
    }// </editor-fold>//GEN-END:initComponents

    private void txtAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAceptarMouseEntered
        BtnAceptar.setBackground(new Color(228,95,28));
        txtAceptar.setForeground(Color.white);
    }//GEN-LAST:event_txtAceptarMouseEntered

    private void txtAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtAceptarMouseExited
        BtnAceptar.setBackground(new Color(1,176,243));
        txtAceptar.setForeground(Color.black);
    }//GEN-LAST:event_txtAceptarMouseExited

    private void txtSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_txtSalirMouseClicked

    private void txtSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseEntered
        btnSalir.setBackground(Color.red);
        txtSalir.setForeground(Color.white);
    }//GEN-LAST:event_txtSalirMouseEntered

    private void txtSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSalirMouseExited
        btnSalir.setBackground(Color.white);
        txtSalir.setForeground(Color.black);
    }//GEN-LAST:event_txtSalirMouseExited

    private void BarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraMouseDragged
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xmouse,y-ymouse);
    }//GEN-LAST:event_BarraMouseDragged

    private void BarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraMousePressed
        xmouse=evt.getX();
        ymouse=evt.getY();
    }//GEN-LAST:event_BarraMousePressed

    private void txtNegarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNegarMouseEntered
        BtnNegar.setBackground(new Color(228,95,28));
        txtNegar.setForeground(Color.white);
    }//GEN-LAST:event_txtNegarMouseEntered

    private void txtNegarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNegarMouseExited
        BtnNegar.setBackground(new Color(1,176,243));
        txtNegar.setForeground(Color.black);
    }//GEN-LAST:event_txtNegarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra;
    private javax.swing.JPanel BtnAceptar;
    private javax.swing.JPanel BtnNegar;
    private javax.swing.JPanel btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel txtAceptar;
    private javax.swing.JLabel txtNegar;
    private javax.swing.JLabel txtSalir;
    // End of variables declaration//GEN-END:variables
}
