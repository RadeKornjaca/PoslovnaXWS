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
  'uplata',
  'zahtevZaPresek',

  'resource.items',
  'resource.item',
  'resource.invoice',
  'resource.invoices',

  'resource.invoiceParams',
  'resource.itemParams',

  'resource.partners',

  'resource.uplata',

  'resource.presek',

  
  'createInvoice',
  'createItem'
  ])
 .config(function ($routeProvider) {
  $routeProvider
  .when('/', {
    templateUrl: 'views/main.html',
    controller: 'MainCtrl'
  })
  .when('/createInvoice',{
  	templateUrl: 'views/createInvoice.html',
    controller: 'CreateInvoiceCtrl'
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
  .when('/createItem',{
  	templateUrl: 'views/createItem.html',
    controller: 'CreateItemCtrl'
  })
  .when('/uplata',{
    templateUrl: 'views/uplata.html',
    controller: 'UplataController'
  })
  .when('/presek',{
    templateUrl: 'views/presek.html',
    controller: 'PresekController'
  })
  .otherwise({
    redirectTo: '/'
  })
});
