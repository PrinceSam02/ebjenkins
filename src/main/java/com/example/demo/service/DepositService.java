package com.example.demo.service;

import com.example.demo.model.Deposit;
import com.example.demo.model.User;
import com.example.demo.repository.DepositRepo;
import com.example.demo.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositService {

    @Autowired
    private DepositRepo depositRepository;
    

    @Autowired
    private UserRepo userRepository;

    public Deposit saveDeposit(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    public List<Deposit> getAllDeposits() {
        return depositRepository.findAll();
    }

    public Optional<Deposit> getDepositById(int id) {
        return depositRepository.findById(id);
    }

    public Deposit updateDeposit(int id, Deposit deposit) {
        if (depositRepository.existsById(id)) {
            deposit.setDpId(id);
            return depositRepository.save(deposit);
        }
        return null;
    }

    public void deleteDeposit(int id) {
        depositRepository.deleteById(id);
    }

    public List<Deposit> getDepositsByUserId(Integer userId) {
        Optional<User> user = userRepository.findbyUserId(userId); // Fetch User by userId
        return user.map(depositRepository::findByUser).orElseGet(List::of); // Fetch deposits by User
    }
    // New method to get deposits by connectionId
    public List<Deposit> getDepositsByConnectionId(Integer connectionId) {
        return depositRepository.findByConnectionId(connectionId);
    }
}
