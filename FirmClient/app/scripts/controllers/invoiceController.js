'use strict';

 angular.module('invoice', ['resource.invoice', 'resource.invoiceParams'])
 	.controller('InvoiceCtrl', function(Invoice, InvoiceParams, $location, $scope, $log) {
 		
 		Invoice.get({idDobavljaca : InvoiceParams.idDobavljaca, idFakture : InvoiceParams.idFakture}, function(response) {
			$log.info(response);
			
			$scope.zaglavlje = response.zaglavlje;
			
			var datumRacuna = new Date($scope.zaglavlje.datumRacuna);
			$scope.zaglavlje.datumRacuna = datumRacuna.customFormat( "#DD#.#MM#.#YYYY#." );	//	customFormat metoda se nalazi u util/dateFormatter.js
			
			var datumValute = new Date($scope.zaglavlje.datumValute);
			$scope.zaglavlje.datumValute = datumValute.customFormat( "#DD#.#MM#.#YYYY#." );	//	customFormat metoda se nalazi u util/dateFormatter.js
			
			$log.info("Successfully obtained invoice data from REST.");

			$scope.go = function ( path ) {
				$log.info("OVDE");
  				$location.path( path );
			};
 		});
 	});
