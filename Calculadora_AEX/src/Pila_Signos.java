
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
        
        if(cima == null)    return null;
        else                return cima.signo;
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

    public static String comprobarExp(String exp){
        Pila_Signos pila = new Pila_Signos();

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
          
        if(!pila.vacia())
            return "Falto un  '"+Pila_Signos.SignoOpuesto(pila.obtener())+"'  que cierra";
        else if(!comprobarOper(exp))
            return "Operadores o punto mal colocados";
        else if(!comprobarExceso(exp))
            return "Exceso o falta de parentesis, corchetes o llaves";
        else 
            return "Todos los simbolos estan bien balanceados";
    }

    private static boolean comprobarExceso(String exp){
        Pila_Signos pila = new Pila_Signos();
        boolean t=false;

        for (Character o : exp.toCharArray()) {
            
            if(o.equals('(') || o.equals('[') || o.equals('{')){
                pila.apilar(o);
                t=true;
            }else if(o.equals('*') || o.equals('+') || o.equals('-') || o.equals('/') || o.equals('^'))
                
                pila.desapilar();    
        }

        if(pila.vacia() && t)   return true;
        else                    return false;
    }

    private static boolean comprobarOper(String exp){
        Pila_Signos pila = new Pila_Signos();
        Character o,a=' ';
        int j=0;

        for (int i=0; i<exp.length();i++) {
            o=exp.charAt(i);
            a=pila.obtener();

            if((!Character.isDigit(o) && !pila.vacia()) && 
            (((o==')' || o==']' || o=='}') && (a=='+' || a=='-' || a=='*' || a=='/' || a=='^')) ||
            ((o=='+' || o=='*' || o=='/' || o=='^' || o=='.') && 
            ((!Character.isDigit(a) && a!=')' && a!=']' && a!='}') || o==exp.charAt(exp.length()-1)))))
                return false;
                
            if((o=='-' && (a=='+' || a=='-' || a=='*' || a=='/' || a=='^')) && ++j==2) 
                return false;
                              
            pila.apilar(o);
        }
        return true;
    }

}
