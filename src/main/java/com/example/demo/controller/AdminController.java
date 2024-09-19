

package com.example.demo.controller;
 
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
 
import com.example.demo.model.Admin;
//import com.example.demo.model.Booking;
import com.example.demo.service.AdminService;
//import com.example.demo.service.BookingService;
//import com.example.demo.service.EmailService;
//import com.example.demo.serviceimpl.EmailServiceImpl;

import jakarta.mail.MessagingException;
 
@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
 
	@Autowired
	AdminService adminservice;
	
	
//	@Autowired
//    private EmailService emailService;
//
//	@Autowired
//	BookingService bookingService;
 
	@PostMapping("/doadmininsert")
	public Admin insertAdmin(@RequestBody Admin newAdmin) {
		return adminservice.newAdmin(newAdmin);
		
	}
 
	@PutMapping("/updateadmin")
	public Admin updateAdmin(@RequestBody Admin admin) {
 
		return adminservice.updateAdmin(admin);
	}
 
	@GetMapping("/getallAdminList")
	public List<Admin> getAdmins() {
		return adminservice.getAdmins();
	}
 
	@GetMapping("/getadminid/{adminId}")
	public Admin appfind(@PathVariable("adminId") int adminId) {
		return adminservice.adminfind(adminId);
	}
 
	@GetMapping("/loginadmin/{adminEmail}/{adminPassword}")
	public boolean loginadmin(@PathVariable("adminEmail") String adminEmail,
			@PathVariable("adminPassword") String adminPassword) {
		Admin existingAdmin = adminservice.findByAdminEmail(adminEmail);
		try {
			if (existingAdmin != null && adminPassword.equals(existingAdmin.getAdminPassword())) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
//	
//	@GetMapping("/bookingPending")
//	public List<Booking> getPendingBooking() {
//		return bookingService.getPendingBooking();
//		 
//	}
	

	
//	@PostMapping("/sendEmail")
//    public ResponseEntity<String> sendEmail(
//            @RequestParam("from") String from,
//            @RequestParam("to") String to,
//            @RequestParam("subject") String subject,
//            @RequestParam("body") String body) {
//        try {
//            emailService.sendSimpleEmail(from, to, subject, body);
//            return ResponseEntity.ok("Email sent successfully");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
//        }
//    }


	
}