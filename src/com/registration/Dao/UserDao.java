package com.registration.Dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.registration.Configuration.HibernateConfiguration;
import com.registration.Entity.UserInformation;


public class UserDao {
	private SessionFactory factory = HibernateConfiguration.getSessionFactory();

	public boolean registerUser(String fname, String lname, long mobile, String email, String password) {
		Session session = factory.openSession();
		UserInformation user = new UserInformation();
		user.setDateOfCreation(LocalDateTime.now());
		user.setDateOfModification(LocalDateTime.now());
		user.setFname(fname);
		user.setLname(lname);
		user.setMobileNo(mobile);
		user.setEmail(email);
		user.setPassword(password);

		session.save(user);
		session.beginTransaction().commit();
		return true;

	}

	public List<UserInformation> getUserByEmail(String email) {
		Session session=factory.openSession();
		   List<UserInformation> list = null;

	        try {
	            Criteria criteria = session.createCriteria(UserInformation.class);
	            criteria.add(Restrictions.eq("email", email));
	            list = criteria.list();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close(); // Ensure session is closed to avoid memory leaks
	        }

	        return list;
	    }

	
	public boolean updateUserPassword(String email, String encryptedPassword) {
        Session session = factory.openSession();
        org.hibernate.Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            
            // Fetch the user based on email
            Criteria criteria = session.createCriteria(UserInformation.class);
            criteria.add(Restrictions.eq("email", email));
            UserInformation user = (UserInformation) criteria.uniqueResult();

            // If user exists, update the password
            if (user != null) {
                user.setPassword(encryptedPassword);
                session.update(user);
                transaction.commit();
                return true;
            }
            
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
		
	}



