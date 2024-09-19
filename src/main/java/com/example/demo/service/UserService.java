package com.example.demo.service;
 
import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;
 
 
 
public interface UserService {
 
 
		public User newUser(User newUser);
 
		public List<User> getUsers();
 
		public User userfind(int userId);
 
		public List<Integer> getUserIdList();
 
		public User updateUser(User user);
 
		public User userLogin(String userEmail, String userPassword);
		
		public User findByUserEmail(String userEmail);

		public Optional<User> getUserById(int id);
	}