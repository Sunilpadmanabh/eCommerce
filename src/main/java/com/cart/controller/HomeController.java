package com.cart.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cart.model.Product;
import com.cart.model.User;
import com.cart.service.CartService;
import com.cart.service.ProductService;
import com.cart.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private CartService cartService;

	@Autowired
	private ProductService productService;	
	
	
	@RequestMapping({"/","**/index1","/index1"})
	public String showHomePage(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model)
	{
		List<Product> products = productService.getAllProducts();
		model.put("products", products);
//		int itemcount = 0;
//		model.put("itemcount", itemcount);
//		HttpSession session = request.getSession();
		request.getSession().setAttribute("login", "login");
		request.getSession().setAttribute("signup","signup");
		
		
		
		String name = (String) request.getSession().getAttribute("UName");
		if(name==null)
		{
			int userId = 100;
			int UniqueNoCartItems = cartService.IncrementCartCount(userId);
	           request.getSession().setAttribute("itemcount", UniqueNoCartItems);			
			return "index1";
		}
		int userId = cartService.getUserId(name);
		int UniqueNoCartItems = cartService.IncrementCartCount(userId);
           request.getSession().setAttribute("itemcount", UniqueNoCartItems);

		
		return "index1";
	}	
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, Map<String, Object> model) {
		
		request.getSession().removeAttribute("logout");
		request.getSession().removeAttribute("welcome");
		request.getSession().removeAttribute("UName");
		List<Product> products = productService.getAllProducts();
		model.put("products", products);
		
//		int itemcount = 0;
//		model.put("itemcount", itemcount);
		   request.getSession().removeAttribute("itemcount");


		String name = (String) request.getSession().getAttribute("UName");
		name = null;
		return "index1";
	}
	
}
