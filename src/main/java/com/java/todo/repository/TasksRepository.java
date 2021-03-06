package com.java.todo.repository;


import com.java.todo.model.Tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface TasksRepository extends PagingAndSortingRepository<Tasks, Integer> {
	Page<Tasks> findByIdUtilisateur(int idUtilisateur, Pageable pageable);

	List<Tasks> findAllByIdUtilisateur(int idUtilisateur);
}
