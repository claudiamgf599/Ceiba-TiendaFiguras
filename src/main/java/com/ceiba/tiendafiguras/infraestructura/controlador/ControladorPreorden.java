package com.ceiba.tiendafiguras.infraestructura.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.tiendafiguras.aplicacion.comando.ComandoPreorden;
import com.ceiba.tiendafiguras.aplicacion.comando.manejador.ManejadorCrearPreorden;
import com.ceiba.tiendafiguras.aplicacion.consulta.ManejadorConsultarPreordenes;
import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;

@RestController
@RequestMapping("/api/preorden")
public class ControladorPreorden {
	
	private final ManejadorCrearPreorden manejadorCrearPreorden;
	private final ManejadorConsultarPreordenes manejadorConsultarPreordenes;
	
	public ControladorPreorden(ManejadorCrearPreorden manejadorCrearPreorden, ManejadorConsultarPreordenes manejadorConsultarPreordenes) {
		this.manejadorCrearPreorden = manejadorCrearPreorden;
		this.manejadorConsultarPreordenes = manejadorConsultarPreordenes; 
	}

	@PostMapping
	public void generar(@RequestBody ComandoPreorden comandoPreorden) {
		this.manejadorCrearPreorden.ejecutar(comandoPreorden);
	}
	
	@GetMapping("/listar/{identificacionCliente}")
	public List<PreordenDTO> listar(@PathVariable(name = "identificacionCliente") String identificacionCliente){
		return this.manejadorConsultarPreordenes.ejecutar(identificacionCliente);
	}

}
