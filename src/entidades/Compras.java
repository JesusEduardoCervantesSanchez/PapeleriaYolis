
package entidades;

import java.util.List;

public class Compras {
    private int idCompras;
    private int idProvedores;
    private String nombreProvedor;
    private int idEmpleado;
    private String NombreEmpleado;
    private String FolioCompra;
    private double Descuento;
    private double SubtotalCompra;
    private double IVA;
    private String FechaCompra;
    private double Total;
    private String Estado;
    private List<CompraDetalle> detalle;

    public Compras() {
    }

    public Compras(int idCompras, int idProvedores, String nombreProvedor, int idEmpleado, String NombreEmpleado, String FolioCompra, double Descuento, double SubtotalCompra, double IVA, String FechaCompra, double Total, String Estado, List<CompraDetalle> detalle) {
        this.idCompras = idCompras;
        this.idProvedores = idProvedores;
        this.nombreProvedor = nombreProvedor;
        this.idEmpleado = idEmpleado;
        this.NombreEmpleado = NombreEmpleado;
        this.FolioCompra = FolioCompra;
        this.Descuento = Descuento;
        this.SubtotalCompra = SubtotalCompra;
        this.IVA = IVA;
        this.FechaCompra = FechaCompra;
        this.Total = Total;
        this.Estado = Estado;
        this.detalle = detalle;
    }

    public Compras(int idCompras, int idProvedores, String nombreProvedor, int idEmpleado, String NombreEmpleado, String FolioCompra, double Descuento, double SubtotalCompra, double IVA, String FechaCompra, double Total, String Estado) {
        this.idCompras = idCompras;
        this.idProvedores = idProvedores;
        this.nombreProvedor = nombreProvedor;
        this.idEmpleado = idEmpleado;
        this.NombreEmpleado = NombreEmpleado;
        this.FolioCompra = FolioCompra;
        this.Descuento = Descuento;
        this.SubtotalCompra = SubtotalCompra;
        this.IVA = IVA;
        this.FechaCompra = FechaCompra;
        this.Total = Total;
        this.Estado = Estado;
    }
    
    

    public Compras(int idCompras, String FolioCompra, double Descuento, double SubtotalCompra, double IVA, String FechaCompra, double Total, String Estado, List<CompraDetalle> detalle) {
        this.idCompras = idCompras;
        this.idProvedores = idProvedores;
        this.idEmpleado = idEmpleado;
        this.FolioCompra = FolioCompra;
        this.Descuento = Descuento;
        this.SubtotalCompra = SubtotalCompra;
        this.IVA = IVA;
        this.FechaCompra = FechaCompra;
        this.Total = Total;
        this.Estado = Estado;
        this.detalle = detalle;
    }

    public List<CompraDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<CompraDetalle> detalle) {
        this.detalle = detalle;
    }
    
    public int getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(int idCompras) {
        this.idCompras = idCompras;
    }

    public int getIdProvedores() {
        return idProvedores;
    }

    public void setIdProvedores(int idProvedores) {
        this.idProvedores = idProvedores;
    }

    public String getNombreProvedor() {
        return nombreProvedor;
    }

    public void setNombreProvedor(String nombreProvedor) {
        this.nombreProvedor = nombreProvedor;
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

    public String getFolioCompra() {
        return FolioCompra;
    }

    public void setFolioCompra(String FolioCompra) {
        this.FolioCompra = FolioCompra;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public double getSubtotalCompra() {
        return SubtotalCompra;
    }

    public void setSubtotalCompra(double SubtotalCompra) {
        this.SubtotalCompra = SubtotalCompra;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public String getFechaCompra() {
        return FechaCompra;
    }

    public void setFechaCompra(String FechaCompra) {
        this.FechaCompra = FechaCompra;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
}
