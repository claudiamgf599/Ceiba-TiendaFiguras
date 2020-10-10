package com.ceiba.tiendafiguras.dominio.unitaria;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import com.ceiba.tiendafiguras.dominio.excepcion.PreordenExcepcion;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioPreorden;
import com.ceiba.tiendafiguras.dominio.servicio.ServicioCancelarPreorden;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.PreordenTestDataBuilder;

public class ServicioCancelarPreordenTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void noPuedeCancelarPreordenTest() {
		
		// arrange
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		Figura figuraPreorden = new FiguraTestDataBuilder().conFechaLlegada(LocalDate.now().plusDays(10)).build();
		Preorden preorden = new PreordenTestDataBuilder().conFechaPreorden(LocalDate.now().minusDays(10)).conFigura(figuraPreorden).build();
		ServicioCancelarPreorden servicioCancelarPreorden = new ServicioCancelarPreorden(repositorioPreorden);
		
		thrown.expect(PreordenExcepcion.class);
		thrown.expectMessage(ServicioCancelarPreorden.PREORDEN_NO_CANCELABLE);
		
		when(repositorioPreorden.obtenerPreordenById(Mockito.anyLong())).thenReturn(preorden);
		
		// act / assert
		servicioCancelarPreorden.cancelarPreorden(100L);

	}
	
	@Test
	public void noExistePreordenACancelarTest() {
		
		// arrange
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		ServicioCancelarPreorden servicioCancelarPreorden = new ServicioCancelarPreorden(repositorioPreorden);
		
		thrown.expect(PreordenExcepcion.class);
		thrown.expectMessage(ServicioCancelarPreorden.PREORDEN_NO_EXISTE);
		
		when(repositorioPreorden.obtenerPreordenById(Mockito.anyLong())).thenReturn(null);
		
		// act / assert
		servicioCancelarPreorden.cancelarPreorden(100L);

	}
}
