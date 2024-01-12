function validatePasswords() {
    var password = document.getElementById('psw').value;
    var confirmPassword = document.getElementById('psw-repeat').value;

    if (password !== confirmPassword) {
        alert("Les mots de passe ne correspondent pas !");
    } else {
        // Si les mots de passe correspondent, soumettez le formulaire
        document.forms[0].submit();
    }
}
