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

import java.util.ArrayList;
import java.util.List;

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

	@RequestMapping("/task")
	public List<Tasks> task(@RequestParam(value = "id", defaultValue = "-1") int idUser) {
		try {
			if (idUser != -1) {
				Utilisateur user = utilisateurRepository.findOne(idUser);
				return user.getListTasks();
			}
		} catch (NullPointerException n) {
			return new ArrayList<>();
		}
		return null;

	}

	//TODO: Suppression d'une tâche
}
