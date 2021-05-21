package com.avengers.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avengers.user.dto.Card;
import com.avengers.user.mapper.CardMapper;

@Repository("cardDao")
public class CardDaoImpl implements CardDao {

	@Autowired
	CardMapper cardMapper;

	// 카드리스트출력
	@Override
	public List<Card> cardSelect(int user_no) throws Exception {
		return cardMapper.cardSelect(user_no);
	}

	// 카드 등록
	@Override
	public int regiCard(Card card) throws Exception {
		return cardMapper.regiCard(card);
	}

	// 카드 삭제
	@Override
	public int deleteCard(String card_no) throws Exception {

		return cardMapper.deleteCard(card_no);
	}

}
