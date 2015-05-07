'use strict';

/* Services */

var bookcatServices = angular.module('bookcatServices', [ 'ngResource' ]);

bookcatServices.factory('Book', [ '$resource', function($resource) {

	 //return $resource('books/:bookCode.json', {}, { //read from json file for testing
	return $resource('http://localhost:8080/shopcart/store/books/:bookCode', {}, { //invoke REST
		query : {
			method : 'GET',
			params : {
				bookCode : 'books'
			},
			isArray : true
		}

	});
} ]);

// create service to provide a shopping cart that
bookcatApp.factory("Cart", function() {

	// create shopping cart
	var myCart = new shoppingCart("BookStore");

	// return data object with store and cart
	return {
		cart : myCart
	};
});
