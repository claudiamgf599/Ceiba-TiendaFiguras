package com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioPreorden;
import com.ceiba.tiendafiguras.infraestructura.adaptador.dao.DaoClienteJPA;
import com.ceiba.tiendafiguras.infraestructura.adaptador.dao.DaoFiguraJPA;
import com.ceiba.tiendafiguras.infraestructura.adaptador.dao.DaoPreordenJPA;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.ClienteEntity;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.FiguraEntity;
import com.ceiba.tiendafiguras.infraestructura.adaptador.repositorio.entidad.PreordenEntity;

@Repository
public class RepositorioPreordenPersistente implements RepositorioPreorden {

	private DaoFiguraJPA daoFiguraJPA;
	private DaoClienteJPA daoClienteJPA;
	private DaoPreordenJPA daoPreordenJPA;
	
	public RepositorioPreordenPersistente(DaoFiguraJPA daoFiguraJPA, DaoClienteJPA daoClienteJPA, DaoPreordenJPA daoPreordenJPA) {
		this.daoFiguraJPA = daoFiguraJPA;
		this.daoClienteJPA = daoClienteJPA;
		this.daoPreordenJPA = daoPreordenJPA;
	}

	@Override
	public void generarPreorden(Preorden preorden) {
		PreordenEntity preordenEntity = buildPreordenEntity(preorden);
		daoPreordenJPA.save(preordenEntity);
	}
	
	private PreordenEntity buildPreordenEntity(Preorden preorden) {
		Optional<ClienteEntity> clienteEntity = daoClienteJPA.findById(preorden.getCliente().getIdentificacion());
		Optional<FiguraEntity> figuraEntity = daoFiguraJPA.findById(preorden.getFigura().getId());
		PreordenEntity preordenEntity = new PreordenEntity();
		preordenEntity.setCliente(clienteEntity.orElse(null));
		preordenEntity.setFigura(figuraEntity.orElse(null));
		preordenEntity.setFechaPreorden(preorden.getFechaPreorden());
		preordenEntity.setPrecio(preorden.getPrecioPreorden());
		return preordenEntity;
	}

}
