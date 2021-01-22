import java.util.Random;

/**
 * “Dado” es un tipo de dato abstracto en java que contiene dentro de sí una variable de tipo 
 * entero, la cual guardará el estado (1 al  6 o 0 si no se ha tirado) del dado, a este se le 
 * asocian las operaciones básicas que permitan su funcionamiento como lanzarlo, obtener 
 * su valor y mostrarlo, será utilizado para declarar variables y definir objetos de su tipo.
 * <br>
 * <H2>Repositorio en github:</H2><br>
 * @see <a href="https://github.com/DominusDrow/Estructuras_de_Datos.git">FCC</a>
 * @author Alfredo Omar Vasquez Lopez
 * @version 1.0
 * @since JDK 2.0 20/ENE/2021
**/

public class Dado {
	
	/**
	 * Representa la cara del dado en la que cae 
	 **/
	private int caraDado;
	
	/**
	 * constructor de un objeto Dado que tiene como estado
	 * inicial "0" pues no ha sido tirado
	 **/
	public Dado(){
		caraDado=0;
	}
	
	/**
	 * Método de instancia que es utilizado por un objeto de tipo “Dado” 
	 * para simular el lanzamiento de un dado asignando al dato “caraDado” un número 
	 * aleatorio entre [1,6], no retorna nada.
	 **/
	public void Lanzar() {
		
		Random aleatorio = new Random();
		caraDado = aleatorio.nextInt(6)+1;
	}
	
	/**
	 * Método de instancia que es utilizado por un objeto de tipo “Dado” 
	 * para representar su último estado, retorna un dato de tipo entero, entre [1,6]  o 0 si 
	 * el dado aun no se ha tirado.  
	 * @return El metodo un dato de tipo entero que representa la cara en la que el dado 
	 * ha caído entre [1,6]
	 * @throws ArithmeticException El metodo retorna 0 si aun no se ha tirado el dado 
	 **/
	public int ObtenerValor() {
		
		return caraDado;
	}
	
	/**
	 *  Método de instancia que es utilizado por un objeto de tipo “Dado” 
	 *  para representar la última cara en la que el dado ha caído, retorna un dato de tipo 
	 *  cadena que contiene un mensaje según el estado del dado.
	 *  @return El método retorna como resultado un dato de tipo cadena cuyo mensaje 
	 *  contiene del 1 al 6 si “caraDado!=0”
	 *  @throws ArithmeticException  El metodo retorna un mensaje de “no se ha lanzado” 
	 *  si “caraDado==0”
	 **/
	public String MostrarValor() {
		
		if(caraDado==0)
			return "no se ha lanzado";
		else
			return "cayo en: "+caraDado+"!!!";
	}
	
	
	
}
