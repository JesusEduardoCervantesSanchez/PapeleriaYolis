
package datos;

import database.Conexion;
import datos.interfaces.CrudClientes;
import entidades.Clientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClientesDAO implements CrudClientes<Clientes> 
{
    private final Conexion CON;
    private PreparedStatement ps;
    private ResultSet rs;
    private boolean resp;

    public ClientesDAO() {
        this.CON = Conexion.getInstance();
    }

    @Override
    public List<Clientes> Listar(String texto) 
    {
        List<Clientes> registros=new ArrayList();
        try
        {
            ps=CON.Conectar().prepareStatement("SELECT * FROM Clientes WHERE nombreCliente LIKE ?");
            ps.setString(1, "%" + texto + "%");
            rs=ps.executeQuery();
            while(rs.next())
                registros.add(new Clientes(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            ps.close();
            rs.close();            
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            ps=null;
            rs=null;
            CON.Desconectar();
        }
        return registros;
    }

    @Override
    public boolean Insertar(Clientes obj) 
    {
resp=false;
        String consultaSQL = "insert into Clientes(NombreCliente, ApellidosCliente, NickName, TelefonoCliente, DomicilioCliente, LocalidadCliente, EstadoCliente, CPCliente, CorreoCliente, ContraseñaCliente)\n" +
"values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
         try
        {
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombreCliente());
            ps.setString(2, obj.getApellidosCliente());
            ps.setString(3, obj.getNickName());
            ps.setString(4, obj.getTelefonoCliente());
            ps.setString(5, obj.getDomicilioCliente());
            ps.setString(6, obj.getLocalidadCliente());
            ps.setString(7, obj.getEstadoCliente());
            ps.setString(8, obj.getCpCliente());
            ps.setString(9, obj.getCorreoCliente());
            ps.setString(10, obj.getContrasenaCliente());
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
    public boolean Actualizar(Clientes obj) 
    {
resp=false;
        String consultaSQL = "UPDATE Clientes SET NombreCliente=?, ApellidosCliente=?, NickName=?, TelefonoCliente=?, DomicilioCliente=?, LocalidadCliente=?, EstadoCliente=?, CPCliente=?, CorreoCliente=?, ContraseñaCliente=?" +
        " WHERE idCliente=?";
         try
        {
            ps=CON.Conectar().prepareStatement(consultaSQL);
            ps.setString(1, obj.getNombreCliente());
            ps.setString(2, obj.getApellidosCliente());
            ps.setString(3, obj.getNickName());
            ps.setString(4, obj.getTelefonoCliente());
            ps.setString(5, obj.getDomicilioCliente());
            ps.setString(6, obj.getLocalidadCliente());
            ps.setString(7, obj.getEstadoCliente());
            ps.setString(8, obj.getCpCliente());
            ps.setString(9, obj.getCorreoCliente());
            ps.setString(10, obj.getContrasenaCliente());
            ps.setInt(11, obj.getIdCliente());
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
    public boolean Eliminar(int id) 
    {
        resp = false;   
        String consultaSQL = "DELETE FROM Clientes WHERE idCliente=?";
        try
        {
            ps = CON.Conectar().prepareStatement(consultaSQL);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0)
                resp = true;
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
    public boolean Existe(String texto) 
    {
        resp = false;
        try
        {
            ps=CON.Conectar().prepareStatement("SELECT * FROM Clientes where NickName=?"); //Consulta para buscar un registro.
            ps.setString(1, texto);
            rs=ps.executeQuery();
            if(rs.next())
                resp=true;
            ps.close();
            rs.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            ps=null;
            rs=null;
            CON.Desconectar();
        }
        return resp;
    }

    @Override
    public int Total() 
    {
        int numeroRegistros=0;
        try
        {
            ps=CON.Conectar().prepareStatement("SELECT COUNT(*) FROM Clientes"); //Consulta para contar registros.
            rs=ps.executeQuery();
            while(rs.next())
                numeroRegistros=rs.getInt(1);
            ps.close();
            rs.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            ps=null;
            rs=null;
            CON.Desconectar();
        }
        return numeroRegistros;
    }    
}
