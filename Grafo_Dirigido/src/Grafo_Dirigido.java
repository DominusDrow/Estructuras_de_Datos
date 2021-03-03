import java.util.Scanner;

public class Grafo_Dirigido {
    
    final int INFINITO=10000000;
    private Lista_Enlazada [] ady; //vector de listas de adyacencia
    public int tam; //tamaño del arreglo de listas
    Scanner lee;

    public Grafo_Dirigido(int tam){
        this.tam=tam;
        ady= new Lista_Enlazada [tam];
        lee=new Scanner(System.in); 
    }

    public void creaGrafo(){
        int num,costo;

        for(int i=0; i<tam; i++){
            ady[i] = new Lista_Enlazada(i);
        }

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.println("¿Hay camino de "+i+" a "+j+"?");
                num=lee.nextInt();

                if(num!=0){
                    System.out.println("Costo de "+i+" a "+j+":");
                    costo=lee.nextInt();
                    ady[i].InsertarFinal(j, costo);
                }
            }
        }
    }

    public void muestraAdy() {

     System.out.println("\n ===========LISTA DE ADYACENCIA=============\n");
     for(int i=0;i<tam;i++) {
        System.out.print(ady[i].getVertice()+": ");
     	ady[i].mostrar();
        System.out.print("\n");
       }
    }

    public int primero(int vertice){
        
        if(ady[vertice].vacia())
            return (Integer) null;
        
        else
           return (Integer) ady[vertice].obtener(0);
        
    }

    public int sigueinte(int vertice, int adyPrevio){

        return (Integer) ady[vertice].obtener(adyPrevio+1);
    }

    public void todosAdy(int vertice){

        System.out.print("Nodos adyacentes a "+(vertice)+":");
        int i=0;
        while(ady[vertice].obtener(i) != null){
            System.out.print("  "+ady[vertice].obtener(i)+" -->");
            i++;
        }
        System.out.print("  null\n");
    } 
}

