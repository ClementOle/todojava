package com.java.todo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_utilisateur;

	private String username;
	private String password;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_utilisateur")
	private List<Task> Task;

	public Utilisateur() {
	}

	public Utilisateur(String username, String password, List<com.java.todo.model.Task> task) {
		this.username = username;
		this.password = password;
		Task = task;
	}

	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<com.java.todo.model.Task> getTask() {
		return Task;
	}

	public void setTask(List<com.java.todo.model.Task> task) {
		Task = task;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Utilisateur)) return false;
		Utilisateur that = (Utilisateur) o;
		return id_utilisateur == that.id_utilisateur &&
				Objects.equals(username, that.username) &&
				Objects.equals(password, that.password) &&
				Objects.equals(Task, that.Task);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_utilisateur, username, password, Task);
	}

	@Override
	public String toString() {
		return "Utilisateur{" +
				"id_utilisateur=" + id_utilisateur +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", Task=" + Task +
				'}';
	}
}
