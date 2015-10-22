var app = angular.module('myApp', ['ngRoute', 'ngFileUpload', 'ui.bootstrap']);

app.config(function($routeProvider) {
	
	$routeProvider
    	
        .when('/homepage', {
        	controller: 'signUpController',
            templateUrl: 'html/homepage.html'
            
            	
        })
               
        .when('/details/:userId', {
        	 templateUrl: 'html/details.html',
             controller: 'detailsController'
            	
        })
        
        .when('/admin', {
        	controller: 'adminController',
            templateUrl: 'html/admin.html'
            
            	
        })
        
        .when('/editUser/:id', {
        	controller: 'adminEditController',
            templateUrl: 'html/editUser.html'
            
            	
        })
        
         .when('/showdetailsforuser/:userId', 	
        		{
        	 		templateUrl: 'html/showDetails.html',
        	 		controller: 'viewDetailsController'
            	
        		})
        
        .when('/userwelcome/:id', 	
        		{
        	 		templateUrl: 'html/userwelcome.html',
        	 		controller: 'welcomeController'
            	
        		})
       
        .otherwise({
            redirectTo: '/homepage'
            	
        });
	
});
