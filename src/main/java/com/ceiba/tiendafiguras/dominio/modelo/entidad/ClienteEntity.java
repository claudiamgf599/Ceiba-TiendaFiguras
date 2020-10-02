package com.ceiba.tiendafiguras.dominio.modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Cliente")
public class ClienteEntity {

	@Id
	private String identificacion;
	
	@Column(nullable = false)
	private String nombres;
	
	@Column(nullable = false)
	private String apellidos;

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public ClienteEntity(String identificacion, String nombres, String apellidos) {
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public ClienteEntity() {
		
	}
	
}
