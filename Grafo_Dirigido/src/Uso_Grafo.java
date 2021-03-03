import java.util.*;

public class Uso_Grafo {
    
    public static void main(String[] args) {
        
        System.out.println("\n ------------GRAFOS POR LISTAS DE ADYACENIA------------\n\tIndique si hay camino con 0 o 1\n");

        Scanner lee= new Scanner(System.in);
        System.out.println("Numero de nodos del grafo?");
        int n=lee.nextInt();
        Grafo_Dirigido g = new Grafo_Dirigido(n);
        g.creaGrafo();
        g.muestraAdy();

        System.out.println("\n ===========NODOS ADYACENTES=============\n");
        for(int i=0;i<g.tam;i++) {
           g.todosAdy(i);
           System.out.print("\n");
        }
    }
}
