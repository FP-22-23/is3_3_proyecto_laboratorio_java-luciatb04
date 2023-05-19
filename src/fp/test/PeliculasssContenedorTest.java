package fp.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fp.cine.Pelicula;
import fp.cine.PeliculasFactoria;
import fp.cine.PeliculasssContenedor;
import fp.common.Formato;
import fp.common.Horario;

public class PeliculasssContenedorTest {
	

	public static void main(String[] args) {
		List<Pelicula> peliculaFacto = new ArrayList<>();
		peliculaFacto.addAll(PeliculasFactoria.leerPelicula("./data/peliculasdataset.csv"));
		//Peliculass contenedor = new Peliculass(peliculaFacto);
		PeliculasssContenedorTest.testContenedor(peliculaFacto);
		
		List<Pelicula> lista = PeliculasFactoria.leerPelicula("./data/peliculasdataset.csv");
		PeliculasssContenedor cine = new PeliculasssContenedor();
		for(Integer i=0; i<lista.size(); i++) {
			cine.añadirAud(lista.get(i));
			//System.out.println(cine);
			
		}	
			
		PeliculasssContenedor audivisual = PeliculasFactoria.leerPeliculasStream("./data/peliculasdataset.csv");
		
		
		Horario horario = new Horario (LocalDate.of(2015, 03, 06), LocalTime.of(21, 04, 53));
		List<String> efectos= new ArrayList<String>(Arrays.asList("Opticos", "Maquillaje"));
		
		Pelicula aud1= new Pelicula(Formato.MOVIE, "Musical", 49, "Korean", 159, true, 2.3, 
				efectos, LocalDateTime.of(2015, 06, 23, 11, 00, 20 ), horario);
		
		Pelicula aud2= new Pelicula(Formato.MOVIE, "Kids", 89, "Spanish", 322, true, 7.3, 
				efectos, LocalDateTime.of(2017, 10, 13, 21, 00, 20 ), horario);
		
		Pelicula aud3= new Pelicula(Formato.TV, "Action and Adventure", 194, "Tagalog", 402, false, 6.2, 
				efectos, LocalDateTime.of(1998, 07, 03, 00, 10, 40 ), horario);
		
		PeliculasssContenedor contenedor1 = new PeliculasssContenedor();
		
		//añadir
		System.out.println("===================================================");
		contenedor1.añadirAud(aud3);
		contenedor1.añadirAud(aud1);
		contenedor1.añadirAud(aud2);
		System.out.println("los tres medios audivisuales: \n" + contenedor1);
		
		
		System.out.println("===================================================");
		//eliminar
		contenedor1.eliminarAud(aud3);
		contenedor1.eliminarAud(aud2);
		System.out.println("Los medios audivisuales ya eliminados: \n" + contenedor1);
		
		
		System.out.println("===================================================");
		//tamaño 
		System.out.println("El tamaño de la lista es: \n" + cine.getTamaño());
		
		//System.out.println("¿existen peliculas las cuales el genero sea 'Kid' y el idioma 'English'? \n  "+cine.existePeliculaGeneroIdioma("Kids", "English"));
		//System.out.println("¿cuantas peliculas existen que tengan el idioma en 'Spanish' en el año 2017? \n"+cine.getNumeroPeliculaIdiomaDeUnAño("Spanish",2017));
		//System.out.println("Se mostrara en pantalla los datos de solo las peliculas con el id= 23 \n "+cine.filtradoSoloPeliculaId(23, Formato.TV ));
		//System.out.println("Se mostrara en pantalla un conjunto con todos los id de los distintos generos\n "+cine.getListaIdPorGenero());
		//System.out.println("El total de peliculas que hay de un mismo genero: \n"+cine.getTotalDuracionPorGenero());
		//System.out.println("¿Existen peliculas las cuales el genero sea 'Musical' y el idioma 'Korean'?\n"+ cine.existePeliculaGeneroIdidomaStream("Musical", "Korean"));
		//System.out.println("Minutos de duracion total por el genero 'Kids' \n"+ cine.calcularMinutosTotalesPorGenero("Kids"));
		//System.out.println("Peliculas y/o series que duran entre los 35 y 45 min \n"+cine.peliculasEntreDosDuracionesDadas(45, 35));
		//System.out.println("Los datos de la pelicula o serie con mayor de los rankings de el idioma 'Japanese' \n"+cine.mejorRankingDeIdioma("Thai"));
		//System.out.println("¿Cuales son las 3 primeras peliculas con el mejor ranking de genero Kids \n "+cine.obtenerNPeliculasGeneroOrdenadosPorElRanking("Kids", 3));
		//System.out.println("mapa donde las claves son los distintos generos y los valores son los sets de los id\n" +cine.agruparIdPorGenero());
		//System.out.println("mapa con el peor ranking de cada idioma dependiendo del año dado"+cine.fechasConPeliculasConPeoresRankings(2013));
		//System.out.println("mapa"+cine.getSeriesTerminadasAcumuladasPorGenero());
		//System.out.println("mapa en donde se muestre el año el cual tenga la mayor cantidad de peliculas (solo peliculas) terminadas \n"+cine.getgetMayorPeliculasPorAñoTerminadas());
		
		System.out.println("===================================================\n");
		System.out.println("ENTREGA DOS\n");
		System.out.println("===================================================");
		testExistePeliculaGeneroIdioma(audivisual, "Kids", "Spanish");
		
		
		System.out.println("===================================================");
		testgetNumeroPeliculaIdiomaDeUnAño(audivisual, "English", 2015);
		
		
		System.out.println("===================================================");
		testfiltradoSoloPeliculaId(audivisual, 23, Formato.MOVIE);
		
		
		System.out.println("===================================================");
		testgetListaIdPorGenero(audivisual);
		
		
		System.out.println("===================================================");
		testGetTotalDuracionPorGenero(audivisual);
		
		System.out.println("===================================================\n");
		System.out.println("ENTREGA TRES\n");
		System.out.println("===================================================");
		testCalcularMinutosTotalesPorIdioma(audivisual, "Korean");
		
		System.out.println("===================================================");
		testExistePeliculaGeneroIdiomaStream(audivisual, "Thriller", "Korean");
		
		System.out.println("===================================================");
		//testPeliculasEntreDosDuracionesDadas(audivisual, 30, 25);
		
		System.out.println("===================================================");
		testGetSeriesListaEfectosConjuntoAños(audivisual);
		
		
		System.out.println("===================================================");
		testMejorRankingDeIdioma(audivisual, "Korean");
		
		System.out.println("===================================================");
		testObtenerNSeriesGeneroOrdenadosPorElRanking(audivisual, "Musical", 3);
		
		System.out.println("===================================================");
		testAgruparIdPorMes(audivisual);
		
		System.out.println("===================================================");
		testFechasConPeliculasConPeoresRankings(audivisual, 2015);
		
		System.out.println("===================================================");
		testGetSeriesTerminadasAcumuladasPorGenero(audivisual);
		
		System.out.println("===================================================");
		testGetMayorPeliculasPorAñoTerminadas(audivisual);
		
		
	}
	private static void testContenedor(List<Pelicula> pelicula) {
		
		
		}

	private static void testExistePeliculaGeneroIdioma(PeliculasssContenedor audivisual, String genero, String idioma) {
		System.out.println("\n TEST DEL CONSTRUCTOR EXISTE PELICULAS GENERO IDIOMA");
		try {
			System.out.println(String.format("existe alguna pelicula/serie que exista para el genero "+ genero + " y el idioma: "+idioma)+audivisual.existePeliculaGeneroIdioma(genero, idioma));
		}catch (Exception e){
			System.out.println("excepcion capturada: \n"+ e);
		}
	}
	
	
	
	
	private static void testgetNumeroPeliculaIdiomaDeUnAño(PeliculasssContenedor audivisual, String idioma, Integer año){
		System.out.println("\n TEST NUMERO DE PELICULAS TOTALES DEPDENDIENDO DE SU IDIOMA DE UN AÑO DETERMINADO");
		try{ 
			System.out.println(String.format("Cuantas peliculas/serie existen para el idioma "+ idioma+ "y el año " +año+":")+audivisual.getNumeroPeliculaIdiomaDeUnAño(idioma, año));
		}catch (Exception e) {
			System.out.println("exceocion capturada: \n " + e);
		}	
	}
	
	
	
	private static void testfiltradoSoloPeliculaId(PeliculasssContenedor audivisual, Integer id, Formato peli) {
		System.out.println("\n TEST DEL FILTRADO POR UN ID SOLO DE PELICULAS");
		try {
			System.out.println(String.format("Los datos de las peliculas por un id "+id+ " determinado :")+audivisual.filtradoSoloPeliculaId(id, peli));
		
		}catch (Exception e) {
			System.out.println("Excepcion capturada: \n" + e);
		}
	}

	
	private static void testgetListaIdPorGenero(PeliculasssContenedor audivisual) {
		System.out.println("\n TEST DE CONJUNTO ID POR GENERO");
		try {
			System.out.println("Se mostrara en pantalla un conjunto con todos los id de los distintos generos");
			imprimeMap(audivisual.getListaIdPorGenero());
		}catch (Exception e){
			System.out.println("Excepcion capturada: \n" + e);
		}
	}
	

	private static void testGetTotalDuracionPorGenero(PeliculasssContenedor audivisual) {
		System.out.println("\n TEST TOTAL DURACIÓN POR GENERO");
		try{
			System.out.println("Se mostrara un mapa con el genero como clave y la duracion como valor");
			imprimeMap(audivisual.getTotalDuracionPorGenero());
		}catch (Exception e) {
			System.out.println("Excepcion capturada: "+ e);
		}
	}
	
	private static void testCalcularMinutosTotalesPorIdioma(PeliculasssContenedor audivisual, String idioma) {
		System.out.println("\n TEST CALCULAR MINUTOS TOTALES POR IDIOMA");
		try {
			System.out.println(String.format("El total de la duracion del idioma "+ " es: \n", audivisual.calcularMinutosTotalesPorIdioma(idioma)));
		}catch (Exception e){
			System.out.println("Excepcion capturada: "+e);
		}
	}
	
	
	private static void testExistePeliculaGeneroIdiomaStream(PeliculasssContenedor audivisual, String genero, String idioma) {
		System.out.println("\n TEST EXISTE PELICULA GENERO E IDIOMA (STREAM)");
		try {
			System.out.println(String.format("¿existe alguna pelicula/serie para el idioma "+ idioma+ " y el genero "+ genero + "?\n"+ 
					audivisual.existePeliculaGeneroIdidomaStream(genero, idioma)));
		}catch(Exception e) {
			System.out.println("Excepcion capturada: "+ e);
		}
	}
	
	private static void testPeliculasEntreDosDuracionesDadas(PeliculasssContenedor audivisual, Integer max, Integer min ) {
		System.out.println("\n TEST CONJUNTO DE PELICULAS ENTRE DOS DURACIONES");
		try {
			System.out.println(String.format("este es el conjunto de peliculas y series que esten entre las dos duraciones "+max+" y "+min + audivisual.efectosEntreDosDuracionesDadas(max, min)));
		}catch(Exception e) {
			System.out.println("Excepcion capturada: "+ e);
		}
	}
	
	private static void testGetSeriesListaEfectosConjuntoAños(PeliculasssContenedor audivisual) {
		System.out.println("\n TEST EFECTOS ESPECIALES Y AÑOS");
		try {
			System.out.println("devuelve un mapa con la lista de efectos como las distintas claves y un conjunto de años de valor");
			imprimeMap(audivisual.getSeriesListaEfectosConjuntoAños());
			
		}catch(Exception e) {
			System.out.println("Excepcion capturada: "+ e);
		}
	}
	
	private static void testMejorRankingDeIdioma(PeliculasssContenedor audivisual, String idioma) {
		System.out.println("\n TEST MEJOR RANKING");
	try{
		System.out.println(String.format("este es el mejor ranking del idioma"+idioma+audivisual.mejorRankingAcabadaIidoma(idioma)));
	}catch(Exception e) {
		System.out.println("Excepcion capturada: "+ e);
	}}
	
	
	
	private static void testObtenerNSeriesGeneroOrdenadosPorElRanking(PeliculasssContenedor audivisual, String genero, Integer n) {
		System.out.println("\n TEST N MEJORES SERIES PUNTUADAS");
		try {
			System.out.println(String.format("se mostraran solo las "+n +" series mejores puntuadas del genero "+ genero+audivisual.obtenerNSeriesGeneroOrdenadosPorElRanking(genero, n)));
			
		}catch(Exception e) {
			System.out.println("Excepcion capturada: "+ e);
		}
	}
	
	private static void testAgruparIdPorMes(PeliculasssContenedor audivisual) {
		System.out.println("\n TEST AGRUPAR ID POR MESES");
		try {
			System.out.println("Se agruparan los meses y sus respectivos ids");
			imprimeMap(audivisual.agruparIdPorMes());
		}catch(Exception e) {
			System.out.println("Excepcion capturada: "+ e);
		}
	}
	
	private static void testFechasConPeliculasConPeoresRankings(PeliculasssContenedor audivisual, Integer año) {
		System.out.println("\n TEST PELICULAS CON PEORES RANKING");
		try {
			System.out.println("se agrupan los idiomas como claves y el peor ranking como valor del año especificado");
			imprimeMap(audivisual.fechasConPeliculasConPeoresRankings(año));
		}catch(Exception e) {
			System.out.println("Excepcion capturada: "+ e);
		}

	}

	private static void testGetSeriesTerminadasAcumuladasPorGenero(PeliculasssContenedor audivisual) {
		System.out.println("\n TEST TOTAL SERIES TERMINADAS POR GENERO");
	try{
		System.out.println(String.format("Se agruparan los generos como claves y el total de las series terminadas como valor"+audivisual.getSeriesTerminadasAcumuladasPorGenero()));
		
	}catch(Exception e) {
			System.out.println("Excepcion capturada: "+ e);
		}
	}
	
	private static void testGetMayorPeliculasPorAñoTerminadas(PeliculasssContenedor audivisual) {
		System.out.println("\n TEST MAS PELICULAS POR AÑO");
		try {
			System.out.println(String.format("como resultado dara el año que tenga mas numero de peliculas que esten terminadas "+ audivisual.getMayorPeliculasPorAñoTerminadas()));
		}catch(Exception e) {
			System.out.println("Excepcion capturada: "+ e);
		}
	}

	
	
	private static <K, V> void imprimeMap(Map<K, V> map) {
		map.entrySet().stream()
		 .forEach(entry->System.out.println( entry.getKey() + " --> "
		+ entry.getValue() ));
	}
	

}



