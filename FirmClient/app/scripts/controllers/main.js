'use strict';

/**
 * @ngdoc function
 * @name genApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the genApp
 */
angular.module('firmApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
