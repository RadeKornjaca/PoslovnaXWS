angular.module('resource.invoice', ['ngResource'])
	.factory('Invoice', function ($resource) {
	
	return $resource.get('http://localhost:8080/client-rest-ws/partneri/' + '14234512432' + '/fakture');		//PAZNJA!!! HARD KODIRANO!
})
