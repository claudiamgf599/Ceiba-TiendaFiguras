package com.ceiba.tiendafiguras.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.tiendafiguras.aplicacion.comando.ComandoPreorden;
import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;

@Component
public class FabricaPreorden {

	public PreordenDTO crearPreorden(ComandoPreorden comandoPreorden) {
		return new PreordenDTO(comandoPreorden.getIdFigura(), comandoPreorden.getIdCliente());
	}
}
