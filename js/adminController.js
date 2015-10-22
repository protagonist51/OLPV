app.controller('adminController',[ '$scope', '$http', '$location', '$routeParams', '$rootScope', '$log', function($scope, $http, $location, $routeParams, $rootScope, $log) {
	$scope.userId=$rootScope.userId;
	
	$http.get('getAlldetails').success(function(response)
    	 	{
				$scope.data = response;
				
				  $scope.totalItems = response.length;
				  $scope.currentPage = 1;
				  $scope.itemsPerPage = 10;
				  
				  $scope.setPage = function (page) {
				      $scope.currentPage = page;
				    };
				  
				 console.log($scope.currentPage);				
    	 	}).error(function(error)
                    {
                alert(error);
            });
	
	 
	  
	  
	
	
	$scope.editUser = function(id)
	{
		
		$location.url('/editUser/'+ id);
	}
	
	
	$scope.Logout = function()
	{
		alert($scope.userId);
		$http.post('logout', $scope.userId ).success(function(response)	
				{
		$location.url('/homepage');
		});


	}

	
}]);
