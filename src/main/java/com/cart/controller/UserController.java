package com.cart.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cart.model.User;
import com.cart.service.CartService;
import com.cart.service.ProductService;
import com.cart.service.UserService;

@Controller
public class UserController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "**/registration", method = RequestMethod.GET)
 	public String getRegistrationForm(Map<String, Object> model) {
		User user=new User();
		model.put("user", user);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+user);
		System.out.println(user.toString());
		return "register1";
	}
	

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registerCustomer(@ModelAttribute("user") User user, Model model,HttpServletRequest request) {
		
		userService.register(user);
		model.addAttribute("user", user.getUserName());
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+user);
	     System.out.println(user.toString());
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+user.getUserId());
           int userId = user.getUserId();
           String userName = user.getUserName();
           System.out.println(userId);
           
		cartService.updateCart(userId);

           
           int UniqueNoCartItems = cartService.IncrementCartCount(userId);
           request.getSession().setAttribute("itemcount", UniqueNoCartItems);
           
		
		request.getSession().setAttribute("UName",userName);
		request.getSession().setAttribute("welcome", "welcome:");
		request.getSession().setAttribute("logout", "logout");
		
		 request.getSession().removeAttribute("login");
		   request.getSession().removeAttribute("signup");

           
		return "redirect:/index1";
	}

	/*@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") String userName,@ModelAttribute("password") String password , Model model) {
		
		if(userService.checklogin(userName,password).equals("success")) {
			model.addAttribute("userName", userName);
		}
		return "redirect:/index1";
	}*/
	@RequestMapping(value="**/login")
	public String login() {
		return "login";
	}
/*	
 * sushma loginCheck
	@RequestMapping(value="/logincheck")
	public String logincheck(@RequestParam("userName") String userName,@RequestParam("password") String password) {
		System.out.println(userName+"username");
		System.out.println(password+"password");
		
		return "redirect:/index1";
	}
*/	
	
	@RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	public String login(@ModelAttribute("userName") String userName,@ModelAttribute("password") String password , Model model,HttpServletRequest request) {
	   
		
		HttpSession session = request.getSession();
		
		if(userService.checklogin(userName,password).equals("success")) {
			System.out.println(userService.checklogin(userName,password)+"in controller");
			model.addAttribute("userName", userName);
			
//			String name = (String) request.getSession().getAttribute("UName");
//System.out.println(name+",,,,,,,,,,,,,,,,,,,,,userName BY LOGIN");
			int userId = cartService.getUserId(userName);
			cartService.updateCart(userId);
			int UniqueNoCartItems = cartService.IncrementCartCount(userId);
	           request.getSession().setAttribute("itemcount", UniqueNoCartItems);

	           
			
			System.out.println("--------------------"+userName);
			request.getSession().setAttribute("UName",userName);
			request.getSession().setAttribute("welcome", "welcome:");
			request.getSession().setAttribute("logout", "logout");
			
			 request.getSession().removeAttribute("login");
			   request.getSession().removeAttribute("signup");
			
		
			return "redirect:/index1";
		}
		else
		{
			
			request.getSession().setAttribute("messageSession", "hey! user please enter the valid credentials");
			return "login";
		}
	}
	
	@RequestMapping(value="myaccount")
	public String myAccount(HttpServletRequest request,HttpServletResponse response,Model model)
	{
		String name = (String) request.getSession().getAttribute("UName");
		System.out.println(name+"''''''''''''''''above");

		List<User> users = userService.getUserDetailsByuserName(name);
		 model.addAttribute("userDetails",users);
		System.out.println(name+"''''''''''''''''below");
		System.out.println(users+"''''''''''''''''");
       
		return "myaccount";
		
	}
	
		

	
	
}
