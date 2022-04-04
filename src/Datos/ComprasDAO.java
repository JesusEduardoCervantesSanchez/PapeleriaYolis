/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import Datos.Interfaces.CrudSimpleCompras;
import Entidades.Compras;
import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ComprasDAO implements CrudSimpleCompras<Compras>{

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public ComprasDAO() {
        CON = Conexion.getInstance();
    }
    
    public List Listar(int id) {
        List<Compras> registros = new ArrayList();
        try{
           ps = CON.Conectar().prepareStatement("SELECT * FROM compras WHERE numeroCompra = ?");
           ps.setInt(1, id);
           rs = ps.executeQuery();
           while(rs.next()){
               registros.add(new Compras(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6)));
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
        String consultaSQL = "INSERT INTO compras (nombreProveedor,categoriaProd,cantidad,precioCompra,fechaCompra)";
        consultaSQL += "VALUES(?, ?, ?, ?, ?)";
        try{
           ps = CON.Conectar().prepareStatement(consultaSQL);
           ps.setString(1, obj.getNombreProveedor());
           ps.setString(2, obj.getCategoriaProd());
           ps.setInt(3, obj.getCantidad());
           ps.setDouble(4, obj.getPrecioCompra());
           ps.setString(5, obj.getFechaCompra());
           
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
    public boolean actualizar(Compras obj) {
        resp = false;
        String consultaSQL = "UPDATE compras SET nombreProveedor=?,categoriaProd=?,cantidad=?,precioCompra=?,fechaCompra=? WHERE numeroCompra = ?";
        try{
           ps = CON.Conectar().prepareStatement(consultaSQL);
           ps.setString(1, obj.getNombreProveedor());
           ps.setString(2, obj.getCategoriaProd());
           ps.setInt(3, obj.getCantidad());
           ps.setDouble(4, obj.getPrecioCompra());
           ps.setString(5, obj.getFechaCompra());
           ps.setInt(6, obj.getNumeroCompra());
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
    public boolean eliminar(int id) {
        resp = false;
        String consultaSQL = "DELETE FROM compras WHERE numeroCompra = ?";
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
    public int total() {
         int numeroRegistros=0;
        try{
           ps = CON.Conectar().prepareStatement("SELECT COUNT(*) from compras;");
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
    public boolean existe(String id) {
        resp = false;
        try{
           ps = CON.Conectar().prepareStatement("SELECT * from compras WHERE numeroCompra = ?;");
           ps.setInt(1, Integer.parseInt(id));
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
    public boolean desactivar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean activar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
