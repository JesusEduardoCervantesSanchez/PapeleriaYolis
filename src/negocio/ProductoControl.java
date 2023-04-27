                                                                                                        
package negocio;

import datos.CategoriaDAO;
import datos.ProductoDAO;
import entidades.Producto;
import entidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class ProductoControl {
    private final ProductoDAO DATOS;
    private final CategoriaDAO DATOSCAT;
    private Producto obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;
    
    public ProductoControl(){
        DATOS=new ProductoDAO();
        DATOSCAT = new CategoriaDAO();
        obj = new Producto();
        registrosMostrados=0;
    }
    
    public DefaultTableModel listar(String texto){
        List <Producto> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        
        //Crear el modelo y establecer los títulos del modelo
        String titulos[]={"ID Producto", "Nombre", "ID Categoría", "Categoría", "Existencias", "Precio de compra", 
        "Precio de venta", "Ganancia", "ImagenProducto"};
        modeloTabla=new DefaultTableModel(null,titulos);
        
        // Recorrer los elementos de la lista con for each
        String registro []= new String[9];
        registrosMostrados=0;
        for(Producto item: lista){
            registro[0] = ""+item.getIdProducto();
            registro[1] = item.getNombreProducto();
            registro[2] = ""+item.getIdCategoria();
            registro[3] = item.getNombreCategoria();
            registro[4] = ""+item.getExistencias();
            registro[5] = ""+item.getPrecioCompra();
            registro[6] = ""+item.getPrecioVenta();
            registro[7] = ""+item.getGanancia();
            registro[8] = item.getImagenProducto();
                        
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados+=1;
        }
        return modeloTabla;
    }
    
    public DefaultTableModel seleccionarCategorias(String texto){
        List <Categoria> lista = new ArrayList();
        lista.addAll(DATOSCAT.listar(texto,1));
        
        //Crear el modelo y establecer los títulos del modelo
        String titulos[]={"ID Categoría", "Nombre"};
        modeloTabla=new DefaultTableModel(null,titulos);
        
        // Recorrer los elementos de la lista con for each
        String registro []= new String[2];
        registrosMostrados=0;
        for(Categoria item: lista){
            registro[0] = ""+item.getIdCategoria();
            registro[1] = item.getNombreCategoria();
                        
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados+=1;
        }
        return modeloTabla;
    }
    
    public String insertar(int idCategoria, String nombreProducto, int existencias, double precioCompra, double precioVenta, double ganancia, String imagenProducto){
    // Verificar si existe la categoria
        if(DATOS.existe(nombreProducto))
            return "El registro ya existe.";
        else
        {
            // Llenar el objeto
            obj.setIdCategoria(idCategoria);
            obj.setNombreProducto(nombreProducto);
            obj.setExistencias(existencias);
            obj.setPrecioCompra(precioCompra);
            obj.setPrecioVenta(precioVenta);
            obj.setGanancia(ganancia);
            obj.setImagenProducto(imagenProducto);
            
            //Insertar el objeto en la base de datos
            return (DATOS.insertar(obj))?"OK":"Error al insertar el registro";
        }
    }
    
    public String eliminar(String nombreProducto){
        // Verificar si existe la categoria
        if(!DATOS.existe(nombreProducto))
            return "El registro no existe.";
        else
        {
            return (DATOS.eliminar(nombreProducto))?"OK":"Error al insertar el registro";
        }
    }
    
    public String actualizar(int idProducto, int idCategoria, String nombreProducto, String nombreAnterior, int existencias, double precioCompra, double precioVenta, double ganancia, String imagenProducto){
        //Verificar si el usuario cambia el nombre de la categoría
        if(nombreProducto.equals(nombreAnterior)){
            // Llenar el objeto
            obj.setIdProducto(idProducto);
            obj.setIdCategoria(idCategoria);
            obj.setNombreProducto(nombreProducto);
            obj.setExistencias(existencias);
            obj.setPrecioCompra(precioCompra);
            obj.setPrecioVenta(precioVenta);
            obj.setGanancia(ganancia);
            obj.setImagenProducto(imagenProducto);

                //Actualizar el objeto en la base de datos
                return(DATOS.actualizar(obj))?"OK":"Error al actualizar el registro";
        }
        else{
        // Verificar si existe la categoria
            if(DATOS.existe(nombreProducto))
                return "El nombre del producto ya existe.";
            else
            {
                // Llenar el objeto
                obj.setIdProducto(idProducto);
                obj.setIdCategoria(idCategoria);
                obj.setNombreProducto(nombreProducto);
                obj.setExistencias(existencias);
                obj.setPrecioCompra(precioCompra);
                obj.setPrecioVenta(precioVenta);
                obj.setGanancia(ganancia);
                obj.setImagenProducto(imagenProducto);

                //Actualizar el objeto en la base de datos
                return(DATOS.actualizar(obj))?"OK":"Error al actualizar el registro";
            }
        }
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return registrosMostrados;
    }
}
