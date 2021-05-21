package com.avengers.user.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.avengers.user.dto.Card;
import com.avengers.user.service.CardService;

public class CardServiceTest {
	public static void main(String[] args) throws Exception {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "spring/application-config.xml"});

		CardService cardService = (CardService) applicationContext.getBean("cardService");
		// 카드 리스트 출력
		//System.out.println(cardService.cardSelect(1));
		
		// 카드 등록
		Card card = new Card("333-444-555", 666, "2022-11-22", 654321, "654321", 1);
		//System.out.println(cardService.regiCard(card));
		
		// 카드 삭제
		//System.out.println(cardService.deleteCard("333-444-555"));

	}
}