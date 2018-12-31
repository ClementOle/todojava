package com.java.todo.controller;

import com.java.todo.model.Tasks;
import com.java.todo.model.Utilisateur;
import com.java.todo.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class UtilisateurController extends NullPointerException {
	@Autowired
	private
	UtilisateurService utilisateurService;

	@RequestMapping(value = "/{id}")
	public Utilisateur findUtilisateur(@PathVariable(value = "id") int id) {
		return utilisateurService.findUtilisateur(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page listUtilisateur(@RequestParam(value = "page") int page) {
		return utilisateurService.pagingEmploye(page);
	}

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.addUser(utilisateur);
	}

	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteUtilisateur(@RequestBody Utilisateur utilisateur) {
		utilisateurService.deleteUser(utilisateur);
	}

	@RequestMapping(value = "/{id}/tasks/", method = RequestMethod.GET)
	public Page listTasks(@PathVariable(value = "id") int idUtilisateur, @RequestParam(value = "page", defaultValue = "0") int page) {
		return utilisateurService.listTasksUtilisateur(idUtilisateur, page);
	}

	@RequestMapping(value = "/{id}/tasks/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Tasks addTask(@PathVariable(value = "id") int id, @RequestBody Tasks tasks) {
		return utilisateurService.newTasks(id, tasks);
	}

	@RequestMapping(value = "/{id}/tasks/{id_task}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Tasks updateTask(@PathVariable(value = "id") int id, @PathVariable(value = "id_task") int idTask, @RequestBody Tasks task) {
		return utilisateurService.updateTask(idTask, task);
	}

	@RequestMapping(value = "/{id}/tasks/{id_task}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteTask(@PathVariable(value = "id") int idUtilisateur, @PathVariable(value = "id_task") int idTask) {
		utilisateurService.suppTask(idUtilisateur, idTask);
	}
}
