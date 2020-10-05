package com.ceiba.tiendafiguras.dominio.unitaria;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.ceiba.tiendafiguras.dominio.excepcion.ClienteExcepcion;
import com.ceiba.tiendafiguras.dominio.excepcion.PreordenExcepcion;
import com.ceiba.tiendafiguras.dominio.modelo.dto.ClienteDTO;
import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;
import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioFigura;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioPreorden;
import com.ceiba.tiendafiguras.dominio.servicio.ServicioGenerarPreorden;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteDTOTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraDTOTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.PreordenDTOTestDataBuilder;

public class ServicioGenerarPreordenTest {

	@Test
	public void figuraNoPreordenableTest(){
		
		//arrange
		String idFigura = "G-14";
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		
		when(repositorioFigura.obtenerFiguraDisponiblePreorden(idFigura)).thenReturn(null);
		
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act
		boolean isPreordenable = servicioGenerarPreorden.isFiguraDisponiblePreorden(idFigura);
		
		//assert
		assertFalse(isPreordenable);
	}
	
	@Test
	public void figuraPreordenableTest(){
		
		//arrange
		String idFigura = "M-2";
		FiguraDTO figuraDTO = new FiguraDTOTestDataBuilder().conId(idFigura)
				.conFechaLanzamiento(new GregorianCalendar(2020, 11, 1).getTime())
				.conFechaLlegada(new GregorianCalendar(2020, 12, 1).getTime())
				.conUnidadesPreventa(5).build();
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		
		when(repositorioFigura.obtenerFiguraDisponiblePreorden(idFigura)).thenReturn(figuraDTO);
		
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act
		boolean isPreordenable = servicioGenerarPreorden.isFiguraDisponiblePreorden(idFigura);
		
		//assert
		assertTrue(isPreordenable);
	}
	
	@Test(expected = ClienteExcepcion.class)
	public void clienteNoExisteTest(){
		
		//arrange
		String idFigura = "M-2";
		String idCliente = "C2568985";
		ClienteDTO clienteDTO = new ClienteDTOTestDataBuilder().conIdentificacion(idCliente).build();
		FiguraDTO figuraDTO = new FiguraDTOTestDataBuilder().conId(idFigura)
				.conFechaLanzamiento(new GregorianCalendar(2020, 11, 1).getTime())
				.conFechaLlegada(new GregorianCalendar(2020, 12, 1).getTime())
				.conUnidadesPreventa(5).build();
		PreordenDTO preordenDTO = new PreordenDTOTestDataBuilder().conCliente(clienteDTO).conFigura(figuraDTO)
				.conFechaPreorden(new Date()).conPrecio(250000).conId(10L).build();
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		
		when(repositorioCliente.obtenerPorId(idCliente)).thenReturn(null);
		when(repositorioFigura.obtenerFiguraDisponiblePreorden(idFigura)).thenReturn(figuraDTO);
		
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act
		servicioGenerarPreorden.ejecutar(preordenDTO);
	}
	
	@Test(expected = PreordenExcepcion.class)
	public void figuraNoPreordenableNoGeneraPreordenTest(){
		
		//arrange
		String idFigura = "G-14";
		String idCliente = "C8266633";
		ClienteDTO clienteDTO = new ClienteDTOTestDataBuilder().conIdentificacion(idCliente).build();
		FiguraDTO figuraDTO = new FiguraDTOTestDataBuilder().conId(idFigura)
				.conFechaLanzamiento(new GregorianCalendar(2020, 11, 1).getTime())
				.conFechaLlegada(new GregorianCalendar(2020, 12, 1).getTime())
				.conUnidadesPreventa(5).build();
		PreordenDTO preordenDTO = new PreordenDTOTestDataBuilder().conCliente(clienteDTO).conFigura(figuraDTO).build();
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		
		when(repositorioCliente.obtenerPorId(idCliente)).thenReturn(clienteDTO);
		when(repositorioFigura.obtenerFiguraDisponiblePreorden(idFigura)).thenReturn(null);
		
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act
		servicioGenerarPreorden.ejecutar(preordenDTO);
	}
}
