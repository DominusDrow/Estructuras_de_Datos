import java.text.Collator;

public class ABST {
    
    private Integer hz;
    private String token;
    private ABST izq,der;
  
    public void insertar(String obj){
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY);

        if(token==null){
            this.token=obj;
            this.hz=1;
        }
        else{

            if(collator.compare(obj, token)==-1){
                if(izq==null) izq=new ABST();
                izq.insertar(obj);
            }
            else if(collator.compare(obj, token)==1){
                if(der==null) der=new ABST();
                der.insertar(obj);
            }
            else if(collator.compare(obj, token)==0)
                this.hz++;
        }
    }
    
    public void enOrden(){

        if (token!=null) {
            if(izq!=null) izq.enOrden();
            System.out.print("\n"+token);
            System.out.print("\t\t"+hz);
            if(der!=null) der.enOrden();
        }
    }

}
