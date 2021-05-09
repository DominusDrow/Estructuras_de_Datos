import java.util.Scanner;
import java.util.StringTokenizer;

public class Uso_BST {
    
    public static void main(String[] args)   {
          
        ABST bst= new ABST();

        System.out.print("\t\t======Arbol ABB de palabras=======\n\nIngrese una cadena:  ");
        
        StringTokenizer st;
        st = new StringTokenizer(new Scanner(System.in).nextLine(),",//.//;// //><//'//://¿//?//!//¡//\"//(//)//"); 
        
        while(st.hasMoreTokens())
           bst.insertar(st.nextToken());
       
        System.out.print("\nPalabra     Frecuencia\n");
        bst.enOrden();
    }

    
}
