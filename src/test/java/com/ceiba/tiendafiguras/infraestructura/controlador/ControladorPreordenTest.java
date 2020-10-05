package com.ceiba.tiendafiguras.infraestructura.controlador;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ceiba.tiendafiguras.aplicacion.comando.ComandoPreorden;
import com.ceiba.tiendafiguras.dominio.modelo.dto.ClienteDTO;
import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteDTOTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraDTOTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.PreordenDTOTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.properties")
public class ControladorPreordenTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Value("${texto.serviciogenerarpreorden.productonodisponible}")
	private String textoProductoNoDisponible;
	
	@Test
	public void generarPreordenTest() throws Exception {
		
		ClienteDTO clienteDTO = new ClienteDTOTestDataBuilder()
				.conIdentificacion("C43259599").conNombres("Claudia Maria").conApellidos("Gómez Flórez")
				.build();
		FiguraDTO figuraDTO = new FiguraDTOTestDataBuilder() 
				.conId("V-3").conNombre("Vegeta").conMarca("Bandai").conFechaLanzamiento(new GregorianCalendar(2020, 10, 15).getTime())
				.conFechaLlegada(new GregorianCalendar(2020, 11, 01).getTime()).conUnidadesPreventa(10).conPrecio(350000)
				.build();
		ComandoPreorden comandoPreorden = new PreordenDTOTestDataBuilder().conCliente(clienteDTO).conFigura(figuraDTO).buildComando();
		
		System.out.println(objectMapper.writeValueAsString(comandoPreorden));
		
		mvc.perform(MockMvcRequestBuilders
                .post("/api/preorden")
                .content(objectMapper.writeValueAsString(comandoPreorden))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
	}
	
    @Test
    public void obtenerPreordenesPorCliente() throws Exception {
    	mvc.perform( MockMvcRequestBuilders
                .get("/api/preorden/mispreordenes/{identificacionCliente}", "C43259599")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
	
}
