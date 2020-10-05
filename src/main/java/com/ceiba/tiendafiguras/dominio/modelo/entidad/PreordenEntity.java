package com.ceiba.tiendafiguras.dominio.modelo.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Preorden")
@NamedQuery(name = "Preorden.findByCliente", query = "SELECT preorden FROM Preorden preorden WHERE preorden.cliente.identificacion = :idCliente "
		+ "ORDER BY fechaPreorden DESC")
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
	private Date fechaPreorden;

	public PreordenEntity(Long id, FiguraEntity figura, ClienteEntity cliente, double precio, Date fechaPreorden) {
		this.id = id;
		this.figura = figura;
		this.cliente = cliente;
		this.precio = precio;
		this.fechaPreorden = (Date) fechaPreorden.clone();
	}

	public PreordenEntity() {
	
	}
	
}
