package com.java.todo.repository;

import com.java.todo.model.Utilisateur;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Integer> {
	Utilisateur findByIdUtilisateur(int idUtilisateur);
}
