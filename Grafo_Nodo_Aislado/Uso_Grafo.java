public class Uso_Grafo {
    
   public static void main(String[] args )  {
     
      String[][] datos;
      int i;
      Grafo_Dirigido digrafo= new Grafo_Dirigido();
      
      try {
         Lee_Grafo archgrafo= new Lee_Grafo(args[0]);
         datos=archgrafo.lee_arch();

         if (archgrafo.formato_valido()) {

            int n=digrafo.tam_matriz(datos);
            digrafo.crea_mat_ady(n,datos);
            digrafo.crea_mat_costos(n,datos);
            
            System.out.println("Matriz de Adyacencia: \n");            
            digrafo.imprime_matriz(digrafo.mat_ady);

            System.out.println("Matriz de Costos: \n");
            digrafo.imprime_matriz(digrafo.mat_costos);
            
            for (i=0; i<n; i++)
               digrafo.encuentra_vertices_adyacentes(i);   
         }
         
         else System.out.println("ERROR: El archivo no contiene un formato valido");
         } catch (Exception e) {System.err.println("Falta nombre de archivo correcto");}
   }
      
}
