'use strict';

angular.module('resource.partner', ['ngResource'])
	.factory('Partner', function ($resource) {
	
	return $resource('http://localhost:8080/client-rest-ws/partneri/:idDobavljaca');
})
