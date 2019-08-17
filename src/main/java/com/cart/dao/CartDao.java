package com.cart.dao;

import java.util.List;
import java.util.Set;

import com.cart.model.Cart;
import com.cart.model.Product;

public interface CartDao {
	
	void addCart(String name,Product product);

	
	void getAllCartDetails(int userId);


	int getUserId(String name);


	List<Cart> IncrementCartCount(int userId);

	List<Cart> addToCartPage(int userId);

	List<Cart> getDistinctCartDetails_Product_CartId(int userId);


	List<Cart> addToCartDistinctItem(Set<Integer> cartItem);


	List<Cart> addToCartView(int userId);


	void anonymousCart(int id, Product product);


	void deleteItem(int productId);


	String removeAllByUserId(int userId);


	void updateCart(int userId);


	
	public List<Cart> checkTabQuantity(int userId,int productId);


	void incQuantity(int count, int productId,int userId);


	boolean Increment(int id, int qty, double price,double prodPrice);


	boolean decrement(int id, int qty, double price,double prodPrice);
	
}
