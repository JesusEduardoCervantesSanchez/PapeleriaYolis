package papeleriayolis;

import javax.swing.table.DefaultTableModel;
import database.Conexion;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Inventario extends javax.swing.JPanel {

    public Inventario() {
        initComponents();
        this.Conectar();
    }
    
    private void Conectar(){
        Conexion conn=Conexion.getInstance();
        PreparedStatement ps;
        ResultSet rs; //Almacenar los resultados de la consulta
        String consultaSQL="SELECT idProductos, nombreProducto, Categoria, PrecioVenta FROM Productos ORDER BY nombreProducto;";
        try{
            DefaultTableModel modelo=new DefaultTableModel();
            jtProductos.setModel(modelo);
            conn.Conectar();
            ps=conn.cadena.prepareStatement(consultaSQL);
            rs=ps.executeQuery();
            
            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Categoria");
            modelo.addColumn("Precio de venta");
            
            while(rs.next()){
                Object[] fila=new Object[4];
                for(int j=0; j<4; j++)
                    fila[j]=rs.getObject(j+1);
                modelo.addRow(fila);
            }
            
            rs.close();
            ps.close();
            conn.Desconectar();
            conn.cadena.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        finally{
            ps=null;
            conn=null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel2.setText("Productos");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 210, -1));

        txtBuscar.setBackground(new java.awt.Color(2, 174, 248));
        txtBuscar.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        txtBuscar.setBorder(null);
        txtBuscar.setBackground(new java.awt.Color(0,0,0,1));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 210, 30));

        jtProductos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Categoría", "Precio de venta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 540, 290));

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel3.setText("Buscar");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/wallhaven-4gmmee.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 460));

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

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        Conexion conn=Conexion.getInstance();
        PreparedStatement ps;
        ResultSet rs; //Almacenar los resultados de la consulta
        String consultaSQL="SELECT nombreProducto,Existencias,Categoria,PrecioVenta FROM Productos WHERE nombreProducto LIKE ? OR Categoria LIKE ? ORDER BY nombreProducto;";
        try{
            DefaultTableModel modelo=new DefaultTableModel();
            jtProductos.setModel(modelo);
            conn.Conectar();
            ps=conn.cadena.prepareStatement(consultaSQL);
            ps.setString(1,"%"+ txtBuscar.getText() + "%");
            ps.setString(2,"%"+ txtBuscar.getText() + "%");
            rs=ps.executeQuery();
            
            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Categoria");
            modelo.addColumn("Precio de compra");
            
            while(rs.next()){
                Object[] fila=new Object[4];
                for(int j=0; j<4; j++)
                    fila[j]=rs.getObject(j+1);
                modelo.addRow(fila);
            }
            rs.close();
            ps.close();
            conn.Desconectar();
            conn.cadena.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        finally{
            ps=null;
            conn=null;
        }
    }//GEN-LAST:event_txtBuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jtProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
