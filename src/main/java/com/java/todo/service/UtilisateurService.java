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

	public int countTache(int idUtilisateur) {
		List<Tasks> listTache = tasksRepository.findAllByIdUtilisateur(idUtilisateur);
		return listTache.size();
	}

	public Page listTasksUtilisateur(int idUtilisateur, int page) {
		Pageable pageable = new PageRequest(page, 10, Sort.Direction.ASC, "idUtilisateur");
		return tasksRepository.findByIdUtilisateur(idUtilisateur, pageable);
	}

	public Tasks newTasks(int id, Tasks tasks) {
		tasks.setIdUtilisateur(id);
		Tasks task = tasksRepository.save(tasks);

		return task;
	}

	public Tasks updateTask(int id, Tasks taskUpdated) {
		Tasks task = tasksRepository.findOne(id);
		task.setText(taskUpdated.getText());
		tasksRepository.save(task);
		return task;
	}

	public void suppTask(int idUtilisateur, int idTask) {
		Utilisateur utilisateur = utilisateurRepository.findOne(idUtilisateur);
		Tasks task = tasksRepository.findOne(idTask);

		tasksRepository.delete(task);

		utilisateur.getListTasks().remove(task);
		utilisateurRepository.save(utilisateur);
	}


}
