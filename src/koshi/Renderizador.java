package koshi;

public class Renderizador {

	//Atributes
	private int A;
	private int B;
	
	//Methods
	public Renderizador(){
		this.A = 5;
		this.B = 5;
	}
	
	public Renderizador(Renderizador orig){
		this.A = orig.A;
		this.B = orig.B;
	}

	public void DibujaP(Mapa mat,char p,Personaje per1,Personaje per2,int limFil, int limCol){
//		int p1x=per1.getX(); 
//		int p1y=per1.getY();
//		int p2x=per2.getX();
//		int p2y=per2.getY();
		
		int p1x=per1.getPos().getX(); 
		int p1y=per1.getPos().getY();
		int p2x=per2.getPos().getX();
		int p2y=per2.getPos().getY();
		
		int iniFil = p1x - this.B;
		int iniCol = p1y - this.A;
		int finFil = p1x + this.B;
		int finCol = p1y + this.A;
		if ((p1x - this.B) < 0) iniFil = 0;
		if ((p1x + this.B) > limFil) finFil = limFil;
		if ((p1y - this.A) < 0) iniCol = 0;
		if ((p1y + this.A) > limCol) finCol = limCol;
		for(int i = iniFil; i <= finFil; i++){
			for (int j = iniCol; j <= finCol; j++){
				if (i == p1y && j == p1x)
					System.out.print(p);
				else System.out.print(mat.mapaValores[i][j].getTipo());
			}			
			System.out.println("");
		}
		
		
	}
	/*Hacer lo mismo que la anterior función pero pasando el mapa*/
	public void DibujaP(Mapa mapaActual){
		
	}
	
	//public void Dibuja(Personaje heroe,int limFil,int limCol,Mapa map){
	//}
	
	//Setters & Getters
	public int getA() {
		return A;
	}

	public void setA(int a) {
		A = a;
	}

	public int getB() {
		return B;
	}

	public void setB(int b) {
		B = b;
	}
}
