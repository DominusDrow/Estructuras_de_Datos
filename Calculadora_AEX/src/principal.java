import java.util.ArrayList;
import java.util.Scanner;

public class principal {
    
    public static void main(String[] args) {
        
        Scanner en = new Scanner(System.in);
        A_EXP bst = new A_EXP(); 
        String cadena;

        System.out.print("\nIngrese la expresion a calcular:  ");
        cadena=en.nextLine();
        
        //Arrays.asList(1,9,40,3,8,4,10,6,7,30,12,15,20,5).forEach(bst::insertar);
        
        String excepcion=Pila_Signos.comprobarExp(cadena);

        System.out.println("\n\n"+excepcion+"\n");

        if(excepcion=="Todos los simbolos estan bien balanceados"){
                   
            A_EXP.convertir(cadena).forEach(bst::insertar);
            
            bst.enOrden();
            System.out.println("\n");
            bst.postOrden();

            System.out.println("\n\nEl resultado es: "+bst.evaluar(bst.raiz()));
        }
        
    }



}
