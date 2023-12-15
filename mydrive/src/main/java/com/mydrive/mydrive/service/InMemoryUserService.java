package com.mydrive.mydrive.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mydrive.mydrive.exception.UserNotFoundException;
import com.mydrive.mydrive.model.User;

@Service
public class InMemoryUserService implements UserService {

	private static Map<Integer,User> users = new HashMap<>();
	
	@Override
	public User createUser(User user) {
		User usr = new User(users.size()+1,user.getName() ,user.getEmail());
		users.put(usr.getId(), usr);
		return usr;
	}

	@Override
	public Optional<com.mydrive.mydrive.model.User> getUser(Integer id) {
		
		User user = users.get(id);
		if (user == null) {
			throw new UserNotFoundException(" User not found for ID :" + id);
		}
		
		return Optional.of(user);
	}

	@Override
	public Optional<List<com.mydrive.mydrive.model.User>> retriveUsers() {
		// TODO Auto-generated method stub
		return Optional.of(new ArrayList<>(users.values()));
	}

}
