'use strict';

//	fabrika potrebna za prenos informacija potrebnih da dobijanje odabrane fakture
//	fabrika proizvodi POJO objekat cije vrednosti se set-uju u invoicesController-u,
//	a get-uju u invoiceController-u


angular.module('resource.invoiceParams', [])
	.factory('InvoiceParams', function () {
	
	var setIdDobavljaca = function(idDobavljaca) {
		this.idDobavljaca = idDobavljaca;
	};
	
	var setIdFakture = function(idFakture) {
		this.idFakture = idFakture;
	};
	
	var getIdDobavljaca = function() {
			return idDobavljaca;
	};
	
	var getIdFakture =  function() {
			return idFakture;
	};
	
	return {
		setIdDobavljaca : setIdDobavljaca,
		setIdFakture : setIdFakture,
		idDobavljaca : getIdDobavljaca,
		idFakture : getIdFakture
	};
})
