package com.ceiba.tiendafiguras.dominio.excepcion;

public class PreordenExcepcion extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PreordenExcepcion(String message) {
		super(message);
	}
}
