package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;

	@PostMapping("/douserinsert")
	public User insertUser(@RequestBody User newUser) {
		return userservice.newUser(newUser);

	}

	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user) {

		return userservice.updateUser(user);
	}

	@GetMapping("/getallUserList")
	public List<User> getUsers() {
		return userservice.getUsers();
	}

	@GetMapping("/getuserid/{userId}")
	public User userfind(@PathVariable("userId") int userId) {
		return userservice.userfind(userId);
	}

	@PostMapping("/loginuser")
	public User loginuser(@RequestParam("userEmail") String userEmail,
			@RequestParam("userPassword") String userPassword) {
		User existingUser = userservice.findByUserEmail(userEmail);
		try {
			if (existingUser != null && userPassword.equals(existingUser.getUserPassword())) {
				return existingUser;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
}