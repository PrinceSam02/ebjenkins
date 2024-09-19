package com.example.demo.repository;

import com.example.demo.model.Units;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitsRepository extends JpaRepository<Units, Integer> {
    
    // Custom query method to find units by connectionId
//    List<Units> findByConnection_ConnectionId(int connectionId);
    List<Units> findByUser_UserId(int userId);
//    List<Units> findByConnection_ConnectionId(int id);
}

