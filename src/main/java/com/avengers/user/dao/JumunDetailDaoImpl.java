package com.avengers.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avengers.user.dto.JumunDetail;
import com.avengers.user.mapper.JumunDetailMapper;

@Repository("jumunDetailDao")
public class JumunDetailDaoImpl implements JumunDetailDao {
	
	@Autowired
	JumunDetailMapper jumunDetailMapper;
	
	@Override
	public int insertJumunDetail(JumunDetail jumunDetail) {
		return jumunDetailMapper.insertJumunDetail(jumunDetail);
	}
	@Override
	public List<JumunDetail> selectJumunDetailByNo(int j_no) {
		return jumunDetailMapper.selectJumunDetailByNo(j_no);
	}
	
	@Override
	public int deleteJumunDetail(int j_no) {
		return jumunDetailMapper.deleteJumunDetail(j_no);
	}
	@Override
	public List<JumunDetail> findCompleteJumunDetail(int user_no) {
		// TODO Auto-generated method stub
		return jumunDetailMapper.findCompleteJumunDetail(user_no);
	}

}
