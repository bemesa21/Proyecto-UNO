import java.util.ArrayList;
import java.util.Scanner;

public class Jugador{
	private ArrayList<Carta> mano;
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
	public int tirarCarta(Tablero monton, Baraja b1){
System.out.flush();
		System.out.print("Carta en mesa: ");
		monton.carta.getCara();
		int auxiliar=-1;
		Scanner teclado=new Scanner(System.in);
		while(auxiliar==-1){
			System.out.println("\nTurno: "+nombre);
			this.imprimeBaraja();
			if(verificarSiNoCome(monton,b1)){
				System.out.println("¿Que carta desea Tirar?");
				int cartaAtirar=teclado.nextInt();
				auxiliar=comprobarCarta(monton,cartaAtirar);
			}else{
				while(verificarSiNoCome(monton,b1)==false){
					System.out.println(nombre+"debe comer de la baraja");
					mano.add(b1.cartas.get(0));
					b1.cartas.remove(0);
				}
			}
			
		}
		return auxiliar;
	}

	public int comprobarCarta(Tablero monton, int cartaAtirar){
		int aRetornar=0;
//		System.out.println(mano.get(cartaAtirar-1).getValor());
		if(mano.get(cartaAtirar-1).getValor()<=9){
			if(monton.carta.getValor()==mano.get(cartaAtirar-1).getValor() || monton.carta.getColor()==mano.get(cartaAtirar-1).getColor()){
				monton.carta=mano.get(cartaAtirar-1);
				mano.remove(cartaAtirar-1);

			}else{
				System.out.println("NO puedes tirar esa carta )o)");
				aRetornar=-1;
			}
		}else{
			if(mano.get(cartaAtirar-1).getValor()==10)
				{mano.remove(cartaAtirar-1);
				aRetornar= 1;}
			else
				if(mano.get(cartaAtirar-1).getValor()==11)
					{mano.remove(cartaAtirar-1);
					aRetornar= 2;}
				else
					if(mano.get(cartaAtirar-1).getValor()==12)
						{mano.remove(cartaAtirar-1);
						aRetornar= 3;}
					else
						if(mano.get(cartaAtirar-1).getValor()==13)
							{mano.remove(cartaAtirar-1);
							aRetornar= 4;}
						else 
							if(mano.get(cartaAtirar-1).getValor()==14)
								{mano.remove(cartaAtirar-1);
								aRetornar= 5;}
			}

		
		return aRetornar;
	}

	public boolean verificarSiNoCome(Tablero monton, Baraja b1){
		boolean bandera=false;
		for (Carta c :  mano ) {
			if(c.getValor()>9 || c.getValor()==monton.carta.getValor() || c.getColor()==monton.carta.getColor())
				bandera = true;
		}
		return bandera;

	}

	public void imprimeBaraja(){
		for (Carta c :  mano ) {
			c.getCara();
		}
		System.out.println(" ");

	

	}

	public ArrayList<Carta> getMano(){
		return mano;
	}
	public String getNombre(){
		return nombre;
	}

}