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
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/banke', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/dnevnaStanjaRacuna', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/nalozi', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/naseljenaMesta', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/poruke', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/racuniBanaka', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/stavkeDnevnogRacuna', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/stavkePoruka', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .otherwise({
    redirectTo: '/'
  });
});
