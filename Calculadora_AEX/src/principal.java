
public class principal {
    
    public static void main(String[] args) {
        
        A_EXP bst = new A_EXP(); 

        //String cadena= "(((-4+5)*((8.3/2)-2.23))+(2^2.2))";
        //String cadena= "{((4+5)*(3+3))*(3-1)}";
        String cadena= "((-4)-3)";
      
        String excepcion=Pila_Signos.comprobarExp(cadena);

        System.out.println(excepcion+"\n");

        if(excepcion=="Todos los simbolos estan bien balanceados"){
            
            for (Object obj : A_EXP.convertir(cadena)) 
                bst.insertar(obj);
            
            bst.enOrden();
            System.out.println("\n");
            bst.postOrden();

            System.out.println("\n\nEl resultado es: "+bst.evaluar(bst.raiz()));
        }
        
    }



}