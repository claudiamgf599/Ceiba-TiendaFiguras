package com.ceiba.tiendafiguras.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;

public class FiguraTestDataBuilder {
	
	private static final String ID = "G-14";
	private static final String NOMBRE = "Goku Transformacion Gold";
	private static final String MARCA = "Bandai";
	private static final LocalDate FECHA_LANZAMIENTO = LocalDate.of(2020, 12, 1);
	private static final LocalDate FECHA_LLEGADA = LocalDate.of(2020, 12, 20);
	private static final int UNIDADES_PREV = 2;
	private static final double PRECIO = 250000;
	
	private String id;
	private String nombre;
	private String marca;
	private LocalDate fechaLanzamiento;
	private LocalDate fechaLlegada;
	private int unidadesPreventa;
	private double precio;
	
	public FiguraTestDataBuilder() {
		this.id = ID;
		this.nombre = NOMBRE;
		this.marca = MARCA;
		this.fechaLanzamiento = FECHA_LANZAMIENTO;
		this.fechaLlegada = FECHA_LLEGADA;
		this.unidadesPreventa = UNIDADES_PREV;
		this.precio = PRECIO;
	}
	
	public FiguraTestDataBuilder conId(String id) {
		this.id = id;
		return this;
	}
	
	public FiguraTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre; 
		return this;
	} 
	
	public FiguraTestDataBuilder conMarca(String marca) {
		this.marca = marca;
		return this;
	} 
	
	public FiguraTestDataBuilder conFechaLanzamiento(LocalDate fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
		return this;
	} 
	
	public FiguraTestDataBuilder conFechaLlegada(LocalDate fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
		return this;
	} 
	
	public FiguraTestDataBuilder conUnidadesPreventa(int unidadesPreventa) {
		this.unidadesPreventa = unidadesPreventa;
		return this;
	} 
	
	public FiguraTestDataBuilder conPrecio(double precio) {
		this.precio = precio; 
		return this;
	} 
	
	public Figura build() {
		return new Figura(id, nombre, marca, fechaLanzamiento, fechaLlegada, unidadesPreventa, precio);
	}	
}

