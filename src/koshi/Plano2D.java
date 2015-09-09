package koshi;

public class Plano2D {
	/*Cree esta clase dado a que a veces es necesario
	 * modificar dos par�metros en una misma llamada
	 * a la funci�n, como ser�a en c++ pasarlos por referencia,
	 * pero en Java no existe par�metros por referencia, por tanto
	 * cree Plano2D que en verdad es un contenedor que permite
	 * que var�es X y y en un mismo llamado
	 */
	private int ejeX;
	private int ejeY;
	
	public Plano2D(int ejeX,int ejeY){
		this.ejeX=ejeX;
		this.ejeY=ejeY;
	}
	public Plano2D(Plano2D copy){
		this.ejeX=copy.ejeX;
		this.ejeY=copy.ejeY;
	}
	public void setX(int x){
		this.ejeX=x;
	}
	public void setY(int y){
		this.ejeY=y;
	}
	public int getX(){
		return this.ejeX;
	}
	public int getY(){
		return this.ejeY;
	}
}
