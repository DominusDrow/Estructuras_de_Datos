

public class Uso_BST {
    
    public static void main(String[] args) {
        
        ABST bst = new ABST();

        //String cadena= "((4+5)*((8/2)-2))";
        String cadena= "(((4+5)*(3+3))*(3-1))";

        for (int i = 0; i < cadena.length(); i++){
            bst.insertar(cadena.charAt(i));
        }
            
        
      
        bst.enOrden();
        System.out.println("\n");
        bst.postOrden();
        

        System.out.println("\n\nEl resultado es: "+bst.evaluar(bst.raiz()));

    }



}
