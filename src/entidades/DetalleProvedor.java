/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Juan Pablo Campos L
 */
public class DetalleProvedor {
    int idProvedores,idCompras;

    public DetalleProvedor(int idProvedores, int idCompras) {
        this.idProvedores = idProvedores;
        this.idCompras = idCompras;
    }

    public int getIdProvedores() {
        return idProvedores;
    }

    public void setIdProvedores(int idProvedores) {
        this.idProvedores = idProvedores;
    }

    public int getIdCompras() {
        return idCompras;
    }

    public void setIdCompras(int idCompras) {
        this.idCompras = idCompras;
    }
    
    
}
