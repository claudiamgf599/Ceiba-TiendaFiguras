package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Cliente;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.ClienteEntity;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteEntityTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteTestDataBuilder;

public class MapeadorClienteEntidadTest {
	
	@Test
	public void entidadEsNullTest() {
		//arrange
		ClienteEntity clienteEntity = null;
		
		//act
		Cliente cliente = MapeadorClienteEntidad.mapearAModelo(clienteEntity);
		
		//assert
		assertNull(cliente);
	}
	
	@Test
	public void clienteEsNullTest() {
		//arrange
		Cliente cliente = null; 
		
		//act
		ClienteEntity clienteEntity = MapeadorClienteEntidad.mapearAEntidad(cliente);
		
		//assert
		assertNull(clienteEntity);
	}
	
	@Test
	public void entidadNoEsNullTest() {
		//arrange
		ClienteEntity clienteEntity = new ClienteEntityTestDataBuilder().build();
		
		//act
		Cliente cliente = MapeadorClienteEntidad.mapearAModelo(clienteEntity);
		
		//assert
		assertNotNull(cliente);
		assertEquals(cliente.getIdentificacion(), clienteEntity.getIdentificacion());
		assertEquals(cliente.getNombres(), clienteEntity.getNombres());
		assertEquals(cliente.getApellidos(), clienteEntity.getApellidos());
	}
	
	@Test
	public void entidadConstruidaMetodosConNoEsNullTest() {
		//arrange
		ClienteEntity clienteEntity = new ClienteEntityTestDataBuilder()
				.conIdentificacion("C43259874")
				.conApellidos("Perez Martinez")
				.conNombres("Marcela")
				.build();
		
		//act
		Cliente cliente = MapeadorClienteEntidad.mapearAModelo(clienteEntity);
		
		//assert
		assertNotNull(cliente);
		assertEquals(cliente.getIdentificacion(), clienteEntity.getIdentificacion());
		assertEquals(cliente.getNombres(), clienteEntity.getNombres());
		assertEquals(cliente.getApellidos(), clienteEntity.getApellidos());
	}
	
	@Test
	public void clienteNoEsNullTest() {
		//arrange
		Cliente cliente = new ClienteTestDataBuilder().build();
		
		//act
		ClienteEntity clienteEntity = MapeadorClienteEntidad.mapearAEntidad(cliente);
		
		//assert
		assertNotNull(clienteEntity);
		assertEquals(clienteEntity.getIdentificacion(), cliente.getIdentificacion());
		assertEquals(clienteEntity.getNombres(), cliente.getNombres());
		assertEquals(clienteEntity.getApellidos(), cliente.getApellidos());
	}
}
