package com.cart.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.context.Theme;

import com.cart.model.Cart;
import com.cart.model.Product;
import com.cart.model.User;

@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
    
	
 
	
	@Override
	public void getAllCartDetails(int userId) {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where userId=?");
		query.setParameter(0, userId);
		User users = (User) query.list();
        

		session.flush();
		// it will close the particular session after completing the process
		session.close();
//		return carts;
	
	}



	@Override
	public void addCart(String name, Product product) {
		// TODO Auto-generated method stub
	    User user = new User();
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select userId from User where userName=:name");
		query.setParameter("name", name);
		 int id = (int) query.uniqueResult();
		 user.setUserId(id);
		 System.out.println(product.getProductId()+"produuuuuuuuuuuuuuuuuuuuuuuct iddddddddddddddd in daooooooo");
		 
		 Cart cart = new Cart();
		 cart.setDescription(product.getProductDescription());
         cart.setName(product.getProductName());
		 cart.setPrice(product.getProductPrice());
		 cart.setUserId(user);
		 cart.setProduct_CartId(product.getProductId());
		 cart.setUnitPrice(product.getProductPrice());
		 
		 System.out.println(cart.getProduct_CartId());
		 
		 session.save(cart);
		session.flush();
		session.close();		

		
	}



	
	public int getUserId(String name) {

		
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("select userId from User where userName=:name");
		query.setParameter("name", name);
		 int id = (int) query.uniqueResult();
		System.out.println(id+"UNIQUE RESULT");	
			return id;
	}



	@Override
	public List<Cart> IncrementCartCount(int userId) {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where userId=?");
		query.setInteger(0, userId);
		
//		Query query = session.createSQLQuery("from Cart where userId=:userId");
//		query.setParameter("userId", userId);
		
		System.out.println(userId+"{{{{}}}}}");
		
		List<Cart> carts =  query.list();
		System.out.println(carts+"'''''''''''''''''");
//        System.out.println(carts.size()+"___----------");
		return carts;
	}



	@Override
	public List<Cart> addToCartPage(int userId) {
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Cart where userId=?");
		query.setInteger(0, userId);
		List<Cart> cartDetails =  query.list();
        System.out.println(cartDetails+"CART DETAILS IS WORKING###");
		return cartDetails;
	}



	@Override
	public List<Cart> getDistinctCartDetails_Product_CartId(int userId) {
		
		Session session = sessionFactory.openSession();
//		Query query = session.createQuery("distinct(userId),name,price,description,Product_CartId from Cart where userId=:userId");
		Query query = session.createQuery("from Cart where userId=?");
		query.setInteger(0, userId);
		System.out.println(userId+"userIduserIduserIduserIduserIduserId=from the DistinctCartDetails");
		List<Cart> cart = query.list();
		System.out.println(cart+"userIdCartObjectObjectObjectObjectObjectObjectObjectObjectObjectObject");
		return cart;
	}



	@Override
	public List<Cart> addToCartDistinctItem(Set<Integer> cartItem) {
		Session session = sessionFactory.openSession();

        Integer[] arr1=cartItem.toArray(new Integer[cartItem.size()]);
        List<Cart> cart =null;
		
		for(int i=0;i<arr1.length;i++)
		{
//			Query query = session.createSQLQuery("select distinct Product_CartId,userId,price,description,name  from cart WHERE Product_CartId=:Product_CartId");
//			query.setParameter("Product_CartId", Product_CartId);
//			Query query = session.createSQLQuery("select Product_CartId,description,name,price from Cart where Product_CartId in(a,b);
			
			/*Query query = session.createQuery("select (distinct)Product_CartId,description,name,price from Cart where Product_CartId='"+arr1[i]+"'");
             //query.setParameterList("arr1[i]", cartItem); 
              cart = query.list();
          System.out.println("uuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu"+cartItem);*/
			
			
			Query query = session.createQuery("from Cart where userId='"+arr1[i]+"'"); 
			query.setFirstResult(0);
			query.setMaxResults(1);
			cart = query.list();
		}
		return cart;
		
	}



	@Override
	public List<Cart> addToCartView(int userId) {
		System.out.println("im in cartdao above");
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from Cart where userId='"+userId+"'"); 
//		query.setFirstResult(0);
//		query.setMaxResults(1);
		 List<Cart> cart = query.list();
		
		return cart;
       }



	@Override
	public void anonymousCart(int id, Product product) {
		User user = new User();
		Cart cart = new Cart();
		System.out.println("IS MY ID OF THE FJSLKJFL anonymous cart");
		System.out.println(id);
		Session session = sessionFactory.openSession();
		
		user.setUserId(id);
		cart.setDescription(product.getProductDescription());
		cart.setName(product.getProductName());
		cart.setPrice(product.getProductPrice());
		cart.setProduct_CartId(product.getProductId());
		cart.setUserId(user);
	    System.out.println(cart.getDescription());
		session.save(cart);
		session.flush();
		session.close();		
		
	}



	@Override
	public void deleteItem(int cartId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query query = session.createSQLQuery("delete from Cart where cartId='"+cartId+"'");
		query.executeUpdate();
		System.out.println("deleted!!!"+cartId);
		session.flush();
		session.close();	
	}



	@Override
	public String removeAllByUserId(int userId) {
		// TODO Auto-generated method stub
		Session session =  sessionFactory.openSession();
		Query query = session.createSQLQuery("delete from Cart where userId=?");
		query.setInteger(0, userId);
		query.executeUpdate();
		System.out.println("dddddddddddddddeeeeeeeeeeeeeelllllllllllleeeeeeetttttttttttttteeeeeeeeedddd");
		return "";
	}



	@Override
	public void updateCart(int userId) {
		
		Session session =  sessionFactory.openSession();
		Query query1 = session.createSQLQuery("update Cart set userId='"+userId+"' where userId=?");
		query1.setInteger(0, 100);
		query1.executeUpdate();
		System.out.println("updatedddddddddddddd");
		session.flush();
		session.close();	

	}



	@Override
	public List<Cart> checkTabQuantity(int userId,int productId) {
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
         Query query = session.createQuery("from Cart where userId='"+userId+"' and product_Id='"+productId+"' ");
		 List<Cart> list = query.list();
	 System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
		  session.getTransaction().commit();
          session.flush();
           session.close();
		return list;
	}



	@Override
	public void incQuantity(int count, int productId, int userId) {
		// TODO Auto-generated method stub
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
        Query query = session.createQuery(" update Cart set quantity='"+count+"' where product_Id='"+productId+"' and userId='"+userId+"' ");
           query.executeUpdate();
           session.getTransaction().commit();
           session.flush();
            session.close();
		
	}



	@Override
	public boolean Increment(int id,int qty,double price,double prodPrice) {
				
		int qty1=qty+1;
		double price1 = prodPrice*qty1;
		if(qty1<4) {
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update Cart set quantity='"+qty1+"' where cartId='"+id+"' ");
		int res = query.executeUpdate();
         
         Query query1 = session.createQuery("update Cart set price='"+price1+"' where cartId='"+id+"' ");
 		 int ress = query1.executeUpdate();
 		  
          session.getTransaction().commit();
         session.flush();
          session.close();
          return true;
		}
//          if((res&ress)!=0)
//          return true;
          else return false;
	}
	


	@Override
	public boolean decrement(int id, int qty, double price,double prodPrice) {
		int qty1=qty-1;
		double price1 = prodPrice*qty1;
		if(qty1==0)
		{
			return false;
		}
		Session session =  sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("update Cart set quantity='"+qty1+"' where cartId='"+id+"' ");
		int res = query.executeUpdate();
		
		   Query query1 = session.createQuery("update Cart set price='"+price1+"' where cartId='"+id+"' ");
	 		int ress = query1.executeUpdate();
	 		  
         session.getTransaction().commit();
         session.flush();
          session.close();
          if((res&ress)!=0)
          return true;
          else return false;
	}
}