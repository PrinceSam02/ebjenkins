//package com.example.demo.serviceimpl;
//
//import com.example.demo.model.Deposit;
//import com.example.demo.repository.DepositRepo;
//import com.example.demo.service.DepositService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class DepositServiceImpl implements DepositService {
//
//    @Autowired
//    private DepositRepo depositRepository;
//
//    @Override
//    public Deposit createDeposit(Deposit deposit) {
//        return depositRepository.save(deposit);
//    }
//
//    @Override
//    public Deposit getDepositById(int dpId) {
//        return depositRepository.findById(dpId);
//    }
//
//    @Override
//    public List<Deposit> getAllDeposits() {
//        return depositRepository.findAll();
//    }
//
//    @Override
//    public void deleteDeposit(int dpId) {
//        depositRepository.delete(dpId);
//    }
//}
