package com.java.todo.service;

import com.java.todo.model.Tasks;
import com.java.todo.model.Utilisateur;
import com.java.todo.repository.TasksRepository;
import com.java.todo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

	@Autowired
	private
	UtilisateurRepository utilisateurRepository;
	@Autowired
	private TasksRepository tasksRepository;


	public Utilisateur findUtilisateur(int id) {
		return utilisateurRepository.findOne(id);
	}

	public Page pagingEmploye(int page) {
		Pageable pageable = new PageRequest(page, 10, Sort.Direction.ASC, "username");
		return utilisateurRepository.findAll(pageable);
	}

	public Utilisateur addUser(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	public void deleteUser(Utilisateur utilisateur) {
		utilisateurRepository.delete(utilisateur);
	}

	//////////////////////////////////////////////Task//////////////////////////////////////////////////

	public Tasks newTasks(int id, Tasks tasks) {

		Tasks task = tasksRepository.save(tasks);

		Utilisateur user = utilisateurRepository.findByIdUtilisateur(id);

		List<Tasks> listDesTaches;
		listDesTaches = tasksRepository.findAllByIdUtilisateur(id);
		listDesTaches.add(task);

		user.setListTasks(listDesTaches);
		//utilisateurRepository.save(user);
		return task;
	}

	public Page listTasksUtilisateur(int idUtilisateur, int page) {
		Pageable pageable = new PageRequest(page, 10, Sort.Direction.ASC, "idUtilisateur");
		return tasksRepository.findByIdUtilisateur(idUtilisateur, pageable);
	}

	public void suppTask(int idUtilisateur, int idTask) {
		Utilisateur utilisateur = utilisateurRepository.findOne(idUtilisateur);
		Tasks task = tasksRepository.findOne(idTask);

		tasksRepository.delete(task);

		utilisateur.getListTasks().remove(task);
		utilisateurRepository.save(utilisateur);
	}


}
