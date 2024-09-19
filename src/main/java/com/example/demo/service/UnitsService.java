package com.example.demo.service;

import com.example.demo.model.Units;
import com.example.demo.repository.UnitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitsService {

    @Autowired
    private UnitsRepository unitsRepository;

    public List<Units> getAllUnits() {
        return unitsRepository.findAll();
    }

    public Optional<Units> getUnitById(int id) {
        return unitsRepository.findById(id);
    }

    public Units saveUnit(Units unit) {
        return unitsRepository.save(unit);
    }

    public Units updateUnit(int id, Units unit) {
        if (unitsRepository.existsById(id)) {
            unit.setUnitId(id);
            return unitsRepository.save(unit);
        }
        return null;
    }

    public void deleteUnit(int id) {
        unitsRepository.deleteById(id);
    }

//     Method to get all units by connectionId
//    public List<Units> getUnitsByConnectionId(int id) {
//        return unitsRepository.findByConnection_ConnectionId(id);
//    }
    public List<Units> getUnitsByUserId(int userId) {
        return unitsRepository.findByUser_UserId(userId);
    }
    public Units updateUnitStatus(int id, String status) {
        Optional<Units> optionalUnit = unitsRepository.findById(id);
        if (optionalUnit.isPresent()) {
            Units unit = optionalUnit.get();
            unit.setStatus(status);
            return unitsRepository.save(unit);
        } else {
            return null;
        }
    }
}
