package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Cliente;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.tiendafiguras.infraestructura.adaptador.dao.DaoClienteJPA;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.ClienteEntity;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador.MapeadorClienteEntidad;

@Repository
public class RepositorioClientePersistente implements RepositorioCliente {

	private DaoClienteJPA daoCliente;
	
	public RepositorioClientePersistente(DaoClienteJPA daoCliente) {
		this.daoCliente = daoCliente;
	}

	@Override
	public Cliente obtenerPorId(String identificacion) {
		Optional<ClienteEntity> clienteEntity = daoCliente.findById(identificacion);
		return MapeadorClienteEntidad.mapearAModelo(clienteEntity.orElse(null));
	}
 
}
