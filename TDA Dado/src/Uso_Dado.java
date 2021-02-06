import java.util.Scanner;

public class Uso_Dado {

	public static void main(String[] args) {
		
		Dado dado1 = new Dado();
		Dado dado2 = new Dado();
		Dado dado3 = new Dado();
		Scanner sc= new Scanner(System.in);
		int opc=-1,op,op2;
		
		while(opc!=0) {
			op=3;
			System.out.print("JUEGO DE MESA CON DADOS!-------------------------------------"
				+ ":\n\nElija un modo de juego:\n1.Novato\n2.Normal\n3.Experto\n0.Salir\n\nelija: ");
			opc=sc.nextInt();
			
			while(op>0) {
				
				if(opc==1) {

					System.out.print("\nNIVEL:Novato\tDADOS:1   Oportunidades: "+op
							+ "\nGana si consigue que caiga un 6!\n\n1.lanzar\n\nElija: ");
					op2=sc.nextInt();
					
					if(op2==1)
						dado1.Lanzar();
					
					System.out.print("\n\nEl dado "+dado1.MostrarValor());
					
					if(dado1.ObtenerValor()==6) {
						
						System.out.print("\nGANASTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");
						op=-1;
					}
					else if(op>1)
						System.out.print("\nSigue intentando:(!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");
					
					
				}
				
				else if(opc==2) {

					System.out.print("\nNIVEL:Normal\tDADOS:2   Oportunidades: "+op
							+ "\nGana si consigue que caiga entre los dos un 7!\n\n1.lanzar\n\nElija: ");
					op2=sc.nextInt();
					
					if(op2==1) {
						dado1.Lanzar();
						dado2.Lanzar();
					}
						
					
					System.out.print("\n\nEl dado 1 "+dado1.MostrarValor());
					System.out.print("\nEl dado 2 "+dado2.MostrarValor());
					
					if(dado1.ObtenerValor()+dado2.ObtenerValor()==7) {
						
						System.out.print("\nGANASTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");
						op=-1;
					}
					else if(op>1)
						System.out.print("\nSigue intentando:(!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");
					
					
				}
				
				else if(opc==3) {

					System.out.print("\nNIVEL:Experto\tDADOS:3   Oportunidades: "+op
						+ "\nGana si consigue que caiga entre los tres un 15!"
						+ "\n\n1.lanzar\nElija: ");
					op2=sc.nextInt();
					
					if(op2==1) {
						dado1.Lanzar();
						dado2.Lanzar();
						dado3.Lanzar();
					}
						
					
					System.out.print("\n\nEl dado 1 "+dado1.MostrarValor());
					System.out.print("\nEl dado 2 "+dado2.MostrarValor());
					System.out.print("\nEl dado 3 "+dado3.MostrarValor());
					
					if(dado1.ObtenerValor()+dado2.ObtenerValor()+dado3.ObtenerValor()==15) {
						
						System.out.print("\nGANASTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");
						op=-1;
					}
					else if(op>1)
						System.out.print("\nSigue intentando:(!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");
					
					
				}
				
				if(op==1)
					System.out.print("\nPERDISTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");
				
				op--;
			}
			
		}
		
		System.out.print("\n\n\nJuego terminado.");
		
	}

}
