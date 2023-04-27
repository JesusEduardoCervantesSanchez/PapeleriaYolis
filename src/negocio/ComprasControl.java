/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Datos.ComprasDAO;
import entidades.CompraDetalle;
import entidades.Compras;
import entidades.Empleados;
import entidades.Producto;
import entidades.Provedores;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ComprasControl {
    
    private final ComprasDAO datos;
    private Compras obj;
    private int registrosMostrados;
    private DefaultTableModel modeloTabla;
    private DefaultTableModel modeloTabla2;
    private DefaultTableModel modeloTabla3;
    
    public ComprasControl()
    {
        datos = new ComprasDAO();
        obj = new Compras();
        registrosMostrados = 0;
    }
    
    public DefaultTableModel Listar(String valor)
    {
        List<Compras> lista = new ArrayList();
        lista.addAll(datos.Listar(valor));
        String titulos[] = {"Id Compra", "Id Proveedor", "Proveedor", "Id Empleado", "Empleado", "Folio", "Descuento", "Subtotal", "IVA", "Fecha", "Total", "Estado"};
        modeloTabla = new DefaultTableModel(null, titulos);
        String registro[] = new String[12];
        registrosMostrados = 0;
        for(Compras item:lista){
            registro[0] = Integer.toString(item.getIdCompras());
            registro[1] = Integer.toString(item.getIdProvedores());
            registro[2] = item.getNombreProvedor();
            registro[3] = Integer.toString(item.getIdEmpleado());
            registro[4] = item.getNombreEmpleado();
            registro[5] = item.getFolioCompra();
            registro[6] = Double.toString(item.getDescuento());
            registro[7] = Double.toString(item.getSubtotalCompra());
            registro[8] = Double.toString(item.getIVA());
            registro[9] = item.getFechaCompra();
            registro[10] = Double.toString(item.getTotal());
            registro[11] = item.getEstado();
            modeloTabla.addRow(registro);
            registrosMostrados += 1;
        }
        return modeloTabla;
    }
    
    public DefaultTableModel ListarDetalle(int idCompra)
    {
        List<CompraDetalle> lista = new ArrayList();
        lista.addAll(datos.ListarDetalle(idCompra));
        
        //Crear el model y establecer los titulos del modelo
        
        String titulos[] = {"ID Producto", "Nombre", "Cantidad", "Precio", "Descuento", "Subtotal"};
        modeloTabla = new DefaultTableModel(null, titulos);
        
        String registro[] = new String[6];
        registrosMostrados = 0;
        //for(tipo variable:arreglo)
        for(CompraDetalle item:lista){
            registro[0] = Integer.toString(item.getIdProductos());
            registro[1] = item.getNombreProducto();
            registro[2] = Integer.toString(item.getCantidad());
            registro[3] = Double.toString(item.getPrecio());
            registro[4] = Double.toString(item.getDescuento());
            registro[5] = Double.toString(item.getSubtotal());

            modeloTabla.addRow(registro);
            registrosMostrados += 1;
        }
        return modeloTabla;
    }
    
    public DefaultTableModel ListarProductos(String valor)
    {
        List<Producto> lista = new ArrayList();
        lista.addAll(datos.ListarProductos(valor));
        String titulos[] = {"Id", "Id Categotia", "Producto", "Categoria", "Existencias", "P. Compra", "P. Venta", "Ganancia", "Imagen"};
        modeloTabla3 = new DefaultTableModel(null, titulos);
        String registro[] = new String[9];
        registrosMostrados = 0;
        for(Producto item:lista){
            registro[0] = Integer.toString(item.getIdProducto());
            registro[1] = Integer.toString(item.getIdCategoria());
            registro[2] = item.getNombreProducto();
            registro[3] = item.getNombreCategoria();
            registro[4] = Integer.toString(item.getExistencias());
            registro[5] = Double.toString(item.getPrecioCompra());
            registro[6] = Double.toString(item.getPrecioVenta());
            registro[7] = Double.toString(item.getGanancia());
            registro[8] = item.getImagenProducto();
            modeloTabla3.addRow(registro);
            registrosMostrados += 1;
        }
        return modeloTabla3;
    }
    
    public DefaultTableModel ListarProvedor(String valor)
    {
        List<Provedores> lista = new ArrayList();
        lista.addAll(datos.ListarProvedor(valor));
        String titulos[] = {"Id", "Nombre", "Codigo", "Telefono", "Correo", "Empresa"};
        modeloTabla = new DefaultTableModel(null, titulos);
        String registro[] = new String[6];
        registrosMostrados = 0;
        for(Provedores item:lista){
            registro[0] = Integer.toString(item.getIdProvedores());
            registro[1] = item.getNombreProvedor();
            registro[2] = Integer.toString(item.getCodigo());
            registro[3] = item.getTelefono();
            registro[4] = item.getCorreo();
            registro[5] = item.getEmpresa();
            modeloTabla.addRow(registro);
            registrosMostrados += 1;
        }
        return modeloTabla;
    }
   
    public DefaultTableModel ListarEmpleados(String valor)
    {
        List<Empleados> lista = new ArrayList();
        lista.addAll(datos.ListarEmpleado(valor));
        String titulos[] = {"Id", "Nombre", "Telefono", "Domicilio", "CP", "Correo", "Contraseña"};
        modeloTabla = new DefaultTableModel(null, titulos);
        String registro[] = new String[7];
        registrosMostrados = 0;
        for(Empleados item:lista){
            registro[0] = Integer.toString(item.getIdEmpleado());
            registro[1] = item.getNombreEmpleado();
            registro[2] = item.getTelefonoEmpleado();
            registro[3] = item.getDomicilioEmpleado();
            registro[4] = item.getCpEmpleado();
            registro[5] = item.getCorreoEmpleado();
            registro[6] = item.getContraseñaEmpleado();
            modeloTabla.addRow(registro);
            registrosMostrados += 1;
        }
        return modeloTabla;
    }
    
    public String Insertar(String FolioCompra, double Descuento, double SubtotalCompra, double IVA, String FechaCompra, double Total, DefaultTableModel detalle){
        List<CompraDetalle> listaProductos = new ArrayList();
        int i;
        int idProducto;
        int cantidad;
        double precio;
        double descuentoProducto;
        double subtotal;
        //Verificar si existe la venta
        if(datos.existe(FolioCompra))
           return "El numero de folio ya existe";
        else{
        //llenar el objeto
            obj.setFolioCompra(FolioCompra);
            obj.setDescuento(Descuento);
            obj.setSubtotalCompra(SubtotalCompra);
            obj.setIVA(IVA);
            obj.setFechaCompra(FechaCompra);
            obj.setTotal(Total);
            //convetir DefaultTable a lista o arreglo
            for(i=0; i<detalle.getRowCount(); i++){
                idProducto = Integer.parseInt(detalle.getValueAt(i, 0).toString());
                cantidad = Integer.parseInt(detalle.getValueAt(i, 2).toString());
                precio = Double.parseDouble(detalle.getValueAt(i, 3).toString());
                descuentoProducto = Double.parseDouble(detalle.getValueAt(i, 4).toString());
                subtotal = Double.parseDouble(detalle.getValueAt(i, 5).toString());
                //Insertar los valores en la lista
                listaProductos.add(new CompraDetalle(idProducto, cantidad, precio, descuentoProducto, subtotal));
            }
            obj.setDetalle(listaProductos);
            //insertar objeto en la BD
            if(datos.insertar(obj))
                return "OK";
            else
                return "Error al realizar la compra";
        }
    }
    
    public String InsertarEmp_Com(int idCompra, int idEmpleado)
    {
            if(datos.insertarEmP_Com(idCompra, idEmpleado))
                return "OK";
            else
                return "Error al generar la nueva compra";    
    }
    
    public String InsertarProv_Comp(int idCompra, int idProvedor)
    {
            if(datos.insertarProv_Comp(idCompra, idProvedor))
                return "OK";
            else
                return "Error al generar la nueva compra";    
    }
    
    public String Cancelar(int id)
    {
        return (datos.cancelar(id)) ? "OK":"Error al cancelar la compra";
    }
    
    public int RegresaeIDCompra(String Folio){
        return datos.RegresarIdCompra(Folio);
    }
    
    public int Total()
    {
        return datos.total();
    }
    
    public int TotalMostrados()
    {
        return registrosMostrados;
    }
    
    public int ActualizarExistenciaProd(int cant, int idProducto)
    {
        return datos.ActualizarStock(cant, idProducto);
    }
    
    public int ObtenerStock(int idProducto)
    {
        return datos.ObtenerStock(idProducto);
    }
}
