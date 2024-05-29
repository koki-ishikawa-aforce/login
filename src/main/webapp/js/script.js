"use strict";
document.getElementById('togglePassword').addEventListener('change', function(){
	var passwordField = document.getElementById('password');
	if (this.checked) {
		passwordField.type = 'text';
	} else {
		passwordField.type = 'password';
	}
})