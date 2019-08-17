package com.cart.service;

import java.util.List;
import java.util.Set;

import com.cart.model.Cart;
import com.cart.model.Product;

public interface CartService {

	public void addCart(String name,Product product);
	
	
	void getAllCartDetailsByuserId(int userId);

	int getUserId(String name);


	public int IncrementCartCount(int userId);


	public int checkQuantity(int userId);
	
	public Set<Cart> getDistinctCartDetails_Product_CartId(int userId);


	public List<Cart> addToCartDistinctItem(Set<Integer> cartItem);


	public List<Cart> addToCartView(int userId);


	public void addCartAnonymous(int id, Product product);


	public void deleteItem(int cartId);


	public void removeAllByUserId(int userId);


	public void updateCart(int userId);


	public int checkTabQuantity(int userId,int productId);


	public void incQuantity(int count, int productId,int userId);


	public boolean Increment(int id, int qty, double price,double prodPrice);


	public boolean decrement(int id, int qty,double price,double prodPrice);
	
}
