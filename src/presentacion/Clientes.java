
package presentacion;

import negocio.ClientesControl;
import javax.swing.JOptionPane;

public class Clientes extends javax.swing.JPanel {

    private final ClientesControl CONTROL;
    String accion;
    private String nicknameant;
    
    public Clientes() 
    {
        initComponents();
        CONTROL = new ClientesControl();
        Listar("");
        TabOperaciones.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabClientes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        lblBusqueda = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnEditar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TabOperaciones = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        txtNickName = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        txtDomicilio = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        txtLocalidad = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        txtCP = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        TabClientes.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Agency FB", 0, 48)); // NOI18N
        jLabel1.setText("Clientes");

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaListado);

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

        lblBusqueda.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        lblBusqueda.setText("Busqueda");

        txtBusqueda.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        txtBusqueda.setBorder(null);
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(255, 191, 117));
        btnBuscar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 191, 117));
        btnEditar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario 128px.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo formulario.jpg"))); // NOI18N

        javax.swing.GroupLayout TabClientesLayout = new javax.swing.GroupLayout(TabClientes);
        TabClientes.setLayout(TabClientesLayout);
        TabClientesLayout.setHorizontalGroup(
            TabClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabClientesLayout.createSequentialGroup()
                .addGroup(TabClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TabClientesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TabClientesLayout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TabClientesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(TabClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(TabClientesLayout.createSequentialGroup()
                                .addComponent(lblBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(40, 40, 40)
                .addGroup(TabClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TabClientesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(TabClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        TabClientesLayout.setVerticalGroup(
            TabClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabClientesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(TabClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBusqueda)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(TabClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(TabClientesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        TabOperaciones.setBackground(new java.awt.Color(255, 255, 255));
        TabOperaciones.setMinimumSize(new java.awt.Dimension(670, 460));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setBackground(new java.awt.Color(255, 191, 117));
        btnVolver.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 70, 30));

        jLabel7.setFont(new java.awt.Font("Agency FB", 0, 36)); // NOI18N
        jLabel7.setText("Clientes");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        txtID.setEditable(false);
        txtID.setBorder(null);
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 40, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 40, 10));

        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 240, 20));

        jLabel8.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel8.setText("Nombre:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 240, 10));

        jLabel13.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel13.setText("ID:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 40, 10));

        jLabel14.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel14.setText("Apellidos:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 70, -1));

        txtApellidos.setBorder(null);
        jPanel1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 240, 20));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 240, 10));

        jLabel15.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel15.setText("NickName:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 70, -1));

        txtNickName.setBorder(null);
        jPanel1.add(txtNickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 240, 20));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 240, 10));

        jLabel16.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel16.setText("Télefono:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 70, -1));

        txtTelefono.setBorder(null);
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 240, 20));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 240, 10));

        jLabel17.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel17.setText("Domicilio:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 70, -1));

        txtDomicilio.setBorder(null);
        jPanel1.add(txtDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 240, 20));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 240, 10));

        jLabel18.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel18.setText("Localidad:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 70, -1));

        txtLocalidad.setBorder(null);
        jPanel1.add(txtLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 240, 20));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, 240, 10));

        jLabel19.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel19.setText("Estado:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 70, -1));

        txtEstado.setBorder(null);
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 240, 20));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 240, 10));

        jLabel20.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel20.setText("CP:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 70, -1));

        txtCP.setBorder(null);
        jPanel1.add(txtCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 240, 20));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 240, 10));

        jLabel21.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel21.setText("Correo:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 70, -1));

        txtCorreo.setBorder(null);
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 240, 20));
        jPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 240, 10));

        jLabel22.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        jLabel22.setText("Contraseña:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 90, -1));

        txtContrasena.setBorder(null);
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 220, 20));
        jPanel1.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 220, 10));

        btnGuardar.setBackground(new java.awt.Color(255, 191, 117));
        btnGuardar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-agregar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 70, 30));

        btnEliminar.setBackground(new java.awt.Color(255, 191, 117));
        btnEliminar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 70, 30));

        btnActualizar.setBackground(new java.awt.Color(255, 191, 117));
        btnActualizar.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actaulizar");
        btnActualizar.setBorder(null);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 70, 30));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario 128px.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo formulario.jpg"))); // NOI18N

        javax.swing.GroupLayout TabOperacionesLayout = new javax.swing.GroupLayout(TabOperaciones);
        TabOperaciones.setLayout(TabOperacionesLayout);
        TabOperacionesLayout.setHorizontalGroup(
            TabOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabOperacionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(TabOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabOperacionesLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        TabOperacionesLayout.setVerticalGroup(
            TabOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabOperacionesLayout.createSequentialGroup()
                .addGroup(TabOperacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TabOperacionesLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TabOperacionesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel12)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TabClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TabOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TabClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TabOperaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void Listar(String texto) 
    {
        tablaListado.setModel(CONTROL.Listar(texto));
    }

    public void MensajeOk(String Mensaje) {
        JOptionPane.showMessageDialog(this, Mensaje, "Papeleria Yolis", JOptionPane.INFORMATION_MESSAGE);
    }

    public void MensajeError(String Mensaje) {
        JOptionPane.showMessageDialog(this, Mensaje, "Papeleria Yolis", JOptionPane.ERROR_MESSAGE);
    }
    
    private void Limpiar()
    {
        txtID.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        txtNickName.setText("");
        txtTelefono.setText("");
        txtDomicilio.setText("");
        txtLocalidad.setText("");
        txtEstado.setText("");
        txtCP.setText("");
        txtCorreo.setText("");
        txtContrasena.setText("");
    }
    
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        TabClientes.setVisible(false);
        TabOperaciones.setVisible(true);
        Limpiar();
        accion = "guardar";
        btnGuardar.setText("Guardar");
        btnActualizar.setVisible(false);
        btnGuardar.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased

    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Listar(txtBusqueda.getText().trim());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tablaListado.getSelectedRowCount() == 1)
        {
            txtID.setText(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0).toString());
            txtNombre.setText(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1).toString());
            txtApellidos.setText(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2).toString());
            txtNickName.setText(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3).toString());
            nicknameant=(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3).toString());
            txtTelefono.setText(tablaListado.getValueAt(tablaListado.getSelectedRow(), 4).toString());
            txtDomicilio.setText(tablaListado.getValueAt(tablaListado.getSelectedRow(), 5).toString());
            txtLocalidad.setText(tablaListado.getValueAt(tablaListado.getSelectedRow(), 6).toString());
            txtEstado.setText(tablaListado.getValueAt(tablaListado.getSelectedRow(), 7).toString());
            txtCP.setText(tablaListado.getValueAt(tablaListado.getSelectedRow(), 8).toString());
            txtCorreo.setText(tablaListado.getValueAt(tablaListado.getSelectedRow(), 9).toString());

            TabClientes.setVisible(false);
            TabOperaciones.setVisible(true);
            accion = "editar";
            btnGuardar.setVisible(false);
            btnActualizar.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(this, "Debes seleccionar un registro","Papeleria Yolis",JOptionPane.WARNING_MESSAGE);

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Listar("");
        TabClientes.setVisible(true);
        TabOperaciones.setVisible(false);
        tablaListado.clearSelection();
        txtBusqueda.setText("");
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String resp;
        if(txtNombre.getText().isBlank() || txtApellidos.getText().isBlank() || txtNickName.getText().isBlank() || txtTelefono.getText().isBlank() || txtDomicilio.getText().isBlank() || txtLocalidad.getText().isBlank() || txtEstado.getText().isBlank() || txtCP.getText().isBlank() || txtCorreo.getText().isBlank() || txtContrasena.getText().isBlank())
        {
            JOptionPane.showMessageDialog(this, "Hay campos vacios.","Papeleria Yolis",JOptionPane.WARNING_MESSAGE);
            return;
        }
            resp = CONTROL.Insertar(txtNombre.getText().trim(), txtApellidos.getText().trim(), txtNickName.getText().trim(), txtTelefono.getText().trim(), txtDomicilio.getText().trim(), txtLocalidad.getText().trim(), txtEstado.getText().trim(), txtCP.getText().trim(), txtCorreo.getText().trim(), txtContrasena.getText().trim());
            if(resp.equals("OK"))
            {
                MensajeOk("Usuario registrado con exito.");
                Limpiar();
            }
            else
            {
                MensajeError("Error al registrar el usuario.");
                Limpiar();
            }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(!txtID.getText().isEmpty())
        {
            CONTROL.Eliminar(Integer.parseInt(txtID.getText().trim()));
            MensajeOk("Usuario eliminado.");
            Limpiar();
        }
        else
        MensajeError("Debes escribir una ID");
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(accion.equals("editar"))
        {
            String resp;
            resp = CONTROL.Actualizar(Integer.parseInt(txtID.getText()), txtNombre.getText().trim(), txtApellidos.getText().trim(), txtNickName.getText().trim(), nicknameant, txtTelefono.getText().trim(), txtDomicilio.getText().trim(), txtLocalidad.getText().trim(), txtEstado.getText().trim(), txtCP.getText().trim(), txtCorreo.getText().trim(), txtContrasena.getText().trim());
            if(resp.equals("OK"))
            {
                MensajeOk("Usuario actualizado con exito.");
                Limpiar();
            }
            else
            {
                MensajeError("Error al actualizar el usuario.");
                Limpiar();
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TabClientes;
    private javax.swing.JPanel TabOperaciones;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCP;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtNickName;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
