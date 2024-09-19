package com.example.demo.service;

import com.example.demo.model.Connection;
import java.util.List;

public interface ConnectionService {
    Connection createConnection(Connection connection);
    Connection getConnectionById(int id);
    List<Connection> getAllConnections();
    void deleteConnection(int id);
    List<Connection> getConnectionsByStatus(String status); // Method to get connections by status
    Connection updateConnectionStatus(int id, String status);
    
    Connection updateConnectionStatusAndAssigned(int id, String status, String assignedEmployee);
    List<Connection> getConnectionsByUserId(int userId);

}
