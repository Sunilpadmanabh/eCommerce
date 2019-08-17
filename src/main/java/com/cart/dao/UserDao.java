package com.cart.dao;

import java.util.List;

import com.cart.model.Product;
import com.cart.model.User;

public interface UserDao {

	public void register(User user);

	public List<User> checklogin(String userName, String password);
	
	//myaccount
	List<User> getUserDetailsByuserName(String uName);

	
	 
	
}
