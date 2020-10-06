package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Figura")
@NamedQuery(name = "Figura.findById", query = "SELECT figura FROM Figura figura WHERE figura.id = :id")
public class FiguraEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private LocalDate fechaLanzamiento;
	
	@Column(nullable = false)
	private LocalDate fechaLlegada;
	
	@Column(nullable = false)
	private int unidadesPreventa;
	
	@Column(nullable = false)
	private double precio;

	public FiguraEntity() {
		
	}

	public FiguraEntity(String id, String nombre, String marca, LocalDate fechaLanzamiento, LocalDate fechaLlegada,
			int unidadesPreventa, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.fechaLanzamiento = fechaLanzamiento;
		this.fechaLlegada = fechaLlegada;
		this.unidadesPreventa = unidadesPreventa;
		this.precio = precio;
	} 
	
}
