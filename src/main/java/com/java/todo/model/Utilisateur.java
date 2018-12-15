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

	private String utilisateur_username;
	private String utilisateur_password;

	@OneToMany
	@JoinColumn(name = "utilisateur_id")
	private List<Tasks> listTasks;

	public Utilisateur() {
	}

	public Utilisateur(String utilisateur_username, String utilisateur_password, ArrayList<com.java.todo.model.Tasks> tasks) {
		this.utilisateur_username = utilisateur_username;
		this.utilisateur_password = utilisateur_password;
		listTasks = tasks;
	}

	public int getUtilisateur_id() {
		return utilisateur_id;
	}

	public void setUtilisateur_id(int utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}

	public String getUtilisateur_username() {
		return utilisateur_username;
	}

	public void setUtilisateur_username(String utilisateur_username) {
		this.utilisateur_username = utilisateur_username;
	}

	public String getUtilisateur_password() {
		return utilisateur_password;
	}

	public void setUtilisateur_password(String utilisateur_password) {
		this.utilisateur_password = utilisateur_password;
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
				Objects.equals(utilisateur_username, that.utilisateur_username) &&
				Objects.equals(utilisateur_password, that.utilisateur_password) &&
				Objects.equals(listTasks, that.listTasks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(utilisateur_id, utilisateur_username, utilisateur_password, listTasks);
	}

	@Override
	public String toString() {
		return "Utilisateur{" +
				"utilisateur_id=" + utilisateur_id +
				", utilisateur_username='" + utilisateur_username + '\'' +
				", utilisateur_password='" + utilisateur_password + '\'' +
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
