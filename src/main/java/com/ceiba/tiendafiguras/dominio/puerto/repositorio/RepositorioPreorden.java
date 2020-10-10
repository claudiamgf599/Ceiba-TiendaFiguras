package com.ceiba.tiendafiguras.dominio.puerto.repositorio;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;


public interface RepositorioPreorden {

	/**
	 * Genera una preorden para el cliente y figura
	 * @param preorden
	 */
	Preorden generarPreorden(Preorden preorden);
	
	/**
	 * Elimina una preorden identificada por el id
	 * @param id
	 */
	void eliminarPreorden(Long id);
	
	/**
	 * Obtiene la �ltima preorden que ha realizado el cliente
	 * @param identificacionCliente
	 * @return
	 */
	Preorden obtenerUltimaPreordenCliente(String identificacionCliente);
	
	/**
	 * Recupera una preorden dado su identificador �nico
	 * @param idPreorden
	 * @return
	 */
	Preorden obtenerPreordenById(Long idPreorden);
	
}
