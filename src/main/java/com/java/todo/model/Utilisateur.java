package com.java.todo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int utilisateur_id;

	@Column(name = "utilisateur_username")
	private String username;
	@Column(name = "utilisateur_password")
	private String password;

	@OneToMany
	@JoinColumn(name = "utilisateur_id")
	private List<Tasks> listTasks;

	public Utilisateur() {
	}

	public Utilisateur(String username, String password, ArrayList<com.java.todo.model.Tasks> tasks) {
		this.username = username;
		this.password = password;
		listTasks = tasks;
	}

	public int getUtilisateur_id() {
		return utilisateur_id;
	}

	public void setUtilisateur_id(int utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}

	public String getUtilisateur_username() {
		return username;
	}

	public void setUtilisateur_username(String username) {
		this.username = username;
	}

	public String getUtilisateur_password() {
		return password;
	}

	public void setUtilisateur_password(String password) {
		this.password = password;
	}

	public List<com.java.todo.model.Tasks> getTasks() {
		return listTasks;
	}

	public void setTasks(List<com.java.todo.model.Tasks> tasks) {
		listTasks = tasks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Utilisateur)) return false;
		Utilisateur that = (Utilisateur) o;
		return utilisateur_id == that.utilisateur_id &&
				Objects.equals(username, that.username) &&
				Objects.equals(password, that.password) &&
				Objects.equals(listTasks, that.listTasks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(utilisateur_id, username, password, listTasks);
	}

	@Override
	public String toString() {
		return "Utilisateur{" +
				"utilisateur_id=" + utilisateur_id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", Tasks=" + listTasks +
				'}';
	}

	public List<Tasks> getListTasks() {
		return listTasks;
	}

	public void setListTasks(List<Tasks> listTasks) {
		this.listTasks = listTasks;
	}
}
