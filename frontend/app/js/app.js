'use strict';

/* App Module */

var bookcatApp = angular.module('bookcatApp', [ 'ngRoute',
		'bookcatControllers', 'bookcatFilters', 'bookcatServices' ]);

bookcatApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/books', {
		templateUrl : 'partials/book-list.html',
		controller : 'BookListCtrl'
	}).when('/books/:bookCode', {
		templateUrl : 'partials/book-detail.html',
		controller : 'BookDetailCtrl'
	}).when('/cart', {
		templateUrl : 'partials/shoppingCart.html',
		controller : 'CartCtrl'
	}).when('/order', {
		templateUrl : 'partials/order.html',
		controller : 'OrderCtrl'
	}).otherwise({
		redirectTo : '/books',
		controller : 'BookListCtrl'
	});
} ]);