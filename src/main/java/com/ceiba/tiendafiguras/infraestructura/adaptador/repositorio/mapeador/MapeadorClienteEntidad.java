package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Cliente;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.ClienteEntity;

public final class MapeadorClienteEntidad {
	
	private MapeadorClienteEntidad() {
		
	}
	
	/**
	 * Convierte un ClienteEntity a un Cliente
	 * @param clienteEntity
	 * @return
	 */
	public static Cliente mapearAModelo(ClienteEntity clienteEntity) {
		if(clienteEntity != null) {
			return new Cliente(clienteEntity.getIdentificacion(), clienteEntity.getNombres(), clienteEntity.getApellidos()); 
		}else {
			return null; 
		}
	}
	
	/**
	 * Convierte un Cliente a un ClienteEntity
	 * @param cliente
	 * @return
	 */
	public static ClienteEntity mapearAEntidad(Cliente cliente) {
		if(cliente != null) {
			return new ClienteEntity(cliente.getIdentificacion(), cliente.getNombres(), cliente.getApellidos());
		}else {
			return null;
		}
	}
}
