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
  .when('/:id/drzave', {
    templateUrl: 'views/edit.html',
    controller: 'EditCtrl'
  })
  .otherwise({
    redirectTo: '/'
  })
}).directive('contentItems', function ($compile) {


  var getTemplate = function(scope) {
    var template = '';
    for (var i = 0; i < scope.meta.length; i++){
      var meta = scope.meta[i];
      var restrict = meta.restriction;
      var type = meta.type;
      var fieldName = meta.name;

      template = template.concat('<div class="form-group">');
      template = template.concat('<label for=\"'+fieldName+'\" class=\"col-lg-2 control-label\">'+fieldName+'</label>');
      switch(type){
        case 'String': 
        template = template.concat('<div class="col-lg-10"><input type = \"text\" class = \"form-control\" ng-model=\"'
          +'ngModel.'+fieldName+'\" maxlength=\"'+restrict.length+'\"'
          +'id=\"'+fieldName+'\" name=\"'+fieldName+'\"/></div>');
        break;
        case 'long':
        case 'int': 
        template = template.concat('<div class="col-lg-10"><input type = \"number\" class = \"form-control\" ng-model=\"'
          +'ngModel.'+fieldName+'\" maxlength=\"'+restrict.length+'\"'
          +'id=\"'+fieldName+'\" name=\"'+fieldName+'\"/></div>');
        break;
      }

      template = template.concat('</div>');
    }
    template = template.concat('<div class="form-group">'
      +'<button class=\"btn btn-success\" type=\"submit\" ng-click=\"submit(ngModel)\">Submit</button>'
      +'<button class=\"btn btn-danger\" ng-click="cancel()">Cancel</button>'
      +'</div>')
    return template;
  }

  var linker = function(scope, element, attrs) {

    element.html(getTemplate(scope)).show();

    $compile(element.contents())(scope);

  }

  return {
    restrict: "E",
    scope: {
      ngModel: '=',
      meta: '=',
      submit: '&'

    },
    link: linker
  }
});;
