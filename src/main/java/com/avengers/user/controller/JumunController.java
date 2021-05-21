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

import com.avengers.user.dto.Address;
import com.avengers.user.dto.Cart;
import com.avengers.user.dto.Jumun;
import com.avengers.user.dto.Product;
import com.avengers.user.dto.UserInfo;
import com.avengers.user.service.AddressService;
import com.avengers.user.service.CartService;
import com.avengers.user.service.JumunService;
import com.avengers.user.service.ProductService;
import com.avengers.user.service.UserInfoService;

@Controller
public class JumunController {

	@Autowired
	CartService cartService;
	@Autowired
	ProductService productService;
	@Autowired
	AddressService addressService;
	@Autowired
	JumunService jumunService;
	@Autowired 
	UserInfoService userinfoservice;
	
	
	@RequestMapping(value = "/jumun_page", method=RequestMethod.POST)
	public String Jumun_page( Model model, HttpSession session ,@RequestParam( value="cart_no" ) List<Integer> cart_no)throws Exception {
		UserInfo user = (UserInfo) session.getAttribute("user");
		ArrayList<Cart> cartList = (ArrayList<Cart>)cartService.selectCartAllByNo(user.getUser_no());
		List<Address> address = addressService.selectAddressAllByNo(user.getUser_no());
		ArrayList<Product> productList=new ArrayList<Product>();
		
		int tot = 0;
		for (Cart cart : cartList) {
			int product_no=cart.getProduct_no();
			Product product=productService.findByProductNo(product_no);
			
			tot+=product.getProduct_price();
			productList.add(product);
		}
		
		/*		
		int subTot = 0;
		for (Cart cart : cartList) {
			Product product=productService.findByProductNo(cart.getProduct_no());
			subTot = (cart.getCart_quantity()*product.getProduct_price());
		}
		for (Cart cart : cartList) {
			int product_no=cart.getProduct_no();
			Product product=productService.findByProductNo(product_no);
			productList.add(product);
		}
		*/
		
		
		model.addAttribute("productList", productList);
		model.addAttribute("cartList",cartList);
		model.addAttribute("cart_no",cart_no);
		model.addAttribute("address",address);
		//model.addAttribute("subTot",subTot);
		model.addAttribute("tot",tot);
		
		return "jumun";
	}
	
	@RequestMapping(value = "/jumun_action", method = RequestMethod.POST)
	public String jumun_action(HttpSession session, @ModelAttribute Address address, @RequestParam(value="j_desc") String j_desc) throws Exception{
		UserInfo user = (UserInfo) session.getAttribute("user");
		ArrayList<Cart> cartList = (ArrayList<Cart>)cartService.selectCartAllByNo(user.getUser_no());
		int tot = 0;
		for (Cart cart : cartList) {
			int product_no=cart.getProduct_no();
			Product product=productService.findByProductNo(product_no);
			tot+=product.getProduct_price();
		}
			addressService.updateAddress(address);
			jumunService.insertJumun(new Jumun(33, null, j_desc, tot, user.getUser_no()));
			cartService.deleteCartByUserNo(user.getUser_no());
		
		return "forward:order_complete_page";
	}
	

	@RequestMapping(value="/payment_page",method = RequestMethod.GET)
	public String payment_page() {
		return "payment-page";
	}
}
