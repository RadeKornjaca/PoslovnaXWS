'use strict';

angular.module('uplata', ['resource.uplata'])
.controller('UplataController', function(Uplata, $location, $scope, $log) {

	$scope.datumValute = new Date();
	$scope.datumNaloga = new Date();

	/*$scope.uplata = {
		nalog : {
			id: "1",
			hitno: false,
			oznakaValute : "DIN",
			drzava: {
				nazivDrzave : "Srbija",
				sifraDrzave: "SRB",
				naseljenaMesta: {}
			}
		}
	};*/
	
	/*$scope.uplata.nalog = {};
	$scope.uplata.nalog.hitno = false;
	$scope.uplata.nalog.oznakaValute = "DIN";
	$scope.uplata.nalog.id = "1";
	$scope.uplata.nalog.drzava = {};
	$scope.uplata.nalog.drzava.nazivDrzave = "Srbija";
	$scope.uplata.nalog.drzava.sifraDrzave = "SRB";
	$scope.uplata.nalog.drzava.naseljenaMesta = {};*/

	$scope.uplata = new Uplata();

	/*$scope.submit = function(){
		$scope.uplata.$save(function(response) {
			$log.info(response);
			
			$scope.zaglavlje = response.zaglavlje;
			
			var datumRacuna = new Date($scope.zaglavlje.datumRacuna);
			$scope.zaglavlje.datumRacuna = datumRacuna.customFormat( "#YYYY#-#MM#-#DD#." );	//	customFormat metoda se nalazi u util/dateFormatter.js
			
			var datumValute = new Date($scope.zaglavlje.datumValute);
			$scope.zaglavlje.datumValute = datumValute.customFormat( "#YYYY#-#MM#-#DD#." );	//	customFormat metoda se nalazi u util/dateFormatter.js
			
		});
}*/

$scope.submit = function(){
	$scope.uplata.nalog.hitno = false;
	$scope.uplata.nalog.oznakaValute = "DIN";
	$scope.uplata.nalog.id = "1";
	$scope.uplata.nalog.naseljenoMesto.drzava = {};
	$scope.uplata.nalog.naseljenoMesto.drzava.nazivDrzave = "Srbija";
	$scope.uplata.nalog.naseljenoMesto.drzava.sifraDrzave = "SRB";
	$scope.uplata.nalog.naseljenoMesto.drzava.naseljenaMesta = {};
	$scope.uplata.nalog.naseljenoMesto.nalozi = {};

	$scope.uplata.nalog.datumNaloga = $scope.datumNaloga;
	$scope.uplata.nalog.datumValute = $scope.datumValute;

	console.log($scope.uplata);
	console.log(JSON.stringify($scope.uplata));

	$scope.uplata.$save(function(response) {
		$log.info(response);

		});


}

});
