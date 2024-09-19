package com.example.demo.serviceimpl;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
import com.example.demo.service.UserService;
 
@Service
@Transactional
public class UserServiceImpl implements UserService {
 
	@Autowired
	UserRepo userdao;
 
	@Override
	public User newUser(User newUser) {
		return userdao.newUser(newUser);
	}
 
	@Override
	public List<User> getUsers() {
 
		return userdao.getUsers();
 
	}
 
	@Override
	public User userfind(int userId) {
		return userdao.userfind(userId);
	}
 
	@Override
	public List<Integer> getUserIdList() {
		return userdao.getUserIdList();
	}
 
	@Override
	public User updateUser(User user) {
		return userdao.updateUser(user);
	}
 
	
	public User userLogin(String userEmail, String userPassword) {
		return userdao.UserLogin(userEmail, userPassword);
	}
 
	@Override
	public User findByUserEmail(String userEmail) {
		return userdao.findByUserEmail(userEmail);
	}

	@Override
	public Optional<User> getUserById(int id) {
	
		return userdao.findbyUserId(id);
	}
}