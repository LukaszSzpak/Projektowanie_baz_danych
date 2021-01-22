package com.library.libraryDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.library.libraryDB.repositories")
@EntityScan("com.library.libraryDB.entities")
public class LibraryDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryDbApplication.class, args);
	}

}
