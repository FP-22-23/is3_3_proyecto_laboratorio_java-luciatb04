package fp.common;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class Peliculas {
	
	//---------------------------------ATRIBUTOS-------------------------------------
	private Formato showType;
	private String genre;
	private String sourceLanguage;
	private Integer seasonId;
	private Integer seriesId;
	private Boolean finished;
	private LocalTime estrenoHora;
	private Double ranking;
	private LocalDate estrenoFecha;
	private List<String> efectosEspeciales;
	
	
	//-----------------------------PRIMER CONTRUCTOR-----------------------------
	
	public Peliculas(Formato st, String genre,String language, Integer season, Integer series_id, Boolean finish,  
					LocalTime ehora, Double ranking, LocalDate efecha, List<String> efectos ) {
		
	//restricciones
		
		if (ranking < 0.0) {
			throw new IllegalArgumentException("El ranking no puede ser negativo.") ;
		}
		
		if (genre == "") {
			throw new IllegalArgumentException("Se debe indicar el genero de la pelicula/serie.");
		}
		
		this.showType = st;
		this.genre = genre;
		this.sourceLanguage = language;
		this.seasonId = season;
		this.seriesId = series_id;
		this.finished= finish;
		this.estrenoHora= ehora;
		this.ranking= ranking;
		this.estrenoFecha= efecha;
		this.efectosEspeciales= efectos;
		
		
	}
	//----------------------------CONSTRUCTOR 2-------------------------------
	public Peliculas(String genre, Integer season, Double ranking, List<String> efectos) {
		
		if (ranking < 0.0) {
			throw new IllegalArgumentException("El ranking no puede ser negativo.") ;
		}
		
		if (genre == "") {
			throw new IllegalArgumentException("Se debe indicar el genero de la pelicula/serie.");
		}
		
			
		this.showType= Formato.TV;
		this.genre= genre;
		this.seasonId= season;
		this.seriesId= null;
		this.ranking= ranking;
		this.efectosEspeciales= efectos;
		
	}

	
	//-------------------------GETTERS AND SETTERS----------------------------


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
		if (genre == "") {
			throw new IllegalArgumentException("Se debe indicar el genero de la pelicula/serie.");
		}
	}



	public Integer getSeasonId() {
		return seasonId;
	}


	public void setSeasonId(Integer season_id) {
		this.seasonId = season_id;
	}


	public Boolean getFinished() {
		return finished;
	}


	public void setFinished(Boolean finished) {
		this.finished = finished;
	}


	public Double getRanking() {
		return ranking;
	}


	public void setRanking(Double ranking) {
		this.ranking = ranking;
		if (ranking < 0.0) {
			throw new IllegalArgumentException("El ranking no puede ser negativo.") ;
		}
	}


	public Formato getShowType() {
		return showType;
	}


	public String getSourceLanguage() {
		return sourceLanguage;
	}


	public Integer getSeriesId() {
		return seriesId;
	}


	public LocalTime getEstrenoHora() {
		return estrenoHora;
	}


	public LocalDate getEstrenoFecha() {
		return estrenoFecha;
	}
	
	public List<String> getEfectosEspeciales() {
		return efectosEspeciales;
	}
	
	public void setEfectos_especiales(List<String> efectosEspeciales) {
		this.efectosEspeciales = efectosEspeciales;
	}
		
	

	//-------------------------------TO STRING-------------------------------------
	
	@Override
	public String toString() {
		return "Peliculas [showType=" + showType + ", genre=" + genre + ", sourceLanguage=" + sourceLanguage
				+ ", seasonId=" + seasonId + ", seriesId=" + seriesId + ", finished=" + finished + ", estrenoHora="
				+ estrenoHora + ", ranking=" + ranking + ", estrenoFecha=" + estrenoFecha + ", efectosEspeciales="
				+ efectosEspeciales + "]";
	}
	
	
	
	
	
	//---------------------------VARIABLE-------------------------------------------
	
	public Siglo getSiglo() {
		Siglo s= null;
				if(this.getEstrenoFecha().getYear()<= 1999) {
					s= Siglo.XX;
				}
				else {
					s= Siglo.XXI;
				}
				return s;
	}
	
	//----------------------------EQUALS-------------------------------------------
	
@Override
	public int hashCode() {
		return Objects.hash(estrenoHora, genre, ranking, showType, sourceLanguage);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peliculas other = (Peliculas) obj;
		return Objects.equals(estrenoHora, other.estrenoHora) && Objects.equals(genre, other.genre)
				&& Objects.equals(ranking, other.ranking) && showType == other.showType
				&& Objects.equals(sourceLanguage, other.sourceLanguage);
	}
	
	
	
	
	//-----------------------------COMPARETO---------------------------------------------
public int compareTo(Peliculas p) {

	int p1;
	p1= getRanking().compareTo(p.getRanking());
		
		if (p1== 0.0) {
			p1= getSeasonId().compareTo(p.getSeasonId());
			
		}
	
	return p1;
	
	
}
	
	
	
}

	

