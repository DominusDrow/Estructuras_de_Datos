import java.lang.reflect.Method;

public class Lista_Enlazada {
    
     
    private class Nodo {
        
        public Libro libro;
        public Nodo sig;

        public Nodo(Libro libro){
            this.libro=libro;
        }

    }

    private Nodo cabeza=null;
    private int Longitud=0;

    public void InsertarInicio(Libro libro) {
        
        Nodo nodo= new Nodo(libro);
        nodo.sig=cabeza;
        cabeza=nodo;
        Longitud++;
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
        Longitud++;
    }

    public void InsertarDespues(int n, Libro libro) {
        
        Nodo nodo = new Nodo(libro);
        
        if(cabeza==null)
            cabeza = nodo;
        else{
            Nodo aux=cabeza;
            int contador=0;
            while (contador<n && aux.sig!=null) {
                aux=aux.sig;
                contador++;   
            }
            nodo.sig=aux.sig;
            aux.sig=nodo;
        }
        Longitud++;
    }


    public Libro obtener(int n){

        if(cabeza==null)
            return null;
        else{
            Nodo aux=cabeza;
            int contador=0;
            while (contador<n && aux.sig!=null) {
                aux=aux.sig;
                contador++;   
            }

            if(contador!=n)
                return null;
            else
                return aux.libro;
        }
    }

    public int contar(){
        return Longitud;
    }

    public boolean vacia(){
        return cabeza==null;
    }

    public Nodo getCabeza(){
        return this.cabeza;
    }

    public void EliminarInicio() {

        if(cabeza!=null){
            Nodo aux=cabeza;
            cabeza=cabeza.sig;
            aux.sig=null;
            Longitud--;
        }
    }

    public void EliminarFinal(){
        
        if(cabeza!=null){
            if(cabeza.sig==null)
                cabeza=null;
            else{
                Nodo aux = cabeza;
                while (aux.sig.sig!=null) {
                    aux=aux.sig;
                }
                aux.sig=null;
            }
            Longitud--;
        }
    }

    public void ELiminarDespues(int n){

        if(cabeza!=null){

            if(n==0)
                this.EliminarInicio();
            else if(n<Longitud){
                Nodo aux=cabeza;
                int contador=0;

                while(contador<n){
                    aux=aux.sig;
                    contador++;
                }
                Nodo temp=aux;
                aux.sig=temp;
                temp.sig=null;
            }
            Longitud--;
        }
    }

    public void mostrar(){

        Nodo aux=cabeza;
        while (aux!=null) {
            System.out.print(aux.libro.getTitulo()+" --> ");
            aux=aux.sig;
        }
        System.out.print("\n\n");
    }

    public void CombinarLista(Nodo cabeza){

        Nodo aux1= this.cabeza;
        Nodo aux2= cabeza;
        Nodo aux3,aux4;

        while(aux1!=null || aux2!=null){
            
            if(aux1!=null && aux2!=null){
                aux3=aux1.sig; 
                aux4=aux2.sig;
               
                aux1.sig=aux2;
                aux2.sig=aux3;
                
                aux1=aux3;
                aux2=aux4;

            }else if(aux2!=null){

                aux3=this.cabeza;
                while(aux3.sig!=null){
                    aux3=aux3.sig;
                }
                aux3.sig=aux2;
                aux2=aux2.sig;
            }else
                break;
        }

    }

}
