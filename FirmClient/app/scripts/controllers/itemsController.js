'use strict';

angular.module('items', ['resource.items', 'resource.itemParams'])
	.controller('ItemsCtrl', function(Items, ItemParams, $scope, $location, $log) {

		Items.get({idDobavljaca : ItemParams.InvoiceParams.idDobavljaca,idFakture : ItemParams.InvoiceParams.idFakture}, function(response) {
			$scope.items = response.stavkaFakture;

			$log.info("Successfully obtained items data from REST.");
 		});

 		$scope.order = function(predicate) {
        	$scope.reverse = !$scope.reverse;
        	$scope.cssClass = $scope.reverse ? "glyphicon glyphicon-triangle-bottom" : "glyphicon glyphicon-triangle-top";		//	menja strelice u tabeli
        	 
        	$scope.predicate = predicate;
      	};

		$scope.go = function ( path, redniBroj ) {
			$log.info("USAO U GO FUNKCIJU itemsControllera")
			ItemParams.setRedniBrojStavke(redniBroj);
  			
  			$location.path( path );
		};

	});