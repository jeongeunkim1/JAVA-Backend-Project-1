package com.avengers.user.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.service.ProductService;

public class ProductServiceTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext(new String[] {"spring/application-config.xml"});
		
		ProductService productDao = (ProductService)applicationContext.getBean("productService");
		
//		System.out.println(productDao.findProductsAll());
//		System.out.println(productDao.findByHighPrice());
//		System.out.println(productDao.findByLowPrice());
//		System.out.println(productDao.findByHighStar());
//		System.out.println(productDao.findByLowPrice());
//		System.out.println(productDao.findByProductNo(4));
		
		
		//System.out.println(productDao.insertProduct(new Product(0,"리누 투웨이 니트집업","트렌디하고 매력적인 디자인의 니트집업입니다 :D","29,000","판매자",new Date(0),"남성니트웨어","41.PNG")));
		
//		Product newproduct = new Product(14, "변경", "변경", "29,000", "판매자", null,"남성블라우스",3,"menTEE.jpg");
//		System.out.println(productDao.updateProductByNo(newproduct));
		
//		System.out.println(productDao.deleteProductByNo(14));

//		System.out.println(productDao.findProductCategory("여성"));
		
		//System.out.println(productDao.findCompleteProduct(3));
		//System.out.println(productDao.findAllCountByType("티셔츠"));
		//System.out.println(productDao.findProductList(1, 1,"남성셔츠"));
//		ProductListPageMakerDto productListPage = productDao.findProductList(3, "남성");
//		System.out.println(productListPage.productList.size());
//		ProductListPageMakerDto findByProductName = productDao.findProductByName(1, "티셔츠");
//		System.out.println(findByProductName.productList.size());
	}
}
