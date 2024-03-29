/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import database.Conexion;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristianss
 */
public class LoginCliente extends javax.swing.JFrame {

    int xMouse, yMouse;

    /**
     * Creates new form LoginUsuario
     */
    public LoginCliente() {
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

        jPanel1 = new javax.swing.JPanel();
        Usuario = new javax.swing.JLabel();
        BtnEntrar = new javax.swing.JButton();
        txtCorreo = new javax.swing.JLabel();
        txtboxCorreo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtContraseña = new javax.swing.JLabel();
        PasswordContrasena = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        btnback = new javax.swing.JLabel();
        btnSalir = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario (1).png"))); // NOI18N

        BtnEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonEntrar.png"))); // NOI18N
        BtnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEntrarActionPerformed(evt);
            }
        });

        txtCorreo.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtCorreo.setText("Correo Electronico");

        txtboxCorreo.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtboxCorreo.setForeground(new java.awt.Color(204, 204, 204));
        txtboxCorreo.setText("Ingrese el correo");
        txtboxCorreo.setBorder(null);
        txtboxCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtboxCorreoMousePressed(evt);
            }
        });
        txtboxCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtboxCorreoActionPerformed(evt);
            }
        });

        txtContraseña.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtContraseña.setText("Contraseña");

        PasswordContrasena.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PasswordContrasena.setForeground(new java.awt.Color(204, 204, 204));
        PasswordContrasena.setText("Contraseña");
        PasswordContrasena.setBorder(null);
        PasswordContrasena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PasswordContrasenaMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        jLabel1.setText("             Cliente");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContraseña)
                            .addComponent(txtCorreo))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addComponent(txtboxCorreo)
                    .addComponent(PasswordContrasena, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(Usuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtboxCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(BtnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 240, 360));

        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1491254409-leftarrowbackwardsign_82959.png"))); // NOI18N
        btnback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnback.setPreferredSize(new java.awt.Dimension(32, 32));
        btnback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnbackMouseClicked(evt);
            }
        });
        getContentPane().add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        btnSalir.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalir.setText("X");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSalirMousePressed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 30, 30));

        jPanel2.setBackground(new java.awt.Color(117, 158, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseClicked
        hide();
        Bienvenida obb = new Bienvenida();
        obb.setVisible(true);
    }//GEN-LAST:event_btnbackMouseClicked

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_btnSalirMousePressed

    private void BtnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEntrarActionPerformed
        Conexion conn = Conexion.getInstance();
        PreparedStatement ps;
        ResultSet rs;
        String consultaSQL = "SELECT correoUsuario, contraseñaUsuario FROM Usuarios WHERE  correoUsuario=? and contraseñaUsuario = ?;";

        if (!txtboxCorreo.getText().isEmpty()) {
            if (PasswordContrasena.getPassword().length > 0) {
                try {
                    conn.Conectar();
                    ps = conn.cadena.prepareStatement(consultaSQL);
                    ps.setString(1, txtboxCorreo.getText());
                    ps.setString(2, String.valueOf(PasswordContrasena.getPassword()));
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        hide();
                        MenuPClientes obpc = new MenuPClientes();
                        obpc.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese un usuario valido");
                    }
                    ps.close();
                    rs.close();
                    conn.Desconectar();
                    conn.cadena.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } finally {
                    ps = null;
                    conn = null;
                    rs = null;
                }

            } else {
                JOptionPane.showMessageDialog(this, "Escribir una contrasea (8 Caracteres)", "Sistema Loncheria Sanchez", JOptionPane.ERROR_MESSAGE);
                PasswordContrasena.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Escribir un correo valido", "Sistema Loncheria Sanchez", JOptionPane.ERROR_MESSAGE);
            txtboxCorreo.requestFocus();
        }
    }//GEN-LAST:event_BtnEntrarActionPerformed

    private void txtboxCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtboxCorreoActionPerformed

    }//GEN-LAST:event_txtboxCorreoActionPerformed

    private void PasswordContrasenaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PasswordContrasenaMousePressed
        if (String.valueOf(PasswordContrasena.getPassword()).equals("Contraseña")) {
            PasswordContrasena.setText("");
            PasswordContrasena.setForeground(Color.black);
        }
    }//GEN-LAST:event_PasswordContrasenaMousePressed

    private void txtboxCorreoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtboxCorreoMousePressed
        if (txtboxCorreo.getText().equals("Ingrese el correo")) {
            txtboxCorreo.setText("");
            txtboxCorreo.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtboxCorreoMousePressed

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
            java.util.logging.Logger.getLogger(LoginCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginCliente.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEntrar;
    private javax.swing.JPasswordField PasswordContrasena;
    private javax.swing.JLabel Usuario;
    private javax.swing.JLabel btnSalir;
    private javax.swing.JLabel btnback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel txtContraseña;
    private javax.swing.JLabel txtCorreo;
    private javax.swing.JTextField txtboxCorreo;
    // End of variables declaration//GEN-END:variables
}
