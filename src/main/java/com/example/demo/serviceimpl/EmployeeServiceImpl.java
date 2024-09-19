
package com.example.demo.serviceimpl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.service.EmployeeService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(int eId) {
        return employeeRepository.findById(eId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(int eId) {
        employeeRepository.delete(eId);
    }

    @Override
    public Employee login(String email, String password, String role) {
        Employee employee = employeeRepository.findByEmailAndPassword(email, password);
        if (employee != null && employee.getRole().equals(role)) {
            return employee; // Return only if role matches
        }
        return null; // Unauthorized
    }

    @Override
    public Employee updatePassword(int eId, String newPassword) {
        Employee employee = employeeRepository.findById(eId);
        if (employee != null) {
            employee.setPassword(newPassword);
            return employeeRepository.save(employee); // Update password and save
        }
        return null; // Not found
    }
    @Override
    public List<Employee> getEmployeesByRole(String role) {
        return employeeRepository.findByRole(role);
    } 
//    @Override
//    public Employee updateStatus(int eId) {
//        Employee employee = employeeRepository.findById(eId);
//        if (employee != null) {
//            employee.setStatus("On Work");
//            return employeeRepository.save(employee); // Update status and save
//        }
//        return null; // Employee not found
//    }
    @Override
    public Employee updateStatus(int eId, String newStatus) {
        Employee employee = employeeRepository.findById(eId);
        if (employee != null) {
            employee.setStatus(newStatus);
            return employeeRepository.save(employee); // Update status and save
        }
        return null; // Employee not found
    }

    @Override
    public boolean verifyPassword(int eId, String password) {
        Employee employee = employeeRepository.findById(eId);
        return employee != null && employee.getPassword().equals(password);
    }
}

