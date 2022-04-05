/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.VentasDAO;
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
        String titulos[] = {"Id", "Numero de Venta", "Nombre del Cliente", "Categoria del Prodcuto", "Cantidad", "Precio de Venta", "Fecha de Venta"};
        modeloTabla = new DefaultTableModel(null, titulos);
        //Recorrer los elementos de la lista con un for each
        String estado;
        String registro[] = new String[7];
        registrosMostrados = 0;
        for (Ventas item : lista) {
            registro[0] = Integer.toString(item.getIdVentas());
            registro[1] = item.getNumeroVenta();
            registro[2] = item.getNombreCliente();
            registro[3] = item.getCategoriaProducto();
            registro[4] = Integer.toString(item.getCantidad());
            registro[5] = Double.toString(item.getPrecioVenta());
            registro[6] = item.getFechaVenta();
            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);
            registrosMostrados += 1;
        }
        return modeloTabla;
    }

    public String[] buscar(int id) {
        List<Ventas> lista = new ArrayList();
        lista.addAll(DATOS.listar(id));
        String registro[] = new String[7];
        for (Ventas item : lista) {
            registro[0] = Integer.toString(item.getIdVentas());
            registro[1] = item.getNumeroVenta();
            registro[2] = item.getNombreCliente();
            registro[3] = item.getCategoriaProducto();
            registro[4] = Integer.toString(item.getCantidad());
            registro[5] = Double.toString(item.getPrecioVenta());
            registro[6] = item.getFechaVenta();
        }
        return registro;
    }

    public String insertar(String numeroVenta, String nombreCliente, String categoriaProdcuto, int cantidad, double precioVenta, String fechaVenta) {
        //Verificar si existe la categoria
        if (DATOS.existe(numeroVenta)) {
            return "El registro ya existe";
        } else {
            //Llenar el objeto
            obj.setNumeroVenta(numeroVenta);
            obj.setNombreCliente(nombreCliente);
            obj.setCategoriaProducto(categoriaProdcuto);
            obj.setCantidad(cantidad);
            obj.setPrecioVenta(precioVenta);
            obj.setFechaVenta(fechaVenta);
            //Insertar el objeto en la base de datos
            if (DATOS.insertar(obj)) {
                return "Ok";
            } else {
                return "Error al insertar el registro";
            }
        }
    }

    public String actualizar(int idVentas, String numeroVenta, String nombreCliente, String categoriaProdcuto, int cantidad, double precioVenta, String fechaVenta) {

        //Verificar si existe la categoria
        if (DATOS.existe(numeroVenta)) {
            //Llenar el objeto
            obj.setIdVentas(idVentas);
            obj.setNumeroVenta(numeroVenta);
            obj.setNombreCliente(nombreCliente);
            obj.setCategoriaProducto(categoriaProdcuto);
            obj.setCantidad(cantidad);
            obj.setPrecioVenta(precioVenta);
            obj.setFechaVenta(fechaVenta);
            //Actualizar el regsitro en la base de datos
            if (DATOS.actualizar(obj)) {
                return "Ok";
            } else {
                return "Error al actualizar el registro";
            }
        }else{
            return "Error la categoria no existe";
        }
    }

    public int total() {
        return DATOS.total();
    }

    public int totalMostrados() {
        return registrosMostrados;
    }

}
