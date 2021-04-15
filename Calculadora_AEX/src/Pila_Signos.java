
public class Pila_Signos {

    private class Nodo{

        public Character signo;
        public Nodo siguente = null;

        public Nodo(Character signo){
            this.signo=signo;
        }
    }

    private Nodo cima = null;


    public void apilar(Character signo){

        Nodo nodo = new Nodo(signo);
        nodo.siguente = cima;
        cima = nodo;
    }

    public void desapilar(){

        if(cima != null){
            Nodo eliminar = cima;
            cima= cima.siguente;
            eliminar.siguente=null;
        }
    }

    public Character obtener(){

        if(cima == null)
            return null;
        else
            return cima.signo;
    }

    public boolean vacia(){
        return cima==null; 
    }

    public static char SignoOpuesto(char signo){

        if(signo==')')        
            return '(';  
        else if(signo==']')   
            return '[';
        else if(signo=='}')
            return '{';
        else if(signo=='(')
            return ')';
        else if(signo=='[')
            return ']';
        else                  
            return '}';      
    }

    public static String comprobarSig(Pila_Signos pila, String exp){

        for(char i:exp.toCharArray()) {

            if ( i == '(' || i == '[' || i == '{') 
                pila.apilar(i);
   
            else if ( i == ')' || i == ']' || i == '}') {

                if (pila.vacia()) 
                    return "\n\nFalto un  '"+Pila_Signos.SignoOpuesto(i)+"'  que abre";

                else if (pila.obtener() != Pila_Signos.SignoOpuesto(i)) 
                    return "falto ponerlo o falto un  '"+Pila_Signos.SignoOpuesto(i)+"'  que abre";

                else 
                    pila.desapilar();
            }
        }
        if (pila.vacia())  
            return "Todos los simbolos estan bien balanceados";
        else             
            return "Falto un  '"+Pila_Signos.SignoOpuesto(pila.obtener())+"'  que cierra";
    }

}
