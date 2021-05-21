package com.avengers.user.service;

import java.util.List;

import com.avengers.user.dto.Card;

public interface CardService {
	//카드 리스트 출력
		public List<Card> cardSelect(int user_no) throws Exception;
		
		//카드 등록
		public int regiCard(Card card) throws Exception;
		
		//카드 삭제
		public int deleteCard(String card_no) throws Exception;
		
}
