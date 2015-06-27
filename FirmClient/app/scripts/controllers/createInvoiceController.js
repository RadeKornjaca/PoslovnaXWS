'use strict';

 angular.module('createInvoice', ['resource.invoices', 'resource.partners'])
 	.controller('CreateInvoiceCtrl', function(Invoices, Partners, $scope, $location, $log) {
 	
 	
	Partners.get(function(response) {
 		$scope.partners = response.partneri;	
 	});
 	
 	$scope.submit = function() {
 		zaglavlje = {
 			id : this.id,
 			dobavljac : $scope.partners[this.i],
 			brojRacuna : this.brojRacuna,
 			datumRacuna : createDate(datumRacuna),
 			vrednostRobe : 0,
 			vrednostUsluge : 0,
 			ukupnoRobaIUsluge : 0,
 			ukupanRabat : 0,
 			ukupanPorez : 0,
 			iznosZaUplatu : 0,
 			datumValute : createDate(datumValute)
 			
 		};
 		
 		$log.info(zaglavlje);
 	};
 	
 	/*Invoices.post() {
 		
 	};*/
 	var createDate = function(dateText) {
 		var chunks = dateText.split('.');
 		
 		var day = chunks[0];
 		var month = chunks[1];
 		var year = chunks[2];
 		
 		return new Date(year, month-1, day, 0, 0, 0, 0);
 	};
 	
 	//funkcija koja otvara datepicker
	$scope.openDatepicker = function($event, opened) {
		$event.preventDefault();
		$event.stopPropagation();
		$scope[opened] = true;
	};

	

 	});
