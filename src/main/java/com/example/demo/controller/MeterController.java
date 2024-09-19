package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Connection;
import com.example.demo.model.Meter;
import com.example.demo.service.ConnectionService;
import com.example.demo.service.MeterService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/meters")
public class MeterController {

    @Autowired
    private MeterService meterService;
    @Autowired
    private ConnectionService connectionService;

    // Create a new meter
    @PostMapping("/meterinsert")
    public Meter createMeter(@RequestBody Meter meter) {
        return meterService.saveMeter(meter);
    }

    // Get all meters
    @GetMapping("/all")
    public List<Meter> getAllMeters() {
        return meterService.getAllMeters();
    }

    // Get meter by ID
    @GetMapping("/{id}")
    public ResponseEntity<Meter> getMeterById(@PathVariable int id) {
        Optional<Meter> meter = meterService.getMeterById(id);
        return meter.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/byConnection/{connectionId}")
    public ResponseEntity<List<Meter>> getMetersByConnectionId(@PathVariable int connectionId) {
        List<Meter> meters = meterService.getMetersByConnectionId(connectionId);
        return meters.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(meters);
    }
    // Update meter
    @PutMapping("/{id}")
    public ResponseEntity<Meter> updateMeter(@PathVariable int id, @RequestBody Meter meterDetails) {
        Meter updatedMeter = meterService.updateMeter(id, meterDetails);
        if (updatedMeter != null) {
            return ResponseEntity.ok(updatedMeter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete meter
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeter(@PathVariable int id) {
        meterService.deleteMeter(id);
        return ResponseEntity.noContent().build();
    }
    
}
