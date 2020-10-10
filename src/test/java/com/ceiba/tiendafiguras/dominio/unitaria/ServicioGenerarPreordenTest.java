package com.ceiba.tiendafiguras.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

	public static final String PRODUCTO_NO_DISPONIBLE = "Se ha agotado el stock para preordenar la figura";
	public static final String CLIENTE_NO_EXISTE = "El cliente no se encuentra registrado";
	public static final String CLIENTE_NO_PUEDE_PREORDENAR = "No han pasado los dias suficientes desde la ultima preorden para poder generar una nueva preorden";
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
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
		
		thrown.expect(ClienteExcepcion.class);
		thrown.expectMessage(ServicioGenerarPreorden.CLIENTE_NO_EXISTE);
		
		when(repositorioCliente.obtenerPorId(idCliente)).thenReturn(null);
		when(repositorioFigura.obtenerFiguraDisponiblePreorden(idFigura)).thenReturn(figura);
		
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act / assert
		servicioGenerarPreorden.ejecutar(preorden);
	}
	
	@Test
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
		
		thrown.expect(PreordenExcepcion.class);
		thrown.expectMessage(ServicioGenerarPreorden.PRODUCTO_NO_DISPONIBLE);
		
		when(repositorioCliente.obtenerPorId(idCliente)).thenReturn(cliente);
		when(repositorioFigura.obtenerFiguraDisponiblePreorden(idFigura)).thenReturn(null);
		
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act / assert
		servicioGenerarPreorden.ejecutar(preorden);
	}
	
	@Test
	public void clienteSinPreordenesSiPuedePreordenarTest() {

		//arrange
		String idCliente = "C2568985";
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		
		when(repositorioPreorden.obtenerUltimaPreordenCliente(idCliente)).thenReturn(null);
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act
		boolean puedePreordenar = servicioGenerarPreorden.clientePuedePreordenar(idCliente);
		
		//assert
		assertTrue(puedePreordenar);		
	}
	
	@Test
	public void clienteNoPuedePreordenarTest() {

		//arrange
		String idCliente = "C2568985";
		Preorden preorden = new PreordenTestDataBuilder().conFechaPreorden(LocalDate.now().minusDays(14)).build();
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		
		when(repositorioPreorden.obtenerUltimaPreordenCliente(idCliente)).thenReturn(preorden);
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act
		boolean puedePreordenar = servicioGenerarPreorden.clientePuedePreordenar(idCliente);
		
		//assert
		assertFalse(puedePreordenar);		
	}
	
	@Test
	public void clienteSiPuedePreordenarTest() {
		
		//arrange
		String idCliente = "C2568985";
		Preorden preorden = new PreordenTestDataBuilder().conFechaPreorden(LocalDate.now().minusDays(30)).build();
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		
		when(repositorioPreorden.obtenerUltimaPreordenCliente(idCliente)).thenReturn(preorden);
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act
		boolean puedePreordenar = servicioGenerarPreorden.clientePuedePreordenar(idCliente);
		
		//assert
		assertTrue(puedePreordenar);		
	}
	
	@Test
	public void generarPreordenTest() {
		
		//arrange
		String idFigura = "M-2";
		String idCliente = "C2568985";
		Cliente cliente = new ClienteTestDataBuilder().conIdentificacion(idCliente).build();
		Figura figura = new FiguraTestDataBuilder().conId(idFigura)
				.conFechaLanzamiento(LocalDate.now().plusMonths(4))
				.conFechaLlegada(LocalDate.now().plusMonths(5))
				.conUnidadesPreventa(5).build();
		Preorden preorden = new PreordenTestDataBuilder().conCliente(cliente).conFigura(figura).build();
		Preorden preordenGenerada = new PreordenTestDataBuilder().conCliente(cliente).conFigura(figura).conFechaPreorden(LocalDate.now()).build();
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		
		when(repositorioFigura.obtenerFiguraDisponiblePreorden(idFigura)).thenReturn(figura);
		when(repositorioCliente.obtenerPorId(idCliente)).thenReturn(cliente);
		when(repositorioPreorden.obtenerUltimaPreordenCliente(idCliente)).thenReturn(null);
		when(repositorioPreorden.generarPreorden(preorden)).thenReturn(preordenGenerada);
		
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act / assert
		Preorden preordenCreada = servicioGenerarPreorden.ejecutar(preorden);
		
		//assert
		assertEquals(preordenCreada.getFechaPreorden(), LocalDate.now());		
	}
	
	@Test
	public void clienteSiPuedeGenerarPreordenTest() {
		
		//arrange
		String idFigura = "M-2";
		String idCliente = "C2568985";
		Cliente cliente = new ClienteTestDataBuilder().conIdentificacion(idCliente).build();
		Figura figura = new FiguraTestDataBuilder().conId(idFigura)
				.conFechaLanzamiento(LocalDate.now().plusMonths(4))
				.conFechaLlegada(LocalDate.now().plusMonths(5))
				.conUnidadesPreventa(5).build();
		Preorden preorden = new PreordenTestDataBuilder()
				.conCliente(cliente)
				.conFigura(figura)
				.conFechaPreorden(LocalDate.now().minusDays(30))
				.build();
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		
		when(repositorioFigura.obtenerFiguraDisponiblePreorden(idFigura)).thenReturn(figura);
		when(repositorioCliente.obtenerPorId(idCliente)).thenReturn(cliente);
		when(repositorioPreorden.obtenerUltimaPreordenCliente(idCliente)).thenReturn(preorden);
		
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act / assert
		servicioGenerarPreorden.ejecutar(preorden);
	}


	@Test
	public void precioPreordenDescuento10Test(){
		
		//arrange
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act
		double precioPreoden = servicioGenerarPreorden.obtenerPrecioPreorden(LocalDate.now().plusDays(65), 250000);
		
		//assert
		assertEquals(225000, precioPreoden, 0);
	}
	
	
	@Test
	public void precioPreordenDescuento15Test(){
		
		//arrange
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act
		double precioPreoden = servicioGenerarPreorden.obtenerPrecioPreorden(LocalDate.now().plusMonths(4), 250000);
		
		//assert
		assertEquals(212500, precioPreoden, 0);
	}
	
	@Test
	public void precioPreordenSinDescuentoTest(){
		
		//arrange
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		RepositorioFigura repositorioFigura = mock(RepositorioFigura.class);
		RepositorioCliente repositorioCliente = mock(RepositorioCliente.class);
		ServicioGenerarPreorden servicioGenerarPreorden = new ServicioGenerarPreorden(repositorioPreorden, repositorioFigura, repositorioCliente);
		
		//act
		double precioPreoden = servicioGenerarPreorden.obtenerPrecioPreorden(LocalDate.now().plusDays(10), 250000);
		
		//assert
		assertEquals(250000, precioPreoden, 0);
	}

}
