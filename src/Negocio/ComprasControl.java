/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Datos.ComprasDAO;
import Entidades.Compras;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ComprasControl {
    
    private final ComprasDAO datos;
    private Compras obj;
    private int registrosMostrados;
    private DefaultTableModel modeloTabla;
    
    public ComprasControl()
    {
        datos = new ComprasDAO();
        obj = new Compras();
        registrosMostrados = 0;
    }
    
    
    public String[] Buscar(int id)
    {
        List<Compras> lista = new ArrayList();
        lista.addAll(datos.Listar(id));
        String registro[] = new String[6];
        for(Compras item:lista)
        {
            registro[0] = Integer.toString(item.getNumeroCompra());
            registro[1] = item.getNombreProveedor();
            registro[2] = item.getCategoriaProd();
            registro[3] = Integer.toString(item.getCantidad());
            registro[4] = Double.toString(item.getPrecioCompra());
            registro[5] = item.getFechaCompra();
        }
        return registro;
    }
    
    public DefaultTableModel Listar(int id)
    {
        List<Compras> lista = new ArrayList();
        lista.addAll(datos.Listar(id));
        String titulos[] = {"Numero Compra", "Proveedor", "Categoria Producto", "Cantidad", "Precio Compra", "Fecha"};
        modeloTabla = new DefaultTableModel(null, titulos);
        String registro[] = new String[6]; //Son 6 titulos
        registrosMostrados = 0;
        for(Compras item:lista){
            registro[0] = Integer.toString(item.getNumeroCompra());
            registro[1] = item.getNombreProveedor();
            registro[2] = item.getCategoriaProd();
            registro[3] = Integer.toString(item.getCantidad());
            registro[4] = Double.toString(item.getPrecioCompra());
            registro[5] = item.getFechaCompra();
            modeloTabla.addRow(registro);
            registrosMostrados += 1;
        }
        return modeloTabla;
    }
    
    public String Insertar(String nombreProveedor, String categoriaProd, int cantidad, double precioCompra, String fechaCompra)
    {
        obj.setNombreProveedor(nombreProveedor);
        obj.setCategoriaProd(categoriaProd);
        obj.setCantidad(cantidad);
        obj.setPrecioCompra(precioCompra);
        obj.setFechaCompra(fechaCompra);
        if(datos.insertar(obj))
            return "OK";
        else
            return "Error al insertar el registro";
    }
    
    
    public String Actualizar(int id, String nombreProveedor, String categoriaProd, int cantidad, double precioCompra, String fechaCompra)
    {
            obj.setNumeroCompra(id);
            obj.setNombreProveedor(nombreProveedor);
            obj.setCategoriaProd(categoriaProd);
            obj.setCantidad(cantidad);
            obj.setPrecioCompra(precioCompra);
            obj.setFechaCompra(fechaCompra);
            if(datos.actualizar(obj))
                return "OK";
            else
                return "Error al actualizar el registro";
    }
    
    public String Eliminar(int id)
    {
        return (datos.eliminar(id)) ? "OK":"Error al eliminar el registro";
    }
    
    public String Existe(String id)
    {
        return (datos.existe(id)) ? "OK":"El numero de la compra no existe";
    }
    
    public int Total()
    {
        return datos.total();
    }
    
    public int TotalMostrados()
    {
        return registrosMostrados;
    }
    
}
