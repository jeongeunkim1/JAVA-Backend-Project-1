package com.avengers.user.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dao.CompanyProductDao;
import com.avengers.user.dto.CompanyProduct;

public class CompanyProductDaoTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(new String[]{"spring/application-config.xml"});
		CompanyProductDao companyProductDao = (CompanyProductDao)applicationContext.getBean("companyProductDao");
		
		// Product insert 후 CompanyProduct에 insert
		//CompanyProduct companyProduct = 
				//new CompanyProduct(0, "테스트", "테스트", "테스트", "테스트", null, 3);
		//companyProductDao.insertCompanyProduct(companyProduct);
		
		// 회사 자신이 판매하는 제품리스트
		//System.out.println(companyProductDao.selectCompanyProductAllByNo(3));
		
		// 회사 자신이 판매하는 제품 상세보기
		//System.out.println(companyProductDao.selectCompanyProductByNo(4));
		
		// 회사 자신이 판매하는 제품 수정
		//System.out.println(companyProductDao.updateCompanyProductByNo(new CompanyProduct(4, "변경", "변경", "변경", "변경")));
		
		// 회사 자신이 등록한 제품 삭제
		//System.out.println(companyProductDao.deleteCompanyProductByNo(4));
	}

}
