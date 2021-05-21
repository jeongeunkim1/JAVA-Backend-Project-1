package com.avengers.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avengers.user.dto.Jumun;
import com.avengers.user.dto.JumunDetail;
import com.avengers.user.mapper.JumunDetailMapper;
import com.avengers.user.mapper.JumunMapper;

@Repository("jumunDao")
public class JumunDaoImpl implements JumunDao {
	
	@Autowired
	JumunMapper jumunMapper;
	@Autowired
	JumunDetailMapper jumunDetailMapper;
	
	@Override
	public int insertJumun(Jumun jumun) {
		
		int a = jumunMapper.insertJumun(jumun);
		System.out.println("--->"+jumun.getJ_no());
		ArrayList<JumunDetail> jdList=jumun.getJumunDetailList();
		
		for (JumunDetail jumunDetail : jdList) {
			jumunDetail.setJ_no(jumun.getJ_no());
			jumunDetailMapper.insertJumunDetail(jumunDetail);
		}
		
		return a;
	}
	
	@Override
	public int deleteJumunByNo(int j_no) {
		return jumunMapper.deleteJumunByNo(j_no);
	}
	
	@Override
	public List<Jumun> selectJumunAllByUserNo(int user_no) {
		return jumunMapper.selectJumunAllByUserNo(user_no);
	}

	@Override
	public Jumun findCompleteProduct(int user_no) {
		// TODO Auto-generated method stub
		return jumunMapper.findCompleteJumun(user_no);
	}
	
	
}
