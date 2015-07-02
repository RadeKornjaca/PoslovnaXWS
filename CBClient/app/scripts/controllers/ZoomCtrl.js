'use strict';

(function() {
	var ZoomCtrl = function(ZoomService, $scope, $routeParams, $window, $route, cbService) {


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

			var idField = $scope.$parent.idField;

			//Izvlaci se samo id, posto su dodati linkovi umesto objekata
			var picked = $scope.$parent.selectedEntry;

			var field = pickType.replace("/","");
			var data = {};
			data[idField] = picked[idField];
			var pickedURL = cbService.restURL + '/' + picked[idField] + pickType;
			//Sacuvaj promenjeni entitet
			ZoomService.setPicked(data, field);

			//Vrati se na prethodnu stranicu
			//$location.path('/'+id+type);
			$window.history.back();

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

		 //Ako se pravi novi entitet, putanja ce biti /new/tip/ref_tip
		 if (type == 'new'){;
		 	var temp = type;
		 	type = id;
		 	id = temp;
		 }

		 $scope.num = {'num':1};
		};

		var app = angular.module("cbApp");
		app.controller("ZoomCtrl", ZoomCtrl);

	}());