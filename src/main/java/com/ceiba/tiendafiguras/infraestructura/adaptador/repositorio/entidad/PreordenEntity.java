package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Preorden")
public class PreordenEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="ID_FIGURA",referencedColumnName="id")
	private FiguraEntity figura;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE",referencedColumnName="identificacion")
	private ClienteEntity cliente; 
	
	@Column(nullable = false)
	private double precio;
	
	@Column(nullable = false)
	private LocalDate fechaPreorden;

	public PreordenEntity(Long id, FiguraEntity figura, ClienteEntity cliente, double precio, LocalDate fechaPreorden) {
		this.id = id;
		this.figura = figura;
		this.cliente = cliente;
		this.precio = precio;
		this.fechaPreorden = fechaPreorden;
	}

	public PreordenEntity() {
	
	}
	
}
