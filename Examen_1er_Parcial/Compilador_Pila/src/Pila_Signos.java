
public class Pila_Signos implements Pila {

    private class Nodo{

        public Character signo;
        public Nodo siguente=null;
        
        public Nodo(Character signo){
            this.signo=signo;
        }

    }

    private Nodo cima=null;
    private int longitud=0;


    @Override
    public void apilar(Character signo){

        Nodo nodo= new Nodo(signo);
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
    public Character obtener(){

        if(cima==null)
            return null;
        else
            return cima.signo;
    }

    @Override
    public int longitud(){
        return longitud;
    }

    @Override
    public boolean vacia(){
        return longitud==0;         
    }
    
    public void ImprimeEstado(){

        if(vacia())
            System.out.println("\nNo hay nada en la pila");
        else
            System.out.println("\nlongitud: "+longitud()+" cima: "+obtener());
    }

    public static char SignoOpuesto(char signo){

        if(signo==')')
            return '(';

        else if(signo==']')
            return '[';
        
        else
            return '{';
    }

}
