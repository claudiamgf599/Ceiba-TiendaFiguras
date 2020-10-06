package com.ceiba.tiendafiguras.aplicacion.consulta;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.tiendafiguras.aplicacion.mapeador.MapeadorPreorden;
import com.ceiba.tiendafiguras.dominio.modelo.dto.PreordenDTO;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;
import com.ceiba.tiendafiguras.dominio.puerto.dao.DaoPreorden;

@Component
public class ManejadorConsultarPreordenes {
	
	private final DaoPreorden daoPreorden;
	
	public ManejadorConsultarPreordenes(DaoPreorden daoPreorden) {
		this.daoPreorden = daoPreorden;
	}
	
	@Transactional
	public List<PreordenDTO> ejecutar(String identificacionCliente){
		List<Preorden> preordenesDominio = daoPreorden.obtenerPreordenesCliente(identificacionCliente);
		return preordenesDominio.stream().map(MapeadorPreorden::mapearADTO).collect(Collectors.toList());
	}
}
