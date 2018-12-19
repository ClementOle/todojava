package com.java.todo.controller;

import com.java.todo.model.Tasks;
import com.java.todo.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TasksController {
	@Autowired
	private
	TasksService tasksService;

	@RequestMapping(value = "/{id}/tasks/", method = RequestMethod.GET)
	public Page listTasks(@PathVariable(value = "id") int id, @RequestParam(value = "page") int page) {
		Pageable pageable = new PageRequest(page, 10, Sort.Direction.ASC);
		return tasksService.findAll(pageable);
	}

	@RequestMapping(value = "/{id}/tasks/", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Tasks addTask(@PathVariable(value = "id") int id, @RequestBody Tasks tasks) {
		return tasksService.newTasks(id, tasks);
	}

	@RequestMapping("/deleteTask")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public boolean deleteTask(@RequestParam(value = "id", defaultValue = "-1") int idTask) {
		//TODO: Suppression d'une tâche
		return false;
	}


}
