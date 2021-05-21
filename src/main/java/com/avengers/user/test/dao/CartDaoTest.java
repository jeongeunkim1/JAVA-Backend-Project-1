package com.avengers.user.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dao.CartDao;

public class CartDaoTest {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/application-config.xml"});
		
		CartDao cartDao = (CartDao)applicationContext.getBean("cartDao");
		
//		System.out.println(cartDao.selectCartAllByNo(3));
//		System.out.println(cartDao.insertCart(new Cart(0,3,3,2)));
//		System.out.println(cartDao.deleteCartByCartNo(4));
//		System.out.println(cartDao.deleteCartByUserNo(3));
		
		//System.out.println(cartDao.findCompleteCart(3));
		System.out.println(cartDao.findCartAndProductByNo(1));
	}
}