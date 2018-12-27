const afficheEmploye = document.getElementById("afficheEmploye");
const afficheListEmploye = document.getElementById("afficheListEmploye");

const addUser = document.getElementById("addUser");
const pseudo = document.getElementById("username");
const mdp = document.getElementById("password");

const deleteUser = document.getElementById("deleteUser");
const idUtilisateur = document.getElementById("idUtilisateur");

const idUser = document.getElementById("idUser");
const listTask = document.getElementById("listTask");

const addTask = document.getElementById("addTask");
const idUtilisateurTask = document.getElementById("idUtilisateurTask");
const textTask = document.getElementById("textTask");

const deleteTask = document.getElementById("deleteTask");
const idUtilisateurDeleteTask = document.getElementById("idUtilisateurDeleteTask");
const idTask = document.getElementById("idTask");

const urlBase = "http://localhost:8083";

$(document).ready(function () {
	afficheEmploye.addEventListener('click', function (event) {
		event.preventDefault();
		event.stopPropagation();
		let idUtilisateur = 22;
		let url = urlBase + "/" + idUtilisateur;
		$.get(url, function (data) {
			console.log(data);
		});
	});

	afficheListEmploye.addEventListener('click', function (ev) {
		ev.stopPropagation();
		ev.preventDefault();


		let numeroPage = 0;
		let url = urlBase + "?page=" + numeroPage;
		$.get(url, function (data) {
			console.log(data);
		});
	});

	addUser.addEventListener('submit', function (ev) {
		ev.preventDefault();
		ev.stopPropagation();
		if (pseudo.value != "" && mdp.value != "") {
			let user = {
				username: pseudo.value,
				password: mdp.value
			};

			jQuery.ajax({
				url: urlBase,
				type: "POST",
				data: JSON.stringify(user),
				dataType: "json",
				contentType: "application/json; charset=utf-8",
				success: function (data) {
					console.log(data);
				}
			});
		}
		//TODO: Cryptage mot de passe
		//TODO: Vérification unicité du pseudo
	});

	deleteUser.addEventListener('submit', function (ev) {
		ev.stopPropagation();
		ev.preventDefault();

		let url = urlBase + "/" + idUtilisateur.value;

		$.get(url, function (data) {
			jQuery.ajax({
				url: urlBase,
				type: "DELETE",
				data: JSON.stringify(data),
				dataType: "json",
				contentType: "application/json; charset=utf-8"
			});
		});
	});

	listTask.addEventListener('submit', function (ev) {
		ev.stopPropagation();
		ev.preventDefault();

		let url = urlBase + "/" + idUser.value + "/tasks/?page=0";
		$.get(url, function (data) {
			console.log(data);
		});
	});

	addTask.addEventListener('submit', function (ev) {
		ev.preventDefault();
		ev.stopPropagation();

		let url = urlBase + "/" + idUtilisateurTask.value + "/tasks/";

		let task = {
			text: textTask.value,
			idUtilisateur: idUtilisateur.value
		};

		jQuery.ajax({
			url: url,
			type: "POST",
			data: JSON.stringify(task),
			dataType: "json",
			contentType: "application/json; charset=utf-8",
			success: function (data) {
				console.log(data);
			}
		});
		//TODO vérification du remplissage des champs
	});

	deleteTask.addEventListener('submit', function (ev) {
		ev.stopPropagation();
		ev.preventDefault();

		let url = urlBase + "/" + idUtilisateurDeleteTask.value + "/tasks/" + idTask.value;

		jQuery.ajax({
			url: url,
			type: "DELETE"
		});
	})


});
