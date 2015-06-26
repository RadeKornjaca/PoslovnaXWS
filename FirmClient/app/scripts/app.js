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
  'invoice',
  'items',
  'item',

  'resource.items',
  'resource.item',
  'resource.invoice',
  'resource.invoices',

  'resource.invoiceParams',
  'resource.itemParams',

  'resource.partners'
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
  .when('/items',{
    templateUrl: 'views/items.html',
    controller: 'ItemsCtrl'
  })
  .when('/item',{
    templateUrl: 'views/item.html',
    controller: 'ItemCtrl'
  })
  .otherwise({
    redirectTo: '/'
  })
});
