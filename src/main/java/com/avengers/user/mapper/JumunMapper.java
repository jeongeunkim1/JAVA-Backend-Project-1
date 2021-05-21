package com.avengers.user.mapper;

import java.util.List;

import com.avengers.user.dto.Jumun;

public interface JumunMapper {
	//주문 데이터 저장
	public int insertJumun(Jumun jumun);
	
	//주문 데이터 삭제 + 주문 상세 데이터 삭제
	public int deleteJumunByNo(int j_no);
	
	//주문 리스트 불러오기
	public List<Jumun> selectJumunAllByUserNo(int user_no);
	
	//최근 주문 완료된 주문 정보
	public Jumun findCompleteJumun(int user_no);
	
}
