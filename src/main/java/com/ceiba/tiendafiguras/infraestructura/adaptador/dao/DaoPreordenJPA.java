package com.ceiba.tiendafiguras.infraestructura.adaptador.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.PreordenEntity;

@Repository
public interface DaoPreordenJPA extends CrudRepository<PreordenEntity, Long> {
	
	@Query("SELECT preorden FROM Preorden preorden WHERE preorden.cliente.identificacion = :idCliente "
			+ "ORDER BY fechaPreorden DESC")
	public List<PreordenEntity> obtenerPreordenesEntityCliente(@Param("idCliente") String idCliente);

}
