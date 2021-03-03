import java.util.ArrayList;

public class Lista_ligada {

         
    private class Nodo {
        
        public Object object;
        public Nodo sig;

        public Nodo(Object object){
            this.object=object;
        }

    }

    private Nodo cabeza =null;
    private int Longitud=0;
    
    /*
     *implementación de una operación denominada impares(…) 
     *que elimine los  nodos que se encuentren en posiciones 
     *impares de una lista ligada
     */
    public void Impares(){
        
        if(cabeza!=null && cabeza.sig!=null){

            Nodo []eliminar = new Nodo[Longitud/2];
            Nodo aux = cabeza;
            int contador=0,i=0;

            while(aux.sig!=null){

                if((contador++)%2==0)
                    eliminar[i++]=aux;
                aux=aux.sig;
            }

            for(Nodo n:eliminar){
                aux=n.sig;
                n.sig=n.sig.sig;
                aux=null;
                Longitud--;
            }
        }
    }
    //metodo impares


    public void InsertarInicio(Object object) {
        
        Nodo nodo= new Nodo(object);
        nodo.sig=cabeza;
        cabeza=nodo;
        Longitud++;
    }

    public void InsertarFinal(Object object) {
        
        Nodo nodo= new Nodo(object);

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

    public void InsertarDespues(int n, Object object) {
        
        Nodo nodo = new Nodo(object);
        
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
            System.out.print(aux.object+" --> ");
            aux=aux.sig;
        }
        System.out.print("\n\n");
    }

}
