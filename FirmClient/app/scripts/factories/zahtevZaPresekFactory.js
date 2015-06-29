'use strict';

angular.module('resource.presek', ['ngResource'])
	.factory('ZahtevZaPresek', function ($resource) {
	return $resource('http://localhost:8080/client-rest-ws/partneri/presek', null, 
	{
		'update': { method: 'PUT'}
	});
})