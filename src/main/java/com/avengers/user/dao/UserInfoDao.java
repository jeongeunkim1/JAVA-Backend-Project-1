package com.avengers.user.dao;

import java.util.List;

import com.avengers.user.dto.UserInfo;

public interface UserInfoDao {

	public UserInfo userLogin(UserInfo userInfo) throws Exception;

	public int insertUserInfo(UserInfo userInfo) throws Exception;

	public UserInfo selectUserInfoByNo(int user_no) throws Exception;

	public UserInfo selectUserIdByEmail(String user_email) throws Exception;

	public UserInfo selectUserPasswordById(String user_id) throws Exception;

	public int updateUserInfoById(UserInfo userInfo) throws Exception;

	public int deleteUserInfoByNo(int user_no) throws Exception;

	// 현재 user_no
	public int selectCurrentUserNo() throws Exception;
	
	public List<UserInfo> selectAll() throws Exception;
}