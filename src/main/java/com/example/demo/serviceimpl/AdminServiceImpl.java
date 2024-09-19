package com.example.demo.serviceimpl;
 
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepo;
import com.example.demo.service.AdminService;
 
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
 
	@Autowired
	AdminRepo admindao;
 
	@Override
	public Admin newAdmin(Admin newAdmin) {
		return admindao.newAdmin(newAdmin);
	}
 
	@Override
	public List<Admin> getAdmins() {
 
		return admindao.getAdmins();
 
	}
 
	@Override
	public Admin adminfind(int adminId) {
		return admindao.adminfind(adminId);
	}
 
	@Override
	public List<Integer> getAdminIdList() {
		return admindao.getAdminIdList();
	}
 
	@Override
	public Admin updateAdmin(Admin admin) {
		return admindao.updateAdmin(admin);
	}
 
	
	public Admin adminLogin(String adminEmail, String adminPassword) {
		return admindao.AdminLogin(adminEmail, adminPassword);
	}
 
	@Override
	public Admin findByAdminEmail(String adminEmail) {
		return admindao.findByAdminEmail(adminEmail);
	}
}