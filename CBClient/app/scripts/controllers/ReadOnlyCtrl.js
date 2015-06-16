'use strict';

(function() {
	var ReadOnlyCtrl = function($scope, $routeParams, $route, cbService) {

		//search.term - Kriterijum pretrage
		//search.field - Polje po kom se pretražujea
		$scope.searchParams = {'field':{}, 'term':''};

		var onResourceComplete = function(data) {
			//Ne ponaša se kako treba kada nije lista
			if (data.wrapper.data.length == 1){
				$scope.entries = [ data.wrapper.data ];
			}
			else{
				$scope.entries = data.wrapper.data;
			}

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

		 $scope.search = function() {
		 	var query = $scope.searchParams.field.name + "=" + $scope.searchParams.term.replace(' ','-');
		 	cbService.getResourceFiltered(type, query).then(onResourceComplete, onError);
		 };

		 $scope.setSearchField = function(field){
		 	$scope.searchParams.field = field;
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