package com.pcanabarro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.pcanabarro.controller", "com.pcanabarro.service", "com.pcanabarro.exception"})
@EntityScan("com.pcanabarro.entity")
@EnableJpaRepositories("com.pcanabarro.repository")
public class UrlShortenerApplication {
	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerApplication.class, args);
	}

}
