package com.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.dao.ProductDao;
import com.cart.model.Product;
import com.cart.model.User;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	

	@Override
	public List<Product> getAllProducts() {
		
		return productDao.getAllProducts();
	}


	@Override
	public Product getProductDetails(int productId) {
		// TODO Auto-generated method stub
		
		Product product = productDao.getProductDetails(productId);
		return product;
	}


	@Override
	public Product getPrice(int productId) {
          Product product = productDao.getProductDetails(productId);
          System.out.println(product.getProductPrice());
		return product;
	}
	

	
}
