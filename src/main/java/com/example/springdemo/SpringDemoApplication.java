package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		/*
		 * Para levantar el server, apretar en "Run" arriba de main
		 * Para crear un package/clase hacer click derecho en:
		 * JAVA PROJECTS -> Create new class.
		 * Luego se puede escribir: "<package-name>.<class-name>"
		 */
		SpringApplication.run(SpringDemoApplication.class, args);
	}
}
