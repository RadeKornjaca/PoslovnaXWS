'use strict';

var app = angular.module('cbApp');

app.directive('genericComponent', function ($compile) {

  var getTemplate = function(type, length, name, required){
    var tmpl = '<';
    switch(type){
      case "String": 
        tmpl += 'input type = \"text\" ng-model=\"'+item[name]+'\" maxlength=\"'+length+'\"'
      case "long":
      case "int": 
        tmpl += 'input type = \"number\" ng-model=\"'+item[name]+'\" maxlength=\"'+length+'\"'
    }
    if (required === 'true'){
      tmpl += 'requred';
    }

    tmpl += '\>'

    return tmpl;
  }; 

  var linker = function(scope, element, attrs, required){
    element.html(getTemplate(attrs.type, attrs.length, attrs.name, attrs.required));
    $compile(element.contents())(scope);

  };

  return {
    restrict: "E",
    replace: true,
    link: linker,
    scope: {
      type:'=',
      lengt:'=',
      name:'=',
      required:'='
    }
  };
});