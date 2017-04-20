import java.util.ArrayList;

public class Baraja{
	ArrayList<Carta> cartas;
	int[][] matriz = {{1,2,3,4},{4,3,2,1},{2,3,4,1},{1,4,3,2},{3,1,4,2},{4,1,2,3},{4,2,1,3},{2,4,1,3},{3,2,1,4}};
	private int [] arreglo={3,2,6,9,8,7,4,5,1};

	public Baraja(){
		cartas= new ArrayList<Carta>();
		cartas.add(new Carta("Rojo",0));		
		this.generaBaraja();
		this.generaCeros();
		cartas.add(new Carta("Amarillo",0));	
	}

	public void generaBaraja(){
		cartas.add(new Carta("Ninguno",13));
		for(int i=0;i<4;i++){
			for(int j=0;j<9;j++){
				switch (matriz[j][i]){
					case 1:
						cartas.add(new Carta("Rojo",arreglo[j]));
					break;
					case 2:
						cartas.add(new Carta("Azul",arreglo[j]));
					break;
					case 3:
						cartas.add(new Carta("Verde",arreglo[j]));
					break;
					case 4:
						cartas.add(new Carta("Amarillo",arreglo[j]));
					break;
				}//while
				if(j==1){	cartas.add(new Carta("Ninguno",10));}
				if(j==4){	cartas.add(new Carta("Ninguno",11));} 
				if(j==7){	cartas.add(new Carta("Ninguno",12));}
			} //for j
			if(i==1){cartas.add(new Carta("Ninguno",14));}
			if(i==3){	cartas.add(new Carta("Ninguno",13));}
		}//for i
		cartas.add(new Carta("Ninguno",14));
	}//funcion
	
	public void generaCeros(){		
				cartas.add(new Carta("Azul",0));
				this.generaBaraja();
				cartas.add(new Carta("Verde",0));
	}

	public void imprimeBaraja(){
		System.out.println(cartas.size());
		for (Carta c :  cartas ) {
			System.out.println(c.getCara());
			
		}
	}

	public ArrayList<Carta> getBaraja(){
		return cartas;
	}

}