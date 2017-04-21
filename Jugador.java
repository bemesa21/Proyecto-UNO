import java.util.ArrayList;
import java.util.Scanner;

public class Jugador{
	static ArrayList<Carta> mano;
	private String nombre="Jugador ";
// 	private int numJugadores;
 

	public Jugador(Baraja mazo,String nombre){ 
		this.nombre=this.nombre+nombre;
		mano= new ArrayList<Carta>();
		this.repartir(mazo);
	}


	public void repartir(Baraja mazo){
		for(int i=0;i<7;i++){
			mano.add(mazo.cartas.get(0));
			mazo.cartas.remove(0);
		}

	}
/*recibe una carta, la ultima del monton
retornará un cero, si tiró una carta normal y no necesito modificar el estado del juego o 
arruinar al jugador siguiente :v
retornará:
1: Saltar1
2: Reversa
3: Roba 2
4:COmodin
5:COmodin roba 4
*/
	public int tirarCarta(Carta monton){
		Scanner teclado=new Scanner(System.in);
		System.out.println("Turno: "+nombre);
		System.out.println("¿Que carta desea Tirar?");
		int cartaAtirar=teclado.nextInt();
		return 	comprobarCarta(monton,cartaAtirar);

	}

	public int comprobarCarta(Carta monton, int cartaAtirar){
		int aRetornar=0;
		System.out.println(mano.get(cartaAtirar-1).getValor());
		if(mano.get(cartaAtirar-1).getValor()<=9){
			if(monton.getValor()==mano.get(cartaAtirar-1).getValor() || monton.getColor()==mano.get(cartaAtirar-1).getColor()){
				//mano.remove(cartaAtirar-1);
				System.out.println("Tiraste una carta: " + mano.get(cartaAtirar-1).getValor());
				System.out.println("ES de color" + mano.get(cartaAtirar-1).getColor());
			}else{
				System.out.println("NO puedes tirar esa carta )o)");
				aRetornar=-1;
			}
		}else{
			if(mano.get(cartaAtirar-1).getValor()==10)
				aRetornar= 1;
			else
				if(mano.get(cartaAtirar-1).getValor()==11)
					aRetornar= 2;
				else
					if(mano.get(cartaAtirar-1).getValor()==12)
						aRetornar= 3;
					else
						if(mano.get(cartaAtirar-1).getValor()==13)
							aRetornar= 4;
						else 
							if(mano.get(cartaAtirar-1).getValor()==14)
								aRetornar= 5;
			}

		
		return aRetornar;
	}

	public void imprimeBaraja(){
		System.out.println(mano.size());
		for (Carta c :  mano ) {
			System.out.println(c.getCara());
		}

	

	}


}