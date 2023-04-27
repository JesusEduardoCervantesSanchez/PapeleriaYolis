/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author CSjes
 */
public class Pro_Ven {

    //int idProducto, int idVenta, String productoNombre, int productoExistencia, 
    //int cantidad, double precio, double descuento, double subTotal
    private int idVentas;
    private int idProductos;
    private String NombreProducto;
    private int Existencia;
    private int CantProVen;
    private double PrecioU;
    private double SubTotal;

    public Pro_Ven() {
    }

    public Pro_Ven(int idProductos, int idVentas, String NombreProducto, int Existencia, int CantProVen, double PrecioU, double SubTotal) {
        this.idProductos = idProductos;
        this.idVentas = idVentas;
        this.NombreProducto = NombreProducto;
        this.Existencia = Existencia;
        this.CantProVen = CantProVen;
        this.PrecioU = PrecioU;
        this.SubTotal = SubTotal;
    }

    public Pro_Ven(int idProductos, int CantProVen, double PrecioU, double SubTotal) {
        this.idProductos = idProductos;
        this.CantProVen = CantProVen;
        this.PrecioU = PrecioU;
        this.SubTotal = SubTotal;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public int getCantProVen() {
        return CantProVen;
    }

    public void setCantProVen(int CantProVen) {
        this.CantProVen = CantProVen;
    }

    public double getPrecioU() {
        return PrecioU;
    }

    public void setPrecioU(double PrecioU) {
        this.PrecioU = PrecioU;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

}
