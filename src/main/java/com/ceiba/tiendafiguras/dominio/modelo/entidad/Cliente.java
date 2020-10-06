package com.ceiba.tiendafiguras.dominio.modelo.entidad;

import lombok.Getter;

@Getter
public class Cliente {

	private String identificacion;
	private String nombres;
	private String apellidos;
	
	private static final String IDENTIFICACION_OBLIGATORIA = "La identificación del cliente es obligatoria";
	private static final String NOMBRES_OBLIGATORIOS = "El nombre del cliente es obligatorio";
	private static final String APELLIDOS_OBLIGATORIOS = "Los apellidos del cliente son obligatorios";
	
	public Cliente(String identificacion, String nombres, String apellidos) {

		ValidadorArgumentos.validarObligatorio(identificacion, IDENTIFICACION_OBLIGATORIA);
		ValidadorArgumentos.validarObligatorio(nombres, NOMBRES_OBLIGATORIOS);
		ValidadorArgumentos.validarObligatorio(apellidos, APELLIDOS_OBLIGATORIOS);
		
		this.identificacion = identificacion;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	
	public Cliente(String identificacion) {
		ValidadorArgumentos.validarObligatorio(identificacion, IDENTIFICACION_OBLIGATORIA);
		this.identificacion = identificacion;
	}
	
	
}
