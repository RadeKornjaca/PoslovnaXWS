'use strict';

 angular.module('createInvoice', ['resource.invoices', 'resource.partners'])
 	.controller('CreateInvoiceCtrl', function(Invoices, Partners, $scope, $location, $log) {
 	
 	var partneri = [];
 	
	Partners.get(function(response) {
 		$scope.partners = response.partneri;
 		
 		for(var i=0;i<response.partneri.length;i++) {
 			partneri[i] = {
 				naziv : response.partneri[i].naziv,
 				racun : response.partneri[i].racun,
 				pozivNaBroj : response.partneri[i].pozivNaBroj,
 				pib : response.partneri[i].pib,
 				adresa : response.partneri[i].adresa
 			}
 		}	
 	});
 	
 	/*var createDate = function(dateText) {
 		var chunks = dateText.split('/');
 		
 		var day = chunks[0];
 		var month = chunks[1];
 		var year = chunks[2];
 		
 		return new Date(year, month-1, day, 0, 0, 0, 0);
 	};*/
 	
 	
 	$scope.submit = function() {
 		var zaglavlje = {
 			id : this.id,
 			dobavljac : partneri[0],
 			kupac : partneri[0],
 			brojRacuna : this.brojRacuna,
 			datumRacuna : new Date(),
 			vrednostRobe : 0,
 			vrednostUsluge : 0,
 			ukupnoRobaIUsluge : 0,
 			ukupanRabat : 0,
 			ukupanPorez : 0,
 			oznakaValute : this.oznakaValute,
 			iznosZaUplatu : 0,
 			uplataNaRacun : this.uplataNaRacun,
 			datumValute : new Date()
 			
 		};
 		
 		var newInvoice = new Invoices({zaglavlje : zaglavlje});
 		 
 		//$log.info(newInvoice); 	
 		newInvoice.$save({idDobavljaca : '14234512432'});
 		
 	};


 	
 	//funkcija koja otvara datepicker
	$scope.openDatepicker = function($event, opened) {
		$event.preventDefault();
		$event.stopPropagation();
		$scope[opened] = true;
	};

	

 	});
