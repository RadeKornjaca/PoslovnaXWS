'use strict';

(function() {
	var CollectionCtrl = function($scope, $routeParams, $route, cbService) {

		//search.term - Kriterijum pretrage
		//search.field - Polje po kom se pretražujea
		$scope.searchParams = {'field':{}, 'term':''};
		//Ovde se pamti poslednji upit
		//Sortiranje koristi poslednji upit
		//samo doda svoje parametre sortiranja
		$scope.query = '';

		//redosled sortiranja po poljima
		$scope.sortList = {};
		var allowSort = true;

		var onResourceComplete = function(data) {

			$scope.entries = data.data;
			
			//Ne ponaša se kako treba kada nije lista
			if ($scope.entries === null 
				&& $scope.entries.constructor != Array){
				$scope.entries = [$scope.entries];
		}

			/*
			 * $scope.meta sadrži podatke o poljima dobavljenih podataka.
			 * Podaci obuhvataju ime i tip polja. Služi da bi generička forma
			 * mogla da napravi header tabele.
			 */
			 $scope.meta = data.meta;

			 //Inicijalno polja nisu sortirana.
			 for (var i = 0; i < $scope.meta.length; i++){
			 	if ($scope.sortList[$scope.meta[i].name] == undefined)
			 		$scope.sortList[$scope.meta[i].name] = '';


			 	//ID polje je potrebno za formiranje linkova za edit i brisanje
			 	//ID polje se nece prikazati u tabeli
			 	if ($scope.meta[i].type === 'id')
			 		$scope.idField = $scope.meta[i].name;

			 	//Posto je u pitanju samo prikaz, polja se mogu slobodno menjati.
			 	for (var j = 0; j < $scope.entries.length; j++){
			 		var entry = $scope.entries[j];

			 					 	
				 	if ($scope.meta[i].type == 'Date'){
				 		var dateLong = $scope.entries[j][$scope.meta[i].name];
				 		$scope.entries[j][$scope.meta[i].name] = new Date(dateLong);
				 	}

			 		if($scope.meta[i].type === 'zoom'
			 			|| $scope.meta[i].type === 'link'){
			 			//Nisu implementirani svi linkovi; npr za nalog
			 		if ($scope.entries[j][$scope.meta[i].name] == undefined)
			 			continue;
			 		var path = window.location.origin+window.location.pathname;
			 		$scope.entries[j][$scope.meta[i].name] = 
			 		$scope.entries[j][$scope.meta[i].name]
			 		.replace("http://localhost:8080/CentralnaBanka/services/restService/", path+"#/");

			 	}

			 }
			}

			allowSort = true;
		};

		var onError = function(reason) {
			$scope.error = "Could not fetch the data, reason: " + reason.statusText;
		};

		$scope.search = function() {

			if ($scope.searchParams.term === null || $scope.searchParams.field === null
				|| $scope.searchParams.term === undefined || $scope.searchParams.field.name === undefined){
				cbService.getResource($scope.type).then(onResourceComplete, onError);
			//resetuj upit za sort
			$scope.query = "";
			return;
		}

		var term = $scope.searchParams.term.replace(' ','-');
		var field = $scope.searchParams.field.name;

		if (term === ''){
			//resetuj upit za sort
			$scope.query = "";
			cbService.getResource($scope.type).then(onResourceComplete, onError);
			return;
		}

		$scope.query = field + "=" + term;

		cbService.getResourceFiltered($scope.type, $scope.query).then(onResourceComplete, onError);
	};

	$scope.setSearchField = function(field){
		$scope.searchParams.field = field;
	};

	$scope.sort = function(field){

		if ($scope.sortList[field] == 'desc' || $scope.sortList[field] == ''){
			$scope.sortList[field] = 'asc'
		}
		else{
			$scope.sortList[field] = 'desc'
		}

		$scope.sortQuery = '';

		//Ako postoji search parametar, treba dodati &
		if ($scope.query != '')
			$scope.sortQuery = '&';

		$scope.sortQuery = $scope.sortQuery.concat('sort='+field+':'+$scope.sortList[field]);

			//Ne moze sort dok se ne dobije odgovor
			allowSort = false;

			cbService.getResourceFiltered($scope.type, $scope.query + $scope.sortQuery).then(onResourceComplete, onError);
		}
		$scope.selectedEntry = null;
		$scope.select = function(entry){
			$scope.selectedEntry = entry;
		}

		/* Uzima putanju do kontrolera.
		 * npr: za CBClient/#/drzava će vratiti /drzava
		 * Ovo služi da se konkatenira na URL ka resursu
		 * kako bi se znalo o kom tipu resursa se radi. 
		 * Pošto ovaj kontroler služi i za zoom forme,
		 * poslednji u tip će biti onaj koji se prikazuje.
		 * npr: 4/naseljenoMesto/drzava
		 */
		 var route = $route.current.$$route.originalPath.split("/");

		 var id = $routeParams.id;

		 cbService.getResource("/"+id+"/"+route[2]+"/"+route[3]).then(onResourceComplete, onError);
		};

		var app = angular.module("cbApp");
		app.controller("CollectionCtrl", CollectionCtrl);

	}());