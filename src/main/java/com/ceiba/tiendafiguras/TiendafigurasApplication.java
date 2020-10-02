package com.ceiba.tiendafiguras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ceiba.tiendafiguras")
public class TiendafigurasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendafigurasApplication.class, args);
	}

}
