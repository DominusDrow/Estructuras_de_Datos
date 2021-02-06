
public class MiPila implements Pila{

    private class Nodo{

        public URL url;
        public Nodo siguente=null;

        public Nodo(URL url){
            this.url=url;
        }
    }

    private Nodo cima=null;
    private int longitud=0;


    @Override
    public void apilar(URL url){

        Nodo nodo= new Nodo(url);
        nodo.siguente=cima;
        cima=nodo;
        longitud++;
    }
    
    @Override
    public void desapilar(){

        if(cima!=null){
            Nodo eliminar= cima;
            cima= cima.siguente;
            eliminar.siguente=null;
            longitud--;
        }
    }

    @Override
    public URL obtener(){

        if(cima==null)
            return null;
        else
            return cima.url;
    }

    @Override
    public int longitud(){
        return longitud;
    }

    @Override
    public boolean vacia(){
        return longitud==0;         //forma elegante de retornar un booleano :0
    }
    
}
