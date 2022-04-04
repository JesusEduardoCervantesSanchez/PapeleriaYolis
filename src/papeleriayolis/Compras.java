/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package papeleriayolis;

import Negocio.ComprasControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Compras extends javax.swing.JPanel {

    private final ComprasControl control;
    String accion;
    //private String nombreant;
    private String[] compras = new String [6];
    private boolean encontrado=false;
    
    public Compras() {
        initComponents();
        control = new ComprasControl();
        FechaActual();
        //txtFechas.setEditable(false);
    }
    
    public void Buscar(int id)
    {
        compras = control.Buscar(id);
        txtID.setText(compras[0]);
        txtNombreProveedor.setText(compras[1]);
        txtCategoriaProd.setText(compras[2]);
        txtCantidad.setText(compras[3]);
        txtPrecio.setText(compras[4]);
        jcFecha.setDate(FormatoF(compras[5]));
    }
    
    public void FechaActual()
    {
        //DateFormat df = DateFormat.getDateInstance();
        Date fechaActual = new Date();
        jcFecha.setDate(fechaActual);
        //txtFechas.setText(df.format(fechaActual));
    }
    
    public java.sql.Date Fecha()
    {
        //Esto traduce el formato de la fecha a una que la BD pueda aceptar
        try{
            Date f = jcFecha.getDate();
            long d = f.getTime();
            java.sql.Date fecha = new java.sql.Date(d);
            return fecha;
        }catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(this, "Ingresa una fecha valida", "Compras", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
    
    public Date FormatoF(String fechaBD)
    {
        //Esto traduce el formato de la fecha de la BD a una que jcFecha pueda aceptar
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try{
            fecha = formatoFecha.parse(fechaBD);
        }catch(ParseException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return fecha;
    }
    
    public void MensajeOK(String mensaje)
    {
        JOptionPane.showMessageDialog(this, mensaje, "Compras", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void MensajeError(String mensaje)
    {
        JOptionPane.showMessageDialog(this, mensaje, "Compras", JOptionPane.ERROR_MESSAGE);
    }
    
    public void Limpiar()
    {
        txtNombreProveedor.setText("");
        txtCategoriaProd.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        FechaActual();
        txtID.setText("");
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        imgVendedor = new javax.swing.JLabel();
        Backgroun = new javax.swing.JLabel();
        btnHoy = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        lblNombreProveedor = new javax.swing.JLabel();
        txtNombreProveedor = new javax.swing.JTextField();
        lblCategoriaProd = new javax.swing.JLabel();
        txtCategoriaProd = new javax.swing.JTextField();
        lbltelefono = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblCorreoVendedor = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblContraseñaVendedor = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jcFecha = new com.toedter.calendar.JDateChooser();

        setMinimumSize(new java.awt.Dimension(670, 460));
        setPreferredSize(new java.awt.Dimension(670, 460));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel1.setText("Compras");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        imgVendedor.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        imgVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/management_inventory_icon_216505.png"))); // NOI18N
        jPanel1.add(imgVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 130, 130));

        Backgroun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FondoVendedores.png"))); // NOI18N
        jPanel1.add(Backgroun, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 230, 460));

        btnHoy.setBackground(new java.awt.Color(254, 192, 15));
        btnHoy.setFont(new java.awt.Font("Agency FB", 0, 12)); // NOI18N
        btnHoy.setText("Hoy");
        btnHoy.setBorder(null);
        btnHoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoyActionPerformed(evt);
            }
        });
        jPanel1.add(btnHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 30, 20));

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
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 70, -1));

        btnEliminar.setBackground(new java.awt.Color(254, 192, 15));
        btnEliminar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 360, 70, -1));

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
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 70, -1));

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
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 70, 20));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 70, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 140, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 140, 10));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 140, 10));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 140, 10));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 140, 10));

        lblNombreProveedor.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblNombreProveedor.setText("Nombre de Proveedor:");
        jPanel1.add(lblNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 50, -1));

        txtNombreProveedor.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtNombreProveedor.setBorder(null);
        jPanel1.add(txtNombreProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 140, -1));

        lblCategoriaProd.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblCategoriaProd.setText("Categoria del Producto:");
        jPanel1.add(lblCategoriaProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 60, -1));

        txtCategoriaProd.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtCategoriaProd.setBorder(null);
        txtCategoriaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaProdActionPerformed(evt);
            }
        });
        jPanel1.add(txtCategoriaProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 140, -1));

        lbltelefono.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lbltelefono.setText("Cantidad:");
        jPanel1.add(lbltelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 90, -1));

        txtCantidad.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtCantidad.setBorder(null);
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 140, -1));

        lblCorreoVendedor.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblCorreoVendedor.setText("Precio Compra:");
        jPanel1.add(lblCorreoVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 70, -1));

        txtPrecio.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtPrecio.setBorder(null);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 140, -1));

        lblContraseñaVendedor.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblContraseñaVendedor.setText("Fecha Compra:");
        jPanel1.add(lblContraseñaVendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 60, -1));

        lblID.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblID.setText("Numero de compra:");
        jPanel1.add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 30, -1));

        txtID.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtID.setBorder(null);
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 70, -1));

        jcFecha.setDateFormatString("d/MM/yyyy");
        jcFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcFechaMouseClicked(evt);
            }
        });
        jPanel1.add(jcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       String resp;
       boolean ban = false;
       if(txtNombreProveedor.getText().isBlank())
           JOptionPane.showMessageDialog(this, "Debes ingresar un nombre", "Compras", JOptionPane.WARNING_MESSAGE);
       else{
           if(txtCategoriaProd.getText().isBlank())
                JOptionPane.showMessageDialog(this, "Debes ingresar una categoria", "Compras", JOptionPane.WARNING_MESSAGE);
           else{
               try
               {
                   Integer.parseInt(txtCantidad.getText());
                   Double.parseDouble(txtPrecio.getText());
                   if(Integer.parseInt(txtCantidad.getText())>0 && Double.parseDouble(txtPrecio.getText())>0)
                       ban = true;
                   else
                       JOptionPane.showMessageDialog(this, "Debes ingresar valores numericos tanto en cantidad como en precio", "Compras", JOptionPane.WARNING_MESSAGE);
               }catch(NumberFormatException e)
               {
                   JOptionPane.showMessageDialog(this, "Debes ingresar valores numericos tanto en cantidad como en precio", "Compras", JOptionPane.WARNING_MESSAGE);
               }
                    if(ban){
                       String fecha = Fecha().toString();
                       resp=control.Insertar(txtNombreProveedor.getText().trim(), txtCategoriaProd.getText(), Integer.parseInt(txtCantidad.getText()), Double.parseDouble(txtPrecio.getText()), fecha);
                    if(resp.equals("OK")){
                        MensajeOK("Registro insertado correctamente");
                        //Listar("");
                        Limpiar();
                    }else{
                        MensajeError(resp);
                    }
               }
           }
       }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String resp;
        try
        {
            if(txtID.getText().isBlank() || encontrado == false){
                JOptionPane.showMessageDialog(this, "Debes seleccionar una compra", "Compras", JOptionPane.WARNING_MESSAGE);
                return;
            }
            resp=control.Eliminar(Integer.valueOf(txtID.getText()));
            if(resp.equals("OK")){
                    this.encontrado=false;
                    MensajeOK("Compra eliminada exitosamente");
                    //Listar("");
                    Limpiar();
                }else{
                    MensajeError(resp);
                }
        }catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Debes ingresar un numero de compra", "Compras", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String resp;
        encontrado = false;
        try
        {
            if(!(resp=control.Existe(txtID.getText())).equals("OK")){
                MensajeError(resp);
                return;
            }
            Buscar(Integer.valueOf(txtID.getText()));
            this.encontrado=true;
        }catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Debes ingresar un numero de compra", "Compras", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
       String resp;
       boolean ban = false;
       if(txtID.getText().isBlank() || encontrado == false)
            JOptionPane.showMessageDialog(this, "Debes seleccionar un producto", "Compras", JOptionPane.WARNING_MESSAGE);
       else{
            if(txtNombreProveedor.getText().isBlank())
                JOptionPane.showMessageDialog(this, "Debes ingresar un nombre", "Compras", JOptionPane.WARNING_MESSAGE);
            else{
                if(txtCategoriaProd.getText().isBlank())
                     JOptionPane.showMessageDialog(this, "Debes ingresar una categoria", "Compras", JOptionPane.WARNING_MESSAGE);
                else{
                    try
                    {
                        Integer.parseInt(txtCantidad.getText());
                        Double.parseDouble(txtPrecio.getText());
                        if(Integer.parseInt(txtCantidad.getText())>0 && Double.parseDouble(txtPrecio.getText())>0)
                            ban = true;
                        else
                            JOptionPane.showMessageDialog(this, "Debes ingresar valores numericos tanto en cantidad como en precio", "Compras", JOptionPane.WARNING_MESSAGE);
                    }catch(NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(this, "Debes ingresar valores numericos tanto en cantidad como en precio", "Compras", JOptionPane.WARNING_MESSAGE);
                    }
                        if(ban){
                            String fecha = Fecha().toString();
                            resp=control.Actualizar(Integer.parseInt(txtID.getText()), txtNombreProveedor.getText().trim(), txtCategoriaProd.getText(), Integer.parseInt(txtCantidad.getText()), Double.parseDouble(txtPrecio.getText()), fecha);
                        if(resp.equals("OK")){
                            this.encontrado=false;
                            MensajeOK("Compra actualizada correctamente");
                            //Listar("");
                            Limpiar();
                        }else{
                            MensajeError(resp);
                        }
                    }
                }
            }
       }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtCategoriaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaProdActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void jcFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcFechaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jcFechaMouseClicked

    private void btnHoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoyActionPerformed
        FechaActual();
    }//GEN-LAST:event_btnHoyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backgroun;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnHoy;
    private javax.swing.JLabel imgVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private com.toedter.calendar.JDateChooser jcFecha;
    private javax.swing.JLabel lblCategoriaProd;
    private javax.swing.JLabel lblContraseñaVendedor;
    private javax.swing.JLabel lblCorreoVendedor;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombreProveedor;
    private javax.swing.JLabel lbltelefono;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCategoriaProd;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
