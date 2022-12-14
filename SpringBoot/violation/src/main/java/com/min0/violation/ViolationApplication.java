package com.min0.violation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@ComponentScan(basePackages = "com.min0.violation")
public class ViolationApplication {
	public static void main(String[] args) {
		SpringApplication.run(ViolationApplication.class, args);
	}

}
