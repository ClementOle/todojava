package com.java.todo.service;

import com.java.todo.model.Utilisateur;
import com.java.todo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UtilisateurService {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	public UtilisateurService() {
	}

	public UtilisateurService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	public boolean addUser(Utilisateur user) {
		List<Utilisateur> listUtilisateur = (List<Utilisateur>) utilisateurRepository.findAll();
		for (Utilisateur utilisateur :
				listUtilisateur) {
			if (utilisateur.getUtilisateur_username().equals(user.getUtilisateur_username())) {
				return false;
			}
		}
		utilisateurRepository.save(user);
		return true;
	}

	public void deleteUser(Utilisateur user) {
		utilisateurRepository.delete(user);
	}


}
