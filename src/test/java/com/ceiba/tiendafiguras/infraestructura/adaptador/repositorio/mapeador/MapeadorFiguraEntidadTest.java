package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;

import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.FiguraEntity;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraDTOTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraEntityTestDataBuilder;

public class MapeadorFiguraEntidadTest {

	@Test
	public void entidadEsNullTest() {
		//arrange
		FiguraEntity figuraEntity = null;
		
		//act
		FiguraDTO figuraDTO = MapeadorFiguraEntidad.mapearAModelo(figuraEntity);
		
		//assert
		assertNull(figuraDTO);
	}
	
	@Test
	public void dtoEsNullTest() {
		//arrange
		FiguraDTO figuraDTO = null; 
		
		//act
		FiguraEntity figuraEntity = MapeadorFiguraEntidad.mapearAEntidad(figuraDTO);
		
		//assert
		assertNull(figuraEntity);
	}
	
	@Test
	public void entidadNoEsNullTest() {
		//arrange
		FiguraEntity figuraEntity = new FiguraEntityTestDataBuilder().build();
		
		//act
		FiguraDTO figuraDTO = MapeadorFiguraEntidad.mapearAModelo(figuraEntity);
		
		//assert
		assertNotNull(figuraDTO);
		assertEquals(figuraDTO.getId(), figuraEntity.getId());
		assertEquals(figuraDTO.getMarca(), figuraEntity.getMarca());
		assertEquals(figuraDTO.getNombre(), figuraEntity.getNombre());
		assertEquals(figuraDTO.getFechaLanzamiento(), figuraEntity.getFechaLanzamiento());
		assertEquals(figuraDTO.getFechaLlegada(), figuraEntity.getFechaLlegada());
		assertEquals(figuraDTO.getUnidadesPreventa(), figuraEntity.getUnidadesPreventa());
		assertEquals(figuraDTO.getPrecio(), figuraEntity.getPrecio(), 0);
	}
	
	@Test
	public void entidadConstruidaMetodosConNoEsNullTest() {
		//arrange
		FiguraEntity figuraEntity = new FiguraEntityTestDataBuilder()
				.conFechaLanzamiento(new Date())
				.conFechaLlegada(new Date())
				.conId("L-45")
				.conNombre("Gundam EX")
				.conPrecio(100000)
				.conMarca("Meca")
				.conUnidadesPreventa(5).build();
		
		//act
		FiguraDTO figuraDTO = MapeadorFiguraEntidad.mapearAModelo(figuraEntity);
		
		//assert
		assertNotNull(figuraDTO);
		assertEquals(figuraDTO.getId(), figuraEntity.getId());
		assertEquals(figuraDTO.getMarca(), figuraEntity.getMarca());
		assertEquals(figuraDTO.getNombre(), figuraEntity.getNombre());
		assertEquals(figuraDTO.getFechaLanzamiento(), figuraEntity.getFechaLanzamiento());
		assertEquals(figuraDTO.getFechaLlegada(), figuraEntity.getFechaLlegada());
		assertEquals(figuraDTO.getUnidadesPreventa(), figuraEntity.getUnidadesPreventa());
		assertEquals(figuraDTO.getPrecio(), figuraEntity.getPrecio(), 0);
	}	
	
	@Test
	public void dtoNoEsNullTest() {
		//arrange
		FiguraDTO figuraDTO = new FiguraDTOTestDataBuilder().build();
		
		//act
		FiguraEntity figuraEntity = MapeadorFiguraEntidad.mapearAEntidad(figuraDTO);
		
		//assert
		assertNotNull(figuraEntity);
		assertEquals(figuraEntity.getId(), figuraDTO.getId());
		assertEquals(figuraEntity.getMarca(), figuraDTO.getMarca());
		assertEquals(figuraEntity.getNombre(), figuraDTO.getNombre());
		assertEquals(figuraEntity.getFechaLanzamiento(), figuraDTO.getFechaLanzamiento());
		assertEquals(figuraEntity.getFechaLlegada(), figuraDTO.getFechaLlegada());
		assertEquals(figuraEntity.getUnidadesPreventa(), figuraDTO.getUnidadesPreventa());
		assertEquals(figuraEntity.getPrecio(), figuraDTO.getPrecio(), 0);
	}
}
