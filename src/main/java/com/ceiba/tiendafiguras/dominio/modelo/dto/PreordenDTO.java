package com.ceiba.tiendafiguras.dominio.modelo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreordenDTO {

	private FiguraDTO figura;
	
	private ClienteDTO cliente; 
	
	private double precioPreorden;
	
	private Date fechaPreorden;

	public PreordenDTO(FiguraDTO figura, ClienteDTO cliente, double precioPreorden, Date fechaPreorden) {
		this.figura = figura;
		this.cliente = cliente;
		this.precioPreorden = precioPreorden;
		this.fechaPreorden = (Date) fechaPreorden.clone();
	}

	public PreordenDTO() {

	}
	
}
