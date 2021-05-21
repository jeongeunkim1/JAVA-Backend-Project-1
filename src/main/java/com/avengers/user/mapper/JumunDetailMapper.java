package com.avengers.user.mapper;

import java.util.List;

import com.avengers.user.dto.JumunDetail;

public interface JumunDetailMapper {
	// 주문 디테일 데이터 저장
	public int insertJumunDetail(JumunDetail jumunDetail);

	//jumun에 있는 모든 jumundetatil을 불러와야 합니다.
	public List<JumunDetail> selectJumunDetailByNo(int j_no);
	
	// 주문 디테일 삭제
	public int deleteJumunDetail(int j_no);
	
	public List<JumunDetail> findCompleteJumunDetail(int user_no); 

}
