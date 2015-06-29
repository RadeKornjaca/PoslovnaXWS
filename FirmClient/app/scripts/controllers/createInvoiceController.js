'use strict';

 angular.module('createInvoice', ['resource.invoices', 'resource.user'])
 	.controller('CreateInvoiceCtrl', function(Invoices, User, $scope, $location, $log) {
 	
 	var partneri = [];
 	this.datumRacuna = new Date();
 	this.datumValute = new Date();
 	
	/*Partners.get(function(response) {
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
 	});*/
 	
 	
 	$scope.submit = function() {
 		var zaglavlje = {
 			id : this.id,
 			dobavljac : User.user,
 			kupac : User.user,
 			brojRacuna : this.brojRacuna,
 			datumRacuna : this.datumRacuna,
 			vrednostRobe : 0,
 			vrednostUsluge : 0,
 			ukupnoRobaIUsluge : 0,
 			ukupanRabat : 0,
 			ukupanPorez : 0,
 			oznakaValute : this.oznakaValute,
 			iznosZaUplatu : 0,
 			uplataNaRacun : this.uplataNaRacun,
 			datumValute : this.datumValute
 			
 		};
 		
 		var newInvoice = new Invoices({zaglavlje : zaglavlje});
 		 	
 		newInvoice.$save({idDobavljaca : User.user.pib});
 		
 		$location.path('/invoices');
 		
 	};


	

 	});
