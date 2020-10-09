package com.ceiba.tiendafiguras.infraestructura.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.tiendafiguras.aplicacion.consulta.ManejadorConsultarFiguras;
import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/figuras")
public class ControladorConsultaFiguras {

	private final ManejadorConsultarFiguras manejadorConsultarFiguras;
	
	public ControladorConsultaFiguras(ManejadorConsultarFiguras manejadorConsultarFiguras) {
		this.manejadorConsultarFiguras = manejadorConsultarFiguras; 
	}
	
	@GetMapping("/disponibles")
	public List<FiguraDTO> listarDisponibles(){
		return this.manejadorConsultarFiguras.ejecutar();
	}
}
