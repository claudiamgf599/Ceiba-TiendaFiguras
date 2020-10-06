package com.ceiba.tiendafiguras.dominio.modelo.entidad;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class Figura {

	private String id;
	private String nombre;
	private String marca;
	private LocalDate fechaLanzamiento;
	private LocalDate fechaLlegada;
	private int unidadesPreventa;
	private double precio;
	
	private static final String ID_OBLIGATORIO = "El id de la figura es obligatorio";
	private static final String MARCA_OBLIGATORIA = "La marca de la figura es obligatoria";
	private static final String PRECIO_OBLIGATORIO = "El precio de la figura es obligatorio";
	
	public Figura(String id, String nombre, String marca, LocalDate fechaLanzamiento, LocalDate fechaLlegada,
			int unidadesPreventa, double precio) {
		
		ValidadorArgumentos.validarObligatorio(id, ID_OBLIGATORIO);
		ValidadorArgumentos.validarObligatorio(nombre, MARCA_OBLIGATORIA);
		ValidadorArgumentos.validarObligatorio(marca, PRECIO_OBLIGATORIO);
		
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.fechaLanzamiento = fechaLanzamiento;
		this.fechaLlegada = fechaLlegada;
		this.unidadesPreventa = unidadesPreventa;
		this.precio = precio;
	}
	
	public Figura(String id) {
		ValidadorArgumentos.validarObligatorio(id, ID_OBLIGATORIO);
		this.id = id;
	}
	
}
