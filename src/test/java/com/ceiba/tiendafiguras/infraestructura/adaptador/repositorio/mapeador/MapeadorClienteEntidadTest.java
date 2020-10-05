package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.ceiba.tiendafiguras.dominio.modelo.dto.ClienteDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.ClienteEntity;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteDTOTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteEntityTestDataBuilder;

public class MapeadorClienteEntidadTest {
	
	@Test
	public void entidadEsNullTest() {
		//arrange
		ClienteEntity clienteEntity = null;
		
		//act
		ClienteDTO clienteDTO = MapeadorClienteEntidad.mapearAModelo(clienteEntity);
		
		//assert
		assertNull(clienteDTO);
	}
	
	@Test
	public void dtoEsNullTest() {
		//arrange
		ClienteDTO clienteDTO = null; 
		
		//act
		ClienteEntity clienteEntity = MapeadorClienteEntidad.mapearAEntidad(clienteDTO);
		
		//assert
		assertNull(clienteEntity);
	}
	
	@Test
	public void entidadNoEsNullTest() {
		//arrange
		ClienteEntity clienteEntity = new ClienteEntityTestDataBuilder().build();
		
		//act
		ClienteDTO clienteDTO = MapeadorClienteEntidad.mapearAModelo(clienteEntity);
		
		//assert
		assertNotNull(clienteDTO);
		assertEquals(clienteDTO.getIdentificacion(), clienteEntity.getIdentificacion());
		assertEquals(clienteDTO.getNombres(), clienteEntity.getNombres());
		assertEquals(clienteDTO.getApellidos(), clienteEntity.getApellidos());
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
		ClienteDTO clienteDTO = MapeadorClienteEntidad.mapearAModelo(clienteEntity);
		
		//assert
		assertNotNull(clienteDTO);
		assertEquals(clienteDTO.getIdentificacion(), clienteEntity.getIdentificacion());
		assertEquals(clienteDTO.getNombres(), clienteEntity.getNombres());
		assertEquals(clienteDTO.getApellidos(), clienteEntity.getApellidos());
	}
	
	@Test
	public void dtoNoEsNullTest() {
		//arrange
		ClienteDTO clienteDTO = new ClienteDTOTestDataBuilder().build();
		
		//act
		ClienteEntity clienteEntity = MapeadorClienteEntidad.mapearAEntidad(clienteDTO);
		
		//assert
		assertNotNull(clienteEntity);
		assertEquals(clienteEntity.getIdentificacion(), clienteDTO.getIdentificacion());
		assertEquals(clienteEntity.getNombres(), clienteDTO.getNombres());
		assertEquals(clienteEntity.getApellidos(), clienteDTO.getApellidos());
	}
}
