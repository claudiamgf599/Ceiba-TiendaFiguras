package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.jpa;

import java.util.Date;
import java.util.List;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.FiguraEntity;

public interface RepositorioFiguraJPA {
	

	/**
	 * Obtiene el listado de figuras disponibles para preordenar teniendo en cuenta la fecha de lanzamiento y fecha de llegada dadas
	 * @param fechaLanzamiento
	 * @param fechaLlegada
	 * @return
	 */
	List<FiguraEntity> obtenerFigurasEntityDisponiblesPreorden(Date fechaLanzamiento, Date fechaLlegada);
	
	/**
	 * Obtiene una FiguraEntity dado su codigo unico
	 * @param id
	 * @return
	 */
	FiguraEntity obtenerFiguraEntityPorId(String id);
	
	
	/**
	 * Retorna la figura identificada con el id, si esta disponible para ser preordenada, null en caso contrario
	 * @return
	 */
	FiguraEntity figuraEntityDisponiblePreorden(String id);
	
}
