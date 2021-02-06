public class Pila_Uso {
    
    public static void main(String[] args) {
        
        URL google = new URL("www.google.com");
        URL youtube= new URL("www.youtube.com");

        Pila pila = new MiPila();

        ImprimeEstado(pila);
        pila.apilar(google);
        ImprimeEstado(pila);
        pila.apilar(youtube);
        ImprimeEstado(pila);

        while (!pila.vacia()) {
            pila.desapilar();
            ImprimeEstado(pila);
        }
        
    }

    public static void ImprimeEstado(Pila pila){

        if(pila.vacia())
            System.out.println("\nNo hay nada en la pila");
        else
            System.out.println("\nlongitud: "+pila.longitud()+" cima: "+pila.obtener().getUrl());
    }

}
