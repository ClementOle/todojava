package com.java.todo;

import com.java.todo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {
	@Autowired
	UtilisateurRepository utilisateurRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
}

