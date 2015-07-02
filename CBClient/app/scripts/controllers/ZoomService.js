/*
 * Service za razmenu odabranog entiteta između servisa.
*/
var myModule = angular.module('cbApp');
myModule.factory('ZoomService', function() {

	var picked;
	var taken = true;
	var field;
	
	var setPicked = function(newPick, newField){
		picked = newPick;
		field = newField;
		taken = false; 
	};

	var take = function(){
		if (!taken){
			taken = true;
			return {
				picked : picked,
				field : field
			}
		}
	}

  return {
  	picked : picked,
  	take : take,
  	setPicked : setPicked
  };
});