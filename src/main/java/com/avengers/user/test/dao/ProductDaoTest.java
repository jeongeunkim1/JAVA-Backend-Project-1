package com.avengers.user.test.dao;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dao.ProductDao;
import com.avengers.user.dto.Product;

public class ProductDaoTest {
	
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(new String[] {"spring/application-config.xml"});
		
		ProductDao productDao = (ProductDao)applicationContext.getBean("productDao");
		System.out.println(productDao.findProductListCountByCategory("티셔츠"));
		System.out.println(productDao.findProductByCategory(1, 10, "티셔츠"));
//		System.out.println(productDao.findProductsAll());
//		System.out.println(productDao.findByHighPrice());
//		System.out.println(productDao.findByLowPrice());
//		System.out.println(productDao.findByHighStar());
//		System.out.println(productDao.findByLowPrice());
//		System.out.println(productDao.findByProductNo(8));
					
		
		/*
		 준우님이 말씀하신 부분 
		 */
		
		//System.out.println(productDao.insertProduct(new Product(0, "추가", "추가", 29000, "판매자", null, "여성셔츠", "womentee_gif")));
//		Product newproduct = new Product(140, "변경", "변경", 20000, "판매자", null, "여성셔츠", "womentee_gif");
//		System.out.println(productDao.updateProductByNo(newproduct));
//		System.out.println(productDao.deleteProductByNo(140));
		
		
		
		
		
//		System.out.println(productDao.findProductCategory("여성"));
		
//		System.out.println(productDao.findCompleteProduct(3));
//		System.out.println(productDao.findAllCountByType("남성"));
//		System.out.println(productDao.findProductList(1, 10, "남성셔츠"));
//		System.out.println(productDao.findNextSequenceValue());
		
	}
}
