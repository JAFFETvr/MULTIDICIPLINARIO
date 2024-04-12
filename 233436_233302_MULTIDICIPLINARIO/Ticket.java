import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Ticket {
    private String nombreCliente;
    private double precioTotal;
    private Date fechaCompra; 

    public Ticket(String nombreCliente, double precioTotal) {
        this.nombreCliente = nombreCliente;
        this.precioTotal = precioTotal;
        this.fechaCompra = new Date();
    }

    public void generarNota(int cantidad, String decoracion2, ArrayList<Pedido> listaPedi, int idDeseado) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        System.out.println("----------------------------------------------------");
        System.out.println("                NOTA DE COMPRA                      ");
        System.out.println("----------------------------------------------------");
        System.out.println("Fecha: " + formatoFecha.format(fechaCompra)); 
        System.out.println("Cliente: " + nombreCliente);

    

    Pedido pedidoDeseado = null;
    for (Pedido pedido : listaPedi) {
        if (pedido.getId() == idDeseado) {
            pedidoDeseado = pedido;
            
            break; 
        }
    }

    if (pedidoDeseado != null) {
        System.out.println("ID del pedido: " + pedidoDeseado.getId());
        
        ArrayList<Productos> listaPedidos = pedidoDeseado.getListaPedidos();
        for (Productos producto : listaPedidos) {
            if (producto instanceof Uniformes) {
                Uniformes uniforme = (Uniformes) producto;
                System.out.println("Producto: " + uniforme.getName());
                System.out.println("Cantidad: " + cantidad);
                System.out.println("Color: " + uniforme.getColor());
                System.out.println("Tipo: " + uniforme.getTipo());
                System.out.println("Talla: " + uniforme.getTalla());
                System.out.println("Género: " + uniforme.getSexo());
                System.out.println("Decoración: " + uniforme.getDecoracion());
            } else if (producto instanceof Playeras) {
                Playeras playera = (Playeras) producto;
                System.out.println("Producto: " + playera.getName());
                System.out.println("Cantidad: " + cantidad);
                System.out.println("Color: " + playera.getColor());
                System.out.println("Talla: " + playera.getTalla());
                System.out.println("Género: " + playera.getSexo());
                System.out.println("Decoración: " + playera.getDecoracion());
            } else if (producto instanceof Pantalones) {
                Pantalones pantalon = (Pantalones) producto;
                System.out.println("Producto: " + pantalon.getName());
                System.out.println("Cantidad: " + cantidad);
                System.out.println("Color: " + pantalon.getColor());
                System.out.println("Talla: " + pantalon.getTalla());
                System.out.println("Género: " + pantalon.getSexo());
                System.out.println("Decoración: " + pantalon.getDetalles());
            }
        }
    } else {
        System.out.println("No se encontró ningún pedido con el ID especificado.");
    }

    System.out.println("Total de la Compra: $" + precioTotal);
    System.out.println("Gracias por su compra. ¡Vuelva pronto!");
    System.out.println("----------------------------------------------------");
}
        
         
    }

