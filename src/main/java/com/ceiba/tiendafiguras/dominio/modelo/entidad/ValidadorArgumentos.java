package com.ceiba.tiendafiguras.dominio.modelo.entidad;

import com.ceiba.tiendafiguras.dominio.excepcion.ValidadorArgumentosExcepcion;

public final class ValidadorArgumentos {

    private ValidadorArgumentos(){
    }

    public static void validarObligatorio(Object valor, String mensaje){
        if(valor == null){
            throw new ValidadorArgumentosExcepcion(mensaje);
        }
    }
    
    public static void validarMayorACero(double valor, String mensaje){
        if(valor <= 0) {
            throw new ValidadorArgumentosExcepcion(mensaje);
        }
    }
}
