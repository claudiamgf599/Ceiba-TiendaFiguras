package com.ceiba.tiendafiguras.dominio.modelo.entidad;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Preorden {

	private Long id;
	private Figura figura;
	private Cliente cliente; 
	private double precioPreorden;
	private LocalDate fechaPreorden;
	
	private static final String FIGURA_OBLIGATORIA = "La figura para la preorden es obligatoria";
	private static final String CLIENTE_OBLIGATORIO = "El cliente para la preorden es obligatorio";
	
	public Preorden(Long id, Figura figura, Cliente cliente, double precioPreorden, LocalDate fechaPreorden) {
		
		ValidadorArgumentos.validarObligatorio(figura, FIGURA_OBLIGATORIA);
		ValidadorArgumentos.validarObligatorio(cliente, CLIENTE_OBLIGATORIO);
		
		this.id = id;
		this.figura = figura;
		this.cliente = cliente;
		this.precioPreorden = precioPreorden;
		this.fechaPreorden = fechaPreorden;
	}
	
	public Preorden(String idFigura, String idCliente) {
		
		ValidadorArgumentos.validarObligatorio(idFigura, FIGURA_OBLIGATORIA);
		ValidadorArgumentos.validarObligatorio(idCliente, FIGURA_OBLIGATORIA);
		
		Figura figuraPreorden = new Figura(idFigura);
		Cliente clientePreorden = new Cliente(idCliente);
		this.figura = figuraPreorden;
		this.cliente = clientePreorden;
	}
	
}
