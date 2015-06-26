'use strict';

angular.module('resource.partners', ['ngResource'])
	.factory('Partners', function ($resource) {
	
	return $resource('http://localhost:8080/client-rest-ws/partneri');
})
