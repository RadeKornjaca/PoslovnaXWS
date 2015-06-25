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
 .module('firmApp', [
  'ngAnimate',
  'ngCookies',
  'ngResource',
  'ngRoute',
  'ngSanitize',
  'ngTouch',
  'invoices',
  'resource.invoices',
  'invoice',
  'resource.invoice',
  'resource.invoiceParams'
  ])
 .config(function ($routeProvider) {
  $routeProvider
  .when('/', {
    templateUrl: 'views/main.html',
    controller: 'MainCtrl'
  })
  .when('/invoices',{
  	templateUrl: 'views/invoices.html',
    controller: 'InvoicesCtrl'
  })
  .when('/invoice',{
  	templateUrl: 'views/invoice.html',
    controller: 'InvoiceCtrl'
  })
  .otherwise({
    redirectTo: '/'
  })
});
