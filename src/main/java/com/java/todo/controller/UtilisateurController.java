package com.java.todo.controller;

import com.java.todo.model.Utilisateur;
import com.java.todo.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilisateurController extends NullPointerException {
	@Autowired
	private
	UtilisateurService utilisateurService;

	@RequestMapping(value = "/addUtilisateur", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.addUser(utilisateur);
	}

	@RequestMapping(value = "/deleteUtilisateur", method = RequestMethod.DELETE)

	public void deleteUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilisateurService.deleteUser(utilisateur);
	}
}
