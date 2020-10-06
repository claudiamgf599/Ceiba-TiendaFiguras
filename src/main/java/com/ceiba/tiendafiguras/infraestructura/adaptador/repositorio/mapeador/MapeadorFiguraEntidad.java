package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.FiguraEntity;

public final class MapeadorFiguraEntidad {

	private MapeadorFiguraEntidad() {
		
	}
	
	/**
	 * Convierte un FiguraEntity a un Figura
	 * @param figuraEntity
	 * @return
	 */
	public static Figura mapearAModelo(FiguraEntity figuraEntity) {
		if(figuraEntity != null) {
			return new Figura(figuraEntity.getId(), figuraEntity.getNombre(), figuraEntity.getMarca(), 
					figuraEntity.getFechaLanzamiento(), figuraEntity.getFechaLlegada(), figuraEntity.getUnidadesPreventa(), 
					figuraEntity.getPrecio());
		}else {
			return null; 
		}
	}
	
	/**
	 * Convierte un Figura a un FiguraEntity
	 * @param figura
	 * @return
	 */
	public static FiguraEntity mapearAEntidad(Figura figura) {
		if(figura != null) {
			return new FiguraEntity(figura.getId(), figura.getNombre(), figura.getMarca(), figura.getFechaLanzamiento(), 
					figura.getFechaLlegada(), figura.getUnidadesPreventa(), figura.getPrecio());
		}else {
			return null;
		}
	}
}
