package com.ceiba.tiendafiguras.dominio.servicio;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioFigura;

@Component
public class ServicioObtenerFigura {
	
	private RepositorioFigura repositorioFigura;
	
	public ServicioObtenerFigura(RepositorioFigura repositorioFigura) {
		this.repositorioFigura = repositorioFigura;
	}
	
	public List<FiguraDTO> ejecutar() {
		return this.repositorioFigura.obtenerFigurasDisponiblesPreorden();
	}

}
