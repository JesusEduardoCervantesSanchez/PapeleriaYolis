/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Cristianss
 */
public class Empleados {
   private int idEmpleado;
   private String nombreEmpleado; 
   private String telefonoEmpleado;
   private String domicilioEmpleado;
   private String cpEmpleado;
   private String correoEmpleado;
   private String contraseñaEmpleado;
   private String imagenEmpleado;
   private boolean activo;

    public Empleados() 
    {
    
    }

    public Empleados(int idEmpleado, String nombreEmpleado, String telefonoEmpleado, String domicilioEmpleado, String cpEmpleado, String correoEmpleado, String contraseñaEmpleado, String imagenEmpleado, boolean activo) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.telefonoEmpleado = telefonoEmpleado;
        this.domicilioEmpleado = domicilioEmpleado;
        this.cpEmpleado = cpEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.contraseñaEmpleado = contraseñaEmpleado;
        this.imagenEmpleado = imagenEmpleado;
        this.activo = activo;
    }
    
    public Empleados(int idEmpleado, String NombreEmpleado, String TelefonoEmpleado, String DomicilioEmpleado, String CPEmpleado, String CorreoEmpleado, String ContraseñaEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = NombreEmpleado;
        this.telefonoEmpleado = TelefonoEmpleado;
        this.domicilioEmpleado = DomicilioEmpleado;
        this.cpEmpleado = CPEmpleado;
        this.correoEmpleado = CorreoEmpleado;
        this.contraseñaEmpleado = ContraseñaEmpleado;
    }

   

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getTelefonoEmpleado() {
        return telefonoEmpleado;
    }

    public void setTelefonoEmpleado(String telefonoEmpleado) {
        this.telefonoEmpleado = telefonoEmpleado;
    }

    public String getDomicilioEmpleado() {
        return domicilioEmpleado;
    }

    public void setDomicilioEmpleado(String domicilioEmpleado) {
        this.domicilioEmpleado = domicilioEmpleado;
    }

    public String getCpEmpleado() {
        return cpEmpleado;
    }

    public void setCpEmpleado(String cpEmpleado) {
        this.cpEmpleado = cpEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public String getContraseñaEmpleado() {
        return contraseñaEmpleado;
    }

    public void setContraseñaEmpleado(String contraseñaEmpleado) {
        this.contraseñaEmpleado = contraseñaEmpleado;
    }

    public String getImagenEmpleado() {
        return imagenEmpleado;
    }

    public void setImagenEmpleado(String imagenEmpleado) {
        this.imagenEmpleado = imagenEmpleado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    

    @Override
    public String toString()
    {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombreEmpleado=" + nombreEmpleado + ", telefonoEmpleado=" + telefonoEmpleado + ", domicilioEmpleado=" + domicilioEmpleado + ", cpEmpleado=" + cpEmpleado + ", correoEmpleado=" + correoEmpleado + ", contraseñaEmpleado=" + contraseñaEmpleado + ", imagenEmpleado=" + imagenEmpleado + "activo="+ activo +'}';
    }
   
}
