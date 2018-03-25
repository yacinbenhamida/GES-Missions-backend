package com.rached;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.rached.model.Utilisateur;

@SpringBootApplication
@EntityScan(basePackages = "com.rached.model")
public class RachedApplication {

	public static void main(String[] args) {
		SpringApplication.run(RachedApplication.class, args);
	}
}
