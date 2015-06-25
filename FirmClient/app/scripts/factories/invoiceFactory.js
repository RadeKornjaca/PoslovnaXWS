'use strict';

angular.module('resource.invoice', ['ngResource'])
	.factory('Invoice', function ($resource) {
	
	return $resource('http://localhost:8080/client-rest-ws/partneri/:idDobavljaca/fakture/:idFakture');
})
