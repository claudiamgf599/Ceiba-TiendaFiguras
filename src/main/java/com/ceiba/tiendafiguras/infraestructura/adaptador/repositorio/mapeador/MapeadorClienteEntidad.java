package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import com.ceiba.tiendafiguras.dominio.modelo.dto.ClienteDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.ClienteEntity;

public final class MapeadorClienteEntidad {
	
	private MapeadorClienteEntidad() {
		
	}
	
	/**
	 * Convierte un ClienteEntity a un ClienteDTO
	 * @param clienteEntity
	 * @return
	 */
	public static ClienteDTO mapearAModelo(ClienteEntity clienteEntity) {
		if(clienteEntity != null) {
			return new ClienteDTO(clienteEntity.getIdentificacion(), clienteEntity.getNombres(), clienteEntity.getApellidos()); 
		}else {
			return null; 
		}
	}
	
	/**
	 * Convierte un ClienteDTO a un ClienteEntity
	 * @param clienteDTO
	 * @return
	 */
	public static ClienteEntity mapearAEntidad(ClienteDTO clienteDTO) {
		if(clienteDTO != null) {
			return new ClienteEntity(clienteDTO.getIdentificacion(), clienteDTO.getNombres(), clienteDTO.getApellidos());
		}else {
			return null;
		}
	}
}
