angular.module('myApp').controller('editPassController', 
		['$scope', '$state', 'customerFactory', 'vehicleFactory', 'passFactory', 'aPass',  function($scope, $state, customerFactory, vehicleFactory, passFactory, aPass){
	
	$scope.pass = aPass.data;
	$scope.customerList = [];
	$scope.vehicleList = [];
	/*$scope.passList = [];*/
	$scope.isEditing = false;
	var isValid = true;
	
	//After Pass is edited, PUT data to Database
	$scope.updatePass = function(pass){
		console.log(pass);
		passFactory.updatePass(pass.id, pass).then(
				function(success){
					$scope.updatePassResult = success.data;
					console.log("success updating Pass");
					$state.go("viewCustomers");
				},
				function(error){
					$scope.updatePassResult = error;
					console.log("error updating Pass");
				}
		);
	};
	
	//Gets The List of customers.
	$scope.getAllCustomers = customerFactory.getAllCustomers().then(
			function(success){
				$scope.customerList = success.data;
				console.log("Success retrieving CustomerList");
			},
			function(error){
				$scope.customerList = error;
				console.log("Error retrieving CustomerList");
			}
	);
	
	//Gets The List of vehicles.
	$scope.getAllVehicles = vehicleFactory.getAllVehicles().then(
			function(success){
				$scope.vehicleList = success.data;
				console.log("Success retrieving VehicleList");
			},
			function(error){
				$scope.vehicleList = error;
				console.log("Error retrieving VehicleList");
			}
	);
	
	/*//Gets The List of passes.
	$scope.getAllPasses = passFactory.getAllPasses().then(
			function(success){
				$scope.passList = success.data;
				console.log("Success retrieving PassList");
			},
			function(error){
				$scope.passList = error;
				console.log("Error retrieving PassList");
			}
	);*/
	
	
	
}]);