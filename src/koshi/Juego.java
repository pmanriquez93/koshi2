package koshi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
	
	private Mapa mapaActual;
	private static final int numNiveles = 4;
	
	
	
	public void jugar() throws IOException{
		/*Variables:*/
		boolean newGame=true;
		Personaje personaje1=new Personaje();
		Personaje personaje2=new Personaje();
		
		
		
		
		
		
		
		
		while(newGame){
			//newGame=showStarScreen()
			/*En esta función se mostrara una pequeña intro
			 * del juego en donde el jugador podrá saltarlo
			 * presionando enter, posteriormente aparecera 2 opciones
			 * una si desea un nuevo juego y otra si desea salir */
			if(!newGame) {
				//showEndScreenLoser();
				/*mostrara la pantalla de rendición*/
				continue;
			}
			//Para el primer laboratorio solo se tomará
			//como multiplayer siempre
			boolean onePlayer=false;
			//onePlayer=escogerMultijugador();
			/*Se le preguntará al jugador si será multiplayer o no*/
			if(onePlayer){
				boolean koshi=true;
				koshi=escogerJugador();
				/*Solo en caso de jugar en modo solo, el
				 * jugador será capaz de escoger entre koshi
				 * y el mono
				 */
				String name= escogerNombre();
				/*Aparecera una pantalla en donde el jugador
				 * debera escribir el nombre, puede ser 
				 * método pokemon, letra por letra.
				 */					
				Personaje personajeSolo = new Personaje(name,koshi);
				/* Aqui se llamará al creador de personaje, 
				 * se pasara como parámetros el nombre y un boolean que
				 * si es verdadero se creará el personaje de koshi o falso el 
				 * personaje del mono
				 */
			}
			else{
				String name1 = escogerNombre();
				String name2 = escogerNombre();
				personaje1 = new Personaje(name1,true);
				personaje2 = new Personaje(name2,false);
			}
			//showHistoryScreen1();	
			GestorMapas gestor = new GestorMapas();
			Renderizador ren = new Renderizador();
			ArrayList<Mapa> mapas=new ArrayList<Mapa>();
			for(int i=0;i<numNiveles;i++){
				mapas.add(new Mapa(gestor.crearMapa(i)));
			}
			int start=0;
			mapaActual=new Mapa(mapas.get(start));
			while(start!=mapas.size()){
				ren.DibujaP(mapaActual);
				int suceso=Movimiento(personaje1,personaje2);
				if(suceso==1) continue; //solo movimiento
				else if(suceso==2) { //no se paso el nivel
					//mostrarPantallaGameOver
					break;
				}
				else if(suceso==3){//se avanzó al siguiente nivel
					start++;
					if(start>=mapas.size()) continue;
					mapaActual=new Mapa(mapas.get(start));
					//actualizarPosicionPersonajes
				}
				
			}
			if(start>=mapas.size()){
				newGame=false; //se gano el juego
				//mostrarPantallaVictoria
			}
		}
		//Mostrar PantallaSalir
	}
	public boolean escogerMultijugador(){
		System.out.println("Un Jugador (O)");
		System.out.println("MultiJugador(M)");
		int c = 0;
		try {
			c=System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(c!=0){
			char d =(char)c;
			if(d=='o' || d=='O') return true;
			else return false;
		}
		return false;	
	}
	public boolean escogerJugador(){
		System.out.println("Escoger a koshi (K)");
		System.out.println("Escoger a mono  (M)");
		int c = 0;
		try {
			c=System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(c!=0){
			char d =(char)c;
			if(d=='k' || d=='K') return true;
			else return false;
		}
		return false;
	}
	public String escogerNombre(){
		System.out.println("Escoja el nombre de su personaje");
		Scanner name = new Scanner(System.in);
		String nombre = name.nextLine();
		name.close();
		return nombre;
	}
	
	/*Metodo aún no terminado*/
	public int Movimiento(Personaje p1, Personaje p2) throws IOException{
		Plano2D plano1 = new Plano2D(p1.getPos());
		Plano2D plano2 = new Plano2D(p2.getPos());
		Plano2D plano1Aux = new Plano2D(plano1);
		Plano2D plano2Aux = new Plano2D(plano1);
		
		int retorno=0;
		int eleccion=InterpretarComando(plano1Aux,plano2Aux);
		if(eleccion==1)/*solo movimiento de personaje1*/{
			char tipo=this.mapaActual.mapaValores[plano1Aux.getX()][plano1Aux.getY()].getTipo();
			switch(tipo){
			case 'p': //se encontro con una piedra, no puede avanzar
				retorno=1; //por tanto no se actualiza su posicion
				break;
			case 'S': //se encontró con un espacio libre valido
				retorno=1; //por tanto se actualiza su posicion
				p1.setPos(plano1Aux.getX(), plano1Aux.getY());
				break;
			}


		}
		return retorno; //retorno significa que sucedió al mover el personaje	
	}
	public int InterpretarComando(Plano2D plano1Aux,Plano2D plano2Aux) throws IOException{
		
		//En cada comando revisar si es valido el movimiento, revisando si el mapa lo permite
		//O si los limites lo permiten
		int d=0, condicion =0;
		
		BufferedReader buffer = new BufferedReader(
                new InputStreamReader(System.in));
		
		d=buffer.read();
		
		char c =(char)d;
		switch (c) { //en este caso X e Y son los ejes y no fila y columna?
        case 'w':  //arriba
        		plano1Aux.setY(plano1Aux.getY()-1);
        		condicion=1; //solo movimiento personaje1
                 break;
        case 'a':  //izquierda
        		plano1Aux.setX(plano1Aux.getX()-1);
        		condicion=1;//solo movimiento
                 break;
        case 's'://abajo
        		plano1Aux.setY(plano1Aux.getY()+1);
        		condicion=1;//solo movimiento
                 break;
        case 'd': //derecha
        		plano1Aux.setX(plano1Aux.getX()+1);
        		condicion=1;//solo movimiento
                 break;
        case 'i'://arriba
        		plano2Aux.setY(plano2Aux.getY()-1);
        		condicion=2;//solo movimiento personaje2
                 break;
        case 'j':  //abajo
    			plano2Aux.setX(plano2Aux.getX()-1);
    			condicion=2;//solo movimiento
                 break;
        case 'k':  //izquierda
        		plano2Aux.setY(plano2Aux.getY()+1);
        		condicion=2;
                 break;
        case 'l':  //derecha
    			plano2Aux.setX(plano2Aux.getX()+1);
    			condicion=2;//solo movimiento
                 break;
        case 'e':  
        	//accionEspecial();
        	break;
        case 'o':  
        	//accionEspecial();
        	break;
		}
		return condicion;		
	}
	
	public void MostrarPantallaHistoria(int nivel)  throws IOException
	{
		String fileName = "historias/historia" + nivel + ".txt";
		FileReader file = new FileReader(fileName);
		
		int valor = 0;		
		for (int i = 0; i < 20; i++){
			for (int j = 0; j <67; j++){
				valor = file.read();
				char aux = (char)valor;
				System.out.print(aux);				
			}			
		}
		System.out.println("");
	}
	
	public void MenuInicial() throws IOException
	{
		String fileName = "historias/inicial.txt";
		FileReader file = new FileReader(fileName);	
		
		int valor = 0;
		for (int i = 0; i < 20; i++){
			for (int j = 0; j < 67; j++){
				valor = file.read();
				char aux = (char)valor;
				System.out.print(aux);
			}
		}
		System.out.println("");
		
	}

	public void MostrarPantallaRendicion() throws IOException
	{
		String fileName = "historias/rendicion.txt";
		FileReader file = new FileReader(fileName);	
		
		int valor = 0;
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 64; j++){
				valor = file.read();
				char aux = (char)valor;
				System.out.print(aux);
			}
		}
		System.out.println("");		
	}
	
	public void MostrarGameOver() throws IOException
	{
		String fileName = "historias/gameover.txt";
		FileReader file = new FileReader(fileName);	
		
		int valor = 0;
		for (int i = 0; i < 24; i++){
			for (int j = 0; j < 37; j++){
				valor = file.read();
				char aux = (char)valor;
				System.out.print(aux);
			}
		}
		System.out.println("");	
	}
	
	public void MostrarPantallaVictoria() throws IOException
	{
		String fileName = "historias/victoria.txt";
		FileReader file = new FileReader(fileName);	
		
		int valor = 0;
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 50; j++){
				valor = file.read();
				char aux = (char)valor;
				System.out.print(aux);
			}
		}
		System.out.println("");	
	}
	
	public void MostrarPantallaSalir() throws IOException
	{
		String fileName = "historias/salir.txt";
		FileReader file = new FileReader(fileName);	
		
		int valor = 0;
		for (int i = 0; i < 14; i++){
			for (int j = 0; j < 68; j++){
				valor = file.read();
				char aux = (char)valor;
				System.out.print(aux);
			}
		}
		System.out.println("");	
	}
}