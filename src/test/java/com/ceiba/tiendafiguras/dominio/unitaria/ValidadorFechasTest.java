package com.ceiba.tiendafiguras.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ceiba.tiendafiguras.dominio.servicio.ValidadorFechas;

public class ValidadorFechasTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void calculaDiasHabilesEntreFechasTest() {
		
		//arrange
		LocalDate fechaInicial = LocalDate.of(2020, 10, 1);
		LocalDate fechaFinal = LocalDate.of(2020, 10, 10);
		
		//act
		int diasEntreFechas = ValidadorFechas.diasHabilesDesdeFecha(fechaInicial, fechaFinal);
		
		//assert
		assertEquals(7, diasEntreFechas);
		
	}
	
	@Test
	public void calculaDiasHabilesEntreFechasExceptionTest() {
		
		//arrange
		LocalDate fechaFinal = LocalDate.of(2020, 10, 1);
		LocalDate fechaInicial = LocalDate.of(2020, 10, 10);
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(ValidadorFechas.RANGO_FECHAS_INVALIDAS);
		
		//act / assert
		ValidadorFechas.diasHabilesDesdeFecha(fechaInicial, fechaFinal);
	
	}
	
	
}
