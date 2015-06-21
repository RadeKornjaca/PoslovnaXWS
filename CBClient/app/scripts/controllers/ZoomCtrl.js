'use strict';

(function() {
	var ZoomCtrl = function($scope, $routeParams, $route, cbService) {

		var onResourceComplete = function(data) {

			var idField = $scope.$parent.idField;

			//Izvlaci se samo id, posto su dodati linkovi umesto objekata
			var picked = $scope.$parent.selectedEntry[idField];

			var entry = data.data[0];


			//npr: za drzave ce type biti /drzave
			entry[pickType.replace("/","")]={};
			entry[pickType.replace("/","")][idField] = picked;

			//Sacuvaj promenjeni entitet
			cbService.editResource(type, id, entry).then(onSuccessSend, onErrorSend);
			
			};

			$scope.error = false;
			$scope.success = false;

			var onError = function(reason) {
				$scope.response = "Neuspešno učitavanje podataka: " + reason.status +" "+ reason.statusText;
				$scope.error = true;
				$scope.success = false;
				$scope.isZoom = false;
			};

			var onErrorSend = function(reason){
				$scope.response = "Neuspešna izmena podataka: " + reason.status + reason.statusText;
				$scope.error = true;
				$scope.success = false;
			};

			var onSuccessSend = function(){
				$scope.response = "Uspešna izmena podataka."
				$scope.error = false;
				$scope.success = true;
			};


			$scope.pick = function(){
				cbService.getResourceById(type, id).then(onResourceComplete, onError);
			}

		/* Uzima putanju do kontrolera.
		 * npr: za CBClient/#/1/drzave će vratiti /1/drzave
		 * Ovo služi da se konkatenira na URL ka resursu
		 * kako bi se znalo o kom tipu resursa se radi.
		 * Splitovanjem ce se dobiti ["","1","drzave"]. 
		 */

		 var route = $route.current.$$route.originalPath.split('/');

		 var pickType = "/"+route[3];
		 var type = "/"+route[2];
		 var id = $routeParams.id;

		 $scope.num = {'num':1};

		 //cbService.getResourceById(type, id).then(onResourceComplete, onError);
		};

		var app = angular.module("cbApp");
		app.controller("ZoomCtrl", ZoomCtrl);

	}());