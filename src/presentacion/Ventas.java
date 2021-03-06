/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import database.Conexion;
import negocio.VentasControl;

/**
 *
 * @author Juan Pablo Campos L
 */
public class Ventas extends javax.swing.JPanel {

    private final VentasControl CONTROL;
    private String[] campos = new String[6];

    /**
     * Creates new form Productos
     */
    public Ventas() {
        initComponents();
        CONTROL = new VentasControl();
    }
    
    public void Buscar(int id){
        campos = CONTROL.buscar(id);
        txtID.setText(campos[0]);
        txtNumeroVenta.setText(campos[1]);
        txtNombreCliente.setText(campos[2]);
        txtCategoriaProducto.setText(campos[3]);
        txtCantidad.setText(campos[4]);
        txtPrecioVenta.setText(campos[5]);
        txtFechaVenta.setText(campos[6]);
        txtNumeroVenta.setEditable(false);
    }

    public void mensajeOk(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "Sistema de compra-venta", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mensajeError(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "Sistema de compra-venta", JOptionPane.ERROR_MESSAGE);
    }

    public void Limpiar() {
        txtNumeroVenta.setText("");
        txtNombreCliente.setText(null);
        txtCategoriaProducto.setText(null);
        txtCantidad.setText(null);
        txtPrecioVenta.setText(null);
        txtFechaVenta.setText(null);
        txtID.setText(null);
        txtNumeroVenta.setEditable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        imgVendedor = new javax.swing.JLabel();
        lblNombrePro = new javax.swing.JLabel();
        txtNumeroVenta = new javax.swing.JTextField();
        lblcodigo = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        lbltelefono = new javax.swing.JLabel();
        txtCategoriaProducto = new javax.swing.JTextField();
        lblCorreoVendedor = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblContrase??aVendedor = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        Backgroun = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblContrase??aVendedor1 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        txtFechaVenta = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 70, 10));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 140, 10));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 140, 10));
        add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 140, 10));
        add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 140, 10));
        add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 140, 10));
        add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 140, 10));

        imgVendedor.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        imgVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventas.png"))); // NOI18N
        add(imgVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 130, 130));

        lblNombrePro.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblNombrePro.setText("Numero de Venta:");
        add(lblNombrePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, -1));

        txtNumeroVenta.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtNumeroVenta.setBorder(null);
        add(txtNumeroVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 140, -1));

        lblcodigo.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblcodigo.setText("Nombre del Cliente:");
        add(lblcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, -1));

        txtNombreCliente.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtNombreCliente.setBorder(null);
        txtNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreClienteActionPerformed(evt);
            }
        });
        add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 140, -1));

        lbltelefono.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lbltelefono.setText("Categoria del Producto:");
        add(lbltelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 120, -1));

        txtCategoriaProducto.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtCategoriaProducto.setBorder(null);
        txtCategoriaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaProductoActionPerformed(evt);
            }
        });
        add(txtCategoriaProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 140, -1));

        lblCorreoVendedor.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblCorreoVendedor.setText("Cantidad:");
        add(lblCorreoVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 70, -1));

        txtCantidad.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtCantidad.setBorder(null);
        add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 140, -1));

        lblContrase??aVendedor.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblContrase??aVendedor.setText("Fecha de Venta:");
        add(lblContrase??aVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 90, -1));

        txtPrecioVenta.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtPrecioVenta.setBorder(null);
        txtPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaActionPerformed(evt);
            }
        });
        add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 140, -1));

        lblID.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblID.setText("ID :");
        add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 20, -1));

        txtID.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtID.setBorder(null);
        add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 70, -1));

        btnBuscar.setBackground(new java.awt.Color(254, 192, 15));
        btnBuscar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 70, -1));

        btnAgregar.setBackground(new java.awt.Color(254, 192, 15));
        btnAgregar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(null);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 70, -1));

        btnActualizar.setBackground(new java.awt.Color(254, 192, 15));
        btnActualizar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(null);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 70, 20));

        Backgroun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FondoVendedores.png"))); // NOI18N
        add(Backgroun, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 230, 460));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel1.setText("Ventas");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblContrase??aVendedor1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblContrase??aVendedor1.setText("Precio de Venta:");
        add(lblContrase??aVendedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 90, -1));
        add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 140, 10));

        txtFechaVenta.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtFechaVenta.setBorder(null);
        txtFechaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaVentaActionPerformed(evt);
            }
        });
        add(txtFechaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreClienteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Buscar(Integer.parseInt(txtID.getText().trim()));
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String resp;
        if (txtNumeroVenta.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Debe escribir un numero de venta", "Sistema de compra-venta papeleria yolis", JOptionPane.WARNING_MESSAGE);
            txtNumeroVenta.requestFocus();
        } else {
            resp = CONTROL.insertar(txtNumeroVenta.getText().trim(), txtNombreCliente.getText().trim(), txtCategoriaProducto.getText().trim(), Integer.parseInt(txtCantidad.getText().trim()), Double.parseDouble(txtPrecioVenta.getText().trim()), txtFechaVenta.getText().trim());
            if (resp.equals("Ok")) {
                mensajeOk("Registro insertado correctamente");
                Limpiar();
            } else {
                mensajeError(resp);
                txtNumeroVenta.requestFocus();
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String resp;
        if (txtNumeroVenta.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Debe escribir un numero de venta", "Sistema de compra-venta", JOptionPane.WARNING_MESSAGE);
            txtNumeroVenta.requestFocus();
        } else {
            resp = CONTROL.actualizar(Integer.parseInt(txtID.getText().trim()), txtNumeroVenta.getText().trim(), txtNombreCliente.getText().trim(), txtCategoriaProducto.getText().trim(), Integer.parseInt(txtCantidad.getText().trim()), Double.parseDouble(txtPrecioVenta.getText().trim()), txtFechaVenta.getText().trim());
            if (resp.equals("Ok")) {
                mensajeOk("Registro actualizado correctamente");
                Limpiar();
            } else {
                mensajeError(resp);
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtCategoriaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaProductoActionPerformed

    private void txtPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaActionPerformed

    private void txtFechaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaVentaActionPerformed

    public boolean encontrado = false;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backgroun;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel imgVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblContrase??aVendedor;
    private javax.swing.JLabel lblContrase??aVendedor1;
    private javax.swing.JLabel lblCorreoVendedor;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombrePro;
    private javax.swing.JLabel lblcodigo;
    private javax.swing.JLabel lbltelefono;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCategoriaProducto;
    private javax.swing.JTextField txtFechaVenta;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNumeroVenta;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
