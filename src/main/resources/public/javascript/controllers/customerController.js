angular.module('myApp').controller('customerController', ['$scope', '$state', 'customerFactory', function($scope, $state, customerFactory){
	
	/*, ['ui.mask']*/
	/*$scope.mask1 = '(999) 999-9999';*/
	$scope.customer = {};
	var isValid = true;
	$scope.customerEditData = {};
	$scope.isEditing = false;
	$scope.customerList = [];
	/*var uiMask = require('angular-ui-mask');
*/
	
	//Gets The Data of customers.
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
	
	//Creating a Customer.
	$scope.createCustomer = function(customer){
		if(isValid){
			customer.firstName = $scope.customer.firstName;
			customer.lastName = $scope.customer.lastName;
			customer.email = $scope.customer.email;
			customer.phone = $scope.customer.phone;
			customerFactory.createCustomer(customer).then(
				function(success){
					console.log("Success Creating Customer");
					$scope.createCustomerResult = success
					$state.go("viewCustomers");
				},
				function(error){
					console.log("Error Creating Customer");
					$scope.createCustomerResult = error;
				}
			);
		}	
	};
	
	//Grabbing Customer Data for Edit customer Page.
	$scope.getCustomerData = function(customer){
		$state.go("editCustomer", {customer: customer});
	}
	
	//Deleting a customer.
	$scope.deleteCustomer = function(customerId){
		customerFactory.deleteCustomer(customerId).then(
				function(success){
					$scope.deleteCustomerResult = success
					console.log("success deleting customer");
					$state.go("viewCustomers", {}, {reload:true});
				},
				function(error){
					$scope.deleteCustomerResult = error;
					console.log("error deleting Customer");
				}
		);
	};

}]);
