package com.java.todo.service;

import com.java.todo.model.Utilisateur;
import com.java.todo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

	@Autowired
	private
	UtilisateurRepository utilisateurRepository;

	public Utilisateur addUser(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	public void deleteUser(Utilisateur utilisateur) {
		utilisateurRepository.delete(utilisateur);

	}


}
