package com.avengers.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avengers.user.dao.CartDao;
import com.avengers.user.dao.JumunDao;
import com.avengers.user.dao.JumunDetailDao;
import com.avengers.user.dto.Cart;
import com.avengers.user.dto.Jumun;
import com.avengers.user.dto.JumunDetail;

@Service("jumunService")
public class JumunServiceImpl implements JumunService{
	
	@Autowired
	JumunDao jumunDao;
	@Autowired
	JumunDetailDao jumunDetailDao;
	@Autowired
	CartDao cartDao ;
	
	@Override
	public int insertJumun(Jumun jumun) {
		int j=0;
			try {
				j= jumunDao.insertJumun(jumun);
				System.out.println("----------->"+jumun);
				
				List<Cart> c = cartDao.selectCartAllByNo(jumun.getUser_no());				
				for (Cart cart : c) {					
					jumunDetailDao.insertJumunDetail(new JumunDetail(0,cart.getProduct_no(),cart.getCart_quantity() ,jumun.getJ_no(), null));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return j;
	}
	
	@Override
	public int deleteJumunByNo(int j_no) {
		return jumunDao.deleteJumunByNo(j_no);
	}
	
	@Override
	public List<Jumun> selectJumunAllByUserNo(int user_no){
		return jumunDao.selectJumunAllByUserNo(user_no);
	}

	@Override
	public Jumun findCompleteProduct(int user_no) {
		// TODO Auto-generated method stub
		return jumunDao.findCompleteProduct(user_no);
	}
	
	
	
	
}
