package com.ceiba.tiendafiguras.aplicacion.mapeador;

import java.time.LocalDate;

import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;

public final class MapeadorPreorden {

	private MapeadorPreorden() {
	}
	
	/**
	 * Convierte un Preorden a un PreordenDTO
	 * @param preorden
	 * @return
	 */
	public static PreordenDTO mapearADTO(Preorden preorden) {
		if(preorden != null) {
			return new PreordenDTO(MapeadorFigura.mapearADTO(preorden.getFigura()), 
					MapeadorCliente.mapearADTO(preorden.getCliente()), 
					preorden.getPrecioPreorden(), preorden.getFechaPreorden(), preorden.getId(), 
					preorden.getFigura().getFechaLlegada().isAfter(LocalDate.now()));
		}else {
			return null; 
		}
	}
	
	/**
	 * Convierte un PreordenDTO a un Preorden
	 * @param preorden
	 * @return
	 */
	public static Preorden mapearAEntidad(PreordenDTO preorden) {
		if(preorden != null) {
			return new Preorden(preorden.getId(), MapeadorFigura.mapearAEntidad(preorden.getFigura()), 
					MapeadorCliente.mapearAEntidad(preorden.getCliente()), 
					preorden.getPrecioPreorden(), preorden.getFechaPreorden());
		}else {
			return null;
		}
	}
}