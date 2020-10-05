package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;

import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.ClienteEntity;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.FiguraEntity;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.PreordenEntity;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteEntityTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraEntityTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.PreordenDTOTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.PreordenEntityTestDataBuilder;

public class MapeadorPreordenEntidadTest {

	@Test
	public void entidadEsNullTest() {
		//arrange
		PreordenEntity preordenEntity = null;
		
		//act
		PreordenDTO preordenDTO = MapeadorPreordenEntidad.mapearAModelo(preordenEntity);
		
		//assert
		assertNull(preordenDTO);
	}
	
	@Test
	public void dtoEsNullTest() {
		//arrange
		PreordenDTO preordenDTO = null; 
		
		//act
		PreordenEntity preordenEntity = MapeadorPreordenEntidad.mapearAEntidad(preordenDTO);
		
		//assert
		assertNull(preordenEntity);
	}
	
	@Test
	public void entidadNoEsNullTest() {
		//arrange
		PreordenEntity preordenEntity = new PreordenEntityTestDataBuilder().build();
		
		//act
		PreordenDTO preordenDTO = MapeadorPreordenEntidad.mapearAModelo(preordenEntity);
		
		//assert
		assertNotNull(preordenDTO);
		assertEquals(preordenDTO.getId(), preordenEntity.getId());
		assertEquals(preordenDTO.getPrecioPreorden(), preordenEntity.getPrecio(), 0);
		assertEquals(preordenDTO.getFechaPreorden(), preordenEntity.getFechaPreorden());
		assertEquals(preordenDTO.getCliente().getIdentificacion(), preordenEntity.getCliente().getIdentificacion());
		assertEquals(preordenDTO.getCliente().getNombres(), preordenEntity.getCliente().getNombres());
		assertEquals(preordenDTO.getCliente().getApellidos(), preordenEntity.getCliente().getApellidos());
		assertEquals(preordenDTO.getFigura().getId(), preordenEntity.getFigura().getId());
		assertEquals(preordenDTO.getFigura().getMarca(), preordenEntity.getFigura().getMarca());
		assertEquals(preordenDTO.getFigura().getNombre(), preordenEntity.getFigura().getNombre());
		assertEquals(preordenDTO.getFigura().getFechaLanzamiento(), preordenEntity.getFigura().getFechaLanzamiento());
		assertEquals(preordenDTO.getFigura().getFechaLlegada(), preordenEntity.getFigura().getFechaLlegada());
		assertEquals(preordenDTO.getFigura().getUnidadesPreventa(), preordenEntity.getFigura().getUnidadesPreventa());
		assertEquals(preordenDTO.getFigura().getPrecio(), preordenEntity.getFigura().getPrecio(), 0);
	}
	
	@Test
	public void entidadConstruidaMetodosConNoEsNullTest() {
		//arrange
		FiguraEntity figuraEntity = new FiguraEntityTestDataBuilder().build();
		ClienteEntity clienteEntity = new ClienteEntityTestDataBuilder().build();
		PreordenEntity preordenEntity = new PreordenEntityTestDataBuilder()
				.conId(10L)
				.conFigura(figuraEntity)
				.conCliente(clienteEntity)
				.conFechaPreorden(new Date())
				.conPrecio(100000)
				.build();
		
		//act
		PreordenDTO preordenDTO = MapeadorPreordenEntidad.mapearAModelo(preordenEntity);
		
		//assert
		assertNotNull(preordenDTO);
		assertEquals(preordenDTO.getId(), preordenEntity.getId());
		assertEquals(preordenDTO.getPrecioPreorden(), preordenEntity.getPrecio(), 0);
		assertEquals(preordenDTO.getFechaPreorden(), preordenEntity.getFechaPreorden());
		assertEquals(preordenDTO.getCliente().getIdentificacion(), preordenEntity.getCliente().getIdentificacion());
		assertEquals(preordenDTO.getCliente().getNombres(), preordenEntity.getCliente().getNombres());
		assertEquals(preordenDTO.getCliente().getApellidos(), preordenEntity.getCliente().getApellidos());
		assertEquals(preordenDTO.getFigura().getId(), preordenEntity.getFigura().getId());
		assertEquals(preordenDTO.getFigura().getMarca(), preordenEntity.getFigura().getMarca());
		assertEquals(preordenDTO.getFigura().getNombre(), preordenEntity.getFigura().getNombre());
		assertEquals(preordenDTO.getFigura().getFechaLanzamiento(), preordenEntity.getFigura().getFechaLanzamiento());
		assertEquals(preordenDTO.getFigura().getFechaLlegada(), preordenEntity.getFigura().getFechaLlegada());
		assertEquals(preordenDTO.getFigura().getUnidadesPreventa(), preordenEntity.getFigura().getUnidadesPreventa());
		assertEquals(preordenDTO.getFigura().getPrecio(), preordenEntity.getFigura().getPrecio(), 0);
	}
		
	@Test
	public void dtoNoEsNullTest() {
		//arrange
		PreordenDTO preordenDTO = new PreordenDTOTestDataBuilder().build();
		
		//act
		PreordenEntity preordenEntity = MapeadorPreordenEntidad.mapearAEntidad(preordenDTO);
		
		//assert
		assertNotNull(preordenEntity);
		assertEquals(preordenEntity.getId(), preordenDTO.getId());
		assertEquals(preordenEntity.getPrecio(), preordenDTO.getPrecioPreorden(), 0);
		assertEquals(preordenEntity.getFechaPreorden(), preordenDTO.getFechaPreorden());
		assertEquals(preordenEntity.getCliente().getIdentificacion(), preordenDTO.getCliente().getIdentificacion());
		assertEquals(preordenEntity.getCliente().getNombres(), preordenDTO.getCliente().getNombres());
		assertEquals(preordenEntity.getCliente().getApellidos(), preordenDTO.getCliente().getApellidos());
		assertEquals(preordenEntity.getFigura().getId(), preordenDTO.getFigura().getId());
		assertEquals(preordenEntity.getFigura().getMarca(), preordenDTO.getFigura().getMarca());
		assertEquals(preordenEntity.getFigura().getNombre(), preordenDTO.getFigura().getNombre());
		assertEquals(preordenEntity.getFigura().getFechaLanzamiento(), preordenDTO.getFigura().getFechaLanzamiento());
		assertEquals(preordenEntity.getFigura().getFechaLlegada(), preordenDTO.getFigura().getFechaLlegada());
		assertEquals(preordenEntity.getFigura().getUnidadesPreventa(), preordenDTO.getFigura().getUnidadesPreventa());
		assertEquals(preordenEntity.getFigura().getPrecio(), preordenDTO.getFigura().getPrecio(), 0);
	}
}
