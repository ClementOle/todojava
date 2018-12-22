package com.java.todo.service;

import com.java.todo.repository.TasksRepository;
import com.java.todo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksService {

	@Autowired
	private
	UtilisateurRepository utilisateurRepository;
	@Autowired
	private
	TasksRepository tasksRepository;




}
