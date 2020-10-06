package com.ceiba.tiendafiguras.dominio.unitaria;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Test;

import com.ceiba.tiendafiguras.dominio.excepcion.ClienteExcepcion;
import com.ceiba.tiendafiguras.dominio.excepcion.PreordenExcepcion;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Cliente;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioFigura;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioPreorden;
import com.ceiba.tiendafiguras.dominio.servicio.ServicioGenerarPreorden;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.PreordenTestDataBuilder;

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
		Figura figura = new FiguraTestDataBuilder().conId(idFigura)
				.conFechaLanzamiento(LocalDate.of(2020, 11, 1))
				.conFechaLlegada(LocalDate.of(2020, 12, 1))
				.conUnidadesPreventa(5).build();
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		
		when(repositorioFigura.obtenerFiguraDisponiblePreorden(idFigura)).thenReturn(figura);
		
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
		Cliente cliente = new ClienteTestDataBuilder().conIdentificacion(idCliente).build();
		Figura figura = new FiguraTestDataBuilder().conId(idFigura)
				.conFechaLanzamiento(LocalDate.of(2020, 11, 1))
				.conFechaLlegada(LocalDate.of(2020, 12, 1))
				.conUnidadesPreventa(5).build();
		Preorden preorden = new PreordenTestDataBuilder().conCliente(cliente).conFigura(figura)
				.conFechaPreorden(LocalDate.now()).conPrecio(250000).conId(10L).build();
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		
		when(repositorioCliente.obtenerPorId(idCliente)).thenReturn(null);
		when(repositorioFigura.obtenerFiguraDisponiblePreorden(idFigura)).thenReturn(figura);
		
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act
		servicioGenerarPreorden.ejecutar(preorden);
	}
	
	@Test(expected = PreordenExcepcion.class)
	public void figuraNoPreordenableNoGeneraPreordenTest(){
		
		//arrange
		String idFigura = "G-14";
		String idCliente = "C8266633";
		Cliente cliente = new ClienteTestDataBuilder().conIdentificacion(idCliente).build();
		Figura figura = new FiguraTestDataBuilder().conId(idFigura)
				.conFechaLanzamiento(LocalDate.of(2020, 11, 1))
				.conFechaLlegada(LocalDate.of(2020, 12, 1))
				.conUnidadesPreventa(5).build();
		Preorden preorden = new PreordenTestDataBuilder().conCliente(cliente).conFigura(figura).build();
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		
		when(repositorioCliente.obtenerPorId(idCliente)).thenReturn(cliente);
		when(repositorioFigura.obtenerFiguraDisponiblePreorden(idFigura)).thenReturn(null);
		
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act
		servicioGenerarPreorden.ejecutar(preorden);
	}
}
