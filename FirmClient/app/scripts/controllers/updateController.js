'use strict';

 angular.module('updateItem', ['resource.items', 'resource.item', 'resource.itemParams'])
 	.controller('UpdateItemCtrl', function(Items, Item, ItemParams , $scope, $location, $log) {
	
 	Item.get({idDobavljaca : ItemParams.InvoiceParams.idDobavljaca, idFakture : ItemParams.InvoiceParams.idFakture, redniBroj : ItemParams.redniBroj}, function(response) {
		$scope.oldItem = response;
		$log.info("Successfully obtained invoice data from REST.");
 	});

	$scope.submit = function(){
		this.stavkaFakture.id = $scope.oldItem.id;
		
		var newItem = new Items();
		
		newItem.id = this.stavkaFakture.id;							//mrzim svoj zivot
		newItem.redniBroj = this.stavkaFakture.redniBroj;
		newItem.tip = this.stavkaFakture.tip;
		newItem.naziv = this.stavkaFakture.naziv;
		newItem.kolicina = this.stavkaFakture.kolicina;
		newItem.jedinicaMere = this.stavkaFakture.jedinicaMere;
		newItem.jedinicnaCena = this.stavkaFakture.jedinicnaCena;
		newItem.vrednost = this.stavkaFakture.vrednost;
		newItem.procenatRabata = this.stavkaFakture.procenatRabata;
		newItem.iznosRabata = this.stavkaFakture.iznosRabata;
		newItem.umanjenoZaRabat = this.stavkaFakture.umanjenoZaRabat;
		newItem.ukupanPorez = this.stavkaFakture.ukupanPorez;
		
		
		Item.update({idDobavljaca : ItemParams.InvoiceParams.idDobavljaca, idFakture : ItemParams.InvoiceParams.idFakture, redniBroj : ItemParams.redniBroj}, newItem);
		
		$location.path('/items');
	};

 	});
