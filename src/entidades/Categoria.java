package entidades;

public class Categoria {
    private int idCategoria;
    private String nombreCategoria;
    private String descripcionCategoria;
    private String imagenCategoria;
    private boolean ActivoCategoria;

    public Categoria() {
    }

    public Categoria(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }
    
    public Categoria(int idCategoria, String nombreCategoria, String descripcionCategoria, String imagenCategoria, boolean ActivoCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.imagenCategoria = imagenCategoria;
        this.ActivoCategoria = ActivoCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public String getImagenCategoria() {
        return imagenCategoria;
    }

    public void setImagenCategoria(String imagenCategoria) {
        this.imagenCategoria = imagenCategoria;
    }

    public boolean isActivoCategoria() {
        return ActivoCategoria;
    }

    public void setActivoCategoria(boolean ActivoCategoria) {
        this.ActivoCategoria = ActivoCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + ", descripcionCategoria=" + descripcionCategoria + ", imagenCategoria=" + imagenCategoria + ", ActivoCategoria=" + ActivoCategoria + '}';
    }
}
