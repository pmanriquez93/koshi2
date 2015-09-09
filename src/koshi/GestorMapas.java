package koshi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GestorMapas {
	
	public GestorMapas(){
		
	}
	
	public Mapa crearMapa(int nivel) throws IOException{
		Mapa mapa = new Mapa(nivel);
		
		String fileName = "mapas/arch" + nivel + ".txt";
		FileReader file = new FileReader(fileName);
		//BufferedReader buffer = new BufferedReader(file);
		
		int valor = 0;		
		for (int i = 0; i < mapa.filas; i++){
			for (int j = 0; j < mapa.columnas; j++){
				valor = file.read();
				char aux = (char)valor;
				Celda c = new Celda(aux);
				mapa.mapaValores[i][j] = c;
			}
		}
		return mapa;
	}
}