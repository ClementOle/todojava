package com.java.todo.service;

import com.java.todo.model.Tasks;
import com.java.todo.model.Utilisateur;
import com.java.todo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

public class TasksService {

	@Autowired
	UtilisateurRepository utilisateurRepository;

	public TasksService() {
	}

	public TasksService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	public UtilisateurRepository getUtilisateurRepository() {
		return utilisateurRepository;
	}

	public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TasksService)) return false;
		TasksService that = (TasksService) o;
		return Objects.equals(utilisateurRepository, that.utilisateurRepository);
	}

	@Override
	public int hashCode() {
		return Objects.hash(utilisateurRepository);
	}

	@Override
	public String toString() {
		return "TasksService{" +
				"utilisateurRepository=" + utilisateurRepository +
				'}';
	}

	public void newTasks(Tasks tasks, Utilisateur user) {
		List<Tasks> listTaches = user.getListTasks();
		listTaches.add(tasks);

		user.setListTasks(listTaches);
		utilisateurRepository.save(user);
	}


}
