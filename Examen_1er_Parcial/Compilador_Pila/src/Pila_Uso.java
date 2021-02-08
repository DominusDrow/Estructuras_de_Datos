import java.util.Scanner;

public class Pila_Uso {

    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        
        String text = entrada.nextLine();
        
        Pila_Signos pila = new Pila_Signos();

        int i = 0;

        while (i<text.length()) {
            
            if(text.charAt(i)=='(' || text.charAt(i)=='[' || text.charAt(i)=='{')
                pila.apilar(text.charAt(i));
            
            else if (text.charAt(i)==')' || text.charAt(i)==']' || text.charAt(i)=='}'){
                
                if(pila.vacia())
                    break;
                
                else if(pila.obtener()!= Pila_Signos.SignoOpuesto(text.charAt(i)))
                    break;

                else 
                    pila.desapilar();
            }   

            i++;
        }

        if(pila.vacia() && i==text.length())
            System.out.println("Correcto");
        else
           System.out.println("Incorrecto");

    }


    
}
