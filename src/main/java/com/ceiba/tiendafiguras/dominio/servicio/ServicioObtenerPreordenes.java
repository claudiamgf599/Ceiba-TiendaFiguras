package com.ceiba.tiendafiguras.dominio.servicio;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioPreorden;

@Component
public class ServicioObtenerPreordenes {

	RepositorioPreorden repositorioPreorden;
	
	public ServicioObtenerPreordenes(RepositorioPreorden repositorioPreorden) {
		this.repositorioPreorden = repositorioPreorden;
	}
	
	public List<PreordenDTO> ejecutar(String identificacionCliente) {
		return this.repositorioPreorden.obtenerPreordenesCliente(identificacionCliente);
	}
}
