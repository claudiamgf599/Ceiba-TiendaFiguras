package com.ceiba.tiendafiguras.infraestructura.adaptador.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.ClienteEntity;

@Repository
public interface DaoClienteJPA extends CrudRepository<ClienteEntity, String> {

	
}
