(function(){
	var cbService = function($http){
		var getAllMessages = function(){
			return $http.get("http://localhost:8080/CentralnaBanka/services/restService/poruke").then(function(response){
				return response.data;
			});
		};
		var getResource = function(type){
			return $http.get("http://localhost:8080/CentralnaBanka/services/restService"+type).then(function(response){
				return response.data;
			});
		};
		return {
			getAllMessages : getAllMessages,
			getResource : getResource
		};
	};
	var module = angular.module("cbApp");
	module.factory("cbService", cbService);
}());