package com.ceiba.tiendafiguras.dominio.excepcion;

public class ClienteExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ClienteExcepcion(String message) {
		super(message);
	}
}
