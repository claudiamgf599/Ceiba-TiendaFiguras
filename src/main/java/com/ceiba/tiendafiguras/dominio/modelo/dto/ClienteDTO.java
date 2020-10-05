package com.ceiba.tiendafiguras.dominio.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {

	private String identificacion;
	
	private String nombres;
	
	private String apellidos;

	public ClienteDTO(String identificacion, String nombres, String apellidos) {
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public ClienteDTO() {

	}
	
	@Override
	public String toString() {
		return "identificacion: " + identificacion + " nombres: " + nombres + " apellidos: " + apellidos;
	}
	
}
