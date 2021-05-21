package com.avengers.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avengers.user.dto.Cart;
import com.avengers.user.dto.Product;
import com.avengers.user.dto.UserInfo;
import com.avengers.user.service.CartService;
import com.avengers.user.service.ProductService;

@Controller
public class MainController {
	@Autowired
	ProductService productService;
	
	@Autowired
	CartService cartService;
	
	@RequestMapping(value = {"/","/main_page"})
	public String main_page(Model model) {
		
		try {
			List<Product> productAll =  productService.findProductsAll();
			ArrayList<Product> productList= new ArrayList<Product>();
			
			for (int i=0; i<10; i++ ) {

				int random = (int) (Math.random() * productAll.size());

				productList.add(productAll.get(random));
			}
			
			model.addAttribute("product",productList);	
			
			
			
			
		} catch (Exception e) {
	}
		return "main";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/main_cart_ajax", produces="application/json; charset=utf-8")
	public Map<String, Object> main_cart_ajax(HttpSession session) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Product> productList = new ArrayList<Product>();
		List<Cart> cartList = new ArrayList<Cart>();
		UserInfo userInfo = (UserInfo)session.getAttribute("user");
		int user_no = userInfo.getUser_no();
		cartList = (ArrayList<Cart>)cartService.selectCartAllByNo(user_no);
		for (Cart cart : cartList) {
			int product_no = cart.getProduct_no();
			Product product = (Product)productService.findByProductNo(product_no);
			productList.add(product);
		}
		map.put("cartList", cartList);
		map.put("productList", productList);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete_cart_ajax", produces="text/plain; charset=utf-8")
	public String delete_cart_ajax(@RequestParam(value="cart_no") int cart_no,HttpSession session) throws Exception {
		UserInfo userInfo = (UserInfo)session.getAttribute("user");
		int result=0;
		if(cartService.deleteCartByCartNo(cart_no)>0) {
			result = cartService.selectCartAllByNo(userInfo.getUser_no()).size();
		}
		return String.valueOf(result);
	}
	
}

