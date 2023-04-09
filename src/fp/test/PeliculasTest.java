package fp.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fp.cine.Pelicula;
import fp.common.Formato;
import fp.common.Horario;

public class PeliculasTest {

	public static void main(String[] args) {
		//--------------------TEST DE LOS CONSTRUCTORES-----------------
	
		Horario horario = new Horario (LocalDate.of(2015, 03, 06), LocalTime.of(21, 04, 53));
		List<String> efectos= new ArrayList<String>(Arrays.asList("Opticos", "Sonido"));
		Pelicula p1 = new Pelicula (Formato.TV, "Drama", 65, "English", 32, true, 7.2,  efectos, LocalDateTime.of(2012, 01, 30, 12, 19,00), horario);
		Pelicula p2 = new Pelicula(Formato.TV, "Comedia", 259, "Spanish", 58, false, 1.5, efectos, LocalDateTime.of(1999,6, 30, 10, 10, 20), null ) ;

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
