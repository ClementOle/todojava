package com.java.todo.repository;

import com.java.todo.model.Utilisateur;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface UtilisateurRepository extends PagingAndSortingRepository<Utilisateur, Integer> {
	List<Utilisateur> findAllByUsername(String username);
}
