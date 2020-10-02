package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.FiguraEntity;

public class MapeadorFiguraEntidad {

	/**
	 * Convierte un FiguraEntity a un FiguraDTO
	 * @param figuraEntity
	 * @return
	 */
	public static FiguraDTO mapearAModelo(FiguraEntity figuraEntity) {
		if(figuraEntity != null) {
			return new FiguraDTO(figuraEntity.getId(), figuraEntity.getNombre(), figuraEntity.getMarca(), 
					figuraEntity.getFechaLanzamiento(), figuraEntity.getFechaLlegada(), figuraEntity.getUnidadesPreventa(), 
					figuraEntity.getPrecio());
		}else {
			return null; 
		}
	}
	
	/**
	 * Convierte un FiguraDTO a un FiguraEntity
	 * @param figuraDTO
	 * @return
	 */
	public static FiguraEntity mapearAEntidad(FiguraDTO figuraDTO) {
		if(figuraDTO != null) {
			return new FiguraEntity(figuraDTO.getId(), figuraDTO.getNombre(), figuraDTO.getMarca(), figuraDTO.getFechaLanzamiento(), 
					figuraDTO.getFechaLlegada(), figuraDTO.getUnidadesPreventa(), figuraDTO.getPrecio());
		}else {
			return null;
		}
	}
}
