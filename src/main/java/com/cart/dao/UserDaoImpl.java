package com.cart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cart.model.User;



@Repository
public class UserDaoImpl implements  UserDao{

	@Autowired
	private SessionFactory sessionFactory;

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void register(User user) {
		System.out.println("Adding customer in dao");
		Session session = sessionFactory.openSession();	
		session.save(user);
		session.flush();
		session.close();
        
	}

	@Override
	public List<User> checklogin(String userName, String password) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select * from User where userName=:userName and password=:password");
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		List<User> user = query.list();
		System.out.println("*********************"+user);
		session.flush();
		session.close();
		return user;
	}

	/* (non-Javadoc)
	 * @see com.cart.dao.UserDao#getUserDetailsByuserName(java.lang.String)
	 */
	
	@Override
	public List<User> getUserDetailsByuserName(String uName) {
		// TODO Auto-generated method stub
		List<User> user=null;
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where userName=:userName");
		query.setParameter("userName", uName);
//		User user = session.get(User.class, uName);
//		System.out.println(user+"}}}}}}}}}}}}}}}}}}");
		user= query.list();
		for(User userList: user) {
			System.out.println(userList.getUserName()+"username in userdao");
		}
		System.out.println("%%%%%%%%%%"+user);
		session.flush();
		session.close();
		
		return user;
		
	}


	
}
