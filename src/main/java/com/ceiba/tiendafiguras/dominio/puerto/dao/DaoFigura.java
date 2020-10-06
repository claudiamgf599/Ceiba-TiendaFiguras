package com.ceiba.tiendafiguras.dominio.puerto.dao;

import java.util.List;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;

public interface DaoFigura {

	/**
	 * Retorna el listado de figuras que estan disponibles para preordenar
	 * @return
	 */
	List<Figura> obtenerFigurasDisponiblesPreorden();
	
}
