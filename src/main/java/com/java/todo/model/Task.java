package com.java.todo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_task;
	private String text_task;
	private int id_utilisateur;

	public Task() {
	}

	public Task(String text_task, int id_utilisateur) {
		this.text_task = text_task;
		this.id_utilisateur = id_utilisateur;
	}

	public int getId_task() {
		return id_task;
	}

	public void setId_task(int id_task) {
		this.id_task = id_task;
	}

	public String getText_task() {
		return text_task;
	}

	public void setText_task(String text_task) {
		this.text_task = text_task;
	}

	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Task)) return false;
		Task task = (Task) o;
		return id_task == task.id_task &&
				id_utilisateur == task.id_utilisateur &&
				Objects.equals(text_task, task.text_task);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_task, text_task, id_utilisateur);
	}

	@Override
	public String toString() {
		return "Task{" +
				"id_task=" + id_task +
				", text_task='" + text_task + '\'' +
				", id_utilisateur=" + id_utilisateur +
				'}';
	}
}
