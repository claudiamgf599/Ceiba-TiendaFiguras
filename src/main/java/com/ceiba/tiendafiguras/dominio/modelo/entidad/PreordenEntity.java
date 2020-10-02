package com.ceiba.tiendafiguras.dominio.modelo.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private Date fechaPreorden;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FiguraEntity getFigura() {
		return figura;
	}

	public void setFigura(FiguraEntity figura) {
		this.figura = figura;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaPreorden() {
		return fechaPreorden;
	}

	public void setFechaPreorden(Date fechaPreorden) {
		this.fechaPreorden = fechaPreorden;
	}

	public PreordenEntity(Long id, FiguraEntity figura, ClienteEntity cliente, double precio, Date fechaPreorden) {
		this.id = id;
		this.figura = figura;
		this.cliente = cliente;
		this.precio = precio;
		this.fechaPreorden = fechaPreorden;
	}

	public PreordenEntity() {
	
	}
	
}
