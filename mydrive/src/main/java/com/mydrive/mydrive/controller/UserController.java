package com.mydrive.mydrive.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mydrive.mydrive.exception.UserNotFoundException;
import com.mydrive.mydrive.model.User;
import com.mydrive.mydrive.service.UserService;

@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public ResponseEntity<Object> retriveAllUsers() {
		return new ResponseEntity<Object>(userService.retriveUsers().get(), HttpStatus.OK);
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Object> getUser(@PathVariable int id) {
		
		
		return new ResponseEntity<Object>(userService.getUser(id).get(), HttpStatus.OK);
	}

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}
	
	@ExceptionHandler(UserNotFoundException.class) 
	public ResponseEntity<String> handleException (Exception exp) {
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.NOT_FOUND) ;
	}
	

}
