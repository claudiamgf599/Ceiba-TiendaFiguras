package com.ceiba.tiendafiguras.dominio.modelo.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiguraDTO {

	private String id;
	
	private String nombre;
	
	private String marca;
	
	private LocalDate fechaLanzamiento;

	private LocalDate fechaLlegada;

	private int unidadesPreventa;
	
	private double precio;

	public FiguraDTO(String id, String nombre, String marca, LocalDate fechaLanzamiento, LocalDate fechaLlegada,
			int unidadesPreventa, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.fechaLanzamiento = fechaLanzamiento;
		this.fechaLlegada = fechaLlegada;
		this.unidadesPreventa = unidadesPreventa;
		this.precio = precio;
	}

	public FiguraDTO() {
		
	}

	@Override
	public String toString() {
		return "id: " + id + " nombre: " + nombre + " marca: " + marca + " fechaLanzamiento: " 
				+ fechaLanzamiento + " fechaLlegada: " + fechaLlegada + " unidadesPreventa: " + unidadesPreventa + " precio: " + precio;
	}

}
