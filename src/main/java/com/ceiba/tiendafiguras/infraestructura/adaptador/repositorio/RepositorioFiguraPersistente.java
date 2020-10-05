package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.FiguraEntity;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioFigura;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.jpa.RepositorioFiguraJPA;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.mapeador.MapeadorFiguraEntidad;

@Repository
public class RepositorioFiguraPersistente implements RepositorioFigura, RepositorioFiguraJPA {

	private static final String FECHA_BASE_LANZAMIENTO = "fechaLanzamiento";
	private static final String FECHA_BASE_LLEGADA = "fechaLlegada";
	private static final String FIGURA_FIND_PREORDENABLES = "Figura.findPreordenables";
	private static final String ID = "id";
	private static final String FIGURA_FIND_BY_ID = "Figura.findById";
	private static final String FIGURA_DISPONIBLE_PREORDEN = "Figura.disponiblePreorden";
	
	private EntityManager entityManager;
	
	public RepositorioFiguraPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<FiguraDTO> obtenerFigurasDisponiblesPreorden() {
		Date fechaBase = new Date(); 
		List<FiguraEntity> figurasEntity = obtenerFigurasEntityDisponiblesPreorden(fechaBase, fechaBase);
		return figurasEntity.stream().map(MapeadorFiguraEntidad::mapearAModelo).collect(Collectors.toList());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<FiguraEntity> obtenerFigurasEntityDisponiblesPreorden(Date fechaLanzamiento, Date fechaLlegada) {
		Query query =  entityManager.createNamedQuery(FIGURA_FIND_PREORDENABLES);
		query.setParameter(FECHA_BASE_LANZAMIENTO, fechaLanzamiento);
		query.setParameter(FECHA_BASE_LLEGADA, fechaLlegada);
		return query.getResultList();
	}

	@Override
	public FiguraEntity obtenerFiguraEntityPorId(String id) {
		Query query = entityManager.createNamedQuery(FIGURA_FIND_BY_ID);
		query.setParameter(ID, id);

		return (FiguraEntity) query.getSingleResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public FiguraEntity figuraEntityDisponiblePreorden(String id) {
		Query query =  entityManager.createNamedQuery(FIGURA_DISPONIBLE_PREORDEN);
		Date fechaBase = new Date();
		FiguraEntity figuraRetorno = null; 
		query.setParameter(FECHA_BASE_LANZAMIENTO, fechaBase);
		query.setParameter(FECHA_BASE_LLEGADA, fechaBase);
		query.setParameter(ID, id);
		
		ArrayList<FiguraEntity> figurasEntity = (ArrayList<FiguraEntity>)query.getResultList();
		if(!figurasEntity.isEmpty()){
			figuraRetorno = figurasEntity.get(0);
		}
		return figuraRetorno;
	}

	@Override
	public FiguraDTO obtenerFiguraDisponiblePreorden(String id) {
		FiguraEntity figuraDisponible = figuraEntityDisponiblePreorden(id);
		return MapeadorFiguraEntidad.mapearAModelo(figuraDisponible);
	}
}
