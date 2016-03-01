$(document).ready(function() {

	$("[name=date]").datepicker({
		dateFormat : 'dd/mm/yy'
	});

});

// Angular Code

(function() {

	var regresionTest = angular.module("regresionTest", [ "ng-currency" ]);
	regresionTest.controller("regresionController", function($scope, $http) {

		/**
		 * **********************************************
		 * Variables*************************************************************
		 */

		// filtrado
		this.urlProfile = location.href.split("=")[1];
		
		this.urlBase = "";
		this.listadoresultado = [];
		this.listadocasosprueba = [];
		this.origenArray = [];
		this.destinoArray = [];
		this.instrumentoArray = [];
		this.origen = "";
		this.destino = "";
		this.instrumento = "";
		this.idPeticion = "";
		this.fechaDesde = "";
		this.fechaHasta = "";
		this.todayDate = createTodayDate();
		this.peticionFiltrado = [];
		this.seleccionados = [];
		this.valorTabla = "";

		// Lista peticiones

		


		/** ****************************************FUNCIONES************************************** */

		this.logOut = function() {
			window.open("index.html", target = "_self");

		}

		this.initCombo = function() {
			var outPutdata = [];
			 this.urlBase = rutaAbsoluta();
			 
			
			$.ajax({
				url : this.urlBase+"api/configuration",
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
					this.instrumentoArray = outPutdata.instrumentos;
					this.origenArray = outPutdata.origenes;
					this.destinoArray = outPutdata.destinos;

				}
				;
			} else {
				alert("Error en la llamada");
			}
		};
		

		// envia la peticion con los datos seleccionados y recoge los diferentes
		// objetos y los muestra en la tabla

		this.filtrado = function() {
			
			var outPutdata = [];

			$.ajax({
				url : this.urlBase+"api/configuration",
				type : 'POST',
				async : false,
				data : "{'Id_Peticion':'" + this.idPeticion
						+ "','Instrumento':'" + this.instrumento
						+ "', 'Origen':'" + this.origen + "','Destino':'"
						+ this.destino + "'" + ",'fechaDesde':'"
						+ this.fechaDesde + "','fechaHasta':'"
						+ this.fechaHasta + "'}",
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
												
					this.peticionFiltrado = [];
					for (var i = 0; i < outPutdata.length; i++) {
						this.peticionObjetos = new peticionObj();
						this.peticionObjetos.construct(outPutdata[i].request_ID, outPutdata[i].Instrumento,outPutdata[i].Accion
								,outPutdata[i].Origen,outPutdata[i].Destino,outPutdata[i].Mensaje,outPutdata[i].MensMN
								,outPutdata[i].MensDestino);
						
						this.peticionFiltrado.push(this.peticionObjetos);
						
						
					}

				}
			}

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

		/**
		 * Funcion que añade las peticiones seleccionadas en la tabla para
		 * ejecutar, no admite repetidos.
		 */
		this.insertarSeleccionado = function() {
			var igual;
			for (var i = 0; i < this.peticionFiltrado.length; i++) {
				if (this.peticionFiltrado[i].seleccionado) {
					igual = false;
					for (var j = 0; j < this.seleccionados.length; j++) {
						if (this.peticionFiltrado[i].idPeticion == this.seleccionados[j].idPeticion) {
							igual = true;
						}
					}
					if (!igual) {
						this.seleccionados.push(this.peticionFiltrado[i]);
					}

				}

			}

		};

		/**
		 * Borra de la tabla de seleccionados.
		 */

		this.borrarSeleccionado = function(id) {
			for (var i = 0; i < this.seleccionados.length; i++) {
				if (this.seleccionados[i].idPeticion == id) {
					this.seleccionados.splice(i, 1);

				}

			}

		};

	});

	// Directivas

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
					dateFormat : 'yy/mm/dd',
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

function rutaAbsoluta(){
	 var loc = window.location;
	 var pathName = loc.pathname.substring(0, loc.pathname.lastIndexOf('/') + 1);
	 return loc.href.substring(0, loc.href.length - ((loc.pathname + loc.search + loc.hash).length - pathName.length));
	}
 
