var app = angular.module("cbApp");
app.directive('contentItems', function ($compile) {


  var getTemplate = function(scope) {
    var template = '';
    for (var i = 0; i < scope.meta.length; i++){
      var meta = scope.meta[i];
      var restrict = meta.restriction;
      var type = meta.type;
      var fieldName = meta.name;

      if (scope.ngModel[fieldName] === undefined)
        continue;

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
        case 'link':
        var link = scope.ngModel[fieldName].replace("http://localhost:8080/CentralnaBanka/services/restService","");
        var path = window.location.origin+window.location.pathname;

        template = template.concat('<a ng-href = \"'+path+"#"+link+'\">'+fieldName+'</a>');
        break;
        case 'zoom':
        var link = scope.ngModel[fieldName].replace("http://localhost:8080/CentralnaBanka/services/restService","");
        var path = window.location.origin+window.location.pathname;
        template = template.concat('<a ng-href = \"'+path+"#"+link+'\">'+fieldName+'</a>');
        template = template.concat('<br><a ng-href = \"'+path+window.location.hash+"/"+fieldName+'\">Promeni</a>');   
        break;
      }

      template = template.concat('</div>');
    }
    template = template.concat('<button class=\"btn btn-success\" type=\"submit\" ng-click=\"submit(ngModel)\">Submit</button>'
      +'<button class=\"btn btn-danger\" ng-click="cancel()">Cancel</button>'
      )
    return template;
  }

  var linker = function(scope, element, attrs, $location) {

    element.html(getTemplate(scope, $location)).show();

    scope.location = $location;

    $compile(element.contents())(scope);

  }

  var redirect = function(){
    scope.location.path(scope.ngModel);
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
});