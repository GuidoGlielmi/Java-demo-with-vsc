package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		/*
		 * ALL classes must be in the same folder as this archive
		 * Para levantar el server, apretar en "Run" arriba de main
		 * Para crear un package/clase hacer click derecho en:
		 * JAVA PROJECTS -> Create new class.
		 * Luego se puede escribir: "<package-name>.<class-name>"
		 * Para agregar una carpeta/clase dentro de un package específico hacer click
		 * derecho en el package específico
		 */
		SpringApplication.run(SpringDemoApplication.class, args);
	}
}
