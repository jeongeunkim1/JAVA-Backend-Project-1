package com.avengers.user.test.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dao.JumunDao;
import com.avengers.user.dto.Jumun;
import com.avengers.user.dto.JumunDetail;

public class JumunDaoTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/application-config.xml"});

		JumunDao jumunDao = (JumunDao) applicationContext.getBean("jumunDao");
		
		Jumun jumun = new Jumun(0,null,"xxxxxxx",56000,10);// 주문을 생성
		
			JumunDetail jd1=new  JumunDetail(0,1, 1, jumun.getJ_no(),null); 
			JumunDetail jd2=new  JumunDetail(0,2, 2, jumun.getJ_no(),null);
			ArrayList<JumunDetail> jdList=new  ArrayList<JumunDetail>();
			jdList.add(jd1);
			jdList.add(jd2);
			
			jumun.setJumunDetailList(jdList);
		
		System.out.println(jumunDao.insertJumun(jumun));
		
		
		
		//System.out.println(jumunDao.deleteJumunByNo(12));
		//System.out.println(jumunDao.selectJumunAllByUserNo(1));
		
//		System.out.println(jumunDao.findCompleteProduct(3));
	}
}
