import java.util.*;

public class Grafo_Dirigido {

   private Vector<Object> vertices=new Vector<Object>();
   public final int INFINITO=10000;
   private int[][] mat_ady;
   private int[][] mat_costos;
   private int[] costos_minimos;
   private int[][] arbolPrim;
   private int[] p;
   Vector<Object> s= new Vector<Object>();
   ArrayList<Vertice> T=new ArrayList<Vertice>();
 
   public int tam_matriz(String[][] datos) {
      Integer num;
      for (int i=0; i<datos.length; i++) {
          for (int j=0; j<datos[i].length-1; j++) {
              num= Integer.parseInt(datos[i][j]);
              if (vertices.indexOf(num)==-1)
                 vertices.addElement(num);
             }
      }
      vertices.trimToSize();   
      return vertices.capacity();
   }
  	
  	public void crea_mat_ady(int tam,String[][] datos) {
      mat_ady= new int[tam][tam];
      arbolPrim=new int[tam][tam];
      
      for(int k=0; k<tam; k++)
         for (int l=0; l<tam; l++)
            mat_ady[k][l]=0;
            
      for (int i=0; i<datos.length; i++)
         mat_ady[Integer.parseInt(datos[i][0])][Integer.parseInt(datos[i][1])]=1;
      

      for(int i=0;i<tam;i++)
         for (int j=0;j<tam;j++)
            arbolPrim[i][j]=INFINITO;
  	}

   public void crea_mat_ady(int tam,int[][] datos) {
      mat_ady= new int[tam][tam];
      
      for(int k=0; k<tam; k++)
         for (int l=0; l<tam; l++)
            mat_ady[k][l]=datos[k][l];
  	}
  	
  	public void crea_mat_costos(int tam,String[][] datos) {
      mat_costos= new int[tam][tam];
   
      for(int k=0; k<tam; k++)
         for (int l=0; l<tam; l++)
            mat_costos[k][l]=10000;
   
      for (int i=0; i<datos.length; i++)
         mat_costos[Integer.parseInt(datos[i][0])][Integer.parseInt(datos[i][1])]= Integer.parseInt(datos[i][2]);	
  	}

   public void muestraCostos() {
      System.out.println("\n        ==============MATRIZ DE COSTOS==============");
      for(int i=0;i<mat_costos.length;i++) {
         for(int j=0;j<mat_costos.length;j++) 
               System.out.print("\t"+mat_costos[i][j]); 	
            
         System.out.print("\n");
      }
   }

   public void muestraAdy() {
      System.out.println("\n        ===========MATRIZ DE ADYACENCIA=============");
      for(int i=0;i<mat_ady.length;i++) {
         for(int j=0;j<mat_ady.length;j++)
            System.out.print("\t"+mat_ady[i][j]); 	
            
         System.out.print("\n");
      }
   }

   public void lista_adyacentes(int v) {
      int i=primero(v);
      System.out.print(" "+(v+1)+" --> ");
      
      do {
      System.out.print("|V:"+(i+1)+" C:"+mat_costos[v][i]+"| --> ");
      i=siguiente(v,i);
      }while(i!=-1);

      System.out.print(" null\n\n");   
   }

   public void DFS (int vertice){

      int [][] aux = new int[mat_ady.length][mat_ady.length];
      int ant=0,ver=vertice;

      for(int k=0; k<mat_ady.length; k++)
         for (int l=0; l<mat_ady.length; l++)
            aux[k][l]=mat_ady[k][l];
      
      System.out.print("\nRecorrido a lo profundo: ");  
      while (ver!=-1) {
         
         System.out.print((ver+1)+",  ");

         for (int i = 0; i < mat_ady.length; i++) 
            mat_ady[i][ver]=0;
         
         mat_ady[ant][ver]=0;
         ant=ver;  
         ver= primero(ver); 

      }
      crea_mat_ady(mat_ady.length, aux);
   }

   public void BFS (int vertice){

      int [][] aux = new int[mat_ady.length][mat_ady.length];
      int pre=0,ant=0,ver=vertice;

      for(int k=0; k<mat_ady.length; k++)
         for (int l=0; l<mat_ady.length; l++)
            aux[k][l]=mat_ady[k][l];

      System.out.print("\n\nRecorrido a lo ancho: ");  
      while (ver!=-1) {
         
         if(ver==vertice)
            ant=ver;
         else
            ant=siguiente(ver,0);
         
         pre=ver;
         ver=siguiente(ver,0); 
         
         while(ant!=-1){
            System.out.print((ant+1)+",  ");
            
            for (int i = 0; i < mat_ady.length; i++) 
               mat_ady[i][ant]=0;
            
            ant=siguiente(pre, ant);
            
         }
         
      }
      
      crea_mat_ady(mat_ady.length, aux);
   }


   public int primero(int v) {
      int v_ady=-1;
      
      for (int i=0;i<mat_ady.length; i++) {
         if (mat_ady[v][i]==1) {
            v_ady=i;
            break;
         }	
      }
      return v_ady;  
   }

   public int siguiente(int v, int i) {
      int v_sig=-1;
         for (int j=i+1; j<mat_ady.length; j++) {
            if (mat_ady[v][j]==1) {
               v_sig=j;
               break;
            } 
         }
      return v_sig;
   }



   public void dijkstra() {
      
      costos_minimos= new int[mat_costos.length];
      p= new int[mat_costos.length];
         
      int min,ind,w;
      
      s.addElement(0);
      vertices.removeElementAt(0);
      vertices.trimToSize();
      for (int i=1; i<mat_costos.length; i++)
         costos_minimos[i]=mat_costos[0][i];
      
      for(int m=1; m<p.length;m++)
         p[m]=0;
      
      for (int j=0; j<mat_costos.length-1; j++) {
         ind=0;
         min=costos_minimos[((Integer)vertices.elementAt(0)).intValue()];
         w=((Integer)vertices.elementAt(0)).intValue();
         for (int k=1; k<vertices.size(); k++)
            {
               if (min>costos_minimos[((Integer)vertices.elementAt(k)).intValue()])
                  {
                  min=costos_minimos[((Integer)vertices.elementAt(k)).intValue()];
                  ind=k;
                  w=((Integer)vertices.elementAt(k)).intValue();
                  }
            }
         vertices.removeElementAt(ind);
         vertices.trimToSize();
         s.addElement(0);
         s.trimToSize();
         
         for (int l=0; l<vertices.size(); l++) {
            if (costos_minimos[((Integer)vertices.elementAt(l)).intValue()]> costos_minimos[w]+mat_costos[w][((Integer)vertices.elementAt(l)).intValue()]) {
               costos_minimos[((Integer)vertices.elementAt(l)).intValue()]=costos_minimos[w]+mat_costos[w][((Integer)vertices.elementAt(l)).intValue()];
               p[((Integer)vertices.elementAt(l)).intValue()]=w; 
               }
            } 
         }
   }

public void recorre(int destino) {
   Vector<Object> recorrido=new Vector<Object>();
         
    System.out.print("\nCamino mas corto entre el nodo 1 y el nodo "+ (destino+1)+": ");
    if ((destino!=0) && (costos_minimos[destino]!=10000)) {
       do {
          recorrido.insertElementAt(destino,0);
          destino=p[destino];    
          }while(destino!=0);
          
          recorrido.insertElementAt(0 ,0);
          
          for (int t=0; t<recorrido.size(); t++)
             System.out.print((Integer)(recorrido.elementAt(t))+1+" -> ");
          System.out.print("\n");   
      }else System.out.println("No existe");
   }


   public void prim() {
      int u,uMin=0,v,vMin=0,min=INFINITO;
      ArrayList<Integer> U = new ArrayList<Integer>();
      ArrayList<Integer> V = new ArrayList<Integer>();
      ArrayList<Integer> VmenosU = new ArrayList<Integer>();
      
      
      for(int i=0;i<mat_ady.length;i++) {
         if (i==0)
            U.add(i+1);
         V.add(i+1);
      }
      
      VmenosU.addAll(V);
      while(U.size()!=V.size()) {   
         VmenosU.removeAll(U);
         System.out.println("U="+U);
         System.out.println("V-U:"+VmenosU+"\n");
         
         for(int i=0;i<U.size();i++) {
               u=U.get(i);
            for(int j=0;j<VmenosU.size();j++) {
               v=VmenosU.get(j);
               if(mat_costos[u-1][v-1]<min) {
                     min=mat_costos[u-1][v-1];
                     uMin=u;
                     vMin=v;
                  }
               }
            }
         arbolPrim[uMin-1][vMin-1]=min;
         T.add(new Vertice(uMin,vMin));
         U.add(vMin);
         min=INFINITO;
      }
   }

   public static void main(String[] args )  {
      String[][] datos;
      int i;
      Grafo_Dirigido digrafo= new Grafo_Dirigido();
      
      try {
         Lee_Grafo archgrafo= new Lee_Grafo(args[0]);
         datos=archgrafo.lee_arch();

         if (archgrafo.formato_valido()){
         
         int n=digrafo.tam_matriz(datos);
         digrafo.crea_mat_ady(n,datos);
         digrafo.crea_mat_costos(n,datos);
         
         digrafo.muestraAdy();
         digrafo.muestraCostos();
         
         System.out.println("\n\n        ===========LISTA DE ADYACENCIA=============");
         for (i=0; i<n; i++)
            digrafo.lista_adyacentes(i);

         
         System.out.println("\n\n        ================RECORRIDOS================");
         digrafo.DFS (0);
         digrafo.BFS (0);


         System.out.println("\n\n\n        ===========AlGORITMO DIJKSTRA=============");
         digrafo.dijkstra();

         System.out.print("\nCostos de la distancia mas corta... \n");
         for (int v=1; v<digrafo.costos_minimos.length; v++)
            System.out.print("De 1 a "+(v+1)+":"+digrafo.costos_minimos[v]+"   ");

            System.out.print("\n");
         for (i=0; i<n; i++)
               digrafo.recorre(i);

         
         System.out.println("\n\n        ===========ARBOL DE COSTO MINIMO=============");
         digrafo.prim();
         System.out.println("Arbol de costos minimos: "+digrafo.T);

         

         } else System.out.println("ERROR: El archivo no contiene un formato valido");

      } catch (Exception e) {System.err.println("Falta nombre de archivo correcto");}
   }
}
  