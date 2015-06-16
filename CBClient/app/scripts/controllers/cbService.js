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

		var getResourceById = function(type, id){
			return $http.get("http://localhost:8080/CentralnaBanka/services/restService/"+id+type).then(function(response){
				return response.data;
			});
		};

		var editResource = function(type, id, data){
			var wrapper = {
				"wrapper":{"data":data}
			};

			return $http.put("http://localhost:8080/CentralnaBanka/services/restService/"+id+type, JSON.stringify(wrapper)).then(function(response){
				return response.data;
			});
		}

		var getResourceFiltered = function(type, query){
			return $http.get("http://localhost:8080/CentralnaBanka/services/restService"+type+"?"+query).then(function(response){
				return response.data;
			});
		};
		return {
			getAllMessages : getAllMessages,
			getResource : getResource,
			getResourceFiltered : getResourceFiltered,
			getResourceById: getResourceById,
			editResource: editResource
		};
	};
	var module = angular.module("cbApp");
	module.factory("cbService", cbService);
}());