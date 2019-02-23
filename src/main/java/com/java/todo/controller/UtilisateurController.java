package com.java.todo.controller;

import com.java.todo.exception.ResourceNotFoundException;
import com.java.todo.model.Utilisateur;
import com.java.todo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController extends NullPointerException {
	@Autowired
	private
	UtilisateurRepository utilisateurRepository;

	@RequestMapping(value = "counts")
	public long countUtilisateur() {
		return utilisateurRepository.count();
	}

	@GetMapping("{id}")
	public Utilisateur findUtilisateur(@PathVariable(value = "id") int id) {
		return utilisateurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", id));
	}

	/*@RequestMapping(value = "", method = RequestMethod.GET)
	public Page listUtilisateur(@RequestParam(value = "page") int page) {
		return utilisateurService.pagingEmploye(page);
	}
*/

	@PostMapping()
	public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	@DeleteMapping("{id}")
	public void deleteUtilisateur(@PathVariable(value = "id") int id) {
		Utilisateur utilisateur = utilisateurRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", id));
		utilisateurRepository.delete(utilisateur);
	}
}
