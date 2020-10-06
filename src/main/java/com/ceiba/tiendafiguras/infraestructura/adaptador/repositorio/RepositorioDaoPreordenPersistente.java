package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;
import com.ceiba.tiendafiguras.dominio.puerto.dao.DaoPreorden;
import com.ceiba.tiendafiguras.infraestructura.adaptador.dao.DaoPreordenJPA;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.PreordenEntity;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador.MapeadorPreordenEntidad;

@Repository
public class RepositorioDaoPreordenPersistente implements DaoPreorden {

	private final DaoPreordenJPA repositorio;
	
	public RepositorioDaoPreordenPersistente(DaoPreordenJPA repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public List<Preorden> obtenerPreordenesCliente(String identificacionCliente) {
		List<PreordenEntity> preordenesEntity = repositorio.obtenerPreordenesEntityCliente(identificacionCliente);
		return preordenesEntity.stream().map(MapeadorPreordenEntidad::mapearAModelo).collect(Collectors.toList());
	}

}
