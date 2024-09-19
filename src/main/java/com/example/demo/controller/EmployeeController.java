
package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.service.EmailService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    
    @Autowired
    private EmailService emailService;

    // Random password generation logic
    private String generateRandomPassword(int length) {
        String charSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            password.append(charSet.charAt(random.nextInt(charSet.length())));
        }

        return password.toString();
    }

    @PostMapping("/doEmpInsert")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        // Generate a random password
        String randomPassword = generateRandomPassword(6);

        // Set the random password in the employee object
        employee.setPassword(randomPassword);

        // Save the employee
        Employee savedEmployee = employeeService.addEmployee(employee);

        // Send email to the employee
        emailService.sendEmail(savedEmployee.getEmail(), savedEmployee.getRole(), savedEmployee.getPassword());

        // Return the saved employee
        return ResponseEntity.ok(savedEmployee);
    }

    @PostMapping("/login")
    public ResponseEntity<Employee> login(@RequestBody Employee loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        String role = loginRequest.getRole();

        Employee employee = employeeService.login(email, password, role);

        if (employee != null) {
            return ResponseEntity.ok(employee); // Successful login
        } else {
            return ResponseEntity.status(401).build(); // Unauthorized
        }
    }

    
    @PutMapping("/updatePassword/{employeeId}")
    public ResponseEntity<Employee> updatePassword(@PathVariable("employeeId") int eId, @RequestBody Map<String, String> passwordRequest) {
        String newPassword = passwordRequest.get("password");
        Employee updatedEmployee = employeeService.updatePassword(eId, newPassword);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    


    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") int eId) {
        Employee employee = employeeService.getEmployeeById(eId);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/{eid}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("eid") int eId) {
        employeeService.deleteEmployee(eId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/role/{role}")
    public ResponseEntity<List<Employee>> getEmployeesByRole(@PathVariable("role") String role) {
        List<Employee> employees = employeeService.getEmployeesByRole(role);
        return ResponseEntity.ok(employees);
    }
    
//    @PutMapping("/updateStatus/{eid}")
//    public ResponseEntity<Employee> updateStatus(@PathVariable("eid") int eId) {
//        Employee updatedEmployee = employeeService.updateStatus(eId);
//        if (updatedEmployee != null) {
//            return ResponseEntity.ok(updatedEmployee);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
 // Update employee status
    @PutMapping("/updateStatus/{eid}")
    public ResponseEntity<Employee> updateStatus(@PathVariable("eid") int eId, @RequestBody Map<String, String> statusRequest) {
        String newStatus = statusRequest.get("status");
        Employee updatedEmployee = employeeService.updateStatus(eId, newStatus);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/verifyPassword/{employeeId}")
    public ResponseEntity<Map<String, Boolean>> verifyPassword(@PathVariable("employeeId") int eId, @RequestBody Map<String, String> passwordRequest) {
        String password = passwordRequest.get("password");
        boolean isValid = employeeService.verifyPassword(eId, password);
        return ResponseEntity.ok(Map.of("verified", isValid));
    }

}
