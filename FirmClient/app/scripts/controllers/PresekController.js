'use strict';

angular.module('zahtevZaPresek', ['resource.presek'])
.controller('PresekController', function(ZahtevZaPresek, $location, $scope, $log) {

	$scope.preseciShow = false;
	$scope.zahtev = {};
	$scope.zahtev = new ZahtevZaPresek();


	$scope.zahtev.datum = new Date();


	$scope.submit = function(){
		console.log($scope.zahtev);
		console.log(JSON.stringify($scope.zahtev));

		$scope.presek = {};
		$scope.preseciShow = false;

		$scope.zahtev.$update(function(response) {
			$log.info(response);
			$scope.presek = response;
			$scope.preseciShow = true;

			$scope.zahtev = {};
			$scope.zahtev = new ZahtevZaPresek();

			$scope.zahtev.datum = new Date();
		});


	}

});
