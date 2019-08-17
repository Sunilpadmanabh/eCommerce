package com.cart.service;

import java.util.List;

import com.cart.model.Product;
import com.cart.model.User;

public interface ProductService {

	public List<Product> getAllProducts();
	
	public Product getProductDetails(int productId);

	public Product getPrice(int productId);


}
