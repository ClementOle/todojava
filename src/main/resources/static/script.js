const formInscription = document.getElementById('inscription');
const username = document.getElementById('username');
const password = document.getElementById('password');
const passwordVerif = document.getElementById('passwordVerif');

$(document).ready(function () {
    formInscription.addEventListener('submit', function (event) {
        event.stopPropagation();
        event.preventDefault();
        let url = "http://localhost:8083/addUtilisateur?username=" + username.value + "&password=" + password.value + "&passwordVerif=" + passwordVerif.value;
        $.get(url, function (data) {
            switch (data) {
                case 0:
                    console.log("Compte créé !");
                    break;
                case 1:
                    console.log("Non d'utilisateur déja utilisé");
                    break;
                case 2:
                    console.log("Mot de passe non identiques");
                    break;
                default:
                    console.log("Erreur serveur");
                    break;
            }
        });
    });
});