'use strict';

angular.module('items', ['resource.items', 'resource.item', 'resource.itemParams'])
	.controller('ItemsCtrl', function(Items, Item, ItemParams, $scope, $location, $log) {
	
	$scope.filterKolicina = 0;
	$scope.filterVrednost = 0;

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
			
		$scope.filterItems = function(){
        return function(item){
        	var kolicina = true, vrednost = true, jedinica = true, naziv = true;

        			if ($scope.byVrednost != null && $scope.byVrednost != undefined){
        				if ($scope.byVrednost == 1)
        					vrednost = item.vrednost > $scope.filterVrednost;
        				else 
        					if ($scope.byVrednost == 2)
        						vrednost = item.vrednost < $scope.filterVrednost;
        				else 
        					if ($scope.byVrednost == 0)
        						vrednost = item.vrednost == $scope.filterVrednost;
        				}
        				if ($scope.byKolicina != null && $scope.byKolicina != undefined){
        				if ($scope.byKolicina == 1)
        					kolicina = item.kolicina > $scope.filterKolicina;
        				else 
        					if ($scope.byKolicina == 2)
        						kolicina = item.kolicina < $scope.filterKolicina;
        				else 
        					if ($scope.byKolicina == 0)
        						kolicina = item.kolicina == $scope.filterKolicina;
        				}
        				
        				if ($scope.filterNaziv != null && $scope.filterNaziv != undefined  && $scope.filterNaziv != ""){
        					naziv = item.naziv == $scope.filterNaziv;
        				}
        				
        				if ($scope.filterJedinica != null && $scope.filterJedinica != undefined && $scope.filterJedinica != ""){
        					jedinica = item.jedinicaMere == $scope.filterJedinica;
        				}
        				
        				return kolicina && vrednost && jedinica && naziv;
        			}
        			}	
		
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
