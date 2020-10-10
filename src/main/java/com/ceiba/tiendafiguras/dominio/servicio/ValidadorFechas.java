package com.ceiba.tiendafiguras.dominio.servicio;

import java.time.DayOfWeek;
import java.time.LocalDate;

public final class ValidadorFechas {

	private ValidadorFechas() {
	}
	
	public static final String RANGO_FECHAS_INVALIDAS = "La fecha inicial debe ser anterior a la fecha final";

	/**
	 * Obtiene el número de días entre dos fechas sin contar los sábados y los domingos
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return
	 */
	public static int diasHabilesDesdeFecha(LocalDate fechaInicial, LocalDate fechaFinal) {
		
		if(fechaInicial.isAfter(fechaFinal)) {
			throw new IllegalArgumentException(RANGO_FECHAS_INVALIDAS);
		}
		
		int conteoDias = 0;
		LocalDate fechaBase = fechaInicial;
		while(fechaBase.isBefore(fechaFinal)) {
			DayOfWeek diaSemana = fechaBase.getDayOfWeek();
			if(diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY) {
				conteoDias++;
			}
			fechaBase = fechaBase.plusDays(1);
		}
		return conteoDias;
		
	}
}
