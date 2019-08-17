package com.cart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cart.model.Product;
import com.cart.model.User;

@Repository
public class ProductDaoImpl implements ProductDao {

	// this class is wired with the sessionFactory to do some operation in the
	// database

	@Autowired
	private SessionFactory sessionFactory;

	// this will create one sessionFactory for this class
	// there is only one sessionFactory should be created for the applications
	// we can create multiple sessions for a sessionFactory
	// each session can do some functions

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Product> getAllProducts() {
		// Reading the records from the table
		Session session = sessionFactory.openSession();
		// List<Product> products = session.createQuery("from Product").list();
		List<Product> products = session.createCriteria(Product.class).list();
		System.out.println("----- List of Products-----");
		System.out.println(products);
		// session.flush is used for clear cache in the session
		session.flush();
		// it will close the particular session after completing the process
		session.close();
		return products;
	}

	@Override
	public Product getProductDetails(int productId) {
		
		Session session = sessionFactory.openSession();
//		Product products = session.createCriteria(Product.class).list();
		Product product = session.get(Product.class, productId);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println(product);
		// session.flush is used for clear cache in the session
		session.flush();
		// it will close the particular session after completing the process
		session.close();
		return product;
	}

	/*@Override
	public void persistIntoCartTable(Product product, List<User> userObj) {
		
		Session session = sessionFactory.openSession();
		session.save(product);
		
		query.setParameter("name", name);
		 user = query.list();
		session.flush();
		session.close();	
		}	
	*/	
		
	

}
