package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.junit.Test;

import com.ceiba.tiendafiguras.aplicacion.mapeador.MapeadorFigura;
import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraDTOTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraTestDataBuilder;

public class MapeadorFiguraTest {

	@Test
	public void entidadEsNullTest() {
		//arrange
		Figura figura = null;
		
		//act
		FiguraDTO figuraDTO = MapeadorFigura.mapearADTO(figura);
		
		//assert
		assertNull(figuraDTO);
	}
	
	@Test
	public void dtoEsNullTest() {
		//arrange
		FiguraDTO figuraDTO = null; 
		
		//act
		Figura figura = MapeadorFigura.mapearAEntidad(figuraDTO);
		
		//assert
		assertNull(figura);
	}
	
	@Test
	public void entidadNoEsNullTest() {
		//arrange
		Figura figura = new FiguraTestDataBuilder().build();
		
		//act
		FiguraDTO figuraDTO = MapeadorFigura.mapearADTO(figura);
		
		//assert
		assertNotNull(figuraDTO);
		assertEquals(figuraDTO.getId(), figura.getId());
		assertEquals(figuraDTO.getMarca(), figura.getMarca());
		assertEquals(figuraDTO.getNombre(), figura.getNombre());
		assertEquals(figuraDTO.getFechaLanzamiento(), figura.getFechaLanzamiento());
		assertEquals(figuraDTO.getFechaLlegada(), figura.getFechaLlegada());
		assertEquals(figuraDTO.getUnidadesPreventa(), figura.getUnidadesPreventa());
		assertEquals(figuraDTO.getPrecio(), figura.getPrecio(), 0);
	}
	
	@Test
	public void entidadConstruidaMetodosConNoEsNullTest() {
		//arrange
		Figura figura = new FiguraTestDataBuilder()
				.conFechaLanzamiento(LocalDate.now())
				.conFechaLlegada(LocalDate.now())
				.conId("L-45")
				.conNombre("Gundam EX")
				.conPrecio(100000)
				.conMarca("Meca")
				.conUnidadesPreventa(5).build();
		
		//act
		FiguraDTO figuraDTO = MapeadorFigura.mapearADTO(figura);
		
		//assert
		assertNotNull(figuraDTO);
		assertEquals(figuraDTO.getId(), figura.getId());
		assertEquals(figuraDTO.getMarca(), figura.getMarca());
		assertEquals(figuraDTO.getNombre(), figura.getNombre());
		assertEquals(figuraDTO.getFechaLanzamiento(), figura.getFechaLanzamiento());
		assertEquals(figuraDTO.getFechaLlegada(), figura.getFechaLlegada());
		assertEquals(figuraDTO.getUnidadesPreventa(), figura.getUnidadesPreventa());
		assertEquals(figuraDTO.getPrecio(), figura.getPrecio(), 0);
	}
	
	@Test
	public void figuraDTONoEsNullTest() {
		//arrange
		FiguraDTO figuraDTO = new FiguraDTOTestDataBuilder().build();
		
		//act
		Figura figura = MapeadorFigura.mapearAEntidad(figuraDTO);
		
		//assert
		assertNotNull(figura);
		assertEquals(figura.getId(), figuraDTO.getId());
		assertEquals(figura.getMarca(), figuraDTO.getMarca());
		assertEquals(figura.getNombre(), figuraDTO.getNombre());
		assertEquals(figura.getFechaLanzamiento(), figuraDTO.getFechaLanzamiento());
		assertEquals(figura.getFechaLlegada(), figuraDTO.getFechaLlegada());
		assertEquals(figura.getUnidadesPreventa(), figuraDTO.getUnidadesPreventa());
		assertEquals(figura.getPrecio(), figuraDTO.getPrecio(), 0);
	}
	
	@Test
	public void figuraDTOMetodosConNoEsNullTest() {
		//arrange
		FiguraDTO figuraDTO = new FiguraDTOTestDataBuilder()
				.conFechaLanzamiento(LocalDate.now())
				.conFechaLlegada(LocalDate.now())
				.conId("L-45")
				.conNombre("Gundam EX")
				.conPrecio(100000)
				.conMarca("Meca")
				.conUnidadesPreventa(5)
				.build();
		
		//act
		Figura figura = MapeadorFigura.mapearAEntidad(figuraDTO);
		
		//assert
		assertNotNull(figura);
		assertEquals(figura.getId(), figuraDTO.getId());
		assertEquals(figura.getMarca(), figuraDTO.getMarca());
		assertEquals(figura.getNombre(), figuraDTO.getNombre());
		assertEquals(figura.getFechaLanzamiento(), figuraDTO.getFechaLanzamiento());
		assertEquals(figura.getFechaLlegada(), figuraDTO.getFechaLlegada());
		assertEquals(figura.getUnidadesPreventa(), figuraDTO.getUnidadesPreventa());
		assertEquals(figura.getPrecio(), figuraDTO.getPrecio(), 0);
	}
	
}
