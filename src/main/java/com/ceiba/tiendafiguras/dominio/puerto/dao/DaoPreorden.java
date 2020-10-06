package com.ceiba.tiendafiguras.dominio.puerto.dao;

import java.util.List;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;

public interface DaoPreorden {

	public List<Preorden> obtenerPreordenesCliente(String identificacionCliente);
}
