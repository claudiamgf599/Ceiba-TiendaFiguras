package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.junit.Test;

import com.ceiba.tiendafiguras.aplicacion.mapeador.MapeadorPreorden;
import com.ceiba.tiendafiguras.dominio.modelo.dto.ClienteDTO;
import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;
import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Cliente;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteDTOTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraDTOTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.PreordenDTOTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.PreordenTestDataBuilder;

public class MapeadorPreordenTest {
	
	@Test
	public void entidadEsNullTest() {
		//arrange
		Preorden preorden = null;
		
		//act
		PreordenDTO preordenDTO = MapeadorPreorden.mapearADTO(preorden);
		
		//assert
		assertNull(preordenDTO);
	}
	
	@Test
	public void preordenDTOEsNullTest() {
		//arrange
		PreordenDTO preordenDTO = null; 
		
		//act
		Preorden preorden = MapeadorPreorden.mapearAEntidad(preordenDTO);
		
		//assert
		assertNull(preorden);
	}
	
	@Test
	public void entidadNoEsNullTest() {
		//arrange
		Preorden preorden = new PreordenTestDataBuilder().build();
		
		//act
		PreordenDTO preordenDTO = MapeadorPreorden.mapearADTO(preorden);
		
		//assert
		assertNotNull(preordenDTO);
		assertEquals(preordenDTO.getId(), preorden.getId());
		assertEquals(preordenDTO.getPrecioPreorden(), preorden.getPrecioPreorden(), 0);
		assertEquals(preordenDTO.getFechaPreorden(), preorden.getFechaPreorden());
		assertEquals(preordenDTO.getCliente().getIdentificacion(), preorden.getCliente().getIdentificacion());
		assertEquals(preordenDTO.getCliente().getNombres(), preorden.getCliente().getNombres());
		assertEquals(preordenDTO.getCliente().getApellidos(), preorden.getCliente().getApellidos());
		assertEquals(preordenDTO.getFigura().getId(), preorden.getFigura().getId());
		assertEquals(preordenDTO.getFigura().getMarca(), preorden.getFigura().getMarca());
		assertEquals(preordenDTO.getFigura().getNombre(), preorden.getFigura().getNombre());
		assertEquals(preordenDTO.getFigura().getFechaLanzamiento(), preorden.getFigura().getFechaLanzamiento());
		assertEquals(preordenDTO.getFigura().getFechaLlegada(), preorden.getFigura().getFechaLlegada());
		assertEquals(preordenDTO.getFigura().getUnidadesPreventa(), preorden.getFigura().getUnidadesPreventa());
		assertEquals(preordenDTO.getFigura().getPrecio(), preorden.getFigura().getPrecio(), 0);
	}
	
	@Test
	public void entidadConstruidaMetodosConNoEsNullTest() {
		//arrange
		Figura figura = new FiguraTestDataBuilder().build();
		Cliente cliente = new ClienteTestDataBuilder().build();
		Preorden preorden = new PreordenTestDataBuilder()
				.conId(10L)
				.conFigura(figura)
				.conCliente(cliente)
				.conFechaPreorden(LocalDate.now())
				.conPrecio(100000)
				.build();
		
		//act
		PreordenDTO preordenDTO = MapeadorPreorden.mapearADTO(preorden);
		
		//assert
		assertNotNull(preordenDTO);
		assertEquals(preordenDTO.getId(), preorden.getId());
		assertEquals(preordenDTO.getPrecioPreorden(), preorden.getPrecioPreorden(), 0);
		assertEquals(preordenDTO.getFechaPreorden(), preorden.getFechaPreorden());
		assertEquals(preordenDTO.getCliente().getIdentificacion(), preorden.getCliente().getIdentificacion());
		assertEquals(preordenDTO.getCliente().getNombres(), preorden.getCliente().getNombres());
		assertEquals(preordenDTO.getCliente().getApellidos(), preorden.getCliente().getApellidos());
		assertEquals(preordenDTO.getFigura().getId(), preorden.getFigura().getId());
		assertEquals(preordenDTO.getFigura().getMarca(), preorden.getFigura().getMarca());
		assertEquals(preordenDTO.getFigura().getNombre(), preorden.getFigura().getNombre());
		assertEquals(preordenDTO.getFigura().getFechaLanzamiento(), preorden.getFigura().getFechaLanzamiento());
		assertEquals(preordenDTO.getFigura().getFechaLlegada(), preorden.getFigura().getFechaLlegada());
		assertEquals(preordenDTO.getFigura().getUnidadesPreventa(), preorden.getFigura().getUnidadesPreventa());
		assertEquals(preordenDTO.getFigura().getPrecio(), preorden.getFigura().getPrecio(), 0);
	}
		
	@Test
	public void preordenDTONoEsNullTest() {
		//arrange
		PreordenDTO preordenDTO = new PreordenDTOTestDataBuilder().build();
		
		//act
		Preorden preorden = MapeadorPreorden.mapearAEntidad(preordenDTO);
		
		//assert
		assertNotNull(preorden);
		assertEquals(preorden.getId(), preordenDTO.getId());
		assertEquals(preorden.getPrecioPreorden(), preordenDTO.getPrecioPreorden(), 0);
		assertEquals(preorden.getFechaPreorden(), preordenDTO.getFechaPreorden());
		assertEquals(preorden.getCliente().getIdentificacion(), preordenDTO.getCliente().getIdentificacion());
		assertEquals(preorden.getCliente().getNombres(), preordenDTO.getCliente().getNombres());
		assertEquals(preorden.getCliente().getApellidos(), preordenDTO.getCliente().getApellidos());
		assertEquals(preorden.getFigura().getId(), preordenDTO.getFigura().getId());
		assertEquals(preorden.getFigura().getMarca(), preordenDTO.getFigura().getMarca());
		assertEquals(preorden.getFigura().getNombre(), preordenDTO.getFigura().getNombre());
		assertEquals(preorden.getFigura().getFechaLanzamiento(), preordenDTO.getFigura().getFechaLanzamiento());
		assertEquals(preorden.getFigura().getFechaLlegada(), preordenDTO.getFigura().getFechaLlegada());
		assertEquals(preorden.getFigura().getUnidadesPreventa(), preordenDTO.getFigura().getUnidadesPreventa());
		assertEquals(preorden.getFigura().getPrecio(), preordenDTO.getFigura().getPrecio(), 0);
	}
	
	@Test
	public void preordenDTOMetodosConNoEsNullTest() {
		//arrange
		FiguraDTO figuraDTO = new FiguraDTOTestDataBuilder().build();
		ClienteDTO clienteDTO = new ClienteDTOTestDataBuilder().build();
		PreordenDTO preordenDTO = new PreordenDTOTestDataBuilder()
				.conId(10L)
				.conFigura(figuraDTO)
				.conCliente(clienteDTO)
				.conFechaPreorden(LocalDate.now())
				.conPrecio(100000)
				.build();
		
		//act
		Preorden preorden = MapeadorPreorden.mapearAEntidad(preordenDTO);
		
		//assert
		assertNotNull(preorden);
		assertEquals(preorden.getId(), preordenDTO.getId());
		assertEquals(preorden.getPrecioPreorden(), preordenDTO.getPrecioPreorden(), 0);
		assertEquals(preorden.getFechaPreorden(), preordenDTO.getFechaPreorden());
		assertEquals(preorden.getCliente().getIdentificacion(), preordenDTO.getCliente().getIdentificacion());
		assertEquals(preorden.getCliente().getNombres(), preordenDTO.getCliente().getNombres());
		assertEquals(preorden.getCliente().getApellidos(), preordenDTO.getCliente().getApellidos());
		assertEquals(preorden.getFigura().getId(), preordenDTO.getFigura().getId());
		assertEquals(preorden.getFigura().getMarca(), preordenDTO.getFigura().getMarca());
		assertEquals(preorden.getFigura().getNombre(), preordenDTO.getFigura().getNombre());
		assertEquals(preorden.getFigura().getFechaLanzamiento(), preordenDTO.getFigura().getFechaLanzamiento());
		assertEquals(preorden.getFigura().getFechaLlegada(), preordenDTO.getFigura().getFechaLlegada());
		assertEquals(preorden.getFigura().getUnidadesPreventa(), preordenDTO.getFigura().getUnidadesPreventa());
		assertEquals(preorden.getFigura().getPrecio(), preordenDTO.getFigura().getPrecio(), 0);
	}
	
}
