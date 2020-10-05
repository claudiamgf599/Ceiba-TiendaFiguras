package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.PreordenEntity;

public final class MapeadorPreordenEntidad {
	
	private MapeadorPreordenEntidad() {

	}

	/**
	 * Convierte un PreordenEntity a un PreordenDTO
	 * @param preordenEntity
	 * @return
	 */
	public static PreordenDTO mapearAModelo(PreordenEntity preordenEntity) {
		if(preordenEntity != null) {
			return new PreordenDTO(MapeadorFiguraEntidad.mapearAModelo(preordenEntity.getFigura()), 
					MapeadorClienteEntidad.mapearAModelo(preordenEntity.getCliente()), 
					preordenEntity.getPrecio(), preordenEntity.getFechaPreorden(), preordenEntity.getId());
		}else {
			return null; 
		}
	}
	
	/**
	 * Convierte un PreordenDTO a un PreordenEntity
	 * @param preordenDTO
	 * @return
	 */
	public static PreordenEntity mapearAEntidad(PreordenDTO preordenDTO) {
		if(preordenDTO != null) {
			return new PreordenEntity(preordenDTO.getId(), MapeadorFiguraEntidad.mapearAEntidad(preordenDTO.getFigura()), 
					MapeadorClienteEntidad.mapearAEntidad(preordenDTO.getCliente()), 
					preordenDTO.getPrecioPreorden(), preordenDTO.getFechaPreorden());
		}else {
			return null;
		}
	}
}

