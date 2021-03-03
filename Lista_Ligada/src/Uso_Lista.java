public class Uso_Lista {
    
    public static void main(String[] args) {
        
      
        Lista_Enlazada lista = new Lista_Enlazada();

        lista.InsertarFinal(new Libro("titulo", "autor"));
        lista.InsertarDespues(0, new Libro("la biblia","si"));
        lista.InsertarDespues(0, new Libro("crimenes","emwklsd"));
        System.out.println("\n**Hacemos la lista de libros:**");
        lista.mostrar();

        Lista_Enlazada lista2 = new Lista_Enlazada();

        lista2.InsertarInicio(new Libro("serpientes", " "));
        lista2.InsertarInicio(new Libro("Origami", " "));
        System.out.println("**Hacemos otra lista de libros:**");
        lista2.mostrar();

        lista2.CombinarLista(lista.getCabeza());
        System.out.println("**Combinamos las listas:**");
        lista2.mostrar();
    }   

}
