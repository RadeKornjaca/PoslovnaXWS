'use strict';

angular.module('items', ['resource.items', 'resource.item', 'resource.itemParams'])
	.controller('ItemsCtrl', function(Items, Item, ItemParams, $scope, $location, $log) {

		Items.get({idDobavljaca : ItemParams.InvoiceParams.idDobavljaca,idFakture : ItemParams.InvoiceParams.idFakture}, function(response) {
			$scope.items = response.stavkaFakture;

			$log.info("Successfully obtained items data from REST.");
 		});

 		$scope.order = function(predicate) {
        	$scope.reverse = !$scope.reverse;
        	$scope.cssClass = $scope.reverse ? "glyphicon glyphicon-triangle-bottom" : "glyphicon glyphicon-triangle-top";		//	menja strelice u tabeli
        	 
        	$scope.predicate = predicate;
      	};

		$scope.go = function ( path, redniBroj, event ) {
			ItemParams.setRedniBrojStavke(redniBroj);
  			
  			$location.path( path );
		};
		
		$scope.goCreateItem = function(path) {
			$location.path(path);
		};
		
		$scope.update = function(path, redniBroj) {
			ItemParams.setRedniBrojStavke(redniBroj);
			$location.path(path);
		};		
		
		$scope.remove = function(redniBroj) {
			Item.delete({idDobavljaca : ItemParams.InvoiceParams.idDobavljaca, idFakture : ItemParams.InvoiceParams.idFakture, redniBroj : redniBroj}, function(){
					
					Items.get({idDobavljaca : ItemParams.InvoiceParams.idDobavljaca,idFakture : ItemParams.InvoiceParams.idFakture}, function(response) {
					$scope.items = response.stavkaFakture;

					$log.info("Successfully obtained items data from REST.");
 				});
			
			});
			

		};
		
	}).directive('stopEvent', function () {
        return {
            restrict: 'A',
            link: function (scope, element, attr) {
                if(attr && attr.stopEvent)
                    element.bind(attr.stopEvent, function (e) {
                        e.stopPropagation();
                    });
            }
        };
     });
