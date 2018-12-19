package com.java.todo.service;

import com.java.todo.model.Tasks;
import com.java.todo.model.Utilisateur;
import com.java.todo.repository.TasksRepository;
import com.java.todo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TasksService {

	@Autowired
	private
	UtilisateurRepository utilisateurRepository;
	@Autowired
	private
	TasksRepository tasksRepository;


	public Tasks newTasks(int id, Tasks tasks) {
		Utilisateur utilisateur = utilisateurRepository.findOne(id);
		utilisateur.getListTasks().add(tasks);
		utilisateurRepository.save(utilisateur);

		return tasksRepository.save(tasks);


	}

	public Page findAll(Pageable pageable) {
		return tasksRepository.findAll(pageable);
	}
}
