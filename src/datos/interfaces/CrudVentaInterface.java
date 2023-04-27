/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos.interfaces;

import java.util.List;

/**
 *
 * @author CSjes
 * @param <T>
 * @param <DV>
 */
public interface CrudVentaInterface<T, DV, P, C, E> {

    public List<T> listar(String texto);// Regresa un listado de tipo list de objetos T

    public List<DV> listarDetalle(int idVenta); //Regresar los prodcutos de la venta(tabla hija)

    public List<P> ListarProductos(String valor);

    public List<E> ListarEmpleado(String valor);

    public List<C> ListarCliente(String valor);

    public boolean insertar(T obj);//Inserta un objeto del tipo T

    public boolean insertarEmP_Ven(int idVenta, int idEmpleado);

    public boolean insertarCli_Ven(int idVenta, int idCliente);
    
    public int RegresarIdVenta(String Folio);

    public int total(); //Regresa el total de registros de una tabla

    public boolean existe(String texto); //Refresa verdadero si existe un registro o falso sino

    public int ActualizarStock(int cant, int id);

    public int ObtenerStock(int id);
}
