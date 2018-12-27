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

$(document).ready(function () {
    afficheEmploye.addEventListener('click', function (event) {
        event.preventDefault();
        event.stopPropagation();
        let idUtilisateur = 22;
        let url = "http://localhost:8083/" + idUtilisateur;
        $.get(url, function (data) {
            console.log(data);
        });
    });

    afficheListEmploye.addEventListener('click', function (ev) {
        ev.stopPropagation();
        ev.preventDefault();


        let numeroPage = 0;
        let url = "http://localhost:8083?page=" + numeroPage;
        $.get(url, function (data) {
            console.log(data);
        });
    });

    addUser.addEventListener('submit', function (ev) {
        ev.preventDefault();
        ev.stopPropagation();

        let url = "http://localhost:8083";

        let user = {
            username: pseudo.value,
            password: mdp.value
        };

        jQuery.ajax({
            url: url,
            type: "POST",
            data: JSON.stringify(user),
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                console.log(data);
            }
        });
    });

    deleteUser.addEventListener('submit', function (ev) {
        ev.stopPropagation();
        ev.preventDefault();

        let url = "http://localhost:8083/" + idUtilisateur.value;

        $.get(url, function (data) {
            let url = "http://localhost:8083";

            jQuery.ajax({
                url: url,
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

        let url = "http://localhost:8083/" + idUser.value + "/tasks/?page=0";

        $.get(url, function (data) {
            console.log(data);
        });
    });

    addTask.addEventListener('submit', function (ev) {
        ev.preventDefault();
        ev.stopPropagation();

        let url = "http://localhost:8083/" + idUtilisateurTask.value + "/tasks/";

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
    });

    deleteTask.addEventListener('submit', function (ev) {
        ev.stopPropagation();
        ev.preventDefault();

        let url = "http://localhost:8083/" + idUtilisateurDeleteTask.value + "/tasks/" + idTask.value;

        jQuery.ajax({
            url: url,
            type: "DELETE"
        });
    })


});
