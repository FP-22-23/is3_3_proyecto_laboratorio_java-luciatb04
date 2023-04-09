package fp.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import fp.cine.Pelicula;
import fp.cine.PeliculasFactoria;
import fp.cine.Peliculass;
import fp.common.Formato;
import fp.common.Horario;

public class PeliculassTest {
	
	
	public static void main(String[] args) {
		List<Pelicula> peliculaFacto = new ArrayList<>();
		peliculaFacto.addAll(PeliculasFactoria.leerPelicula("./data/peliculasdataset.csv"));
		//Peliculass contenedor = new Peliculass(peliculaFacto);
		PeliculassTest.testContenedor(peliculaFacto);
		
		List<Pelicula> lista = PeliculasFactoria.leerPelicula("./data/peliculasdataset.csv");
		Peliculass cine = new Peliculass();
		for(Integer i=0; i<lista.size(); i++) {
			cine.añadirAud(lista.get(i));
			//System.out.println(cine);
			
		}
		Horario horario = new Horario (LocalDate.of(2015, 03, 06), LocalTime.of(21, 04, 53));
		List<String> efectos= new ArrayList<String>(Arrays.asList("Opticos", "Maquillaje"));
		
		Pelicula aud1= new Pelicula(Formato.MOVIE, "Musical", 49, "Korean", 159, true, 2.3, 
				efectos, LocalDateTime.of(2015, 06, 23, 11, 00, 20 ), horario);
		
		Pelicula aud2= new Pelicula(Formato.MOVIE, "Kids", 89, "Spanish", 322, true, 7.3, 
				efectos, LocalDateTime.of(2017, 10, 13, 21, 00, 20 ), horario);
		
		Pelicula aud3= new Pelicula(Formato.TV, "Action and Adventure", 194, "Tagalog", 402, false, 6.2, 
				efectos, LocalDateTime.of(1998, 07, 03, 00, 10, 40 ), horario);
		
		Peliculass contenedor1 = new Peliculass();
		
		//añadir
		
		contenedor1.añadirAud(aud3);
		contenedor1.añadirAud(aud1);
		contenedor1.añadirAud(aud2);
		System.out.println("los tres medios audivisuales: \n" + contenedor1);
		
		//eliminar
		contenedor1.eliminarAud(aud3);
		contenedor1.eliminarAud(aud2);
		System.out.println("Los medios audivisuales ya eliminados: \n" + contenedor1);
		
		//tamaño 
		System.out.println("El tamaño de la lista es: \n" + cine.getTamaño());
		
		System.out.println("¿existen peliculas las cuales el genero sea 'Kid' y el idioma 'English'? \n  "+cine.existePeliculaGeneroIdioma("Kids", "English"));
		System.out.println("¿cuantas peliculas existen que tengan el idioma en 'Spanish'? \n"+cine.getNumeroPeliculaIdioma("Spanish"));
		System.out.println("Se mostrara en pantalla los datos de las peliculas/series con el id= 23 \n "+cine.filtradoPeliculaId(23));
		System.out.println("Se mostrara en pantalla un conjunto con todos los id de los dsitintos generos\n "+cine.getListaIdPorGenero());
		
	}
	private static void testContenedor(List<Pelicula> pelicula) {
		
		
		}

	}


