/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Datos.Interfaces;

import java.util.List;

/**
 *
 * @author Tadeo
 */
public interface CrudSimpleCompras <T>
{
    public List<T> Listar(int id);
    public boolean insertar(T obj); 
    public boolean actualizar(T obj);
    public boolean eliminar(int id);
    public boolean desactivar(int id); 
    public boolean activar(int id); 
    public int total();
    public boolean existe(String texto);
}
