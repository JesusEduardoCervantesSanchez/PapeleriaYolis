/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author CSjes
 */
public class Ventas {

    private int idVentas;
    private int idCliente;
    private String ClienteNombre;
    private int idEmpleado;
    private String NombreEmpleado;
    private String FolioVenta;
    private Date FechaVenta;
    private double SubTotal;
    private double IVA;
     private List<Pro_Ven> detalles;

    public Ventas() {
    }

    public Ventas(int idVentas, int idCliente, String ClienteNombre, int idEmpleado, String NombreEmpleado, String FolioVenta, Date FechaVenta, double SubTotal, double IVA) {
        this.idVentas = idVentas;
        this.idCliente = idCliente;
        this.ClienteNombre = ClienteNombre;
        this.idEmpleado = idEmpleado;
        this.NombreEmpleado = NombreEmpleado;
        this.FolioVenta = FolioVenta;
        this.FechaVenta = FechaVenta;
        this.SubTotal = SubTotal;
        this.IVA = IVA;
    }

    

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public String getFolioVenta() {
        return FolioVenta;
    }

    public void setFolioVenta(String FolioVenta) {
        this.FolioVenta = FolioVenta;
    }

    public Date getFechaVenta() {
        return FechaVenta;
    }

    public void setFechaVenta(Date FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getClienteNombre() {
        return ClienteNombre;
    }

    public void setClienteNombre(String ClienteNombre) {
        this.ClienteNombre = ClienteNombre;
    }

    public List<Pro_Ven> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Pro_Ven> detalles) {
        this.detalles = detalles;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return NombreEmpleado;
    }

    public void setNombreEmpleado(String NombreEmpleado) {
        this.NombreEmpleado = NombreEmpleado;
    }
    
    
    
}


