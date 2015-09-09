package koshi;

public class Mapa {
	static final int filas = 16;
	static final int columnas = 12;
	int nivel;
	
	public Celda[][] mapaValores = new Celda[filas][columnas];

	
	public Mapa(int nivel) {
		this.nivel = nivel;
	}
	
	public Mapa(Mapa mapa) {
		this.nivel = mapa.nivel;
		for (int i = 0; i < this.filas; i++){
			for (int j = 0; j < this.columnas; j++){
				this.mapaValores[i][j]=mapa.mapaValores[i][j];
			}
		}
	}
	
	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public Celda[][] getMapa() {
		return mapaValores;
	}

	public void setMapa(Celda[][] mapa) {
		this.mapaValores = mapa;
	}
	
	public void imprimirMapa(Celda[][] mapa){
		for (int i = 0; i < this.filas; i++){
			for (int j = 0; j < this.columnas; j++){
				System.out.print(mapa[i][j]);
			}
			System.out.println();
		}
	}
	public  boolean movValido(Personaje per,int x,int y){
		if(x>0 &&(x<this.filas) && y>0 && (y<this.columnas)){
			if(this.mapaValores[x][y].getTipo()=='S' || this.mapaValores[x][y].getTipo()=='S')
				return true;
		}
		return true;
	}
}
