'use strict';

//	fabrika potrebna za prenos informacija potrebnih da dobijanje odabrane fakture
//	fabrika proizvodi POJO objekat cije vrednosti se set-uju u invoicesController-u,
//	a get-uju u invoiceController-u


angular.module('resource.itemParams', ['resource.invoiceParams'])
	.factory('ItemParams', function (InvoiceParams) {
	
	var setRedniBrojStavke = function(redniBroj) {
		this.redniBroj = redniBroj;
	};
	
	var getRedniBrojStavke = function() {
			return idStavke;
	};
	
	return {
		InvoiceParams: InvoiceParams,
		setRedniBrojStavke: setRedniBrojStavke,
		redniBroj : getRedniBrojStavke
	};
})
