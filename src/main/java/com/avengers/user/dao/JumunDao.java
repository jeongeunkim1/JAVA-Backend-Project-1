package com.avengers.user.dao;

import java.util.List;

import com.avengers.user.dto.Jumun;

public interface JumunDao {

	int insertJumun(Jumun jumun);

	int deleteJumunByNo(int j_no);
	
	List<Jumun> selectJumunAllByUserNo(int user_no);

	Jumun findCompleteProduct(int user_no);
	
}