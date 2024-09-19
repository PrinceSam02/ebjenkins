package com.example.demo.controller;

import com.example.demo.model.Deposit;
import com.example.demo.model.Meter;
import com.example.demo.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/deposits")
public class DepositController {

    @Autowired
    private DepositService depositService;

    @PostMapping("/insert")
    public ResponseEntity<Deposit> createDeposit(@RequestBody Deposit deposit) {
        Deposit savedDeposit = depositService.saveDeposit(deposit);
        return ResponseEntity.ok(savedDeposit);
    }

    @GetMapping
    public ResponseEntity<List<Deposit>> getAllDeposits() {
        List<Deposit> deposits = depositService.getAllDeposits();
        return ResponseEntity.ok(deposits);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deposit> getDepositById(@PathVariable int id) {
        Optional<Deposit> deposit = depositService.getDepositById(id);
        return deposit.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Deposit> updateDeposit(@PathVariable int id, @RequestBody Deposit deposit) {
        Deposit updatedDeposit = depositService.updateDeposit(id, deposit);
        return updatedDeposit != null ? ResponseEntity.ok(updatedDeposit) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeposit(@PathVariable int id) {
        depositService.deleteDeposit(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Deposit>> getDepositsByUserId(@PathVariable Integer userId) {
        List<Deposit> deposits = depositService.getDepositsByUserId(userId);
        return ResponseEntity.ok(deposits);
    }    
    @GetMapping("/connection/{connectionId}")
    public ResponseEntity<List<Deposit>> getDepositsByConnectionId(@PathVariable Integer connectionId) {
        List<Deposit> deposits = depositService.getDepositsByConnectionId(connectionId);
        return ResponseEntity.ok(deposits);
    }
}
