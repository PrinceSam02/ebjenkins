package com.example.demo.model;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "connections")
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fullName;
    private String age;
    private String gender;
    private String phoneNumber;
    private String email;
    private String residentialAddress;
    private String identityNumber;
    private String propertyType;
    private String connectionType;
    
    private String status; // Added field for status
    private String assignedEmployee; // Added field for assigned employee


    @ManyToOne
    private User user; // Mapping to the User table


    @OneToOne
    private Employee employee;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getResidentialAddress() {
		return residentialAddress;
	}


	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}


	public String getIdentityNumber() {
		return identityNumber;
	}


	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}


	public String getPropertyType() {
		return propertyType;
	}


	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}


	public String getConnectionType() {
		return connectionType;
	}


	public void setConnectionType(String connectionType) {
		this.connectionType = connectionType;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getAssignedEmployee() {
		return assignedEmployee;
	}


	public void setAssignedEmployee(String assignedEmployee) {
		this.assignedEmployee = assignedEmployee;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Connection(int id, String fullName, String age, String gender, String phoneNumber, String email,
			String residentialAddress, String identityNumber, String propertyType, String connectionType, String status,
			String assignedEmployee, User user, Employee employee) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.residentialAddress = residentialAddress;
		this.identityNumber = identityNumber;
		this.propertyType = propertyType;
		this.connectionType = connectionType;
		this.status = status;
		this.assignedEmployee = assignedEmployee;
		this.user = user;
		this.employee = employee;
	}


	public Connection() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Connection [id=" + id + ", fullName=" + fullName + ", age=" + age + ", gender=" + gender
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", residentialAddress=" + residentialAddress
				+ ", identityNumber=" + identityNumber + ", propertyType=" + propertyType + ", connectionType="
				+ connectionType + ", status=" + status + ", assignedEmployee=" + assignedEmployee + ", user=" + user
				+ ", employee=" + employee + "]";
	}
    
    
    
	    
}