
package negocio;

import datos.ClientesDAO;
import entidades.Clientes;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClientesControl 
{
    private final ClientesDAO DATOS;
    private Clientes obj;
    private DefaultTableModel modelo;

    public ClientesControl() 
    {
        DATOS = new ClientesDAO();
        obj = new Clientes();
    }    
    
    public DefaultTableModel Listar(String texto)
    {
        List<Clientes> lista=new ArrayList();
        lista.addAll(DATOS.Listar(texto));
        String [] titulos = {"ID", "Nombre", "Apellidos", "NickName", "Telefono", "Domicilio", "Localidad", "Estado", "CP", "Correo"};
        modelo = new DefaultTableModel(null, titulos);
        String registro [] = new String [10];
        for(Clientes item : lista)
        {
            registro[0] = Integer.toString(item.getIdCliente());
            registro[1] = item.getNombreCliente();
            registro[2] = item.getApellidosCliente();
            registro[3] = item.getNickName();
            registro[4] = item.getTelefonoCliente();
            registro[5] = item.getDomicilioCliente();
            registro[6] = item.getLocalidadCliente();
            registro[7] = item.getEstadoCliente();
            registro[8] = item.getCpCliente();
            registro[9] = item.getCorreoCliente();
            modelo.addRow(registro);
        }
        return modelo;
    }
    
    public String Insertar(String nombreCliente, String apellidosCliente, String nickName, String telefonoCliente, String domicilioCliente, String localidadCliente, String estadoCliente, String cpCliente, String correoCliente, String contrasenaCliente)
    {
        if(DATOS.Existe(nickName))
            return "El cliente ya existe.";
        else
        {
            obj.setNombreCliente(nombreCliente);
            obj.setApellidosCliente(apellidosCliente);
            obj.setNickName(nickName);
            obj.setTelefonoCliente(telefonoCliente);
            obj.setDomicilioCliente(domicilioCliente);
            obj.setLocalidadCliente(localidadCliente);
            obj.setEstadoCliente(estadoCliente);
            obj.setCpCliente(cpCliente);
            obj.setCorreoCliente(correoCliente);
            obj.setContrasenaCliente(contrasenaCliente);
            if(DATOS.Insertar(obj))
                return "OK";
            else
                return "Error al agregar el cliente.";
        }
    }
    
    public String Actualizar(int idCliente, String nombreCliente, String apellidosCliente, String nickName, String nickNameAnt, String telefonoCliente, String domicilioCliente, String localidadCliente, String estadoCliente, String cpCliente, String correoCliente, String contrasenaCliente)
    {
        if(nickName.equals(nickNameAnt))
        {
            obj.setIdCliente(idCliente);
            obj.setNombreCliente(nombreCliente);
            obj.setApellidosCliente(apellidosCliente);
            obj.setNickName(nickName);
            obj.setTelefonoCliente(telefonoCliente);
            obj.setDomicilioCliente(domicilioCliente);
            obj.setLocalidadCliente(localidadCliente);
            obj.setEstadoCliente(estadoCliente);
            obj.setCpCliente(cpCliente);
            obj.setCorreoCliente(correoCliente);
            obj.setContrasenaCliente(contrasenaCliente);
            if(DATOS.Actualizar(obj))
                return "OK";
            else
                return "Error al actualizar el registro.";
        }
        else
        {
            if(DATOS.Existe(nickName))
                return "El usuario ya existe.";
            else
            {
                obj.setNombreCliente(nombreCliente);
                obj.setApellidosCliente(apellidosCliente);
                obj.setNickName(nickName);
                obj.setTelefonoCliente(telefonoCliente);
                obj.setDomicilioCliente(domicilioCliente);
                obj.setLocalidadCliente(localidadCliente);
                obj.setEstadoCliente(estadoCliente);
                obj.setCpCliente(cpCliente);
                obj.setCorreoCliente(correoCliente); 
                if(DATOS.Actualizar(obj))
                    return "OK.";
                else
                    return "Error al actualizar el registro.";
            }
        }
    }
    
    public String Eliminar(int idCliente)
    {
         return (DATOS.Eliminar(idCliente))?"Cliente eliminado.":"No se pudo eliminar el cliente.";
    }
    
    /*public String [] Buscar(String texto)
    {
        List<Clientes> lista=new ArrayList();
        lista.addAll(DATOS.Listar(texto));
        String registro [] = new String [8];
        for(Clientes item : lista)
        {
            registro[0] = Integer.toString(item.getIdCliente());
            registro[1] = item.getNombreCliente();
            registro[2] = item.getApellidosCliente();
            registro[3] = item.getTelefonoCliente();
            registro[4] = item.getNickName();
            registro[5] = item.getDomicilioCliente();
            registro[6] = item.getLocalidadCliente();
            registro[7] = item.getEstadoCliente();
            registro[8] = item.getCpCliente();
            registro[9] = item.getCorreoCliente();
        }
        return registro;
    }*/
    
    public int Total()
    {
        return DATOS.Total();
    }
}
