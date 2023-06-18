package com.example.todoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.todoApp.Dao")
@EntityScan("com.example.todoApp.Entity")
public class TodoAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

}
