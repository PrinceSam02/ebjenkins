package com.example.demo.service;
 
import java.util.List;
 
import com.example.demo.model.Admin;
 
 
 
public interface AdminService {
 
 
		public Admin newAdmin(Admin newAdmin);
 
		public List<Admin> getAdmins();
 
		public Admin adminfind(int adminId);
 
		public List<Integer> getAdminIdList();
 
		public Admin updateAdmin(Admin admin);
 
		public Admin adminLogin(String adminEmail, String adminPassword);
		
		public Admin findByAdminEmail(String adminEmail);
	}