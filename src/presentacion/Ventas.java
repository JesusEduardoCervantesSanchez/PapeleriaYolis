/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package presentacion;


import negocio.VentasControl;
import entidades.Pro_Ven;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author CSJesus
 */
public class Ventas extends javax.swing.JPanel {

    private final VentasControl control;
    //private final CompraDetalleControl controldetalle;
    private int contador = 0;
    String accion;
    private int filas;
    private String[] ventas = new String[6];
    private boolean encontrado = false;
    //DefaultTableModel dtmDetalle;
    DefaultTableModel dtmVentaDetalle;
    ArrayList<Pro_Ven> listacompras = new ArrayList<Pro_Ven>();

    public Ventas() {
        initComponents();
        tabVentaDet.setVisible(false);
        tabBuscarCliente.setVisible(false);
        tabBuscarProducto.setVisible(false);
        tabBuscarEmpleado.setVisible(false);
        control = new VentasControl();
        accion = "guardar";
        Listar("");
        ListarTablaCli("");
        ListarTablaProd("");
        ListarTablaEmp("");
        //"ID Venta", "ID Prodcuto", "Producto", "Existencia", "Cantidad", "Precio", "SubTotal"
        dtmVentaDetalle = new DefaultTableModel();
        dtmVentaDetalle.addColumn("ID Producto");
        dtmVentaDetalle.addColumn("Nombre");
        dtmVentaDetalle.addColumn("Cantidad");
        dtmVentaDetalle.addColumn("Precio");
        dtmVentaDetalle.addColumn("Subtotal");
        //String titulos[] = {"ID Producto","Nombre", "Cantidad", "Precio", "Descuento", "Subtotal"};
        //dtmDetalle.setColumnIdentifiers(titulos);
        this.jtListadoDetalleV.setModel(dtmVentaDetalle);

        txtcliente.setEditable(false);
        txtNomProducto.setEditable(false);
        txtIdProducto.setEditable(false);
        txtPrecio.setEditable(false);
        txtSubtotalProd.setEditable(false);
        txtSubtotal.setEditable(false);
        txtiva.setEditable(false);
        txtotal.setEditable(false);

        txtidVenta.setVisible(false);
        txtIdCliente.setVisible(false);
        txtIdEmpleado.setVisible(false);
    }

    public void ModificablesNuevo() {
        txtFolio.setEditable(true);
        btnConfirmarCli.setEnabled(true);
        btnConfirmarProd.setEnabled(true);
        txtcantidad.setEditable(true);
        btnAñadir.setEnabled(true);
        btnModificar.setEnabled(true);
        btnQuitarVenDet.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnDespejarTabla.setEnabled(true);
        btnConfirmarEmp.setEnabled(true);
    }

    public void NoModificablesDetalle() {
        txtFolio.setEditable(false);
        btnConfirmarCli.setEnabled(false);
        btnConfirmarProd.setEnabled(false);
        txtcantidad.setEditable(false);
        btnAñadir.setEnabled(false);
        btnModificar.setEnabled(false);
        btnQuitarVenDet.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnDespejarTabla.setEnabled(false);
        btnConfirmarEmp.setEnabled(false);
    }

    public void Listar(String texto) {
        jtListadoVentas1.setModel(control.listar(texto));
        TableRowSorter modeloOrdenado = new TableRowSorter(jtListadoVentas1.getModel());
        jtListadoVentas1.setRowSorter(modeloOrdenado);
        int[] posiciones = {1, 3, 4,};
        for (int x = 0; x < posiciones.length; x++) {
            jtListadoVentas1.getColumnModel().getColumn(posiciones[x]).setMaxWidth(0);
            jtListadoVentas1.getColumnModel().getColumn(posiciones[x]).setMinWidth(0);
            jtListadoVentas1.getTableHeader().getColumnModel().getColumn(posiciones[x]).setMaxWidth(0);
            jtListadoVentas1.getTableHeader().getColumnModel().getColumn(posiciones[x]).setMinWidth(0);
        }
        //418
        int[] anchos = {30, 0, 78, 0, 0, 70, 0, 50, 0, 80, 40, 70};
        for (int i = 0; i < jtListadoVentas1.getColumnCount(); i++) {
            jtListadoVentas1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    public void ListarDetalle(int idCompra) {
        dtmVentaDetalle = control.listarDetalle(idCompra);
        jtListadoDetalleV.setModel(control.listarDetalle(idCompra));
        TableRowSorter modeloOrdenado = new TableRowSorter(jtListadoDetalleV.getModel());
    }

    public void ListarTablaCli(String texto) {
        jtClientes.setModel(control.ListarCliente(texto));
        TableRowSorter modeloOrdenado = new TableRowSorter(jtClientes.getModel());
        jtClientes.setRowSorter(modeloOrdenado);
        //540
        int[] anchos = {40, 110, 70, 80, 110, 130};
        for (int i = 0; i < jtClientes.getColumnCount(); i++) {
            jtClientes.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    public void ListarTablaProd(String texto) {
        jtProductos.setModel(control.ListarProductos(texto));
        TableRowSorter modeloOrdenado = new TableRowSorter(jtProductos.getModel());
        jtProductos.setRowSorter(modeloOrdenado);
        int[] posiciones = {1, 5, 8};
        for (int x = 0; x < posiciones.length; x++) {
            jtProductos.getColumnModel().getColumn(posiciones[x]).setMaxWidth(0);
            jtProductos.getColumnModel().getColumn(posiciones[x]).setMinWidth(0);
            jtProductos.getTableHeader().getColumnModel().getColumn(posiciones[x]).setMaxWidth(0);
            jtProductos.getTableHeader().getColumnModel().getColumn(posiciones[x]).setMinWidth(0);
        }
        //418
        int[] anchos = {20, 0, 200, 70, 45, 45, 0, 38, 0};
        for (int i = 0; i < jtProductos.getColumnCount(); i++) {
            jtProductos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    public void ListarTablaEmp(String texto) {
        jtEmpleado.setModel(control.ListarEmpleados(texto));
        TableRowSorter modeloOrdenado = new TableRowSorter(jtEmpleado.getModel());
        jtEmpleado.setRowSorter(modeloOrdenado);

        jtEmpleado.getColumnModel().getColumn(6).setMaxWidth(0);
        jtEmpleado.getColumnModel().getColumn(6).setMinWidth(0);
        jtEmpleado.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
        jtEmpleado.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
        //418
        int[] anchos = {20, 100, 80, 100, 60, 130, 0};
        for (int i = 0; i < jtEmpleado.getColumnCount(); i++) {
            jtEmpleado.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    /*public void ListarTablaDetalle(int idCompra)
    {
        dtmDetalle = controldetalle.Listar(idCompra);
        jtListadoDetalleC.setModel(dtmDetalle);
    }*/
    public void CalcularSubtotal() {
        Double precio;
        int cant;
        double subtotal;
        if (txtPrecio.getText().isEmpty()) {
            precio = 0.0;
        } else {
            precio = Double.parseDouble(txtPrecio.getText());
        }
        if (txtcantidad.getText().isEmpty()) {
            cant = 0;
        } else {
            cant = Integer.parseInt(txtcantidad.getText());
        }
        subtotal = cant * precio;
        txtSubtotalProd.setText(Double.toString(subtotal));
    }

    public void CalcularSubtotalVenta() {
        int fila = 0;
        //fila = dtmDetalle.getRowCount();
        fila = jtListadoDetalleV.getRowCount();
        double descuento = 0;
        double subtotal = 0;
        double iva = 0;
        double total = 0;
        for (int f = 0; f < fila; f++) {
            subtotal += Double.parseDouble(String.valueOf(jtListadoDetalleV.getModel().getValueAt(f, 4)));
        }
        iva = subtotal * 0.16;
        total = subtotal + iva;
        txtSubtotal.setText(String.valueOf(subtotal));
        txtiva.setText(String.valueOf(iva));
        txtotal.setText(String.valueOf(total));
    }

    public void MensajeOK(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Ventas", JOptionPane.INFORMATION_MESSAGE);
    }

    public void MensajeError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Ventas", JOptionPane.ERROR_MESSAGE);
    }

    public void Limpiar() {
        txtBusqueda.setText("");
        txtcliente.setText("");
        txtIdCliente.setText("");
        txtEmpleado.setText("");
        txtIdEmpleado.setText("");
        txtFolio.setText("");
        txtNomProducto.setText("");
        txtIdProducto.setText("");
        txtcantidad.setText("");
        txtPrecio.setText("");
        txtSubtotalProd.setText("");
        txtSubtotal.setText("");
        txtiva.setText("");
        txtotal.setText("");
        ///Esto es para limpiar despues de elegir una compra finalizada y regresar
        btnBuscarProducto.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnAñadir.setEnabled(true);
        btnModificar.setEnabled(true);
        btnQuitarVenDet.setEnabled(true);
        btnDespejarTabla.setEnabled(true);
        txtcantidad.setEditable(true);
        ///////
        int fila = jtListadoDetalleV.getRowCount();
        System.out.println(fila);
        System.out.println(dtmVentaDetalle.getRowCount());
        for (int i = fila - 1; i >= 0; i--) {
            //dtmDetalle.removeRow(i);
            dtmVentaDetalle.removeRow(i);
        }
        jtListadoDetalleV.setModel(dtmVentaDetalle);

    }

    public void AccionLimpiar() {
        txtNomProducto.setText("");
        txtIdProducto.setText("");
        txtcantidad.setText("");
        txtPrecio.setText("");
        txtSubtotalProd.setText("");
        jtListadoDetalleV.clearSelection();
    }

    public void MetodoAñadir() {
        Pro_Ven cdet = new Pro_Ven();
        if (!txtIdProducto.getText().isEmpty()) {
            cdet.setIdProductos(Integer.parseInt(txtIdProducto.getText()));
            cdet.setNombreProducto(txtNomProducto.getText());
            if (!txtcantidad.getText().isEmpty()) {
                cdet.setCantProVen(Integer.parseInt(txtcantidad.getText()));
                cdet.setPrecioU(Double.parseDouble(txtPrecio.getText()));
                cdet.setSubTotal(Double.parseDouble(txtSubtotalProd.getText()));
                Object a[] = new Object[5];
                a[0] = Integer.parseInt(txtIdProducto.getText());
                a[1] = txtNomProducto.getText();
                a[2] = Integer.parseInt(txtcantidad.getText());
                a[3] = Double.parseDouble(txtPrecio.getText());
                a[4] = Double.parseDouble(txtSubtotalProd.getText());
                dtmVentaDetalle.addRow(a);
                CalcularSubtotalVenta();
                AccionLimpiar();

            } else {
                JOptionPane.showMessageDialog(this, "Debes ingresar una cantidad", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes elegir un producto primero", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ActualizarStockDecrementado() {
        for (int i = 0; i < jtListadoDetalleV.getRowCount(); i++) {
            int idp = Integer.parseInt(String.valueOf(jtListadoDetalleV.getModel().getValueAt(i, 0)));
            int cant = Integer.parseInt(String.valueOf(jtListadoDetalleV.getModel().getValueAt(i, 4)));
            int stock = control.ObtenerStock(idp);
            int total = stock - cant;
            control.ActualizarExistenciaProd(total, idp);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabVenta = new javax.swing.JPanel();
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
        jtListadoVentas1 = new javax.swing.JTable();
        tabVentaDet = new javax.swing.JPanel();
        btnAñadir = new javax.swing.JButton();
        btnQuitarVenDet = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtListadoDetalleV = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblNombreProveedor = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        lblClaveCompra = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        txtidVenta = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        lblNombreEmpleado = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        btnBuscarEmpleado = new javax.swing.JButton();
        txtIdEmpleado = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        lblNomProducto = new javax.swing.JLabel();
        txtNomProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
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
        tabBuscarCliente = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnConfirmarCli = new javax.swing.JButton();
        btnRegresarCli = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscarCli = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
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

        tabVenta.setBackground(new java.awt.Color(255, 255, 255));
        tabVenta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel2.setText("Ventas");
        tabVenta.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        imgVendedor1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        imgVendedor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventas.png"))); // NOI18N
        tabVenta.add(imgVendedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 130, 130));

        Backgroun1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo formulario.jpg"))); // NOI18N
        tabVenta.add(Backgroun1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 170, 460));

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
        tabVenta.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 120, -1));

        btnBuscar1.setBackground(new java.awt.Color(255, 191, 117));
        btnBuscar1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscar1.setBorder(null);
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        tabVenta.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 97, 70, 20));

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
        tabVenta.add(btnDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 120, -1));
        tabVenta.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 230, 10));

        lblBusqueda.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda.setText("Busqueda");
        tabVenta.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 50, -1));

        txtBusqueda.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtBusqueda.setBorder(null);
        txtBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaActionPerformed(evt);
            }
        });
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        tabVenta.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 230, -1));

        jtListadoVentas1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtListadoVentas1.getTableHeader().setReorderingAllowed(false);
        jtListadoVentas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoVentas1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtListadoVentas1);

        tabVenta.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 420, 260));

        tabVentaDet.setBackground(new java.awt.Color(255, 255, 255));
        tabVentaDet.setMinimumSize(new java.awt.Dimension(670, 460));
        tabVentaDet.setPreferredSize(new java.awt.Dimension(670, 460));
        tabVentaDet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tabVentaDet.add(btnAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 80, 30));

        btnQuitarVenDet.setBackground(new java.awt.Color(255, 191, 117));
        btnQuitarVenDet.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnQuitarVenDet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnQuitarVenDet.setText("Eliminar");
        btnQuitarVenDet.setBorder(null);
        btnQuitarVenDet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarVenDetActionPerformed(evt);
            }
        });
        tabVentaDet.add(btnQuitarVenDet, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 80, 30));

        jtListadoDetalleV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtListadoDetalleV.getTableHeader().setReorderingAllowed(false);
        jtListadoDetalleV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoDetalleVMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtListadoDetalleV);

        tabVentaDet.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 650, 150));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNombreProveedor.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblNombreProveedor.setText("Cliente:");

        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });

        btnBuscarCliente.setBackground(new java.awt.Color(255, 191, 117));
        btnBuscarCliente.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscarCliente.setBorder(null);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        lblClaveCompra.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblClaveCompra.setText("Folio:");

        txtFolio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFolioActionPerformed(evt);
            }
        });

        txtidVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidVentaActionPerformed(evt);
            }
        });

        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
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
                        .addComponent(txtcliente))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblNombreEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblClaveCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(txtidVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblClaveCompra)
                        .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNombreProveedor)
                        .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtidVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNombreEmpleado)
                        .addComponent(txtEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        tabVentaDet.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 110));

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
                        .addGap(179, 179, 179)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
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
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        tabVentaDet.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 560, 100));

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
        tabVentaDet.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 80, 40));

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
        tabVentaDet.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 60, 80, 40));

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
        tabVentaDet.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 80, 30));

        lblTotal.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblTotal.setText("TOTAL:");
        tabVentaDet.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 80, 30));

        txtotal.setText("0.0");
        tabVentaDet.add(txtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 70, 30));

        lblSubtotal.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblSubtotal.setText("Subtotal c/Desc. Gen. :");
        tabVentaDet.add(lblSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 190, 30));

        txtSubtotal.setText("0.0");
        tabVentaDet.add(txtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 60, 30));

        lbliva.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lbliva.setText("Iva:");
        tabVentaDet.add(lbliva, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 40, 30));

        txtiva.setText("0.0");
        tabVentaDet.add(txtiva, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 60, 30));

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
        tabVentaDet.add(btnDespejarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 100, 30));

        tabBuscarCliente.setBackground(new java.awt.Color(255, 255, 255));
        tabBuscarCliente.setMinimumSize(new java.awt.Dimension(670, 460));
        tabBuscarCliente.setPreferredSize(new java.awt.Dimension(670, 460));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel3.setText("Buscar Cliente");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        btnConfirmarCli.setBackground(new java.awt.Color(255, 191, 117));
        btnConfirmarCli.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnConfirmarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnConfirmarCli.setText("Confirmar compra");
        btnConfirmarCli.setBorder(null);
        btnConfirmarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarCliActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmarCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 80, 40));

        btnRegresarCli.setBackground(new java.awt.Color(255, 191, 117));
        btnRegresarCli.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnRegresarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        btnRegresarCli.setText("Regresar");
        btnRegresarCli.setBorder(null);
        btnRegresarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarCliActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresarCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 80, 40));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 210, -1));

        txtBuscarCli.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        txtBuscarCli.setBorder(null);
        txtBuscarCli.setBackground(new java.awt.Color(0,0,0,1));
        txtBuscarCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarCliKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscarCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 210, 30));

        jtClientes.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtClientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 540, 290));

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel4.setText("Buscar");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 460));

        javax.swing.GroupLayout tabBuscarClienteLayout = new javax.swing.GroupLayout(tabBuscarCliente);
        tabBuscarCliente.setLayout(tabBuscarClienteLayout);
        tabBuscarClienteLayout.setHorizontalGroup(
            tabBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tabBuscarClienteLayout.setVerticalGroup(
            tabBuscarClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
        txtBuscarCli.setBackground(new java.awt.Color(0,0,0,1));
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

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
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
        txtBuscarCli.setBackground(new java.awt.Color(0,0,0,1));
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
                    .addComponent(tabVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(tabVentaDet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(tabVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(tabVentaDet, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        tabVenta.setVisible(false);
        tabVentaDet.setVisible(true);
        ModificablesNuevo();
        accion = "guardar";
        btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        if (jtListadoVentas1.getSelectedRowCount() == 1) {
            txtidVenta.setText(jtListadoVentas1.getValueAt(jtListadoVentas1.getSelectedRow(), 0).toString());
            txtIdCliente.setText(jtListadoVentas1.getValueAt(jtListadoVentas1.getSelectedRow(), 1).toString());
            txtcliente.setText(jtListadoVentas1.getValueAt(jtListadoVentas1.getSelectedRow(), 2).toString());
            txtIdEmpleado.setText(jtListadoVentas1.getValueAt(jtListadoVentas1.getSelectedRow(), 3).toString());
            txtEmpleado.setText(jtListadoVentas1.getValueAt(jtListadoVentas1.getSelectedRow(), 4).toString());
            txtFolio.setText(jtListadoVentas1.getValueAt(jtListadoVentas1.getSelectedRow(), 5).toString());
            txtSubtotal.setText(jtListadoVentas1.getValueAt(jtListadoVentas1.getSelectedRow(), 7).toString());
            txtiva.setText(jtListadoVentas1.getValueAt(jtListadoVentas1.getSelectedRow(), 8).toString());
            txtotal.setText(Double.toString((Double.parseDouble(jtListadoVentas1.getValueAt(jtListadoVentas1.getSelectedRow(), 7).toString())) + Double.parseDouble(jtListadoVentas1.getValueAt(jtListadoVentas1.getSelectedRow(), 8).toString())));
            //cambio de tabs
            tabVenta.setVisible(false);
            tabVentaDet.setVisible(true);
            NoModificablesDetalle();
            ListarDetalle(Integer.parseInt(txtidVenta.getText()));

        } else {
            JOptionPane.showMessageDialog(this, "Debes elegir una compra primero", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        int fila = 0;
        boolean ban = false;
        if (jtListadoDetalleV.getSelectedRowCount() >= 1) {
            int idtabla = Integer.parseInt(String.valueOf(jtListadoDetalleV.getModel().getValueAt(jtListadoDetalleV.getSelectedRow(), 0)));
            fila = jtListadoDetalleV.getRowCount();
            int idprod = Integer.parseInt(String.valueOf(txtIdProducto.getText()));
            if (fila > 0) {
                for (int f = 0; f < fila; f++) {
                    if (idprod == idtabla) {
                        JOptionPane.showMessageDialog(this, "Este producto ya esta ingresado como registro de la compra", "Sistema de compras", JOptionPane.ERROR_MESSAGE);
                        ban = false;
                        break;
                    }
                    ban = true;
                }
            } else {
                ban = true;
            }
            if (ban == true) {
                MetodoAñadir();
            }
        } else {
            MetodoAñadir();
        }
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String resp;
        if (txtIdCliente.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar a un Cliente", "Sistema de Ventas", JOptionPane.WARNING_MESSAGE);
            txtcliente.requestFocus();
            return;
        }
        if (txtFolio.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la clave de la venta", "Sistema de Ventas", JOptionPane.WARNING_MESSAGE);
            txtFolio.requestFocus();
            return;
        }
        if (dtmVentaDetalle.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Debes tener por lo menos un producto en el registro", "Sistema de Ventas", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //codigo de guardar o insertar
        //String FolioVenta, double precioVenta, double IVA, DefaultTableModel detalles
        resp = control.insertar(txtFolio.getText().trim(), Double.parseDouble(txtSubtotal.getText()), Double.parseDouble(txtiva.getText()), dtmVentaDetalle);
        if (resp.equals("OK")) {
            control.InsertarEmp_Ven(control.RegresarIdVenta(txtFolio.getText().trim()), Integer.parseInt(txtIdEmpleado.getText()));
            control.InsertarCli_Ven(control.RegresarIdVenta(txtFolio.getText().trim()), Integer.parseInt(txtIdCliente.getText()));
            MensajeOK("Compra registrada correctamente");
            Listar("");
            tabVenta.setVisible(true);
            tabVentaDet.setVisible(false);
            jtListadoVentas1.clearSelection();
            jtListadoDetalleV.clearSelection();
            ActualizarStockDecrementado();
            ListarTablaProd("");
            /////
            Limpiar();
            /////
        } else {
            MensajeError(resp);
        }
        //}
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        tabVenta.setVisible(true);
        tabVentaDet.setVisible(false);
        Limpiar();
        Listar("");
        jtListadoVentas1.clearSelection();
        jtListadoDetalleV.clearSelection();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnQuitarVenDetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarVenDetActionPerformed
        int fila = jtListadoDetalleV.getSelectedRow();
        //if(fila>=0){
        if (jtListadoDetalleV.getSelectedRowCount() == 1) {
            dtmVentaDetalle.removeRow(fila);
            CalcularSubtotalVenta();
            AccionLimpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Debes elegir a un registro de la venta", "Sistema de Ventas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnQuitarVenDetActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jtListadoDetalleV.getSelectedRowCount() == 1) {
            Object a[] = new Object[5];
            a[0] = Integer.parseInt(txtIdProducto.getText());
            a[1] = txtNomProducto.getText();
            a[2] = Integer.parseInt(txtcantidad.getText());
            a[3] = Double.parseDouble(txtPrecio.getText());
            a[4] = Double.parseDouble(txtSubtotalProd.getText());
            for (int i = 0; i < jtListadoDetalleV.getColumnCount(); i++) {
                dtmVentaDetalle.setValueAt(a[i], filas, i);
            }
            CalcularSubtotalVenta();
            AccionLimpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Debes elegir a un registro de la Venta para modificarlo", "Sistema de Ventas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        Listar(txtBusqueda.getText().trim());
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        tabBuscarCliente.setVisible(true);
        tabVentaDet.setVisible(false);
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void txtBuscarCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCliKeyReleased
        //controlprov.Listar(txtBusqueda.getText().trim());
        ListarTablaCli(txtBuscarCli.getText().trim());
    }//GEN-LAST:event_txtBuscarCliKeyReleased

    private void btnRegresarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarCliActionPerformed
        tabBuscarCliente.setVisible(false);
        ListarTablaCli("");
        txtBuscarCli.setText("");
        tabVentaDet.setVisible(true);
        jtClientes.clearSelection();
    }//GEN-LAST:event_btnRegresarCliActionPerformed

    private void btnConfirmarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCliActionPerformed
        if (jtClientes.getSelectedRowCount() == 1) {
            txtIdCliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 0).toString());
            txtcliente.setText(jtClientes.getValueAt(jtClientes.getSelectedRow(), 1).toString());
            tabBuscarCliente.setVisible(false);
            tabVentaDet.setVisible(true);
            jtClientes.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this, "Debes elegir un Cliente", "Sistema de Ventas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarCliActionPerformed

    private void btnConfirmarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarProdActionPerformed
        int fila = 0;
        boolean ban = false;
        if (jtProductos.getSelectedRowCount() == 1) {
            int idtabProd = Integer.parseInt(String.valueOf(jtProductos.getValueAt(jtProductos.getSelectedRow(), 1)));
            fila = dtmVentaDetalle.getRowCount();
            if (fila > 0) {
                for (int f = 0; f < fila; f++) {
                    int idtabDet = Integer.parseInt(String.valueOf(jtListadoDetalleV.getModel().getValueAt(f, 1)));
                    if (idtabDet == idtabProd) {
                        JOptionPane.showMessageDialog(this, "Este producto ya esta ingresado como registro de la venta", "Sistema de Ventas", JOptionPane.ERROR_MESSAGE);
                        ban = false;
                        break;
                    }
                    ban = true;
                }
            } else {
                ban = true;
            }
            if (ban == true) {
                txtIdProducto.setText(jtProductos.getValueAt(jtProductos.getSelectedRow(), 1).toString());
                txtNomProducto.setText(jtProductos.getValueAt(jtProductos.getSelectedRow(), 2).toString());
                txtPrecio.setText(jtProductos.getValueAt(jtProductos.getSelectedRow(), 6).toString());
                tabBuscarProducto.setVisible(false);
                tabVentaDet.setVisible(true);
                jtProductos.clearSelection();
                CalcularSubtotal();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes elegir un producto", "Sistema de ventas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarProdActionPerformed

    private void btnRegresarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarProdActionPerformed
        tabBuscarProducto.setVisible(false);
        ListarTablaProd("");
        txtBuscarProd.setText("");
        tabVentaDet.setVisible(true);
        jtProductos.clearSelection();
    }//GEN-LAST:event_btnRegresarProdActionPerformed

    private void txtBuscarProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProdKeyReleased
        ListarTablaProd(txtBuscarProd.getText().trim());
    }//GEN-LAST:event_txtBuscarProdKeyReleased

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        tabBuscarProducto.setVisible(true);
        tabVentaDet.setVisible(false);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void txtcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyReleased
        try {
            CalcularSubtotal();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Debes ingresar un numero positivo en la cantidad", "Sistema de ventas", JOptionPane.ERROR_MESSAGE);
            txtcantidad.setText("");
        }
    }//GEN-LAST:event_txtcantidadKeyReleased

    private void btnDespejarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDespejarTablaActionPerformed
        int fila = jtListadoDetalleV.getRowCount();
        System.out.println(fila);
        System.out.println(dtmVentaDetalle.getRowCount());
        for (int i = fila - 1; i >= 0; i--) {
            dtmVentaDetalle.removeRow(i);
        }
        CalcularSubtotalVenta();
        AccionLimpiar();
    }//GEN-LAST:event_btnDespejarTablaActionPerformed

    private void jtListadoDetalleVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoDetalleVMouseClicked
        int seleccion = jtListadoDetalleV.getSelectedRow();
        txtIdProducto.setText(jtListadoDetalleV.getValueAt(seleccion, 0).toString());
        txtNomProducto.setText(jtListadoDetalleV.getValueAt(seleccion, 1).toString());
        txtcantidad.setText(jtListadoDetalleV.getValueAt(seleccion, 2).toString());
        txtPrecio.setText(jtListadoDetalleV.getValueAt(seleccion, 3).toString());
        txtSubtotalProd.setText(jtListadoDetalleV.getValueAt(seleccion, 4).toString());
        filas = seleccion;
    }//GEN-LAST:event_jtListadoDetalleVMouseClicked

    private void jtListadoVentas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoVentas1MouseClicked

    }//GEN-LAST:event_jtListadoVentas1MouseClicked

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        Listar(txtBusqueda.getText().trim());
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void txtFolioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFolioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFolioActionPerformed

    private void btnBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEmpleadoActionPerformed
        tabBuscarEmpleado.setVisible(true);
        tabVentaDet.setVisible(false);
    }//GEN-LAST:event_btnBuscarEmpleadoActionPerformed

    private void txtIdEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEmpleadoActionPerformed

    private void btnConfirmarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarEmpActionPerformed
        if (jtEmpleado.getSelectedRowCount() == 1) {
            txtIdEmpleado.setText(jtEmpleado.getValueAt(jtEmpleado.getSelectedRow(), 0).toString());
            txtEmpleado.setText(jtEmpleado.getValueAt(jtEmpleado.getSelectedRow(), 1).toString());
            tabBuscarEmpleado.setVisible(false);
            tabVentaDet.setVisible(true);
            jtEmpleado.clearSelection();
        } else {
            JOptionPane.showMessageDialog(this, "Debes elegir al empleado que realizo la venta", "Sistema de ventas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarEmpActionPerformed

    private void btnRegresarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarEmpActionPerformed
        tabBuscarEmpleado.setVisible(false);
        ListarTablaProd("");
        txtBuscarEmp.setText("");
        tabVentaDet.setVisible(true);
        jtEmpleado.clearSelection();
    }//GEN-LAST:event_btnRegresarEmpActionPerformed

    private void txtBuscarEmpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarEmpKeyReleased
        ListarTablaEmp(txtBuscarEmp.getText().trim());
    }//GEN-LAST:event_txtBuscarEmpKeyReleased

    private void txtBuscarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarEmpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarEmpActionPerformed

    private void txtBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaActionPerformed

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteActionPerformed

    private void txtidVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidVentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backgroun1;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarEmpleado;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmarCli;
    private javax.swing.JButton btnConfirmarEmp;
    private javax.swing.JButton btnConfirmarProd;
    private javax.swing.JButton btnDespejarTabla;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnQuitarVenDet;
    private javax.swing.JButton btnRegresarCli;
    private javax.swing.JButton btnRegresarEmp;
    private javax.swing.JButton btnRegresarProd;
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
    private javax.swing.JTable jtClientes;
    private javax.swing.JTable jtEmpleado;
    private javax.swing.JTable jtListadoDetalleV;
    private javax.swing.JTable jtListadoVentas1;
    private javax.swing.JTable jtProductos;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblClaveCompra;
    private javax.swing.JLabel lblNomProducto;
    private javax.swing.JLabel lblNombreEmpleado;
    private javax.swing.JLabel lblNombreProveedor;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblSubtotalP;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblidprod;
    private javax.swing.JLabel lbliva;
    private javax.swing.JPanel tabBuscarCliente;
    private javax.swing.JPanel tabBuscarEmpleado;
    private javax.swing.JPanel tabBuscarProducto;
    private javax.swing.JPanel tabVenta;
    private javax.swing.JPanel tabVentaDet;
    private javax.swing.JTextField txtBuscarCli;
    private javax.swing.JTextField txtBuscarEmp;
    private javax.swing.JTextField txtBuscarProd;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtNomProducto;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtSubtotalProd;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtidVenta;
    private javax.swing.JTextField txtiva;
    private javax.swing.JTextField txtotal;
    // End of variables declaration//GEN-END:variables
}
