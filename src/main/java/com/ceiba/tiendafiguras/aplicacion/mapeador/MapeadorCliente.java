package com.ceiba.tiendafiguras.aplicacion.mapeador;

import com.ceiba.tiendafiguras.dominio.modelo.dto.ClienteDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Cliente;

public final class MapeadorCliente {

	private MapeadorCliente() {
	}
	
	/**
	 * Convierte un ClienteDTO a un Cliente
	 * @param clienteDTO
	 * @return
	 */
	public static Cliente mapearAEntidad(ClienteDTO clienteDTO) {
		if(clienteDTO != null) {
			return new Cliente(clienteDTO.getIdentificacion(), clienteDTO.getNombres(), clienteDTO.getApellidos()); 
		}else {
			return null; 
		}
	}
	
	/**
	 * Convierte un Cliente a un ClienteDTO
	 * @param cliente
	 * @return
	 */
	public static ClienteDTO mapearADTO(Cliente cliente) {
		if(cliente != null) {
			return new ClienteDTO(cliente.getIdentificacion(), cliente.getNombres(), cliente.getApellidos());
		}else {
			return null;
		}
	}
}
