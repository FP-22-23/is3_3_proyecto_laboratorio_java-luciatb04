package fp.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import fp.common.Formato;
import fp.common.Peliculas;

public class PeliculasTest {

	public static void main(String[] args) {
		//--------------------TEST DE LOS CONSTRUCTORES-----------------
		
		ArrayList<String> efectos= new ArrayList<String>(Arrays.asList("Opticos", "Sonido"));
		Peliculas p1 = new Peliculas (Formato.TV, "Drama", "English", 3, 56, true, LocalTime.of(14, 8, 26), 7.2, LocalDate.of(2015, 02, 04), efectos );
		Peliculas p2 = new Peliculas(Formato.TV, "Comedia", "Spanish", 5, null, false, LocalTime.of(4, 17, 54), 1.5, null, efectos ) ;

		System.out.println("\n--------------------PRUEBA CONSTRUCTORES-------------------------------");
		System.out.println(p1);
		System.out.println(p2);
		
		
		//------------------TEST DEL EQUALS Y HASHCODE----------------------
		System.out.println("\n--------------------TEST EQUALS-----------------------");
		System.out.println("\t¿la primera serie y la segunda son iguales?: "+p1.equals(p2));
		
		//----------------TEST DE LA PROPIEDAD DERIVADA----------------------
		System.out.println("\n--------------------TEST RPOPIEDAD DERIVADA-----------------");
		System.out.println("\tel siglo de la primera pelicula es: "+ p1.getSiglo());
	
	
		//----------------TEST DEL ORDEN NATURAL--------------------------------
		System.out.println("\n----------------------TEST DE COMPARETO----------------------");
		System.out.println("\tComprobamos el orden natural de la primera y segunda pelicula: "+p1.compareTo(p2));
	
	
	
	}
	

	
	
	
	


	}
