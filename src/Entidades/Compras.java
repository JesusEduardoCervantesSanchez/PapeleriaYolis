/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

public class Compras {
    private int numeroCompra;
    private String nombreProveedor;
    private String categoriaProd;
    private int cantidad;
    private double precioCompra;
    private String fechaCompra;

    public Compras() {
    }

    public Compras(int numeroCompra, String nombreProveedor, String categoriaProd, int cantidad, double precioCompra, String fechaCompra) {
        this.numeroCompra = numeroCompra;
        this.nombreProveedor = nombreProveedor;
        this.categoriaProd = categoriaProd;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.fechaCompra = fechaCompra;
    }
    
    public int getNumeroCompra() {
        return numeroCompra;
    }

    public void setNumeroCompra(int numeroCompra) {
        this.numeroCompra = numeroCompra;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getCategoriaProd() {
        return categoriaProd;
    }

    public void setCategoriaProd(String categoriaProd) {
        this.categoriaProd = categoriaProd;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public String toString() {
        return "Compras{" + "numeroCompra=" + numeroCompra + ", nombreProveedor=" + nombreProveedor + ", categoriaProd=" + categoriaProd + ", cantidad=" + cantidad + ", precioCompra=" + precioCompra + ", fechaCompra=" + fechaCompra + '}';
    }
}
