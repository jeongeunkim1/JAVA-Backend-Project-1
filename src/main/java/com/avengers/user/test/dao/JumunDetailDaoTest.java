package com.avengers.user.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dao.JumunDetailDao;

public class JumunDetailDaoTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/application-config.xml"});

		JumunDetailDao jumunDetailDao = (JumunDetailDao) applicationContext.getBean("jumunDetailDao");
		//System.out.println(jumunDetailDao.insertJumunDetail(new JumunDetail(0, 2, 11)));
		//System.out.println(jumunDetailDao.selectJumunDetailByNo(11));
		//System.out.println(jumunDetailDao.deleteJumunDetail(11));
		
//		System.out.println(jumunDetailDao.findCompleteJumunDetail(3));
	}
}
