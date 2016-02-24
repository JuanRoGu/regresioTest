$(document).ready(function() {

});




//Angular code
(function() {
	var login = angular.module("regresionTest", []);
	login.controller("loginController", function($scope) {
		// Propierties
		this.log = new UserObj();
		// Scope variables
		$scope.actionRegister = 0; // to show login form or register form
		this.loginUser = function() {
			// Access to the server to get all users types.

			var login = false;
		
			
			if (this.log.user == "tester" && this.log.pass =="tester") { // admin
																				// 1
				this.log.construct("tester", "tester", "tester");
				login = true;
			} else if (this.log.user == "config"
					&& this.log.pass == "config") { // normal client
														// (perfil) 2
				this.log.construct("config", "config", "config");
				login = true;
			}

			if (login) { // send the values of the role and nick in the url
				window.open("usermain.html?role=" ,target = "_self"); //
			} else {
				alert("Wrong id or password");
			}

		};

	});

})();
