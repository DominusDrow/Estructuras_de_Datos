import java.util.Arrays;

public class Uso_BST {
    
    public static void main(String[] args) {
        


        ABST bst = new ABST();

        Arrays.asList(1,9,40,3,8,4,10,6,7,30,12,15,20,5).forEach(bst::insertar);
        
        bst.preOrden();
        System.out.println("\n");
        bst.enOrden();
        localizar(bst, 3);

        System.out.println("\nla altura del nodo es: "+bst.alturaNodo(1));

        System.out.println("\nla profundidad del nodo es: "+bst.profundidadNodo(1));

        System.out.println("\nlas hojas del nodo es: "+bst.NumeroHojas(bst.raiz()));




    }

    public static void localizar(ABST bst, int id){

        if(bst.existe(id))
            System.out.println("\n"+bst.obtener(id));
        else 
            System.out.println("\nEl valor no existe ");
    }
}
