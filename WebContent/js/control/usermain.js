$(document).ready(function() {

	$("[name=date]").datepicker({
		dateFormat : 'dd/mm/yy'
	});

});

// Angular Code

(function() {

	var regresionTest = angular.module("regresionTest", [ "ng-currency" ]);
	regresionTest.controller("regresionController", function($scope, $http) {
		
		
		/************************************************ Variables**************************************************************/
		
		//filtrado
		this.urlProfile = location.href.split("=")[1];
		
		
		this.listadoresultado = [];
		this.listadocasosprueba = [];
		this.origen = [];
		this.destino = [];
		this.instrumento = [];
		this.idPeticion = "";
		this.fechaDesde = ""
		this.fechaHasta = "";
		this.todayDate = createTodayDate();
		this.peticionFiltrado = [];
		
		//Lista peticiones
		
		this.objAjaxPrueba = new peticionObj();
		this.objAjaxPrueba.construct("444","emisiones","MLC","Deri","2016-02-01","2016-02-24");
		
		this.objprueba1 = new peticionObj();
		this.objprueba1.construct("444","emisiones","MLC","Deri");
		
		this.objprueba2 = new peticionObj();
		this.objprueba2.construct("232","BSB","murex","FusionDisk");
		
		
		/******************************************FUNCIONES***************************************/
		
		
		
		this.logOut = function(){
			window.open("index.html",target="_self");
			
		}

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
		
		
//envia la peticion con los datos seleccionados y recoge los diferentes objetos y los muestra en la tabla
		
		this.filtrado = function() {
		
//			$.ajax({
//				url : 'http://localhost:8081/RegresionTest/api/configuration',
//				type : 'POST',
//				async : false,
//				data : "{'idPeticion':'"+this.requestID+"','instrumento':'"+this.instrumento.getInstrumento()+"'}",
//				dataType : "json",
//				success : function(response) {
//					outPutdata = response;
//				},
//				error : function(xhr, ajaxOptions, thrownError) {
//					alert(xhr.status + "\n" + thrownError);
//				}
//			});
//			
//
//			if (outPutdata != null) {
//				{
//					this.instrumento = outPutdata.instrumentos;
//					this.origen = outPutdata.origenes;
//					this.destino = outPutdata.destinos;
//
//				};
//			}
			alert("{'idPeticion':'"+this.requestID+"','instrumento':'"+this.objAjaxPrueba.getInstrumento()+"'}");
			this.peticionFiltrado.push(this.objprueba1);
			this.peticionFiltrado.push(this.objprueba2);
		};
		
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
		
	});


	
	//Directivas

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


// funciones no angular
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
