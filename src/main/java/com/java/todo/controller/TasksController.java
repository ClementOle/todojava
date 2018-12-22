package com.java.todo.controller;

import com.java.todo.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TasksController {
	@Autowired
	private
	TasksService tasksService;


}
