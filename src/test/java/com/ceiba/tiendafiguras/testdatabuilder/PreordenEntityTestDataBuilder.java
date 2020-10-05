package com.ceiba.tiendafiguras.testdatabuilder;

import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.ClienteEntity;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.FiguraEntity;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.PreordenEntity;

public class PreordenEntityTestDataBuilder {

	private static final Long ID = 1L;
	private static final FiguraEntity FIGURA = new FiguraEntityTestDataBuilder().build();
	private static final ClienteEntity CLIENTE = new ClienteEntityTestDataBuilder().build();
	private static final double PRECIO = 140000;
	private static final Date FECHA_PREORDEN = new GregorianCalendar(2020, 9, 20).getTime();
	
	private Long id;
	private FiguraEntity figura;
	private ClienteEntity cliente; 
	private double precio;
	private Date fechaPreorden;
	
	public PreordenEntityTestDataBuilder() {
		this.id = ID; 
		this.figura = FIGURA;
		this.cliente = CLIENTE;
		this.precio = PRECIO; 
		this.fechaPreorden = FECHA_PREORDEN; 
	}	
	
	public PreordenEntityTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public PreordenEntityTestDataBuilder conFigura(FiguraEntity figura) {
		this.figura = figura; 
		return this;
	} 
	
	public PreordenEntityTestDataBuilder conCliente(ClienteEntity cliente) {
		this.cliente = cliente;
		return this;
	} 
	
	public PreordenEntityTestDataBuilder conPrecio(double precio) {
		this.precio = precio;
		return this;
	} 
	
	public PreordenEntityTestDataBuilder conFechaPreorden(Date fechaPreorden) {
		this.fechaPreorden = fechaPreorden;
		return this;
	} 
	
	public PreordenEntity build() {
		return new PreordenEntity(id, figura, cliente, precio, fechaPreorden);
	}

}
