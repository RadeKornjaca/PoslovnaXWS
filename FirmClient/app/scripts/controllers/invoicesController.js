'use strict';

 angular.module('invoices', ['resource.invoices', 'resource.invoiceParams', 'resource.user'])
 	.controller('InvoicesCtrl', function(Invoices, InvoiceParams, User, $scope, $location, $log) {
 		
 		
 		
 		Invoices.get({idDobavljaca : User.user.pib}, function(response) {
			$scope.invoices = response.faktura;
			for(var i = 0; i < $scope.invoices.length; i++) {
				var date = new Date($scope.invoices[i].zaglavlje.datumRacuna);
				$scope.invoices[i].zaglavlje.datumRacuna = date;												//	za svaki slucaj da sortira datume kako treba, ne da serenda
				$scope.invoices[i].zaglavlje.datumRacunaFormatted = date.customFormat( "#DD#.#MM#.#YYYY#." );	//	customFormat metoda se nalazi u util/dateFormatter.js
			}

			$log.info("Successfully obtained invoices data from REST.");
 		});

      	
      	$scope.order = function(predicate) {
        	$scope.reverse = !$scope.reverse;
        	$scope.cssClass = $scope.reverse ? "glyphicon glyphicon-triangle-bottom" : "glyphicon glyphicon-triangle-top";		//	menja strelice u tabeli
        	 
        	$scope.predicate = predicate;
      	};

		$scope.go = function ( path, idDobavljaca, idFakture ) {
			InvoiceParams.setIdDobavljaca(idDobavljaca);
			InvoiceParams.setIdFakture(idFakture);
  			$location.path( path );
		};

 	});
	

