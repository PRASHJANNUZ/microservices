package com.user.service.Services;

import java.util.List;

import com.user.service.Entities.User;

public interface UserService {

	//create
	User saveUser(User user);
	
	//get all users
	List<User> getAllUsers();
	
	//get single user
	User getUser(String userid);
}
