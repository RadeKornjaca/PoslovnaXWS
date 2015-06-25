'use strict';

angular.module('resource.invoices', ['ngResource'])
	.factory('Invoices', function ($resource) {
	
	return $resource('http://localhost:8080/client-rest-ws/partneri/:idDobavljaca/fakture');
})
