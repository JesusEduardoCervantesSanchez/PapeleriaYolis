/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class Conexion {

    private final String DRIVER = "com.mysql.cj.jdbc.Driver", URL = "jdbc:mysql://localhost:3307/", DB = "Papeleria", USER = "root", PASSWORD = "";
    public Connection cadena;
    public static Conexion instancia;
    

    private Conexion() {
        this.cadena = null;
    }

    public Connection Conectar() {
        try {
            Class.forName(DRIVER);
            this.cadena = DriverManager.getConnection(URL + DB, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
        return this.cadena;
    }

    public void Desconectar() {
        try {
            this.cadena.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public static Conexion getInstance()
    {
        if(instancia==null)
            instancia = new Conexion();
        return instancia;
    }
}
