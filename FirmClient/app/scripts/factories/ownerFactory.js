'use strict';

angular.module('resource.owner', ['ngResource'])
	.factory('Owner', function ($resource) {
	
	return $resource('http://localhost:8080/client-rest-ws/partneri/vlasnik/:idVlasnika');
})
