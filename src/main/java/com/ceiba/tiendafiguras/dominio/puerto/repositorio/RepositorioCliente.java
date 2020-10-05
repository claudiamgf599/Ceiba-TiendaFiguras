package com.ceiba.tiendafiguras.dominio.puerto.repositorio;

import com.ceiba.tiendafiguras.dominio.modelo.dto.ClienteDTO;

public interface RepositorioCliente {

	/**
	 * Obtiene un cliente identificado por el valor identificacion
	 * @param identificacion
	 * @return
	 */
	ClienteDTO obtenerPorId(String identificacion);
}
