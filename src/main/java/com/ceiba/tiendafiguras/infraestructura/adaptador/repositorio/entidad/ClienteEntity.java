package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Cliente")
@NamedQuery(name = "Cliente.findById", query = "SELECT cliente FROM Cliente cliente WHERE cliente.identificacion = :identificacion")
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
