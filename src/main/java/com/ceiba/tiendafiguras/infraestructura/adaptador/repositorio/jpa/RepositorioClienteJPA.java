package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.jpa;

import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.ClienteEntity;

public interface RepositorioClienteJPA {

	/**
	 * Obtiene un cliente entity identificado por el valor identificacion
	 * @param identificacion
	 * @return
	 */
	ClienteEntity obtenerClienteEntityPorId(String identificacion);
}
