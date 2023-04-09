package fp.cine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import fp.common.Formato;
import fp.common.Horario;


public class PeliculasFactoria {

	//-----------------------------LEER FICHERO------------------------------
	/*public static List<Pelicula> leerPelicula(String nombreFichero){
		List<Pelicula> res=new ArrayList<Pelicula>();

	try { 
		List<String> líneas = Files.readAllLines(Paths.get(nombreFichero));
		líneas.remove(0);
		for (String línea:líneas){
		res.add(parsearPelicula(línea));
	}
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return res;
	}
	*/
	public static List<Pelicula> leerPelicula(String path){
		List<Pelicula> serie = new ArrayList<>();
		try {
			serie = Files.lines(Paths.get(path)).skip(1).map(PeliculasFactoria::parsearPelicula).collect(Collectors.toList());

		}catch(IOException e){
			System.out.println("No se ha encuentrado el fichero" + path);
			e.printStackTrace();
		}


			return serie;
	}
	
	//-----------------------------PARSEAR------------------------------------
	
	private static List<String>parsearEfectos(String lista){
		String limpia = lista.replace("[", "").replace("]", "");
		String[] splits= limpia.split(",");
		List<String> res= Arrays.stream(splits)
				.map(split ->split.trim()).collect(Collectors.toList());
		return res;
		
	}
	
	private static Pelicula parsearPelicula(String linea) {
		String[] trozo = linea.split(";"); 
		if(!(trozo.length<11)) {
			throw new IllegalArgumentException("cadena con formato no valido");
		}
		
		Formato formato = Formato.valueOf(trozo[0].trim());
		String genre = trozo[1].trim();
		Integer runningMinutes= Integer.parseInt(trozo[2].trim());
		String sourceLanguage= trozo[3].trim();
		Integer peliculaId= Integer.parseInt(trozo[4].trim());
		Boolean finished = Boolean.valueOf(trozo[5].trim());
		Double ranking = Double.parseDouble(trozo[6].trim());
		LocalDate fecha = LocalDate.parse(trozo[7].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalTime hora= LocalTime.parse(trozo[8].trim(), DateTimeFormatter.ofPattern("HH:mm:ss"));
		LocalDateTime fechaHora = LocalDateTime.of(fecha, hora);
		List<String> efectos= parsearEfectos(trozo[9].trim());
		Horario horario = new Horario(fecha, hora);
		
		return new Pelicula(formato, genre,runningMinutes, sourceLanguage, peliculaId, finished, ranking,
				efectos, fechaHora, horario);
	}
	

}
