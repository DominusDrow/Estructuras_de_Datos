import java.util.ArrayList;

public class A_EXP {
    
    private Object token;
    private static A_EXP aux;
    private A_EXP padre,izq,der;
 
    public void insertar(Object obj){
        insertarImpl(obj,null);
    }

    public void insertarImpl(Object obj, A_EXP padre){

        if(token==null){
            this.token=obj;
            this.padre=padre;
        }
        else if(obj.equals('(') || obj.equals('[') || obj.equals('{')){
  
            if(token.equals('(') || token.equals('[') || token.equals('{')){
                if(izq==null) izq=new A_EXP();
                izq.insertarImpl(obj,this);
            }
            else if(token.equals('*') || token.equals('+') || token.equals('-') || token.equals('/') || token.equals('^')){
                if(der==null) der=new A_EXP();
                der.insertarImpl(obj,this);
            }          
        }
        else if(obj.equals('*') || obj.equals('+') || obj.equals('-') || obj.equals('/') || obj.equals('^')){
            ultimaHoja();
            signos(aux, obj);
        }
        else{
            
            if(token.equals('(') || token.equals('[') || token.equals('{')){ 
                if(izq==null) izq=new A_EXP();
                izq.insertarImpl(obj,this);
            }
            else if(token.equals('*') || token.equals('+') || token.equals('-') || token.equals('/') || token.equals('^')){
                if(der==null) der=new A_EXP();
                der.insertarImpl(obj,this);
            }

        } 

    }

    private void signos(A_EXP nodo, Object obj){
        Object o= nodo.token;

        if(o.equals('(') || o.equals('[') || o.equals('{'))
            nodo.token=obj;
                
        else if(nodo.esHoja() || o.equals('*') || o.equals('+') || o.equals('-') || o.equals('/') || o.equals('^'))
            signos(nodo.padre, obj);
    }

    private void ultimaHoja(){

        if (token!=null) {
            aux=this;
            if(izq!=null) izq.ultimaHoja();
            if(der!=null) der.ultimaHoja();
        }
    }


    public double evaluar(A_EXP nodo){
        Object o= nodo.token;
        double i=0;
       
        if(nodo.esHoja())
            i= (double) o;
        
        else if(o!=null && (o.equals('*') || o.equals('+') || o.equals('-') || o.equals('/') || o.equals('^')))
            i= Operacion(evaluar(nodo.izq),evaluar(nodo.der), (Character) o);
        
        return i;
    }

    private static double Operacion(double n1,double n2, Character o){
        double i=0;
        switch(o){
            case '*': i= n1*n2;   break;  
            case '-': i= n1-n2;   break;
            case '+': i= n1+n2;   break;
            case '/': i= n1/n2;   break;
            case '^': i= Math.pow(n1, n2);   break;
        }
        return i;
    } 
  
    public void enOrden(){

        if (token!=null) {
            if(izq!=null) izq.enOrden();
            System.out.print("---> "+token);
            if(der!=null) der.enOrden();
        }
    }

    public void postOrden(){

        if (token!=null) {
            if(izq!=null) izq.postOrden();
            if(der!=null) der.postOrden();
            System.out.print("---> "+token);
        }     
    }

    public A_EXP raiz(){
        A_EXP raiz=this;

        while(raiz.padre!=null)
            raiz=raiz.padre;

        return raiz;
    }

    public boolean esHoja(){
        return token!=null && izq==null && der==null;
    }

    public String toString(){
        return ""+this.token;
    }

    public static ArrayList convertir(String exp){
        ArrayList<Object> arreglo=new ArrayList<Object>();
        Character sg=' ',an=' ';
        String cad="";
        
        for (int i = 0; i < exp.length(); i++) {
            an=sg;
            sg=exp.charAt(i);
            
            if(sg=='(' || sg=='[' || sg=='{' || sg=='*' || sg=='+' || sg=='-' || sg=='/' || sg=='^'){
                
                if(cad!=""){
                    arreglo.add(Double.parseDouble(cad));
                    cad="";
                }
                if(sg=='-' && (an=='(' || an=='[' || an=='{' || an=='*' || an=='+' || an=='/' || an=='^'))
                    cad=cad+sg;
                else
                    arreglo.add(sg);
            }
            else if((sg==')' || sg==']' || sg=='}') && arreglo.get(arreglo.size()-1).equals('(') )
                arreglo.remove(arreglo.size()-1);
           
            else if(i== exp.length()-1)
                arreglo.add(Double.parseDouble(cad));

            else if(sg!=')' && sg!=']' && sg!='}')
                cad=cad+sg; 
        }
        return arreglo;
    }

}
