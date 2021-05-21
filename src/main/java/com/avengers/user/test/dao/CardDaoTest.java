package com.avengers.user.test.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dao.CardDao;
import com.avengers.user.dto.Card;

public class CardDaoTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/application-config.xml"});

		CardDao cardDao = (CardDao) applicationContext.getBean("cardDao");

		// 카드 리스트 출력
		//System.out.println(cardDao.cardSelect(3));

		/*
		// 카드 등록
		Card card = new Card("123-456-789", 789, "2022-04-30", 123456, "123456",3);
		//System.out.println(cardDao.regiCard(card));
			
		// 카드삭제
		//System.out.println(cardDao.deleteCard("123-456-789"));
		 */
	}
}
