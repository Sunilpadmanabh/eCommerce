package com.cart.service;

import java.util.List;

import com.cart.model.Product;
import com.cart.model.User;

public interface UserService {

	public void register(User user);

	public String checklogin(String userName, String password);
	
	//myaccount
	List<User> getUserDetailsByuserName(String uName);

	

}
