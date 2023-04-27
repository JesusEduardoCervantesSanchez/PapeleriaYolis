/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import datos.interfaces.CrudEmpleadosInterface;
import database.Conexion;
import entidades.Empleados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristianss
 */
public class EmpleadosDAO implements CrudEmpleadosInterface<Empleados>{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public EmpleadosDAO() 
    {
        CON = Conexion.getInstance();
    }
    
  
    public List<Empleados> listar(String texto) 
    {
        List<Empleados> registros=new ArrayList();
          try{
            ps=CON.Conectar().prepareStatement("SELECT * FROM Empleados WHERE nombreEmpleado LIKE ?");
            ps.setString(1, '%' + texto + '%');
            rs=ps.executeQuery();
            while(rs.next()){
                registros.add(new Empleados(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getBoolean(9)));
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
    public boolean insertar(Empleados obj) 
    {
        resp=false;
        String consultaSQL="INSERT INTO Empleados(NombreEmpleado, TelefonoEmpleado, DomicilioEmpleado, CPEmpleado, CorreoEmpleado, ContraseñaEmpleado, ImagenEmpleado, activo)\n" +
                           " values(?,?,?,?,?,?,?,?);";
        try{
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombreEmpleado());
            ps.setString(2, obj.getTelefonoEmpleado() );
            ps.setString(3, obj.getDomicilioEmpleado());
            ps.setString(4, obj.getCpEmpleado());
            ps.setString(5, obj.getCorreoEmpleado());
            ps.setString(6, obj.getContraseñaEmpleado());
            ps.setString(7, obj.getImagenEmpleado());
            ps.setBoolean(8, true);
            
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
    public boolean actualizar(Empleados obj) 
    {
        resp=false;
        String consultaSQL = "UPDATE Empleados SET NombreEmpleado=?, TelefonoEmpleado=?, DomicilioEmpleado=?, CPEmpleado=?, CorreoEmpleado=?, ContraseñaEmpleado=?, ImagenEmpleado=? " +
"WHERE idEmpleado = ?;";
         try
        {
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombreEmpleado());
            ps.setString(2, obj.getTelefonoEmpleado());
            ps.setString(3, obj.getDomicilioEmpleado());
            ps.setString(4, obj.getCpEmpleado());
            ps.setString(5, obj.getCorreoEmpleado());
            ps.setString(6, obj.getContraseñaEmpleado());
            ps.setString(7, obj.getImagenEmpleado());
            ps.setInt(8, obj.getIdEmpleado());
            if(ps.executeUpdate() > 0)
                resp=true;
            ps.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            ps=null;
            CON.Desconectar();
        }
        return resp;
    }

    @Override
    public boolean eliminar(int id) 
    {
        resp=false;
        String consultaSQL="DELETE FROM Empleados WHERE idEmpleado=?";
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
    public boolean desactivar(int id) 
    {
        resp=false;
        String consultaSQL="UPDATE Empleados SET Activo = 0 WHERE idEmpleado=?";
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
        String consultaSQL="UPDATE Empleados SET Activo = 1 WHERE idEmpleado=?";
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
    public int total() 
    {
        int numeroRegistros=0;
        try{
            ps=CON.Conectar().prepareStatement("SELECT COUNT(*) FROM Empleados;");
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
    public boolean existe(String texto) 
    {
         resp=false;
        try{
            ps=CON.Conectar().prepareStatement("SELECT * FROM Empleados WHERE nombreEmpleado =?;");
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
