package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;
import com.ceiba.tiendafiguras.dominio.puerto.dao.DaoFigura;
import com.ceiba.tiendafiguras.infraestructura.adaptador.dao.DaoFiguraJPA;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.FiguraEntity;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador.MapeadorFiguraEntidad;

@Repository
public class RepositorioDaoFiguraPersistente implements DaoFigura {

	private final DaoFiguraJPA repositorio;
	
	public RepositorioDaoFiguraPersistente(DaoFiguraJPA repositorio) {
		this.repositorio = repositorio;
	}
	
	@Override
	public List<Figura> obtenerFigurasDisponiblesPreorden() {
		LocalDate fechaBase = LocalDate.now(); 
		List<FiguraEntity> figurasEntity = repositorio.obtenerFigurasEntityDisponiblesPreorden(fechaBase, fechaBase);
		return figurasEntity.stream().map(MapeadorFiguraEntidad::mapearAModelo).collect(Collectors.toList());
	}
	
	
	
}
