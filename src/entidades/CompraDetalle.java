/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

public class CompraDetalle {
    private int idCompras;
    private int idProductos;
    private String nombreProducto;
    private int Cantidad;
    private double Precio;
    private double Descuento;
    private double Subtotal;

    public CompraDetalle() {
    }

    public CompraDetalle(int idCompras, int idProductos, String nombreProducto, int Cantidad, double Precio, double Descuento, double Subtotal) {
        this.idCompras = idCompras;
        this.idProductos = idProductos;
        this.nombreProducto = nombreProducto;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Descuento = Descuento;
        this.Subtotal = Subtotal;
    }

    public CompraDetalle(int idProductos, int Cantidad, double Precio, double Descuento, double Subtotal) {
        this.idProductos = idProductos;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.Descuento = Descuento;
        this.Subtotal = Subtotal;
    }

    public int getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(int idCompras) {
        this.idCompras = idCompras;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public double getSubtotal() {
        return Subtotal;
    }

    public void setSubtotal(double Subtotal) {
        this.Subtotal = Subtotal;
    } 
    
}
