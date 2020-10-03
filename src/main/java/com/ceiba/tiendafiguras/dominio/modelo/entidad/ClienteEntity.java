package com.ceiba.tiendafiguras.dominio.modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Cliente")
public class ClienteEntity {

	@Id
	private String identificacion;
	
	@Column(nullable = false)
	private String nombres;
	
	@Column(nullable = false)
	private String apellidos;
	
	public ClienteEntity(String identificacion, String nombres, String apellidos) {
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}

	public ClienteEntity() {
		
	}
	
}
