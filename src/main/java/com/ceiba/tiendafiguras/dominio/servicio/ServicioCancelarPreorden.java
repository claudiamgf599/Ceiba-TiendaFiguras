package com.ceiba.tiendafiguras.dominio.servicio;

import org.springframework.stereotype.Component;

import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioPreorden;

@Component
public class ServicioCancelarPreorden {

	private RepositorioPreorden repositorioPreorden;
	
	public ServicioCancelarPreorden(RepositorioPreorden repositorioPreorden) {
		this.repositorioPreorden = repositorioPreorden;
	}

	public void cancelarPreorden(Long id) {
		System.out.println(" ++++ Cancelar preorden Service "); //TODO - VALIDACIONES E IMPLEMENTACIÓN
		repositorioPreorden.eliminarPreorden(id);
	}
	
}
