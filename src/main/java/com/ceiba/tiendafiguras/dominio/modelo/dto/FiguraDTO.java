package com.ceiba.tiendafiguras.dominio.modelo.dto;

import java.util.Date;

public class FiguraDTO {

	private String id;
	
	private String nombre;
	
	private String marca;
	
	private Date fechaLanzamiento;

	private Date fechaLlegada;

	private int unidadesPreventa;
	
	private double precio;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public int getUnidadesPreventa() {
		return unidadesPreventa;
	}

	public void setUnidadesPreventa(int unidadesPreventa) {
		this.unidadesPreventa = unidadesPreventa;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public FiguraDTO(String id, String nombre, String marca, Date fechaLanzamiento, Date fechaLlegada,
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


}
