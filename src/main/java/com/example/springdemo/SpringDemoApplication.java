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
	/*
	 * HOW TO CREATE A SPRING BOOT PROYECT FROM SCRATCH
	 * - Download "Java Extension Pack"
	 * - Spring Boot Extension Pack. Esto reemplaza al spring initializr, creado
	 * desde "start.spring.io"
	 * - luego desde el command pallet (F1) se ejecuta
	 * "Spring Initializr: Create a Maven Project"
	 * -- seleccionar la última versión estable ( la que suele aparecer primero)
	 * -- seleccionar el lenguaje Java
	 * -- Ingresar el group id
	 * -- Ingresar el artifact id (nombre del proyecto).
	 * Un artifact de Maven es una estructura que soporta cualquier proyecto java.
	 * Este proceso tiene varias partes:
	 * 
	 * validate : Simplemente comprueba que el proyecto tiene la estructura correcta
	 * y los ficheros están donde tienen que estar.
	 * 
	 * compile : compila el código.
	 * 
	 * test: Se encarga de pasar las pruebas unitarias , algo que siempre debiéramos
	 * tener por lo tanto es otra fase importante y que Maven de alguna forma
	 * refuerza.
	 * 
	 * package: Recordemos que una cosa es compilar nuestro código y generar los
	 * ficheros .class y otra cosa muy diferente es generar un empaquetado que se
	 * pueda “reutilizar”.
	 * 
	 * install: instala nuestro maven artifact en un repositorio de Maven.
	 * 
	 * deploy: para que el artefacto pueda ser utilizado por otros developers, lo
	 * que
	 * lo instalará en un repositorio Maven remoto al que otros usuarios podrán
	 * acceder (Nexus o Artifactory).
	 * 
	 * - Seleccionar el package (jar -Java Archive- en la mayoría de los casos o
	 * war). Jar is a file format based on the popular ZIP file format and is used
	 * for aggregating many files into one. Although JAR can be used as a general
	 * archiving tool, the primary motivation for its development was so that Java
	 * applets and their requisite components (.class files, images and sounds) can
	 * be downloaded to a browser in a single HTTP transaction, rather than opening
	 * a new connection for each piece. This greatly improves the speed with which
	 * an applet can be loaded onto a web page and begin functioning. Additionally,
	 * individual entries in a JAR file may be digitally signed by the applet author
	 * to authenticate their origin.
	 * 
	 * JAR is:
	 * the only archive format that is cross-platform
	 * the only format that handles audio and image files as well as class files
	 * backward-compatible with existing applet code
	 * an open standard, fully extendable, and written in java
	 * the preferred way to bundle the pieces of a java applet
	 * 
	 * - Seleccionar la version de Java (17)
	 * - Seleccionar las dependencias. Mínimamente "Spring web" y
	 * "SpringBoot Dev Tools"
	 * - Seleccionar la carpeta destino para el proyecto.
	 * 
	 */

	/*
	 * NOTAS:
	 * mvnw.cmd es un comando shell (MaVeN Wrapper), el cual windows puede
	 * considerar peligroso, aunque no lo sea, dado que puede acceder a la
	 * comptuadora.
	 * Este archivo sirve para no tener que instalar maven.
	 * La pestaña JAVA PROJECTS debajo de la carpeta donde estamos trabajando es
	 * como suele verse en la mayoría de los IDE's.
	 * Dentro de dicho proyecto, "maven dependencies" son las dependencias del
	 * proyecto de SpringBoot que
	 * mvnw.cmd descargó
	 */
}
