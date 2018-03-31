(function() {
	angular.module("myApp").config(appConfig).run([ '$state', function($state) {
		$state.transitionTo('home');
	} ]);

	// Create Power page.
	function appConfig($stateProvider) {

		// Index page.									                  Index Page.
		var index = {
			name : 'index',
			url : '/index',
			templateUrl : 'index.html'
		};
		$stateProvider.state(index);
		
		// Home page.									                  Home Page.
		var home = {
			name : 'home',
			url : '/home',
			templateUrl : '../templates/home.html'
		};
		$stateProvider.state(home);
		
		// viewCustomers page.												View Pages.
		var viewCustomers = {
			name : 'viewCustomers',
			url : '/viewCustomers',
			templateUrl : '../templates/viewCustomers.html',
			controller: 'customerController'
		};
		$stateProvider.state(viewCustomers);
		
		// viewPasses page.
		var viewPasses = {
			name : 'viewPasses',
			url : '/viewPasses',
			templateUrl : '../templates/viewPasses.html',
			controller: 'passController'
		};
		$stateProvider.state(viewPasses);
		
		// viewVehicles page.
		var viewVehicles = {
			name : 'viewVehicles',
			url : '/viewVehicles',
			templateUrl : '../templates/viewVehicles.html',
			controller: 'vehicleController'
		};
		$stateProvider.state(viewVehicles);
		
		// Create a Customer.												Create Pages.
		var createCustomer = {
			name : 'createCustomer',
			url : '/createCustomer',
			templateUrl : '../templates/createCustomer.html',
			controller: 'customerController'
		};
		$stateProvider.state(createCustomer);
		
		
		// Create a Pass.
		var createPass = {
			name : 'createPass',
			url : '/createPass}',
			templateUrl : '../templates/createPass.html',
			controller: 'passController'
		};
		$stateProvider.state(createPass);
		
		// Create a Vehicle.
		var createVehicle = {
			name : 'createVehicle',
			url : '/createVehicle',
			templateUrl : '../templates/createVehicle.html',
			controller: 'vehicleController'
		};
		$stateProvider.state(createVehicle);

		// Edit a Customer.													Edit Pages.
		var editCustomer = {
			name : 'editCustomer',
			url : '/editCustomer/{customer}',
			templateUrl : '../templates/editCustomer.html',
			controller: 'editCustomerController',
			resolve: {
				aCustomer: function(customerFactory, $stateParams) {
					return customerFactory.getCustomer($stateParams.customer);
				}
			}
		};
		$stateProvider.state(editCustomer);
		
		// Edit a Pass.
		var editPass = {
			name : 'editPass',
			url : '/editPass/{pass}',
			templateUrl : '../templates/editPass.html',
			controller: 'editPassController',
			resolve: {
				aPass: function(passFactory, $stateParams) {
					return passFactory.getPass($stateParams.pass);
				}
			}
		};
		$stateProvider.state(editPass);
		
		// Edit a Vehicle.
		var editVehicle = {
			name : 'editVehicle',
			url : '/editVehicle/{vehicle}',
			templateUrl : '../templates/editVehicle.html',
			controller: 'editVehicleController',
			resolve: {
				aVehicle: function(vehicleFactory, $stateParams) {
					return vehicleFactory.getVehicle($stateParams.vehicle);
				}
			}
		};
		$stateProvider.state(editVehicle);

	}
})();