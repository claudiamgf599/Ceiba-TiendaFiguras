package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.junit.Test;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.FiguraEntity;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraEntityTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraTestDataBuilder;

public class MapeadorFiguraEntidadTest {

	@Test
	public void entidadEsNullTest() {
		//arrange
		FiguraEntity figuraEntity = null;
		
		//act
		Figura figura = MapeadorFiguraEntidad.mapearAModelo(figuraEntity);
		
		//assert
		assertNull(figura);
	}
	
	@Test
	public void figuraEsNullTest() {
		//arrange
		Figura figura = null; 
		
		//act
		FiguraEntity figuraEntity = MapeadorFiguraEntidad.mapearAEntidad(figura);
		
		//assert
		assertNull(figuraEntity);
	}
	
	@Test
	public void entidadNoEsNullTest() {
		//arrange
		FiguraEntity figuraEntity = new FiguraEntityTestDataBuilder().build();
		
		//act
		Figura figura = MapeadorFiguraEntidad.mapearAModelo(figuraEntity);
		
		//assert
		assertNotNull(figura);
		assertEquals(figura.getId(), figuraEntity.getId());
		assertEquals(figura.getMarca(), figuraEntity.getMarca());
		assertEquals(figura.getNombre(), figuraEntity.getNombre());
		assertEquals(figura.getFechaLanzamiento(), figuraEntity.getFechaLanzamiento());
		assertEquals(figura.getFechaLlegada(), figuraEntity.getFechaLlegada());
		assertEquals(figura.getUnidadesPreventa(), figuraEntity.getUnidadesPreventa());
		assertEquals(figura.getPrecio(), figuraEntity.getPrecio(), 0);
	}
	
	@Test
	public void entidadConstruidaMetodosConNoEsNullTest() {
		//arrange
		FiguraEntity figuraEntity = new FiguraEntityTestDataBuilder()
				.conFechaLanzamiento(LocalDate.now())
				.conFechaLlegada(LocalDate.now())
				.conId("L-45")
				.conNombre("Gundam EX")
				.conPrecio(100000)
				.conMarca("Meca")
				.conUnidadesPreventa(5).build();
		
		//act
		Figura figura = MapeadorFiguraEntidad.mapearAModelo(figuraEntity);
		
		//assert
		assertNotNull(figura);
		assertEquals(figura.getId(), figuraEntity.getId());
		assertEquals(figura.getMarca(), figuraEntity.getMarca());
		assertEquals(figura.getNombre(), figuraEntity.getNombre());
		assertEquals(figura.getFechaLanzamiento(), figuraEntity.getFechaLanzamiento());
		assertEquals(figura.getFechaLlegada(), figuraEntity.getFechaLlegada());
		assertEquals(figura.getUnidadesPreventa(), figuraEntity.getUnidadesPreventa());
		assertEquals(figura.getPrecio(), figuraEntity.getPrecio(), 0);
	}	
	
	@Test
	public void figuraNoEsNullTest() {
		//arrange
		Figura figura = new FiguraTestDataBuilder().build();
		
		//act
		FiguraEntity figuraEntity = MapeadorFiguraEntidad.mapearAEntidad(figura);
		
		//assert
		assertNotNull(figuraEntity);
		assertEquals(figuraEntity.getId(), figura.getId());
		assertEquals(figuraEntity.getMarca(), figura.getMarca());
		assertEquals(figuraEntity.getNombre(), figura.getNombre());
		assertEquals(figuraEntity.getFechaLanzamiento(), figura.getFechaLanzamiento());
		assertEquals(figuraEntity.getFechaLlegada(), figura.getFechaLlegada());
		assertEquals(figuraEntity.getUnidadesPreventa(), figura.getUnidadesPreventa());
		assertEquals(figuraEntity.getPrecio(), figura.getPrecio(), 0);
	}
}
