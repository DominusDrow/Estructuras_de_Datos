import java.lang.reflect.Method;

public class Lista_Enlazada {
    
     
    private class Nodo {
        
        public Libro libro;
        public Nodo sig;

        public Nodo(Libro libro){
            this.libro=libro;
        }

    }

    private Nodo cabeza =null;


    public void InsertarInicio(Libro libro) {
        
        Nodo nodo= new Nodo(libro);
        nodo.sig=cabeza;
        cabeza=nodo;
    }

    public void InsertarFinal(Libro libro) {
        
        Nodo nodo= new Nodo(libro);
      

        if(cabeza==null)
            cabeza=nodo;
        else{    
            Nodo aux=cabeza;
            while (aux.sig!=null) {
                aux=aux.sig;   
            }
            aux.sig=nodo;
        }
    }



}
