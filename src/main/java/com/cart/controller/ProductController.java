package com.cart.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cart.model.Product;
import com.cart.model.User;
import com.cart.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	
/*	@RequestMapping(value="getProductById")
	public String showHomePage(@PathVariable(value = "id") int productId)
	{
		System.out.println(productId);
		System.out.println("%%%%%%%%%%%%%%%%%%%controller");
		productService.getProductDetails(productId);
		
		return "index1";
	}	
*/	
	
	@RequestMapping(value="getProductById")
	public String showHomePage(HttpServletRequest req,Model model)
	{
		int productId =Integer.parseInt(req.getParameter("id"));
		System.out.println(productId);
		System.out.println("%%%%%%%%%%%%%%%%%%%controller");
	    Product product =	productService.getProductDetails(productId);
	    model.addAttribute("product",product);
	    System.out.println("&&&&&&&&"+product.getProductDescription());
		return "productDetails";
	}

 }
