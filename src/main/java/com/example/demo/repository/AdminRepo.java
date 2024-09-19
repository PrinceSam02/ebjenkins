package com.example.demo.repository;
 
import java.util.List;
 
import com.example.demo.model.Admin;
 
 
 
public interface AdminRepo {
 
	public Admin newAdmin(Admin newAdmin);
 
	public List<Admin> getAdmins();
 
	public Admin adminfind(int adminId);
 
	public List<Integer> getAdminIdList();
 
	public Admin updateAdmin(Admin admin);
 
	public Admin AdminLogin(String adminEmail, String adminPassword);
	
	public Admin findByAdminEmail(String adminEmail);
 
//	public Admin adminLogin(String adminEmail, String adminPassword);
}
 