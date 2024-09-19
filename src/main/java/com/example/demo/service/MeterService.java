package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Meter;
import com.example.demo.repository.MeterRepository;

@Service
public class MeterService {

    @Autowired
    private MeterRepository meterRepository;

    // Save a new meter
    public Meter saveMeter(Meter meter) {
        return meterRepository.save(meter);
    }

    // Get all meters
    public List<Meter> getAllMeters() {
        return meterRepository.findAll();
    }

    // Get meter by ID
    public Optional<Meter> getMeterById(int id) {
        return meterRepository.findById(id);
    }

    // Update a meter
    public Meter updateMeter(int id, Meter meterDetails) {
        Optional<Meter> optionalMeter = meterRepository.findById(id);
        if (optionalMeter.isPresent()) {
            Meter meter = optionalMeter.get();
            meter.setMeterNumber(meterDetails.getMeterNumber());
            meter.setDepositAmount(meterDetails.getDepositAmount());
            meter.setConnection(meterDetails.getConnection());
            return meterRepository.save(meter);
        }
        return null; // Handle this case in your controller
    }

    // Delete a meter
    public void deleteMeter(int id) {
        meterRepository.deleteById(id);
    }
 // Method to find meters by connectionId
    public List<Meter> getMetersByConnectionId(int connectionId) {
        return meterRepository.findByConnectionId(connectionId);
    }

    public Meter getMeterByNumber(String meterNumber) {
        return meterRepository.findByMeterNumber(meterNumber);
    }
}
	