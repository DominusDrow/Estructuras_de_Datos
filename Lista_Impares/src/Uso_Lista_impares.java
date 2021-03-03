public class Uso_Lista_impares {
    
    public static void main(String[] args) {
        
        Lista_ligada peliculas = new Lista_ligada();
        
        System.out.println("\n**Hacemos la lista:**\n");

        peliculas.InsertarInicio("Harry Pother");
        peliculas.InsertarInicio("UP");
        peliculas.InsertarFinal("La llorona");
        peliculas.InsertarDespues(0,"La momia");
        peliculas.InsertarDespues(2,"Focus");
        peliculas.mostrar();
        
        System.out.println("**Aplicacmos el metodo impares:**\n");
        peliculas.Impares();
        peliculas.mostrar();

    }

}
