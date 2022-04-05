/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entidades.Ventas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author CSjes
 */
public class VentasDAO implements CrudSimpleInterface<Ventas> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public VentasDAO() {
        this.CON = Conexion.getInstance();
    }

    public List<Ventas> listar(String texto) {
        List<Ventas> registros = new ArrayList();
        try {
            ps = CON.Conectar().prepareStatement("SELECT * FROM Ventas WHERE idVentas = ?");
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Ventas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getString(7)));
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
    }

    @Override
    public boolean insertar(Ventas obj) {
        resp = false;
        String consultaSQL = "INSERT INTO Ventas(numeroVenta, nombreCliente, categoriaProducto, cantidad, precioVenta, fechaVenta )"
                + "VALUES(?,?,?,?,?,?) ;";
        try {
            ps = CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNumeroVenta());
            ps.setString(2, obj.getNombreCliente());
            ps.setString(3, obj.getCategoriaProducto());
            ps.setInt(4, obj.getCantidad());
            ps.setDouble(5, obj.getPrecioVenta());
            ps.setString(6, obj.getFechaVenta());
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
    }

    @Override
    public boolean actualizar(Ventas obj) {
        resp = false;
        String consultaSQL = "update Ventas set numeroVenta  =?, nombreCliente =?, categoriaProducto=?, cantidad=?, precioVenta=?, fechaVenta=? where idVentas = ?;";
        try {
            ps = CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNumeroVenta());
            ps.setString(2, obj.getNombreCliente());
            ps.setString(3, obj.getCategoriaProducto());
            ps.setInt(4, obj.getCantidad());
            ps.setDouble(5, obj.getPrecioVenta());
            ps.setString(6, obj.getFechaVenta());
            ps.setInt(7, obj.getIdVentas());
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
    }

    @Override
    public boolean desactivar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean activar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int total() {
        int numeroregistros = 0;
        try {
            ps = CON.Conectar().prepareStatement("SELECT COUNT(*) FROM Ventas; ");
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroregistros = rs.getInt(1);
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
        return numeroregistros;
    }

    @Override
    public boolean existe(String texto) {
        resp = false;
        try {
            ps = CON.Conectar().prepareStatement("SELECT * FROM Ventas WHERE numeroVenta = ?;");
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
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Ventas> listar(int id) {
        List<Ventas> registros = new ArrayList();
        try {
            ps = CON.Conectar().prepareStatement("SELECT * FROM Ventas WHERE idVentas = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Ventas(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getString(7)));
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
    }
}
