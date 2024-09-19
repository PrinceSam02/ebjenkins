package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Meter;

public interface MeterRepository extends JpaRepository<Meter, Integer> {
    // You can add custom queries if needed.
	 List<Meter> findByConnectionId(int connectionId);
	 Meter findByMeterNumber(String meterNumber);
}
