package com.ceiba.tiendafiguras.dominio.servicio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ceiba.tiendafiguras.dominio.excepcion.ClienteExcepcion;
import com.ceiba.tiendafiguras.dominio.excepcion.PreordenExcepcion;
import com.ceiba.tiendafiguras.dominio.modelo.dto.ClienteDTO;
import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;
import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioFigura;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioPreorden;

@Component
public class ServicioGenerarPreorden {
	
	private RepositorioPreorden repositorioPreorden;
	private RepositorioFigura repositorioFigura;
	private RepositorioCliente repositorioCliente;

	public ServicioGenerarPreorden(RepositorioPreorden repositorioPreorden, RepositorioFigura repositorioFigura, RepositorioCliente repositorioCliente) {
		this.repositorioPreorden = repositorioPreorden;
		this.repositorioFigura = repositorioFigura;
		this.repositorioCliente = repositorioCliente;
	}
	
	@Value("${texto.serviciogenerarpreorden.productonodisponible}")
	private String textoProductoNoDisponible;
	
	@Value("${texto.serviciogenerarpreorden.clientenoexiste}")
	private String textoClienteNoExiste;
	
	/**
	 * Genera una preorden para el cliente y la figura 
	 * @param preorden
	 */
	public void ejecutar(PreordenDTO preorden) {
		ClienteDTO cliente = repositorioCliente.obtenerPorId(preorden.getCliente().getIdentificacion());
		if(cliente == null) {
			throw new ClienteExcepcion(textoClienteNoExiste);
		}
		
		if(!isFiguraDisponiblePreorden(preorden.getFigura().getId())) {
			throw new PreordenExcepcion(textoProductoNoDisponible);
		}
		
		preorden.setFechaPreorden(new Date());
		preorden.setPrecioPreorden(100000);  //TODO - calcular el precio
		
		repositorioPreorden.generarPreorden(preorden);
	}
	
	/**
	 * Indica si la figura identificada con el idFigura está disponible en stock para ser preordenada
	 * @param idFigura
	 * @return
	 */
	public boolean isFiguraDisponiblePreorden(String idFigura) {
		boolean isPreordenable = true;
		FiguraDTO figura = repositorioFigura.obtenerFiguraDisponiblePreorden(idFigura);
		if(figura == null) {
			isPreordenable = false;
		}
		return isPreordenable;
	}

}
