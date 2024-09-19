package com.example.demo.repository;

import com.example.demo.model.Deposit;
import com.example.demo.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepo extends JpaRepository<Deposit, Integer> {
	  List<Deposit> findByUser(User user);
	  List<Deposit> findByConnectionId(Integer connectionId);
}
