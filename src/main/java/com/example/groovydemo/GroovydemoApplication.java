package com.example.groovydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class GroovydemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GroovydemoApplication.class, args);

	}

}
