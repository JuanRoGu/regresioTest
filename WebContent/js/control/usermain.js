$(document).ready(function() {

	$("[name=date]").datepicker({
		dateFormat : 'dd/mm/yy'
	});

});

// Angular Code

(function() {

	var regresionTest = angular.module("regresionTest", [ "ng-currency" ]);
	regresionTest.controller("regresionController", function($scope, $http) {

		this.listadoresultado = [];
		this.listadocasosprueba = [];
		this.origen = [];
		this.destino = [];
		this.instrumento = [];
		this.idPeticion = "";
		this.fechaDesde = ""
		this.fechaHasta = "";
		this.todayDate = createTodayDate();
		this.peticion = new peticionObj();

		this.initCombo = function() {
			var outPutdata = [];

			$.ajax({
				url : 'http://localhost:8081/RegresionTest/api/configuration',
				type : 'GET',
				async : false,
				data : "",
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
					this.instrumento = outPutdata.instrumentos;
					this.origen = outPutdata.origenes;
					this.destino = outPutdata.destinos;

				};
			}
			else {
				alert("Error en la llamada");
			}
		};
		
		this.filtrado = function() {
			alert(this.requestID);
			$.ajax({
				url : 'http://localhost:8081/RegresionTest/api/configuration',
				type : 'POST',
				async : false,
				data : this.requestID,
				dataType : "json",
				success : function(response) {
					outPutdata = response;
				},
				error : function(xhr, ajaxOptions, thrownError) {
					alert(xhr.status + "\n" + thrownError);
				}
			});
			
		};
		
		
	});

	this.fechasValidas = function() {
		var bool = true;

		if (this.filtrado.fechaDesde > this.todayDate) {

			$("#fechaDesde").removeClass("ng-valid");
			$("#fechaDesde").addClass("ng-invalid");
			bool = false;
		} else {

			$("#fechaDesde").removeClass("ng-invalid");
			$("#fechaDesde").addClass("ng-valid");

		}
		if (this.reservation.fechaDesde >= this.reservation.fechaHasta) {

			$("#fechaHasta").removeClass("ng-valid");
			$("#fechaHasta").addClass("ng-invalid");

			bool = false;
		} else {

			$("#fechaHasta").removeClass("ng-invalid");
			$("#fechaHasta").addClass("ng-valid");

		}

	};

	regresionTest.directive("configuration", function() {

		return {

			restrict : 'E',
			templateUrl : "templates/configuration.html",

			controller : function() {

			},

			controllerAs : 'configuration'
		};
	});

	regresionTest.directive('calendar', function() {
		return {
			require : 'ngModel',
			link : function(scope, el, attr, ngModel) {
				$(el).datepicker({
					dateFormat : 'yy-mm-dd',
					onSelect : function(dateText) {
						scope.$apply(function() {
							ngModel.$setViewValue(dateText);
						});
					}
				});
			}
		};
	});

	regresionTest.directive("result", function() {

		return {

			restrict : 'E',
			templateUrl : "templates/result.html",

			controller : function() {

			},

			controllerAs : 'result'
		};
	});

	regresionTest.directive("cabecera", function() {

		return {

			restrict : 'E',
			templateUrl : "templates/cabecera.html",

			controller : function() {

			},

			controllerAs : 'cabecera'
		};
	});

	regresionTest.directive("filtrado", function() {

		return {

			restrict : 'E',
			templateUrl : "templates/filtrado.html",

			controller : function() {

			},

			controllerAs : 'filtrado'
		};
	});

	regresionTest.directive("execution", function() {

		return {

			restrict : 'E',
			templateUrl : "templates/execution.html",

			controller : function() {

			},

			controllerAs : 'execution'
		};
	});

	regresionTest.directive("visualizarjson", function() {

		return {

			restrict : 'E',
			templateUrl : "templates/visualizarjson.html",

			controller : function() {

			},

			controllerAs : 'visualizarjson'
		};
	});

	regresionTest.directive("listadoresultados", function() {

		return {

			restrict : 'E',
			templateUrl : "templates/listadoresultados.html",

			controller : function() {

			},

			controllerAs : 'listadoresultados'
		};
	});

	regresionTest.directive("listadocasosprueba", function() {

		return {

			restrict : 'E',
			templateUrl : "templates/listadocasosprueba.html",

			controller : function() {

			},

			controllerAs : 'listadocasosprueba'
		};
	});
})();

function createTodayDate() {

	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth() + 1; // January is 0!
	var yyyy = today.getFullYear();

	if (dd < 10) {
		dd = '0' + dd
	}

	if (mm < 10) {
		mm = '0' + mm
	}
	today = yyyy + '-' + mm + '-' + dd;

	return today;

}
