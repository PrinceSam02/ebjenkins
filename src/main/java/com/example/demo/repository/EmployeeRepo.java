
package com.example.demo.repository;

import com.example.demo.model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepo {
    Employee save(Employee employee);
    Employee findById(int eId);
    List<Employee> findAll();
    void delete(int eId);
    Employee findByEmailAndPassword(String email, String password); // Add role check in service layer
    List<Employee> findByRole(String role);
    
}
