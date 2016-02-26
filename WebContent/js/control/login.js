$(document).ready(function() {

});




//Angular code
(function() {
	var login = angular.module("regresionTest", []);
	
	login.controller("loginController", function($scope) {
		
		
		// Propierties
		this.log = new UserObj();
		this.logDB = new UserObj();
		
		// Scope variables
		$scope.actionRegister = 0; // to show login form or register form
		
		
		this.loginUser = function() {
			// Access to the server to get all users types.

			var login = false;
			
			// llamada AJAX
			
			var outPutdata = [];
			
			var user = "Config";
			
			$.ajax({
				url : 'http://localhost:8081/RegresionTest/api/login',
				type : 'POST',
				async : false,
				data  : "{'user':'"+this.log.user+"'}",
				dataType : "json",
				success : function(response) {
					outPutdata = response;
				},
				error : function(xhr, ajaxOptions, thrownError) {
					alert(xhr.status + "\n" + thrownError);
				}
			});

			if (outPutdata != null) {
				{
					
					this.logDB.user=outPutdata.user;
					this.logDB.pass= outPutdata.pass;
					this.logDB.profile = outPutdata.profile;
					

				};
			}
			else {
				alert("Error en la llamada");
			}
		
	
			//comprobaciones 
			
				alert(this.log.pass +" "+this.logDB.pass);
				if (this.log.user == this.logDB.user && this.log.pass == this.logDB.pass){
			//if (this.log.user == "tester" && this.log.pass =="tester") { // admin																// 1
				login = true;
				this.log.profile = this.logDB.profile;
				

				}

			if (login) {
				// send the values of the role and nick in the url
				window.open("usermain.html?role="+this.log.getProfile(),target="_self");
			} else {
				alert("Wrong id or password");
			}

		};

	});

})();
