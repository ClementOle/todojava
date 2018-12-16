package com.java.todo.controller;

import com.java.todo.model.Tasks;
import com.java.todo.model.Utilisateur;
import com.java.todo.repository.TasksRepository;
import com.java.todo.repository.UtilisateurRepository;
import com.java.todo.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TasksController {
	@Autowired
	UtilisateurRepository utilisateurRepository;
	@Autowired
	TasksRepository tasksRepository;


	@RequestMapping("/addTask")
	public boolean addTask(@RequestParam(value = "text", defaultValue = " ") String text, @RequestParam(value = "id", defaultValue = "null") int utilisateur_id) {
		Utilisateur user = utilisateurRepository.findOne(utilisateur_id);
		Tasks tache = new Tasks(text, utilisateur_id);
		tasksRepository.save(tache);
		TasksService a = new TasksService(utilisateurRepository);
		a.newTasks(tache, user);
		return true;
	}
	//TODO: Suppression d'une tâche
	//TODO: Recupération des tâches
}
