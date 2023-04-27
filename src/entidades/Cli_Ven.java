
package entidades;

public class Cli_Ven 
{
   private int idCliente, idVentas; 

    public Cli_Ven() 
    {
    }

    public Cli_Ven(int idCliente, int idVentas) 
    {
        this.idCliente = idCliente;
        this.idVentas = idVentas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }
}