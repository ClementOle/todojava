package com.java.todo.repository;


import com.java.todo.model.Tasks;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface TasksRepository extends PagingAndSortingRepository<Tasks, Integer> {
	Page<Tasks> findByUtilisateurId(int utilisateurId, Pageable pageable);
}
