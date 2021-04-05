import java.util.Arrays;

public class Uso_BST {
    
    public static void main(String[] args) {
        


        ABST bst = new ABST();

        Arrays.asList(3,4,5,2,1,6,8).forEach(bst::insertar);
        
        bst.preOrden();
        System.out.println("\n");
        bst.enOrden();
        localizar(bst, 3);

        System.out.println("\nla altura del nodo es: "+bst.alturaNodo(4));

        System.out.println("\nla profundidad del nodo es: "+bst.profundidadNodo(8));

        System.out.println("\nlas hojas del nodo es: "+bst.NumeroHojas(3));

    }

    public static void localizar(ABST bst, int id){

        if(bst.existe(id))
            System.out.println("\n"+bst.obtener(id));
        else 
            System.out.println("\nEl valor no existe ");
    }
}
