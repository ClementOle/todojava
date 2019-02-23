package com.java.todo.repository;


import com.java.todo.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TasksRepository extends JpaRepository<Tasks, Integer> {
	List<Tasks> findAllByUtilisateurId(int id);
}
