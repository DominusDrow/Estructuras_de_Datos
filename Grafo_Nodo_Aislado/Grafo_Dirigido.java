
import java.util.*;

public class Grafo_Dirigido
  {
   Vector<Object> vertices=new Vector<Object>();
   int[][] mat_ady;
   int[][] mat_costos;
   int[] costos_minimos;
   int[] p;
   Vector<Object> s= new Vector<Object>();
   
   
   public int tam_matriz(String[][] datos)
  	   {
  	   	Integer num;
  	   	for (int i=0; i<datos.length; i++)
       	   {
       	     for (int j=0; j<datos[i].length-1; j++)
       	        {
       	         num= new Integer(Integer.parseInt(datos[i][j]));
       	         if (vertices.indexOf(num)==-1)
       	            vertices.addElement(num);
       	        }
           }
       vertices.trimToSize();   
       return vertices.capacity();
  	   }
  	
  	
  	
  	public void crea_mat_ady(int tam,String[][] datos)
  	   {
  	   	mat_ady= new int[tam][tam];
  	  
  	   	
  	   	for(int k=0; k<tam; k++)
  	   	   	for (int l=0; l<tam; l++)
  	   	   	    mat_ady[k][l]=0;
  	   	   	
  	   	for (int i=0; i<datos.length; i++)
       	    mat_ady[Integer.parseInt(datos[i][0])][Integer.parseInt(datos[i][1])]=1;	
  	   }

  	
  	
  	public void crea_mat_costos(int tam,String[][] datos)
  	   {
  	   	mat_costos= new int[tam][tam];
  	  
  	   	for(int k=0; k<tam; k++)
  	   	   	for (int l=0; l<tam; l++)
  	   	   	   mat_costos[k][l]=10000;
  	   	
  	   	for (int i=0; i<datos.length; i++)
       	    mat_costos[Integer.parseInt(datos[i][0])][Integer.parseInt(datos[i][1])]= Integer.parseInt(datos[i][2]);	
  	   }

  	
  	
  	public void imprime_matriz(int[][] mat)
  	   {
  	   	for (int i=0; i<mat.length; i++)
       	   {
       	     for (int j=0; j<mat.length; j++)
       	   	    System.out.print(" "+mat[i][j]);
       	  
       	     System.out.println(" ");
           }
        System.out.print("\n");
  	   }




    public int primero(int v)
       {
        int v_ady=-1;
       	
       	for (int i=0;i<mat_ady.length; i++)
       	  {
       	   if (mat_ady[v][i]==1)
       	      {
       	       v_ady=i;
       	       break;
       	      }	
       	  }
       	return v_ady;  
       }

       
    public int siguiente(int v, int i)
       {
       	int v_sig=-1;
       	 for (int j=i+1; j<mat_ady.length; j++)
       	    {
       	     if (mat_ady[v][j]==1)
       	       {
       	        v_sig=j;
       	        break;
       	       } 
       	    }
       	return v_sig;
       }



    public void encuentra_vertices_adyacentes(int v)
       {
        int i=primero(v);
        System.out.print("nodos adyacentes a "+v+": ");
        
        do {
        	System.out.print(i+" ");
        	i=siguiente(v,i);
           }while(i!=-1);
        System.out.print("\n");   
       }    
       
  }
  