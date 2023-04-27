/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos.interfaces;

import java.util.List;

/**
 *
 * @author CSjes
 */
public interface CrudEmpleadosInterface<T> {

    public List<T> listar(String texto);// Regresa un listado de tipo list de objetos T
    
    public boolean insertar(T obj);//Inserta un objeto del tipo T

    public boolean actualizar(T obj);//Actualizar un registro de acuerdo a un objeto de tipo T
    
    public boolean eliminar(int id);//Realiza una eliminación total

    public boolean desactivar(int id);//Realiza un borrado logico (Desactivar)

    public boolean activar(int id);//Activa un registro borrado logicamente

    public int total(); //Regresa el total de registros de una tabla

    public boolean existe(String texto); //Refresa verdadero si existe un registro o falso sino
}
