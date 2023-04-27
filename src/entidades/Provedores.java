/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Juan Pablo Campos L
 */
public class Provedores {
    int idProvedores;
    String NombreProvedor;
    int Codigo;
    String telefono,correo,empresa;
    

    public Provedores() {
    }

    public Provedores(int idProvedores, String NombreProvedor, int Codigo, String telefono, String correo, String empresa) {
        this.idProvedores = idProvedores;
        this.NombreProvedor = NombreProvedor;
        this.Codigo = Codigo;
        this.telefono = telefono;
        this.correo = correo;
        this.empresa = empresa;
        
    }

    

    public int getIdProvedores() {
        return idProvedores;
    }

    public void setIdProvedores(int idProvedores) {
        this.idProvedores = idProvedores;
    }

    public String getNombreProvedor() {
        return NombreProvedor;
    }

    public void setNombreProvedor(String NombreProvedor) {
        this.NombreProvedor = NombreProvedor;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    
}
