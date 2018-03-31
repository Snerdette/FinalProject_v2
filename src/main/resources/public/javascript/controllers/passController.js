angular.module('myApp').controller('passController', 
		['$scope', '$state', 'passFactory', 'customerFactory', 'vehicleFactory', 
		 function($scope, $state, passFactory, customerFactory, vehicleFactory){
	
	$scope.val = {};
	$scope.pass = {};
	var isValid = true;
	$scope.isEditing = false;
	$scope.passList = [];
	$scope.passEditData = {};
	$scope.customerList = [];
	$scope.vehicleList = [];
	
	
	//Gets The List of passes.
	$scope.getAllPasses = passFactory.getAllPasses().then(
			function(success){
				$scope.passList = success.data;
				console.log("Success retrieving PassList");
			},
			function(error){
				$scope.passList = error;
				console.log("Error retrieving PassList");
			}
	);
	
	/*$scope.pass.customers = [];*/
	
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
	
	//Gets The List of customers.
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
	
	//Creating a Pass.
	$scope.createPass = function(pass){
		if(isValid){
			pass.price = $scope.pass.price;
			pass.expDate = $scope.pass.expDate;
			pass.customer = $scope.pass.customer;
			pass.vehicle = $scope.pass.vehicle;
			pass.type = $scope.pass.type;
			pass.isActive = $scope.pass.isActive;
			passFactory.createPass(pass).then(
				function(success){
					console.log("Success Creating Pass");
					$scope.createPassResult = success
					$state.go("viewPasses");
				},
				function(error){
					console.log("Error Creating Pass");
					$scope.createPassResult = error;
				}
			);
		}
		
	};
	
	//Grabbing Pass List for Edit pass Page.
	$scope.getPassData = function(pass){
		$state.go("editPass", {pass: pass});
	}
	
	//Deleting a pass.
	$scope.deletePass = function(passId){
		passFactory.deletePass(passId).then(
				function(success){
					$scope.deletePassResult = success
					console.log("success deleting pass");
					$state.go("viewPasses", {}, {reload:true});
				},
				function(error){
					$scope.deletePassResult = error;
					console.log("error deleting Pass");
				}
		);
	};
	
	$scope.submitPass = function(){
		expDate.pattern
	}

}]);
