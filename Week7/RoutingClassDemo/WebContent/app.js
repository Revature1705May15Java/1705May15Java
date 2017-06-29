/**
 * 
 */

var app = angular.module('routingApp',['ngRoute']);

app.config(function($routeProvider){
	$routeProvider
	
	.when('/',{
		templateUrl :'views/home.html'
	})
	
	.when('/about',{
		templateUrl:'views/about.html',
		controller:'demoCtrl'
	})
	
	.when('/contact',{
		templateUrl:'views/contact.html'
	})
	
	.otherwise({
		redirectTo : '/'
	});
})