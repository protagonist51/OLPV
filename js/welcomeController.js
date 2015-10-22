app.controller('welcomeController',[ '$scope', '$http', '$location', '$routeParams',  function($scope, $http, $location, $routeParams)
                                     
 {
		
		$scope.id = $routeParams.id;
		
		$http.post('recordforid', $scope.id ).success(function(response)
		{
			
			$scope.res=response;
		});
		
	 
		$scope.Logout = function ()
		{
			alert ("logout");
		// Session.clear();
		$location.url('/homepage');
		}
		
		 $http.post('viewDoc', $scope.id).success(function(re){
	     	 
	     	 $scope.doc = re.docPath;
	     	  
	       }).error(function(error)
	               {
	           alert(error);
	       });
	
}]);
