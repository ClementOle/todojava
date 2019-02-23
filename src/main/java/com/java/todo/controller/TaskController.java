package com.java.todo.controller;

import com.java.todo.exception.ResourceNotFoundException;
import com.java.todo.model.Tasks;
import com.java.todo.model.Utilisateur;
import com.java.todo.repository.TasksRepository;
import com.java.todo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	TasksRepository tasksRepository;
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@GetMapping(value = "count")
	public long countTasks() {
		return tasksRepository.count();
	}

	@GetMapping("{id}")
	public Tasks getTask(@PathVariable(value = "id") int id) {
		return tasksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task", "id", id));
	}

	@GetMapping(value = "utilisateurs/{id}/")
	public List<Tasks> listTasksByUtilisateur(@PathVariable(value = "id") int idUtilisateur) {
		Utilisateur utilisateur = utilisateurRepository.findById(idUtilisateur).orElseThrow(() -> new ResourceNotFoundException("Utilisateur", "id", idUtilisateur));
		return tasksRepository.findAllByUtilisateurId(idUtilisateur);
	}

	@PostMapping("utilisateurs")
	public Tasks addTask(@RequestBody Tasks tasks) {
		return tasksRepository.save(tasks);
	}

	/*@RequestMapping(value = "/{id}/tasks/{id_task}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Tasks updateTask(@PathVariable(value = "id") int id, @PathVariable(value = "id_task") int idTask, @RequestBody Tasks task) {
		return utilisateurService.updateTask(idTask, task);
	}*/

	@DeleteMapping("{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteTask(@PathVariable(value = "id") int id) {
		Tasks tasks = tasksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tasks", "id", id));
		tasksRepository.delete(tasks);
	}
}
