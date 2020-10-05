package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ceiba.tiendafiguras.dominio.modelo.dto.ClienteDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.ClienteEntity;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.jpa.RepositorioClienteJPA;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador.MapeadorClienteEntidad;

@Repository
public class RepositorioClientePersistente implements RepositorioCliente, RepositorioClienteJPA {

	private static final String ID = "identificacion";
	private static final String CLIENTE_FIND_BY_ID = "Cliente.findById";
	
	private EntityManager entityManager;
	
	public RepositorioClientePersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public ClienteEntity obtenerClienteEntityPorId(String identificacion) {
		Query query = entityManager.createNamedQuery(CLIENTE_FIND_BY_ID);
		query.setParameter(ID, identificacion);

		return (ClienteEntity) query.getSingleResult();
	}

	@Override
	public ClienteDTO obtenerPorId(String identificacion) {
		ClienteEntity clienteEntity = obtenerClienteEntityPorId(identificacion);
		return MapeadorClienteEntidad.mapearAModelo(clienteEntity);
	}
 
}
