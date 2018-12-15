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
	public Utilisateur addUtilisateur(@RequestParam(value = "username", defaultValue = "null") String username, @RequestParam(value = "password", defaultValue = "null") String password) {

		try {
			ArrayList<Tasks> listTaches = new ArrayList<>();
			Utilisateur newUser = new Utilisateur(username, password, listTaches);
			UtilisateurService us = new UtilisateurService(utilisateurRepository);
			if (!us.addUser(newUser)) {
				System.out.println("Username déja utilisé");
			}
			return null;

		} catch (NullPointerException e) {
			printStackTrace();

		}
		return null;
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
