package com.avengers.user.mapper;

import java.util.List;

import com.avengers.user.dto.UserInfo;

public interface UserInfoMapper {
	
	//로그인
	public UserInfo userLogin(UserInfo userInfo) throws Exception;
	
	// 가입
	public int insertUserInfo(UserInfo userInfo) throws Exception;
	
	// 회원정보 출력
	public UserInfo selectUserInfoByNo(int user_no) throws Exception;
		
	// 아이디 찾기 (이메일로 찾기)
	public UserInfo selectUserIdByEmail(String user_email) throws Exception;
    
	// 비밀번호 찾기
	public UserInfo selectUserPasswordById(String user_id) throws Exception; 
	
	// 수정
	public int updateUserInfo(UserInfo userInfo) throws Exception;

	// 탈퇴
	public int deleteUserInfoByNo(int user_no) throws Exception;
	
	//현재 user_no
	public int selectCurrentUserNo()throws Exception;
	
	public List<UserInfo> selectAll() throws Exception;
	
}
