package com.cart.dao;

import java.util.List;

import com.cart.model.Product;
import com.cart.model.User;

public interface ProductDao {

	List<Product> getAllProducts();

	Product getProductDetails(int productId);



}
