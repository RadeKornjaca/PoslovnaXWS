'use strict';

(function() {
	var EditCtrl = function(ZoomService, $scope, $routeParams, $route, cbService) {	

		var onResourceComplete = function(data) {

			$scope.entry = data.data;

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
			 for (var i = 0; i < $scope.meta.length; i++){
			 	var meta = $scope.meta[i];
			 	if (meta.type == 'Date'){
			 		var dateLong = $scope.entry[0][meta.name];
			 		$scope.entry[0][meta.name] = new Date(dateLong);
			 	}
			 }
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
				for (var i = 0; i < $scope.meta.length; i++){
					var meta = $scope.meta[i];
					//if (meta.type == 'Date' && typeof $scope.entry[0][meta.name] != 'number'){
					//	var date = $scope.entry[0][meta.name];
					//	$scope.entry[0][meta.name] = date.toISOString();
					//}
					if (meta.type == 'link' || meta.type == 'zoom'){
						var entry = data[0];
						//Ako je string, onda je URL i nije promenjen
						//U suprotnom je novi objekat
						if(entry[meta.name] != undefined 
							&& typeof entry[meta.name] == 'string'){
							//Izbacuje se da ne bi zbunio backend koji ocekuje objekat
						delete entry[meta.name];
					}
				}
			}

			cbService.editResource(type, id, data).then(onSuccessSend, onErrorSend).then(resetFeedback(), 2000);
		};

		/* Uzima putanju do kontrolera.
		 * npr: za CBClient/#/1/drzave će vratiti /1/drzave
		 * Ovo služi da se konkatenira na URL ka resursu
		 * kako bi se znalo o kom tipu resursa se radi.
		 * Splitovanjem ce se dobiti ["","1","drzave"]. 
		 */

		 var route = $route.current.$$route.originalPath.split('/');

		 var type = "/"+route[2];
		 var id = $routeParams.id;

		 $scope.num = {'num':1};
		 cbService.getResourceById(type, id).then(onResourceComplete, onError);
		};

		var app = angular.module("cbApp");
		app.controller("EditCtrl", EditCtrl);

	}());