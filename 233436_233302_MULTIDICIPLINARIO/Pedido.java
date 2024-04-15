import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Pedido {
    private  int  precioTotal;
    private int id=0; 
    
    private ArrayList<Productos> listaPedidos = new ArrayList<>();
    private ArrayList<Cliente> listaClientes = new ArrayList<>();
    private ArrayList<Pedido> listaPedi = new ArrayList<>();
    private String nombrecliente;
    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }
    public String getNombrecliente() {
        return nombrecliente;
    }
    public void setListaPedi(ArrayList<Pedido> listaPedi) {
        this.listaPedi = listaPedi;
    }
    public ArrayList<Pedido> getListaPedi() {
        return listaPedi;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
         this.listaClientes = listaClientes;
     }
     public ArrayList<Cliente> getListaClientes() {
         return listaClientes;
     }
    public void setListaPedidos(ArrayList<Productos> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }
    public ArrayList<Productos> getListaPedidos() {
        return listaPedidos;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
   public void setPrecioTotal(int precioTotal) {
       this.precioTotal = precioTotal;
   }
   public int getPrecioTotal() {
       return precioTotal;
   }    
    public  void generarPedido(Inventario inventario,Uniformes uniformes,Pantalones pantalones,Playeras playeras)throws InputMismatchException{
       // listaPedidos.clear();
       boolean bandera = true;
       do {
           try {
            Pedido nuevoPedido = new Pedido();
        nuevoPedido.setListaClientes(getListaClientes());
        Scanner leer = new Scanner(System.in );
        int opc2;
        int precioTotal=0;
        int can =0;
        String decoracion ="";
        boolean clienteEncontrado = false;
        if (inventario.getLisMaterial().isEmpty()) {
            System.out.println("El inventario está vacío. No se pueden generar pedidos.");
            inventario.agregarInventario(leer);
            return;
        }
    
        if (getListaClientes().isEmpty()) {
            System.out.println("NO HAY NINGUN CLIENTE REGISTRADO POR FAVOR PRIMERO REGISTRE UN CLIENTE.");
            System.out.println("------------------------------------------------------------------");
            registrarCliente();
        } else{
            System.out.println("--------------------------------------------------------");
            System.out.println("Ingrese el nombre del cliente que desea hacer la compra:");
          String nombreCliente = leer.nextLine();
          

          do{
           
         do {
            for (int i = 0; i < listaClientes.size(); i++) {
                Cliente cliente = listaClientes.get(i);
                
                if (cliente.getName().equals(nombreCliente)) {
                    clienteEncontrado = true;
                    setNombrecliente(nombreCliente);
                    nuevoPedido.setNombrecliente(nombreCliente);
                    System.out.println("el nombre es :"+nuevoPedido.getNombrecliente());

                    int exis;
                    do {
                        System.out.println("HOLA , Ingrese lo que llevara su pedido\n1.Uniformes(PRECIO:$200)\n2.Playeras(PRECIO:$250)\n3.Pantalones(PRECIO:$150)");
                         exis = leer.nextInt();
                    } while (exis<1|| exis >3);
                  
                  
                    leer.nextLine();
                    if (exis==1) {
                        int opc1;
                       do {
                        System.out.println("Ingresa el tipo de uniformes\n1.Escolares\n2.Deportivos");
                         opc1=leer.nextInt();
                       } while (opc1<1 || opc1 >2);
                    
                       if (opc1==1) {
                       System.out.println("Ingrese la cantidad de uniformes a comprar.");
                           can=leer.nextInt();

                           int cantidadTelas = 0;
                           int cantidadBotones = 0;
                           int cantidadHilos = 0;
                           int cantidadCierres = 0;

                           for (Material material : inventario.getLisMaterial()) {
                            switch (material.getName().toLowerCase()) {
                                case "telas":
                                    cantidadTelas = can * 60;
                                    if (cantidadTelas > material.getCantidad()) {
                                        System.out.println("No hay suficiente cantidad de telas en el inventario.");
                                        return; 
                                    }
                                    break;
                                case "botones":
                                    cantidadBotones = can * 4;
                                    if (cantidadBotones > material.getCantidad()) {
                                        System.out.println("No hay suficiente cantidad de botones en el inventario.");
                                        return;
                                    }
                                    break;
                                case "hilos":
                                    cantidadHilos = can * 20;
                                    if (cantidadHilos > material.getCantidad()) {
                                        System.out.println("No hay suficiente cantidad de hilos en el inventario.");
                                        return;
                                    }
                                    break;
                                case "cierres":
                                    cantidadCierres = can * 2;
                                    if (cantidadCierres > material.getCantidad()) {
                                        System.out.println("No hay suficiente cantidad de cierres en el inventario.");
                                        return;
                                    }
                                    break;
                            }
                        }

                        for (Material material : inventario.getLisMaterial()) {
                            switch (material.getName().toLowerCase()) {
                                case "telas":
                                    material.setCantidad(material.getCantidad() - cantidadTelas);
                                    break;
                                case "botones":
                                    material.setCantidad(material.getCantidad() - cantidadBotones);
                                    break;
                                case "hilos":
                                    material.setCantidad(material.getCantidad() - cantidadHilos);
                                    break;
                                case "cierres":
                                    material.setCantidad(material.getCantidad() - cantidadCierres);
                                    break;
                            }
                        }
                          String tipo ="  Escolares";
                          String name = "Uniforme";
                           int precio =200;
                           
                           precioTotal= precioTotal+can*precio;
                           String talla;
                          String color;
                          System.out.println("Ingrese la talla");
                          talla=leer.next();
                          leer.nextLine();
                          System.out.println("Ingrese el color de su producto");
                          color =leer.nextLine();
                          System.out.println("Ingrese si sera Masculino(M)/Femenino(F)");
                          String sexo = leer.nextLine();
                          uniformes.validacionProducto();
                          System.out.println("Su total de todo sera : "+precioTotal);
                        
   
                        Uniformes unifor = new Uniformes();
                         unifor.setColor(color);
                         unifor.setPrecio(precio);
                         unifor.setTalla(talla);
                         unifor.setTipo(tipo);
                         unifor.setName(name);
                         unifor.setSexo(sexo);
                         unifor.setCantidad(can);
                         unifor.setDecoracion(uniformes.getDecoracion());
   
                         nuevoPedido.listaPedidos.add(unifor);
                         leer.nextLine();
                    
                    }
                       if (opc1==2) {

                           System.out.println("Ingrese la cnatidad de uniformes a comprar.");
                            can=leer.nextInt();


                           int cantidadTelas = 0;
                           int cantidadBotones = 0;
                           int cantidadHilos = 0;
                           int cantidadCierres = 0;

                           for (Material material : inventario.getLisMaterial()) {
                            switch (material.getName().toLowerCase()) {
                                case "telas":
                                    cantidadTelas = can * 60;
                                    if (cantidadTelas > material.getCantidad()) {
                                        System.out.println("No hay suficiente cantidad de telas en el inventario.");
                                        return; 
                                    }
                                    break;
                                case "botones":
                                    cantidadBotones = can *4;
                                    if (cantidadBotones > material.getCantidad()) {
                                        System.out.println("No hay suficiente cantidad de botones en el inventario.");
                                        return; 
                                    }
                                    break;
                                case "hilos":
                                    cantidadHilos = can * 20;
                                    if (cantidadHilos > material.getCantidad()) {
                                        System.out.println("No hay suficiente cantidad de hilos en el inventario.");
                                        return; 
                                    }
                                    break;
                                case "cierres":
                                    cantidadCierres = can * 2;
                                    if (cantidadCierres > material.getCantidad()) {
                                        System.out.println("No hay suficiente cantidad de cierres en el inventario.");
                                        return; 
                                    }
                                    break;
                            }
                        }

                           for (Material material : inventario.getLisMaterial()) {
                            switch (material.getName().toLowerCase()) {
                                case "telas":
                                    material.setCantidad(material.getCantidad() - cantidadTelas);
                                    break;
                                case "botones":
                                    material.setCantidad(material.getCantidad() - cantidadBotones);
                                    break;
                                case "hilos":
                                    material.setCantidad(material.getCantidad() - cantidadHilos);
                                    break;
                                case "cierres":
                                    material.setCantidad(material.getCantidad() - cantidadCierres);
                                    break;
                            }
                        }
                           String tipo =" Deportivos ";
                           String name = "Uniforme";
                           int precio =200;
                        
                           precioTotal= precioTotal+can*precio;
                          String talla;
                          String color;
                          System.out.println("Ingrese la talla");
                          talla=leer.next();
                          leer.nextLine();
                          System.out.println("Ingrese el color de su producto");
                          color =leer.nextLine();
                          System.out.println("Ingrese si sera Masculino(M)/Femenino(F)");
                          String sexo = leer.nextLine();
                          uniformes.validacionProducto();
                          System.out.println("Su total sera : "+precioTotal);
                         
   
                        Uniformes unifor = new Uniformes();
                         unifor.setColor(color);
                         unifor.setPrecio(precio);
                         unifor.setTalla(talla);
                         unifor.setTipo(tipo);
                         unifor.setName(name);
                         unifor.setSexo(sexo);
                         unifor.setCantidad(can);
                         unifor.setDecoracion(uniformes.getDecoracion());
   
                         nuevoPedido.listaPedidos.add(unifor);
                         leer.nextLine();
                       }
                    }
                    if (exis==2) {
                       
                       System.out.println("Ingrese la cantidad de playeras a comprar .");
                       can=leer.nextInt();


                       int cantidadTelas = 0;
                       int cantidadBotones = 0;
                       int cantidadHilos = 0;
                       int cantidadCierres = 0;

                       for (Material material : inventario.getLisMaterial()) {
                        switch (material.getName().toLowerCase()) {
                            case "telas":
                                cantidadTelas = can * 30;
                                if (cantidadTelas > material.getCantidad()) {
                                    System.out.println("No hay suficiente cantidad de telas en el inventario.");
                                    return;
                                }
                                break;
                            case "botones":
                                cantidadBotones = can * 2;
                                if (cantidadBotones > material.getCantidad()) {
                                    System.out.println("No hay suficiente cantidad de botones en el inventario.");
                                    return; 
                                }
                                break;
                            case "hilos":
                                cantidadHilos = can * 10;
                                if (cantidadHilos > material.getCantidad()) {
                                    System.out.println("No hay suficiente cantidad de hilos en el inventario.");
                                    return;
                                }
                                break;
                            case "cierres":
                                cantidadCierres = can * 0;
                                if (cantidadCierres > material.getCantidad()) {
                                    System.out.println("No hay suficiente cantidad de cierres en el inventario.");
                                    return;
                                }
                                break;
                        }
                    }

                       for (Material material : inventario.getLisMaterial()) {
                        switch (material.getName().toLowerCase()) {
                            case "telas":
                                material.setCantidad(material.getCantidad() - cantidadTelas);
                                break;
                            case "botones":
                                material.setCantidad(material.getCantidad() - cantidadBotones);
                                break;
                            case "hilos":
                                material.setCantidad(material.getCantidad() - cantidadHilos);
                                break;
                            case "cierres":
                                material.setCantidad(material.getCantidad() - cantidadCierres);
                                break;
                        }
                    }
                       int precio =250;
                     
                       precioTotal= precioTotal+can*precio;
                       String talla;
                      String color;
                      String name ="Playeras";
                      System.out.println("Ingrese la talla ");
                      talla=leer.next();
                      leer.nextLine();
                      System.out.println("Ingrese el color de su producto");
                      color =leer.nextLine();
                      System.out.println("Ingrese si sera Masculino(M)/Femenino(F)");
                      String sexo = leer.nextLine();
                     playeras.validacionProducto();
                      System.out.println("Su total sera : "+precioTotal);
                     
   
                    Playeras playera = new Playeras();
                     playera.setColor(color);
                     playera.setPrecio(precio);
                     playera.setTalla(talla);
                     playera.setName(name);
                     playera.setSexo(sexo);
                     playera.setCantidad(can);
                     playera.setDecoracion(playeras.getDecoracion());
   
                     nuevoPedido.listaPedidos.add(playera);
                     leer.nextLine();
                    }
                    if (exis==3) {
                       System.out.println("Ingrese la cantidad de pantalones a comprar .");
                        can=leer.nextInt();

                    
                       int cantidadTelas = 0;
                       int cantidadBotones = 0;
                       int cantidadHilos = 0;
                       int cantidadCierres = 0;

                       for (Material material : inventario.getLisMaterial()) {
                        switch (material.getName().toLowerCase()) {
                            case "telas":
                                cantidadTelas = can * 30;
                                if (cantidadTelas > material.getCantidad()) {
                                    System.out.println("No hay suficiente cantidad de telas en el inventario.");
                                    return; 
                                }
                                break;
                            case "botones":
                                cantidadBotones = can * 2;
                                if (cantidadBotones > material.getCantidad()) {
                                    System.out.println("No hay suficiente cantidad de botones en el inventario.");
                                    return; 
                                }
                                break;
                            case "hilos":
                                cantidadHilos = can * 15;
                                if (cantidadHilos > material.getCantidad()) {
                                    System.out.println("No hay suficiente cantidad de hilos en el inventario.");
                                    return; 
                                }
                                break;
                            case "cierres":
                                cantidadCierres = can * 1;
                                if (cantidadCierres > material.getCantidad()) {
                                    System.out.println("No hay suficiente cantidad de cierres en el inventario.");
                                    return;
                                }
                                break;
                        }
                    }

                       for (Material material : inventario.getLisMaterial()) {
                        switch (material.getName().toLowerCase()) {
                            case "telas":
                                material.setCantidad(material.getCantidad() - cantidadTelas);
                                break;
                            case "botones":
                                material.setCantidad(material.getCantidad() - cantidadBotones);
                                break;
                            case "hilos":
                                material.setCantidad(material.getCantidad() - cantidadHilos);
                                break;
                            case "cierres":
                                material.setCantidad(material.getCantidad() - cantidadCierres);
                                break;
                        }
                    }

                       int precio =150;

                       precioTotal= precioTotal+can*precio;
                       String talla;
                      String color;
                      String name= "Pantalones ";
                      System.out.println("Ingrese la talla");
                      talla=leer.next();
                      leer.nextLine();
                      System.out.println("Ingrese el color de su producto ");
                      color =leer.nextLine();
                      System.out.println("Ingrese si sera  Masculino(M)/Femenino(F)");
                      String sexo = leer.nextLine();
                      pantalones.validacionProducto();
                      
                      System.out.println("Su total sera: "+precioTotal);
   
                    Pantalones pantalon = new Pantalones();
                     pantalon.setColor(color);
                     pantalon.setPrecio(precio);
                     pantalon.setTalla(talla);
                     pantalon.setName(name);
                     pantalon.setSexo(sexo);
                     pantalon.setCantidad(can);
                     pantalon.setDetalles(pantalones.getDetalles());
   
                     nuevoPedido.listaPedidos.add(pantalon);
                     leer.nextLine();
                    }
                    }
                   
                  } 
                  if (!clienteEncontrado) {
                    System.out.println("Cliente no encontrado. Por favor, ingrese un nombre de cliente válido.");
                    nombreCliente = leer.nextLine();
                   
                }
                }while (!clienteEncontrado);
                    System.out.println("Dedea agregar mas productos\n1)SI\n2)NO");
                    opc2=leer.nextInt();


                } while (opc2==1);
                id++;
                nuevoPedido.setId(id);
                System.out.println("Pedido generado correctamente con ID: " + id);
                for (Productos producto : listaPedidos) {
                    producto.setId(id);
                }
                int idDeseado = nuevoPedido.getId();

                setPrecioTotal(precioTotal);
                nuevoPedido.setPrecioTotal(precioTotal);
                System.out.println(" el precio total es : "+nuevoPedido.getPrecioTotal());

                listaPedi.add(nuevoPedido);


                nuevoPedido.validarTipoDeEntrega(nuevoPedido.getPrecioTotal(),listaPedi, nombreCliente ,can , decoracion, idDeseado); 
            }
            
               bandera = false;
           } catch (InputMismatchException e) {
               System.out.println("Intento de nuevo, no ingresó algo válido.\n");
             
           } catch (ArithmeticException e) {
               System.out.println("Cero es un denominador inválido. Intente de nuevo.\n");
           }
       } while (bandera);
        
           
                  
                   
        }  
        
        public void validarTipoDeEntrega( int precioTotal, ArrayList<Pedido> listaPedi ,String nombreCliente , int can ,String decoracion, int idDeseado)throws InputMismatchException{
            
            boolean bandera = true;
            do {
                try {
                    Scanner leer = new Scanner(System.in);
            
                    String nombreclient = nombreCliente;
                    int cantidad = can;
                    String decoracion2=decoracion;
                    
                    int opc;
                   do {
                    System.out.println("Ingresa el tipo de entrega del pedido\n1.Normal\n2.Envio($50 COSTO EXTRA)");
                    opc = leer.nextInt();
                   } while (opc<1||opc>2);
                    
                    int total =0;
                    if (opc == 1) {
                        System.out.println("Elegiste la opción de entrega NORMAL");
                        total = precioTotal;
                
                    }
                    if (opc == 2) {
                        System.out.println("Elegiste la opción de entrega con ENVÍO");
                        
                        for (Pedido pedido : listaPedi) {
                            if (pedido instanceof Pedido) {
                                total = precioTotal+50; 
                                setPrecioTotal(total);
                                System.out.println("Su total es : $" + total);
                                break;
                            }
                        }
        
                    }
                
                    
                    Ticket ticket = new Ticket(nombreclient, total);
                    ticket.generarNota(cantidad,decoracion2 , listaPedi,idDeseado);
                    bandera = false;
                } catch (InputMismatchException e) {
                    System.out.println("Intento de nuevo, no ingresó algo válido.\n");
                  
                } catch (ArithmeticException e) {
                    System.out.println("Cero es un denominador inválido. Intente de nuevo.\n");
                }
            } while (bandera);
           }

    public void registrarCliente()throws InputMismatchException{
        boolean bandera = true;
        do {
            try {

                Scanner leer = new Scanner(System.in);
                String name; 
                long Ntelefonico;
                String direccion ; 
                int opc=0;
              do {
                System.out.println("-----------");
                System.out.println("Ingrese el nombre del cliente a registrar ");
                name = leer.nextLine();
                if (verificarNombreCliente(name)) {
                    System.out.println("Este nombre ya está registrado. Intente con otro nombre.");
                    continue; // Volver al inicio del bucle y solicitar nuevamente el nombre
                }
                
                System.out.println("Ingrese el numero de telefono ");
                Ntelefonico = leer.nextLong();
                leer.nextLine();
                System.out.println("Ingrese la dirrecion de cliente");
                direccion= leer.nextLine();
                
        
                Cliente cliente = new Cliente();
                cliente.setName(name);
                cliente.setDireccion(direccion);
                cliente.setNumTelefono(Ntelefonico);
                
                listaClientes.add(cliente);
        
                System.out.println("Desea agregar otro cliente\n1.SI\n2.Cualquier otro numero para no");
                opc=leer.nextInt();
                leer.nextLine();
        
              } while (opc==1);
                bandera = false;
            } catch (InputMismatchException e) {
                System.out.println("Intento de nuevo, no ingresó algo válido.\n");
              
            } catch (ArithmeticException e) {
                System.out.println("Cero es un denominador inválido. Intente de nuevo.\n");
            }
        } while (bandera);
    }
    

    public boolean verificarNombreCliente(String nombre) {

        for (Cliente cliente : listaClientes) {
            if (cliente.getName().equalsIgnoreCase(nombre)) {
                return true; 
            }
        }
        return false;
    }
  

    
    public void gestionarCliente(ArrayList<Pedido> listaPedi2) {
    boolean bandera = true;
    do {
        try {
            Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cliente que desea editar: ");
        String nombreCliente = leer.nextLine();
        
        Cliente clienteEncontrado = null;
        
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            if (cliente.getName().equals(nombreCliente)) {
                clienteEncontrado = cliente;
                break;
            }
        }
        
        if (clienteEncontrado == null) {
            System.out.println("El cliente no existe.");
            return;
        }
        
        
        System.out.println("Seleccione una opción:");
        System.out.println("1. Editar información del cliente");
        System.out.println("2. Eliminar cliente");
        int opcion = leer.nextInt();
        leer.nextLine();
        switch (opcion) {
            case 1:
               
                System.out.println("Ingrese el nuevo nombre del cliente:");
                String nuevoNombre = leer.nextLine();
                
                System.out.println("Ingrese el nuevo número de teléfono:");
                long nuevoTelefono = leer.nextLong();
                leer.nextLine(); 
                System.out.println("Ingrese la nueva dirección del cliente:");
                String nuevaDireccion = leer.nextLine();
                
                clienteEncontrado.setName(nuevoNombre);
                clienteEncontrado.setNumTelefono(nuevoTelefono);
                clienteEncontrado.setDireccion(nuevaDireccion);
                System.out.println("La información del cliente ha sido actualizada.");
                for (Pedido pedido : listaPedi2) {
                    if (pedido.getNombrecliente().equals(nombreCliente)) {
                        pedido.setNombrecliente(nuevoNombre);
                    }
                }
                break;
            case 2:
                // Eliminar cliente
                for (int i = 0; i < listaClientes.size(); i++) {
                    Cliente cliente = listaClientes.get(i);
                    if (cliente.equals(clienteEncontrado)) {
                        listaClientes.remove(i);
                        System.out.println("El cliente ha sido eliminado.");
                        break;
                    }
                }
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
            bandera = false;
        } catch (InputMismatchException e) {
            System.out.println("Intento de nuevo, no ingresó algo válido.\n");
          
        } catch (ArithmeticException e) {
            System.out.println("Cero es un denominador inválido. Intente de nuevo.\n");
        }
    } while (bandera);
        
    }


    public void verPedidos(ArrayList<Pedido> listaPedi) {

        System.out.println("----------------------------------------------------");
         double totalVentas=0;
        for (Pedido pedido : listaPedi) {
            System.out.println("ID del pedido: " + pedido.getId());
            System.out.println("Cliente :"+pedido.getNombrecliente());
         
            ArrayList<Productos> listaPedidos = pedido.getListaPedidos();
            for (Productos producto : listaPedidos) {
                if (producto instanceof Uniformes) {
                    Uniformes uniforme = (Uniformes) producto;
                    System.out.println("Producto: " + uniforme.getName());
                    System.out.println("Cantidad  :"+uniforme.getCantidad());
                    System.out.println("Color: " + uniforme.getColor());
                    System.out.println("Tipo: " + uniforme.getTipo());
                    System.out.println("Talla: " + uniforme.getTalla());
                    System.out.println("Género: " + uniforme.getSexo());
                    System.out.println("decoracion : "+uniforme.getDecoracion());
                } else if (producto instanceof Playeras) {
                    Playeras playera = (Playeras) producto;
                    System.out.println("Producto: " + playera.getName());
                    System.out.println("cantidad : "+playera.getCantidad());
                    System.out.println("Color: " + playera.getColor());
                    System.out.println("Talla: " + playera.getTalla());
                    System.out.println("Género: " + playera.getSexo());
                } else if (producto instanceof Pantalones) {
                    Pantalones pantalon = (Pantalones) producto;
                    System.out.println("Producto: " + pantalon.getName());
                    System.out.println("Cantidad : "+pantalon.getCantidad());
                    System.out.println("Color: " + pantalon.getColor());
                    System.out.println("Talla: " + pantalon.getTalla());
                    System.out.println("Género: " + pantalon.getSexo());
                }
            }
            double precioTotalPedido = pedido.getPrecioTotal(); 
            totalVentas += precioTotalPedido; 
            System.out.println(" Total $" + precioTotalPedido);
            System.out.println("----------------------------------------------------");
        }
        System.out.println("Total de ventas obtenido: $" + totalVentas);
        System.out.println("----------------------------------------------------");

       
    }

    public void modificarPedido(int idPedido, Inventario inventario, Uniformes uniformes, Pantalones pantalones, Playeras playeras) {
        boolean bandera = true;
        do {
            try {
                Pedido pedidoActual = null;
                int precioTotal;
                int cantidadUniformes=0 ;
                int cantidadPlayeras=0;
                int cantidadPantalones=0 ;
                int can =0;
                for (Pedido pedido : listaPedi) {
                    if (pedido.getId() == idPedido) {
                        pedidoActual = pedido;
                        precioTotal = pedidoActual.getPrecioTotal();
                        break;
                    }
                }
            
                if (pedidoActual == null) {
                    System.out.println("No se encontró ningún pedido con el ID especificado.");
                    return;
                }
                precioTotal = pedidoActual.getPrecioTotal();
        
                Scanner leer = new Scanner(System.in);
                int opc;
            
                do {
                 
                      do {
                        System.out.println("Opciones:");
                        System.out.println("1. Agregar producto");
                        System.out.println("2. Eliminar producto");
                        System.out.println("3. Regresar");
                        System.out.println("Ingrese su opción:");
                        opc = leer.nextInt();
                      } while (opc<1||opc>3);
                   
            
                    switch (opc) {
                        case 1:
            System.out.println("Seleccione el producto que desea agregar:");
            System.out.println("1. Uniformes");
            System.out.println("2. Playeras");
            System.out.println("3. Pantalones");
            System.out.println("Ingrese su opción:");
            int opcProducto = leer.nextInt();
            
            // Variables para almacenar el producto agregado
            Productos productoAgregado = null;
            int precioProducto = 0;
        
            switch (opcProducto) {
                case 1:
                int opc1;
                do {
                 System.out.println("Ingresa el tipo de uniforme\n1.Escolares\n2,Deportivos");
                  opc1=leer.nextInt();
                } while (opc1<1 || opc1 >2);
             
                if (opc1==1) {
                System.out.println("Ingrese la cantidad de uniformes a comprar.");
                    can=leer.nextInt();
                    cantidadUniformes = can;
        
                    int cantidadTelas = 0;
                    int cantidadBotones = 0;
                    int cantidadHilos = 0;
                    int cantidadCierres = 0;
        
                    for (Material material : inventario.getLisMaterial()) {
                     switch (material.getName().toLowerCase()) {
                         case "telas":
                             cantidadTelas = can * 60;
                             if (cantidadTelas > material.getCantidad()) {
                                 System.out.println("No hay suficiente cantidad de telas en el inventario.");
                                 return; 
                             }
                             break;
                         case "botones":
                             cantidadBotones = can * 4;
                             if (cantidadBotones > material.getCantidad()) {
                                 System.out.println("No hay suficiente cantidad de botones en el inventario.");
                                 return;
                             }
                             break;
                         case "hilos":
                             cantidadHilos = can * 20;
                             if (cantidadHilos > material.getCantidad()) {
                                 System.out.println("No hay suficiente cantidad de hilos en el inventario.");
                                 return;
                             }
                             break;
                         case "cierres":
                             cantidadCierres = can * 2;
                             if (cantidadCierres > material.getCantidad()) {
                                 System.out.println("No hay suficiente cantidad de cierres en el inventario.");
                                 return;
                             }
                             break;
                     }
                 }
        
                    for (Material materials : inventario.getLisMaterial()) {
                     switch (materials.getName().toLowerCase()) {
                         case "telas":
                             materials.setCantidad(materials.getCantidad() - cantidadTelas);
                             break;
                         case "botones":
                             materials.setCantidad(materials.getCantidad() - cantidadBotones);
                             break;
                         case "hilos":
                             materials.setCantidad(materials.getCantidad() - cantidadHilos);
                             break;
                         case "cierres":
                             materials.setCantidad(materials.getCantidad() - cantidadCierres);
                             break;
                     }
                 }
                   
                   String tipo ="  Escolares";
                   String name = "Uniforme";
                    int precio =200;
                    
                    precioTotal= precioTotal+can*precio;
                    String talla;
                   String color;
                   System.out.println("Ingrese la talla");
                   talla=leer.next();
                   leer.nextLine();
                   System.out.println("Ingrese el color del producto");
                   color =leer.nextLine();
                   System.out.println("Ingrese si seraMAsculino(M)/Femenino(F)");
                   String sexo = leer.nextLine();
                   uniformes.validacionProducto();
                   ;
                 
        
                 Uniformes unifor = new Uniformes();
                  unifor.setColor(color);
                  unifor.setPrecio(precio);
                  unifor.setTalla(talla);
                  unifor.setTipo(tipo);
                  unifor.setName(name);
                  unifor.setSexo(sexo);
                  unifor.setCantidad(can);
        
                  pedidoActual.getListaPedidos().add(unifor);
                  leer.nextLine();
             
             }
                if (opc1==2) {
        
                    System.out.println("Ingrese la cantidad a comprar.");
                     can=leer.nextInt();
                     cantidadUniformes = can;
        
        
                    int cantidadTelas = 0;
                    int cantidadBotones = 0;
                    int cantidadHilos = 0;
                    int cantidadCierres = 0;
        
                    for (Material material : inventario.getLisMaterial()) {
                     switch (material.getName().toLowerCase()) {
                         case "telas":
                             cantidadTelas = can * 60;
                             if (cantidadTelas > material.getCantidad()) {
                                 System.out.println("No hay suficiente cantidad de telas en el inventario.");
                                 return; 
                             }
                             break;
                         case "botones":
                             cantidadBotones = can * 4;
                             if (cantidadBotones > material.getCantidad()) {
                                 System.out.println("No hay suficiente cantidad de botones en el inventario.");
                                 return; 
                             }
                             break;
                         case "hilos":
                             cantidadHilos = can * 20;
                             if (cantidadHilos > material.getCantidad()) {
                                 System.out.println("No hay suficiente cantidad de hilos en el inventario.");
                                 return; 
                             }
                             break;
                         case "cierres":
                             cantidadCierres = can * 2;
                             if (cantidadCierres > material.getCantidad()) {
                                 System.out.println("No hay suficiente cantidad de cierres en el inventario.");
                                 return; 
                             }
                             break;
                     }
                 }
        
                    for (Material material : inventario.getLisMaterial()) {
                     switch (material.getName().toLowerCase()) {
                         case "telas":
                             material.setCantidad(material.getCantidad() - cantidadTelas);
                             break;
                         case "botones":
                             material.setCantidad(material.getCantidad() - cantidadBotones);
                             break;
                         case "hilos":
                             material.setCantidad(material.getCantidad() - cantidadHilos);
                             break;
                         case "cierres":
                             material.setCantidad(material.getCantidad() - cantidadCierres);
                             break;
                     }
                 }
                    String tipo =" Deportivos ";
                    String name = "Uniforme";
                    int precio =200;
                 
                    precioTotal= precioTotal+can*precio;
                   String talla;
                   String color;
                   System.out.println("Ingrese la talla");
                   talla=leer.next();
                   leer.nextLine();
                   System.out.println("Ingrese el color de su producto");
                   color =leer.nextLine();
                   System.out.println("Ingrese si sera Masculino(M)/Femenino(F)");
                   String sexo = leer.nextLine();
                   uniformes.validacionProducto();
                 
                  
        
                 Uniformes unifor = new Uniformes();
                  unifor.setColor(color);
                  unifor.setPrecio(precio);
                  unifor.setTalla(talla);
                  unifor.setTipo(tipo);
                  unifor.setName(name);
                  unifor.setSexo(sexo);
                  unifor.setCantidad(can);
        
                  pedidoActual.getListaPedidos().add(unifor);
                  leer.nextLine();
                }
                pedidoActual.setPrecioTotal(precioTotal);
                break;
                case 2:
                    // Lógica para agregar playeras (similar al caso de uniformes)
                    System.out.println("Ingrese la cantidad de playeras a comprar.");
                               can=leer.nextInt();
        
        
                               int cantidadTelas = 0;
                               int cantidadBotones = 0;
                               int cantidadHilos = 0;
                               int cantidadCierres = 0;
        
                               for (Material material : inventario.getLisMaterial()) {
                                switch (material.getName().toLowerCase()) {
                                    case "telas":
                                        cantidadTelas = can * 30;
                                        if (cantidadTelas > material.getCantidad()) {
                                            System.out.println("No hay suficiente cantidad de telas en el inventario.");
                                            return;
                                        }
                                        break;
                                    case "botones":
                                        cantidadBotones = can * 2;
                                        if (cantidadBotones > material.getCantidad()) {
                                            System.out.println("No hay suficiente cantidad de botones en el inventario.");
                                            return; 
                                        }
                                        break;
                                    case "hilos":
                                        cantidadHilos = can * 10;
                                        if (cantidadHilos > material.getCantidad()) {
                                            System.out.println("No hay suficiente cantidad de hilos en el inventario.");
                                            return;
                                        }
                                        break;
                                    case "cierres":
                                        cantidadCierres = can * 0;
                                        if (cantidadCierres > material.getCantidad()) {
                                            System.out.println("No hay suficiente cantidad de cierres en el inventario.");
                                            return;
                                        }
                                        break;
                                }
                            }
        
                               for (Material material : inventario.getLisMaterial()) {
                                switch (material.getName().toLowerCase()) {
                                    case "telas":
                                        material.setCantidad(material.getCantidad() - cantidadTelas);
                                        break;
                                    case "botones":
                                        material.setCantidad(material.getCantidad() - cantidadBotones);
                                        break;
                                    case "hilos":
                                        material.setCantidad(material.getCantidad() - cantidadHilos);
                                        break;
                                    case "cierres":
                                        material.setCantidad(material.getCantidad() - cantidadCierres);
                                        break;
                                }
                            }
                               int precio =250;
                             
                               precioTotal= precioTotal+can*precio;
                               String talla;
                              String color;
                              String name ="Playeras";
                              System.out.println("Ingrese la talla");
                              talla=leer.next();
                              leer.nextLine();
                              System.out.println("Ingrese el color de su producto");
                              color =leer.nextLine();
                              System.out.println("Ingrese si sera Masculino(M)/Femenino(F)");
                              String sexo = leer.nextLine();
                             playeras.validacionProducto();
                           ;
                             
           
                            Playeras playera = new Playeras();
                             playera.setColor(color);
                             playera.setPrecio(precio);
                             playera.setTalla(talla);
                             playera.setName(name);
                             playera.setSexo(sexo);
                             playera.setCantidad(can);
                             pedidoActual.getListaPedidos().add(playera);
                             leer.nextLine();
                              cantidadPlayeras = can;
                             
                            pedidoActual.setPrecioTotal(precioTotal);
                    break;
                case 3:
                    System.out.println("Ingrese la cantidad de playeras a comprar.");
                    can=leer.nextInt();
        
                
                   int cantidadTelas2 = 0;
                   int cantidadBotones2 = 0;
                   int cantidadHilos2 = 0;
                   int cantidadCierres2 = 0;
        
                   for (Material material : inventario.getLisMaterial()) {
                    switch (material.getName().toLowerCase()) {
                        case "telas":
                            cantidadTelas2 = can * 30;
                            if (cantidadTelas2 > material.getCantidad()) {
                                System.out.println("No hay suficiente cantidad de telas en el inventario.");
                                return; 
                            }
                            break;
                        case "botones":
                            cantidadBotones2 = can * 2;
                            if (cantidadBotones2 > material.getCantidad()) {
                                System.out.println("No hay suficiente cantidad de botones en el inventario.");
                                return; 
                            }
                            break;
                        case "hilos":
                            cantidadHilos2 = can * 15;
                            if (cantidadHilos2 > material.getCantidad()) {
                                System.out.println("No hay suficiente cantidad de hilos en el inventario.");
                                return; 
                            }
                            break;
                        case "cierres":
                            cantidadCierres2 = can * 1;
                            if (cantidadCierres2 > material.getCantidad()) {
                                System.out.println("No hay suficiente cantidad de cierres en el inventario.");
                                return;
                            }
                            break;
                    }
                }
        
                   for (Material material : inventario.getLisMaterial()) {
                    switch (material.getName().toLowerCase()) {
                        case "telas":
                            material.setCantidad(material.getCantidad() - cantidadTelas2);
                            break;
                        case "botones":
                            material.setCantidad(material.getCantidad() - cantidadBotones2);
                            break;
                        case "hilos":
                            material.setCantidad(material.getCantidad() - cantidadHilos2);
                            break;
                        case "cierres":
                            material.setCantidad(material.getCantidad() - cantidadCierres2);
                            break;
                    }
                }
        
                   int precio2 =150;
        
                   precioTotal= precioTotal+can*precio2;
                   String talla2;
                  String color2;
                  String name2= "Pantalones ";
                  System.out.println("Ingrese la talla");
                  talla2=leer.next();
                  leer.nextLine();
                  System.out.println("Ingrese el color de su producto");
                  color2 =leer.nextLine();
                  System.out.println("Ingrese si sera Masculino(M)/Femenino(F)");
                  String sexo2 = leer.nextLine();
                  pantalones.validacionProducto();
               
        
                Pantalones pantalon = new Pantalones();
                 pantalon.setColor(color2);
                 pantalon.setPrecio(precio2);
                 pantalon.setTalla(talla2);
                 pantalon.setName(name2);
                 pantalon.setSexo(sexo2);
                 pantalon.setCantidad(can);
                 pedidoActual.getListaPedidos().add(pantalon);
                leer.nextLine();
                cantidadPantalones = can;
              
                pedidoActual.setPrecioTotal(precioTotal);

                    break;
                   
                 default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
             }
           
             break;
        
        
             case 2:
             System.out.println("Productos en el pedido:");
          ArrayList<Productos> listaPedidos = pedidoActual.getListaPedidos();
           for (int i = 0; i < listaPedidos.size(); i++) {
        System.out.println((i + 1) + ") " + listaPedidos.get(i).getName());
          }
              System.out.println("Ingrese el número del producto que desea eliminar:");
               int numProductoEliminar = leer.nextInt();

                 if (numProductoEliminar < 1 || numProductoEliminar > listaPedidos.size()) {
              System.out.println("Número de producto inválido. Por favor, seleccione un número válido.");
                break;
              }

              Productos productoEliminar = listaPedidos.remove(numProductoEliminar - 1);
              System.out.println("Se ha eliminado el producto '" + productoEliminar.getName() + "' del pedido.");

                    int precioProductoEliminado = productoEliminar.getPrecio() * productoEliminar.getCantidad();
             int precioTotalActualizado = pedidoActual.getPrecioTotal() - precioProductoEliminado;
              pedidoActual.setPrecioTotal(precioTotalActualizado);
               break;
         
                        case 3:
                            System.out.println("Saliendo...");
                            break;
                        default:
                            System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                            break;
                    }
                } while (opc != 3);
                int cantidad = can;
                
                System.out.println("Detalles del pedido:");
            ArrayList<Productos> listaPedidos = pedidoActual.getListaPedidos();
            for (Productos producto : listaPedidos) {
                    if (producto instanceof Uniformes) {
                        Uniformes uniforme = (Uniformes) producto;
                        System.out.println("Producto: " + uniforme.getName());
                        System.out.println("Cantidad: " + uniforme.getCantidad());
                        System.out.println("Color: " + uniforme.getColor());
                        System.out.println("Tipo: " + uniforme.getTipo());
                        System.out.println("Talla: " + uniforme.getTalla());
                        System.out.println("Género: " + uniforme.getSexo());
                    
                    } else if (producto instanceof Playeras) {
                        Playeras playera = (Playeras) producto;
                        System.out.println("Producto: " + playera.getName());
                        System.out.println("Cantidad: " + playera.getCantidad());
                        System.out.println("Color: " + playera.getColor());
                        System.out.println("Talla: " + playera.getTalla());
                        System.out.println("Género: " + playera.getSexo());
                       
                    } else if (producto instanceof Pantalones) {
                        Pantalones pantalon = (Pantalones) producto;
                        System.out.println("Producto: " + pantalon.getName());
                        System.out.println("Cantidad: " + pantalon.getCantidad());
                        System.out.println("Color: " + pantalon.getColor());
                        System.out.println("Talla: " + pantalon.getTalla());
                        System.out.println("Género: " + pantalon.getSexo());
                    }
                }
              
            
                bandera = false;
            } catch (InputMismatchException e) {
                System.out.println("Intento de nuevo, no ingresó algo válido.\n");
              
            } catch (ArithmeticException e) {
                System.out.println("Cero es un denominador inválido. Intente de nuevo.\n");
            }
        } while (bandera);
       

    }
    }
    
        //CORRGIR COMO SE PASA LOS PARAMETROS NUEVOS 
        

