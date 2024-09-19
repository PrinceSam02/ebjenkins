package com.example.demo.controller;

import com.example.demo.model.Connection;
import com.example.demo.model.Meter;
import com.example.demo.service.ConnectionService;
import com.example.demo.service.EmailService;
import com.example.demo.service.MeterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin("*")
@RequestMapping("/api/connections")
public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;

    @PostMapping("/doInsert")
    public Connection createConnection(@RequestBody Connection connection) {
        return connectionService.createConnection(connection);
    }

    @GetMapping("/{id}")
    public Connection getConnectionById(@PathVariable int id) {
        return connectionService.getConnectionById(id);
    }

    @GetMapping("/all")
    public List<Connection> getAllConnections() {
        return connectionService.getAllConnections();
    }

    @DeleteMapping("/{id}")
    public void deleteConnection(@PathVariable int id) {
        connectionService.deleteConnection(id);
    }
    @GetMapping("/status/{status}")
    public List<Connection> getConnectionsByStatus(@PathVariable String status) {
        return connectionService.getConnectionsByStatus(status);
    }
    @PutMapping("/updateStatusAndAssigned/{id}")
    public Connection updateConnectionStatusAndAssigned(@PathVariable int id, @RequestBody Connection connection) {
        return connectionService.updateConnectionStatusAndAssigned(id, connection.getStatus(), connection.getAssignedEmployee());
    }
    @PutMapping("/updateStatus/{id}")
    public Connection updateConnectionStatus(@PathVariable int id, @RequestBody Connection connection) {
        return connectionService.updateConnectionStatus(id, connection.getStatus());
    }
    @Autowired
    private MeterService meterService; // To fetch meter details

    @Autowired
    private EmailService mailService; // For sending emails

    @PutMapping("/requestDeposit/{connectionId}")
    public ResponseEntity<String> requestDeposit(@PathVariable int connectionId) {
        // Fetch connection details
        Connection connection = connectionService.getConnectionById(connectionId);
        if (connection == null) {
            return ResponseEntity.notFound().build();
        }

        String customerName = connection.getFullName();
        String customerEmail = connection.getEmail();

        // Fetch meter details
        List<Meter> meters = meterService.getMetersByConnectionId(connectionId);
        if (meters.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Meter meter = meters.get(0); // Assuming there's one meter per connection
        String meterNumber = meter.getMeterNumber();
        String depositAmount = meter.getDepositAmount(); // Assuming depositAmount is a field in Meter

        // Send email
        mailService.sendDepositRequestEmail(customerEmail, customerName, meterNumber, depositAmount);

        return ResponseEntity.ok("Deposit request email sent successfully.");
    }
    @GetMapping("/user/{userId}")
    public List<Connection> getConnectionsByUserId(@PathVariable int userId) {
        return connectionService.getConnectionsByUserId(userId);
    }
}
