package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio;

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

	private static final String FIGURA_FIN_PREORDENABLES = "Figura.findPreordenables";
	
	private EntityManager entityManager;
	
	public RepositorioFiguraPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FiguraEntity> obtenerFigurasEntityDisponiblesPreorden() {

		Query query =  entityManager.createNamedQuery(FIGURA_FIN_PREORDENABLES);
		List<FiguraEntity> figuras = query.getResultList();
		System.out.println(figuras.size());
		return figuras;
	}

	@Override
	public List<FiguraDTO> obtenerFigurasDisponiblesPreorden() {
		List<FiguraEntity> figurasEntity = obtenerFigurasEntityDisponiblesPreorden();
		return figurasEntity.stream().map(MapeadorFiguraEntidad::mapearAModelo).collect(Collectors.toList());
	}

}
