package com.ceiba.tiendafiguras.infraestructura.adaptador.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.FiguraEntity;

@Repository
public interface DaoFiguraJPA extends CrudRepository<FiguraEntity, String>{

	/**
	 * Obtiene el listado de figuras disponibles para preordenar teniendo en cuenta la fecha de lanzamiento y fecha de llegada dadas
	 * @param fechaLanzamiento
	 * @param fechaLlegada
	 * @return
	 */
	@Query("SELECT figura FROM Figura figura WHERE figura.fechaLanzamiento > :fechaLanzamiento "
			+ "AND figura.fechaLlegada > :fechaLlegada "
			+ "AND figura.unidadesPreventa > (SELECT count(1) FROM Preorden preorden WHERE preorden.figura.id = figura.id )")
	public List<FiguraEntity> obtenerFigurasEntityDisponiblesPreorden(@Param("fechaLanzamiento") LocalDate fechaLanzamiento, @Param("fechaLlegada") LocalDate fechaLlegada);

	/**
	 * Retorna la figura identificada con el id, si esta disponible para ser preordenada, null en caso contrario
	 * @return
	 */
	@Query("SELECT figura FROM Figura figura WHERE figura.id = :id AND "
			+ "figura.fechaLanzamiento > :fechaLanzamiento "
			+ "AND figura.fechaLlegada > :fechaLlegada "
			+ "AND figura.unidadesPreventa > (SELECT count(1) FROM Preorden preorden WHERE preorden.figura.id = figura.id )")
	public Optional<FiguraEntity> figuraEntityDisponiblePreorden(@Param("id") String id, @Param("fechaLanzamiento")	LocalDate fechaLanzamiento,
			@Param("fechaLlegada") LocalDate fechaLlegada);
	
	
}
