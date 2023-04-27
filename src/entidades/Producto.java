package entidades;

public class Producto {
    private int idProducto;
    private int idCategoria;
    private String nombreProducto;
    private String nombreCategoria;
    private int existencias;
    private double precioCompra;
    private double precioVenta;
    private double ganancia;
    private String imagenProducto;

    public Producto() {
    }

    public Producto(int idProducto, int idCategoria, String nombreProducto, String nombreCategoria, int existencias, double precioCompra, double precioVenta, double ganancia, String imagenProducto) {
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.nombreProducto = nombreProducto;
        this.nombreCategoria = nombreCategoria;
        this.existencias = existencias;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.ganancia = ganancia;
        this.imagenProducto = imagenProducto;
    }

    

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }
    
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", idCategoria=" + idCategoria + ", nombreProducto=" + nombreProducto + ", nombreCategoria=" + nombreCategoria + ", existencias=" + existencias + ", precioCompra=" + precioCompra + ", precioVenta=" + precioVenta + ", ganancia=" + ganancia + ", imagenProducto=" + imagenProducto + '}';
    }
    
}
