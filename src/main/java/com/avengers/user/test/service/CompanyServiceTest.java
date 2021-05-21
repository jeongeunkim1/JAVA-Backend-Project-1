package com.avengers.user.test.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dto.CompanyProduct;
import com.avengers.user.service.CompanyProductService;

public class CompanyServiceTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/application-config.xml"});

		CompanyProductService companyProductService = (CompanyProductService) applicationContext.getBean("companyProductService");

		// Product insert 후 CompanyProductService에 insert
		//CompanyProduct companyProduct = new CompanyProduct(0, "테스트", "테스트", "테스트", "테스트", null, 3);
		//System.out.println(companyProductService.insertCompanyProduct(companyProduct));
		
		
		// 회사 자신이 판매하는 제품리스트
		//System.out.println(companyProductService.selectCompanyProductAllByNo(3));

		// 회사 자신이 판매하는 제품 상세보기
		//System.out.println(companyProductService.selectCompanyProductByNo(4));

		// 회사 자신이 판매하는 제품 수정
		//System.out.println(companyProductService.updateCompanyProductByNo(new CompanyProduct(4, "변경", "변경", "변경", "변경")));

		// 회사 자신이 등록한 제품 삭제
		//System.out.println(companyProductService.deleteCompanyProductByNo(4));
	}

}
