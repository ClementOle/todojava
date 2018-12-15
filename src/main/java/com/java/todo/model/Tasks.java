package com.java.todo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tasks_id;
	private String tasks_text;


	private int utilisateur_id;

	public Tasks() {
	}

	public Tasks(String tasks_text, int utilisateur_id) {
		this.tasks_text = tasks_text;
		this.utilisateur_id = utilisateur_id;
	}

	public int getTasks_id() {
		return tasks_id;
	}

	public void setTasks_id(int tasks_id) {
		this.tasks_id = tasks_id;
	}

	public String getTasks_text() {
		return tasks_text;
	}

	public void setTasks_text(String tasks_text) {
		this.tasks_text = tasks_text;
	}

	public int getUtilisateur_id() {
		return utilisateur_id;
	}

	public void setUtilisateur_id(int utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Tasks)) return false;
		Tasks tasks = (Tasks) o;
		return tasks_id == tasks.tasks_id &&
				utilisateur_id == tasks.utilisateur_id &&
				Objects.equals(tasks_text, tasks.tasks_text);
	}

	@Override
	public int hashCode() {
		return Objects.hash(tasks_id, tasks_text, utilisateur_id);
	}

	@Override
	public String toString() {
		return "Task{" +
				"tasks_id=" + tasks_id +
				", tasks_text='" + tasks_text + '\'' +
				", utilisateur_id=" + utilisateur_id +
				'}';
	}
}
