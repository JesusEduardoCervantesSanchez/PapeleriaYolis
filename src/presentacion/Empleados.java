/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import negocio.EmpleadosControl;


public class Empleados extends javax.swing.JPanel {

    
    private final EmpleadosControl EMPLEADOSCON;
    
    private int contador = 0;
    String accion;
    String imagenEmpleado;
    String nombreAnterior;
    private int filas;
    //private String nombreant;
    //private String[] compras2 = new String [6];
    DefaultTableModel dtmDetalle;
    
    
    public Empleados() {
        initComponents();
        EMPLEADOSCON = new EmpleadosControl();
         tabEmpComp.setVisible(false);
        accion = "guardar";
        imagenEmpleado="imagenEmpleado.jpg";
        txtidEmpleado.setEnabled(false);
         txtestadoEmpleado.setEnabled(false);
         //btnBuscarEmpleado.setEnabled(false);
        
        ListarTablaEmpleados("");
        
        
//        txtnombreEmpleado.setEditable(false);
//        txtNomProducto.setEditable(false);
//        txtIdCompra.setEditable(false);
//        txtPrecio.setEditable(false);
//        txtSubtotalCompra.setEditable(false);
//        txtSubtotal.setEditable(false);
//        txtiva.setEditable(false);
//        txtotal.setEditable(false);
        
        
       
    }
    
    
    
    
    public void Limpiar ()
    {
        //Sección tabla principal Empleados
        txtBusqueda.setText("");
        //Seccion secundaria Empleados
        txtnombreEmpleado.setText("");
        txtnombreEmpleado.setText("");
        txtidEmpleado.setText("");
        txttelefonoEmpleado.setText("");
        txtdomicilioEmpleado.setText("");
        txtcpEmpleado.setText("");
        txtcorreoEmpleado.setText("");
        txtcontraseñaEmpleado.setText("");
        txtestadoEmpleado.setText("");
        //Sección Imagen Principal Empleados
        lblimgEmpleado2.setIcon(null);
    }
    
    public void pintarImagen(JLabel lbl, String ruta){
        ImageIcon imagen = new ImageIcon(ruta);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));
        lbl.setIcon(icono);
        repaint();
    }
    
   
    //Listar a los empleados en el panel principal
     public void ListarTablaEmpleados(String texto)
    {
        jtListadoEmpleados.setModel(EMPLEADOSCON.listar(texto));
        TableRowSorter modeloOrdenado = new TableRowSorter(jtListadoEmpleados.getModel());
        jtListadoEmpleados.setRowSorter(modeloOrdenado);
        lblRegistrosMostrados.setText("Mostrados " + EMPLEADOSCON.totalMostrados() + " registros de " + EMPLEADOSCON.total());
        

   }
    
    public void MensajeOK(String mensaje)
    {
        JOptionPane.showMessageDialog(this, mensaje, "Compras", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void MensajeError(String mensaje)
    {
        JOptionPane.showMessageDialog(this, mensaje, "Compras", JOptionPane.ERROR_MESSAGE);
    }
    
//    public void Limpiar()
//    {
//        //Sección tabla principal Empleados
//        txtBusqueda.setText("");
//        //Seccion secundaria Empleados
//        txtnombreEmpleado.setText("");
//        txtnombreEmpleado.setText("");
//        txtidEmpleado.setText("");
//        txttelefonoEmpleado.setText("");
//        txtdomicilioEmpleado.setText("");
//        txtcpEmpleado.setText("");
//        txtcorreoEmpleado.setText("");
//        txtcontraseñaEmpleado.setText("");
//        txtestadoEmpleado.setText("");
//        txtDesc.setText("");
//       //Sección secundaria Compras
//        txtIdCompra.setText("");
//        txtDesc.setText("");
//        txtSubtotalCompra.setText("");
//        txtSubtotal.setText("");
//        txtiva.setText("");
//        txtotal.setText("");
//        ///Esto es para activar los campos despues de elegir una compra finalizada y regresar
//        //Activación de botones 
//        btnBuscarProducto.setEnabled(true);
//        btnGuardar.setEnabled(true);
//        btnAñadir.setEnabled(true);
//        btnModificar.setEnabled(true);
//        btnQuitarComDet.setEnabled(true);
//        btnLimpiarTabla.setEnabled(true);
//        //Activación
//        txtDescuento.setEditable(true);
//        txtcantidad.setEditable(true);
//        txtDesc.setEditable(true);
//        txtFecha.setEnabled(true);
//        cmbEstado.setEnabled(true);
//        ///////
//        int fila = jtListadoDetalleC.getRowCount();
//        for(int i = fila-1; i>=0; i--){
//            dtmDetalle.removeRow(i);
//        }
//    }
    
//    public void AccionLimpiar()
//    {
//        txtNomProducto.setText("");
//        txtIdCompra.setText("");
//        txtcantidad.setText("");
//        txtPrecio.setText("");
//        txtDesc.setText("");
//        txtSubtotalCompra.setText("");
//        jtListadoDetalleC.clearSelection();
//    }
    
//    public void MetodoAñadir()
//    {
//        CompraDetalle cdet = new CompraDetalle();
//        if(!txtIdCompra.getText().isEmpty()){
//            cdet.setIdProducto(Integer.parseInt(txtIdCompra.getText()));
//            cdet.setNombreProducto(txtNomProducto.getText());
//            if(!txtcantidad.getText().isEmpty())
//            {
//                cdet.setCantidad(Integer.parseInt(txtcantidad.getText()));
//                cdet.setPrecio(Double.parseDouble(txtPrecio.getText()));
//                if(!txtDesc.getText().isEmpty()){
//                    cdet.setDescuento(Double.parseDouble(txtDesc.getText()));
//                    cdet.setSubtotal(Double.parseDouble(txtSubtotalCompra.getText()));
//                    Object a[] = new Object[6];
//                    a[0] = Integer.parseInt(txtIdCompra.getText());
//                    a[1] = txtNomProducto.getText();
//                    a[2] = Integer.parseInt(txtcantidad.getText());
//                    a[3] = Double.parseDouble(txtPrecio.getText());
//                    a[4] = Double.parseDouble(txtDesc.getText());
//                    a[5] = Double.parseDouble(txtSubtotalCompra.getText());
//                    dtmDetalle.addRow(a);
//                    CalcularSubtotalCompra();
//                    AccionLimpiar();
//                }else{
//                    JOptionPane.showMessageDialog(this, "Debes ingresar un porcentaje de descuento valido entre 0 a 100", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
//                }
//            }else{
//                JOptionPane.showMessageDialog(this, "Debes ingresar una cantidad", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
//            }
//        }else{
//            JOptionPane.showMessageDialog(this, "Debes elegir un producto primero", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//    
    
    
   
    
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabEmpleados = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblimgEmpleado = new javax.swing.JLabel();
        Backgroun1 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnDetalles = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        lblBusqueda = new javax.swing.JLabel();
        lblRegistrosMostrados = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListadoEmpleados = new javax.swing.JTable();
        btnDesactivar = new javax.swing.JButton();
        btnActivacion1 = new javax.swing.JButton();
        tabEmpComp = new javax.swing.JPanel();
        btnAñadir = new javax.swing.JButton();
        lblimgEmpleado2 = new javax.swing.JLabel();
        btnImagen = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblNombreProveedor4 = new javax.swing.JLabel();
        txtnombreEmpleado = new javax.swing.JTextField();
        lblIDEmpleado = new javax.swing.JLabel();
        txtidEmpleado = new javax.swing.JTextField();
        lblNombreProveedor = new javax.swing.JLabel();
        txttelefonoEmpleado = new javax.swing.JTextField();
        lbldomicilioEmpleado = new javax.swing.JLabel();
        txtdomicilioEmpleado = new javax.swing.JTextField();
        lblcpEmpleado = new javax.swing.JLabel();
        txtcpEmpleado = new javax.swing.JTextField();
        lblcorreoEmpleado = new javax.swing.JLabel();
        txtcorreoEmpleado = new javax.swing.JTextField();
        lblcontraseñaEmpleado = new javax.swing.JLabel();
        txtcontraseñaEmpleado = new javax.swing.JTextField();
        lblEstadoEmpleado = new javax.swing.JLabel();
        txtestadoEmpleado = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        Backgroun = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(670, 460));
        setPreferredSize(new java.awt.Dimension(670, 460));

        tabEmpleados.setBackground(new java.awt.Color(255, 255, 255));
        tabEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel2.setText("Empleados");
        tabEmpleados.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblimgEmpleado.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblimgEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vendedor128px.png"))); // NOI18N
        tabEmpleados.add(lblimgEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 130, 130));

        Backgroun1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo formulario.jpg"))); // NOI18N
        tabEmpleados.add(Backgroun1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 170, 460));

        btnNuevo.setBackground(new java.awt.Color(255, 191, 117));
        btnNuevo.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorder(null);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        tabEmpleados.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 120, -1));

        btnBuscar.setBackground(new java.awt.Color(255, 191, 117));
        btnBuscar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        tabEmpleados.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 70, 20));

        btnDetalles.setBackground(new java.awt.Color(255, 191, 117));
        btnDetalles.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnDetalles.setText("Detalles");
        btnDetalles.setBorder(null);
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });
        tabEmpleados.add(btnDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 120, -1));
        tabEmpleados.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 230, 10));

        lblBusqueda.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda.setText("Busqueda:");
        tabEmpleados.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 60, -1));

        lblRegistrosMostrados.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        tabEmpleados.add(lblRegistrosMostrados, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 190, 20));

        txtBusqueda.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtBusqueda.setBorder(null);
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        tabEmpleados.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 230, -1));

        jtListadoEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtListadoEmpleados.getTableHeader().setReorderingAllowed(false);
        jtListadoEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtListadoEmpleados);

        tabEmpleados.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 420, 260));

        btnDesactivar.setBackground(new java.awt.Color(255, 191, 117));
        btnDesactivar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.setBorder(null);
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });
        tabEmpleados.add(btnDesactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 100, -1));

        btnActivacion1.setBackground(new java.awt.Color(255, 191, 117));
        btnActivacion1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnActivacion1.setText("Activar");
        btnActivacion1.setBorder(null);
        btnActivacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivacion1ActionPerformed(evt);
            }
        });
        tabEmpleados.add(btnActivacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 100, -1));

        tabEmpComp.setBackground(new java.awt.Color(255, 255, 255));
        tabEmpComp.setMinimumSize(new java.awt.Dimension(670, 460));
        tabEmpComp.setPreferredSize(new java.awt.Dimension(670, 460));
        tabEmpComp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAñadir.setBackground(new java.awt.Color(255, 191, 117));
        btnAñadir.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnAñadir.setText("Añadir");
        btnAñadir.setBorder(null);
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirbtnAñadirActionPerformed(evt);
            }
        });
        tabEmpComp.add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 80, 20));

        lblimgEmpleado2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblimgEmpleado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vendedor128px.png"))); // NOI18N
        tabEmpComp.add(lblimgEmpleado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 120, 130));

        btnImagen.setBackground(new java.awt.Color(255, 191, 117));
        btnImagen.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnImagen.setText("Agregar Imagen");
        btnImagen.setBorder(null);
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });
        tabEmpComp.add(btnImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 120, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNombreProveedor4.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblNombreProveedor4.setText("Empleado:");

        lblIDEmpleado.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblIDEmpleado.setText("ID: ");

        lblNombreProveedor.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblNombreProveedor.setText("Telefono: ");

        lbldomicilioEmpleado.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lbldomicilioEmpleado.setText("Domicilio:");

        lblcpEmpleado.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblcpEmpleado.setText("CP:");

        lblcorreoEmpleado.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblcorreoEmpleado.setText("Correo:");

        lblcontraseñaEmpleado.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblcontraseñaEmpleado.setText("Contraseña:");

        lblEstadoEmpleado.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblEstadoEmpleado.setText("Estado:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblcorreoEmpleado)
                            .addComponent(lblcpEmpleado))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtcpEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtcorreoEmpleado)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lbldomicilioEmpleado)
                                .addGap(18, 18, 18)
                                .addComponent(txtdomicilioEmpleado))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblNombreProveedor4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(lblIDEmpleado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(lblNombreProveedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txttelefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEstadoEmpleado)
                            .addComponent(lblcontraseñaEmpleado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcontraseñaEmpleado)
                            .addComponent(txtestadoEmpleado))))
                .addGap(259, 259, 259))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreProveedor4)
                            .addComponent(txtnombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttelefonoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreProveedor)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblIDEmpleado)
                        .addComponent(txtidEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldomicilioEmpleado)
                    .addComponent(txtdomicilioEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcpEmpleado)
                    .addComponent(txtcpEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcorreoEmpleado)
                    .addComponent(txtcorreoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcontraseñaEmpleado)
                    .addComponent(txtcontraseñaEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstadoEmpleado)
                    .addComponent(txtestadoEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(232, Short.MAX_VALUE))
        );

        tabEmpComp.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 450));

        btnGuardar.setBackground(new java.awt.Color(255, 191, 117));
        btnGuardar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/confirmar.png"))); // NOI18N
        btnGuardar.setText("Confirmar");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        tabEmpComp.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 80, 20));

        btnCancelar.setBackground(new java.awt.Color(255, 191, 117));
        btnCancelar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.setBorder(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        tabEmpComp.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 80, 20));

        btnModificar.setBackground(new java.awt.Color(255, 191, 117));
        btnModificar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnModificar.setText("Actualizar");
        btnModificar.setBorder(null);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        tabEmpComp.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 80, 20));

        Backgroun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo formulario.jpg"))); // NOI18N
        Backgroun.setPreferredSize(new java.awt.Dimension(460, 670));
        tabEmpComp.add(Backgroun, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 170, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(tabEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabEmpComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabEmpleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabEmpComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
          //Cambio Paneles
          tabEmpleados.setVisible(false);
          tabEmpComp.setVisible(true);
          //Sección activar edición Botones del Segundo Panel
                //btnBuscarProducto.setEnabled(true);
                btnGuardar.setEnabled(true);
                btnAñadir.setEnabled(true);
                btnModificar.setEnabled(true);
                //btnQuitarComDet.setEnabled(true);
                //btnLimpiarTabla.setEnabled(true);
                //btnBuscarEmpleado.setEnabled(true);
//        //Sección activar edición Campos del Segundo Panel
                txtnombreEmpleado.setEditable(true);
                txtidEmpleado.setEditable(true);
                txttelefonoEmpleado.setEditable(true);
                txtdomicilioEmpleado.setEditable(true);
                txtcpEmpleado.setEditable(true);
                txtcorreoEmpleado.setEditable(true);
                txtcontraseñaEmpleado.setEditable(true);
                txtestadoEmpleado.setEditable(true);
               
          //Sección Imagen;
                btnImagen.setEnabled(true);
          //Rellenar Campos
          if(jtListadoEmpleados.getSelectedRowCount()==1)
          {
              txtidEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 0).toString());
            txtnombreEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 1).toString());
            txttelefonoEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 2).toString());
            txtdomicilioEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 3).toString());
            txtcpEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 4).toString());
            txtcorreoEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 5).toString());
            txtcontraseñaEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 6).toString());
            imagenEmpleado=jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(),7).toString();
            pintarImagen(lblimgEmpleado2,imagenEmpleado);
            txtestadoEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 8).toString());
          }
            
                
          btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        //Se desactiva la edición de empleados y compras
            if(jtListadoEmpleados.getSelectedRowCount()==1){
           
//            String estado = jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 7).toString();
//              if(estado.equals("Finalizada")){
               //Sección desactivar edición Botones del Segundo Panel
                //btnBuscarProducto.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnAñadir.setEnabled(false);
                btnModificar.setEnabled(false);
                //btnQuitarComDet.setEnabled(false);
                //btnLimpiarTabla.setEnabled(false);
               // btnBuscarEmpleado.setEnabled(false);
//              //Sección desactivar edición Campos del Segundo Panel
                txtnombreEmpleado.setEditable(false);
                txtidEmpleado.setEditable(false);
                txttelefonoEmpleado.setEditable(false);
                txtdomicilioEmpleado.setEditable(false);
                txtcpEmpleado.setEditable(false);
                txtcorreoEmpleado.setEditable(false);
                txtcontraseñaEmpleado.setEditable(false);
                txtestadoEmpleado.setEditable(false);
                //Sección Imagen;
                btnImagen.setEnabled(false);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Debes elegir un empleado primero", "Papeleria Yolis", JOptionPane.ERROR_MESSAGE);
            }
            txtidEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 0).toString());
            txtnombreEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 1).toString());
            txttelefonoEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 2).toString());
            txtdomicilioEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 3).toString());
            txtcpEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 4).toString());
            txtcorreoEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 5).toString());
            txtcontraseñaEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 6).toString());
            imagenEmpleado=jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(),7).toString();
            pintarImagen(lblimgEmpleado2,imagenEmpleado);
            txtestadoEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 8).toString());


//            //Se hace el cambio de paneles 
              tabEmpleados.setVisible(false);
              tabEmpComp.setVisible(true);
//            NoModificablesDetalle();
//            ListarTablaDetalle(Integer.parseInt(txtidCompra.getText()));
//            
//            //accion = "editar";
//            //btnGuardar.setText("Editar");
//        }else{
//            JOptionPane.showMessageDialog(this, "Debes elegir una compra primero", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
//        }
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
//        Listar(txtBusqueda.getText().trim());
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        String resp;
        // Preguntar que se haya seleccionado un elemento
        if(jtListadoEmpleados.getSelectedRowCount()==1){
            //Preguntar si el registro aún no ha sido activado
            if(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(),8).toString().equals("Activo")){
                //Obtener el Id antes de desactivar
                txtidEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 0).toString());
                txtnombreEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 1).toString());
                //System.out.println(txtnombreEmpleado);
                if(JOptionPane.showConfirmDialog(this, "¿Deseas activar el empleado: "+txtnombreEmpleado.getText()+"?","Papeleria Yolis", JOptionPane.YES_NO_OPTION)==0){
                    resp=EMPLEADOSCON.desactivar(Integer.parseInt(txtidEmpleado.getText()));
                    if(resp.equals("OK")){
                        mensajeOK("Registro desactivado.");
                        Limpiar();
                        ListarTablaEmpleados("");
                    }
                    else
                        mensajeError(resp);
                }
            }
            else
                mensajeError("El registro ya ha sido desactivado");
        }
        else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro","Papeleria Yolis", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void jtListadoEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoEmpleadosMouseClicked
        
    }//GEN-LAST:event_jtListadoEmpleadosMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ListarTablaEmpleados(txtBusqueda.getText().trim());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnActivacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivacion1ActionPerformed
        String resp;
        // Preguntar que se haya seleccionado un elemento
        if(jtListadoEmpleados.getSelectedRowCount()==1){
            //Preguntar si el registro aún no ha sido activado
            if(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(),8).toString().equals("Inactivo")){
                //Obtener el Id antes de desactivar
                txtidEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 0).toString());
                txtnombreEmpleado.setText(jtListadoEmpleados.getValueAt(jtListadoEmpleados.getSelectedRow(), 1).toString());
                if(JOptionPane.showConfirmDialog(this, "¿Deseas activar el empleado: "+txtnombreEmpleado.getText()+"?","Papeleria Yolis", JOptionPane.YES_NO_OPTION)==0){
                    resp=EMPLEADOSCON.activar(Integer.parseInt(txtidEmpleado.getText()));
                    if(resp.equals("OK")){
                        mensajeOK("Registro activado.");
                        Limpiar();
                        ListarTablaEmpleados("");
                    }
                    else
                        mensajeError(resp);
                }
            }
            else
                mensajeError("El registro ya ha sido activado");
        }
        else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro","Papeleria Yolis", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnActivacion1ActionPerformed

    private void btnAñadirbtnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirbtnAñadirActionPerformed
        String resp = null;
        accion="guardar";
    //Verificar que el campo nombre no esté vacío
        if(txtnombreEmpleado.getText().isBlank())
        {
            JOptionPane.showMessageDialog(this, "Debe escribir un nombre", "Sistema de Compra-Venta", JOptionPane.WARNING_MESSAGE);
            txtnombreEmpleado.requestFocus();
            
        }
            if( accion.equals("guardar"))
            {
            resp=EMPLEADOSCON.insertar(txtnombreEmpleado.getText(), txttelefonoEmpleado.getText(), txtdomicilioEmpleado.getText(), txtcpEmpleado.getText(), txtcorreoEmpleado.getText(), txtcontraseñaEmpleado.getText(), imagenEmpleado);
                if(resp.equals("OK"))
                {
                    this.mensajeOK("Registro insertado correctamente.");
                    ListarTablaEmpleados("");
                    this.Limpiar();
              
                }    
            }
            else
            {
                this.mensajeError(resp);
                txtnombreEmpleado.requestFocus();
            }
    
        
    }//GEN-LAST:event_btnAñadirbtnAñadirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
      String resp = null;
      accion="guardar";
        if(txtnombreEmpleado.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe ingresar un Nombre", "Sistema de compras", JOptionPane.WARNING_MESSAGE);
            txtnombreEmpleado.requestFocus();
            return;
        }
        if(txttelefonoEmpleado.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe ingresar un telefono", "Sistema de compras", JOptionPane.WARNING_MESSAGE);
            txttelefonoEmpleado.requestFocus();
            return;
        }
        if(txtdomicilioEmpleado.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debes ingresar un domicilio", "Sistema de compras", JOptionPane.WARNING_MESSAGE);
            txtdomicilioEmpleado.requestFocus();
            return;
        }
        if(txtcpEmpleado.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debes ingresar un cp", "Sistema de compras", JOptionPane.WARNING_MESSAGE);
            txtcpEmpleado.requestFocus();
            return;
        }
        if(txtcorreoEmpleado.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debes ingresar un correo", "Sistema de compras", JOptionPane.WARNING_MESSAGE);
            txtcorreoEmpleado.requestFocus();
            return;
        }
        if(txtcontraseñaEmpleado.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debes ingresar una contraseña", "Sistema de compras", JOptionPane.WARNING_MESSAGE);
            txtcontraseñaEmpleado.requestFocus();
            return;
        }
        
            if( accion.equals("guardar"))
            {
            resp=EMPLEADOSCON.insertar(txtnombreEmpleado.getText(), txttelefonoEmpleado.getText(), txtdomicilioEmpleado.getText(), txtcpEmpleado.getText(), txtcorreoEmpleado.getText(), txtcontraseñaEmpleado.getText(), imagenEmpleado);
                if(resp.equals("OK"))
                {
                    this.mensajeOK("Registro insertado correctamente.");
                    ListarTablaEmpleados("");
                    this.Limpiar();
              
                }    
            }
            else
            {
                this.mensajeError(resp);
                txtnombreEmpleado.requestFocus();
            }
    
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
         //Cambio de paneles 
        tabEmpleados.setVisible(true);
        tabEmpComp.setVisible(false);
        Limpiar();
        ListarTablaEmpleados("");
        jtListadoEmpleados.clearSelection();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String resp;
        accion="editar";
        if(txtnombreEmpleado.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe escribir un nombre", "Papeleria Yolis", JOptionPane.WARNING_MESSAGE);
            txtnombreEmpleado.requestFocus();
            
        }
        if(txttelefonoEmpleado.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe ingresar un telefono", "Papeleria Yolis", JOptionPane.WARNING_MESSAGE);
            txttelefonoEmpleado.requestFocus();
            return;
        }
        if(txtdomicilioEmpleado.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debes ingresar un domicilio", "Papeleria Yolis", JOptionPane.WARNING_MESSAGE);
            txtdomicilioEmpleado.requestFocus();
            return;
        }
        if(txtcpEmpleado.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debes ingresar un cp", "Papeleria Yolis", JOptionPane.WARNING_MESSAGE);
            txtcpEmpleado.requestFocus();
            return;
        }
        if(txtcorreoEmpleado.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debes ingresar un correo", "Papeleria Yolis", JOptionPane.WARNING_MESSAGE);
            txtcorreoEmpleado.requestFocus();
            return;
        }
        if(txtcontraseñaEmpleado.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debes ingresar una contraseña", "Papeleria Yolis", JOptionPane.WARNING_MESSAGE);
            txtcontraseñaEmpleado.requestFocus();
            return;
        }
        
        if(accion.equals("editar"))
        {
            nombreAnterior=txtnombreEmpleado.getText();
                      resp=EMPLEADOSCON.actualizar(Integer.parseInt(txtidEmpleado.getText()),txtnombreEmpleado.getText().trim(), nombreAnterior,  txttelefonoEmpleado.getText().trim(), txtdomicilioEmpleado.getText().trim(), txtcpEmpleado.getText().trim(), txtcorreoEmpleado.getText().trim(), txtcontraseñaEmpleado.getText().trim(), imagenEmpleado);
            if(resp.equals("OK"))
            {
                this.mensajeOK("Registro actualizado correctamente.");
                ListarTablaEmpleados("");
                this.Limpiar();  
            }    
            else
            {
                this.mensajeError(resp);
                //txtNombre.requestFocus();
            }
        }  
    }//GEN-LAST:event_btnModificarActionPerformed
public void mensajeOK(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Sistema Compra-Venta", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Sistema Compra-Venta", JOptionPane.ERROR_MESSAGE);
    }
    
    
    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        String ruta;
        // 1. Crear un objeto que permita seleccionar un archivo
        JFileChooser jf = new JFileChooser();
        // 2. Establecer un filtro para la selección de imágenes
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("GIF, JPG, SVG y PNG", "gif", "jpg", "svg", "png");
        // 3. Establecer el filtro al OBJ jf
        jf.setFileFilter(filtro);
        // 4. Abrir el cuadro de diálogo
        int respuesta = jf.showOpenDialog(this);
        // 5. Validar la respuesta
        if(respuesta == JFileChooser.APPROVE_OPTION){
            //6. Obtener la ruta del archivo seleccionado
            ruta=jf.getSelectedFile().getPath();
            // 7. Obtener el nombre del archivo seleccionado
            imagenEmpleado = ruta;
            //8. Pintar la imagen que seleccionó el usuario
            pintarImagen(lblimgEmpleado2,ruta);
        }
        ruta=imagenEmpleado;
        System.out.println(imagenEmpleado);
    }//GEN-LAST:event_btnImagenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backgroun;
    private javax.swing.JLabel Backgroun1;
    private javax.swing.JButton btnActivacion1;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jtListadoEmpleados;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblEstadoEmpleado;
    private javax.swing.JLabel lblIDEmpleado;
    private javax.swing.JLabel lblNombreProveedor;
    private javax.swing.JLabel lblNombreProveedor4;
    private javax.swing.JLabel lblRegistrosMostrados;
    private javax.swing.JLabel lblcontraseñaEmpleado;
    private javax.swing.JLabel lblcorreoEmpleado;
    private javax.swing.JLabel lblcpEmpleado;
    private javax.swing.JLabel lbldomicilioEmpleado;
    private javax.swing.JLabel lblimgEmpleado;
    private javax.swing.JLabel lblimgEmpleado2;
    private javax.swing.JPanel tabEmpComp;
    private javax.swing.JPanel tabEmpleados;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtcontraseñaEmpleado;
    private javax.swing.JTextField txtcorreoEmpleado;
    private javax.swing.JTextField txtcpEmpleado;
    private javax.swing.JTextField txtdomicilioEmpleado;
    private javax.swing.JTextField txtestadoEmpleado;
    private javax.swing.JTextField txtidEmpleado;
    private javax.swing.JTextField txtnombreEmpleado;
    private javax.swing.JTextField txttelefonoEmpleado;
    // End of variables declaration//GEN-END:variables
}
