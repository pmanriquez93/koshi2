package koshi;

public class Celda {
	char tipo;
	
	public Celda() {
		this.tipo = 0;		
	}
	
	public Celda(char tipo) {
		this.tipo = tipo;
	}
	
	public Celda(Celda celda) {
		this.tipo = celda.tipo;
	}
	
	public int tipoCelda() //para saber lo que hay en la celda
	{
		/*Se retorna un n�mero segun lo que haya en esa celda
		/* si es 1 camino vac�o para koshi,
		 * si es 2 camino vac�o para mono
		 * si es 3 roca
		 * si es 4 roca gigante
		 * si es 5 Agua
		 * si es 6 ...
		 * si es 7 ...
		 * si es 8 ...
		 * si es 9 ...
		 */
		if(tipo=='S') return 1; //camino koshi
		if(tipo=='B') return 2; //camino mono
		if(tipo=='R') return 3; //rio
		if(tipo=='C') return 4; //piedra impasable
		if(tipo=='P') return 5; //roca gigante
		if(tipo=='E') return 6; //enemigo
		if(tipo=='T') return 7; //terreno trigger
		if(tipo=='Y') return 8; //objeto de apoyo
		return 0;
	}
	
	public char getTipo() { //para saber que caracter hay en la celda y poder imprimir el mapa
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	
	
	

}
