package com.example.demo.repositoryimpl;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepo;
 
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
 
@Repository
@Transactional
public class AdminRepoImpl implements AdminRepo {
 
	@Autowired
	EntityManager entityMan;
 
	public Admin newAdmin(Admin newAdmin) {
		entityMan.persist(newAdmin);
		return newAdmin;
	}
 
	@SuppressWarnings("unchecked")
 
	public List<Admin> getAdmins() {
		return entityMan.createQuery("from Admin").getResultList();
	}
 
	public Admin adminfind(int adminId) {
		return entityMan.find(Admin.class, adminId);
	}
 
	
 
	public Admin updateAdmin(Admin admin) {
		entityMan.merge(admin);
		return admin;
	}
 
	
 
	@Override
	public List<Integer> getAdminIdList() {
		Query q = entityMan.createQuery("SELECT c.adminId FROM Admin");
		return q.getResultList();
	}
 
	@Override
	public Admin AdminLogin(String adminEmail, String adminPassword) {
		Query query1 = entityMan.createQuery("from Admin u where u.adminEmail =?1 and u.adminPassword=?2");
		query1.setParameter(1, adminEmail);
		query1.setParameter(2, adminPassword);
 
		return (Admin) query1.getSingleResult();
 
	}
 
	@Override
	public Admin findByAdminEmail(String adminEmail) {
		String jpql = "SELECT e FROM Admin e WHERE e.adminEmail = :adminEmail";
	    TypedQuery<Admin> query = entityMan.createQuery(jpql, Admin.class);
	    query.setParameter("adminEmail", adminEmail);
	    
	    try {
	        return query.getSingleResult();
	    } catch (NoResultException | NonUniqueResultException	 e) {
	        return null;
	    }
	}
}