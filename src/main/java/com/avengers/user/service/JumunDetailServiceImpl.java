package com.avengers.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avengers.user.dao.JumunDetailDao;
import com.avengers.user.dto.JumunDetail;

@Service("jumunDetailService")
public class JumunDetailServiceImpl implements JumunDetailService {
	@Autowired
	JumunDetailDao jumunDetailDao;
	
	@Override
	public int insertJumunDetail(JumunDetail jumunDetail) {
		return jumunDetailDao.insertJumunDetail(jumunDetail);
	}
	@Override
	public List<JumunDetail> selectJumunDetailByNo(int j_no) {
		return jumunDetailDao.selectJumunDetailByNo(j_no);
	}
	
	@Override
	public int deleteJumunDetail(int j_no) {
		return jumunDetailDao.deleteJumunDetail(j_no);
	}
	@Override
	public List<JumunDetail> findCompleteJumunDetail(int user_no) {
		// TODO Auto-generated method stub
		return jumunDetailDao.findCompleteJumunDetail(user_no);
	}
}
