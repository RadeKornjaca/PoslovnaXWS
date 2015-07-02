var app = angular.module("cbApp");
app.directive('contentItems', function ($compile, cbService) {


  var getTemplate = function(scope) {
    var template = '';
    for (var i = 0; i < scope.meta.length; i++){
      var meta = scope.meta[i];
      var restrict = meta.restriction;
      var type = meta.type;
      var fieldName = meta.name;

      //if (scope.ngModel[fieldName] === undefined)
      //  continue;

      template = template.concat('<div class="form-group">');
      template = template.concat('<label for=\"'+fieldName+'\" class=\"col-lg-2 control-label\">'+fieldName+'</label>');
      
      switch(type){
        case 'String': 
        template = template.concat('<div class="col-lg-10"><input type = \"text\" class = \"form-control\" ng-model=\"'
          +'ngModel.'+fieldName
          +'\" maxlength=\"'+restrict.length
          +'\"' + (restrict.regex != null ? ' pattern=\"' + restrict.regex + '\"' : '\"')
          +' required=' + !restrict.nullable 
          +' id=\"'+fieldName+'\" name=\"'+fieldName+'\"/></div>');
        break;
        case 'long':
        case 'int': 
        template = template.concat('<div class="col-lg-10"><input type = \"number\" class = \"form-control\" ng-model=\"'
          +'ngModel.'+fieldName
          +'\" maxlength=\"'+restrict.length
          +'\"' + (restrict.regex != null ? ' pattern=\"' + restrict.regex + '\"' : '\"')
          +' required=' + !restrict.nullable 
          +' id=\"'+fieldName+'\" name=\"'+fieldName+'\"/></div>');
        break;
        case 'double': 
        template = template.concat('<div class="col-lg-10"><input type = \"text\" class = \"form-control\" ng-model=\"'
          +'ngModel.'+fieldName
          +'\" maxlength=\"'+restrict.length
          +'\"' + 'pattern=\"[1-9]?[0-9]{0,14}(.[1-9]?[0-9])?\" required=' + !restrict.nullable 
          +' id=\"'+fieldName+'\" name=\"'+fieldName+'\"/></div>');
        break;
        case 'boolean': 
        template = template.concat('<div class="col-lg-10"><input type = \"checkbox\" class = \"form-control\"'
          +' ng-model=\"ngModel.'+fieldName+'\"'
          +' id=\"'+fieldName+'\" name=\"'+fieldName+'\"/></div>');
        break;
        case 'Date': 
        template = template.concat('<div class="col-lg-10"><input type = \"date\" class = \"form-control\"'
          +' ng-model=\"ngModel.'+fieldName+'\"'
          +' id=\"'+fieldName+'\" name=\"'+fieldName+'\"/></div>');
        break;
        case 'link':
        var link = '';
        if (scope.ngModel[fieldName] != undefined)
          link = scope.ngModel[fieldName].replace(cbService.restURL,"");

        var path = window.location.origin+window.location.pathname;

        template = template.concat('<a ng-href = \"'+path+"#"+link+'\">'+fieldName+'</a>');
        break;
        case 'zoom':
        var link = '';
        if (scope.ngModel[fieldName] != undefined){
          if (typeof scope.ngModel[fieldName] == 'string')
            link = scope.ngModel[fieldName].replace(cbService.restURL,"");
          else{
            //ima samo id u sebi, znaci to je prvo polje
            var id = scope.ngModel[fieldName][Object.keys(scope.ngModel[fieldName])[0]];
            link = id + '/' + fieldName;
          }
        }
        var path = window.location.origin+window.location.pathname;
        template = template.concat('<a ng-href = \"'+path+"#"+link+'\">'+fieldName+'</a>');
        template = template.concat('<br><a ng-href = \"'+path+window.location.hash+"/"+fieldName+'\">Promeni</a>');   
        break;
      }

      template = template.concat('</div>');
    }
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