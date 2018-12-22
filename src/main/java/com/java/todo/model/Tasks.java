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
	private int utilisateurId;

	public Tasks() {
	}

	public Tasks(String text, int utilisateurId) {
		this.text = text;
		this.utilisateurId = utilisateurId;
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

	public int getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Tasks)) return false;
		Tasks tasks = (Tasks) o;
		return idTasks == tasks.idTasks &&
				utilisateurId == tasks.utilisateurId &&
				Objects.equals(text, tasks.text);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTasks, text, utilisateurId);
	}

	@Override
	public String toString() {
		return "Tasks{" +
				"idTasks=" + idTasks +
				", text='" + text + '\'' +
				", utilisateurId=" + utilisateurId +
				'}';
	}
}
