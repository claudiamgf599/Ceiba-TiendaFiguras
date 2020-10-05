package com.ceiba.tiendafiguras.testdatabuilder;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.ClienteEntity;

public class ClienteEntityTestDataBuilder {

	private static final String ID = "C43259599";
	private static final String NOMBRES = "Claudia Maria";
	private static final String APELLIDOS = "Gómez Flórez";
	
	private String identificacion;
	private String nombres;
	private String apellidos;
	
	public ClienteEntityTestDataBuilder() {
		this.identificacion = ID;
		this.nombres = NOMBRES;
		this.apellidos = APELLIDOS;
	}
	
	public ClienteEntityTestDataBuilder conIdentificacion(String identificacion) {
		this.identificacion = identificacion; 
		return this;
	} 
	
	public ClienteEntityTestDataBuilder conNombres(String nombres) {
		this.nombres = nombres; 
		return this;
	} 
	
	public ClienteEntityTestDataBuilder conApellidos(String apellidos) {
		this.apellidos = apellidos; 
		return this;
	}
	
	public ClienteEntity build() {
		return new ClienteEntity(identificacion, nombres, apellidos);
	}
}
