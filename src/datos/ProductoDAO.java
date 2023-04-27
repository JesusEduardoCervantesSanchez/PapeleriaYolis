package datos;

import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import entidades.Producto;
import datos.interfaces.CrudProductoInterface;

public class ProductoDAO implements CrudProductoInterface<Producto> {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public ProductoDAO(){
        CON = Conexion.getInstance();
    }
    
    @Override
    public List<Producto> listar(String texto) {
        List<Producto> registros=new ArrayList();
        try{
            ps=CON.Conectar().prepareStatement("SELECT P.idProductos, C.idCategoria, P.nombreProducto, C.NombreCategoria, P.Existencias, P.PrecioCompra, P.PrecioVenta,\n" +
                                                " P.Ganancia, P.ImagenProducto\n" +
                                                " FROM Productos P INNER JOIN Categorias C ON P.idCategoria = C.idCategoria\n" +
                                                " WHERE nombreProducto like ?;");
            ps.setString(1, '%' + texto + '%');
            rs=ps.executeQuery();
            while(rs.next())
                registros.add(new Producto(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getString(9)));
            ps.close();
            rs.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            rs=null;
            CON.Desconectar();
        }
        return registros;
    }

    @Override
    public boolean insertar(Producto obj) {
        resp=false;
        String consultaSQL="INSERT INTO Productos(idCategoria, nombreProducto, Existencias, PrecioCompra, PrecioVenta, Ganancia, ImagenProducto) \n" +
                            "VALUES(?,?,?,?,?,?,?);";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, obj.getIdCategoria());
            ps.setString(2, obj.getNombreProducto());
            ps.setInt(3, obj.getExistencias());
            ps.setDouble(4, obj.getPrecioCompra());
            ps.setDouble(5, obj.getPrecioVenta());
            ps.setDouble(6, obj.getGanancia());
            ps.setString(7, obj.getImagenProducto());
            
            if(ps.executeUpdate() > 0)
            {
                resp=true;
            }
            ps.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            CON.Desconectar();
        }
        return resp;
    }

    @Override
    public boolean actualizar(Producto obj) {
        resp=false;
        String consultaSQL="UPDATE Productos SET idCategoria=?, nombreProducto=?, Existencias=?, PrecioCompra=?, \n" +
                           "PrecioVenta=?, Ganancia=?, ImagenProducto=? WHERE idProductos=?;";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, obj.getIdCategoria());
            ps.setString(2, obj.getNombreProducto());
            ps.setInt(3, obj.getExistencias());
            ps.setDouble(4, obj.getPrecioCompra());
            ps.setDouble(5, obj.getPrecioVenta());
            ps.setDouble(6, obj.getGanancia());
            ps.setString(7, obj.getImagenProducto());
            ps.setInt(8, obj.getIdProducto());
            
            if(ps.executeUpdate() > 0)
            {
                resp=true;
            }
            ps.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            CON.Desconectar();
        }
        return resp;
    }

    @Override
    public int total() {
        int numeroRegistros=0;
        try{
            ps=CON.Conectar().prepareStatement("SELECT COUNT(*) FROM Productos;");
            rs=ps.executeQuery();
            while(rs.next()){
            numeroRegistros=rs.getInt(1);  // getString(String)
        }
        ps.close();
        rs.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            rs=null;
            CON.Desconectar();
        }
        return numeroRegistros;    
    }

    @Override
    public boolean existe(String texto) {
        resp=false;
        try{
            ps=CON.Conectar().prepareStatement("SELECT * FROM Productos WHERE nombreProducto=?;");
            ps.setString(1, texto);
            rs=ps.executeQuery();
            if(rs.next()){
            resp=true;  //getString(String)
            }
            ps.close();
            rs.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            rs=null;
            CON.Desconectar();
        }
        return resp;       
    }
    
    @Override
    public boolean eliminar(String NombreProducto) {
        resp=false;
        String consultaSQL="DELETE FROM Productos WHERE nombreProducto=?;";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, NombreProducto);
            if(ps.executeUpdate() > 0)
            {
                resp=true;
            }
            ps.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally{
            ps=null;
            CON.Desconectar();
        }
        return resp;    
    }
}
