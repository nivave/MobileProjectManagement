package com.zemingo.baseserver.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zemingo.baseserver.model.User;

public class UserDAOImpl implements UserDAO
{

	private SessionFactory sessionFactory;

	public UserDAOImpl(){
		System.out.println("UserDAOImple cntr");
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public void save(User p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		session.persist(p);
//		for (Device device: p.getDevices()){
//			session.persist(device); //TODO: consider	
//		}
		
		tx.commit();
		session.close();
	}

	public List<User> getByNameAndPassword(String userName, String pass) {
 		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> userList = session.createQuery("from users where userName = "+userName+" and password = "+pass).list();
		session.close();
		return userList;

	}
}
