package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.jpa;

import java.util.List;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.PreordenEntity;

public interface RepositorioPreordenJPA {
	
	/**
	 * Obtiene el listado de preordenes que ha realizado un cliente
	 * @param idCliente
	 * @return
	 */
	List<PreordenEntity> obtenerPreordenesEntityCliente(String idCliente);
	
}
