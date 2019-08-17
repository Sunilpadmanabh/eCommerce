package com.cart.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cart.model.Cart;
import com.cart.model.Product;
import com.cart.model.User;
import com.cart.service.CartService;
import com.cart.service.ProductService;

@Controller
public class CartController {
	int cartQuantity;
	String name;
	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	@RequestMapping("**/cart/add/{productId}")
	public String addCartItem(@PathVariable(value = "productId") int productId, @ModelAttribute("user") User user,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println(productId);
		Product product = productService.getProductDetails(productId);
		
		
		//request.getSession().setAttribute("unitprice", value);
		 name = (String) request.getSession().getAttribute("UName");
		System.out.println("^^^^^^^^^^" + name);
		if (name != null) {
			System.out.println(cartQuantity + "***0000000000000000000000000000000000***");
			int userId = cartService.getUserId(name);
			cartQuantity = cartService.checkTabQuantity(userId,productId);
			
			if(cartQuantity==0)
			{
				cartService.addCart(name, product);
				int UniqueNoCartItems = cartService.IncrementCartCount(userId);
				request.getSession().setAttribute("itemcount", UniqueNoCartItems);
				return "redirect:/index1";
			}
			
			else if(cartQuantity >= 1)
			{
				int count=cartQuantity+1;
				cartService.incQuantity(count,productId,userId);
				System.out.println("````````````````````````````quantity updated!!!");
				 int UniqueNoCartItems = cartService.IncrementCartCount(userId);
				 request.getSession().setAttribute("itemcount", UniqueNoCartItems);
				 //below is for the updating the price in cartPage while user adds the procuct to cart
				 
				 
				 
				  return "redirect:/index1";
			}
			
			/*
			 * if(count!=1) { cartService.incQuantity(count,productId); int
			 * UniqueNoCartItems = cartService.IncrementCartCount(userId);
			 * request.getSession().setAttribute("itemcount", UniqueNoCartItems);
			 * 
			 * return "redirect:/index1";
			 * 
			 * }
			 */

/*       		System.out.println(count+"no of times user clicked add to carttttttttttttttttttt");	
			cartService.addCart(name, product);
     		int UniqueNoCartItems = cartService.IncrementCartCount(userId);
			request.getSession().setAttribute("itemcount", UniqueNoCartItems);
         model.addAttribute("cartitemlist", cartDetails);
	       cartService.getAllCartDetailsByuserId();
			return "redirect:/index1";
*/
		} else {
			String id = request.getSession().getId();
			System.out.println("SORRY YOU HAVE NOT LOGGED IN");
			int userId = 100;
			String userName = "sunilP";
			Product anonymousProd = productService.getProductDetails(productId);
			cartService.addCart(userName, product);

//			cartService.addCartAnonymous(userId, anonymousProd);
			int UniqueNoCartItems = cartService.IncrementCartCount(userId);
			request.getSession().setAttribute("itemcount", UniqueNoCartItems);

			return "redirect:/index1";
		}
		return "redirect:/index1";
	}

	@RequestMapping(value = { "**/myCartPageDetails", "/cartPage" })
//	@RequestMapping("myCartPageDetails")
	public String myCartPage(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map,
			Model model) {
		String name = (String) request.getSession().getAttribute("UName");
		if (name != null) {
			int userId = cartService.getUserId(name);
			Integer quantity = cartService.checkQuantity(userId);
			System.out.println(";;;;;;");
			System.out.println(request.getSession().getId());
               
//       Set<Cart> cartItem = cartService.getDistinctCartDetails_Product_CartId(userId);
//         List<Cart> uQueryCart = cartService.addToCartDistinctItem(cartItem);
			List<Cart> cart = cartService.addToCartView(userId);
                    
			
			//for productPrice
			System.out.println("************************************************");
			for(int i=0;i<cart.size();i++)
			{
				 Cart cartt = cart.get(i);
				System.out.println(cartt.getPrice());
			}
			System.out.println("************************************************");
			model.addAttribute("cartitemlist", cart);
			return "cartPage";
		} else {
			int userId1 = 100;
			Integer quantity = cartService.checkQuantity(userId1);
			List<Cart> cart = cartService.addToCartView(userId1);
			
			model.addAttribute("cartitemlist", cart);
			
			
			return "cartPage";
		}
	}

	@RequestMapping("**/cart/remove/{cartId}")
	public String removeCartItem(@PathVariable(value = "cartId") int cartId, HttpServletRequest request, Model model) {
		  request.getSession().removeAttribute("message");

		System.out.println(cartId + "========");
		cartService.deleteItem(cartId);
		return "redirect:/cartPage";
//		   return "cartPage";
	}

	@RequestMapping("**/removeAllCartItems")
	public String removeAllCartItems(HttpServletRequest request) {
		  request.getSession().removeAttribute("message");

		String name = (String) request.getSession().getAttribute("UName");
		if(name==null)
		{ 
			int userId = 100;
            cartService.removeAllByUserId(userId);
			return "redirect:/cartPage";
		}
		int userId = cartService.getUserId(name);
		System.out.println(name + "-------------------------------");
		System.out.println(userId + "------------------------------");
		cartService.removeAllByUserId(userId);
		return "redirect:/index1";

	}

	@RequestMapping("checkout")
	public String checkOut(HttpServletRequest request, Model model) {
		  request.getSession().removeAttribute("message");

		int totalSum = 0;
		String name = (String) request.getSession().getAttribute("UName");
		if(name == null)
		{
			request.getSession().setAttribute("message", "please login or register to by the products");
			return "redirect:/cartPage";
		}
		int userId = cartService.getUserId(name);
       model.addAttribute("uName", name);
		List<Cart> cart = cartService.addToCartView(userId);
		if(cart.isEmpty())
		{
			request.getSession().setAttribute("message", "please add the products to checkout!");
			return "redirect:/cartPage";
		}
		model.addAttribute("cartitemlist", cart);
		System.out.println("checkoutconntroller");
		for (Cart cart2 : cart) {
			System.out.println(cart2);
			totalSum += cart2.getPrice();
		}
		model.addAttribute("sum", totalSum);
		return "checkOut";

	}
	 
	@RequestMapping("/incQuantity")
     public String incQuantity(@RequestParam("cartId") int id,@RequestParam("qty") int qty,@RequestParam("price") double price,@RequestParam("productId") int productId , HttpServletRequest request)
     {
		    Product product = productService.getPrice(productId);
		    double prodPrice = product.getProductPrice();
		    System.out.println(prodPrice+"bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		boolean res = cartService.Increment(id,qty,price,prodPrice);
		System.out.println(id+"::::::::::: "+qty);
		if(res)
		return "redirect:/cartPage";
		else
			if(name!=null)
			request.getSession().setAttribute("message", "hey! "+name+" you can add minimum 3 quantity each");
			else
			request.getSession().setAttribute("message", "hey! user you can add minimum 3 quantity each");
		return "redirect:/cartPage";
			
     }

	@RequestMapping("/decQuantity")
    public String decQuantity(@RequestParam("id") int id,@RequestParam("qty") int qty,@RequestParam("price") double price,@RequestParam("productId") int productId , HttpServletRequest request)
    {
		  request.getSession().removeAttribute("message");

		
		  Product product = productService.getPrice(productId);
		    double prodPrice = product.getProductPrice();
		boolean res = cartService.decrement(id,qty,price,prodPrice);
		System.out.println(id+"::::::::::: "+qty);
		if(res)
		return "redirect:/cartPage";
		else
			return "redirect:/cartPage";
    }

}
