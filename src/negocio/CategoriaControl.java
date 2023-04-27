                                                                                                        
package negocio;

import datos.CategoriaDAO;
import entidades.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class CategoriaControl {
    private final CategoriaDAO DATOS;
    private Categoria obj;
    private DefaultTableModel modeloTabla;
    private int registrosMostrados;
    
    public CategoriaControl(){
        DATOS=new CategoriaDAO();
        obj = new Categoria();
        registrosMostrados=0;
    }
    
    
    
    public DefaultTableModel listar(String texto){
        List <Categoria> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto, 0));
        
        //Crear el modelo y establecer los títulos del modelo
        String titulos[]={"id","Nombre","Descripción","Imagen","Estatus"};
        modeloTabla=new DefaultTableModel(null,titulos);
        
        // Recorrer los elementos de la lista con for each
        String registro []= new String[5];
        registrosMostrados=0;
        for(Categoria item: lista){
            registro[0] = ""+item.getIdCategoria();
            registro[1] = item.getNombreCategoria();
            registro[2] = item.getDescripcionCategoria();
            registro[3] = item.getImagenCategoria();
            registro[4] = (item.isActivoCategoria())?"Activo":"Inactivo";
            
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados+=1;
        }
        return modeloTabla;
    }
    
    
    public String insertar(String nombreCategoria, String descripcionCategoria, String imagenCategoria){
    // Verificar si existe la categoria
        if(DATOS.existe(nombreCategoria))
            return "El registro ya existe.";
        else
        {
            // Llenar el objeto
            obj.setNombreCategoria(nombreCategoria);
            obj.setDescripcionCategoria(descripcionCategoria);
            obj.setImagenCategoria(imagenCategoria);
            
            //Insertar el objeto en la base de datos
            return (DATOS.insertar(obj))?"OK":"Error al insertar el registro";
        }
    }
    
    public String actualizar(int idCategoria, String nombreCategoria, String nombreAnterior, String descripcionCategoria, String imagenCategoria){
        //Verificar si el usuario cambia el nombre de la categoría
        if(nombreCategoria.equals(nombreAnterior)){
            // Llenar el objeto
                obj.setNombreCategoria(nombreCategoria);
                obj.setDescripcionCategoria(descripcionCategoria);
                obj.setImagenCategoria(imagenCategoria);
                obj.setIdCategoria(idCategoria);

                //Actualizar el objeto en la base de datos
                return(DATOS.actualizar(obj))?"OK":"Error al actualizar el registro";
        }
        else{
        // Verificar si existe la categoria
            if(DATOS.existe(nombreCategoria))
                return "El nombre de la categoria ya existe.";
            else
            {
                // Llenar el objeto
                obj.setNombreCategoria(nombreCategoria);
                obj.setDescripcionCategoria(descripcionCategoria);
                obj.setImagenCategoria(imagenCategoria);
                obj.setIdCategoria(idCategoria);

                //Actualizar el objeto en la base de datos
                return(DATOS.actualizar(obj))?"OK":"Error al actualizar el registro";
            }
        }
    }
    
    public String desactivar(int id){
        return(DATOS.desactivar(id))?"OK":"No se pudo desactivar el registro";
    }
    
    public String activar(int id){
        return(DATOS.activar(id))?"OK":"No se pudo desactivar el registro";
    }
    
    public int total(){
        return DATOS.total();
    }
    
    public int totalMostrados(){
        return registrosMostrados;
    }
}
