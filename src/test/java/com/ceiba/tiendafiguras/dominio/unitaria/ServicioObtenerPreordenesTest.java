package com.ceiba.tiendafiguras.dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioPreorden;
import com.ceiba.tiendafiguras.dominio.servicio.ServicioObtenerPreordenes;
import com.ceiba.tiendafiguras.testdatabuilder.PreordenDTOTestDataBuilder;


public class ServicioObtenerPreordenesTest {

	@Test
	public void preordenesClienteTest() {
		
		//arrange
		String identificacionCliente = "C43259599";
		List<PreordenDTO> preordenes = new ArrayList<PreordenDTO>();
		preordenes.add(new PreordenDTOTestDataBuilder().build());
		preordenes.add(new PreordenDTOTestDataBuilder().conId(100L).build());
		
		RepositorioPreorden repositorioPreorden = mock(RepositorioPreorden.class);
		
		when(repositorioPreorden.obtenerPreordenesCliente(identificacionCliente)).thenReturn(preordenes);
		
		ServicioObtenerPreordenes servicioObtenerPreordenes = new ServicioObtenerPreordenes(repositorioPreorden);
		
		//act
		List<PreordenDTO> preordenesCliente = servicioObtenerPreordenes.ejecutar(identificacionCliente);
		
		//assert
		assertNotNull(preordenesCliente);
		assertEquals(2, preordenesCliente.size());
		
	}
}
