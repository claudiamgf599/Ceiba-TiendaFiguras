package com.ceiba.tiendafiguras.infraestructura.controlador;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

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
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Cliente;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;
import com.ceiba.tiendafiguras.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.FiguraTestDataBuilder;
import com.ceiba.tiendafiguras.testdatabuilder.PreordenTestDataBuilder;
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
		
		Cliente cliente = new ClienteTestDataBuilder()
				.conIdentificacion("C43259599").conNombres("Claudia Maria").conApellidos("Gomez Florez")
				.build();
		Figura figura = new FiguraTestDataBuilder() 
				.conId("V-3").conNombre("Vegeta").conMarca("Bandai").conFechaLanzamiento(LocalDate.of(2020, 10, 15))
				.conFechaLlegada(LocalDate.of(2020, 11, 01)).conUnidadesPreventa(10).conPrecio(350000)
				.build();
		ComandoPreorden comandoPreorden = new PreordenTestDataBuilder().conCliente(cliente).conFigura(figura).buildComando();
		
		System.out.println(objectMapper.writeValueAsString(comandoPreorden));
		
		/*MvcResult mvcResult = */ mvc.perform(MockMvcRequestBuilders
                .post("/api/preorden/generar")
                .content(objectMapper.writeValueAsString(comandoPreorden))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
		
		//System.out.println("MVC Result: " + mvcResult);
		///*.andReturn()*/;
	}
	
    @Test
    public void obtenerPreordenesPorCliente() throws Exception {
    	mvc.perform( MockMvcRequestBuilders
                .get("/api/preorden/listar/{identificacionCliente}", "C43259599")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
	
}
