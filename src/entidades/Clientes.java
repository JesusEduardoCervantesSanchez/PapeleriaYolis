
package entidades;

public class Clientes 
{
    private int idCliente;
    private String nombreCliente, apellidosCliente, nickName, telefonoCliente, domicilioCliente, localidadCliente, estadoCliente, cpCliente, correoCliente, contrasenaCliente;

    public Clientes() 
    {
    } 

    public Clientes(int idCliente, String nombreCliente, String apellidosCliente, String nickName, String telefonoCliente, String domicilioCliente, String localidadCliente, String estadoCliente, String cpCliente, String correoCliente, String contrasenaCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidosCliente = apellidosCliente;
        this.nickName = nickName;
        this.telefonoCliente = telefonoCliente;
        this.domicilioCliente = domicilioCliente;
        this.localidadCliente = localidadCliente;
        this.estadoCliente = estadoCliente;
        this.cpCliente = cpCliente;
        this.correoCliente = correoCliente;
        this.contrasenaCliente = contrasenaCliente;
    }
    
    public Clientes(int idCliente, String nombreCliente, String apellidosCliente, String nickName, String telefonoCliente, String domicilioCliente, String localidadCliente, String estadoCliente, String cpCliente, String correoCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidosCliente = apellidosCliente;
        this.nickName = nickName;
        this.telefonoCliente = telefonoCliente;
        this.domicilioCliente = domicilioCliente;
        this.localidadCliente = localidadCliente;
        this.estadoCliente = estadoCliente;
        this.cpCliente = cpCliente;
        this.correoCliente = correoCliente;
    }

    public Clientes(int idCliente, String nombreCliente, String apellidosCliente, String telefonoCliente, String correoCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidosCliente = apellidosCliente;
        this.telefonoCliente = telefonoCliente;
        this.correoCliente = correoCliente;
    }
    
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidosCliente() {
        return apellidosCliente;
    }

    public void setApellidosCliente(String apellidosCliente) {
        this.apellidosCliente = apellidosCliente;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getDomicilioCliente() {
        return domicilioCliente;
    }

    public void setDomicilioCliente(String domicilioCliente) {
        this.domicilioCliente = domicilioCliente;
    }

    public String getLocalidadCliente() {
        return localidadCliente;
    }

    public void setLocalidadCliente(String localidadCliente) {
        this.localidadCliente = localidadCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getCpCliente() {
        return cpCliente;
    }

    public void setCpCliente(String cpCliente) {
        this.cpCliente = cpCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getContrasenaCliente() {
        return contrasenaCliente;
    }

    public void setContrasenaCliente(String contrasenaCliente) {
        this.contrasenaCliente = contrasenaCliente;
    }

        
}
