/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos.interfaces;

import java.util.List;

/**
 *
 * @author Juan Pablo Campos L
 */
public interface CrudProvedor<T,DP> {
    public List <T> listar(String texto); //Regresa un listado de tipo list de objetos T
     public List<DP> ListarDetalle(int idProvedor);
    public boolean insertar(T obj); //Inserta un metodo del tipo T
    public boolean actualizar(T obj); //Actualaizar un registro de acuerdo a un objeto del tipo T
    public boolean desactivar (int id); //este metodo realiza un borrado logico (desactivar) 
    public int total();//regresa el total de registros de una tabla
    public boolean existe (String texto); //regresar verdadero o falso si existe un registro
}
