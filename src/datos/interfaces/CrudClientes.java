
package datos.interfaces;

import java.util.List;

public interface CrudClientes<T>
{
    public List<T> Listar(String texto); 
    public boolean Insertar(T obj);
    public boolean Actualizar(T obj); 
    public boolean Eliminar(int id);
    public boolean Existe(String texto);
    public int Total();
}
