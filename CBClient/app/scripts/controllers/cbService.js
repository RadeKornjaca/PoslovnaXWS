(function(){
	var cbService = function($http){

		var restURL = "http://localhost:8080/CentralnaBanka/services/restService";

		var getResource = function(type){
			return $http.get(restURL+type).then(function(response){
				return response.data;
			});
		};

		var getResourceById = function(type, id){
			return $http.get(restURL+'/'+id+type).then(function(response){
				return response.data;
			});
		};

		var editResource = function(type, id, data){
			var wrapper = {
				"wrapper":{"data":data}
			};

			return $http.put(restURL+'/'+id+type, JSON.stringify(wrapper)).then(function(response){
				return response.data;
			});
		}

		var deleteResource = function(type, id){

			return $http.delete(restURL+'/'+id+type).then(function(response){
				return response.data;
			});
		}

		var newResource = function(type, data){
			var wrapper = {
				"wrapper":{"data":data}
			};

			return $http.post(restURL+type, JSON.stringify(wrapper)).then(function(response){
				return response.data;
			});
		}

		var getResourceFiltered = function(type, query){
			return $http.get(restURL+type+"?"+query).then(function(response){
				return response.data;
			});
		};
		var doKliring = function(){
			return $http.put(restURL+'/kliring').then(function(response){
				return response.data;
			});
		}
		return {
			getResource : getResource,
			getResourceFiltered : getResourceFiltered,
			getResourceById: getResourceById,
			editResource: editResource,
			newResource : newResource,
			deleteResource : deleteResource,
			doKliring : doKliring,
			restURL : restURL
		};
	};
	var module = angular.module("cbApp");
	module.factory("cbService", cbService);
}());