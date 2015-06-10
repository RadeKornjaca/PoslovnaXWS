'use strict';

(function() {
	var ReadOnlyCtrl = function($scope, $routeParams, $route, cbService) {

		var onResourceComplete = function(data) {
			$scope.entries = data.wrapper.data;

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

		/* Uzima putanju do kontrolera.
		 * npr: za CBClient/#/drzave će vratiti /drzave
		 * Ovo služi da se konkatenira na URL ka resursu
		 * kako bi se znalo o kom tipu resursa se radi. 
		*/
		var type = $route.current.$$route.originalPath;

		cbService.getResource(type).then(onResourceComplete, onError);
	};
	var app = angular.module("cbApp");
	app.controller("ReadOnlyCtrl", ReadOnlyCtrl);
}());