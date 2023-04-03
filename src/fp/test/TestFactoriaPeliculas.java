package fp.test;

import java.util.List;

import fp.cine.Pelicula;
import fp.cine.PeliculasFactoria;

public class TestFactoriaPeliculas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Pelicula> peliculas = PeliculasFactoria.leerPelicula("./data/peliculasdataset.csv");
		for(Pelicula p: peliculas) {
			System.out.println(p);
			
		}
		System.out.println("se han leido: " + peliculas.size() + " registros.");
		
	}

}