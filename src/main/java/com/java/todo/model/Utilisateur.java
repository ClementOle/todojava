package com.java.todo.model;


import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "utilisateur_id")
	private int idUtilisateur;

	@Column(name = "utilisateur_username")
	private String username;
	@Column(name = "utilisateur_password")
	private String password;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "utilisateur_id")
	private List<Tasks> listTasks = new ArrayList<>();

	public Utilisateur() {
	}

	public Utilisateur(String username, String password, List<Tasks> listTasks) {
		this.username = username;
		this.password = password;
		this.listTasks = listTasks;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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

	public List<Tasks> getListTasks() {
		return listTasks;
	}

	public void setListTasks(@Null List<Tasks> listTasks) {
		this.listTasks = listTasks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Utilisateur)) return false;
		Utilisateur that = (Utilisateur) o;
		return idUtilisateur == that.idUtilisateur &&
				Objects.equals(username, that.username) &&
				Objects.equals(password, that.password) &&
				Objects.equals(listTasks, that.listTasks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUtilisateur, username, password, listTasks);
	}

	@Override
	public String toString() {
		return "Utilisateur{" +
				"idUtilisateur=" + idUtilisateur +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", listTasks=" + listTasks +
				'}';
	}
}
