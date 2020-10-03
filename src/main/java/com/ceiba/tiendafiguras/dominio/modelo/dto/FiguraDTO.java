package com.ceiba.tiendafiguras.dominio.modelo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiguraDTO {

	private String id;
	
	private String nombre;
	
	private String marca;
	
	private Date fechaLanzamiento;

	private Date fechaLlegada;

	private int unidadesPreventa;
	
	private double precio;

	public FiguraDTO(String id, String nombre, String marca, Date fechaLanzamiento, Date fechaLlegada,
			int unidadesPreventa, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.fechaLanzamiento = (Date) fechaLanzamiento.clone();
		this.fechaLlegada = (Date) fechaLlegada.clone();
		this.unidadesPreventa = unidadesPreventa;
		this.precio = precio;
	}

	public FiguraDTO() {
		
	}


}
