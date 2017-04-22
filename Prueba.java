import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Prueba{
	public static void main(String[] args) {
		int numJugadores=0;
		Baraja b1= new Baraja();
		Scanner teclado=new Scanner(System.in);
//		Jugador j1,j2,j3,j4;
		ArrayList<Jugador> jugadores=new ArrayList<Jugador>();
		boolean bandera=true;
		//b1.imprimeBaraja();

		
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
				//j1=new Jugador(b1,"1");
				jugadores.add(new Jugador(b1,"1"));
			break;
			case 2:
				jugadores.add(new Jugador(b1,"1"));
				jugadores.add(new Jugador(b1,"2"));
			break;
			case 3:
				jugadores.add(new Jugador(b1,"1"));
				jugadores.add(new Jugador(b1,"2"));
				jugadores.add(new Jugador(b1,"3"));
			break;
			case 4:
				jugadores.add(new Jugador(b1,"1"));
				jugadores.add(new Jugador(b1,"2"));
				jugadores.add(new Jugador(b1,"3"));
				jugadores.add(new Jugador(b1,"4"));
			break;
		}
		int k=0;
		while(b1.cartas.get(k).getValor()>9){
			k++;
		}
		Tablero tab=new Tablero(b1.cartas.get(k));
		b1.cartas.remove(k);
		int index=0, aux;
		
		while(bandera){
			aux=jugadores.get(index).tirarCarta(tab,b1);
			if(aux==0)	
				{if(jugadores.get(index).getMano().size()<1){
					bandera=false;
				}
				index++;}
			else
				if(aux==1){
					if(jugadores.get(index).getMano().size()<1){
						bandera=false;
					}
					index+=2;}
				else
					if(aux==2){
						if(index!=0)
							index=jugarReversa(jugadores,index-1,numJugadores,tab,b1)+1;
						else
							index=jugarReversa(jugadores,numJugadores-1,numJugadores,tab,b1)+1;
					}else
						if(aux==3){
							if(index!=numJugadores-1){
							jugadores.get(index+1).getMano().add(b1.cartas.get(0));
							b1.cartas.remove(0);
							jugadores.get(index+1).getMano().add(b1.cartas.get(0));
							b1.cartas.remove(0);

							}else{
							jugadores.get(0).getMano().add(b1.cartas.get(0));
							b1.cartas.remove(0);
							jugadores.get(0).getMano().add(b1.cartas.get(0));
							b1.cartas.remove(0);
							}
							if(jugadores.get(index).getMano().size()<1){
								bandera=false;
							}
							index+=2;}
						else
							if(aux==4){
								if(jugadores.get(index).getMano().size()<1){
									bandera=false;
								}
								index++;}
							else{
								if(index!=numJugadores-1){
									for(int i=0;i<4;i++){
									jugadores.get(index+1).getMano().add(b1.cartas.get(0));
									b1.cartas.remove(0);
									}
								}else{
									for(int i=0;i<4;i++){
									jugadores.get(0).getMano().add(b1.cartas.get(0));
									b1.cartas.remove(0);
									}
								}

								if(jugadores.get(index).getMano().size()<1){
									bandera=false;
								}
								index+=2;
							}
						if(index==numJugadores)
							index=0;
						else
							if(index==numJugadores+1)
								index=1;
						
		}
		System.out.println("------------"+jugadores.get(index).getNombre()+" gana!!!!");
	}

	static int jugarReversa(ArrayList<Jugador> jugadores, int index, int numJugadores, Tablero tab, Baraja b1){
			int aux;
			boolean bandera=true;
			while(bandera){
			aux=jugadores.get(index).tirarCarta(tab,b1);
			if(aux==0){	
				if(jugadores.get(index).getMano().size()<1){
					bandera=false;
				}
				index--;}
			else
				if(aux==1){
					if(jugadores.get(index).getMano().size()<1){
						bandera=false;
					}
					index-=2;}
				else
					if(aux==2)
						break;
					else
						if(aux==3){
							if(jugadores.get(index).getMano().size()<1){
								bandera=false;
							}
							if(index!=0){
							jugadores.get(index-1).getMano().add(b1.cartas.get(0));
							b1.cartas.remove(0);
							jugadores.get(index-1).getMano().add(b1.cartas.get(0));
							b1.cartas.remove(0);
							}
							else{
							jugadores.get(numJugadores-1).getMano().add(b1.cartas.get(0));
							b1.cartas.remove(0);
							jugadores.get(numJugadores-1).getMano().add(b1.cartas.get(0));
							b1.cartas.remove(0);
							}
							
							index-=2;}
						else
							if(aux==4){
								if(jugadores.get(index).getMano().size()<1){
									bandera=false;
								}
								index--;
							}
							else{
								if(index!=0){
									for(int i=0;i<4;i++){
									jugadores.get(index-1).getMano().add(b1.cartas.get(0));
									b1.cartas.remove(0);
									}
								}else{
									for(int i=0;i<4;i++){
									jugadores.get(numJugadores-1).getMano().add(b1.cartas.get(0));
									b1.cartas.remove(0);
									}
								}
								if(jugadores.get(index).getMano().size()<1){
									bandera=false;
								}
								index-=2 	;
							}
						if(index==-1)
							index=numJugadores-1;
						if(index==-2)
							index=numJugadores-2;
						else
							if(index==-20)
								index=numJugadores-2;
						
	}
	if(bandera=false)
		System.out.println("------------"+jugadores.get(index).getNombre()+" gana!!!!");
	return index;
}
}