package com.example.demo.controller;

import com.example.demo.model.Units;
import com.example.demo.service.UnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/units")
public class UnitsController {

    @Autowired
    private UnitsService unitsService;

    @GetMapping("/all")
    public ResponseEntity<List<Units>> getAllUnits() {
        List<Units> units = unitsService.getAllUnits();
        return new ResponseEntity<>(units, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Units> getUnitById(@PathVariable int id) {
        Optional<Units> unit = unitsService.getUnitById(id);
        if (unit.isPresent()) {
            return new ResponseEntity<>(unit.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Units> createUnit(@RequestBody Units unit) {
        Units savedUnit = unitsService.saveUnit(unit);
        return new ResponseEntity<>(savedUnit, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Units> updateUnit(@PathVariable int id, @RequestBody Units unit) {
        Units updatedUnit = unitsService.updateUnit(id, unit);
        if (updatedUnit != null) {
            return new ResponseEntity<>(updatedUnit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable int id) {
        unitsService.deleteUnit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
    @GetMapping("/user/{userId}")
    public List<Units> getUnitsByUserId(@PathVariable int userId) {
        return unitsService.getUnitsByUserId(userId);
    }
    @PatchMapping("/{id}/status")
    public ResponseEntity<Units> updateUnitStatus(@PathVariable int id, @RequestBody String status) {
        Units updatedUnit = unitsService.updateUnitStatus(id, status);
        if (updatedUnit != null) {
            return new ResponseEntity<>(updatedUnit, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    @GetMapping("/connection/{connectionId}")
//    public List<Units> getUnitsByConnectionId(@PathVariable int id) {
//        return unitsService.getUnitsByConnectionId(id);
//    }

}
