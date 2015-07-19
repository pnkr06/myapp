/**
 * Created by naveenpurmani on 07/19/2015.
 */

var app = angular.module('shipapp', ['xeditable',
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngRoute'    
]);

app.config(function ($routeProvider) {
    $routeProvider.when('/', {
        templateUrl: 'views/dashboard.html',
        controller: 'DashboardCtrl'
    }).when('/list', {
        templateUrl: 'views/list.html',
        controller: 'ListCtrl'
    }).when('/logistics', {
        templateUrl: 'views/logistics.html',
        controller: 'LogisticsCtrl'
    }).when('/create', {
        templateUrl: 'views/create.html',
        controller: 'CreateCtrl'
    }).when('/priority', {
        templateUrl: 'views/priority.html',
        controller: 'CreateCtrl'
    }).when('/track', {
        templateUrl: 'views/logistics.html',
        controller: 'LogisticsCtrl'
    }).otherwise({
        redirectTo: '/'
    })
});

app.controller('DashboardCtrl', function ($scope, $http, $location) {
    $http.get('/api/v2/todosi')
    .success(function (data) {
    	$scope.todosi= data;
 
        
    }).error(function (data, status) {
        console.log('Error ' + data)
    })
});
    
app.controller('ListCtrl', function ($scope, $http, $location) {
    $http.get('/api/v1/todos')
    .success(function (data) {
        $scope.todos = data;
        
    }).error(function (data, status) {
        console.log('Error ' + data)
    })

    $scope.todoStatusChanged = function (todo) {
        console.log(todo);
         
        $http.put('/api/v1/todos/' + todo.id, todo)
        .success(function (data) {
           console.log('status changed');
        }).error(function (data, status) {
            console.log('Error ' + data)
        })
    }
    
    $scope.deleteTodo = function(todo) {
    	console.log(todo);
    	
    	$http.put('/api/v1/todo/'+ todo.id, todo)
    	.success(function (data) {
    		console.log('todo deleted');
    		$location.path('/#');
    	}).error(function (data, status) {
    		console.log('Error' + data)
    	})
    }
    
    $scope.editTodo = function (todo) {
        
        console.log(todo);
        
        $http.put('/api/v1/todos/' + todo.id, todo).success(function (data) {
        	
            console.log('title changed');
        }).error(function (data, status) {
            console.log('Error ' + data)
        })
    }
      

});

app.controller('CreateCtrl', function ($scope, $http, $location) {
   

    $scope.createAsn = function () {
        $http.post('/api/v1/todos', $scope.todo).success(function (data) {
             $location.path('/list');
        }).error(function (data, status) {
            console.log('Error ' + data)
        })
    }
    
    $scope.createPrt = function () {
        console.log($scope.todo);
        $http.post('/api/v2/todosi', $scope.todo).success(function (data) {
             $location.path('/');
        }).error(function (data, status) {
            console.log('Error ' + data)
        })
    }
    
});



app.run(function(editableOptions) {
	  editableOptions.theme = 'bs3';
	});
     
