package com.avengers.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avengers.user.dao.CardDao;
import com.avengers.user.dto.Card;

@Service("cardService")
public class CardServiceImpl implements CardService {

	@Autowired
	CardDao cardDao;

	// 카드 리스트 출력
	@Override
	public List<Card> cardSelect(int user_no) throws Exception {
		return cardDao.cardSelect(user_no);
	}

	// 카드 등록
	@Override
	public int regiCard(Card card) throws Exception {
		return cardDao.regiCard(card);
	}

	// 카드 삭제
	@Override
	public int deleteCard(String card_no) throws Exception {
		return cardDao.deleteCard(card_no);
	}

}