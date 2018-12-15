package com.java.todo.repository;

import com.java.todo.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Integer> {
}
