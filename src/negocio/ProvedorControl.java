/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.ProveedorDAO;
import entidades.Provedores;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Pablo Campos L
 */
public class ProvedorControl {

    private final ProveedorDAO datos;
    private Provedores obj;
    private DefaultTableModel modeloTabla;

    public ProvedorControl() {
        datos = new ProveedorDAO();
        obj = new Provedores();
    }

    public DefaultTableModel Listar(String texto) {
        List<Provedores> Lista = new ArrayList();
        Lista.addAll(datos.listar(texto));

        // Crear modelo y establecer los titulos del modelo 
        String titulos[] = {"id", "Nombre", "Codigo", "Telefono", "Correo", "Empresa"};
        modeloTabla = new DefaultTableModel(null, titulos);
        //Donde vamos a recorrer la estructura o los elementos de la lista con for each
        String registro[] = new String[6];

        for (Provedores item : Lista) {
            registro[0] = Integer.toString(item.getIdProvedores());
            registro[1] = item.getNombreProvedor();
            registro[2] = Integer.toString(item.getCodigo());
            registro[3] = item.getTelefono();
            registro[4] = item.getCorreo();
            registro[5] = item.getEmpresa();

            //Insertar el registro en el modelo
            modeloTabla.addRow(registro);

        }
        return modeloTabla;
    }

    public String Insertar(String nombre, int Codigo, String telefono, String correo, String empresa) {
        //verificar si existe la categoria
        if (datos.existe(nombre)) {
            return "El registro ya existe";
        } else {
            //llenar el objeto
            obj.setNombreProvedor(nombre);
            obj.setCodigo(Codigo);
            obj.setTelefono(telefono);
            obj.setCorreo(correo);
            obj.setEmpresa(empresa);
            //Insertar el objeto en la base de datos
            if (datos.insertar(obj)) {
                return "OK";
            } else {
                return "Error al insertar el registro";
            }
        }
    }

    public String Actualizar(int id, String nombre, String nombreAnt, int Codigo, String telefono, String correo, String empresa) {
        //Verificar si el usuario esta cambiando el nombre de la categoria
        if (nombre.equals(nombreAnt)) {
            obj.setIdProvedores(id);
            obj.setNombreProvedor(nombre);
            obj.setCodigo(Codigo);
            obj.setTelefono(telefono);
            obj.setCorreo(correo);
            obj.setEmpresa(empresa);
            //Actualizar el registro en la base de datos
            if (datos.actualizar(obj)) {
                return "OK";
            } else {
                return "ERROR al actualizar el registro";
            }
        } else {
            //Verificar si existe la categoria
            if (datos.existe(nombre)) {
                return "el nombre del provedor ya existe";
            } else {
                //llenar el objeto
                obj.setIdProvedores(id);
                obj.setNombreProvedor(nombre);
                obj.setCodigo(Codigo);
                obj.setTelefono(telefono);
                obj.setCorreo(correo);
                obj.setEmpresa(empresa);
                //Actualizar el registro en la base de datos
                if (datos.actualizar(obj)) {
                    return "OK";
                } else {
                    return "ERROR al actualizar el registro";
                }
            }
        }
    }
    
    public String Desactivar(int id) {
        if (datos.desactivar(id)) {
            return "OK";
        } else {
            return "No se pudo desactivar el registro";
        }
    }
    
     public int total() {
        return datos.total();
    }
     
     
}
