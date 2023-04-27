/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.VentasDAO;
import entidades.Clientes;
import entidades.Empleados;
import entidades.Pro_Ven;
import entidades.Producto;
import entidades.Ventas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CSjes
 */
public class VentasControl {

    private final VentasDAO DATOS;
    private Ventas obj;
    private DefaultTableModel modeloTabla;
    private DefaultTableModel modeloTabla2;
    private DefaultTableModel modeloTabla3;
    private int registrosMostrados;

    public VentasControl() {
        this.DATOS = new VentasDAO();
        obj = new Ventas();
        registrosMostrados = 0;
    }

    public DefaultTableModel listar(String texto) {
        List<Ventas> lista = new ArrayList();
        lista.addAll(DATOS.listar(texto));
        //Crear el modelo y establecer los titulos del modelo
        String titulos[] = {"IdVenta", "Id Cliente", "Nombre del Cliente", "Id Empleado", "Nombre Empleado", "Folio de Venta", "Fecha", "SubTotal", "IVA"};
        modeloTabla = new DefaultTableModel(null, titulos);
        //Recorrer los elementos de la lista con un for each
        String registro[] = new String[9];
        registrosMostrados = 0;
        for (Ventas item : lista) {
            registro[0] = Integer.toString(item.getIdVentas());
            registro[1] = Integer.toString(item.getIdCliente());
            registro[2] = item.getClienteNombre();
            registro[3] = Integer.toString(item.getIdEmpleado());
            registro[4] = item.getNombreEmpleado();
            registro[5] = item.getFolioVenta();
            registro[6] = "" + item.getFechaVenta();
            registro[7] = Double.toString(item.getSubTotal());
            registro[8] = Double.toString(item.getIVA());
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados += 1;
        }
        return modeloTabla;
    }

    public DefaultTableModel listarDetalle(int idVenta) {
        List<Pro_Ven> lista = new ArrayList();
        lista.addAll(DATOS.listarDetalle(idVenta));
        //Crear el modelo y establecer los titulos del modelo"
        String titulos[] = {"ID Producto", "Producto", "Cantidad", "Precio", "SubTotal"};
        modeloTabla = new DefaultTableModel(null, titulos);
        //Recorrer los elementos de la lista con un for each
        String estado;
        String registro[] = new String[5];
        registrosMostrados = 0;
        for (Pro_Ven item : lista) {
            registro[0] = "" + item.getIdProductos();
            registro[1] = item.getNombreProducto();
            registro[2] = "" + item.getCantProVen();
            registro[3] = "" + item.getPrecioU();
            registro[4] = "" + item.getSubTotal();
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados += 1;
        }
        return modeloTabla;
    }

    public DefaultTableModel ListarProductos(String valor) {
        List<Producto> lista = new ArrayList();
        lista.addAll(DATOS.ListarProductos(valor));
        String titulos[] = {"Id", "Id Categotia", "Producto", "Categoria", "Existencias", "P. Compra", "P. Venta", "Ganancia", "Imagen"};
        modeloTabla3 = new DefaultTableModel(null, titulos);
        String registro[] = new String[9];
        registrosMostrados = 0;
        for (Producto item : lista) {
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

    public DefaultTableModel ListarCliente(String valor) {
        List<Clientes> lista = new ArrayList();
        lista.addAll(DATOS.ListarCliente(valor));
        //int idCliente, String nombreCliente, String apellidosCliente, String telefonoCliente, String correoCliente
        String titulos[] = {"Id", "Nombre", "Apellidos", "Telefono", "Correo"};
        modeloTabla = new DefaultTableModel(null, titulos);
        String registro[] = new String[5];
        registrosMostrados = 0;
        for (Clientes item : lista) {
            registro[0] = Integer.toString(item.getIdCliente());
            registro[1] = item.getNombreCliente();
            registro[2] = item.getApellidosCliente();
            registro[3] = item.getTelefonoCliente();
            registro[4] = item.getCorreoCliente();
            modeloTabla.addRow(registro);
            registrosMostrados += 1;
        }
        return modeloTabla;
    }

    public DefaultTableModel ListarEmpleados(String valor) {
        List<Empleados> lista = new ArrayList();
        lista.addAll(DATOS.ListarEmpleado(valor));
        String titulos[] = {"Id", "Nombre", "Telefono", "Domicilio", "CP", "Correo", "Contraseña"};
        modeloTabla = new DefaultTableModel(null, titulos);
        String registro[] = new String[7];
        registrosMostrados = 0;
        for (Empleados item : lista) {
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

    public String insertar(String FolioVenta, double precioVenta, double IVA, DefaultTableModel detalles) {
        List<Pro_Ven> listaProductos = new ArrayList();
        int i;
        int idProducto;
        int cantidad;
        double precio;
        double subtotal;
        //Verificar si existe la categoria
        if (DATOS.existe(FolioVenta)) {
            return "El registro ya existe";
        } else {
            //Llenar el objeto
            obj.setFolioVenta(FolioVenta);
            obj.setSubTotal(precioVenta);
            obj.setIVA(IVA);
            //Convertir el Default Table Model a una lista
            for (i = 0; i < detalles.getRowCount(); i++) {
                idProducto = Integer.parseInt("" + detalles.getValueAt(i, 0));
                cantidad = Integer.parseInt("" + detalles.getValueAt(i, 2));
                precio = Double.parseDouble("" + detalles.getValueAt(i, 3));
                subtotal = Double.parseDouble("" + detalles.getValueAt(i, 4));
                //Insertar los valores en la lista
                listaProductos.add(new Pro_Ven(idProducto, cantidad, precio, subtotal));
            }
            obj.setDetalles(listaProductos);
            //Insertar el objeto en la base de datos
            if (DATOS.insertar(obj)) {
                return "OK";
            } else {
                return "Error al insertar el registro";
            }
        }
    }

    public String InsertarEmp_Ven(int idVenta, int idEmpleado)
    {
            if(DATOS.insertarEmP_Ven(idVenta, idEmpleado))
                return "OK";
            else
                return "Error al generar la nueva venta";    
    }
    
    public String InsertarCli_Ven(int idVenta, int idCliente){
        if(DATOS.insertarCli_Ven(idVenta, idCliente)){
            return "OK";
        }
        else
        {
            return "Error al generar la nueva venta";
        }
    }
    
    public int total() {
        return DATOS.total();
    }
    
    public int RegresarIdVenta(String Folio){
        return DATOS.RegresarIdVenta(Folio);
    }

    public int totalMostrados() {
        return registrosMostrados;
    }

     public int ActualizarExistenciaProd(int cant, int idProducto)
    {
        return DATOS.ActualizarStock(cant, idProducto);
    }
    
    public int ObtenerStock(int idProducto)
    {
        return DATOS.ObtenerStock(idProducto);
    }
}
