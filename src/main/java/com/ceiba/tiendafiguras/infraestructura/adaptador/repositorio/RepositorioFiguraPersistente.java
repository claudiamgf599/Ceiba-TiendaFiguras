package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioFigura;
import com.ceiba.tiendafiguras.infraestructura.adaptador.dao.DaoFiguraJPA;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.FiguraEntity;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador.MapeadorFiguraEntidad;

@Repository
public class RepositorioFiguraPersistente implements RepositorioFigura {

	private final DaoFiguraJPA repositorio;
	
	public RepositorioFiguraPersistente(DaoFiguraJPA repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Figura obtenerFiguraDisponiblePreorden(String id) {
		LocalDate fechaBase = LocalDate.now();
		Optional<FiguraEntity> figuraDisponible = repositorio.figuraEntityDisponiblePreorden(id, fechaBase, fechaBase);
		return MapeadorFiguraEntidad.mapearAModelo(figuraDisponible.orElse(null));
	}

}
