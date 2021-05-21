package com.avengers.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avengers.user.dto.Cart;
import com.avengers.user.dto.Product;
import com.avengers.user.dto.UserInfo;
import com.avengers.user.service.CartService;
import com.avengers.user.service.ProductService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService; 
	
	@RequestMapping(value = "/cart_page")
	public String cart_page( Model model, HttpSession session ) throws Exception {
		UserInfo user = (UserInfo) session.getAttribute("user");
		List<Cart> cartList = cartService.findCartAndProductByNo(user.getUser_no());
		int tot = 0;
		
		for (Cart cart : cartList) {
			tot+=cart.getProduct().getProduct_price();
		}
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("tot",tot);
		
		return "cart";
	}
	
	@RequestMapping(value = "/add_cart",method = RequestMethod.POST)
	public String add_cart(@ModelAttribute Cart cart) {
		try {
			Cart finditem = cartService.findcartitem(cart);
			if(finditem!=null) {
				cartService.updateCartQty(cart);
			}else {
				cartService.insertCart(cart);
				
				if(cart.getCart_quantity() > 1) {
					int cart_item = cart.getCart_quantity()-1;
					cart.setCart_quantity(cart_item);
					cartService.updateCartQty(cart);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:cart_page";
	}
	
	@RequestMapping(value = "/cart_delete_action", method = RequestMethod.POST)
	public String cart_delete_action(@RequestParam(value="cart_del_no") int cart_no) {
		try {
			cartService.deleteCartByCartNo(cart_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "forward:cart_page";
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/cart_add_item_json", produces = "application/json;charset=UTF-8")
	public Cart product_list_json(@RequestParam("qty") int qty,@RequestParam("cart_no") int cart_no) throws Exception{
		Cart cart = cartService.findcartitembyNo(cart_no);
		cart.setCart_quantity(qty);
		cartService.updateCartQty(cart);

		return cartService.findcartitembyNo(cart_no);
	}
	
}