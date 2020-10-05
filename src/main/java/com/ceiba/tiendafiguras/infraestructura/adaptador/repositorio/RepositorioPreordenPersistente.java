package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.ClienteEntity;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.FiguraEntity;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.PreordenEntity;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioPreorden;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.jpa.RepositorioClienteJPA;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.jpa.RepositorioFiguraJPA;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.jpa.RepositorioPreordenJPA;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador.MapeadorPreordenEntidad;

@Repository
public class RepositorioPreordenPersistente implements RepositorioPreorden, RepositorioPreordenJPA {

	private static final String PREORDEN_POR_CLIENTE = "Preorden.findByCliente";
	private static final String ID_CLIENTE = "idCliente";
	
	private EntityManager entityManager;
	private RepositorioFiguraJPA repositorioFiguraJPA;
	private RepositorioClienteJPA repositorioClienteJPA;
	
	public RepositorioPreordenPersistente(EntityManager entityManager, RepositorioFiguraJPA repositorioProductoJPA,
			RepositorioClienteJPA repositorioClienteJPA) {
		this.entityManager = entityManager;
		this.repositorioFiguraJPA = repositorioProductoJPA;
		this.repositorioClienteJPA = repositorioClienteJPA;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PreordenEntity> obtenerPreordenesEntityCliente(String idCliente) {
		Query query =  entityManager.createNamedQuery(PREORDEN_POR_CLIENTE);
		query.setParameter(ID_CLIENTE, idCliente);
		return query.getResultList();
	}
	
	@Override
	public List<PreordenDTO> obtenerPreordenesCliente(String identificacionCliente) {
		List<PreordenEntity> preordenesEntity = obtenerPreordenesEntityCliente(identificacionCliente);
		return preordenesEntity.stream().map(MapeadorPreordenEntidad::mapearAModelo).collect(Collectors.toList());
	}

	@Override
	public void generarPreorden(PreordenDTO preorden) {
		PreordenEntity preordenEntity = buildPreordenEntity(preorden);
		entityManager.persist(preordenEntity);
	}
	
	private PreordenEntity buildPreordenEntity(PreordenDTO preorden) {
		ClienteEntity clienteEntity = repositorioClienteJPA.obtenerClienteEntityPorId(preorden.getCliente().getIdentificacion());
		FiguraEntity figuraEntity = repositorioFiguraJPA.obtenerFiguraEntityPorId(preorden.getFigura().getId());
		PreordenEntity preordenEntity = new PreordenEntity();
		preordenEntity.setCliente(clienteEntity);
		preordenEntity.setFigura(figuraEntity);
		preordenEntity.setFechaPreorden(preorden.getFechaPreorden());
		preordenEntity.setPrecio(preorden.getPrecioPreorden());
		return preordenEntity;
	}

}
