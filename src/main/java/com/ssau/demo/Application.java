package com.ssau.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		try {
			Class.forName("org.postgresql.Driver");

		} catch(ClassNotFoundException e) {
			System.out.print(e.getMessage());
		}
		SpringApplication.run(Application.class, args);
	}
}