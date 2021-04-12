
public class ABST implements IBST {
    
    private Integer valor;
    private ABST padre,izq,der;

    public Integer alturaNodo(Integer id){
        ABST nodo = obtener(id);
        int i=0;

        if(nodo!=null && !nodo.esHoja()){

            if(nodo.izq!=null)
                i = Math.max(i, alturaNodo(nodo.izq.valor));
            
            if(nodo.der!=null)
                i = Math.max(i, alturaNodo(nodo.der.valor));

            i++; 
        } 
        return i;
    }

    public Integer profundidadNodo(Integer id){
        ABST nodo = obtener(id);
        int i=0;

        if(nodo.padre!=null)
            i= 1+ profundidadNodo(nodo.padre.valor);
        return i;
    }

    public Integer NumeroHojas(ABST nodo){
        int i=0;

        if(nodo.esHoja())
            i++;
        if(nodo.izq!=null)
            i+=NumeroHojas(nodo.izq);
        if(nodo.der!=null)
            i+=NumeroHojas(nodo.der);

        return i;
    }
  
    @Override
    public void insertar(Object obj){
        insertarImpl((Integer) obj,null);
    }

    public void insertarImpl(Integer obj, ABST padre){
        if(valor==null){
            this.valor=obj;
            this.padre=padre;
        }
        else{

            if(obj<valor){
                if(izq==null) izq=new ABST();
                izq.insertarImpl(obj,this);
            }
            else if(obj>valor){
                if(der==null) der=new ABST();
                der.insertarImpl(obj,this);
            }
        }
    }

    @Override
    public boolean existe(int id){

        if (valor!=null) {

            if(valor==id)
                return true;
            else if(id<valor && izq!=null)
                return izq.existe(id);
            else if(id>valor && der!=null)
                return der.existe(id);
            else 
                return false;
            
        }else return false;
    }

    @Override
    public ABST obtener(int id){
      
        if (valor!=null) {

            if(valor==id)
                return this;
            else if(id<valor && izq!=null)
                return izq.obtener(id);
            else if(id>valor && der!=null)
                return der.obtener(id);
            else 
                return null;
            
        }else return null;
    }

    @Override
    public boolean esHoja(){
        return valor!=null && izq==null && der==null;
    }

    @Override
    public boolean esVacio(){
        return valor==null;
    }

    @Override
    public void preOrden(){

        if (valor!=null) {
            System.out.print("---> "+valor);
            if(izq!=null) izq.preOrden();
            if(der!=null) der.preOrden();
        }
    }

    @Override
    public void enOrden(){

        if (valor!=null) {
            if(izq!=null) izq.enOrden();
            System.out.print("---> "+valor);
            if(der!=null) der.enOrden();
        }
    }

    @Override
    public void postOrden(){

        if (valor!=null) {
            if(izq!=null) izq.postOrden();
            if(der!=null) der.postOrden();
            System.out.print("---> "+valor);
        }     
    }

    @Override
    public void eliminar(int id){

        if(valor!=null){

            if(valor==id){
                eliminarImpl(id);
            }
            else if(id<valor && izq!=null)
                izq.eliminar(id);
            else if(id>valor && der!=null)
                der.eliminar(id);
        }
    }

    private void eliminarImpl(int id){

        if(izq!=null && der!=null){

           ABST minimo = der.minimo();
           this.valor=minimo.valor;
           
           der.eliminar(minimo.valor);

        }    
        else if(izq!=null || der!=null){

            ABST sustituto= izq!=null ? izq:der;

            this.valor=sustituto.valor;
            this.izq=sustituto.izq;
            this.der=sustituto.der;
        }
        else{

            if(padre!=null){
                if(this==padre.izq) padre.izq=null;
                if(this==padre.der) padre.der=null;
                padre=null;
            }
            valor=null;
        }
    }

    private ABST minimo(){

        if(izq!=null && !izq.esVacio())
            return minimo();
        else
            return this;
    }

    @Override
    public ABST raiz(){
        ABST raiz=this;

        while(raiz.padre!=null)
            raiz=raiz.padre;

        return raiz;
    }
    
    public String toString(){
        return ""+this.valor;
    }

}
