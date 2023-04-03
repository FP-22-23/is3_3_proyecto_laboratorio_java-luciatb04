package fp.cine;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fp.common.Formato;
import fp.common.Horario;
import fp.common.Siglo;
import fp.utiles.Checkers;

public class Pelicula {
	
	//---------------------------------ATRIBUTOS-------------------------------------
	private Formato showType;
	private String genre;
	private Integer runningMinutes;
	private String sourceLanguage;
	private Integer peliculaId;
	private Boolean finished;
	private Double ranking;
	private LocalDateTime fechaHora;
	private List<String> efectosEspeciales;
	private Horario horario;
	
	
	//-----------------------------PRIMER CONTRUCTOR-----------------------------
	
	public Pelicula(Formato st, String genre, Integer minutes,String language, Integer pelicula_id, Boolean finish,  
					 Double ranking, List<String> efectos, LocalDateTime fechaHora, Horario horario ) {
		
	//restricciones
		
		if (ranking < 0.0) {
			throw new IllegalArgumentException("El ranking no puede ser negativo.") ;
		}
		
		if (genre == "") {
			throw new IllegalArgumentException("Se debe indicar el genero de la pelicula/serie.");
		}
		
		if (fechaHora.isAfter(LocalDateTime.now())){
			throw new IllegalArgumentException("La fecha de estreno no puede ser en el futuro ");
		}
		
		this.showType = st;
		this.genre = genre;
		this.runningMinutes= minutes;
		this.sourceLanguage = language;
		this.peliculaId = pelicula_id;
		this.finished= finish;
		this.ranking= ranking;
		this.efectosEspeciales= efectos;
		this.fechaHora= fechaHora;
		this.horario= horario;
	
		
	}
	//----------------------------CONSTRUCTOR 2-------------------------------
	public Pelicula(String genre, Integer season, Double ranking, List<String> efectos,LocalDateTime fechaHora, Horario horario) {
		
		if (ranking < 0.0) {
			throw new IllegalArgumentException("El ranking no puede ser negativo.") ;
		}
		
		if (genre == "") {
			throw new IllegalArgumentException("Se debe indicar el genero de la pelicula/serie.");
		}
		if (fechaHora.isAfter(LocalDateTime.now())){
			throw new IllegalArgumentException("La fecha de estreno no puede ser en el futuro ");
		}
			
		this.showType= Formato.TV;
		this.genre= genre;
		this.peliculaId= null;
		this.ranking= ranking;
		this.efectosEspeciales= efectos;
		this.fechaHora = fechaHora;
		this.horario= null;
		
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
	public Integer getRunningMinutes() {
		return runningMinutes;
	}
	public void setRunningMinutes(Integer runningMinutes) {
		this.runningMinutes = runningMinutes;
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
		return peliculaId;
	}

	
	public List<String> getEfectosEspeciales() {
		return efectosEspeciales;
	}
	
	public void setEfectos_especiales(List<String> efectosEspeciales) {
		this.efectosEspeciales = efectosEspeciales;
	}
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
		if (fechaHora.isAfter(LocalDateTime.now())){
			throw new IllegalArgumentException("La fecha de estreno no puede ser en el futuro ");
		}
	}
	public Horario getHorario() {
		return horario;
	}

	

	//-------------------------------TO STRING-------------------------------------
	@Override
	public String toString() {
		return "Pelicula [showType=" + showType + ", genre=" + genre +", minutes="+ runningMinutes+ ", sourceLanguage=" + sourceLanguage
				+  ", peliculaId=" + peliculaId + ", finished=" + finished + ", ranking="
				+ ranking + ", fechaHora=" + fechaHora + ", efectosEspeciales=" + efectosEspeciales + ", horario="
				+ horario + "]";
	}
	
	
	
	//---------------------------VARIABLE-------------------------------------------
	
	public Siglo getSiglo() {
		Siglo s= null;
				if(this.getFechaHora().getYear()<= 1999) {
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
		return Objects.hash(genre, ranking);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pelicula other = (Pelicula) obj;
		return Objects.equals(genre, other.genre) && Objects.equals(ranking, other.ranking);
	}



	
	//-----------------------------COMPARETO---------------------------------------------
	
	
	public int compareTo(Pelicula p) {

	int p1;
	p1= getRanking().compareTo(p.getRanking());
		
		if (p1== 0.0) {
			p1= getGenre().compareTo(p.getGenre());
			
		}
	
	return p1;
	
	
}

	
}

	

