package com.ceiba.tiendafiguras.aplicacion.consulta;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;
import com.ceiba.tiendafiguras.dominio.servicio.ServicioObtenerFigura;

@Service
public class ManejadorConsultarFiguras {

	private final ServicioObtenerFigura servicioObtenerFigura;
	
	public ManejadorConsultarFiguras(ServicioObtenerFigura servicioObtenerFigura) {
		this.servicioObtenerFigura = servicioObtenerFigura;
	}
	
	@Transactional
	public List<FiguraDTO> ejecutar(){
		return this.servicioObtenerFigura.ejecutar();
	}
}
