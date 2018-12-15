package com.java.todo.repository;

import com.java.todo.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
	List<Utilisateur> findAllByUsername(String username);
}
