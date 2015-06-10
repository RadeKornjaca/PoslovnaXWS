'use strict';

(function() {
	var AllMessagesCtrl = function($scope, $routeParams, cbService) {

		var onMessagesComplete = function(data) {
			$scope.messages = data.wrapper.data;
		};

		var onError = function(reason) {
			$scope.error = "Could not fetch the data, reason: " + reason.statusText;
		};

		cbService.getAllMessages().then(onMessagesComplete, onError);
	};
	var app = angular.module("cbApp");
	app.controller("AllMessagesCtrl", AllMessagesCtrl);
}());