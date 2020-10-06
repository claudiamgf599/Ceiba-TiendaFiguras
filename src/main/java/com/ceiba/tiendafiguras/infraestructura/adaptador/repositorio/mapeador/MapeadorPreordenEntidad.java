package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.PreordenEntity;

public final class MapeadorPreordenEntidad {
	
	private MapeadorPreordenEntidad() {

	}

	/**
	 * Convierte un PreordenEntity a un Preorden
	 * @param preordenEntity
	 * @return
	 */
	public static Preorden mapearAModelo(PreordenEntity preordenEntity) {
		if(preordenEntity != null) {
			return new Preorden(preordenEntity.getId(), MapeadorFiguraEntidad.mapearAModelo(preordenEntity.getFigura()), 
					MapeadorClienteEntidad.mapearAModelo(preordenEntity.getCliente()), 
					preordenEntity.getPrecio(), preordenEntity.getFechaPreorden());
		}else {
			return null; 
		}
	}
	
	/**
	 * Convierte un Preorden a un PreordenEntity
	 * @param preorden
	 * @return
	 */
	public static PreordenEntity mapearAEntidad(Preorden preorden) {
		if(preorden != null) {
			return new PreordenEntity(preorden.getId(), MapeadorFiguraEntidad.mapearAEntidad(preorden.getFigura()), 
					MapeadorClienteEntidad.mapearAEntidad(preorden.getCliente()), 
					preorden.getPrecioPreorden(), preorden.getFechaPreorden());
		}else {
			return null;
		}
	}
}

