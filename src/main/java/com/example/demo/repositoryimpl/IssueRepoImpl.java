package com.example.demo.repositoryimpl;

import com.example.demo.model.Issue;
import com.example.demo.repository.IssueRepo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IssueRepoImpl implements IssueRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Issue issue) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(issue);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public Issue findById(int id) {
        Session session = sessionFactory.openSession();
        Issue issue = null;
        try {
            issue = session.get(Issue.class, id);
        } finally {
            session.close();
        }
        return issue;
    }

    @Override
    public List<Issue> findAll() {
        Session session = sessionFactory.openSession();
        List<Issue> issues = null;
        try {
            issues = session.createQuery("from Issue", Issue.class).list();
        } finally {
            session.close();
        }
        return issues;
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Issue issue = session.get(Issue.class, id);
            if (issue != null) {
                session.delete(issue);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
    @Override
    public void updateReply(int id, String reply) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Issue issue = session.get(Issue.class, id);
            if (issue != null) {
                issue.setReply(reply);
                session.update(issue);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Issue> findByUserId(int userId) {
        Session session = sessionFactory.openSession();
        List<Issue> issues = null;
        try {
            issues = session.createQuery("from Issue where user.id = :userId", Issue.class)
                            .setParameter("userId", userId)
                            .list();
        } finally {
            session.close();
        }
        return issues;
    }
}
