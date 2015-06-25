'use strict';

 angular.module('invoice', ['resource.invoice', 'invoices', 'resource.invoiceParams'])
 	.controller('InvoiceCtrl', function(Invoice, InvoiceParams, $scope, $log) {
 		
 		$log.info(InvoiceParams.idFakture);
 		$log.info(InvoiceParams.idDobavljaca);
 		
 		Invoice.get({idDobavljaca : InvoiceParams.idDobavljaca, idFakture : InvoiceParams.idFakture}, function(response) {
			$log.info(response);
			
			$scope.zaglavlje = response.zaglavlje;
			//$scope.stavkeFakture = response.stavkeFakture;
			
			$log.info("Successfully obtained invoice data from REST.");
 		});


 	});
