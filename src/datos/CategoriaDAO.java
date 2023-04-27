package datos;

import database.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import datos.interfaces.CrudSEInterface;
import entidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAO implements CrudSEInterface<Categoria> {
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;
    
    public CategoriaDAO(){
        CON = Conexion.getInstance();
    }
    
    @Override
    public List<Categoria> listar(String texto, int combo) {
        List<Categoria> registros=new ArrayList();
        try{
            ps=(combo==1)?CON.Conectar().prepareStatement("SELECT * FROM Categorias WHERE nombreCategoria LIKE ? AND ActivoCategoria=true ORDER BY nombreCategoria;"):
                    CON.Conectar().prepareStatement("SELECT * FROM Categorias WHERE nombreCategoria LIKE ? ORDER BY nombreCategoria;");
            ps.setString(1, '%' + texto + '%');
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Categoria(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5)));
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
        return registros;
    }

    @Override
    public boolean insertar(Categoria obj) {
        resp=false;
        String consultaSQL="insert into Categorias(NombreCategoria, DescripcionCategoria, ImagenCategoria, ActivoCategoria)\n" +
        "values(?,?,?,?);";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombreCategoria() );
            ps.setString(2, obj.getDescripcionCategoria());
            ps.setString(3, obj.getImagenCategoria());
            ps.setBoolean(4, obj.isActivoCategoria());
            
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
    public boolean actualizar(Categoria obj) {
        resp=false;
        String consultaSQL="UPDATE Categorias SET NombreCategoria=?, DescripcionCategoria=?, ImagenCategoria=?"
                + "WHERE idCategoria = ?;";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombreCategoria() );
            ps.setString(2, obj.getDescripcionCategoria());
            ps.setString(3, obj.getImagenCategoria());
            ps.setInt(4, obj.getIdCategoria());
            
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
    public boolean desactivar(int id) {
        resp=false;
        String consultaSQL="UPDATE Categorias SET ActivoCategoria = 0 WHERE idCategoria=?";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, id);
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
    public boolean activar(int id) {
        resp=false;
        String consultaSQL="UPDATE Categorias SET ActivoCategoria = 1 WHERE idCategoria=?";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, id);
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
        return resp;    }

    @Override
    public int total() {
        int numeroRegistros=0;
        try{
            ps=CON.Conectar().prepareStatement("SELECT COUNT(*) FROM Categorias;");
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
            ps=CON.Conectar().prepareStatement("SELECT * FROM Categorias WHERE NombreCategoria=?;");
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
}
