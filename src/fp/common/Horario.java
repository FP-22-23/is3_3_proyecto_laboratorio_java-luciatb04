package fp.common;

import java.time.LocalDate;
import java.time.LocalTime;

public record Horario(LocalDate eFecha, LocalTime eHora) {
	public String formateoHorario(LocalDate eFecha, LocalTime eHora) {
		return (eFecha + "->" + eHora);
	}

}
