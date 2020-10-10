package com.ceiba.tiendafiguras.dominio.servicio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import com.ceiba.tiendafiguras.dominio.excepcion.PreordenExcepcion;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioPreorden;

@Component
public class ServicioCancelarPreorden {
	
	public static final String PREORDEN_NO_EXISTE = "La preorden que se desea cancelar no existe";
	public static final String PREORDEN_NO_CANCELABLE = "Falta menos de un mes para la fecha de lanzamiento de la figura. No es posible cancelar la preorden";
	
	private RepositorioPreorden repositorioPreorden;
	
	public ServicioCancelarPreorden(RepositorioPreorden repositorioPreorden) {
		this.repositorioPreorden = repositorioPreorden;
	}
	
	public void cancelarPreorden(Long id) {
		
		Preorden preorden = repositorioPreorden.obtenerPreordenById(id);
		if(preorden == null) {
			throw new PreordenExcepcion(PREORDEN_NO_EXISTE);
		}
		if(ChronoUnit.MONTHS.between(LocalDate.now(), preorden.getFigura().getFechaLlegada()) < 1) {
			throw new PreordenExcepcion(PREORDEN_NO_CANCELABLE);
		}
		repositorioPreorden.eliminarPreorden(id);
	}
	
}
