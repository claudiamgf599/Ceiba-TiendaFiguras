package com.ceiba.tiendafiguras.testdatabuilder;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Cliente;

public class ClienteTestDataBuilder {

	private static final String ID = "C43259599";
	private static final String NOMBRES = "Claudia Maria";
	private static final String APELLIDOS = "Gomez Florez";
	
	private String identificacion;
	private String nombres;
	private String apellidos;
	
	public ClienteTestDataBuilder() {
		this.identificacion = ID;
		this.nombres = NOMBRES;
		this.apellidos = APELLIDOS;
	}
	
	public ClienteTestDataBuilder conIdentificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}
	
	public ClienteTestDataBuilder conNombres(String nombres) {
		this.nombres = nombres; 
		return this;
	} 
	
	public ClienteTestDataBuilder conApellidos(String apellidos) {
		this.apellidos = apellidos;
		return this;
	} 
	
	public Cliente build() {
		return new Cliente(identificacion, nombres, apellidos);
	}	
}

