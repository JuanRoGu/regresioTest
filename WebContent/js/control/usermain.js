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
		 * **********************************************Variables*************************************************************
		 */

		
		this.urlProfile = location.href.split("=")[1];
		this.urlBase = "";
		this.origen = "";
		this.destino = "";
		this.instrumento = "";
		this.idPeticion = "";
		this.fechaDesde = "";
		this.fechaHasta = "";
		this.valorTabla = "";
		this.selectresult = "";
		this.nombreCaso = "";
		this.casosprueba = "";
		this.entorno = "";
		this.entornoresult = "";
		this.nombreresult = "";
		this.jsonresult = "";

		
		
		this.listadoresultado = [];
		this.listadocasosprueba = [];
		this.origenArray = [];
		this.destinoArray = [];
		this.instrumentoArray = [];
		this.todayDate = createTodayDate();
		this.peticionFiltrado = [];
		this.seleccionados = [];
		this.CasoPrueba = [];
		this.nombreCasoPrueba = [];
		this.entornoArray = [];
		this.entornoResultArray = [];
		
		
//
//		this.resultobjetos = new resultObj();
//		this.resultobjetos.construct("ejecucion1","{'id':'1234'}")
//		this.listadoresultado.push(this.resultobjetos);
//		
//		this.resultobjetos2 = new resultObj();
//		this.resultobjetos2.construct("ejecucion2","{'text' : 'Resultados Test Case TC1','children' : [{'text' : 'personas[1]','children' : [{'text' : 'persona[1]','children' : [{'text' : 'nombre[1]','children' : [{'text' : 'Valor encontrado: Manolo'},{'text' : 'Valor esperado: Pepe'}]},{'text' : 'edad[1]','children' : [{'text' : 'Valor esperado: 25'},{'text' : 'Valor encontrado: 21'}]}]},{'text' : 'persona[2]','children' : [{'text' : 'nombre[1]','children' : [{'text' : 'Valor esperado: Eva'},{'text' : 'Valor encontrado: pepin'}]},{'text' : 'edad[1]','children' : [{'text' : 'Valor esperado: 29'},{'text' : 'Valor encontrado: 123'}]}]}]}]}");
//		this.listadoresultado.push(this.resultobjetos2);
//		
		

		


		/** ****************************************FUNCIONES************************************** */

		
		
		
		this.logOut = function() {
			window.open("index.html", target = "_self");

		}
		
		this.visualizaJson = function(){
			for(var i = 0; i<this.listadoresultado.length; i++){
				if(this.listadoresultado[i].nombre == this.selectresult){
					
					verJson(this.listadoresultado[i].json);
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
		
		this.reset = function(){
			
			this.origen = "";
			this.destino = "";
			this.instrumento = "";
			this.idPeticion = "";
			this.fechaDesde = "";
			this.fechaHasta = "";
			this.entorno = "";
			
		}
		
		



		
			/**
			 * ***************************************LLamadas AJAX*****************************************************
			 */

		// inicializa los combobox del filtrado
		
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
					this.entornoArray = outPutdata.nombre;
					
					for (var i = 0; i < this.entornoArray.length; i++) {
						if (this.entornoArray[i] != "PRO") {
							this.entornoResultArray.push(this.entornoArray[i]);
						}
					}


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
						+ this.fechaHasta + "','entorno':'"
						+ this.entorno + "'}",
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
						this.peticionObjetos.construct(outPutdata[i].request_ID,outPutdata[i].request_ID, outPutdata[i].Instrumento,outPutdata[i].Accion
								,outPutdata[i].Origen,outPutdata[i].Destino,outPutdata[i].Mensaje,outPutdata[i].MensMN,outPutdata[i].mensDestino
								,outPutdata[i].MensDestino);
						
						
						this.peticionFiltrado.push(this.peticionObjetos);
						
						
					}

				}
			}

		};
		
		// guardar caso de prueba
		this.guardarCaso = function() {
			this.CasoPrueba = "";
			var outPutdata = [];
			
			this.CasoPrueba = "{'nombreCaso':'"+this.nombreCaso+"','operaciones':[";
			for(var i =0; i<this.seleccionados.length-1; i++){
				this.CasoPrueba += "{'id':'"+this.seleccionados[i].id+"','idPeticion':'"+this.seleccionados[i].idPeticion+"','instrumento':'"+this.seleccionados[i].instrumento
									+"','accion':'"+this.seleccionados[i].accion+"','origen':'"+this.seleccionados[i].origen+"','destino':'"+this.seleccionados[i].destino
									+"','mensaje':'"+this.seleccionados[i].mensaje+"','mensajeNeutro':'"+this.seleccionados[i].mensajeNeutro+"','mensajeDestino':'"+this.seleccionados[i].mensajeDestino+"'},";
				
			}
			
			if(this.seleccionados.length>0){
				this.CasoPrueba += "{'id':'"+this.seleccionados[this.seleccionados.length-1].id+"','idPeticion':'"+this.seleccionados[this.seleccionados.length-1].idPeticion+"','instrumento':'"+this.seleccionados[this.seleccionados.length-1].instrumento
				+"','accion':'"+this.seleccionados[this.seleccionados.length-1].accion+"','origen':'"+this.seleccionados[this.seleccionados.length-1].origen+"','destino':'"+this.seleccionados[this.seleccionados.length-1].destino
				+"','mensaje':'"+this.seleccionados[this.seleccionados.length-1].mensaje+"','mensajeNeutro':'"+this.seleccionados[this.seleccionados.length-1].mensajeNeutro+"','mensajeDestino':'"+this.seleccionados[this.seleccionados.length-1].mensajeDestino+"'}]}";
			}
			$.ajax({
				url : this.urlBase+"api/configuration/add",
				type : 'POST',
				async : false,
				data : this.CasoPrueba,
				dataType : "json",
				success : function(response) {
					outPutdata = response;
				},
				error : function(xhr, ajaxOptions, thrownError) {
					// alert(xhr.status + "\n" + thrownError);
				}
			});

			if (outPutdata != null) {
				{
												
				
				this.initCasosprueba();
				alert("caso de prueba guardado")
						
					}
				}
			
			else{
				alert("no ha sido posible guardar el caso de prueba")
				
			}

		};
	
		// Eliminar caso de prueba
		this.eliminarCaso = function() {
			
			this.nombreCasoPrueba = "";
			var outPutdata = [];
			this.nombreCasoPrueba =  "{'NombreCaso':' " + this.casosprueba+ "'}";
			// alert(JSON.stringify(this.nombreCasoPrueba));
			
			$.ajax({
				url : this.urlBase+"api/ejecution",
				type : 'DELETE',
				async : false,
				data : this.nombreCasoPrueba,
				dataType : "json",
				success : function(response) {
					outPutdata = response;
				},
				error : function(xhr, ajaxOptions, thrownError) {
					// alert(xhr.status + "\n" + thrownError);
				}
			});

			if (outPutdata != null) {
				
					
					this.initCasosprueba();
					
					alert("caso de prueba eliminado")
			
			}
			
			else{
				alert("error no ha sido posible eliminar")
			}

		};
		
		//Falta parte servidor
		
//		// Eliminar resultado
//		this.eliminarResultado = function() {
//			
//			this.nombreCasoPrueba = "";
//			var outPutdata = [];
//			this.nombreCasoPrueba =  "{'Nombre':' " + this.nombreresult+ "'}";
//			// alert(JSON.stringify(this.nombreCasoPrueba));
//			
//			$.ajax({
//				url : this.urlBase+"api/result",
//				type : 'DELETE',
//				async : false,
//				data : JSON.stringify(this.nombreCasoPrueba),
//				dataType : "json",
//				success : function(response) {
//					outPutdata = response;
//				},
//				error : function(xhr, ajaxOptions, thrownError) {
//					// alert(xhr.status + "\n" + thrownError);
//				}
//			});
//
//			if (outPutdata != null) {
//				
//					
//					this.initCasosprueba();
//					
//					alert("caso de prueba eliminado")
//			
//			}
//			
//			else{
//				alert("error no ha sido posible eliminar")
//			}
//
//		};
		
		
		// Inicializar combo de listado Resultado
		
		this.initCasosprueba = function() {
			
			var outPutdata = [];
			 this.urlBase = rutaAbsoluta();
			 
			$.ajax({
				url : this.urlBase+"api/result",
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
					this.listadoresultado = outPutdata.resultados;
				}
				;
			} else {
				alert("Error en la llamada");
			}
		};
		

		//Inicializar combo de casos de prueba
		this.initCasosprueba = function() {
			
			var outPutdata = [];
			 this.urlBase = rutaAbsoluta();
			 
			$.ajax({
				url : this.urlBase+"api/ejecution",
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
					this.listadocasosprueba = outPutdata.casosdeprueba;
				}
				;
			} else {
				alert("Error en la llamada");
			}
		};
		

	//// guarda resultados de casos de prueba
		this.guardaresultado = function() {
		
			var outPutdata = [];
			var datos = "";
			var json1 ='{"Report": {"Grupo": [{"NTMMessageGeneric": {"NTMMessage": {"NTMHeader": {"MessageID": {"found": 10000000002593974,"expected": 100000000025939766}}}}},{"NTMMessageGeneric": {"NTMMessage": {"NTMTrade": {"TradeHeader": {"SysTradeID": {"SystemID": {"found": "Murex","expected": "Adaptiv"}}}}}}},{"NTMMessageGeneric": {"NTMMessage": {"NTMTrade": {"IRSwap": {"PaySide": {"TradeLeg": {"TradeLegDetails": {"TradeLegPrincipal": {"Principal": {"found": 400000000,"expected": 40000}}}}}}}}}}]}}'; 
			datos += "{'NombreRes':'"+this.nombreresult+"','Json':'"+json1+"'}";

			$.ajax({
				url : this.urlBase+"api/result",
				type : 'POST',
				async : false,
				data : datos,
				dataType : "json",
				success : function(response) {
					outPutdata = response;
				},
			error : function(xhr, ajaxOptions, thrownError) {
			}
			});
		}
	
	});
	
/** *************************************************DIRECTIVAS********************************************************* */

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

function verJson(json){
	
	


	vaciaDiv();
	var divContent = "";
	divContent +="<div id='jsonviews'>";
	divContent += "<script>";
	divContent +="$('#jsonviews').jstree(";
	divContent += "{ 'core' : { 'data' : [";
	divContent += json;
	divContent += "]} }";
	divContent += ");</script></div>";
	$('#json').html(divContent);
	
}
 
function vaciaDiv(){
	var valor = $('#json').html();
	if( valor != null || valor != ""){
		$('#json').empty();
	}
}
