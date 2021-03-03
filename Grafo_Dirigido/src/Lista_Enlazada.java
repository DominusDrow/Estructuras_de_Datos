public class Lista_Enlazada {

    private class Nodo {
        
        public Object adyacente;
        public Object costo;
        public Nodo sig;

        public Nodo(Object adyacente, Object costo){
            this.adyacente=adyacente;
            this.costo=costo;
        }

    }

    private Object vertice;
    private Nodo cabeza;

    public Lista_Enlazada(Object vertice){
        this.vertice=vertice;
        this.cabeza=null;
    }

    public Object getVertice() {
        return vertice;
    }

    public void InsertarInicio(Object adyacente, Object costo) {
        
        Nodo nodo= new Nodo(adyacente,costo);
        nodo.sig=cabeza;
        cabeza=nodo;
    }

    public void InsertarFinal(Object adyacente, Object costo) {
        
        Nodo nodo= new Nodo(adyacente,costo);

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

    public Object obtener(int n){

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
                return aux.adyacente;
        }
    }

    public boolean vacia(){
        return cabeza==null;
    }

    public void EliminarInicio() {

        if(cabeza!=null){
            Nodo aux=cabeza;
            cabeza=cabeza.sig;
            aux.sig=null;
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
        }
    }

    public void mostrar(){

        Nodo aux=cabeza;
        while (aux!=null) {
            System.out.print("|V:"+aux.adyacente+" C:"+aux.costo+"| --> ");
            aux=aux.sig;
        }
        System.out.print("null\n\n");
    }

}
