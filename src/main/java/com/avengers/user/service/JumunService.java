package com.avengers.user.service;

import java.util.List;

import com.avengers.user.dto.Jumun;

public interface JumunService {

	int insertJumun(Jumun jumun);

	int deleteJumunByNo(int j_no);

	List<Jumun> selectJumunAllByUserNo(int user_no);
	
	Jumun findCompleteProduct(int user_no);

}