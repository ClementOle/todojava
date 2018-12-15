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
		if (utilisateurRepository.findAllByUsername(user.getUtilisateur_username()).size() != 0) {
			return false;
		}
		utilisateurRepository.save(user);
		return true;
	}

	public void deleteUser(Utilisateur user) {
		List<Utilisateur> a = utilisateurRepository.findAllByUsername(user.getUtilisateur_username());
		if (a.size() == 1) {
			utilisateurRepository.delete(a);
		} else {
			System.err.println("Impossible de supprimer cette utilisateur");
		}

	}


}
