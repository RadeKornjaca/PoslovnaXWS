'use strict';

/**
 * @ngdoc overview
 * @name genApp
 * @description
 * # genApp
 *
 * Main module of the application.
 */
 angular
 .module('cbApp', [
  'ngAnimate',
  'ngCookies',
  'ngResource',
  'ngRoute',
  'ngSanitize',
  'ngTouch'
  ])
 .config(function ($routeProvider) {
  $routeProvider
  .when('/', {
    templateUrl: 'views/main.html',
    controller: 'MainCtrl'
  })
  .when('/about', {
    templateUrl: 'views/about.html',
    controller: 'AboutCtrl'
  })
  .when('/messages', {
    templateUrl: 'views/messages.html',
    controller: 'AllMessagesCtrl'
  })
  .when('/drzave', {
    templateUrl: 'views/drzave.html',
    controller: 'ReadOnlyCtrl'
  })
  .otherwise({
    redirectTo: '/'
  });
});
