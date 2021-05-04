import java.util.Scanner;

public class Uso_BST {
    
    public static void main(String[] args)   {
          
        ABST bst = new ABST();
        
        System.out.print("\t\t====ARBOL ABB====\n\nIngrese una cadena:  ");
    
        for (String obj : cls(new Scanner(System.in).nextLine())) 
            bst.insertar(obj);
        
        System.out.print("\nPalabra     Frecuencia\n");
        bst.enOrden();
    }

    public static String [] cls(String cad){
        String aux="";

        for (char i : cad.toCharArray()) 
            if(i!='.' && i!=',' && i!=':' && i!=';' && i!='"' && i!='!' && i!='?')
                aux=aux+i;
        
        return aux.split(" ");
    }
}
