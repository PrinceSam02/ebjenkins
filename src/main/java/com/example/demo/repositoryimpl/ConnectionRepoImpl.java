package com.example.demo.repositoryimpl;

import com.example.demo.model.Connection;
import com.example.demo.repository.ConnectionRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConnectionRepoImpl implements ConnectionRepo{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Connection save(Connection connection) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(connection);
        transaction.commit();
        session.close();
        return connection;
    }

    @Override
    public Connection findById(int id) {
        Session session = sessionFactory.openSession();
        Connection connection = session.get(Connection.class, id);
        session.close();
        return connection;
    }

    @Override
    public List<Connection> findAll() {
        Session session = sessionFactory.openSession();
        List<Connection> connections = session.createQuery("from Connection", Connection.class).list();
        session.close();
        return connections;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Connection connection = session.get(Connection.class, id);
        if (connection != null) {
            session.delete(connection);
        }
        transaction.commit();
        session.close();
    }
    
    @Override
    public List<Connection> findByStatus(String status) {
        Session session = sessionFactory.openSession();
        List<Connection> connections = session.createQuery("from Connection where status = :status", Connection.class)
                                              .setParameter("status", status)
                                              .list();
        session.close();
        return connections;
    }
    
   
    @Override
    public Connection updateStatusAndAssigned(int id, String status, String assignedEmployee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Connection connection = session.get(Connection.class, id);
        if (connection != null) {
            connection.setStatus(status);
            connection.setAssignedEmployee(assignedEmployee);
            session.update(connection);
        }
        transaction.commit();
        session.close();
        return connection;
    }
    @Override
    public Connection updateStatus(int id, String status) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Connection connection = session.get(Connection.class, id);
        if (connection != null) {
            connection.setStatus(status);
           
            session.update(connection);
        }
        transaction.commit();
        session.close();
        return connection;
    }
    @Override
    public List<Connection> findByUserId(int userId) {
        Session session = sessionFactory.openSession();
        List<Connection> connections = session.createQuery("from Connection where user.id = :userId", Connection.class)
                                              .setParameter("userId", userId)
                                              .list();
        session.close();
        return connections;
    }
}
