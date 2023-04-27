/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion;

import entidades.CompraDetalle;
import Negocio.ComprasControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class Compras extends javax.swing.JPanel {

    
    private final ComprasControl control;
    //private final CompraDetalleControl controldetalle;
    private int contador = 0;
    String accion;
    private int filas;
    private String[] compras = new String [6];
    private boolean encontrado=false;
    //DefaultTableModel dtmDetalle;
    DefaultTableModel dtmCompraDetalle;
    ArrayList<CompraDetalle> listacompras = new ArrayList<CompraDetalle>();
    
    public Compras() {
        initComponents();
        tabCompraDet.setVisible(false);
        tabBuscarProveedor.setVisible(false);
        tabBuscarProducto.setVisible(false);
        tabBuscarEmpleado.setVisible(false);
        control = new ComprasControl();
        accion = "guardar";
        Listar("");
        ListarTablaProv("");
        ListarTablaProd("");
        ListarTablaEmp("");
        dtmCompraDetalle = new DefaultTableModel();
        dtmCompraDetalle.addColumn("ID Producto");
        dtmCompraDetalle.addColumn("Nombre");
        dtmCompraDetalle.addColumn("Cantidad");
        dtmCompraDetalle.addColumn("Precio");
        dtmCompraDetalle.addColumn("Descuento");
        dtmCompraDetalle.addColumn("Subtotal");
        //String titulos[] = {"ID Producto","Nombre", "Cantidad", "Precio", "Descuento", "Subtotal"};
        //dtmDetalle.setColumnIdentifiers(titulos);
        this.jtListadoDetalleC.setModel(dtmCompraDetalle);
        
        txtproveedor.setEditable(false);
        txtNomProducto.setEditable(false);
        txtIdProducto.setEditable(false);
        txtPrecio.setEditable(false);
        txtSubtotalProd.setEditable(false);
        txtSubtotal.setEditable(false);
        txtiva.setEditable(false);
        txtotal.setEditable(false);
        
        txtidCompra.setVisible(false);
        txtIdProveedor.setVisible(false);
        txtIdEmpleado.setVisible(false);
        FechaActual();
    }
    
    public void ModificablesNuevo()
    {
        txtFolio.setEditable(true);
        btnConfirmarProv.setEnabled(true);
        txtDescuento.setEditable(true);
        txtFecha.setEnabled(true);
        btnConfirmarProd.setEnabled(true);
        txtcantidad.setEditable(true);
        txtDescProd.setEditable(true);
        btnAñadir.setEnabled(true);
        btnModificar.setEnabled(true);
        btnQuitarComDet.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnDespejarTabla.setEnabled(true);
        btnConfirmarEmp.setEnabled(true);
    }
    
    public void NoModificablesDetalle()
    {
        txtFolio.setEditable(false);
        btnConfirmarProv.setEnabled(false);
        txtDescuento.setEditable(false);
        txtFecha.setEnabled(false);
        btnConfirmarProd.setEnabled(false);
        txtcantidad.setEditable(false);
        txtDescProd.setEditable(false);
        btnAñadir.setEnabled(false);
        btnModificar.setEnabled(false);
        btnQuitarComDet.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnDespejarTabla.setEnabled(false);
        btnConfirmarEmp.setEnabled(false);
    }
    
    public void Listar(String texto)
    {
        jtListadoCompras1.setModel(control.Listar(texto));
        TableRowSorter modeloOrdenado = new TableRowSorter(jtListadoCompras1.getModel());
        jtListadoCompras1.setRowSorter(modeloOrdenado);
        int [] posiciones = {1, 3, 4, 6, 8};
        for(int x = 0; x<posiciones.length; x++){
            jtListadoCompras1.getColumnModel().getColumn(posiciones[x]).setMaxWidth(0);
            jtListadoCompras1.getColumnModel().getColumn(posiciones[x]).setMinWidth(0);
            jtListadoCompras1.getTableHeader().getColumnModel().getColumn(posiciones[x]).setMaxWidth(0);
            jtListadoCompras1.getTableHeader().getColumnModel().getColumn(posiciones[x]).setMinWidth(0);
        }
        //418
        int[] anchos = {30,0,78,0,0,70,0,50,0,80,40,70};
        for(int i = 0; i<jtListadoCompras1.getColumnCount(); i++)
        {
            jtListadoCompras1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }
    
    public void ListarDetalle(int idCompra){
        dtmCompraDetalle = control.ListarDetalle(idCompra);
        jtListadoDetalleC.setModel(control.ListarDetalle(idCompra));
        TableRowSorter modeloOrdenado = new TableRowSorter(jtListadoDetalleC.getModel());
    }
    
    public void ListarTablaProv(String texto)
    {
        jtProveedores.setModel(control.ListarProvedor(texto));
        TableRowSorter modeloOrdenado = new TableRowSorter(jtProveedores.getModel());
        jtProveedores.setRowSorter(modeloOrdenado);
        //540
        int[] anchos = {40,110,70,80,110,130};
        for(int i = 0; i<jtProveedores.getColumnCount(); i++)
        {
            jtProveedores.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }
    
    public void ListarTablaProd(String texto)
    {
        jtProductos.setModel(control.ListarProductos(texto));
        TableRowSorter modeloOrdenado = new TableRowSorter(jtProductos.getModel());
        jtProductos.setRowSorter(modeloOrdenado);
        int [] posiciones = {1, 6, 8};
        for(int x = 0; x<posiciones.length; x++){
            jtProductos.getColumnModel().getColumn(posiciones[x]).setMaxWidth(0);
            jtProductos.getColumnModel().getColumn(posiciones[x]).setMinWidth(0);
            jtProductos.getTableHeader().getColumnModel().getColumn(posiciones[x]).setMaxWidth(0);
            jtProductos.getTableHeader().getColumnModel().getColumn(posiciones[x]).setMinWidth(0);
        }
        //418
        int[] anchos = {20,0,200,70,45,45,0,38,0};
        for(int i = 0; i<jtProductos.getColumnCount(); i++)
        {
            jtProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }
    
    public void ListarTablaEmp(String texto)
    {
        jtEmpleado.setModel(control.ListarEmpleados(texto));
        TableRowSorter modeloOrdenado = new TableRowSorter(jtEmpleado.getModel());
        jtEmpleado.setRowSorter(modeloOrdenado);
        
        jtEmpleado.getColumnModel().getColumn(6).setMaxWidth(0);
        jtEmpleado.getColumnModel().getColumn(6).setMinWidth(0);
        jtEmpleado.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        jtEmpleado.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        //418
        int[] anchos = {20,100,80,100,60,130,0};
        for(int i = 0; i<jtEmpleado.getColumnCount(); i++)
        {
            jtEmpleado.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }
    
    /*public void ListarTablaDetalle(int idCompra)
    {
        dtmDetalle = controldetalle.Listar(idCompra);
        jtListadoDetalleC.setModel(dtmDetalle);
    }*/
    
    public void FechaActual()
    {
        //DateFormat df = DateFormat.getDateInstance();
        Date fechaActual = new Date();
        txtFecha.setDate(fechaActual);
        //txtFechas.setText(df.format(fechaActual));
    }
    
    public java.sql.Date Fecha()
    {
        //Esto traduce el formato de la fecha a una que la BD pueda aceptar
        try{
            Date f = txtFecha.getDate();
            long d = f.getTime();
            java.sql.Date fecha = new java.sql.Date(d);
            return fecha;
        }catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(this, "Ingresa una fecha valida", "Sistema de compras", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
    
    public Date FormatoF(String fechaBD)
    {
        //Esto traduce el formato de la fecha de la BD a una que jcFecha pueda aceptar
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat formatoFecha = new SimpleDateFormat("d/MM/yyyy");
        Date fecha = null;
        try{
            fecha = formatoFecha.parse(fechaBD);
        }catch(ParseException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        return fecha;
    }
    
    public void CalcularSubtotal(){
        Double precio;
        int cant;
        double porc_descuento = 0.0;
        double subtotal;
            if(txtPrecio.getText().isEmpty()){
                precio = 0.0;
            }else{
                precio = Double.parseDouble(txtPrecio.getText());
            }
            if(txtcantidad.getText().isEmpty()){
                cant = 0;
            }else{
                cant = Integer.parseInt(txtcantidad.getText());
            }
            if(txtDescProd.getText().isEmpty()){
                porc_descuento = 0.0;
            }else{
                if(!(Double.parseDouble(txtDescProd.getText())>=0 && Double.parseDouble(txtDescProd.getText())<=100)){
                    JOptionPane.showMessageDialog(this, "Debes ingresar un valor entr 0 a 100 en el descuento", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
                    txtDescProd.setText("");
                }else{
                    porc_descuento = (Double.parseDouble(txtDescProd.getText())/100.0);
                }
            }
            subtotal = cant*precio;
            subtotal = subtotal-(subtotal*porc_descuento);
            txtSubtotalProd.setText(Double.toString(subtotal));
    }
    
    public void CalcularSubtotalCompra()
    {
        int fila = 0;
        //fila = dtmDetalle.getRowCount();
        fila = jtListadoDetalleC.getRowCount();
        double descuento = 0;
        double subtotal = 0;
        double iva = 0;
        double total = 0;
        if(txtDescuento.getText().isEmpty()){
            descuento = 0.0;
        }else{
            if(!(Double.parseDouble(txtDescuento.getText())>=0 && Double.parseDouble(txtDescuento.getText())<=100)){
                JOptionPane.showMessageDialog(this, "Debes ingresar un valor entre 0 a 100 en el descuento", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
                txtDescuento.setText("");
            }else{
                descuento = (Double.parseDouble(txtDescuento.getText())/100.0);
            }
        }
        for (int f=0; f<fila; f++){
            subtotal += Double.parseDouble(String.valueOf(jtListadoDetalleC.getModel().getValueAt(f, 5))) - Double.parseDouble(String.valueOf(jtListadoDetalleC.getModel().getValueAt(f, 5)))*descuento;            
        }
        iva = subtotal*0.16;
        total = subtotal+iva;
        txtSubtotal.setText(String.valueOf(subtotal));
        txtiva.setText(String.valueOf(iva));
        txtotal.setText(String.valueOf(total));
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
        txtBusqueda.setText("");
        txtproveedor.setText("");
        txtIdProveedor.setText("");
        txtEmpleado.setText("");
        txtIdEmpleado.setText("");
        txtFolio.setText("");
        txtDescuento.setText("");
        FechaActual();
        txtNomProducto.setText("");
        txtIdProducto.setText("");
        txtcantidad.setText("");
        txtPrecio.setText("");
        txtDescProd.setText("");
        txtSubtotalProd.setText("");
        txtSubtotal.setText("");
        txtiva.setText("");
        txtotal.setText("");
        ///Esto es para limpiar despues de elegir una compra finalizada y regresar
        btnBuscarProducto.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnAñadir.setEnabled(true);
        btnModificar.setEnabled(true);
        btnQuitarComDet.setEnabled(true);
        btnDespejarTabla.setEnabled(true);
        txtDescuento.setEditable(true);
        txtcantidad.setEditable(true);
        txtDescProd.setEditable(true);
        txtFecha.setEnabled(true);
        ///////
        int fila = jtListadoDetalleC.getRowCount();
        System.out.println(fila);
        System.out.println(dtmCompraDetalle.getRowCount());
        for(int i = fila-1; i>=0; i--){
            //dtmDetalle.removeRow(i);
            dtmCompraDetalle.removeRow(i);
        }
        jtListadoDetalleC.setModel(dtmCompraDetalle);
        
    }
    
    public void AccionLimpiar()
    {
        txtNomProducto.setText("");
        txtIdProducto.setText("");
        txtcantidad.setText("");
        txtPrecio.setText("");
        txtDescProd.setText("");
        txtSubtotalProd.setText("");
        jtListadoDetalleC.clearSelection();
    }
    
    public void MetodoAñadir()
    {
        CompraDetalle cdet = new CompraDetalle();
        if(!txtIdProducto.getText().isEmpty()){
            cdet.setIdProductos(Integer.parseInt(txtIdProducto.getText()));
            cdet.setNombreProducto(txtNomProducto.getText());
            if(!txtcantidad.getText().isEmpty())
            {
                cdet.setCantidad(Integer.parseInt(txtcantidad.getText()));
                cdet.setPrecio(Double.parseDouble(txtPrecio.getText()));
                if(!txtDescProd.getText().isEmpty()){
                    cdet.setDescuento(Double.parseDouble(txtDescProd.getText()));
                    cdet.setSubtotal(Double.parseDouble(txtSubtotalProd.getText()));
                    Object a[] = new Object[6];
                    a[0] = Integer.parseInt(txtIdProducto.getText());
                    a[1] = txtNomProducto.getText();
                    a[2] = Integer.parseInt(txtcantidad.getText());
                    a[3] = Double.parseDouble(txtPrecio.getText());
                    a[4] = Double.parseDouble(txtDescProd.getText());
                    a[5] = Double.parseDouble(txtSubtotalProd.getText());
                    dtmCompraDetalle.addRow(a);
                    CalcularSubtotalCompra();
                    AccionLimpiar();
                }else{
                    JOptionPane.showMessageDialog(this, "Debes ingresar un porcentaje de descuento valido entre 0 a 100", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Debes ingresar una cantidad", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Debes elegir un producto primero", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
        }
    }
   
    private void ActualizarStockAumentado()
    {
        for(int i = 0; i < jtListadoDetalleC.getRowCount(); i++)
        {
            int idp = Integer.parseInt(String.valueOf(jtListadoDetalleC.getModel().getValueAt(i, 0)));
            int cant = Integer.parseInt(String.valueOf(jtListadoDetalleC.getModel().getValueAt(i, 2)));
            int stock = control.ObtenerStock(idp);
            int total = stock+cant;
            control.ActualizarExistenciaProd(total, idp);
        }
    }
    
    private void ActualizarStockDecrementado()
    {
        for(int i = 0; i < jtListadoDetalleC.getRowCount(); i++)
        {
            int idp = Integer.parseInt(String.valueOf(jtListadoDetalleC.getModel().getValueAt(i, 0)));
            int cant = Integer.parseInt(String.valueOf(jtListadoDetalleC.getModel().getValueAt(i, 2)));
            int stock = control.ObtenerStock(idp);
            int total = stock-cant;
            control.ActualizarExistenciaProd(total, idp);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabCompra = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        imgVendedor1 = new javax.swing.JLabel();
        Backgroun1 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        btnDetalles = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        lblBusqueda = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListadoCompras1 = new javax.swing.JTable();
        btnActivacion = new javax.swing.JButton();
        tabCompraDet = new javax.swing.JPanel();
        btnAñadir = new javax.swing.JButton();
        btnQuitarComDet = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtListadoDetalleC = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblNombreProveedor = new javax.swing.JLabel();
        txtproveedor = new javax.swing.JTextField();
        btnBuscarProveedor = new javax.swing.JButton();
        lblClaveCompra = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        lblDescuento = new javax.swing.JLabel();
        txtDescuento = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        txtidCompra = new javax.swing.JTextField();
        txtIdProveedor = new javax.swing.JTextField();
        lblNombreEmpleado = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        btnBuscarEmpleado = new javax.swing.JButton();
        txtIdEmpleado = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        lblNomProducto = new javax.swing.JLabel();
        txtNomProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        lblDescuentoCompra = new javax.swing.JLabel();
        txtDescProd = new javax.swing.JTextField();
        lblSubtotalP = new javax.swing.JLabel();
        txtSubtotalProd = new javax.swing.JTextField();
        lblidprod = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        txtotal = new javax.swing.JTextField();
        lblSubtotal = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        lbliva = new javax.swing.JLabel();
        txtiva = new javax.swing.JTextField();
        btnDespejarTabla = new javax.swing.JButton();
        tabBuscarProveedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnConfirmarProv = new javax.swing.JButton();
        btnRegresarProv = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscarProv = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProveedores = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tabBuscarProducto = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btnConfirmarProd = new javax.swing.JButton();
        btnRegresarProd = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        txtBuscarProd = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tabBuscarEmpleado = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnConfirmarEmp = new javax.swing.JButton();
        btnRegresarEmp = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        txtBuscarEmp = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtEmpleado = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(670, 460));
        setPreferredSize(new java.awt.Dimension(670, 460));

        tabCompra.setBackground(new java.awt.Color(255, 255, 255));
        tabCompra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel2.setText("Compras");
        tabCompra.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        imgVendedor1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        imgVendedor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/compras128px.png"))); // NOI18N
        tabCompra.add(imgVendedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 130, 130));

        Backgroun1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo formulario.jpg"))); // NOI18N
        tabCompra.add(Backgroun1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 170, 460));

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
        tabCompra.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 120, -1));

        btnBuscar1.setBackground(new java.awt.Color(255, 191, 117));
        btnBuscar1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscar1.setBorder(null);
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        tabCompra.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 97, 70, 20));

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
        tabCompra.add(btnDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 120, -1));
        tabCompra.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 230, 10));

        lblBusqueda.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda.setText("Busqueda");
        tabCompra.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 50, -1));

        txtBusqueda.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtBusqueda.setBorder(null);
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        tabCompra.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 230, -1));

        jtListadoCompras1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtListadoCompras1.getTableHeader().setReorderingAllowed(false);
        jtListadoCompras1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoCompras1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtListadoCompras1);

        tabCompra.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 420, 260));

        btnActivacion.setBackground(new java.awt.Color(255, 191, 117));
        btnActivacion.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnActivacion.setText("Cancelar");
        btnActivacion.setBorder(null);
        btnActivacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivacionActionPerformed(evt);
            }
        });
        tabCompra.add(btnActivacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 100, -1));

        tabCompraDet.setBackground(new java.awt.Color(255, 255, 255));
        tabCompraDet.setMinimumSize(new java.awt.Dimension(670, 460));
        tabCompraDet.setPreferredSize(new java.awt.Dimension(670, 460));
        tabCompraDet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAñadir.setBackground(new java.awt.Color(255, 191, 117));
        btnAñadir.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnAñadir.setText("Añadir");
        btnAñadir.setBorder(null);
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        tabCompraDet.add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 80, 30));

        btnQuitarComDet.setBackground(new java.awt.Color(255, 191, 117));
        btnQuitarComDet.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnQuitarComDet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnQuitarComDet.setText("Eliminar");
        btnQuitarComDet.setBorder(null);
        btnQuitarComDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarComDetActionPerformed(evt);
            }
        });
        tabCompraDet.add(btnQuitarComDet, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 80, 30));

        jtListadoDetalleC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtListadoDetalleC.getTableHeader().setReorderingAllowed(false);
        jtListadoDetalleC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoDetalleCMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtListadoDetalleC);

        tabCompraDet.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 650, 150));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNombreProveedor.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblNombreProveedor.setText("Proveedor:");

        btnBuscarProveedor.setBackground(new java.awt.Color(255, 191, 117));
        btnBuscarProveedor.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscarProveedor.setBorder(null);
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        lblClaveCompra.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblClaveCompra.setText("Folio:");

        txtFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFolioActionPerformed(evt);
            }
        });

        lblDescuento.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblDescuento.setText("% Descuento:");

        txtDescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescuentoKeyReleased(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblFecha.setText("Fecha:");

        txtFecha.setDateFormatString("d/MM/yyyy");

        txtIdProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProveedorActionPerformed(evt);
            }
        });

        lblNombreEmpleado.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblNombreEmpleado.setText("Empleado:");

        txtEmpleado.setEditable(false);

        btnBuscarEmpleado.setBackground(new java.awt.Color(255, 191, 117));
        btnBuscarEmpleado.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnBuscarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscarEmpleado.setBorder(null);
        btnBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEmpleadoActionPerformed(evt);
            }
        });

        txtIdEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtproveedor))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblClaveCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(lblDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(txtidCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblClaveCompra)
                        .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombreProveedor)
                        .addComponent(txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreEmpleado)
                            .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tabCompraDet.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 110));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNomProducto.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblNomProducto.setText("Producto:");

        btnBuscarProducto.setBackground(new java.awt.Color(255, 191, 117));
        btnBuscarProducto.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscarProducto.setBorder(null);
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        lblDescuentoCompra.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblDescuentoCompra.setText("% Descuento:");

        txtDescProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescProdKeyReleased(evt);
            }
        });

        lblSubtotalP.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblSubtotalP.setText("Subtotal:");

        lblidprod.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblidprod.setText("ID:");

        lblPrecio.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblPrecio.setText("Precio:");

        lblCantidad.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblCantidad.setText("Cantidad:");

        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcantidadKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblCantidad)
                        .addGap(4, 4, 4)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblDescuentoCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDescProd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSubtotalP, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSubtotalProd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblNomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txtNomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblidprod, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomProducto)
                    .addComponent(txtNomProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblidprod)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSubtotalP)
                        .addComponent(txtSubtotalProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCantidad)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDescuentoCompra)
                                .addComponent(txtDescProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );

        tabCompraDet.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 560, 100));

        btnGuardar.setBackground(new java.awt.Color(255, 191, 117));
        btnGuardar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnGuardar.setText("Confirmar compra");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        tabCompraDet.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 80, 40));

        btnCancelar.setBackground(new java.awt.Color(255, 191, 117));
        btnCancelar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras16px.png"))); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.setBorder(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        tabCompraDet.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 80, 40));

        btnModificar.setBackground(new java.awt.Color(255, 191, 117));
        btnModificar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setBorder(null);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        tabCompraDet.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 80, 30));

        lblTotal.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblTotal.setText("TOTAL:");
        tabCompraDet.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 80, 30));

        txtotal.setText("0.0");
        tabCompraDet.add(txtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 70, 30));

        lblSubtotal.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblSubtotal.setText("Subtotal c/Desc. Gen. :");
        tabCompraDet.add(lblSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 190, 30));

        txtSubtotal.setText("0.0");
        tabCompraDet.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 60, 30));

        lbliva.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lbliva.setText("Iva:");
        tabCompraDet.add(lbliva, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 40, 30));

        txtiva.setText("0.0");
        tabCompraDet.add(txtiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 60, 30));

        btnDespejarTabla.setBackground(new java.awt.Color(255, 191, 117));
        btnDespejarTabla.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnDespejarTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnDespejarTabla.setText("Despejar");
        btnDespejarTabla.setBorder(null);
        btnDespejarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDespejarTablaActionPerformed(evt);
            }
        });
        tabCompraDet.add(btnDespejarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 100, 30));

        tabBuscarProveedor.setBackground(new java.awt.Color(255, 255, 255));
        tabBuscarProveedor.setMinimumSize(new java.awt.Dimension(670, 460));
        tabBuscarProveedor.setPreferredSize(new java.awt.Dimension(670, 460));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel3.setText("Buscar Proveedor");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        btnConfirmarProv.setBackground(new java.awt.Color(255, 191, 117));
        btnConfirmarProv.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnConfirmarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnConfirmarProv.setText("Confirmar compra");
        btnConfirmarProv.setBorder(null);
        btnConfirmarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarProvActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmarProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 80, 40));

        btnRegresarProv.setBackground(new java.awt.Color(255, 191, 117));
        btnRegresarProv.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnRegresarProv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        btnRegresarProv.setText("Regresar");
        btnRegresarProv.setBorder(null);
        btnRegresarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarProvActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresarProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 210, -1));

        txtBuscarProv.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        txtBuscarProv.setBorder(null);
        txtBuscarProv.setBackground(new java.awt.Color(0,0,0,1));
        txtBuscarProv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProvKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscarProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 210, 30));

        jtProveedores.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jtProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtProveedores.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtProveedores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 540, 290));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel4.setText("Buscar");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 460));

        javax.swing.GroupLayout tabBuscarProveedorLayout = new javax.swing.GroupLayout(tabBuscarProveedor);
        tabBuscarProveedor.setLayout(tabBuscarProveedorLayout);
        tabBuscarProveedorLayout.setHorizontalGroup(
            tabBuscarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabBuscarProveedorLayout.setVerticalGroup(
            tabBuscarProveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabBuscarProducto.setBackground(new java.awt.Color(255, 255, 255));
        tabBuscarProducto.setMinimumSize(new java.awt.Dimension(670, 460));
        tabBuscarProducto.setPreferredSize(new java.awt.Dimension(670, 460));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel5.setText("Buscar Producto");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        btnConfirmarProd.setBackground(new java.awt.Color(255, 191, 117));
        btnConfirmarProd.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnConfirmarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnConfirmarProd.setText("Confirmar compra");
        btnConfirmarProd.setBorder(null);
        btnConfirmarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarProdActionPerformed(evt);
            }
        });
        jPanel2.add(btnConfirmarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 80, 40));

        btnRegresarProd.setBackground(new java.awt.Color(255, 191, 117));
        btnRegresarProd.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnRegresarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        btnRegresarProd.setText("Regresar");
        btnRegresarProd.setBorder(null);
        btnRegresarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarProdActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegresarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 40));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 210, -1));

        txtBuscarProd.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        txtBuscarProd.setBorder(null);
        txtBuscarProv.setBackground(new java.awt.Color(0,0,0,1));
        txtBuscarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarProdActionPerformed(evt);
            }
        });
        txtBuscarProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProdKeyReleased(evt);
            }
        });
        jPanel2.add(txtBuscarProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 210, 30));

        jtProductos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtProductos.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtProductos);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 540, 290));

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel6.setText("Buscar");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, 30));
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 460));

        javax.swing.GroupLayout tabBuscarProductoLayout = new javax.swing.GroupLayout(tabBuscarProducto);
        tabBuscarProducto.setLayout(tabBuscarProductoLayout);
        tabBuscarProductoLayout.setHorizontalGroup(
            tabBuscarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabBuscarProductoLayout.setVerticalGroup(
            tabBuscarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabBuscarEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        tabBuscarEmpleado.setMinimumSize(new java.awt.Dimension(670, 460));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel8.setText("Buscar Empleado");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        btnConfirmarEmp.setBackground(new java.awt.Color(255, 191, 117));
        btnConfirmarEmp.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnConfirmarEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnConfirmarEmp.setText("Confirmar compra");
        btnConfirmarEmp.setBorder(null);
        btnConfirmarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarEmpActionPerformed(evt);
            }
        });
        jPanel4.add(btnConfirmarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 80, 40));

        btnRegresarEmp.setBackground(new java.awt.Color(255, 191, 117));
        btnRegresarEmp.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnRegresarEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        btnRegresarEmp.setText("Regresar");
        btnRegresarEmp.setBorder(null);
        btnRegresarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarEmpActionPerformed(evt);
            }
        });
        jPanel4.add(btnRegresarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 40));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 210, -1));

        txtBuscarEmp.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        txtBuscarEmp.setBorder(null);
        txtBuscarProv.setBackground(new java.awt.Color(0,0,0,1));
        txtBuscarEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarEmpActionPerformed(evt);
            }
        });
        txtBuscarEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarEmpKeyReleased(evt);
            }
        });
        jPanel4.add(txtBuscarEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 210, 30));

        jtEmpleado.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jtEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtEmpleado.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jtEmpleado);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 540, 290));

        jLabel9.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel9.setText("Buscar");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, 30));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 460));

        javax.swing.GroupLayout tabBuscarEmpleadoLayout = new javax.swing.GroupLayout(tabBuscarEmpleado);
        tabBuscarEmpleado.setLayout(tabBuscarEmpleadoLayout);
        tabBuscarEmpleadoLayout.setHorizontalGroup(
            tabBuscarEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabBuscarEmpleadoLayout.setVerticalGroup(
            tabBuscarEmpleadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1245, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(tabCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(tabCompraDet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(tabCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(tabCompraDet, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tabCompra.setVisible(false);
        tabCompraDet.setVisible(true);
        ModificablesNuevo();
        accion = "guardar";
        btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        if(jtListadoCompras1.getSelectedRowCount()==1){
            txtidCompra.setText(jtListadoCompras1.getValueAt(jtListadoCompras1.getSelectedRow(), 0).toString());
            txtIdProveedor.setText(jtListadoCompras1.getValueAt(jtListadoCompras1.getSelectedRow(), 1).toString());
            txtproveedor.setText(jtListadoCompras1.getValueAt(jtListadoCompras1.getSelectedRow(), 2).toString());
            txtIdEmpleado.setText(jtListadoCompras1.getValueAt(jtListadoCompras1.getSelectedRow(), 3).toString());
            txtEmpleado.setText(jtListadoCompras1.getValueAt(jtListadoCompras1.getSelectedRow(), 4).toString());
            txtFolio.setText(jtListadoCompras1.getValueAt(jtListadoCompras1.getSelectedRow(), 5).toString());
            txtDescuento.setText(jtListadoCompras1.getValueAt(jtListadoCompras1.getSelectedRow(), 6).toString());
            txtSubtotal.setText(jtListadoCompras1.getValueAt(jtListadoCompras1.getSelectedRow(), 7).toString());
            txtiva.setText(jtListadoCompras1.getValueAt(jtListadoCompras1.getSelectedRow(), 8).toString());
            txtFecha.setDate(FormatoF(jtListadoCompras1.getValueAt(jtListadoCompras1.getSelectedRow(), 9).toString()));
            txtotal.setText(jtListadoCompras1.getValueAt(jtListadoCompras1.getSelectedRow(), 10).toString());

            //cambio de tabs
            tabCompra.setVisible(false);
            tabCompraDet.setVisible(true);
            NoModificablesDetalle();
            ListarDetalle(Integer.parseInt(txtidCompra.getText()));

        }else{
            JOptionPane.showMessageDialog(this, "Debes elegir una compra primero", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        int fila = 0;
        boolean ban = false;
        if(jtListadoDetalleC.getSelectedRowCount()>=1){
            int idtabla = Integer.parseInt(String.valueOf(jtListadoDetalleC.getModel().getValueAt(jtListadoDetalleC.getSelectedRow(), 0)));
            fila = jtListadoDetalleC.getRowCount();
            int idprod = Integer.parseInt(String.valueOf(txtIdProducto.getText()));
            if(fila > 0){
                for (int f=0; f<fila; f++){
                if(idprod == idtabla){
                    JOptionPane.showMessageDialog(this, "Este producto ya esta ingresado como registro de la compra", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
                    ban = false;
                    break;
                }
                ban = true;
                }
            }else{
                ban = true;
            }
            if(ban == true){
                MetodoAñadir();
            }
        }else{
            MetodoAñadir();
        }
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String resp;
        String fecha;
        if(txtIdProveedor.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe ingresar a un proveedor", "Sistema de compras", JOptionPane.WARNING_MESSAGE);
            txtproveedor.requestFocus();
            return;
        }
        if(txtFolio.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe ingresar la clave de la compra", "Sistema de compras", JOptionPane.WARNING_MESSAGE);
            txtFolio.requestFocus();
            return;
        }
        if(txtDescuento.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe ingresar un porcentaje de descuento valido entre 0 a 100", "Sistema de compras", JOptionPane.WARNING_MESSAGE);
            txtDescuento.requestFocus();
            return;
        }
        if(dtmCompraDetalle.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Debes tener por lo menos un producto en el registro", "Sistema de compras", JOptionPane.WARNING_MESSAGE);
            return;
        }
        fecha = Fecha().toString();
        if(fecha == null){
            txtFecha.requestFocus();
            return;
        }
        //codigo de guardar o insertar
        resp=control.Insertar(txtFolio.getText().trim(), Double.parseDouble(txtDescuento.getText()), Double.parseDouble(txtSubtotal.getText()), Double.parseDouble(txtiva.getText()), fecha, Double.parseDouble(txtotal.getText()), dtmCompraDetalle);
        if(resp.equals("OK")){
            control.InsertarEmp_Com(control.RegresaeIDCompra(txtFolio.getText().trim()), Integer.parseInt(txtIdEmpleado.getText()));
            control.InsertarProv_Comp(control.RegresaeIDCompra(txtFolio.getText().trim()), Integer.parseInt(txtIdProveedor.getText()));
            MensajeOK("Compra registrada correctamente");
            Listar("");
            tabCompra.setVisible(true);
            tabCompraDet.setVisible(false);
            jtListadoCompras1.clearSelection();
            jtListadoDetalleC.clearSelection();
            ActualizarStockAumentado();
            ListarTablaProd("");
            /////
            Limpiar();
            /////
        }else{
            MensajeError(resp);
        }
            //}
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        tabCompra.setVisible(true);
        tabCompraDet.setVisible(false);
        Limpiar();
        Listar("");
        jtListadoCompras1.clearSelection();
        jtListadoDetalleC.clearSelection();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnQuitarComDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarComDetActionPerformed
        int fila = jtListadoDetalleC.getSelectedRow();
        //if(fila>=0){
        if(jtListadoDetalleC.getSelectedRowCount()==1){
            dtmCompraDetalle.removeRow(fila);
            CalcularSubtotalCompra();
            AccionLimpiar();
        }else{
            JOptionPane.showMessageDialog(this, "Debes elegir a un registro de la compra", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnQuitarComDetActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(jtListadoDetalleC.getSelectedRowCount()==1){
            Object a[] = new Object[6];
                a[0] = Integer.parseInt(txtIdProducto.getText());
                a[1] = txtNomProducto.getText();
                a[2] = Integer.parseInt(txtcantidad.getText());
                a[3] = Double.parseDouble(txtPrecio.getText());
                a[4] = Double.parseDouble(txtDescProd.getText());
                a[5] = Double.parseDouble(txtSubtotalProd.getText());
                for(int i=0; i<jtListadoDetalleC.getColumnCount(); i++){
                    dtmCompraDetalle.setValueAt(a[i], filas, i);
                }
            CalcularSubtotalCompra();
            AccionLimpiar();
        }else{
            JOptionPane.showMessageDialog(this, "Debes elegir a un registro de la compra para modificarlo", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        Listar(txtBusqueda.getText().trim());
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        tabBuscarProveedor.setVisible(true);
        tabCompraDet.setVisible(false);
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void txtBuscarProvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProvKeyReleased
        //controlprov.Listar(txtBusqueda.getText().trim());
        ListarTablaProv(txtBuscarProv.getText().trim());
    }//GEN-LAST:event_txtBuscarProvKeyReleased

    private void btnRegresarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarProvActionPerformed
        tabBuscarProveedor.setVisible(false);
        ListarTablaProv("");
        txtBuscarProv.setText("");
        tabCompraDet.setVisible(true);
        jtProveedores.clearSelection();
    }//GEN-LAST:event_btnRegresarProvActionPerformed

    private void btnConfirmarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarProvActionPerformed
        if(jtProveedores.getSelectedRowCount()==1){
            txtIdProveedor.setText(jtProveedores.getValueAt(jtProveedores.getSelectedRow(), 0).toString());
            txtproveedor.setText(jtProveedores.getValueAt(jtProveedores.getSelectedRow(), 1).toString());
            tabBuscarProveedor.setVisible(false);
            tabCompraDet.setVisible(true);
            jtProveedores.clearSelection();
        }else{
            JOptionPane.showMessageDialog(this, "Debes elegir un proveedor", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarProvActionPerformed

    private void btnConfirmarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarProdActionPerformed
        int fila = 0;
        boolean ban = false;
        if(jtProductos.getSelectedRowCount()==1){
            int idtabProd = Integer.parseInt(String.valueOf(jtProductos.getValueAt(jtProductos.getSelectedRow(), 0)));
            fila = dtmCompraDetalle.getRowCount();
            if(fila > 0){
                for (int f=0; f<fila; f++){
                int idtabDet = Integer.parseInt(String.valueOf(jtListadoDetalleC.getModel().getValueAt(f, 0)));
                if(idtabDet == idtabProd){
                    JOptionPane.showMessageDialog(this, "Este producto ya esta ingresado en como registro de la compra", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
                    ban = false;
                    break;
                }
                ban = true;
                }
            }else{
                ban = true;
            }
            if(ban == true){
                txtIdProducto.setText(jtProductos.getValueAt(jtProductos.getSelectedRow(), 0).toString());
                txtNomProducto.setText(jtProductos.getValueAt(jtProductos.getSelectedRow(), 2).toString());
                txtPrecio.setText(jtProductos.getValueAt(jtProductos.getSelectedRow(), 5).toString());
                tabBuscarProducto.setVisible(false);
                tabCompraDet.setVisible(true);
                jtProductos.clearSelection();
                CalcularSubtotal();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Debes elegir un producto", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarProdActionPerformed

    private void btnRegresarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarProdActionPerformed
        tabBuscarProducto.setVisible(false);
        ListarTablaProd("");
        txtBuscarProd.setText("");
        tabCompraDet.setVisible(true);
        jtProductos.clearSelection();
    }//GEN-LAST:event_btnRegresarProdActionPerformed

    private void txtBuscarProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProdKeyReleased
        ListarTablaProd(txtBuscarProd.getText().trim());
    }//GEN-LAST:event_txtBuscarProdKeyReleased

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        tabBuscarProducto.setVisible(true);
        tabCompraDet.setVisible(false);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void txtIdProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProveedorActionPerformed

    private void txtcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyReleased
        try{
            CalcularSubtotal();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Debes ingresar un numero positivo en la cantidad", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
            txtcantidad.setText("");
        }
    }//GEN-LAST:event_txtcantidadKeyReleased

    private void txtDescProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescProdKeyReleased
        try{
            CalcularSubtotal();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Debes ingresar un valor valido en descuento", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
            txtDescProd.setText("");
        }
    }//GEN-LAST:event_txtDescProdKeyReleased

    private void btnDespejarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDespejarTablaActionPerformed
        int fila = jtListadoDetalleC.getRowCount();
        System.out.println(fila);
        System.out.println(dtmCompraDetalle.getRowCount());
        for(int i=fila-1; i>=0; i--){
            dtmCompraDetalle.removeRow(i);
        }
        CalcularSubtotalCompra();
        AccionLimpiar();
    }//GEN-LAST:event_btnDespejarTablaActionPerformed

    private void txtDescuentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescuentoKeyReleased
        try{
            CalcularSubtotalCompra();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Debes ingresar un valor valido en el descuento global de la compra", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
            txtDescuento.setText("");
        }
    }//GEN-LAST:event_txtDescuentoKeyReleased

    private void jtListadoDetalleCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoDetalleCMouseClicked
        int seleccion = jtListadoDetalleC.getSelectedRow();
        txtIdProducto.setText(jtListadoDetalleC.getValueAt(seleccion, 0).toString());
        txtNomProducto.setText(jtListadoDetalleC.getValueAt(seleccion, 1).toString());
        txtcantidad.setText(jtListadoDetalleC.getValueAt(seleccion, 2).toString());
        txtPrecio.setText(jtListadoDetalleC.getValueAt(seleccion, 3).toString());
        txtDescProd.setText(jtListadoDetalleC.getValueAt(seleccion, 4).toString());
        txtSubtotalProd.setText(jtListadoDetalleC.getValueAt(seleccion, 5).toString());
        filas = seleccion;
    }//GEN-LAST:event_jtListadoDetalleCMouseClicked

    private void btnActivacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivacionActionPerformed
        String resp;
        if(jtListadoCompras1.getSelectedRowCount()==1){
            //obtener id
            int id = Integer.parseInt(jtListadoCompras1.getValueAt(jtListadoCompras1.getSelectedRow(), 0).toString());
            //if(JOptionPane.showConfirmDialog(this, "Deseas activar la categoria " + txtnombre.getText(), "Sistema de compras-ventas", JOptionPane.YES_NO_OPTION)==0){
                resp = control.Cancelar(id);
                if(resp.equals("OK"))
                {
                    MensajeOK("Compra cancelada");
                    ListarDetalle(id);
                    ActualizarStockDecrementado();
                    Limpiar();
                    Listar("");
                    ListarTablaProd("");
                }else{
                    MensajeError(resp);
                }
        }else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro", "Sistema compra ventas", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnActivacionActionPerformed

    private void jtListadoCompras1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoCompras1MouseClicked
        String estatus = jtListadoCompras1.getValueAt(jtListadoCompras1.getSelectedRow(), 11).toString();
        if(estatus.equals("Cancelada")){
            btnActivacion.setEnabled(false);
        }else{
            btnActivacion.setEnabled(true);
        }
    }//GEN-LAST:event_jtListadoCompras1MouseClicked

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        Listar(txtBusqueda.getText().trim());
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void txtFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFolioActionPerformed

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        tabBuscarEmpleado.setVisible(true);
        tabCompraDet.setVisible(false);
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void txtIdEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEmpleadoActionPerformed

    private void btnConfirmarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarEmpActionPerformed
        if(jtEmpleado.getSelectedRowCount()==1){
            txtIdEmpleado.setText(jtEmpleado.getValueAt(jtEmpleado.getSelectedRow(), 0).toString());
            txtEmpleado.setText(jtEmpleado.getValueAt(jtEmpleado.getSelectedRow(), 1).toString());
            tabBuscarEmpleado.setVisible(false);
            tabCompraDet.setVisible(true);
            jtEmpleado.clearSelection();
        }else{
            JOptionPane.showMessageDialog(this, "Debes elegir al empleado que realizo la compra", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarEmpActionPerformed

    private void btnRegresarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarEmpActionPerformed
        tabBuscarEmpleado.setVisible(false);
        ListarTablaProd("");
        txtBuscarEmp.setText("");
        tabCompraDet.setVisible(true);
        jtEmpleado.clearSelection();
    }//GEN-LAST:event_btnRegresarEmpActionPerformed

    private void txtBuscarEmpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarEmpKeyReleased
        ListarTablaEmp(txtBuscarEmp.getText().trim());
    }//GEN-LAST:event_txtBuscarEmpKeyReleased

    private void txtBuscarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarEmpActionPerformed

    private void txtBuscarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarProdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backgroun1;
    private javax.swing.JButton btnActivacion;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmarEmp;
    private javax.swing.JButton btnConfirmarProd;
    private javax.swing.JButton btnConfirmarProv;
    private javax.swing.JButton btnDespejarTabla;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitarComDet;
    private javax.swing.JButton btnRegresarEmp;
    private javax.swing.JButton btnRegresarProd;
    private javax.swing.JButton btnRegresarProv;
    private javax.swing.JLabel imgVendedor1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTable jtEmpleado;
    private javax.swing.JTable jtListadoCompras1;
    private javax.swing.JTable jtListadoDetalleC;
    private javax.swing.JTable jtProductos;
    private javax.swing.JTable jtProveedores;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblClaveCompra;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblDescuentoCompra;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNomProducto;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblNombreProveedor;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblSubtotalP;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblidprod;
    private javax.swing.JLabel lbliva;
    private javax.swing.JPanel tabBuscarEmpleado;
    private javax.swing.JPanel tabBuscarProducto;
    private javax.swing.JPanel tabBuscarProveedor;
    private javax.swing.JPanel tabCompra;
    private javax.swing.JPanel tabCompraDet;
    private javax.swing.JTextField txtBuscarEmp;
    private javax.swing.JTextField txtBuscarProd;
    private javax.swing.JTextField txtBuscarProv;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtDescProd;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtEmpleado;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtIdProveedor;
    private javax.swing.JTextField txtNomProducto;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtSubtotalProd;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtidCompra;
    private javax.swing.JTextField txtiva;
    private javax.swing.JTextField txtotal;
    private javax.swing.JTextField txtproveedor;
    // End of variables declaration//GEN-END:variables
}
