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
public interface CrudSimpleCompras <T, DC, P, PR, E>
{
    public List<T> Listar(String folio);
    public List<DC> ListarDetalle(int idCompra);
    public List<P> ListarProductos(String valor);
    public List<PR> ListarProvedor(String valor);
    public List<E> ListarEmpleado(String valor);
    public boolean insertar(T obj);
    public boolean insertarEmP_Com(int idCompra, int idEmpleado);
    public boolean insertarProv_Comp(int idCompra, int idProvedor);
    public boolean cancelar(int id);
    public int total();
    public int RegresarIdCompra(String Folio);
    public boolean existe(String texto);
    public int ActualizarStock(int cant, int id);
    public int ObtenerStock(int id);
}
