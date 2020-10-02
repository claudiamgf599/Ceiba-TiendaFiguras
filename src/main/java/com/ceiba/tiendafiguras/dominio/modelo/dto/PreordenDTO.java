package com.ceiba.tiendafiguras.dominio.modelo.dto;

import java.util.Date;

public class PreordenDTO {

	private FiguraDTO figura;
	
	private ClienteDTO cliente; 
	
	private double precioPreorden;
	
	private Date fechaPreorden;

	public FiguraDTO getFigura() {
		return figura;
	}

	public void setFigura(FiguraDTO figura) {
		this.figura = figura;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public double getPrecioPreorden() {
		return precioPreorden;
	}

	public void setPrecioPreorden(double precioPreorden) {
		this.precioPreorden = precioPreorden;
	}

	public Date getFechaPreorden() {
		return fechaPreorden;
	}

	public void setFechaPreorden(Date fechaPreorden) {
		this.fechaPreorden = fechaPreorden;
	}

	public PreordenDTO(FiguraDTO figura, ClienteDTO cliente, double precioPreorden, Date fechaPreorden) {
		this.figura = figura;
		this.cliente = cliente;
		this.precioPreorden = precioPreorden;
		this.fechaPreorden = fechaPreorden;
	}

	public PreordenDTO() {

	}
	
}
