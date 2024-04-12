import java.util.InputMismatchException;
import java.util.Scanner;

public class Pantalones extends Productos {
    Scanner leer = new Scanner(System.in);
    private String detalles;
    public Pantalones (){}

    

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getDetalles() {
        return detalles;
    }
    public void validacionProducto()throws InputMismatchException {
        int producto;
        do{

            System.out.println("Quisieras que tu pantalon tuviera algun modelo o detalles extras en tu pantalon  1)Si  2)No");
             producto = leer.nextInt();
        } while(producto<1 || producto>2);

        if(producto==1){
            System.out.println("Ingresa el detalle o modelo especial");
             setDetalles(leer.next());
            leer.nextLine();
        }

        System.out.println("el detalle del pedido es de" + getDetalles());

           
        

    }
}
