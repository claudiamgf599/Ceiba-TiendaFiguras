package com.ceiba.tiendafiguras.testdatabuilder;

import com.ceiba.tiendafiguras.dominio.modelo.dto.ClienteDTO;

public class ClienteDTOTestDataBuilder {

	private static final String ID = "C43259599";
	private static final String NOMBRES = "Claudia Maria";
	private static final String APELLIDOS = "Gómez Flórez";
	
	private String identificacion;
	private String nombres;
	private String apellidos;
	
	public ClienteDTOTestDataBuilder() {
		this.identificacion = ID;
		this.nombres = NOMBRES;
		this.apellidos = APELLIDOS;
	}
	
	public ClienteDTOTestDataBuilder conIdentificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}
	
	public ClienteDTOTestDataBuilder conNombres(String nombres) {
		this.nombres = nombres; 
		return this;
	} 
	
	public ClienteDTOTestDataBuilder conApellidos(String apellidos) {
		this.apellidos = apellidos;
		return this;
	} 
	
	public ClienteDTO build() {
		return new ClienteDTO(identificacion, nombres, apellidos);
	}	
}
