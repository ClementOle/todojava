package com.java.todo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Tasks {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTasks;

	private String text;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "utilisateur_id", foreignKey = @ForeignKey(name = "FK_UTILISATEUR"), nullable = false)
	@JsonIgnoreProperties("listTasks")
	private Utilisateur utilisateur;

	public Tasks(String text, Utilisateur utilisateur) {
		this.text = text;
		this.utilisateur = utilisateur;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Tasks tasks = (Tasks) o;
		return idTasks == tasks.idTasks &&
				Objects.equals(text, tasks.text) &&
				Objects.equals(utilisateur, tasks.utilisateur);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTasks, text, utilisateur);
	}

	@Override
	public String toString() {
		return "Tasks{" +
				"idTasks=" + idTasks +
				", text='" + text + '\'' +
				", utilisateur=" + utilisateur +
				'}';
	}
}
