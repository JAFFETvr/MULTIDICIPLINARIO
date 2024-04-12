import java.util.InputMismatchException;
import java.util.Scanner;

public class Uniformes extends Productos {
    private String decoracion;
    private String tipo;
    public Uniformes (){}

    Scanner leer = new Scanner(System.in);
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }

    public void setDecoracion(String decoracion) {
        this.decoracion = decoracion;
    }

    public String getDecoracion() {
        return decoracion;
    }



    public void  validacionProducto()throws InputMismatchException{
        
        int opc;
        int decor;
        do{
            System.out.println("llevara algun tipo de accesorios especial 1)si  2)no");
            opc = leer.nextInt();
            
            if (opc == 1) {
                do{

                    System.out.println("Ingresa el tipo accesorio 1)logotipo personalizado  2)bolsas extras en el pantalo o pans");
                    decor = leer.nextInt();
                    leer.nextLine(); 
            
                    if(decor == 1){
                        System.out.println("De qué será su logo personalizado");
                        setDecoracion(leer.nextLine());
                    }
            
                    if(decor == 2){
                        System.out.println("Ingrese cuántas bolsas extras quiere y en qué parte del uniforme:");
                        setDecoracion(leer.nextLine());
                    }

                    System.out.println("el resultado es" + getDecoracion());
                }while(decor<=0 || decor>=3);
            }
        }while(opc<=0);


    }
    }

