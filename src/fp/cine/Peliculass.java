package fp.cine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;






public class Peliculass {
	//atributo
	private List<Pelicula> Peliculass;

	
	
	//-------------CONSTRUCTOR-------------------
	public Peliculass() {
		this.Peliculass = new ArrayList<>();
	}
	public Peliculass(Stream<Pelicula> st ) {
		this.Peliculass= st.collect(Collectors.toList());
	}
	
	//------------METODOS BASICOS---------------
	public void añadirAud(Pelicula p) {
		this.Peliculass.add(p);                           //añadir
		
	}
	
	public void eliminarAud(Pelicula p) {
		if (!Peliculass.contains(p)) {
			throw new IllegalArgumentException("La pelicula/serie no existe");
		}else {
			Peliculass.remove(p);                   //eliminar
		}
	}
	public Integer getTamaño() {
		return Peliculass.size();     //tamaño
	}
	
	//-------------GETERS AND SETERS-------------

	public List<Pelicula> getAudivisual() {
		return Peliculass;
	}


	
	//------------------TO STRING-------------------

	@Override
	public String toString() {
		return "Peliculass [audivisual=" + Peliculass + "]";
	}

	//---------------HASHCODE AND EQUALS------------
	
	@Override
	public int hashCode() {
		return Objects.hash(Peliculass);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peliculass other = (Peliculass) obj;
		return Objects.equals(Peliculass, other.Peliculass);
	}
	
//-------------------------TRATAMIETNOS SECUENCIALES------------------------
	
	//existe para todo
	
	
	public Boolean existePeliculaGeneroIdioma(String g, String i) {
		Boolean res= false;
		for(Pelicula pe: Peliculass) {
			if(pe.getGenre().equals(g) && pe.getSourceLanguage().equals(i))
			res= true;
		
		}
	return res;
	
	
	} 

	//contador 
	
	public Integer getNumeroPeliculaIdioma(String i) {
		Integer res= 0;
		for (Pelicula pe: Peliculass) {
			String idioma= pe.getSourceLanguage();
			if(idioma.equals(i)) {
				res++;	
			}
			}
		return res;
	}

	//filtrado
	
	public List<Pelicula> filtradoPeliculaId(Integer a){
		List<Pelicula> idFiltrado = new ArrayList<>();
		for (Pelicula pe:Peliculass) {
			if(pe.getSeriesId().equals(a)) {
				idFiltrado.add(pe);
			}
		}
		return idFiltrado;
	}
	   
	//map con una lista como valor
	
	public Map<String, Set<Integer>> getListaIdPorGenero(){
		Map<String, Set<Integer>> res= new HashMap<>();
		for(Pelicula pe: Peliculass) {
			String llave= pe.getGenre();
			if(res.containsKey(llave)) {
				res.get(llave).add(pe.getSeriesId());
			}
			else {
				Set<Integer> valor= new HashSet<>();
				valor.add(pe.getSeriesId());
				res.put(llave, valor);
			}
		}
		return res; 
	}

	
	//map sumador
	public Map<String, Long> getTotalDuracionPorGenero(){
		Map<String, Long> res= new HashMap<String, Long>();
		for(Pelicula pe: Peliculass) {
			String llave= pe.getGenre();
			if(res.containsKey(llave)) {
				Long valor= res.get(llave);
				res.put(llave, valor);
			}else {
				Long valor= 1L;
				res.put(llave, valor);
				
			}
		} return res;
		
	} 
	
	
}
