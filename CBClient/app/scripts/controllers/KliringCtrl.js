'use strict';

(function() {
	var KliringCtrl = function(ZoomService, $scope, $routeParams, $route, cbService) {

		var onKliringComplete = function(data) {
			$scope.response = "Uspešno izvršen kliring.";
				$scope.error = false;
				$scope.success = true;
			};

			var onError = function(reason) {
				$scope.response = "Neuspešno izvršavanje kliringa: " + reason.status +" "+ reason.statusText;
				$scope.error = true;
				$scope.success = false;
			};

		$scope.doKliring = function(){
			cbService.doKliring().then(onKliringComplete, onError);
		}

		};

		var app = angular.module("cbApp");
		app.controller("KliringCtrl", KliringCtrl);

	}());