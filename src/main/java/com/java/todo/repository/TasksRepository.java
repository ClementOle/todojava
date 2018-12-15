package com.java.todo.repository;


import com.java.todo.model.Tasks;
import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Tasks, Integer> {
}
