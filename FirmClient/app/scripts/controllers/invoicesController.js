'use strict';

angular.module('invoices', ['resource.invoices', 'resource.invoiceParams', 'resource.user'])
.controller('InvoicesCtrl', function(Invoices, InvoiceParams, User, $scope, $location, $log) {

	$scope.filterDatumRacuna = new Date();
	$scope.filterDatumValute = new Date();
	$scope.filterIznos = 0;

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
        

        $scope.filterInvoices = function(){
        return function(item){
        	var datumValute = true, iznos = true, datumRacuna = true;

        	if ($scope.byDatumRacuna != null && $scope.byDatumRacuna != undefined){
        		if ($scope.byDatumRacuna == 1)
        			datumRacuna = item.zaglavlje.datumRacuna > $scope.filterDatumRacuna;
        		else 
        			if ($scope.byDatumRacuna == 2)
        				datumRacuna = item.zaglavlje.datumRacuna < $scope.filterDatumRacuna;
        		}

        		if ($scope.byDatumValute != null && $scope.byDatumValute != undefined){

        			if ($scope.byDatumValute == 1)
        				datumValute = item.zaglavlje.datumValute > $scope.filterDatumValute;
        			else 
        				if ($scope.byDatumValute == 2)
        					datumValute = item.zaglavlje.datumValute< $scope.filterDatumValute;
        			}

        			if ($scope.byIznos != null && $scope.byIznos != undefined){
        				if ($scope.byIznos == 1)
        					iznos = item.zaglavlje.iznosZaUplatu > $scope.filterIznos;
        				else 
        					if ($scope.byIznos == 2)
        						iznos = item.zaglavlje.iznosZaUplatu < $scope.filterIznos;
        				else 
        					if ($scope.byIznos == 0)
        						iznos = item.zaglavlje.iznosZaUplatu == $scope.filterIznos;
        				}
        				return datumValute && iznos && datumRacuna;
        			}
        			}

        		});


