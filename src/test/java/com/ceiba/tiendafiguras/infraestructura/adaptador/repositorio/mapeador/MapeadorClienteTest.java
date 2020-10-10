package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.ceiba.tiendafiguras.aplicacion.mapeador.MapeadorCliente;
import com.ceiba.tiendafiguras.dominio.excepcion.ValidadorArgumentosExcepcion;
import com.ceiba.tiendafiguras.dominio.modelo.dto.ClienteDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Cliente;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteDTOTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteTestDataBuilder;

public class MapeadorClienteTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void entidadEsNullTest() {
		//arrange
		Cliente cliente = null;
		
		//act
		ClienteDTO clienteDTO = MapeadorCliente.mapearADTO(cliente);
		
		//assert
		assertNull(clienteDTO);
	}
	
	@Test
	public void dtoEsNullTest() {
		//arrange
		ClienteDTO clienteDTO = null; 
		
		//act
		Cliente cliente = MapeadorCliente.mapearAEntidad(clienteDTO);
		
		//assert
		assertNull(cliente);
	}
	
	@Test
	public void entidadNoEsNullTest() {
		//arrange
		Cliente cliente = new ClienteTestDataBuilder().build();
		
		//act
		ClienteDTO clienteDTO = MapeadorCliente.mapearADTO(cliente);
		
		//assert
		assertNotNull(clienteDTO);
		assertEquals(clienteDTO.getIdentificacion(), cliente.getIdentificacion());
		assertEquals(clienteDTO.getNombres(), cliente.getNombres());
		assertEquals(clienteDTO.getApellidos(), cliente.getApellidos());
	}
	
	@Test
	public void entidadConstruidaMetodosConNoEsNullTest() {
		//arrange
		Cliente cliente = new ClienteTestDataBuilder()
				.conIdentificacion("C43259874")
				.conApellidos("Perez Martinez")
				.conNombres("Marcela")
				.build();
		
		//act
		ClienteDTO clienteDTO = MapeadorCliente.mapearADTO(cliente);
		
		//assert
		assertNotNull(clienteDTO);
		assertEquals(clienteDTO.getIdentificacion(), cliente.getIdentificacion());
		assertEquals(clienteDTO.getNombres(), cliente.getNombres());
		assertEquals(clienteDTO.getApellidos(), cliente.getApellidos());
	}
	
	@Test
	public void clienteDTONoEsNullTest() {
		//arrange
		ClienteDTO clienteDTO = new ClienteDTOTestDataBuilder().build();
		
		//act
		Cliente cliente = MapeadorCliente.mapearAEntidad(clienteDTO);
		
		//assert
		assertNotNull(cliente);
		assertEquals(cliente.getIdentificacion(), clienteDTO.getIdentificacion());
		assertEquals(cliente.getNombres(), clienteDTO.getNombres());
		assertEquals(cliente.getApellidos(), clienteDTO.getApellidos());
	}
	
	@Test
	public void clienteDTOMetodosConNoEsNullTest() {
		//arrange
		ClienteDTO clienteDTO = new ClienteDTOTestDataBuilder()
				.conIdentificacion("C43259874")
				.conApellidos("Perez Martinez")
				.conNombres("Marcela")
				.build();
		
		//act
		Cliente cliente = MapeadorCliente.mapearAEntidad(clienteDTO);
		
		//assert
		assertNotNull(cliente);
		assertEquals(cliente.getIdentificacion(), clienteDTO.getIdentificacion());
		assertEquals(cliente.getNombres(), clienteDTO.getNombres());
		assertEquals(cliente.getApellidos(), clienteDTO.getApellidos());
	}
	
	@Test
	public void clienteArgumentosInvalidosTest() {
		//arrange
		thrown.expect(ValidadorArgumentosExcepcion.class);
				
		//act / assert
		new Cliente(null, null, null);

	}
}
