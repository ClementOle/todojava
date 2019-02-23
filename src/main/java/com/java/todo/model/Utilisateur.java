package com.java.todo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String username;
	private String password;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "utilisateur")
	@JsonIgnoreProperties("utilisateur")
	private List<Tasks> listTasks;

	public Utilisateur(String username, String password, List<Tasks> listTasks) {
		this.username = username;
		this.password = password;
		this.listTasks = listTasks;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Utilisateur that = (Utilisateur) o;
		return id == that.id &&
				Objects.equals(username, that.username) &&
				Objects.equals(password, that.password) &&
				Objects.equals(listTasks, that.listTasks);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, password, listTasks);
	}

	@Override
	public String toString() {
		return "Utilisateur{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", listTasks=" + listTasks +
				'}';
	}
}
