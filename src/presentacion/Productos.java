package presentacion;

import entidades.Producto;
import java.awt.Image;
import negocio.ProductoControl;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Productos extends javax.swing.JPanel {

    private final ProductoControl CONTROL;
    String imagenProducto, nombreAnt;
    
    
    public Productos() {
        initComponents();
        tabProductosDet.setVisible(false);
        tabCategorias.setVisible(false);
        CONTROL=new ProductoControl();
        imagenProducto="default.jpg";
        txtIdCategoria.setVisible(false);
        txtIdProducto.setVisible(false);
        Listar("");
        //ListarCat("");
        
    }
    
    public void Listar(String texto)
    {
        jtListadoProductos.setModel(CONTROL.listar(texto));
        TableRowSorter modeloOrdenado = new TableRowSorter(jtListadoProductos.getModel());
        jtListadoProductos.setRowSorter(modeloOrdenado);
    }
    
    public void ListarCategorias(String texto){
        jtListadoCategorias.setModel(CONTROL.seleccionarCategorias(texto));
        TableRowSorter modeloOrdenado = new TableRowSorter(jtListadoCategorias.getModel());
        jtListadoCategorias.setRowSorter(modeloOrdenado);
    }
    
    public void mensajeOK(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Papelería Yolis", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Papelería Yolis", JOptionPane.ERROR_MESSAGE);
    }
    
    public void Limpiar(){
        txtIdProducto.setText("");
        txtIdCategoria.setText("");
        txtNombreP.setText("");
        txtNombreC.setText("");
        txtExistencias.setText("0");
        txtPrecioC.setText("0");
        txtPrecioV.setText("0");
        txtGanancia.setText("0");
        lblImagenProducto.setIcon(null);
        imagenProducto="default.jpg";
    }
    
    public void pintarImagen(JLabel lbl, String ruta){
        ImageIcon imagen = new ImageIcon(ruta);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));
        lbl.setIcon(icono);
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabProductos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Backgroun1 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnBuscarP = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        lblBusqueda = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListadoProductos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        tabProductosDet = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnImagen = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        lblBusqueda1 = new javax.swing.JLabel();
        txtNombreP = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        lblBusqueda2 = new javax.swing.JLabel();
        txtIdProducto = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        txtNombreC = new javax.swing.JTextField();
        lblBusqueda3 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        txtExistencias = new javax.swing.JFormattedTextField();
        lblBusqueda4 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        txtPrecioC = new javax.swing.JFormattedTextField();
        lblBusqueda5 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        txtPrecioV = new javax.swing.JFormattedTextField();
        txtGanancia = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        lblImagenProducto = new javax.swing.JLabel();
        Backgroun2 = new javax.swing.JLabel();
        lblBusqueda6 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtIdCategoria = new javax.swing.JTextField();
        tabCategorias = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Backgroun3 = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        btnBuscarC = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JSeparator();
        lblBusqueda7 = new javax.swing.JLabel();
        txtBusquedaC = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtListadoCategorias = new javax.swing.JTable();

        tabProductos.setBackground(new java.awt.Color(255, 255, 255));
        tabProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel2.setText("Productos");
        tabProductos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        Backgroun1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo formulario.jpg"))); // NOI18N
        tabProductos.add(Backgroun1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 170, 460));

        btnNuevo.setBackground(new java.awt.Color(255, 191, 117));
        btnNuevo.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnNuevo.setText("Agregar producto");
        btnNuevo.setBorder(null);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        tabProductos.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 120, 30));

        btnBuscarP.setBackground(new java.awt.Color(255, 191, 117));
        btnBuscarP.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnBuscarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscarP.setBorder(null);
        btnBuscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPActionPerformed(evt);
            }
        });
        tabProductos.add(btnBuscarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 97, 70, 20));
        tabProductos.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 230, 10));

        lblBusqueda.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda.setText("Búsqueda");
        tabProductos.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 50, -1));

        txtBusqueda.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtBusqueda.setBorder(null);
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        tabProductos.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 230, -1));

        jtListadoProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtListadoProductos.getTableHeader().setReorderingAllowed(false);
        jtListadoProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtListadoProductos);

        tabProductos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 420, 260));

        btnEditar.setBackground(new java.awt.Color(255, 191, 117));
        btnEditar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnEditar.setText("Editar producto");
        btnEditar.setBorder(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        tabProductos.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 120, 30));

        btnEliminar.setBackground(new java.awt.Color(255, 191, 117));
        btnEliminar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar producto");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        tabProductos.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 120, 30));

        tabProductosDet.setBackground(new java.awt.Color(255, 255, 255));
        tabProductosDet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel3.setText("Productos");
        tabProductosDet.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(255, 191, 117));
        btnGuardar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnGuardar.setText("Agregar producto");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        tabProductosDet.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 120, -1));

        btnImagen.setBackground(new java.awt.Color(255, 191, 117));
        btnImagen.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnImagen.setText("Buscar imagen");
        btnImagen.setBorder(null);
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });
        tabProductosDet.add(btnImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 110, 20));
        tabProductosDet.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 210, 10));

        lblBusqueda1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda1.setText("Nombre del producto:");
        tabProductosDet.add(lblBusqueda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, -1));

        txtNombreP.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtNombreP.setBorder(null);
        txtNombreP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombrePKeyReleased(evt);
            }
        });
        tabProductosDet.add(txtNombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 210, 20));

        btnActualizar.setBackground(new java.awt.Color(255, 191, 117));
        btnActualizar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar producto");
        btnActualizar.setBorder(null);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        tabProductosDet.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 120, -1));

        lblBusqueda2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda2.setText("Categoria:");
        tabProductosDet.add(lblBusqueda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 60, -1));

        txtIdProducto.setEditable(false);
        txtIdProducto.setBackground(new java.awt.Color(255, 255, 255));
        txtIdProducto.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtIdProducto.setBorder(null);
        txtIdProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdProductoKeyReleased(evt);
            }
        });
        tabProductosDet.add(txtIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 120, -1, 20));
        tabProductosDet.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 210, 10));

        txtNombreC.setEditable(false);
        txtNombreC.setBackground(new java.awt.Color(255, 255, 255));
        txtNombreC.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtNombreC.setBorder(null);
        txtNombreC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreCKeyReleased(evt);
            }
        });
        tabProductosDet.add(txtNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 210, 20));

        lblBusqueda3.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda3.setText("Existencias:");
        tabProductosDet.add(lblBusqueda3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 70, -1));
        tabProductosDet.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 100, 10));

        txtExistencias.setBorder(null);
        txtExistencias.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtExistencias.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtExistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExistenciasActionPerformed(evt);
            }
        });
        tabProductosDet.add(txtExistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 100, -1));

        lblBusqueda4.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda4.setText("Precio de compra:");
        tabProductosDet.add(lblBusqueda4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 100, -1));
        tabProductosDet.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 100, 10));

        txtPrecioC.setBorder(null);
        txtPrecioC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtPrecioC.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtPrecioC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioCActionPerformed(evt);
            }
        });
        txtPrecioC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioCKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioCKeyReleased(evt);
            }
        });
        tabProductosDet.add(txtPrecioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 100, -1));

        lblBusqueda5.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda5.setText("Precio de venta:");
        tabProductosDet.add(lblBusqueda5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 100, -1));
        tabProductosDet.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 100, 10));

        txtPrecioV.setBorder(null);
        txtPrecioV.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        txtPrecioV.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtPrecioV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVActionPerformed(evt);
            }
        });
        txtPrecioV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioVKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioVKeyReleased(evt);
            }
        });
        tabProductosDet.add(txtPrecioV, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 100, -1));

        txtGanancia.setEditable(false);
        txtGanancia.setBackground(new java.awt.Color(255, 255, 255));
        txtGanancia.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtGanancia.setBorder(null);
        txtGanancia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGananciaKeyReleased(evt);
            }
        });
        tabProductosDet.add(txtGanancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 100, 20));
        tabProductosDet.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 100, 10));

        lblImagenProducto.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblImagenProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabProductosDet.add(lblImagenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 130, 130));

        Backgroun2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo formulario.jpg"))); // NOI18N
        tabProductosDet.add(Backgroun2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 170, 460));

        lblBusqueda6.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda6.setText("Ganancia:");
        tabProductosDet.add(lblBusqueda6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 60, -1));

        btnAtras.setBackground(new java.awt.Color(255, 191, 117));
        btnAtras.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrarsesion32px.png"))); // NOI18N
        btnAtras.setBorder(null);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        tabProductosDet.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        btnBuscar.setBackground(new java.awt.Color(255, 191, 117));
        btnBuscar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        tabProductosDet.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 50, 20));

        txtIdCategoria.setEditable(false);
        txtIdCategoria.setBackground(new java.awt.Color(255, 255, 255));
        txtIdCategoria.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtIdCategoria.setBorder(null);
        txtIdCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdCategoriaKeyReleased(evt);
            }
        });
        tabProductosDet.add(txtIdCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 20));

        tabCategorias.setBackground(new java.awt.Color(255, 255, 255));
        tabCategorias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel4.setText("Categorías");
        tabCategorias.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        Backgroun3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo formulario.jpg"))); // NOI18N
        tabCategorias.add(Backgroun3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 170, 460));

        btnSeleccionar.setBackground(new java.awt.Color(255, 191, 117));
        btnSeleccionar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar categoría");
        btnSeleccionar.setBorder(null);
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        tabCategorias.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 150, 30));

        btnBuscarC.setBackground(new java.awt.Color(255, 191, 117));
        btnBuscarC.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnBuscarC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscarC.setBorder(null);
        btnBuscarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCActionPerformed(evt);
            }
        });
        tabCategorias.add(btnBuscarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 97, 70, 20));
        tabCategorias.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 230, 10));

        lblBusqueda7.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda7.setText("Búsqueda");
        tabCategorias.add(lblBusqueda7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 50, -1));

        txtBusquedaC.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtBusquedaC.setBorder(null);
        txtBusquedaC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaCKeyReleased(evt);
            }
        });
        tabCategorias.add(txtBusquedaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 230, -1));

        jtListadoCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtListadoCategorias.getTableHeader().setReorderingAllowed(false);
        jtListadoCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtListadoCategoriasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtListadoCategorias);

        tabCategorias.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 420, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabProductosDet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(tabProductosDet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tabProductos.setVisible(false);
        tabProductosDet.setVisible(true);
        btnGuardar.setVisible(true);
        btnActualizar.setVisible(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPActionPerformed
        Listar(txtBusqueda.getText().trim());
    }//GEN-LAST:event_btnBuscarPActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        Listar(txtBusqueda.getText().trim());
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void jtListadoProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoProductosMouseClicked

    }//GEN-LAST:event_jtListadoProductosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(jtListadoProductos.getSelectedRowCount()==1){
            nombreAnt=jtListadoProductos.getValueAt(jtListadoProductos.getSelectedRow(),1).toString();
            
            txtIdProducto.setText(jtListadoProductos.getValueAt(jtListadoProductos.getSelectedRow(),0).toString());
            txtIdCategoria.setText(jtListadoProductos.getValueAt(jtListadoProductos.getSelectedRow(),2).toString());
            txtNombreP.setText(jtListadoProductos.getValueAt(jtListadoProductos.getSelectedRow(),1).toString());
            txtNombreC.setText(jtListadoProductos.getValueAt(jtListadoProductos.getSelectedRow(),3).toString());
            txtExistencias.setText(jtListadoProductos.getValueAt(jtListadoProductos.getSelectedRow(),4).toString());
            txtPrecioC.setText(jtListadoProductos.getValueAt(jtListadoProductos.getSelectedRow(),5).toString());
            txtPrecioV.setText(jtListadoProductos.getValueAt(jtListadoProductos.getSelectedRow(),6).toString());
            txtGanancia.setText(jtListadoProductos.getValueAt(jtListadoProductos.getSelectedRow(),7).toString());
            imagenProducto=jtListadoProductos.getValueAt(jtListadoProductos.getSelectedRow(),8).toString();
            pintarImagen(lblImagenProducto,imagenProducto);
            
            
            tabProductos.setVisible(false);
            tabProductosDet.setVisible(true);
            btnGuardar.setVisible(false);
            btnActualizar.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro","Sistema Compras-Ventas", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String resp;
        if(txtNombreP.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe escribir el nombre del producto.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtNombreP.requestFocus();
            return;
        }
        if(txtNombreC.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una categoria.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtNombreC.requestFocus();
            return;
        }
        if(txtExistencias.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe escribir las existencias.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtExistencias.requestFocus();
            return;
        }
        if(txtPrecioC.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe escribir el precio de compra.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtPrecioC.requestFocus();
            return;
        }
        if(txtPrecioV.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe escribir el precio de venta.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtPrecioV.requestFocus();
            return;
        }
        if(Double.valueOf(txtGanancia.getText().toString())<=1){
            JOptionPane.showMessageDialog(this, "El precio de venta no puede ser mayor o igual al precio de compra.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtPrecioV.requestFocus();
            return;
        }
        resp=CONTROL.insertar(Integer.parseInt(txtIdCategoria.getText()),txtNombreP.getText(), Integer.valueOf(txtExistencias.getText().toString().replace(",","")), Double.valueOf(txtPrecioC.getText().toString().replace(",","")), Double.valueOf(txtPrecioV.getText().toString().replace(",","")), Double.valueOf(txtGanancia.getText().toString().replace(",","")), imagenProducto);
        if(resp.equals("OK"))
            {
                this.mensajeOK("Registro insertado correctamente.");
                Listar("");
                this.Limpiar();
                
                tabProductos.setVisible(true);
                tabProductosDet.setVisible(false);
            }    
            else{
                this.mensajeError(resp);
            }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            imagenProducto = ruta;
            //8. Pintar la imagen que seleccionó el usuario
            pintarImagen(lblImagenProducto,ruta);
        }
    }//GEN-LAST:event_btnImagenActionPerformed

    private void txtNombrePKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombrePKeyReleased

    private void txtIdProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProductoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProductoKeyReleased

    private void txtNombreCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCKeyReleased

    private void txtExistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExistenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExistenciasActionPerformed

    private void txtPrecioCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioCActionPerformed
        if(Double.valueOf(txtPrecioV.getText().toString())>0)
            txtGanancia.setText(""+(Double.valueOf(txtPrecioV.getText().toString())-Double.valueOf(txtPrecioC.getText().toString())));
    }//GEN-LAST:event_txtPrecioCActionPerformed

    private void txtPrecioVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVActionPerformed
        if(Double.valueOf(txtPrecioC.getText().toString())>0)
            txtGanancia.setText(""+(Double.valueOf(txtPrecioV.getText().toString())-Double.valueOf(txtPrecioC.getText().toString())));
    }//GEN-LAST:event_txtPrecioVActionPerformed

    private void txtGananciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGananciaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGananciaKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String resp;
        // Preguntar que se haya seleccionado un elemento
        if(jtListadoProductos.getSelectedRowCount()==1){
            //cmbCategoria.setText(jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(), 1).toString());
                if(JOptionPane.showConfirmDialog(this, "¿Deseas eliminar el producto: "+jtListadoProductos.getValueAt(jtListadoProductos.getSelectedRow(), 1).toString()+"?","Sistema Compras-Ventas", JOptionPane.YES_NO_OPTION)==0){
                    resp=CONTROL.eliminar(jtListadoProductos.getValueAt(jtListadoProductos.getSelectedRow(), 1).toString());
                    if(resp.equals("OK")){
                        mensajeOK("Registro eliminado.");
                        Listar("");
                    }
                    else
                        mensajeError(resp);
                }
            else
                mensajeError("Eliminación cancelada.");
        }
        else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar un producto","Papelería Yolis", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String resp;
        if(txtNombreP.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe escribir el nombre del producto.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtNombreP.requestFocus();
            return;
        }
        if(txtNombreC.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe seleccionar una categoria.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtNombreC.requestFocus();
            return;
        }
        if(txtExistencias.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe escribir las existencias.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtExistencias.requestFocus();
            return;
        }
        if(txtPrecioC.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe escribir el precio de compra.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtPrecioC.requestFocus();
            return;
        }
        if(txtPrecioV.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe escribir el precio de venta.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtPrecioV.requestFocus();
            return;
        }
        if(Double.valueOf(txtGanancia.getText().toString())<=1){
            JOptionPane.showMessageDialog(this, "El precio de venta no puede ser mayor o igual al precio de compra.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtPrecioV.requestFocus();
            return;
        }
        //int idProducto, int idCategoria, String nombreProducto, String nombreAnterior, int existencias, double precioCompra, double precioVenta, double ganancia, String imagenProducto
        resp=CONTROL.actualizar(Integer.parseInt(txtIdProducto.getText()),Integer.parseInt(txtIdCategoria.getText()),txtNombreP.getText(), nombreAnt, Integer.valueOf(txtExistencias.getText().toString().replace(",","")), Double.valueOf(txtPrecioC.getText().toString().replace(",","")), Double.valueOf(txtPrecioV.getText().toString().replace(",","")), Double.valueOf(txtGanancia.getText().toString().replace(",","")), imagenProducto);
        if(resp.equals("OK"))
        {
                this.mensajeOK("Registro actualizado correctamente.");
                Listar("");
                this.Limpiar();
                
                tabProductos.setVisible(true);
                tabProductosDet.setVisible(false);
        }    
        else{
            this.mensajeError(resp);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        tabProductos.setVisible(true);
        tabProductosDet.setVisible(false);
        Limpiar();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        tabProductosDet.setVisible(false);
        tabCategorias.setVisible(true);
        
        this.ListarCategorias("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtPrecioCKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCKeyPressed

    }//GEN-LAST:event_txtPrecioCKeyPressed

    private void txtPrecioVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVKeyPressed

    private void txtPrecioCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCKeyReleased
        try{
            if(Double.valueOf(txtPrecioV.getText().toString().replace(",",""))>=0)
                txtGanancia.setText(""+(Double.valueOf(txtPrecioV.getText().toString().replace(",",""))-(Double.valueOf(txtPrecioC.getText().toString().replace(",","")))));
        }
        catch(NumberFormatException e){
        }
    }//GEN-LAST:event_txtPrecioCKeyReleased

    private void txtPrecioVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVKeyReleased
        try{
            if(Double.valueOf(txtPrecioC.getText().toString().replace(",",""))>=0)
                txtGanancia.setText(""+(Double.valueOf(txtPrecioV.getText().toString().replace(",",""))-(Double.valueOf(txtPrecioC.getText().toString().replace(",","")))));
        }
        catch(NumberFormatException e){
        }
    }//GEN-LAST:event_txtPrecioVKeyReleased

    private void txtIdCategoriaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdCategoriaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCategoriaKeyReleased

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if(jtListadoCategorias.getSelectedRowCount()==1){
            txtIdCategoria.setText(jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(),0).toString());
            txtNombreC.setText(jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(),1).toString());

            tabProductosDet.setVisible(true);
            tabCategorias.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar una categoría","Papelería Yolis", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnBuscarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCActionPerformed
        this.ListarCategorias(txtBusquedaC.getText());
    }//GEN-LAST:event_btnBuscarCActionPerformed

    private void txtBusquedaCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaCKeyReleased
        this.ListarCategorias(txtBusquedaC.getText());
    }//GEN-LAST:event_txtBusquedaCKeyReleased

    private void jtListadoCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoCategoriasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtListadoCategoriasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backgroun1;
    private javax.swing.JLabel Backgroun2;
    private javax.swing.JLabel Backgroun3;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarC;
    private javax.swing.JButton btnBuscarP;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jtListadoCategorias;
    private javax.swing.JTable jtListadoProductos;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblBusqueda1;
    private javax.swing.JLabel lblBusqueda2;
    private javax.swing.JLabel lblBusqueda3;
    private javax.swing.JLabel lblBusqueda4;
    private javax.swing.JLabel lblBusqueda5;
    private javax.swing.JLabel lblBusqueda6;
    private javax.swing.JLabel lblBusqueda7;
    private javax.swing.JLabel lblImagenProducto;
    private javax.swing.JPanel tabCategorias;
    private javax.swing.JPanel tabProductos;
    private javax.swing.JPanel tabProductosDet;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtBusquedaC;
    private javax.swing.JFormattedTextField txtExistencias;
    private javax.swing.JTextField txtGanancia;
    private javax.swing.JTextField txtIdCategoria;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtNombreC;
    private javax.swing.JTextField txtNombreP;
    private javax.swing.JFormattedTextField txtPrecioC;
    private javax.swing.JFormattedTextField txtPrecioV;
    // End of variables declaration//GEN-END:variables
}
