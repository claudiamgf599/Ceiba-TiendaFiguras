package com.ceiba.tiendafiguras.dominio.servicio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import com.ceiba.tiendafiguras.dominio.excepcion.ClienteExcepcion;
import com.ceiba.tiendafiguras.dominio.excepcion.PreordenExcepcion;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Cliente;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Figura;
import com.ceiba.tiendafiguras.dominio.modelo.entidad.Preorden;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioCliente;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioFigura;
import com.ceiba.tiendafiguras.dominio.puerto.repositorio.RepositorioPreorden;

@Component
public class ServicioGenerarPreorden {
	
	private RepositorioPreorden repositorioPreorden;
	private RepositorioFigura repositorioFigura;
	private RepositorioCliente repositorioCliente;

	public ServicioGenerarPreorden(RepositorioPreorden repositorioPreorden, RepositorioFigura repositorioFigura, RepositorioCliente repositorioCliente) {
		this.repositorioPreorden = repositorioPreorden;
		this.repositorioFigura = repositorioFigura;
		this.repositorioCliente = repositorioCliente;
	}
	
	public static final int DESCUENTO_2_MESES = 10;
	public static final int DESCUENTO_3_MESES = 15;
	public static final int DIAS_DESDE_ULTIMA_PREORDEN = 15;
	
	public static final String PRODUCTO_NO_DISPONIBLE = "Se ha agotado el stock para preordenar la figura";
	public static final String CLIENTE_NO_EXISTE = "El cliente no se encuentra registrado";
	public static final String CLIENTE_NO_PUEDE_PREORDENAR = "No han pasado los dias suficientes desde la ultima preorden para poder generar una nueva preorden";
	
	/**
	 * Genera una preorden para el cliente y la figura 
	 * @param preorden
	 */
	public Preorden ejecutar(Preorden preorden) {
		
		Cliente cliente = repositorioCliente.obtenerPorId(preorden.getCliente().getIdentificacion());
		if(cliente == null) {
			throw new ClienteExcepcion(CLIENTE_NO_EXISTE);
		}
		
		Figura figura = repositorioFigura.obtenerFiguraDisponiblePreorden(preorden.getFigura().getId());
		if(figura == null) {
			throw new PreordenExcepcion(PRODUCTO_NO_DISPONIBLE);
		}
		
		if(!clientePuedePreordenar(preorden.getCliente().getIdentificacion())) {
			throw new PreordenExcepcion(CLIENTE_NO_PUEDE_PREORDENAR);
		}
		
		preorden.setPrecioPreorden(obtenerPrecioPreorden(figura.getFechaLanzamiento(), figura.getPrecio()));
		preorden.setFechaPreorden(LocalDate.now());
		return (repositorioPreorden.generarPreorden(preorden));
	}
	
	/**
	 * @param identificacionCliente
	 * @return
	 */
	public boolean clientePuedePreordenar(String identificacionCliente) {
		
		boolean puedePreordenar = true;
		Preorden ultimaPreorden = repositorioPreorden.obtenerUltimaPreordenCliente(identificacionCliente);
		
		if(ultimaPreorden != null){
			int diasDesdePreorden = ValidadorFechas.diasHabilesDesdeFecha(ultimaPreorden.getFechaPreorden(), LocalDate.now());
			if(diasDesdePreorden > DIAS_DESDE_ULTIMA_PREORDEN) {
				puedePreordenar = false;
			}
		}
		
		return puedePreordenar; 
	}
	
	/**
	 * Obtiene el precio de la preorden validando si tiene descuentos
	 * @param fechaLanzamiento
	 * @param precioFigura
	 * @return
	 */
	public double obtenerPrecioPreorden(LocalDate fechaLanzamiento, double precioFigura) {
		
		double precioPreorden = precioFigura;
		LocalDate fechaActual = LocalDate.now();
		long mesesEntreFechas = ChronoUnit.MONTHS.between(fechaActual, fechaLanzamiento);
		
		if(mesesEntreFechas >= 2 && mesesEntreFechas < 3) {
			precioPreorden = precioPreorden - ((precioPreorden * DESCUENTO_2_MESES) / 100);
		}else if(mesesEntreFechas > 3) {
			precioPreorden = precioPreorden - ((precioPreorden * DESCUENTO_3_MESES) / 100);
		}

		return precioPreorden;
	}

}
