package com.ceiba.tiendafiguras.aplicacion.comando.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.tiendafiguras.dominio.servicio.ServicioCancelarPreorden;

@Component
public class ManejadorCancelarPreorden {

	private final ServicioCancelarPreorden servicioCancelarPreorden;

	public ManejadorCancelarPreorden(ServicioCancelarPreorden servicioCancelarPreorden) {
		this.servicioCancelarPreorden = servicioCancelarPreorden;
	}
	
	@Transactional
	public void ejecutar(Long id) {
		servicioCancelarPreorden.cancelarPreorden(id);
	}
	
}
