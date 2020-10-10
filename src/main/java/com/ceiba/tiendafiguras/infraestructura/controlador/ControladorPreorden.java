package com.ceiba.tiendafiguras.infraestructura.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.tiendafiguras.aplicacion.comando.ComandoPreorden;
import com.ceiba.tiendafiguras.aplicacion.comando.manejador.ManejadorCancelarPreorden;
import com.ceiba.tiendafiguras.aplicacion.comando.manejador.ManejadorCrearPreorden;
import com.ceiba.tiendafiguras.aplicacion.consulta.ManejadorConsultarPreordenes;
import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/preorden")
public class ControladorPreorden {
	
	private final ManejadorCrearPreorden manejadorCrearPreorden;
	private final ManejadorCancelarPreorden manejadorCancelarPreorden;
	private final ManejadorConsultarPreordenes manejadorConsultarPreordenes;
	
	public ControladorPreorden(ManejadorCrearPreorden manejadorCrearPreorden,
			ManejadorCancelarPreorden manejadorCancelarPreorden,
			ManejadorConsultarPreordenes manejadorConsultarPreordenes) {
		this.manejadorCrearPreorden = manejadorCrearPreorden;
		this.manejadorCancelarPreorden = manejadorCancelarPreorden;
		this.manejadorConsultarPreordenes = manejadorConsultarPreordenes;
	}

	@PostMapping("/generar")
	public ResponseEntity<?> generar(@RequestBody ComandoPreorden comandoPreorden) {
		Map<String, Object> response = new HashMap<String, Object>();
		PreordenDTO preordenDTO = null;
		try {
			preordenDTO = this.manejadorCrearPreorden.ejecutar(comandoPreorden);
		}catch(Exception e) {
			response.put("mensaje", e.getMessage());
			response.put("error", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "Preorden creada con exito");
		response.put("preorden", preordenDTO);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	
	@GetMapping("/listar/{identificacionCliente}")
	public List<PreordenDTO> listar(@PathVariable(name = "identificacionCliente") String identificacionCliente){
		return this.manejadorConsultarPreordenes.ejecutar(identificacionCliente);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/cancelar/{idPreorden}")
	public void cancelar(@PathVariable Long idPreorden) {
		this.manejadorCancelarPreorden.ejecutar(idPreorden);
	}

}
