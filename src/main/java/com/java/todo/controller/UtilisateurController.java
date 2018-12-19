package com.java.todo.controller;

import com.java.todo.model.Utilisateur;
import com.java.todo.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UtilisateurController extends NullPointerException {
	@Autowired
	private
	UtilisateurService utilisateurService;

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.addUser(utilisateur);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilisateurService.deleteUser(utilisateur);
	}
}
