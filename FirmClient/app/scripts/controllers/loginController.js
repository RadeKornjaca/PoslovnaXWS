'use strict';

 angular.module('login', ['resource.partner', 'resource.owner', 'resource.user'])
 	.controller('LoginCtrl', function(Partner, Owner, User, $rootScope, $scope, $location, $log) {
 	
 		$scope.login = function() {
 			Partner.get({idDobavljaca : this.pib}).$promise.then(function(data) {
 				$log.info(data);
 				
 				var user = {
 					adresa : data.adresa,
 					id : data.id,
 					model : data.model,
 					naziv : data.naziv,
 					pib : data.pib,
 					pozivNaBroj : data.pozivNaBroj,
 					racun : data.racun
 				};
 				
 				
 				$rootScope.ownerView = false;
 				$rootScope.loggedIn = true;
 				
 				User.setUser(user);
 				$log.info(User.user.naziv + " se ulogovao");
 				
 				$location.path('/invoices');
 			}, function(error){
 				Owner.get({idVlasnika : this.pib}).$promise.then(function(data) {
	 				var user = {
	 					adresa : data.adresa,
	 					id : data.id,
	 					model : data.model,
	 					naziv : data.naziv,
	 					pib : data.pib,
	 					pozivNaBroj : data.pozivNaBroj,
	 					racun : data.racun
	 				};
	 				
	 				
	 				$rootScope.ownerView = true;
	 				$rootScope.loggedIn = true;
	 				
	 				User.setUser(user);
	 				$log.info(User.user.naziv + " se ulogovao kao vlasnik");
 				}, function(error){
 					$log.info("Nepostojeci PIB!");
 				});
 			});
 		};

 	});
