/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import database.Conexion;
import datos.interfaces.CrudVentaInterface;
import entidades.Clientes;
import entidades.Empleados;
import entidades.Pro_Ven;
import entidades.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import entidades.Ventas;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author CSjes
 */
public class VentasDAO implements CrudVentaInterface<Ventas, Pro_Ven, Producto, Clientes, Empleados> {

    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public VentasDAO() {
        this.CON = Conexion.getInstance();
    }

    @Override
    public List<Ventas> listar(String texto) {
        List<Ventas> registros = new ArrayList();
        //Consulta que busca las ventas por un numero de folio (String)
        String sql = "SELECT DISTINCT V.idVentas, C.idCliente, C.NombreCliente, E.idEmpleado, E.NombreEmpleado, V.FolioVenta, V.FechaVenta, V.SubTotal, V.IVA\n"
                + " FROM Clientes C INNER JOIN (Cli_Ven CV INNER JOIN (Ventas V INNER JOIN (Emp_Ven EV INNER JOIN Empleados E ON E.idEmpleado=EV.idEmpleado) ON EV.idVentas=V.idVentas) ON V.idVentas = CV.idVentas) on CV.idCliente = C.idCliente\n"
                + " WHERE V.FolioVenta like ?;";
        try {
            ps = CON.Conectar().prepareStatement(sql);
            ps.setString(1, "%" + texto + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                //int idVentas, int idCliente, String ClienteNombre, int idEmpleado, String NombreEmpleado, String FolioVenta, Date FechaVenta, double SubTotal, double IVA
                registros.add(new Ventas(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getString(6), rs.getDate(7), rs.getDouble(8), rs.getDouble(9)));
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
    public List<Pro_Ven> listarDetalle(int idVenta) {
        List<Pro_Ven> registros = new ArrayList();
        //Consulta que busca las ventas por un numero de folio (String)
        String sql = "SELECT  V.idVentas, P.idProductos, P.nombreProducto, P.Existencias, PV.CantProVen, PV.PrecioU, V.SubTotal \n"
                + "FROM Ventas V INNER JOIN ( Productos P INNER JOIN Pro_Ven PV ON P.idProductos=PV.idProductos) ON PV.idVentas=V.idVentas \n"
                + "WHERE V.idVentas = ?;";
        try {
            ps = CON.Conectar().prepareStatement(sql);
            ps.setInt(1, idVenta);
            rs = ps.executeQuery();
            while (rs.next()) {
                //int idProductos, int idVentas, String NombreProducto, int Existencia, int CantProVen, double PrecioU, double SubTotal
                registros.add(new Pro_Ven(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getInt(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7)));
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
        Connection conn = null;
        String InsertarVenta = "INSERT INTO Ventas(FolioVenta, SubTotal, IVA) VALUES(?,?,?);";
        try {
            conn = CON.Conectar();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(InsertarVenta, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getFolioVenta());
            ps.setDouble(2, obj.getSubTotal());
            ps.setDouble(3, obj.getIVA());
            int filasAfectadas = ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            int idVenta = 0;
            if (rs.next()) {
                idVenta = rs.getInt(1);
            }
            if (filasAfectadas == 1) {
                String insertDetalleVenta = "INSERT INTO Pro_Ven(idVentas, idProductos, CantProVen, PrecioU) values(?,?,?,?);";
                ps = conn.prepareStatement(insertDetalleVenta);
                for (Pro_Ven item : obj.getDetalles()) {
                    ps.setInt(1, idVenta);
                    ps.setInt(2, item.getIdProductos());
                    ps.setInt(3, item.getCantProVen());
                    ps.setDouble(4, item.getPrecioU());
                    resp = ps.executeUpdate() > 0;
                }
                //Cometer la transaccion
                conn.commit();
            } else {
                //Deshacer la transacción
                conn.rollback();
            }
        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error" + ex);
            }
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(VentasDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
    }

    @Override
    public int total() {
        int numeroregistros = 0;
        try {
            ps = CON.Conectar().prepareStatement("SELECT COUNT(*) FROM Ventas; ");//El parametro del count, si se le ingresa un asterisco toma en cuenta solo nulos
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
            ps = CON.Conectar().prepareStatement("SELECT 1 FROM Ventas WHERE FolioVenta = ?;");
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
    public List<Producto> ListarProductos(String valor) {
        List<Producto> registros = new ArrayList();
        try {
            String sql = "SELECT P.idProductos, P.idCategoria, P.nombreProducto, C.NombreCategoria, P.Existencias, P.PrecioCompra, P.PrecioVenta, P.Ganancia, P.ImagenProducto FROM Productos P INNER JOIN Categorias C ON C.idCategoria=P.idCategoria WHERE P.nombreProducto LIKE ? OR C.NombreCategoria LIKE ? ORDER BY P.idProductos ASC";
            ps = CON.Conectar().prepareStatement(sql);
            ps.setString(1, "%" + valor + "%");
            ps.setString(2, "%" + valor + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros.add(new Producto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getString(9)));
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
    public List<Empleados> ListarEmpleado(String valor) {
        List<Empleados> registros = new ArrayList();
        try {
            String sql = "SELECT idEmpleado, NombreEmpleado, TelefonoEmpleado, DomicilioEmpleado, CPEmpleado, CorreoEmpleado, ContraseñaEmpleado FROM Empleados ORDER BY idEmpleado ASC";
            String buscar = "SELECT idEmpleado, NombreEmpleado, TelefonoEmpleado, DomicilioEmpleado, CPEmpleado, CorreoEmpleado, ContraseñaEmpleado FROM Empleados WHERE NombreEmpleado LIKE '%" + valor + "%' OR TelefonoEmpleado LIKE '%" + valor + "%' OR CorreoEmpleado LIKE '%" + valor + "%' ORDER BY idEmpleado ASC";
            if (valor.equalsIgnoreCase("")) {
                ps = CON.Conectar().prepareStatement(sql);
            } else {
                ps = CON.Conectar().prepareStatement(buscar);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                //la linea siguiente probablememtne tiene error en rs.getInt(2), tal vez deberia ser con String
                registros.add(new Empleados(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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
    public boolean insertarEmP_Ven(int idVenta, int idEmpleado) {
        resp = false;
        String consultaSQL = "Insert into Emp_Ven(idVentas, idEmpleado)";
        consultaSQL += "VALUES(?, ?)";
        try {
            ps = CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, idVenta);
            ps.setInt(2, idEmpleado);
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
    public boolean insertarCli_Ven(int idVenta, int idCliente) {
        resp = false;
        String consultaSQL = "Insert into Cli_Ven(idVentas, idCliente)";
        consultaSQL += "VALUES(?, ?)";
        try {
            ps = CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, idVenta);
            ps.setInt(2, idCliente);
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
    public List<Clientes> ListarCliente(String valor) {
        List<Clientes> registros = new ArrayList();
        try {
            //int idCliente, String nombreCliente, String apellidosCliente, String telefonoCliente, String correoCliente
            String sql = "SELECT idCliente, NombreCliente, ApellidosCliente, TelefonoCliente, CorreoCliente FROM Clientes ORDER BY idCliente ASC";
            String buscar = "SELECT idCliente, NombreCliente, ApellidoCliente, TelefonoCliente, CorreoCliente FROM Clientes WHERE NombreCliente LIKE '%" + valor + "%' ORDER BY idClientes ASC";
            if (valor.equalsIgnoreCase("")) {
                ps = CON.Conectar().prepareStatement(sql);
            } else {
                ps = CON.Conectar().prepareStatement(buscar);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                //la linea siguiente probablememtne tiene error en rs.getInt(2), tal vez deberia ser con String
                registros.add(new Clientes(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
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
    public int ActualizarStock(int cant, int id) {
        int r = 0;
        String sql = "UPDATE Productos SET Existencias=? WHERE idProductos=?";
        try {
            ps = CON.Conectar().prepareStatement(sql);
            ps.setDouble(1, cant);
            ps.setInt(2, id);
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
        return r;
    }

    @Override
    public int ObtenerStock(int id) {
        int r = 0;
        String sql = "SELECT Existencias FROM Productos WHERE idProductos = ?";
        try {
            ps = CON.Conectar().prepareStatement(sql);
            ps.setDouble(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                r = rs.getInt(1);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            ps = null;
            CON.Desconectar();
        }
        return r;
    }

    @Override
    public int RegresarIdVenta(String Folio) {
        int idVenta = 0;
        try {
            ps = CON.Conectar().prepareStatement(" Select idVentas from Ventas where FolioVenta Like ?;");//El parametro del count, si se le ingresa un asterisco toma en cuenta solo nulos
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
