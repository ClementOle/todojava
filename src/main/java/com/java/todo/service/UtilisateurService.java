package com.java.todo.service;

import com.java.todo.model.Utilisateur;
import com.java.todo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {

	@Autowired
	private
	UtilisateurRepository utilisateurRepository;

	@Autowired
	private
	TasksService tasksService;

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


}
