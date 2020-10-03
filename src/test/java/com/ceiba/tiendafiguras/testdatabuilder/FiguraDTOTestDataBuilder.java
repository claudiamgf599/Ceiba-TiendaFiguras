package com.ceiba.tiendafiguras.testdatabuilder;

import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;

public class FiguraDTOTestDataBuilder {
	
	private static final String ID = "G-14";
	private static final String NOMBRE = "Goku Transformación Gold";
	private static final String MARCA = "Bandai";
	private static final Date FECHA_LANZAMIENTO = new GregorianCalendar(2020, 12, 1).getTime();
	private static final Date FECHA_LLEGADA = new GregorianCalendar(2020, 12, 20).getTime();
	private static final int UNIDADES_PREV = 2;
	private static final double PRECIO = 250000;
	
	private String id;
	private String nombre;
	private String marca;
	private Date fechaLanzamiento;
	private Date fechaLlegada;
	private int unidadesPreventa;
	private double precio;
	
	public FiguraDTOTestDataBuilder() {
		this.id = ID;
		this.nombre = NOMBRE;
		this.marca = MARCA;
		this.fechaLanzamiento = FECHA_LANZAMIENTO;
		this.fechaLlegada = FECHA_LLEGADA;
		this.unidadesPreventa = UNIDADES_PREV;
		this.precio = PRECIO;
	}
	
	public FiguraDTOTestDataBuilder conId(String id) {
		this.id = id;
		return this;
	}
	
	public FiguraDTOTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre; 
		return this;
	} 
	
	public FiguraDTOTestDataBuilder conMarca(String marca) {
		this.marca = marca;
		return this;
	} 
	
	public FiguraDTOTestDataBuilder conFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
		return this;
	} 
	
	public FiguraDTOTestDataBuilder conFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
		return this;
	} 
	
	public FiguraDTOTestDataBuilder conUnidadesPreventa(int unidadesPreventa) {
		this.unidadesPreventa = unidadesPreventa;
		return this;
	} 
	
	public FiguraDTOTestDataBuilder conPrecio(double precio) {
		this.precio = precio; 
		return this;
	} 
	
	public FiguraDTO build() {
		return new FiguraDTO(id, nombre, marca, fechaLanzamiento, fechaLlegada, unidadesPreventa, precio);
	}	
}
