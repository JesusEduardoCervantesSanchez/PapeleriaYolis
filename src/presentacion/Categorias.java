package presentacion;

import java.awt.Image;
import negocio.CategoriaControl;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableRowSorter;

public class Categorias extends javax.swing.JPanel {

    private final CategoriaControl CONTROL;
    String imagenProducto, nombreAnt;
    
    public Categorias() {
        initComponents();
        tabCategoriasDet.setVisible(false);
        CONTROL=new CategoriaControl();
        imagenProducto="default.jpg";
        txtIdCategorias.setVisible(false);
        Listar("");        
    }
    
    public void Listar(String texto)
    {
        jtListadoCategorias.setModel(CONTROL.listar(texto));
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
        txtIdCategorias.setText("");
        txtNombreC.setText("");
        txtNombreC.setText("");
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

        tabCategorias = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Backgroun1 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnBuscarP = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        lblBusqueda = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListadoCategorias = new javax.swing.JTable();
        btnActivar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        tabCategoriasDet = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnImagen = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        lblBusqueda1 = new javax.swing.JLabel();
        txtNombreC = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        lblBusqueda2 = new javax.swing.JLabel();
        txtIdCategorias = new javax.swing.JTextField();
        lblImagenProducto = new javax.swing.JLabel();
        Backgroun2 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();

        tabCategorias.setBackground(new java.awt.Color(255, 255, 255));
        tabCategorias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel2.setText("Categorias");
        tabCategorias.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        Backgroun1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo formulario.jpg"))); // NOI18N
        tabCategorias.add(Backgroun1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 170, 460));

        btnNuevo.setBackground(new java.awt.Color(255, 191, 117));
        btnNuevo.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnNuevo.setText("Agregar categoría");
        btnNuevo.setBorderPainted(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        tabCategorias.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 120, 30));

        btnBuscarP.setBackground(new java.awt.Color(255, 191, 117));
        btnBuscarP.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnBuscarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscarP.setBorder(null);
        btnBuscarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPActionPerformed(evt);
            }
        });
        tabCategorias.add(btnBuscarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 97, 70, 20));
        tabCategorias.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 230, 10));

        lblBusqueda.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda.setText("Búsqueda");
        tabCategorias.add(lblBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 50, -1));

        txtBusqueda.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtBusqueda.setBorder(null);
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        tabCategorias.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 230, -1));

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
        jScrollPane2.setViewportView(jtListadoCategorias);

        tabCategorias.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 420, 260));

        btnActivar.setBackground(new java.awt.Color(255, 191, 117));
        btnActivar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnActivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnActivar.setText("Activar");
        btnActivar.setBorder(null);
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });
        tabCategorias.add(btnActivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 70, 30));

        btnEditar.setBackground(new java.awt.Color(255, 191, 117));
        btnEditar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnEditar.setText("Editar categoría");
        btnEditar.setBorder(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        tabCategorias.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 120, 30));

        btnDesactivar.setBackground(new java.awt.Color(255, 191, 117));
        btnDesactivar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnDesactivar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnDesactivar.setText("Desactivar");
        btnDesactivar.setBorder(null);
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });
        tabCategorias.add(btnDesactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 80, 30));

        tabCategoriasDet.setBackground(new java.awt.Color(255, 255, 255));
        tabCategoriasDet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel3.setText("Categorias");
        tabCategoriasDet.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(255, 191, 117));
        btnGuardar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnGuardar.setText("Agregar categoria");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        tabCategoriasDet.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 120, -1));

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
        tabCategoriasDet.add(btnImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 110, 20));
        tabCategoriasDet.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 210, 10));

        lblBusqueda1.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda1.setText("Nombre de la categoria:");
        tabCategoriasDet.add(lblBusqueda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 130, -1));

        txtNombreC.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtNombreC.setBorder(null);
        txtNombreC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreCKeyReleased(evt);
            }
        });
        tabCategoriasDet.add(txtNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 210, 20));

        btnActualizar.setBackground(new java.awt.Color(255, 191, 117));
        btnActualizar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar categoria");
        btnActualizar.setBorder(null);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        tabCategoriasDet.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 120, -1));

        lblBusqueda2.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda2.setText("Descripción:");
        tabCategoriasDet.add(lblBusqueda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 70, -1));

        txtIdCategorias.setEditable(false);
        txtIdCategorias.setBackground(new java.awt.Color(255, 255, 255));
        txtIdCategorias.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtIdCategorias.setBorder(null);
        txtIdCategorias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdCategoriasKeyReleased(evt);
            }
        });
        tabCategoriasDet.add(txtIdCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(369, 120, -1, 20));

        lblImagenProducto.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblImagenProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabCategoriasDet.add(lblImagenProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 130, 130));

        Backgroun2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo formulario.jpg"))); // NOI18N
        tabCategoriasDet.add(Backgroun2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 170, 460));

        btnAtras.setBackground(new java.awt.Color(255, 191, 117));
        btnAtras.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrarsesion32px.png"))); // NOI18N
        btnAtras.setBorder(null);
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        tabCategoriasDet.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        tabCategoriasDet.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 270, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabCategoriasDet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(tabCategoriasDet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tabCategorias.setVisible(false);
        tabCategoriasDet.setVisible(true);
        btnGuardar.setVisible(true);
        btnActualizar.setVisible(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPActionPerformed
        Listar(txtBusqueda.getText().trim());
    }//GEN-LAST:event_btnBuscarPActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        Listar(txtBusqueda.getText().trim());
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void jtListadoCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtListadoCategoriasMouseClicked

    }//GEN-LAST:event_jtListadoCategoriasMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(jtListadoCategorias.getSelectedRowCount()==1){
            nombreAnt=jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(),1).toString();
            
            txtIdCategorias.setText(jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(),0).toString());
            txtNombreC.setText(jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(),1).toString());
            txtDescripcion.setText(jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(),2).toString());
            imagenProducto=jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(),3).toString();
            pintarImagen(lblImagenProducto,imagenProducto);
            
            
            tabCategorias.setVisible(false);
            tabCategoriasDet.setVisible(true);
            btnGuardar.setVisible(false);
            btnActualizar.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro","Sistema Compras-Ventas", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String resp;
        if(txtNombreC.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe escribir el nombre del producto.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtNombreC.requestFocus();
            return;
        }
        if(txtDescripcion.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe escribir una descripción.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }
        resp=CONTROL.insertar(txtNombreC.getText(), txtDescripcion.getText(), imagenProducto);
        if(resp.equals("OK"))
            {
                this.mensajeOK("Registro insertado correctamente.");
                Listar("");
                this.Limpiar();
                
                tabCategorias.setVisible(true);
                tabCategoriasDet.setVisible(false);
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

    private void txtNombreCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCKeyReleased

    private void txtIdCategoriasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdCategoriasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCategoriasKeyReleased

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        String resp;
        // Preguntar que se haya seleccionado un elemento
        if(jtListadoCategorias.getSelectedRowCount()==1){
            if(jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(), 4).toString().equals("Activo")){
                //cmbCategoria.setText(jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(), 1).toString());
                    if(JOptionPane.showConfirmDialog(this, "¿Deseas desactivar la categoria: "+jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(), 1).toString()+"?","Sistema Compras-Ventas", JOptionPane.YES_NO_OPTION)==0){
                        resp=CONTROL.desactivar(Integer.parseInt(jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(), 0).toString()));
                        if(resp.equals("OK")){
                            mensajeOK("Registro desactivado.");
                            Listar("");
                        }
                        else
                            mensajeError(resp);
                    }
                else
                    mensajeError("Desactivación cancelada.");
            }
            else
                JOptionPane.showMessageDialog(this, "La categoría ya está inactiva","Papelería Yolis", JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar una categoría","Papelería Yolis", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        String resp;
        if(txtNombreC.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe escribir el nombre del producto.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtNombreC.requestFocus();
            return;
        }
        if(txtDescripcion.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Debe escribir una descripción.", "Papelería Yolis", JOptionPane.WARNING_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }
        //int idProducto, int idCategoria, String nombreProducto, String nombreAnterior, int existencias, double precioCompra, double precioVenta, double ganancia, String imagenProducto
        resp=CONTROL.actualizar(Integer.parseInt(txtIdCategorias.getText()),txtNombreC.getText(), nombreAnt, txtDescripcion.getText(), imagenProducto);
        if(resp.equals("OK"))
        {
                this.mensajeOK("Registro actualizado correctamente.");
                Listar("");
                this.Limpiar();
                
                tabCategorias.setVisible(true);
                tabCategoriasDet.setVisible(false);
        }    
        else{
            this.mensajeError(resp);
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        tabCategorias.setVisible(true);
        tabCategoriasDet.setVisible(false);
        Limpiar();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        String resp;
        // Preguntar que se haya seleccionado un elemento
        if(jtListadoCategorias.getSelectedRowCount()==1){
            if(jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(), 4).toString().equals("Inactivo")){
                //cmbCategoria.setText(jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(), 1).toString());
                    if(JOptionPane.showConfirmDialog(this, "¿Deseas activar la categoria: "+jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(), 1).toString()+"?","Sistema Compras-Ventas", JOptionPane.YES_NO_OPTION)==0){
                        resp=CONTROL.activar(Integer.parseInt(jtListadoCategorias.getValueAt(jtListadoCategorias.getSelectedRow(), 0).toString()));
                        if(resp.equals("OK")){
                            mensajeOK("Registro activado.");
                            Listar("");
                        }
                        else
                            mensajeError(resp);
                    }
                else
                    mensajeError("Eliminación cancelada.");
            }
            else
                JOptionPane.showMessageDialog(this, "La categoría ya está activa","Papelería Yolis", JOptionPane.WARNING_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(this, "Debes seleccionar una categoría","Papelería Yolis", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnActivarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backgroun1;
    private javax.swing.JLabel Backgroun2;
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnBuscarP;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jtListadoCategorias;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblBusqueda1;
    private javax.swing.JLabel lblBusqueda2;
    private javax.swing.JLabel lblImagenProducto;
    private javax.swing.JPanel tabCategorias;
    private javax.swing.JPanel tabCategoriasDet;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtIdCategorias;
    private javax.swing.JTextField txtNombreC;
    // End of variables declaration//GEN-END:variables
}
