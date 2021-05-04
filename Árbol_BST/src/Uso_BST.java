import java.util.Scanner;

public class Uso_BST {
    
    public static void main(String[] args)   {
        
        ABST bst = new ABST();
        String [] cad=null;
        
        System.out.print("\t\t====ARBOL ABB====\n\nIngrese los datos que tendra el arbol:  ");
        cad=new Scanner(System.in).nextLine().split(",");

        for (String obj : cad) 
            bst.insertar(Integer.parseInt(obj));
        
        System.out.print("\nRecorrido en preorden:  ");
        bst.preOrden();
        System.out.print("\n\nRecorrido en enorden:   ");
        bst.enOrden();
        System.out.print("\n\nRecorrido en postorden: ");
        bst.postOrden();
        
    
    }

   
}
