package com.ceiba.tiendafiguras.dominio.modelo.entidad;

import java.util.Date;

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
@NamedQuery(name = "Figura.findPreordenables", 
	query = "SELECT figura FROM Figura figura WHERE figura.fechaLanzamiento > :fechaLanzamiento "
			+ "AND figura.fechaLlegada > :fechaLlegada "
			+ "AND figura.unidadesPreventa > (SELECT count(1) FROM Preorden preorden WHERE preorden.figura.id = figura.id )")
@NamedQuery(name = "Figura.findById", query = "SELECT figura FROM Figura figura WHERE figura.id = :id")
@NamedQuery(name = "Figura.disponiblePreorden", 
query = "SELECT figura FROM Figura figura WHERE figura.id = :id AND "
		+ "figura.fechaLanzamiento > :fechaLanzamiento "
		+ "AND figura.fechaLlegada > :fechaLlegada "
		+ "AND figura.unidadesPreventa > (SELECT count(1) FROM Preorden preorden WHERE preorden.figura.id = figura.id )")
public class FiguraEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private Date fechaLanzamiento;
	
	@Column(nullable = false)
	private Date fechaLlegada;
	
	@Column(nullable = false)
	private int unidadesPreventa;
	
	@Column(nullable = false)
	private double precio;

	public FiguraEntity() {
		
	}

	public FiguraEntity(String id, String nombre, String marca, Date fechaLanzamiento, Date fechaLlegada,
			int unidadesPreventa, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.fechaLanzamiento = (Date) fechaLanzamiento.clone();
		this.fechaLlegada = (Date) fechaLlegada.clone();
		this.unidadesPreventa = unidadesPreventa;
		this.precio = precio;
	} 
	
}
