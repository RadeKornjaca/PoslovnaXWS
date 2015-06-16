'use strict';

(function() {
	var EditCtrl = function($scope, $routeParams, $route, cbService) {

		var onResourceComplete = function(data) {

			var temp = data.wrapper.data;
			$scope.entry = [temp];
			/*
			 * $scope.meta sadrži podatke o poljima dobavljenih podataka.
			 * Podaci obuhvataju ime i tip polja. Služi da bi generička forma
			 * mogla da napravi header tabele.
			 */
			 $scope.meta = data.wrapper.meta;
		};

		var onError = function(reason) {
			$scope.error = "Could not fetch the data, reason: " + reason.statusText;
		};


		$scope.submit = function(data){
			cbService.editResource(type, id, data);
		};

		$scope.bleja = function(){
			console.log("bleja");
		}
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