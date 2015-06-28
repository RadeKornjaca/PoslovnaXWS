'use strict';

angular.module('resource.uplata', ['ngResource'])
	.factory('Uplata', function ($resource) {
	return $resource('http://localhost:8080/client-rest-ws/partneri/uplata');
})
