package com.ceiba.tiendafiguras.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.tiendafiguras.aplicacion.comando.ComandoPreorden;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Cliente;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;

public class PreordenTestDataBuilder {

	private static final Long ID = 1L;
	private static final Figura FIGURA = new FiguraTestDataBuilder().build();
	private static final Cliente CLIENTE = new ClienteTestDataBuilder().build();
	private static final double PRECIO = 140000;
	private static final LocalDate FECHA_PREORDEN = LocalDate.of(2020, 9, 20);
	
	private Long id;
	private Figura figura;
	private Cliente cliente; 
	private double precio;
	private LocalDate fechaPreorden;
	
	public PreordenTestDataBuilder() {
		this.id = ID; 
		this.figura = FIGURA;
		this.cliente = CLIENTE;
		this.precio = PRECIO; 
		this.fechaPreorden = FECHA_PREORDEN; 
	}	
	
	public PreordenTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public PreordenTestDataBuilder conFigura(Figura figura) {
		this.figura = figura; 
		return this;
	} 
	
	public PreordenTestDataBuilder conCliente(Cliente cliente) {
		this.cliente = cliente;
		return this;
	} 
	
	public PreordenTestDataBuilder conPrecio(double precio) {
		this.precio = precio;
		return this;
	} 
	
	public PreordenTestDataBuilder conFechaPreorden(LocalDate fechaPreorden) {
		this.fechaPreorden = fechaPreorden;
		return this;
	} 
	
	public Preorden build() {
		return new Preorden(id, figura, cliente, precio, fechaPreorden);
	}	
	
	public ComandoPreorden buildComando() {
		return new ComandoPreorden(this.figura.getId(), this.cliente.getIdentificacion());
	}
}

