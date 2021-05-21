package com.avengers.user.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.service.CartService;

public class CartServiceTest {
	public static void main(String[] args) throws Exception {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/application-config.xml"});
		
		CartService cartService = (CartService)applicationContext.getBean("cartService");
//		Cart cart = new Cart(0,3,3,2);
//		System.out.println(cartService.findcartitem(cart));
//		System.out.println(cartService.updateCartQty(cart));
//		System.out.println(cartService.insertCart(new Cart(0,2,1,1)));
//		System.out.println(cartService.selectCartAllByNo(3));
//		System.out.println(cartService.deleteCartByCartNo(1));
//		System.out.println(cartService.deleteCartByUserNo(2));
		
		//System.out.println(cartService.findCompleteCart(3));
//		System.out.println(cartService.findCartAndProductByNo(3));

	}
}
