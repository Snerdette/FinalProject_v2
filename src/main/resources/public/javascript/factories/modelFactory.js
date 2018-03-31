angular.module('myApp').factory('modelFactory', ['$http', function($http){
	
	return {
		getAllModels: function(model){
			return $http.get('model');
		},
		getModel: function(model){
			return $http.get('/model/' + model);
		},
		getModelsForMake: function(makeId){
			return $http.get('/model/make_id/' + makeId);
		}
	}
}])