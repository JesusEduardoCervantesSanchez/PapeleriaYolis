/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import entidades.Compras;
import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Datos.Interfaces.CrudSimpleCompras;
import entidades.CompraDetalle;
import entidades.Provedores;
import entidades.Empleados;
import entidades.Producto;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComprasDAO implements CrudSimpleCompras<Compras, CompraDetalle, Producto, Provedores, Empleados>{

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public ComprasDAO() {
        CON = Conexion.getInstance();
    }
    
    public List Listar(String texto) {
        List<Compras> registros = new ArrayList();
        try{
            String sql = "SELECT DISTINCT C.idCompras, P.idProvedores, P.nombreProvedor, E.idEmpleado, E.NombreEmpleado, C.FolioCompra, C.Descuento,\n" +
            " C.SubtotalCompra, C.IVA, C.FechaCompra, C.Total, C.Estado\n" +
            " FROM Provedores P INNER JOIN (Prov_Comp PC INNER JOIN (Compras C INNER JOIN (Emp_Com EC INNER JOIN Empleados E ON E.idEmpleado=EC.idEmpleado) ON EC.idCompras=C.idCompras) ON C.idCompras = PC.idCompras) on PC.idProvedores = P.idProvedores\n" +
            " ORDER BY C.idCompras ASC";
            String buscar = "SELECT DISTINCT C.idCompras, P.idProvedores, P.nombreProvedor, E.idEmpleado, E.NombreEmpleado, C.FolioCompra, C.Descuento,\n" +
               " C.SubtotalCompra, C.IVA, C.FechaCompra, C.Total, C.Estado\n" +
               " FROM Provedores P INNER JOIN (Prov_Comp PC INNER JOIN (Compras C INNER JOIN (Emp_Com EC INNER JOIN Empleados E ON E.idEmpleado=EC.idEmpleado) ON EC.idCompras=C.idCompras) ON C.idCompras = PC.idCompras) on PC.idProvedores = P.idProvedores\n" +
               " WHERE C.FolioCompra like '%"+texto+"%' OR P.nombreProvedor like '%"+texto+"%' OR C.FechaCompra like '%"+texto+"%' ORDER BY C.idCompras ASC";
           if(texto.equalsIgnoreCase("")){
               ps = CON.Conectar().prepareStatement(sql);
           }else{
               ps = CON.Conectar().prepareStatement(buscar);
           }
           rs = ps.executeQuery();
           while(rs.next()){
               registros.add(new Compras(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getString(10), rs.getDouble(11), rs.getString(12)));
           }
           ps.close();
           rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps = null;
            rs = null;
            CON.Desconectar();
        }
        return registros;
    }

        @Override
    public List<CompraDetalle> ListarDetalle(int idCompra) {
        List<CompraDetalle> registros = new ArrayList();
        try{
            ps = CON.Conectar().prepareStatement("SELECT PC.idCompras, PC.idProductos, P.nombreProducto, PC.Cantidad, PC.Precio, PC.Descuento, PC.Subtotal\n" +
            " FROM Pro_Comp PC inner join Productos P ON P.idProductos=PC.idProductos\n" +
            " WHERE PC.idCompras=?;");
           ps.setInt(1, idCompra);
           rs = ps.executeQuery();
           while(rs.next()){
               //int idDetalleVenta, int idProducto, int idVenta, String productoNombre, int productoExistencia, int Cantidad, double precio, double descuento, double subTotal) {
               registros.add(new CompraDetalle(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7)));
           }
           ps.close();
           rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps = null;
            rs = null;
            CON.Desconectar();
        }
        return registros;
    }
    
    
    @Override
    public boolean insertar(Compras obj) {
        resp = false;
        Connection conn = null;
        String InsertarCompra = "INSERT INTO Compras(FolioCompra, Descuento, SubtotalCompra, IVA, FechaCompra, Total)\n" +
        " values (?, ?, ?, ?, ?, ?);";
        try{
           conn = CON.Conectar();
           conn.setAutoCommit(false);
           ps = conn.prepareStatement(InsertarCompra, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, obj.getFolioCompra());
           ps.setDouble(2, obj.getDescuento());
           ps.setDouble(3, obj.getSubtotalCompra());
           ps.setDouble(4, obj.getIVA());
           ps.setString(5, obj.getFechaCompra());
           ps.setDouble(6, obj.getTotal());
           
           int filasAfectadas = ps.executeUpdate();
           rs = ps.getGeneratedKeys();
           int idCompra = 0;
           if(rs.next()){
               idCompra = rs.getInt(1);
           }
           if(filasAfectadas == 1){
               //se inserto la venta  correctamente
               String InsertarDetalleVenta = "Insert into Pro_Comp(idCompras, idProductos, Cantidad, Precio, Descuento, Subtotal)\n" +
            " values(?,?,?,?,?,?);";
                ps = conn.prepareStatement(InsertarDetalleVenta);
               for (CompraDetalle item : obj.getDetalle()) {
                   ps.setInt(1, idCompra);
                   ps.setInt(2, item.getIdProductos());
                   ps.setInt(3, item.getCantidad());
                   ps.setDouble(4, item.getPrecio());
                   ps.setDouble(5, item.getDescuento());
                   ps.setDouble(6, item.getSubtotal());
                   resp=ps.executeUpdate()>0;
               } //aqui se cierra el for
                conn.commit();
           }else{
               //Deshacer la transaccion
               conn.rollback();
           }    
        }catch(SQLException e){
            try{
                if(conn != null)
                    conn.rollback();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error" + ex);
            }
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            try {
                if(ps!=null)
                    ps.close();
                if(rs!=null)
                    rs.close();
                if(conn!=null)
                    conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ComprasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }
    
    @Override
    public boolean insertarEmP_Com(int idCompra, int idEmpleado){
        resp = false;
        String consultaSQL = "Insert into Emp_Com(idCompras, idEmpleado)";
        consultaSQL += "VALUES(?, ?)";
        try{
           ps = CON.Conectar().prepareStatement(consultaSQL);
           ps.setInt(1, idCompra);
           ps.setInt(2, idEmpleado);
           if(ps.executeUpdate() > 0){
               resp = true;
           }
           ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps = null;
            CON.Desconectar();
        }
        return resp;
    }
    
    @Override
    public boolean insertarProv_Comp(int idCompra, int idProvedor){
        resp = false;
        String consultaSQL = "Insert into Prov_Comp(idCompras, idProvedores)";
        consultaSQL += "VALUES(?, ?)";
        try{
           ps = CON.Conectar().prepareStatement(consultaSQL);
           ps.setInt(1, idCompra);
           ps.setInt(2, idProvedor);
           if(ps.executeUpdate() > 0){
               resp = true;
           }
           ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps = null;
            CON.Desconectar();
        }
        return resp;
    }
    

    @Override
    public int total() {
         int numeroRegistros=0;
        try{
           ps = CON.Conectar().prepareStatement("SELECT COUNT(*) from Compras;");
           rs = ps.executeQuery();
           while(rs.next()){
               numeroRegistros = rs.getInt(1); //getString(String);
           }
           ps.close();
           rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps = null;
            rs = null;
            CON.Desconectar();
        }
        return numeroRegistros;
    }

    @Override
    public boolean existe(String Folio) {
        resp = false;
        try{
           ps = CON.Conectar().prepareStatement("SELECT * from Compras WHERE FolioCompra = ?;");
           ps.setString(1, Folio);
           rs = ps.executeQuery();
           if(rs.next()){
               resp = true;
           }
           ps.close();
           rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps = null;
            rs = null;
            CON.Desconectar();
        }
        return resp;
    }

    @Override
    public boolean cancelar(int id) {
        resp = false;
        String consultaSQL = "UPDATE Compras SET estado = 'Cancelada' WHERE idCompras = ?;";
        try{
           ps = CON.Conectar().prepareStatement(consultaSQL);
           ps.setInt(1, id);
           
           if(ps.executeUpdate() > 0){
               resp = true;
           }
           ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps = null;
            CON.Desconectar();
        }
        return resp;
    }

    @Override
    public List<Producto> ListarProductos(String valor) {
        List<Producto> registros = new ArrayList();
        try{
           String sql = "SELECT P.idProductos, P.idCategoria, P.nombreProducto, C.NombreCategoria, P.Existencias, P.PrecioCompra, P.PrecioVenta, P.Ganancia, P.ImagenProducto FROM Productos P INNER JOIN Categorias C ON C.idCategoria=P.idCategoria WHERE P.nombreProducto LIKE ? OR C.NombreCategoria LIKE ? ORDER BY P.idProductos ASC";
           ps = CON.Conectar().prepareStatement(sql);
           ps.setString(1, "%" + valor + "%");
           ps.setString(2, "%" + valor + "%");
           rs = ps.executeQuery();
           while(rs.next()){
               registros.add(new Producto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getString(9)));
           }
           ps.close();
           rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps = null;
            rs = null;
            CON.Desconectar();
        }
        return registros;
    }

    @Override
    public int ActualizarStock(int cant, int id) {
        int r = 0;
        String sql = "UPDATE Productos SET Existencias=? WHERE idProductos=?";
        try{
           ps = CON.Conectar().prepareStatement(sql);
           ps.setDouble(1, cant);
           ps.setInt(2, id);
           if(ps.executeUpdate() > 0){
               resp = true;
           }
           ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps = null;
            CON.Desconectar();
        }
        return r;
    }

    @Override
    public int ObtenerStock(int id) {
        int r = 0;
        String sql = "SELECT Existencias FROM Productos WHERE idProductos = ?";
        try{
           ps = CON.Conectar().prepareStatement(sql);
           ps.setDouble(1, id);
           rs = ps.executeQuery();
           while (rs.next()){
               r = rs.getInt(1);
           }
           ps.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps = null;
            CON.Desconectar();
        }
        return r;
    }

    @Override
    public List<Provedores> ListarProvedor(String valor) {
        List<Provedores> registros = new ArrayList();
        try{
           String sql = "SELECT idProvedores, nombreProvedor, codigoProvedor, telefonoProvedor, correoProvedor, EmpresaProvedor FROM Provedores ORDER BY idProvedores ASC";
           String buscar = "SELECT idProvedores, nombreProvedor, codigoProvedor, telefonoProvedor, correoProvedor, EmpresaProvedor FROM Provedores WHERE nombreProvedor LIKE '%"+valor+"%' OR codigoProvedor LIKE '%"+valor+"%' OR telefonoProvedor LIKE '%"+valor+"%' OR correoProvedor LIKE '%"+valor+"%' ORDER BY idProvedores ASC";
           if(valor.equalsIgnoreCase("")){
               ps = CON.Conectar().prepareStatement(sql);
           }else{
               ps = CON.Conectar().prepareStatement(buscar);
           }
           rs = ps.executeQuery();
           while(rs.next()){
               //la linea siguiente probablememtne tiene error en rs.getInt(2), tal vez deberia ser con String
               registros.add(new Provedores(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6)));
           }
           ps.close();
           rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps = null;
            rs = null;
            CON.Desconectar();
        }
        return registros;
    }

    @Override
    public List<Empleados> ListarEmpleado(String valor) {
        List<Empleados> registros = new ArrayList();
        try{
           String sql = "SELECT idEmpleado, NombreEmpleado, TelefonoEmpleado, DomicilioEmpleado, CPEmpleado, CorreoEmpleado, ContraseñaEmpleado FROM Empleados ORDER BY idEmpleado ASC";
           String buscar = "SELECT idEmpleado, NombreEmpleado, TelefonoEmpleado, DomicilioEmpleado, CPEmpleado, CorreoEmpleado, ContraseñaEmpleado FROM Empleados WHERE NombreEmpleado LIKE '%"+valor+"%' OR TelefonoEmpleado LIKE '%"+valor+"%' OR CorreoEmpleado LIKE '%"+valor+"%' ORDER BY idEmpleado ASC";
           if(valor.equalsIgnoreCase("")){
               ps = CON.Conectar().prepareStatement(sql);
           }else{
               ps = CON.Conectar().prepareStatement(buscar);
           }
           rs = ps.executeQuery();
           while(rs.next()){
               //la linea siguiente probablememtne tiene error en rs.getInt(2), tal vez deberia ser con String
               registros.add(new Empleados(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
           }
           ps.close();
           rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps = null;
            rs = null;
            CON.Desconectar();
        }
        return registros;
    }

    @Override
    public int RegresarIdCompra(String Folio) {
         int idVenta = 0;
        try {
            ps = CON.Conectar().prepareStatement(" Select idCompras from Compras where FolioCompra Like ?;");//El parametro del count, si se le ingresa un asterisco toma en cuenta solo nulos
            ps.setString(1, "%" + Folio + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                idVenta = rs.getInt(1);
            }
            ps.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            rs = null;
            CON.Desconectar();
        }
        return idVenta;
    }
}
