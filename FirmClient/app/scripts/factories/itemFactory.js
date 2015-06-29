'use strict';

angular.module('resource.item', ['ngResource'])
	.factory('Item', function ($resource) {
	
	return $resource('http://localhost:8080/client-rest-ws/partneri/:idDobavljaca/fakture/:idFakture/stavke/:redniBroj', null,
	{
    	'update': { method:'PUT' }
    });
});
