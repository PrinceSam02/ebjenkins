package com.example.demo.serviceimpl;

import com.example.demo.model.Connection;
import com.example.demo.repository.ConnectionRepo;
import com.example.demo.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Autowired
    private ConnectionRepo connectionRepository;

    @Override
    public Connection createConnection(Connection connection) {
        return connectionRepository.save(connection);
    }

    @Override
    public Connection getConnectionById(int id) {
        return connectionRepository.findById(id);
    }

    @Override
    public List<Connection> getAllConnections() {
        return connectionRepository.findAll();
    }

    @Override
    public void deleteConnection(int id) {
        connectionRepository.delete(id);
    }

    @Override
    public List<Connection> getConnectionsByStatus(String status) {
        return connectionRepository.findByStatus(status);
    }

    @Override
    public Connection updateConnectionStatusAndAssigned(int id, String status, String assignedEmployee) {
        return connectionRepository.updateStatusAndAssigned(id, status, assignedEmployee);
    }
    @Override
    public Connection updateConnectionStatus(int id, String status) {
        return connectionRepository.updateStatus(id, status);
    }
    @Override
    public List<Connection> getConnectionsByUserId(int userId) {
        return connectionRepository.findByUserId(userId);
    }
}
