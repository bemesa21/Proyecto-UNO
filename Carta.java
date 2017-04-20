public class Carta{
	private String color;
	private int valor;
	private String cara;

	public Carta(String color, int valor){
		this.color=color;
		this.valor=valor;
	}

	public String getColor(){
		return color;
	}

	public int getValor(){
		return valor;
	}

	public String getCara(){
		cara = "[";
		if( color != "Ninguno")
		{
			cara += this.color + " ";
		}

		switch(this.valor)
		{
			case 10: cara += "Saltar Turno";
				break;
			case 11: cara += "Reversa";
				break;
			case 12: cara += "Roba 2";
				break;
			case 13: cara += "Comodin";
				break;
			case 14: cara += "Comodin roba 4";
				break;
			default: cara += String.valueOf(this.valor);
		}
		cara += "]";
		return cara;
	}
}