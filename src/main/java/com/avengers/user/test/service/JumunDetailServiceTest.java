package com.avengers.user.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.service.JumunDetailService;

public class JumunDetailServiceTest {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/application-config.xml"});
		
		JumunDetailService jumunDetailService = (JumunDetailService) applicationContext.getBean("jumunDetailService");
		//System.out.println(jumunDetailService.insertJumunDetail(new JumunDetail(0, 2, 2)));
		//jumunDetailService.insertJumunDetail(new JumunDetail(0,30, 1, 66, null));
	
	}
}
