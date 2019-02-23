package com.java.todo.repository;

import com.java.todo.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
