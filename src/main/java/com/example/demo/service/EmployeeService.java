
package com.example.demo.service;

import com.example.demo.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    Employee getEmployeeById(int eId);
    List<Employee> getAllEmployees();
    void deleteEmployee(int eId);
    Employee login(String email, String password, String role); // Modify to check role as well
    Employee updatePassword(int eId, String newPassword); // New method for password update
    List<Employee> getEmployeesByRole(String role);    
//    Employee updateStatus(int eId);
 // Update employee status
    Employee updateStatus(int eId, String newStatus);

    boolean verifyPassword(int eId, String password);

}
