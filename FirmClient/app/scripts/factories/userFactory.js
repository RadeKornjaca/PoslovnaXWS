'use strict';

angular.module('resource.user', [])
	.factory('User', function ($log) {
	
	var setUser = function(user) {
		this.user = user;
		$log.info(user);
	};
	
	var getUser = function() {
		return user;
	};
	
	var setAdmin = function(isAdmin) {
		this.admin = isAdmin;
	};
	
	var getAdmin = function() {
		return admin;
	};
	
	return {
		user : getUser,
		setUser : setUser,
		admin : getAdmin,
		setAdmin : setAdmin
	};
});
