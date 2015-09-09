package koshi;

public class Personaje {
	
	
	//Atributes
	int maxVida;
	int vidaActual;
	private Plano2D pos=new Plano2D(0,0);
	String nombre;
	
	
	public Personaje(){
		/*constructor para que no haya problemas con el principal*/
	}
	public Personaje(String nombre,boolean koshi){
		this.nombre=nombre;
		if(koshi){
			/*El personaje aun no es diferente entre koshi
			 * y el mono. Se debe agregar dado a que cada uno
			 * posee una lista de acciones distinas*/
			this.vidaActual=250;
			this.maxVida=250;
		}
		else{
			this.vidaActual=150;
			this.maxVida=150;
		}		
	}
	//Setters n Getters
	public int getMaxVida() {
		return maxVida;
	}
	public void setMaxVida(int maxVida) {
		this.maxVida = maxVida;
	}
	public int getVidaActual() {
		return vidaActual;
	}
	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}
	public int getX() {
		return pos.getX();
	}

	public int getY() {
		return pos.getY();
	}

	public Plano2D getPos() {
		return pos;
	}
	public void setPos(int x,int y){
		this.pos.setX(x);
		this.pos.setY(y);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Methods
	//public void mover(int x,int y){
	//    if(this.getX() != x)
	//        this.setX(x);
	//    if(this.getY() != y)
	//        this.setY(y);
	//}
	

}
