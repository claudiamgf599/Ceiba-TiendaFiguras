package com.ceiba.tiendafiguras.dominio.modelo.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "Figura")
//@NamedQuery(name = "Figura.findPreordenables", query = "SELECT figura FROM Figura figura WHERE figura.fechaLanzamiento > sysdate AND figura.fechaLlegada > sysdate")
@NamedQuery(name = "Figura.findPreordenables", query = "SELECT figura FROM Figura figura ")
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public int getUnidadesPreventa() {
		return unidadesPreventa;
	}

	public void setUnidadesPreventa(int unidadesPreventa) {
		this.unidadesPreventa = unidadesPreventa;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public FiguraEntity() {
		
	}

	public FiguraEntity(String id, String nombre, String marca, Date fechaLanzamiento, Date fechaLlegada,
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
