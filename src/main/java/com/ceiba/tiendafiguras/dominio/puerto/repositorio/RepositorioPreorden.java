package com.ceiba.tiendafiguras.dominio.puerto.repositorio;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;


public interface RepositorioPreorden {

	/**
	 * Genera una preorden para el cliente y figura
	 * @param preorden
	 */
	void generarPreorden(Preorden preorden);
	
}
