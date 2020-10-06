package com.ceiba.tiendafiguras.dominio.puerto.repositorio;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Cliente;

public interface RepositorioCliente {

	/**
	 * Obtiene un cliente identificado por el valor identificacion
	 * @param identificacion
	 * @return
	 */
	Cliente obtenerPorId(String identificacion);
}
