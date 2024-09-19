package com.example.demo.repositoryimpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;
 
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
 
@Repository
@Transactional
public class UserRepoImpl implements UserRepo {
 
	@Autowired
	EntityManager entityMan;
 
	public User newUser(User newUser) {
		entityMan.persist(newUser);
		return newUser;
	}
 
	@SuppressWarnings("unchecked")
 
	public List<User> getUsers() {
		return entityMan.createQuery("from User").getResultList();
	}
 
	public User userfind(int userId) {
		return entityMan.find(User.class, userId);
	}
 
	
 
	public User updateUser(User user) {
		entityMan.merge(user);
		return user;
	}
 
	
 
	@Override
	public List<Integer> getUserIdList() {
		Query q = entityMan.createQuery("SELECT c.userId FROM User");
		return q.getResultList();
	}
 
	@Override
	public User UserLogin(String userEmail, String userPassword) {
		Query query1 = entityMan.createQuery("from User u where u.userEmail =?1 and u.userPassword=?2");
		query1.setParameter(1, userEmail);
		query1.setParameter(2, userPassword);
 
		return (User) query1.getSingleResult();
 
	}
 
	@Override
	public User findByUserEmail(String userEmail) {
		String jpql = "SELECT e FROM User e WHERE e.userEmail = :userEmail";
	    TypedQuery<User> query = entityMan.createQuery(jpql, User.class);
	    query.setParameter("userEmail", userEmail);
	    
	    try {
	        return query.getSingleResult();
	    } catch (NoResultException | NonUniqueResultException	 e) {
	        return null;
	    }
	}

	@Override
	public Optional<User> findbyUserId(int id) {
		String jpql = "SELECT u FROM User u WHERE u.id = :id";
	    TypedQuery<User> query = entityMan.createQuery(jpql, User.class);
	    query.setParameter("id",id);
	    
	    try {
	        return Optional.ofNullable(query.getSingleResult());
	    } catch (NoResultException | NonUniqueResultException	 e) {
	        return null;
	    }
	}
	
}