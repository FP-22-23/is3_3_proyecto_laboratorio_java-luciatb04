package fp.test;

import java.util.List;

import fp.cine.Pelicula;
import fp.cine.PeliculasFactoria;

public class TestFactoriaPeliculas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Pelicula> audiovisual = PeliculasFactoria.leerPelicula("./data/peliculasdataset.csv");
		
		for(Integer i = 0; i < audiovisual.size(); i++) {
		    System.out.println(audiovisual.get(i));
		}
			
	
		System.out.println("se han leido: " + audiovisual.size() + " registros.");
		
	}

}