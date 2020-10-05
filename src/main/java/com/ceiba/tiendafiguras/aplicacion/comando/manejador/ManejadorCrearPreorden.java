package com.ceiba.tiendafiguras.aplicacion.comando.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.tiendafiguras.aplicacion.comando.ComandoPreorden;
import com.ceiba.tiendafiguras.aplicacion.comando.fabrica.FabricaPreorden;
import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;
import com.ceiba.tiendafiguras.dominio.servicio.ServicioGenerarPreorden;

@Component
public class ManejadorCrearPreorden {

	private final ServicioGenerarPreorden servicioGenerarPreorden;
	private final FabricaPreorden fabricaPreorden;
	
	public ManejadorCrearPreorden(ServicioGenerarPreorden servicioGenerarPreorden, FabricaPreorden fabricaPreorden) {
		this.servicioGenerarPreorden = servicioGenerarPreorden;
		this.fabricaPreorden = fabricaPreorden;
	}
	
	@Transactional
	public void ejecutar(ComandoPreorden comandoPreorden) {
		PreordenDTO preordenDTO = fabricaPreorden.crearPreorden(comandoPreorden);
		servicioGenerarPreorden.ejecutar(preordenDTO);
	}
}
