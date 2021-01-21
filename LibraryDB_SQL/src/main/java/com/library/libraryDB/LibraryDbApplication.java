package com.library.libraryDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.lapots.breed.platform.cloud.boot")
@EnableJpaRepositories("com.lapots.breed.platform.cloud.boot.repository")
@EntityScan("com.lapots.breed.platform.cloud.boot.domain")
public class LibraryDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryDbApplication.class, args);
	}

}
