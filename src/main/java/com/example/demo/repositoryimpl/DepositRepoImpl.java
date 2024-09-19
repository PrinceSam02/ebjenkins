package com.example.demo.repositoryimpl;
//
//import com.example.demo.model.Deposit;
//import com.example.demo.repository.DepositRepo;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
public class DepositRepoImpl  {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public Deposit save(Deposit deposit) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.saveOrUpdate(deposit);
//        transaction.commit();
//        session.close();
//        return deposit;
//    }
//
//    @Override
//    public Deposit findById(int dpId) {
//        Session session = sessionFactory.openSession();
//        Deposit deposit = session.get(Deposit.class, dpId);
//        session.close();
//        return deposit;
//    }
//
//    @Override
//    public List<Deposit> findAll() {
//        Session session = sessionFactory.openSession();
//        List<Deposit> deposits = session.createQuery("from Deposit", Deposit.class).list();
//        session.close();
//        return deposits;
//    }
//
//    @Override
//    public void delete(int dpId) {
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        Deposit deposit = session.get(Deposit.class, dpId);
//        if (deposit != null) {
//            session.delete(deposit);
//        }
//        transaction.commit();
//        session.close();
//    }
}
