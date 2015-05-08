'use strict';

/* Controllers */

var bookcatControllers = angular.module('bookcatControllers', []);

bookcatControllers.controller('BookListCtrl', [ '$scope', 'Book', 'Cart',
		function($scope, Book, Cart) {
			$scope.books = Book.query();
			$scope.orderProp = 'name';
			$scope.cart = Cart.cart;
			if (Cart.cart.submitted == true) {
				$scope.cart.items = {};
				$scope.cart.submitted = false;
			}
		} ]);

bookcatControllers.controller('BookDetailCtrl', [ '$scope', '$routeParams',
		'Book', 'Cart', function($scope, $routeParams, Book, Cart) {
			$scope.book = Book.get({
				bookCode : $routeParams.bookCode
			}, function(Book) {
				// add some callback function here
			});

			$scope.cart = Cart.cart;
		} ]);

bookcatControllers.controller('CartCtrl', [ '$scope', '$location', 'Cart',
		function($scope, $location, Cart) {
			$scope.cart = Cart.cart;
		} ]);

bookcatControllers.controller('OrderCtrl', [ '$scope', 'Cart',
		function($scope, Cart) {
			$scope.cart = Cart.cart;
			$scope.savedCart = angular.copy(Cart.cart);
			$scope.cart.items = [];
		} ]);
