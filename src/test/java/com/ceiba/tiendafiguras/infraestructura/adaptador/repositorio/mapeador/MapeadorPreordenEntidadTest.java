package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.junit.Test;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.ClienteEntity;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.FiguraEntity;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.PreordenEntity;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteEntityTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraEntityTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.PreordenEntityTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.PreordenTestDataBuilder;

public class MapeadorPreordenEntidadTest {

	@Test
	public void entidadEsNullTest() {
		//arrange
		PreordenEntity preordenEntity = null;
		
		//act
		Preorden preorden = MapeadorPreordenEntidad.mapearAModelo(preordenEntity);
		
		//assert
		assertNull(preorden);
	}
	
	@Test
	public void preordenEsNullTest() {
		//arrange
		Preorden preorden = null; 
		
		//act
		PreordenEntity preordenEntity = MapeadorPreordenEntidad.mapearAEntidad(preorden);
		
		//assert
		assertNull(preordenEntity);
	}
	
	@Test
	public void entidadNoEsNullTest() {
		//arrange
		PreordenEntity preordenEntity = new PreordenEntityTestDataBuilder().build();
		
		//act
		Preorden preorden = MapeadorPreordenEntidad.mapearAModelo(preordenEntity);
		
		//assert
		assertNotNull(preorden);
		assertEquals(preorden.getId(), preordenEntity.getId());
		assertEquals(preorden.getPrecioPreorden(), preordenEntity.getPrecio(), 0);
		assertEquals(preorden.getFechaPreorden(), preordenEntity.getFechaPreorden());
		assertEquals(preorden.getCliente().getIdentificacion(), preordenEntity.getCliente().getIdentificacion());
		assertEquals(preorden.getCliente().getNombres(), preordenEntity.getCliente().getNombres());
		assertEquals(preorden.getCliente().getApellidos(), preordenEntity.getCliente().getApellidos());
		assertEquals(preorden.getFigura().getId(), preordenEntity.getFigura().getId());
		assertEquals(preorden.getFigura().getMarca(), preordenEntity.getFigura().getMarca());
		assertEquals(preorden.getFigura().getNombre(), preordenEntity.getFigura().getNombre());
		assertEquals(preorden.getFigura().getFechaLanzamiento(), preordenEntity.getFigura().getFechaLanzamiento());
		assertEquals(preorden.getFigura().getFechaLlegada(), preordenEntity.getFigura().getFechaLlegada());
		assertEquals(preorden.getFigura().getUnidadesPreventa(), preordenEntity.getFigura().getUnidadesPreventa());
		assertEquals(preorden.getFigura().getPrecio(), preordenEntity.getFigura().getPrecio(), 0);
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
				.conFechaPreorden(LocalDate.now())
				.conPrecio(100000)
				.build();
		
		//act
		Preorden preorden = MapeadorPreordenEntidad.mapearAModelo(preordenEntity);
		
		//assert
		assertNotNull(preorden);
		assertEquals(preorden.getId(), preordenEntity.getId());
		assertEquals(preorden.getPrecioPreorden(), preordenEntity.getPrecio(), 0);
		assertEquals(preorden.getFechaPreorden(), preordenEntity.getFechaPreorden());
		assertEquals(preorden.getCliente().getIdentificacion(), preordenEntity.getCliente().getIdentificacion());
		assertEquals(preorden.getCliente().getNombres(), preordenEntity.getCliente().getNombres());
		assertEquals(preorden.getCliente().getApellidos(), preordenEntity.getCliente().getApellidos());
		assertEquals(preorden.getFigura().getId(), preordenEntity.getFigura().getId());
		assertEquals(preorden.getFigura().getMarca(), preordenEntity.getFigura().getMarca());
		assertEquals(preorden.getFigura().getNombre(), preordenEntity.getFigura().getNombre());
		assertEquals(preorden.getFigura().getFechaLanzamiento(), preordenEntity.getFigura().getFechaLanzamiento());
		assertEquals(preorden.getFigura().getFechaLlegada(), preordenEntity.getFigura().getFechaLlegada());
		assertEquals(preorden.getFigura().getUnidadesPreventa(), preordenEntity.getFigura().getUnidadesPreventa());
		assertEquals(preorden.getFigura().getPrecio(), preordenEntity.getFigura().getPrecio(), 0);
	}
		
	@Test
	public void preordenNoEsNullTest() {
		//arrange
		Preorden preorden = new PreordenTestDataBuilder().build();
		
		//act
		PreordenEntity preordenEntity = MapeadorPreordenEntidad.mapearAEntidad(preorden);
		
		//assert
		assertNotNull(preordenEntity);
		assertEquals(preordenEntity.getId(), preorden.getId());
		assertEquals(preordenEntity.getPrecio(), preorden.getPrecioPreorden(), 0);
		assertEquals(preordenEntity.getFechaPreorden(), preorden.getFechaPreorden());
		assertEquals(preordenEntity.getCliente().getIdentificacion(), preorden.getCliente().getIdentificacion());
		assertEquals(preordenEntity.getCliente().getNombres(), preorden.getCliente().getNombres());
		assertEquals(preordenEntity.getCliente().getApellidos(), preorden.getCliente().getApellidos());
		assertEquals(preordenEntity.getFigura().getId(), preorden.getFigura().getId());
		assertEquals(preordenEntity.getFigura().getMarca(), preorden.getFigura().getMarca());
		assertEquals(preordenEntity.getFigura().getNombre(), preorden.getFigura().getNombre());
		assertEquals(preordenEntity.getFigura().getFechaLanzamiento(), preorden.getFigura().getFechaLanzamiento());
		assertEquals(preordenEntity.getFigura().getFechaLlegada(), preorden.getFigura().getFechaLlegada());
		assertEquals(preordenEntity.getFigura().getUnidadesPreventa(), preorden.getFigura().getUnidadesPreventa());
		assertEquals(preordenEntity.getFigura().getPrecio(), preorden.getFigura().getPrecio(), 0);
	}
}
