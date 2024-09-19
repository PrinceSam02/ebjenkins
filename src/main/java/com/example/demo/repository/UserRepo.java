package com.example.demo.repository;
 
import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;
 
 
 
public interface UserRepo {
 
	public User newUser(User newUser);
 
	public List<User> getUsers();
 
	public User userfind(int userId);
 
	public List<Integer> getUserIdList();
 
	public User updateUser(User user);
 
	public User UserLogin(String userEmail, String userPassword);
	
	public User findByUserEmail(String userEmail);

	public Optional<User> findbyUserId(int id);
 
//	public User userLogin(String userEmail, String userPassword);
}
 