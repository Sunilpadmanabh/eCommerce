package com.cart.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cart.dao.CartDao;
import com.cart.dao.ProductDao;
import com.cart.model.Cart;
import com.cart.model.Product;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;

	public void addCart(String name,Product product) {
		  cartDao.addCart(name,product);
	}

	
	@Override
	public void getAllCartDetailsByuserId(int userId) {
       cartDao.getAllCartDetails(userId);
	}


	@Override
	public int getUserId(String name) {
		int id =cartDao.getUserId(name);

		return id;
	}


	@Override
	public int IncrementCartCount(int userId) {
		List<Cart> carts = cartDao.IncrementCartCount(userId);
		
		System.out.println("I'M IN THE CART SERVICE IMPL");
		
		//Cart cart = new Cart();
		
		Set<Integer> set = new HashSet<>();
		for(int i=0;i<carts.size();i++)
		{
		Cart cart 	 = carts.get(i);
		set.add(cart.getProduct_CartId());
		System.out.println(cart.getProduct_CartId());	
		}
		
		int size = set.size();
		System.out.println(size+"++++++++++++++++++");
		System.out.println(size+"_____---------");
		return size;
	}


	@Override
	public int checkQuantity(int userId) {
//		return cartDao.addToCartPage(userId);
		List<Cart> cart = cartDao.IncrementCartCount(userId);
		int count =0;
		for(int i=0;i<cart.size();i++)
		{
		  Cart cart1 = cart.get(i);
		  count++;
		}
		System.out.println(cart+"BEFOREEEEEEEEEEEEEEEEEEEEEEEE");
		System.out.println(count+"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
		return count;
	}


	@Override
	public Set<Cart> getDistinctCartDetails_Product_CartId(int userId) {
		
		List<Cart> cart = cartDao.getDistinctCartDetails_Product_CartId(userId);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		for(int i=0;i<cart.size();i++)
		{
			System.out.println(cart.get(i));
		}
		Set<Cart> uniCart_ProdId = new HashSet<>();
	//	Cart cart3 = cart.get(i);

		return uniCart_ProdId;
		
	}


	@Override
	@Transactional
	public List<Cart> addToCartDistinctItem(Set<Integer> cartItem) {
		return cartDao.addToCartDistinctItem(cartItem);
		
	}


	@Override
	@Transactional
	public List<Cart> addToCartView(int userId) {
		System.out.println("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");
		List<Cart> cart =  cartDao.addToCartView(userId);
       //System.out.println(cart+"in service");
       for(Cart car:cart)
       {
    	   System.out.println(car.getUnitPrice());
    	   System.out.println("above is the unit Price");
       }
		System.out.println("gggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg");

		return cart;
	}


	@Override
	public void addCartAnonymous(int id, Product product) {
		cartDao.anonymousCart(id,product);
		
	}


	@Override
	public void deleteItem(int cartId) {
		// TODO Auto-generated method stub
		cartDao.deleteItem(cartId);
	}


	@Override
	public void removeAllByUserId(int userId) {
		// TODO Auto-generated method stub
		cartDao.removeAllByUserId(userId);
		
	}


	@Override
	public void updateCart(int userId) {
		// TODO Auto-generated method stub
		cartDao.updateCart(userId);
	}


	public int checkTabQuantity(int userId,int productId) {
		int quantity = 0;
		List<Cart> cart = cartDao.checkTabQuantity(userId,productId);
		System.out.println("cart service....................");
		for(Cart car : cart)
		{
			 quantity = car.getQuantity();
		}
		System.out.println(quantity);
		return quantity;
	}


	@Override
	public void incQuantity(int count, int productId,int userId) {
		// TODO Auto-generated method stub
		cartDao.incQuantity(count,productId,userId);
		
	}


	@Override
	public boolean Increment(int id, int qty, double price,double prodPrice) {
		  boolean res = cartDao.Increment(id,qty,price,prodPrice);
		if(res)
		{
			return true;
		}
		else
			return false;
		  
	}


	@Override
	public boolean decrement(int id, int qty, double price,double prodPrice) {
		 boolean res = cartDao.decrement(id,qty,price,prodPrice);
			if(res)
			{
				return true;
			}
			else
				return false;
		}


	
	
}
