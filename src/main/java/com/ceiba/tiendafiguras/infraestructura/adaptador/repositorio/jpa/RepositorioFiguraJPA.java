package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.jpa;

import java.util.List;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.FiguraEntity;

public interface RepositorioFiguraJPA {
	
	/**
	 * Obtiene un listado de FiguraEntity correspondiente a figuras disponibles para preordenar
	 * @return
	 */
	List<FiguraEntity> obtenerFigurasEntityDisponiblesPreorden();

}
