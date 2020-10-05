package com.ceiba.tiendafiguras.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;

/**
 * Registra una preorden
 * @author claudia.gomez
 *
 */
public interface RepositorioPreorden {

	void generarPreorden(PreordenDTO preorden);
	
	List<PreordenDTO> obtenerPreordenesCliente(String identificacionCliente);
}
