package com.user.service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.Entities.User;
import com.user.service.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//create
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User u = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(u);
	}
	
	//get All
	@GetMapping
	public ResponseEntity<List<User>> getAll()
	{
		List<User> l=userService.getAllUsers();
		return ResponseEntity.ok(l);
	}
	
	//single user get
	@GetMapping("/{id}")
	public ResponseEntity<User> getSingleUser(@PathVariable String id)
	{
		User u=userService.getUser(id);
		return ResponseEntity.ok(u);
	}
}
