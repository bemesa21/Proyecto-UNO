import java.util.Scanner;

public class Prueba{
	public static void main(String[] args) {
		Baraja b1= new Baraja();
		b1.imprimeBaraja();
		Scanner teclado=new Scanner(System.in);
		System.out.println("¿Cuántos jugadores jugaran?");
		int numJugadores= teclado.nextInt();
	}
}