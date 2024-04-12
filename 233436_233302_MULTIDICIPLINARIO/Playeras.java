import java.util.InputMismatchException;
import java.util.Scanner;

public class Playeras extends Productos{
    Scanner leer = new Scanner(System.in);
    private String decoracion;
    public Playeras(){

    }

    public void setDecoracion(String decoracion) {
        this.decoracion = decoracion;
    }

    public String getDecoracion() {
        return decoracion;
    }

    public void validacionProducto()throws InputMismatchException{
        int opc;
        String  decoracion;
        do{

            System.out.println("Sera personalizada 1)Si  2)No");
            opc = leer.nextInt();
            
            if (opc ==1) {
                System.out.println("Que tipo de personalizacion sera? ");
                setDecoracion(leer.next());
                leer.nextLine();

                System.out.println("tu decoracion es " + getDecoracion());
                
                

                
            }
        }while(opc <=0 || opc>=3);

    }
}
