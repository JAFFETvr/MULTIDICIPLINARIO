import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Inventario {
    private ArrayList<Material> lisMaterial = new ArrayList<>();
    Scanner leer = new Scanner(System.in);
    
    public Inventario () {
        inicializarInventario();
    }

    public void setLisMaterial(ArrayList<Material> lisMaterial) {
        this.lisMaterial = lisMaterial;
    }

    public ArrayList<Material> getLisMaterial() {
        return lisMaterial;
    }

    public void inicializarInventario() {
        lisMaterial.add(new Material("telas", 0));
        lisMaterial.add(new Material("hilos", 0));
        lisMaterial.add(new Material("botones", 0));
        lisMaterial.add(new Material("cierres", 0));
    }

public void agregarInventario(Scanner leer2) throws InputMismatchException{
    
            int opcion=0;
    int tipoMaterial;
    do {
        do {
            System.out.println("Ingrese el tipo de material que desea agregar: ");
        System.out.println("1. Telas");
        System.out.println("2. Hilos");
        System.out.println("3. Botones");
        System.out.println("4. Cierres");
         tipoMaterial = leer2.nextInt();

        } while (tipoMaterial < 1 || tipoMaterial > 4);
        

        String nombreMaterial = "";
        switch (tipoMaterial) {
            case 1:
                nombreMaterial = "telas";
                break;
            case 2:
                nombreMaterial = "hilos";
                break;
            case 3:
                nombreMaterial = "botones";
                break;
            case 4:
                nombreMaterial = "cierres";
                break;
            default:
                System.out.println("Opción no válida");
                
        }

        int cantidad;
        do {
            System.out.println("Ingrese la cantidad a agregar:");
            cantidad = leer2.nextInt();
        } while (cantidad <= 0);

        boolean encontrado = false;
        for (Material material : lisMaterial) {
            if (material.getName().equalsIgnoreCase(nombreMaterial)) {
                encontrado = true;
                material.setCantidad(material.getCantidad() + cantidad);
                System.out.println("Cantidad actualizada exitosamente.");
                break;
            }
        }
        if (!encontrado) {
            Material nuevoMaterial = new Material(nombreMaterial, cantidad);
            nuevoMaterial.setName(nombreMaterial);
            nuevoMaterial.setCantidad(cantidad);
            lisMaterial.add(nuevoMaterial);
            System.out.println("Material agregado al inventario.");
        }

        System.out.println("¿Desea agregar otro material? (1: Sí, 2: No)");
        opcion = leer.nextInt();
    } while (opcion == 1);
          
    
}



public void eliminarInventario()throws InputMismatchException {

    boolean bandera = true;
    do {
        try {
            System.out.println("Ingrese el nombre del material que desea modificar:");
            String nombreMaterial = leer.next();
            int opcion;
            boolean encontrado = false;
            for (int i = 0; i < lisMaterial.size(); i++) {
                Material material = lisMaterial.get(i);
                if (material.getName().equalsIgnoreCase(nombreMaterial)) {
                    encontrado = true;
                    System.out.println("Material encontrado. Cantidad actual : " + material.getCantidad());
                    do {
                        System.out.println("¿Qué acción desea realizar?");
                        System.out.println("1. Disminuir cantidad");
                        System.out.println("2. Eliminar todo el material");
                         opcion = leer.nextInt();
                    } while (opcion <1 || opcion >2);
                
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese la cantidad que desea disminuir:");
                            int cantidadDisminuir = leer.nextInt();
                            if (cantidadDisminuir > material.getCantidad()) {
                                System.out.println("La cantidad a disminuir es mayor que la cantidad actual del material. No se puede realizar la operación.");
                            } else {
                                material.setCantidad(material.getCantidad() - cantidadDisminuir);
                                System.out.println("Cantidad disminuida exitosamente.");
                            }
                            break;
                        case 2:
                           material.setCantidad(0);
                            System.out.println("Material eliminado completamente del inventario.");
                            i--; // Disminuir el índice para compensar la eliminación
                            break;
                        default:
                            System.out.println("Opción no válida.");
                            break;
                    }
                    break;
                }
            }
            
            if (!encontrado) {
                System.out.println("El material especificado no se encontró en el inventario.");
            }
            bandera = false;
        } catch (InputMismatchException e) {
            System.out.println("Intento de nuevo, no ingresó algo válido.\n");
          
        } catch (ArithmeticException e) {
            System.out.println("Cero es un denominador inválido. Intente de nuevo.\n");
        }
    } while (bandera);
   
    
    
}

public void imprimirInventario()throws InputMismatchException {
    System.out.println("Inventario:");
    for (int i = 0; i < lisMaterial.size(); i++) {
        Material material = lisMaterial.get(i);
        System.out.println("Nombre: " + material.getName() + ", Cantidad: " + material.getCantidad() );
        
    }
}
    
}