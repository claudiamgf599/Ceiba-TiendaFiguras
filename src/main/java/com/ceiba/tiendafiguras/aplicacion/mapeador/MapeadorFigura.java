package com.ceiba.tiendafiguras.aplicacion.mapeador;

import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;

public final class MapeadorFigura {

	private MapeadorFigura() {
	}
	
	/**
	 * Convierte un FiguraDTO a un Figura
	 * @param figura
	 * @return
	 */
	public static FiguraDTO mapearADTO(Figura figura) {
		if(figura != null) {
			return new FiguraDTO(figura.getId(), figura.getNombre(), figura.getMarca(), 
					figura.getFechaLanzamiento(), figura.getFechaLlegada(), figura.getUnidadesPreventa(), 
					figura.getPrecio());
		}else {
			return null; 
		}
	}
	
	/**
	 * Convierte un Figura a un FiguraDTO
	 * @param figuraDTO
	 * @return
	 */
	public static Figura mapearAEntidad(FiguraDTO figuraDTO) {
		if(figuraDTO != null) {
			return new Figura(figuraDTO.getId(), figuraDTO.getNombre(), figuraDTO.getMarca(), figuraDTO.getFechaLanzamiento(), 
					figuraDTO.getFechaLlegada(), figuraDTO.getUnidadesPreventa(), figuraDTO.getPrecio());
		}else {
			return null;
		}
	}
}
