$(document).ready(function(){

    $("[name=date]").datepicker({ dateFormat: 'dd/mm/yy' });

});



//Angular Code

(function() {  

	  
		  
		  
		  var regresionTest = angular.module("regresionTest",["ng-currency"]);
		  regresionTest.controller("regresionController", function ($scope, $http){
		  
		  this.listadoresultado = ["","Resultado 1","Resultado 2","Resultado 3","Resultado 4"]; 
		  this.listadocasosprueba = ["","Caso Prueba 1","Caso Prueba 2","Caso Prueba 3","Caso Prueba 4"];
		  this.origen =[];
		  this.destino = [];
		  this.instrumento =[];
		  this.todayDate = createTodayDate();
		  this.peticion = new peticionObj();
		  
		  
		  
		  function RemoteResource($http, $q, baseUrl) {
			    
			  
			  this.get = function() {
			        var defered = $q.defer();
			        var promise = defered.promise;

			        $http({
			            method: 'GET',
			            url: baseUrl + '/api/configuration/' + idSeguro
			        }).success(function(data, status, headers, config) {
			            defered.resolve(data);
			        }).error(function(data, status, headers, config) {
			            if (status === 400) {
			                defered.reject(data);
			            } else {
			                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
			            }
			        });

			        return promise;

			    };

			}
		  
		  function RemoteResourceProvider() {
			    var _baseUrl;
			    this.setBaseUrl = function(baseUrl) {
			        _baseUrl = baseUrl;
			    };
			    this.$get = ['$http', '$q', function($http, $q) {
			            return new RemoteResource($http, $q, _baseUrl);
			        }];
			};
		  

		  
		  
		  
		  
	  });

	  
      this.fechasValidas = function() {
          var bool = true;

          if( this.filtrado.fechaDesde > this.todayDate ) {

              $("#fechaDesde").removeClass("ng-valid");
              $("#fechaDesde").addClass("ng-invalid");
              bool=false;
          }else {

              $("#fechaDesde").removeClass("ng-invalid");
              $("#fechaDesde").addClass("ng-valid");

          }
          if( this.reservation.fechaDesde >= this.reservation.fechaHasta ) {

              $("#fechaHasta").removeClass("ng-valid");
              $("#fechaHasta").addClass("ng-invalid");

              bool=false;
          }else {

              $("#fechaHasta").removeClass("ng-invalid");
              $("#fechaHasta").addClass("ng-valid");

          }
          if(bool){
              alert(this.reservation.toString());
          }

      };
      
      
      
	  regresionTest.directive("configuration", function () {

	        return {

	            restrict: 'E',
	            templateUrl:"templates/configuration.html",

	            controller:function(){

	            },

	            controllerAs: 'configuration'
	        };
	    });
	  
	 
	  
	  regresionTest.directive('calendar', function () {
	        return {
	            require: 'ngModel',
	            link: function (scope, el, attr, ngModel) {
	                $(el).datepicker({
	                    dateFormat: 'yy-mm-dd',
	                    onSelect: function (dateText) {
	                        scope.$apply(function () {
	                            ngModel.$setViewValue(dateText);
	                        });
	                    }
	                });
	            }
	        };
	    });
	  
	  
	  regresionTest.directive("result", function () {

	        return {

	            restrict: 'E',
	            templateUrl:"templates/result.html",

	            controller:function(){

	            },

	            controllerAs: 'result'
	        };
	    });
	  
	  
	  regresionTest.directive("cabecera", function () {

	        return {

	            restrict: 'E',
	            templateUrl:"templates/cabecera.html",

	            controller:function(){

	            },

	            controllerAs: 'cabecera'
	        };
	    });
	  
	  regresionTest.directive("filtrado", function () {

	        return {

	            restrict: 'E',
	            templateUrl:"templates/filtrado.html",

	            controller:function(){

	            },

	            controllerAs: 'filtrado'
	        };
	    });
	  
	  regresionTest.directive("execution", function () {

	        return {

	            restrict: 'E',
	            templateUrl:"templates/execution.html",

	            controller:function(){

	            },

	            controllerAs: 'execution'
	        };
	    });
	  
	  
	  regresionTest.directive("visualizarjson", function () {

	        return {

	            restrict: 'E',
	            templateUrl:"templates/visualizarjson.html",

	            controller:function(){

	            },

	            controllerAs: 'visualizarjson'
	        };
	    });
	  
	  regresionTest.directive("listadoresultados", function () {

	        return {

	            restrict: 'E',
	            templateUrl:"templates/listadoresultados.html",

	            controller:function(){

	            },

	            controllerAs: 'listadoresultados'
	        };
	    });
	  
	  regresionTest.directive("listadocasosprueba", function () {

	        return {

	            restrict: 'E',
	            templateUrl:"templates/listadocasosprueba.html",

	            controller:function(){

	            },

	            controllerAs: 'listadocasosprueba'
	        };
	    });
})();

function createTodayDate() {

    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();

    if(dd<10) {
        dd='0'+dd
    }

    if(mm<10) {
        mm='0'+mm
    }
    today = yyyy+'-'+mm+'-'+dd;

    return today;

}
