package com.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cart.dao.UserDao;
import com.cart.model.Product;
import com.cart.model.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public void register(User user) {
		
		 userDao.register(user);
	}

	@Override
	public String checklogin(String userName, String password) {
		if(userDao.checklogin(userName,password).isEmpty())
		{
			return "failure";
		}
		else
		return "success";
	}

	@Override
	public List<User> getUserDetailsByuserName(String uName) {
		return userDao.getUserDetailsByuserName(uName);
	}

	
	
}
