package com.codea.eccomerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class EccomerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EccomerceApplication.class, args);
	}

}
