package com.ceiba.tiendafiguras.aplicacion.consulta;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.tiendafiguras.aplicacion.mapeador.MapeadorFigura;
import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;
import com.ceiba.tiendafiguras.dominio.puerto.dao.DaoFigura;

@Component
public class ManejadorConsultarFiguras {

	private final DaoFigura daoFigura;
	
	public ManejadorConsultarFiguras(DaoFigura daoFigura) {
		this.daoFigura = daoFigura;
	}
	
	@Transactional
	public List<FiguraDTO> ejecutar(){
		List<Figura> figurasDominio = daoFigura.obtenerFigurasDisponiblesPreorden();
		return figurasDominio.stream().map(MapeadorFigura::mapearADTO).collect(Collectors.toList());
	}
}
