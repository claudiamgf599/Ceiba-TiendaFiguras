package com.ceiba.tiendafiguras.aplicacion.consulta;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;
import com.ceiba.tiendafiguras.dominio.servicio.ServicioObtenerPreordenes;

@Component
public class ManejadorConsultarPreordenes {
	
	private final ServicioObtenerPreordenes servicioObtenerPreordenes;
	
	public ManejadorConsultarPreordenes(ServicioObtenerPreordenes servicioObtenerPreordenes) {
		this.servicioObtenerPreordenes = servicioObtenerPreordenes;
	}
	
	@Transactional
	public List<PreordenDTO> ejecutar(String identificacionCliente){
		return this.servicioObtenerPreordenes.ejecutar(identificacionCliente);
	}
}
