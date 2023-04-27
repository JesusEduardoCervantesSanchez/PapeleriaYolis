package datos.interfaces;

import java.util.List;

public interface CrudSEInterface<T> {
    public List<T> listar(String texto, int combo); //Regresa un listado de tipo List de objetos T
    public boolean insertar(T obj); // Inserta un objeto del tipo T
    public boolean actualizar(T obj); //Actualiza un registro de acuerdo a un objeto del tipo T
    public boolean desactivar(int id); // Realiza un borrado lógico (Desactivar)
    public boolean activar(int id); // Activar un registro borrado lógicamente
    public int total();
    public boolean existe(String texto); //Regresa verdadero o falso si existe un registro.
}
