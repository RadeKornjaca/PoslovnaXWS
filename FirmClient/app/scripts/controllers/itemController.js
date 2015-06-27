'use strict';

 angular.module('item', ['resource.item', 'resource.itemParams'])
 	.controller('ItemCtrl', function(Item, ItemParams, $location, $scope, $log) {

 		Item.get({idDobavljaca : ItemParams.InvoiceParams.idDobavljaca, idFakture : ItemParams.InvoiceParams.idFakture, redniBroj : ItemParams.redniBroj}, function(response) {
			$log.info(response);
			$scope.item = response;
			$log.info("Successfully obtained invoice data from REST.");
 		});
 	});
