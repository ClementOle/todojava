package com.java.todo.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Tasks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tasks_id")
	private int idTasks;

	@Column(name = "tasks_text")
	private String text;

	@Column(name = "utilisateur_id")
	private int idUtilisateur;

	public Tasks() {
	}

	public Tasks(String text, int idUtilisateur) {
		this.text = text;
		this.idUtilisateur = idUtilisateur;
	}

	public int getIdTasks() {
		return idTasks;
	}

	public void setIdTasks(int idTasks) {
		this.idTasks = idTasks;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Tasks)) return false;
		Tasks tasks = (Tasks) o;
		return idTasks == tasks.idTasks &&
				idUtilisateur == tasks.idUtilisateur &&
				Objects.equals(text, tasks.text);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTasks, text, idUtilisateur);
	}

	@Override
	public String toString() {
		return "Tasks{" +
				"idTasks=" + idTasks +
				", text='" + text + '\'' +
				", idUtilisateur=" + idUtilisateur +
				'}';
	}
}
