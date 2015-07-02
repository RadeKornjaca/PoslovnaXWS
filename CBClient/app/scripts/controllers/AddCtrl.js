'use strict';

(function() {
	var AddCtrl = function(ZoomService, $scope, $routeParams, $route, cbService) {

		var onResourceComplete = function(data) {

			$scope.entry = [{

			}];

			//var zoomService = new ZoomService();
			var zoomPicked = ZoomService.take();

			if (zoomPicked != null || zoomPicked != undefined){
				$scope.entry[0][zoomPicked.field] = zoomPicked.picked;
			}


			/*
			 * $scope.meta sadrži podatke o poljima dobavljenih podataka.
			 * Podaci obuhvataju ime i tip polja. Služi da bi generička forma
			 * mogla da napravi header tabele.
			 */
			 $scope.meta = data.meta;
			};

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

			var resetFeedback = function(){
				$scope.error = false;
				$scope.success = false;
			};

			$scope.submit = function(data){
				cbService.newResource(type, data).then(onSuccessSend, onErrorSend).then(resetFeedback(), 2000);
			};

			//Kada zoom odabere
			$scope.$on('zoomSelect', function(event, picked, field) {
				$scope.entry[field] = picked;
				getData = false;
			});



		/* Uzima putanju do kontrolera.
		 * npr: za CBClient/#/1/drzave će vratiti /1/drzave
		 * Ovo služi da se konkatenira na URL ka resursu
		 * kako bi se znalo o kom tipu resursa se radi.
		 * Splitovanjem ce se dobiti ["","1","drzave"]. 
		 */

		 var route = $route.current.$$route.originalPath.split('/');

		 var type = "/"+route[1];

		 $scope.num = {'num':1};
		 	cbService.getResource(type).then(onResourceComplete, onError);
		};

		var app = angular.module("cbApp");
		app.controller("AddCtrl", AddCtrl);

	}());