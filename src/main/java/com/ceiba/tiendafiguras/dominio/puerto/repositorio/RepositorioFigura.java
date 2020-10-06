package com.ceiba.tiendafiguras.dominio.puerto.repositorio;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;

public interface RepositorioFigura {
	
		/**
	 * Obtiene la figura identificada con el id, si esta disponible para ser preordenada
	 * @param id
	 * @return
	 */
	Figura obtenerFiguraDisponiblePreorden(String id);

}
