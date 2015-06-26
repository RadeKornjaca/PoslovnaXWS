'use strict';

angular.module('resource.items', ['ngResource'])
	.factory('Items', function ($resource) {
	
	return $resource('http://localhost:8080/client-rest-ws/partneri/:idDobavljaca/fakture/:idFakture/stavke');
});