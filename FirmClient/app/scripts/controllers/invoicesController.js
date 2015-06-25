'use strict';

 angular.module('invoices', ['resource.invoices', 'resource.invoiceParams'])
 	.controller('InvoicesCtrl', function(Invoices, InvoiceParams, $scope, $location, $log) {
 		
 		Invoices.get({idDobavljaca : '14234512432'}, function(response) {
			$scope.invoices = response.faktura;
			for(var i = 0; i < $scope.invoices.length; i++) {
				var date = new Date($scope.invoices[i].zaglavlje.datumRacuna);
				$scope.invoices[i].zaglavlje.datumRacuna = date.customFormat( "#DD#.#MM#.#YYYY#." );	//	customFormat metoda se nalazi u util/dateFormatter.js
			}

			$log.info("Successfully obtained invoices data from REST.");
 		});

		$scope.go = function ( path, idDobavljaca, idFakture ) {
			InvoiceParams.setIdDobavljaca(idDobavljaca);
			InvoiceParams.setIdFakture(idFakture);
  			
  			$location.path( path );
		};

 	});
	

