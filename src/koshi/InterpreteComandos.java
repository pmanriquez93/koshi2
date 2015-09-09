//package koshi;
//
//public class InterpreteComandos {
//	
//	void ejecutarComando(Personaje per1, Personaje per2,char c)
//	{
//		
//		//En cada comando revisar si es valido el movimiento, revisando si el mapa lo permite
//		//O si los limites lo permiten
//		switch (c) {
//        case 'w':  
//        	//if (Mapa.movValido(per1,per1.getX(), per1.getY()-1))
//        		per1.mover(per1.getX(), per1.getY()-1);
//                 break;
//        case 'a':  per1.mover(per1.getX()-1, per1.getY());
//                 break;
//        case 's':  per1.mover(per1.getX(), per1.getY()+1);
//                 break;
//        case 'd':  per1.mover(per1.getX()+1, per1.getY());
//                 break;
//        case 'i':  per2.mover(per2.getX(), per2.getY()-1);
//                 break;
//        case 'j':  per2.mover(per2.getX()-1, per2.getY());
//                 break;
//        case 'k':  per2.mover(per2.getX(), per2.getY()+1);
//                 break;
//        case 'l':  per2.mover(per2.getX()+1, per2.getY());
//                 break;
//        case 'e':  accionEspecial();
//        	break;
//        case 'o':  accionEspecial();
//        	break;
//		}
//		
//		
//	}
//	
//	void accionEspecial()
//	{
//		
//	}
//	
//	void accionSalir(boolean newgame)
//	{
//		String seguro;
//		System.out.print("Seguro que deseas salir? (s/n) ");
//		//System.read(seguro);
////	    if (seguro == "s") {
////	        newgame=false;
////	    }
//		
//	}
//
//}
