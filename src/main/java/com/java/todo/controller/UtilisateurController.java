package com.java.todo.controller;

import com.java.todo.model.Tasks;
import com.java.todo.model.Utilisateur;
import com.java.todo.repository.UtilisateurRepository;
import com.java.todo.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UtilisateurController extends NullPointerException {
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@RequestMapping("/addUtilisateur")
	public String addUtilisateur(@RequestParam(value = "username", defaultValue = "null") String username, @RequestParam(value = "password", defaultValue = "null") String password, @RequestParam(value = "passwordVerif", defaultValue = "null") String passwordVerif) {

		try {
			ArrayList<Tasks> listTaches = new ArrayList<>();
			if (!password.equals(passwordVerif)) {
				return "Les mots de passe ne sont pas identiques";
			}

			Utilisateur newUser = new Utilisateur(username, password, listTaches);
			UtilisateurService us = new UtilisateurService(utilisateurRepository);

			if (!us.addUser(newUser)) {
				return "Username déja utilisé";
			}
			return "Votre compte à bien été créé";

		} catch (NullPointerException e) {
			printStackTrace();

		}
		return "Erreur serveur!";
	}

	@RequestMapping("/deleteUtilisateur")
	public void deleteUtilisateur(@RequestParam(value = "username", defaultValue = "null") String username, @RequestParam(value = "password", defaultValue = "null") String password) {
		try {
			ArrayList<Tasks> listTaches = new ArrayList<>();
			Utilisateur newUser = new Utilisateur(username, password, listTaches);
			UtilisateurService us = new UtilisateurService(utilisateurRepository);
			us.deleteUser(newUser);


		} catch (NullPointerException e) {
			printStackTrace();

		}
	}
}
