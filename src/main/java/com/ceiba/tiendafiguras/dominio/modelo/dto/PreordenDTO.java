package com.ceiba.tiendafiguras.dominio.modelo.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreordenDTO {

	private Long id;
	
	private FiguraDTO figura;
	
	private ClienteDTO cliente; 
	
	private double precioPreorden;
	
	private LocalDate fechaPreorden;
	
	private boolean puedeCancelarPreorden;

	public PreordenDTO(FiguraDTO figura, ClienteDTO cliente, double precioPreorden, LocalDate fechaPreorden, Long id, boolean puedeCancelarPreorden) {
		this.figura = figura;
		this.cliente = cliente;
		this.precioPreorden = precioPreorden;
		this.id = id;
		this.fechaPreorden = fechaPreorden;
		this.puedeCancelarPreorden = puedeCancelarPreorden;
	}
	
	public PreordenDTO() {

	}
	
	@Override
	public String toString() {
		return "figura: " + figura.toString() + " cliente: " + cliente.toString() + " precioPreorden: " + precioPreorden + " fechaPreorden: " 
				+ fechaPreorden + " id: " + id + " puedeCancelarPreorden: " + puedeCancelarPreorden;
	}
	
}
