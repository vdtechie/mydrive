package com.mydrive.mydrive.service;

import java.util.List;
import java.util.Optional;

import com.mydrive.mydrive.model.User;

public interface UserService {
	
	public Optional<User> getUser(Integer id);
	
	public Optional<List<User>> retriveUsers();

	User createUser(User user);

}
