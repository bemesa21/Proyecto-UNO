import java.util.ArrayList;
import java.util.Collections;

public class Baraja{
	static ArrayList<Carta> cartas;
	int numCartas;

	public Baraja(){
		cartas= new ArrayList<Carta>();
		int j=0;
		while (j<2){
			for(int i=1;i<=9;i++){
				cartas.add(new Carta("Rojo",i));
				cartas.add(new Carta("Azul",i));
				cartas.add(new Carta("Verde",i));
				cartas.add(new Carta("Amarillo",i));
			}
			j++;
		}
		for(int i=0;i<4;i++){
			cartas.add(new Carta("Ninguno",13));
			cartas.add(new Carta("Ninguno",14));
		}
		for(int i=0;i<8;i++){
			cartas.add(new Carta("Ninguno",10));
			cartas.add(new Carta("Ninguno",11));
			cartas.add(new Carta("Ninguno",12));
		}
		cartas.add(new Carta("Rojo",0));
		cartas.add(new Carta("Azul",0));
		cartas.add(new Carta("Verde",0));
		cartas.add(new Carta("Amarillo",0));

		Collections.shuffle(cartas);
		numCartas=cartas.size();
	}

	public void imprimeBaraja(){
		int contador=0;
		System.out.println(cartas.size());
		for (Carta c :  cartas ) {
			System.out.println(c.getCara());
			contador ++;
		}

		System.out.println(contador);
	}

	public ArrayList<Carta> getBaraja(){
		return cartas;
	}

}