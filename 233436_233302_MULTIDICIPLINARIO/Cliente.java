import java.util.ArrayList;

public class Cliente {
    private String name;
    private long numTelefono;
    private String direccion;
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
   public void setNumTelefono(long numTelefono) {
       this.numTelefono = numTelefono;
   }
   public long getNumTelefono() {
       return numTelefono;
   }



   public void verClientes(ArrayList<Cliente> listaClientes) {
    if (listaClientes.isEmpty()) {
        System.out.println("No hay clientes registrados.");
        return;
    }

    System.out.println("Listado de clientes:");
    System.out.println("-------------------------");
    for (Cliente cliente : listaClientes) {
        System.out.println("Nombre: " + cliente.getName());
        System.out.println("Número de teléfono: " + cliente.getNumTelefono());
        System.out.println("Dirección: " + cliente.getDireccion());
        System.out.println("-------------------------");
    }
}
}
