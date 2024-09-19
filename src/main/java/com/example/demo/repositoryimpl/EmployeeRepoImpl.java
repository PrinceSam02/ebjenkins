package com.example.demo.repositoryimpl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee save(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(employee);
        transaction.commit();
        session.close();
        return employee;
    }

    @Override
    public Employee findById(int eId) {
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, eId);
        session.close();
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
        session.close();
        return employees;
    }

    @Override
    public void delete(int eId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = session.get(Employee.class, eId);
        if (employee != null) {
            session.delete(employee);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public Employee findByEmailAndPassword(String email, String password) {
        Session session = sessionFactory.openSession();
        Employee employee = session.createQuery("from Employee where email = :email and password = :password", Employee.class)
                                   .setParameter("email", email)
                                   .setParameter("password", password)
                                   .uniqueResult();
        session.close();
        return employee;
    }
    
    @Override
    public List<Employee> findByRole(String role) {
        Session session = sessionFactory.openSession();
        List<Employee> employees = session.createQuery("from Employee where role = :role", Employee.class)
                                          .setParameter("role", role)
                                          .list();
        session.close();
        return employees;
    }

	

}