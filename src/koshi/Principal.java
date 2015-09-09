package koshi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Principal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		Juego jueguito = new Juego();
//		
//		jueguito.jugar();
//		
		Personaje per1 = new Personaje();
		Personaje per2 = new Personaje();
		//InterpreteComandos interprete= new InterpreteComandos();
		Renderizador dibujador= new Renderizador();
		Mapa[] mapas = new Mapa[2];
		GestorMapas gestor = new GestorMapas();
		
		mapas[0]=gestor.crearMapa(2);
		
		//jueguito.mostrarPantallaHistoria(1);
		
		//jueguito.mostrarPantallaHistoria(2);
		
		per1.setPos(0, 0);
		per2.setPos(2, 2);
		String linea;
		
				dibujador.DibujaP(mapas[0],'Z', per1,per2, 5,21 );				
				
				while(true){
					System.out.println("Ingrese el siguiente movimiento: ");
					
					int con= jueguito.InterpretarComando(per1.getPos(),per2.getPos());
					dibujador.DibujaP(mapas[0],'Z',per1,per2,5,5);  
				}
//				System.out.println("Ingrese el siguiente movimiento: ");
//				con= jueguito.InterpretarComando(per1.getPos(),per2.getPos());
//				dibujador.DibujaP(mapas[0],'Z',per1,per2,5,2);

//				int d;
//				d=System.in.read();
//				System.out.println("");
////				nivel1char[per.getX()][per.getY()]='e';
//				interprete.ejecutarComando(per1,per2, (char)d);
//				dibujador.DibujaP(nivel1char,'Z',per1, per2, 5,21 );
//			
//				
//				System.out.println("Ingrese el siguiente movimiento: ");
//				d=System.in.read();
//				System.out.println("");
//				interprete.ejecutarComando(per1,per2, (char)d);
//				dibujador.DibujaP(nivel1char,'Z',per1, per2, 5,21 );
//				
//				System.out.println("Ingrese el siguiente movimiento: ");
//				d=System.in.read();
//				System.out.println("");
//				interprete.ejecutarComando(per1,per2, (char)d);
//				dibujador.DibujaP(nivel1char,'Z',per1, per2, 5,21 );
//				
//				System.out.println("Ingrese el siguiente movimiento: ");
//				d=System.in.read();
//				System.out.println("");
//				interprete.ejecutarComando(per1,per2, (char)d);
//				dibujador.DibujaP(nivel1char,'Z',per1, per2, 5,21 );
//		
//		try{
//			InputStream f = new FileInputStream(new File("arch.txt"));
//			//if(f.exists()){
//				BufferedReader reader = new BufferedReader(new InputStreamReader(f));
//		        StringBuilder out = new StringBuilder();
//		        String line;
//		        while ((line = reader.readLine()) != null) {
//		            out.append(line);
//		        }
//		        System.out.println(out.toString());   //Prints the string content read from input stream
//		        reader.close();
//				
//			//}
//		}catch(Exception e){
//			System.out.println(e.getMessage());
//		}
//		
//		char escCode = 0x1B;
//		int row = 20; int column = 5;
//		//System.out.print(String.format("%c[%d;%df",escCode,row,column));
//		System.out.print("\033[" + column + ";" + row + "H");

//	Plano2D plano =new Plano2D(5,5);
//	System.out.println(plano.getX()+" "+plano.getY());
//	Plano2D plano2 =new Plano2D(plano);
//	System.out.println(plano2.getX()+" "+plano2.getY());
//	Personaje juani =new Personaje("juani",true);
//	juani.setPos(10, 20);
//	Plano2D plano3 = juani.getPos();
//	System.out.println(plano3.getX()+" "+plano3.getY());
//		
	}

}
