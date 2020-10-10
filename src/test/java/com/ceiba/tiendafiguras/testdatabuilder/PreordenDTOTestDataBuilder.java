package com.ceiba.tiendafiguras.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.tiendafiguras.aplicacion.comando.ComandoPreorden;
import com.ceiba.tiendafiguras.dominio.modelo.dto.ClienteDTO;
import com.ceiba.tiendafiguras.dominio.modelo.dto.FiguraDTO;
import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;

public class PreordenDTOTestDataBuilder {

	private static final Long ID = 1L;
	private static final FiguraDTO FIGURA = new FiguraDTOTestDataBuilder().build();
	private static final ClienteDTO CLIENTE = new ClienteDTOTestDataBuilder().build();
	private static final double PRECIO = 140000;
	private static final LocalDate FECHA_PREORDEN = LocalDate.of(2020, 9, 20);
	
	private Long id;
	private FiguraDTO figura;
	private ClienteDTO cliente; 
	private double precio;
	private LocalDate fechaPreorden;
	
	public PreordenDTOTestDataBuilder() {
		this.id = ID; 
		this.figura = FIGURA;
		this.cliente = CLIENTE;
		this.precio = PRECIO; 
		this.fechaPreorden = FECHA_PREORDEN; 
	}	
	
	public PreordenDTOTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public PreordenDTOTestDataBuilder conFigura(FiguraDTO figura) {
		this.figura = figura; 
		return this;
	} 
	
	public PreordenDTOTestDataBuilder conCliente(ClienteDTO cliente) {
		this.cliente = cliente;
		return this;
	} 
	
	public PreordenDTOTestDataBuilder conPrecio(double precio) {
		this.precio = precio;
		return this;
	} 
	
	public PreordenDTOTestDataBuilder conFechaPreorden(LocalDate fechaPreorden) {
		this.fechaPreorden = fechaPreorden;
		return this;
	} 
	
	public PreordenDTO build() {
		return new PreordenDTO(figura, cliente, precio, fechaPreorden, id, true);
	}	
	
	public ComandoPreorden buildComando() {
		return new ComandoPreorden(this.figura.getId(), this.cliente.getIdentificacion());
	}
}
