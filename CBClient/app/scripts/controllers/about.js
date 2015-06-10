'use strict';

/**
 * @ngdoc function
 * @name genApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the genApp
 */
angular.module('cbApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
