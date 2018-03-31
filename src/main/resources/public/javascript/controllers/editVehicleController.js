angular.module('myApp').controller('editVehicleController',
		['$scope', '$state', 'vehicleFactory', 'modelFactory', 'makeFactory', 'aVehicle',  
		 function($scope, $state, vehicleFactory, modelFactory, makeFactory, aVehicle){
	
	$scope.vehicleEditData = {};
	$scope.make = {};
	$scope.vehicle = aVehicle.data;
	$scope.vehicleList = [];
	$scope.makeList = [];
	$scope.modelList = [];
	$scope.modelsForMake = [];
	var isValid = true;
	var editing = false;

	//Gets The Data of vehicles.
	$scope.getAllVehicles = function(){
		vehicleFactory.getAllVehicles().then(
			function(success){
				$scope.vehicleList = success.data;
				console.log("Success retrieving VehicleList");
			},
			function(error){
				$scope.vehicleList = error;
				console.log("Error retrieving VehicleList");
			}
		);
	};
	
	
	//After Vehicle is edited, PUT data to Database
	$scope.updateVehicle = function(vehicle){
		vehicleFactory.updateVehicle(vehicle.id, vehicle).then(
			function(success){
				$scope.updateVehicleResult = success.data;
				console.log("success updating Vehicle");
				$state.go("viewVehicles");
			},
			function(error){
				$scope.updateVehicleResult = error;
				console.log("error updating Vehicle");
			}
		);
	};
	
	//Gets Make Data
	$scope.getAllMakes = function(){
		console.log("getAllMakes Factory Call");
		makeFactory.getAllMakes().then(
				
			function(success){console.log("Success.data");
				$scope.makeList = success.data;
				console.log("Success retrieving MakeList");
			},
			function(error){console.log("Error makeList");
				$scope.makeList = error;
				console.log("Error retrieving MakeList");
			}
		);
	};
	
	//Gets Model Data
	$scope.getAllModels = function() {
		modelFactory.getAllModels().then(
			function(success){
				$scope.modelList = success.data;
				console.log("Success retrieving ModelList");
			},
			function(error){
				$scope.modelList = error;
				console.log("Error retrieving ModelList");
			}
		);
	};
	
	$scope.onChange = function(makeId){
		console.log(makeId);
		modelFactory.getModelsForMake(makeId).then(
			function(success){
				$scope.modelsForMake = success.data;
				console.log(success.data);
			},
			function(error){
				$scope.modelsForMake = error;
				console.log("Error retrieving models for make " + makeId);
			}
		);
		
		$scope.onLoad = function(vehicle){
			$scope.vehicle.model = vehicle.model(modelId);
			$scope.model.make.id = make.id;
			
		}
		
	};

}]);