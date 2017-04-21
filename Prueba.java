import java.util.Scanner;
import java.util.Collections;

public class Prueba{
	public static void main(String[] args) {
		int numJugadores=0;
		Baraja b1= new Baraja();
		Scanner teclado=new Scanner(System.in);
		Jugador j1,j2,j3,j4;
		boolean bandera=false;
		//b1.imprimeBaraja();
		Carta cartaEnMesa;
		
		while(numJugadores<2 || numJugadores>4){
		System.out.println("¿Cuántos jugadores seran?");
		numJugadores = teclado.nextInt();
		if(numJugadores<2){
			System.out.println("No puedes jugar solo )o)");
			}
		if(numJugadores>4)
			System.out.println("Solo pueden jugar 4 :v");
		}
		//creando jugadores
		switch(numJugadores){
			case 1:
				j1=new Jugador(b1,"1");
			break;
			case 2:
				j1=new Jugador(b1,"1");
				j2=new Jugador(b1,"2");
			break;
			case 3:
				j1=new Jugador(b1,"1");
				j2=new Jugador(b1,"2");
				j3=new Jugador(b1,"3");
			break;
			case 4:
				j1=new Jugador(b1,"1");
				j2=new Jugador(b1,"2");
				j3=new Jugador(b1,"3");
				j4=new Jugador(b1,"4");
			break;
		}
		cartaEnMesa=b1.cartas.get(0);
		b1.cartas.remove(0);
		System.out.println(b1.cartas.size());
		while(bandera){
			

		}
	}
}