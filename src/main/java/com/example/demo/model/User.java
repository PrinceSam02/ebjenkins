package com.example.demo.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name= "users")
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int userId;

	    private String userEmail;
	    private String userName;
	    private String userPhoneNumber;
	    private String userPassword;
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserPhoneNumber() {
			return userPhoneNumber;
		}
		public void setUserPhoneNumber(String userPhoneNumber) {
			this.userPhoneNumber = userPhoneNumber;
		}
		public String getUserPassword() {
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		public User(int userId, String userEmail, String userName, String userPhoneNumber, String userPassword) {
			super();
			this.userId = userId;
			this.userEmail = userEmail;
			this.userName = userName;
			this.userPhoneNumber = userPhoneNumber;
			this.userPassword = userPassword;
		}
		public User() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "User [userId=" + userId + ", userEmail=" + userEmail + ", userName=" + userName
					+ ", userPhoneNumber=" + userPhoneNumber + ", userPassword=" + userPassword + "]";
		}
		
	
}
