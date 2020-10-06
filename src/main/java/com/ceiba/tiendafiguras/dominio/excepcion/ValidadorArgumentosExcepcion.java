package com.ceiba.tiendafiguras.dominio.excepcion;

public class ValidadorArgumentosExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ValidadorArgumentosExcepcion(String mensaje) {
		super(mensaje);
	}
}
