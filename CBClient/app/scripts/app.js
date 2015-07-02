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
  .when('/drzava', {
    templateUrl: 'views/read-edit.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/banka', {
    templateUrl: 'views/read-edit.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/dnevnoStanjeRacuna', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/nalog', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/naseljenoMesto', {
    templateUrl: 'views/read-edit.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/poruka', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/racunBanke', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/stavkaDnevnogRacuna', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/stavkaPoruke', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/mt102', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/mt103', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/mt900', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/mt910', {
    templateUrl: 'views/read.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/:id/drzava', {
    templateUrl: 'views/edit.html',
    controller: 'EditCtrl'
  })
  .when('/:id/naseljenoMesto', {
    templateUrl: 'views/edit.html',
    controller: 'EditCtrl'
  })
  .when('/:id/banka', {
    templateUrl: 'views/edit.html',
    controller: 'EditCtrl'
  })
  .when('/:id/racunBanke', {
    templateUrl: 'views/edit.html',
    controller: 'EditCtrl'
  })
  .when('/drzava/new', {
    templateUrl: 'views/edit.html',
    controller: 'AddCtrl'
  })
  .when('/naseljenoMesto/new', {
    templateUrl: 'views/edit.html',
    controller: 'AddCtrl'
  })
  .when('/banka/new', {
    templateUrl: 'views/edit.html',
    controller: 'AddCtrl'
  })
  .when('/racunBanke/new', {
    templateUrl: 'views/edit.html',
    controller: 'AddCtrl'
  })
  .when('/:id/naseljenoMesto/drzava', {
    templateUrl: 'views/zoom.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/:id/naseljenoMesto/drzava', {
    templateUrl: 'views/zoom.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/:id/racunBanke/banka', {
    templateUrl: 'views/zoom.html',
    controller: 'ReadOnlyCtrl'
  })
  .when('/naseljenoMesto/new/drzava', {
    templateUrl: 'views/zoom.html',
    controller: 'ReadOnlyCtrl'
  })
 .when('/racunBanke/new/drzava', {
    templateUrl: 'views/zoom.html',
    controller: 'ReadOnlyCtrl'
  })
  .otherwise({
    redirectTo: '/'
  })
});
