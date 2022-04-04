/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author CSjes
 */

public class Ventas {
 private int idVentas;
 private String numeroVenta;
 private String nombreCliente;
 private String categoriaProducto;
 private int cantidad;
 private double precioVenta;
 private String fechaVenta;

    public Ventas(int idVentas, String numeroVenta, String nombreCliente, String categoriaProducto, int cantidad, double precioVenta, String fechaVenta) {
        this.idVentas = idVentas;
        this.numeroVenta = numeroVenta;
        this.nombreCliente = nombreCliente;
        this.categoriaProducto = categoriaProducto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.fechaVenta = fechaVenta;
    }

    public Ventas() {
        
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public String getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(String numeroVenta) {
        this.numeroVenta = numeroVenta;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(String categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "Ventas{" + "idVentas=" + idVentas + ", numeroVenta=" + numeroVenta + ", nombreCliente=" + nombreCliente + ", categoriaProducto=" + categoriaProducto + ", cantidad=" + cantidad + ", precioVenta=" + precioVenta + ", fechaVenta=" + fechaVenta + '}';
    }
}
