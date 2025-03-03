package com.crudwithdatabase.crudwithdatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main entry point of the Spring Boot application.
 * The @SpringBootApplication annotation enables:
 * - @Configuration: Allows Spring Boot to use Java-based configuration.
 * - @EnableAutoConfiguration: Enables automatic configuration based on dependencies.
 * - @ComponentScan: Scans the base package and sub-packages for Spring components.
 */

@SpringBootApplication
public class CrudwithdatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudwithdatabaseApplication.class, args);
	}

}
