package com.ceiba.tiendafiguras.dominio.modelo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PreordenDTO {

	private Long id;
	
	private FiguraDTO figura;
	
	private ClienteDTO cliente; 
	
	private double precioPreorden;
	
	private Date fechaPreorden;

	public PreordenDTO(FiguraDTO figura, ClienteDTO cliente, double precioPreorden, Date fechaPreorden, Long id) {
		this.figura = figura;
		this.cliente = cliente;
		this.precioPreorden = precioPreorden;
		this.id = id;
		this.fechaPreorden = (Date) fechaPreorden.clone();
	}
	
	public PreordenDTO(String idFigura, String idCliente) {
		FiguraDTO figuraDTO = new FiguraDTO();
		figuraDTO.setId(idFigura);
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setIdentificacion(idCliente);
		this.setFigura(figuraDTO);
		this.setCliente(clienteDTO);
	}

	public PreordenDTO() {

	}
	
	@Override
	public String toString() {
		return "figura: " + figura.toString() + " cliente: " + cliente.toString() + " precioPreorden: " + precioPreorden + " fechaPreorden: " 
				+ fechaPreorden + " id: " + id;
	}
	
}
