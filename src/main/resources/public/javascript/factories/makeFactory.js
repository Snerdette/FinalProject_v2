angular.module('myApp').factory('makeFactory', ['$http', function($http){
	console.log("makeFactory");
	return {
		getAllMakes: function(make){console.log("getAllMakes");
				return $http.get('make');
		},
		getMake: function(make){console.log("getMake");
			return $http.get('/make/' + make);
		}
	}
	
}])