package com.avengers.user.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dto.Jumun;
import com.avengers.user.service.JumunService;

public class JumunServiceTest {
	public static void main(String[] args) throws Exception {
	
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/application-config.xml"});

		JumunService jumunService = (JumunService) applicationContext.getBean("jumunService");
		Jumun jumun=new Jumun(0, null, "desc..", 3400,3); 
		//jumunService.insertJumun(jumun);
		System.out.println(jumun);
		//System.out.println(jumunService.insertJumun(new Jumun(1)));
		//System.out.println(jumunService.deleteJumunByNo(1));
		System.out.println(jumunService.selectJumunAllByUserNo(1));
	
	}

}
