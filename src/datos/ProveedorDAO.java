/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import database.Conexion;
import datos.interfaces.CrudProvedor;
import entidades.DetalleProvedor;
import entidades.Provedores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Pablo Campos L
 */
public class ProveedorDAO implements CrudProvedor<Provedores,DetalleProvedor>{
    
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public ProveedorDAO() {
        CON =Conexion.getInstance();
    }

    @Override
    public List<Provedores> listar(String texto) {
        List<Provedores> registros=new ArrayList();
        try {
            ps = CON.Conectar().prepareStatement("SELECT * FROM Provedores where nombreProvedor like ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Provedores(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6)));
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

        return registros;
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DetalleProvedor> ListarDetalle(int idProvedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insertar(Provedores obj) {
resp = false;
        String consultaSQL = "insert into Provedores(nombreProvedor, codigoProvedor, telefonoProvedor, correoProvedor, EmpresaProvedor )\n"
                + "values(?,?,?,?,?) ;";
        try {
            ps = CON.Conectar().prepareStatement(consultaSQL);
           ps.setString(1, obj.getNombreProvedor());
           ps.setInt(2, obj.getCodigo());
           ps.setString(3, obj.getTelefono());
           ps.setString(4, obj.getCorreo());
           ps.setString(5, obj.getEmpresa());

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.Desconectar();
        }
        return resp;        
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Provedores obj) {
 resp = false;
        String consultaSQL = "update Provedores set nombreProvedor=?,codigoProvedor=?,telefonoProvedor=?,correoProvedor=?,EmpresaProvedor=? where idProvedores=?;";
        try {
            ps = CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombreProvedor());
           ps.setInt(2, obj.getCodigo());
           ps.setString(3, obj.getTelefono());
           ps.setString(4, obj.getCorreo());
           ps.setString(5, obj.getEmpresa());
           ps.setInt(6, obj.getIdProvedores());
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.Desconectar();
        }
        return resp;        
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean desactivar(int id) {
 resp = false;
        String consultaSQL = "delete from Provedores where idProvedores=?";
        try {
            ps = CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.Desconectar();
        }
        return resp;        
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int total() {
int numeroderegistros = 0;
        try {
            ps = CON.Conectar().prepareStatement("select count(idProvedores) from Provedores;");
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroderegistros = rs.getInt(1); //getString(String) 
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

        return numeroderegistros;        
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existe(String texto) {
resp = false;
        try {
            ps = CON.Conectar().prepareStatement("select * from Provedores where idProvedores=?;");
            ps.setString(1, texto);
            rs = ps.executeQuery();
            if (rs.next()) {
                resp = true;
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

        return resp;        
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

}
