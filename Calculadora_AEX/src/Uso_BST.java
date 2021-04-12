
public class Uso_BST {
    
    public static void main(String[] args) {
        
        A_EXP bst = new A_EXP(); 

        String cadena= "((4+5)*((8.332/2)-2.23))";
        //String cadena= "(((4+5)*(3+3))*(3-1))";

        for (Object obj : A_EXP.convertir(cadena)) 
            bst.insertar(obj);
        
        bst.enOrden();
        System.out.println("\n");
        bst.postOrden();
        

        System.out.println("\n\nEl resultado es: "+bst.evaluar(bst.raiz()));

    }



}
