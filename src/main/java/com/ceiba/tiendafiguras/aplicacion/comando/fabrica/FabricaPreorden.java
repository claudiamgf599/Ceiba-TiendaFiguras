package com.ceiba.tiendafiguras.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.tiendafiguras.aplicacion.comando.ComandoPreorden;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;

@Component
public class FabricaPreorden {

	public Preorden crearPreorden(ComandoPreorden comandoPreorden) {
		return new Preorden(comandoPreorden.getIdFigura(), comandoPreorden.getIdCliente());
	}
}
