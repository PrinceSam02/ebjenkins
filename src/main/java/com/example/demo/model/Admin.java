package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String adminEmail;
	
	private String adminName;
	
	private String adminPhoneNumber;
	
	private String adminPassword;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPhoneNumber() {
		return adminPhoneNumber;
	}

	public void setAdminPhoneNumber(String adminPhoneNumber) {
		this.adminPhoneNumber = adminPhoneNumber;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Admin(int id, String adminEmail, String adminName, String adminPhoneNumber, String adminPassword) {
		super();
		this.id = id;
		this.adminEmail = adminEmail;
		this.adminName = adminName;
		this.adminPhoneNumber = adminPhoneNumber;
		this.adminPassword = adminPassword;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", adminEmail=" + adminEmail + ", adminName=" + adminName + ", adminPhoneNumber="
				+ adminPhoneNumber + ", adminPassword=" + adminPassword + "]";
	}
		
}
	
	
	