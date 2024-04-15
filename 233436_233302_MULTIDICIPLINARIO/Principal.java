import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.xml.transform.Source;

public class Principal {
    public static void main(String[] args) {
    
        Pedido pedido = new Pedido();
        Cliente cliente = new Cliente();
        ArrayList<Pedido> listaPedi = pedido.getListaPedi();
        ArrayList<Cliente> listaClientes = pedido.getListaClientes();

        Inventario inventario = new Inventario();
        Uniformes uniformes = new Uniformes();
        Playeras playeras = new Playeras();
        Pantalones pantalones = new Pantalones();
        boolean bandera = true;
        do {
            try {
                verMenu(pedido, inventario,uniformes,playeras,pantalones ,listaPedi,cliente,listaClientes);
                bandera = false;
            } catch (InputMismatchException e) {
                System.out.println("Intento de nuevo, no ingresó algo válido.\n");
              
            } catch (ArithmeticException e) {
                System.out.println("Cero es un denominador inválido. Intente de nuevo.\n");
            }
        } while (bandera);
    }

    public static void verMenu(Pedido pedido, Inventario inventario,Uniformes uniformes,Playeras playeras, Pantalones pantalones, ArrayList<Pedido> listaPedi, Cliente cliente, ArrayList<Cliente> listaClientes ) {
        Scanner leer = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Ingrese lo que desea hacer:");
            System.out.println("1.  Administrar Cliente");
            System.out.println("2. Administrar inventario");
            System.out.println("3. Administrar pedido");
            System.out.println("4. Salir");
            opcion = leer.nextInt();
        

            switch (opcion) {
                case 1:
                
              getionarCliente(pedido, inventario, uniformes, playeras, pantalones, listaPedi, cliente, listaClientes);                  
                break;

                case 2:
                boolean bandera = true;
                do {
                    try {
                        GestionarInventario(inventario, pedido, uniformes, playeras, pantalones, listaPedi, cliente, listaClientes);
                        bandera = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Intento de nuevo, no ingresó algo válido.\n");
                      
                    } catch (ArithmeticException e) {
                        System.out.println("Cero es un denominador inválido. Intente de nuevo.\n");
                    }
                } while (bandera);
                   
                    break;

                case 3:
                   gestionarPedido(pedido, inventario, uniformes, playeras, pantalones, listaPedi, cliente, listaClientes);
                    break;

               
                case 4:
                System.out.println("Saliendo del programa...");
                break;
                    
                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número válido.");
                    break;
            }
        } while (opcion != 4);
    }

    public static void getionarCliente (Pedido pedido, Inventario inventario,Uniformes uniformes,Playeras playeras, Pantalones pantalones, ArrayList<Pedido> listaPedi, Cliente cliente, ArrayList<Cliente> listaClientes){
        Scanner leer = new Scanner(System.in);
        int opc;
        do{

            System.out.println("Que movimiento te gustaia hacer\n1.Agregar cliente\n2.Gestionar cliente\n3.ver lista clientes");
            opc = leer.nextInt();
       
            if(opc==1){
                pedido.registrarCliente();
        }

        if(opc==2){
            pedido.gestionarCliente(listaPedi);
        }
        if (opc==3){
            cliente.verClientes(listaClientes);
        }
        
    }while(opc<1||opc>3);
    }

    public static void GestionarInventario(Inventario inventario,Pedido pedido,Uniformes uniformes,Playeras playeras, Pantalones pantalones, ArrayList<Pedido> listaPedi, Cliente cliente, ArrayList<Cliente> listaClientes) {
        Scanner leer = new Scanner(System.in);
        int opc;
        do {
            System.out.println("Que movimiento te gustaría hacer\n1.Agregar al inventario\n2.Eliminar el inventario\n3.Ver el inventario");
            opc = leer.nextInt();

            if (opc == 1) {
                try {
                    inventario.agregarInventario(leer);
                } catch (InputMismatchException ex) {
                    System.out.println("Error: el valor ingresado no es válido.");
                    leer.nextLine(); 
                }
            } else if (opc == 2) {
                inventario.eliminarInventario();
            } else if (opc == 3) {
                inventario.imprimirInventario();
            }
        } while (opc<1||opc>3 );
    }
    public static void gestionarPedido(Pedido pedido, Inventario inventario,Uniformes uniformes,Playeras playeras, Pantalones pantalones, ArrayList<Pedido> listaPedi, Cliente cliente, ArrayList<Cliente> listaClientes){
        Scanner leer =  new Scanner (System.in);
        int opcpedido;
        do {
            System.out.println("Ingresa lo que desea realizar ");
            System.out.println("1.Realizar Pedido");
            System.out.println("2.Ver lista pedido");
            System.out.println("3.Modificar pedido");
            opcpedido=leer.nextInt();
        
        switch (opcpedido) {
            case 1:
            pedido.generarPedido(inventario,uniformes,pantalones,playeras);
            break;
            case 2:
            pedido.verPedidos(listaPedi);

            break;
            case 3 :
             System.out.println("Ingresa el ID del pedido a modificar");
            int idPedido=leer.nextInt();
            pedido.modificarPedido(idPedido, inventario, uniformes, pantalones, playeras);
             break;
        
            default:
                break;
        }
       } while (opcpedido<1 ||opcpedido>4);
    }
}
