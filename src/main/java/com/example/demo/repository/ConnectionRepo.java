package com.example.demo.repository;

import com.example.demo.model.Connection;
import java.util.List;

public interface ConnectionRepo {
    Connection save(Connection connection);
    Connection findById(int id);
    List<Connection> findAll();
    void delete(int id);
    List<Connection> findByStatus(String status); 
    Connection updateStatusAndAssigned(int id, String status, String assignedEmployee); 
    List<Connection> findByUserId(int userId);
    Connection updateStatus(int id, String status); 
}
