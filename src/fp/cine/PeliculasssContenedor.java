package fp.cine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.Formato;




public class PeliculasssContenedor {
	//atributo
	private List<Pelicula> Peliculass;

	
	
	//-------------CONSTRUCTORES-------------------
	public PeliculasssContenedor() {
		this.Peliculass = new ArrayList<>();
		}
	
	public PeliculasssContenedor(List<Pelicula> Peliculass) {
		this.Peliculass= Peliculass;
	
	}
	
	public PeliculasssContenedor(Stream<Pelicula> Peliculass ) {
		this.Peliculass= Peliculass.collect(Collectors.toList());
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
		PeliculasssContenedor other = (PeliculasssContenedor) obj;
		return Objects.equals(Peliculass, other.Peliculass);
	}
	
//-------------------------TRATAMIENTOS SECUENCIALES------------------------
	
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

	public Integer getNumeroPeliculaIdiomaDeUnAño(String i, Integer a) {
		Integer res= 0;
		for (Pelicula pe: Peliculass) {
			String idioma= pe.getSourceLanguage();
			if(idioma.equals(i) && pe.getFechaHora().getYear()== a) {
				res++;	
			}
		}
		return res;
	}

	//filtrado
	
	public List<Pelicula> filtradoSoloPeliculaId(Integer a, Formato p){
		List<Pelicula> idFiltrado = new ArrayList<>();
		for (Pelicula pe:Peliculass) {
			if(pe.getSeriesId().equals(a)&& pe.getShowType().equals(p)) {
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
				res.put(llave, valor+1);
			}else {
				Long valor= 1L;
				res.put(llave, valor);

			}
		} return res;

	} 
	//------------------------------ENTREGA 3 BLOQUE I-------------------------------------
	
	//existe para todo (Stream)
	
	public Boolean existePeliculaGeneroIdidomaStream(String g, String i) {
		Predicate<Pelicula> p= pe-> pe.getGenre().equals(g) && pe.getSourceLanguage().equals(i);
		return Peliculass.stream().allMatch(p);
	}
	
	//contador con stream
	public Integer calcularMinutosTotalesPorIdioma(String g) {
		return Integer.valueOf((int)Peliculass.stream().filter(av->av.getSourceLanguage().equals(g)).count());
	}
	
	//filtrado con stream 
	public Set<Pelicula> peliculasEntreDosDuracionesDadas(Integer max, Integer min){
		return Peliculass.stream().filter(pe->pe.getRunningMinutes()>= min && pe.getRunningMinutes()<= max).collect(Collectors.toSet());
	}
	
	public Map<List<String>, Set<Integer>> getSeriesListaEfectosConjuntoAños(){
		return Peliculass.stream().filter(p->p.getShowType().equals(Formato.TV))
				.collect(Collectors.groupingBy(p->p.getEfectosEspeciales(), 
						Collectors.mapping(p->p.getFechaHora().getYear(), Collectors.toSet())));
	}
	
	//max ranking de un idioma dado
	
	public Pelicula mejorRankingAcabadaIidoma(String idioma) {
		return Peliculass.stream().filter(pe->pe.getSourceLanguage().equals(idioma)).filter(pe->pe.getFinished().equals(true))
				.max(Comparator.comparing(p->p.getRanking())).orElse(null);
	}

	//con filtrado y seleccion ordenado
	
	public List<Pelicula> obtenerNSeriesGeneroOrdenadosPorElRanking(String g, Integer n){
		return Peliculass.stream().filter(pe->pe.getGenre().equals(g)).filter(pe->pe.getShowType().equals(Formato.TV))
				.sorted(Comparator.comparing(Pelicula::getRanking).reversed())
				.limit(n).collect(Collectors.toList());
	}
	
	//Collectors.mapping
	public Map<Integer, Set<Integer>> agruparIdPorMes(){
		return Peliculass.stream().filter(p->p.getShowType().equals(Formato.TV)).collect(Collectors.groupingBy(pe->pe.getFechaHora().getMonthValue(),
				Collectors.mapping(pe->pe.getSeriesId(), Collectors.toSet())));
	}
	
	//minimo en mapa
	public Map<String, Pelicula> fechasConPeliculasConPeoresRankings(Integer año){
		return Peliculass.stream().filter(pe->pe.getFechaHora().getYear()==año).collect(Collectors.groupingBy(Pelicula::getSourceLanguage,
				Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Pelicula::getRanking)), pe->pe.get())));
	}

	//sortedMap
	public SortedMap<String, Integer> getSeriesTerminadasAcumuladasPorGenero(){
		return Peliculass.stream().filter(pe->pe.getShowType().equals(Formato.TV))
				.filter(pe->pe.getFinished().equals(true))
				.collect(Collectors.groupingBy(Pelicula::getGenre, TreeMap::new, Collectors.collectingAndThen(Collectors.counting(), l->l.intValue())));
		
	}
	
	//Un método que calcule un Map y devuelva la clave con el valor asociado (mayor o menor) de todo el Map.
	
	
	public Entry<Integer, Long> getMayorPeliculasPorAñoTerminadas(){
    	Map<Integer, Long> m = Peliculass.stream()
    			.filter(a -> a.getFinished().equals(true)).filter(p->p.getShowType().equals(Formato.MOVIE)) 
    			.collect(Collectors.groupingBy(pe-> pe.getFechaHora().getYear(), Collectors.counting()));
    	
    	return m.entrySet().stream().max(Comparator.comparing(p -> p.getValue())).get(); 
    }


}




