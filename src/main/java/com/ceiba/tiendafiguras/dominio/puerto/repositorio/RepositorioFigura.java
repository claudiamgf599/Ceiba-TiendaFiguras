package com.ceiba.tiendafiguras.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;

public interface RepositorioFigura {
	
	/**
	 * Retorna el listado de figuras que est�n disponibles para preordenar
	 * @return
	 */
	List<FiguraDTO> obtenerFigurasDisponiblesPreorden();

}
