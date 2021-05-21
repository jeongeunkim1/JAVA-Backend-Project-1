package com.avengers.user.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avengers.user.dao.UserInfoDao;
import com.avengers.user.dto.UserInfo;
import com.avengers.user.mapper.UserInfoMapper;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	UserInfoDao userInfoDao;
	
	@Override
	public UserInfo userLogin(UserInfo userInfo) throws Exception {
		return userInfoDao.userLogin(userInfo);
	}
	
	@Override
	public int insertUserInfo(UserInfo userInfo) throws Exception {
		return userInfoDao.insertUserInfo(userInfo);
	}

	@Override
	public UserInfo selectUserIdByEmail(String user_email) throws Exception {
		return userInfoDao.selectUserIdByEmail(user_email);
	}
	
	@Override
	public UserInfo selectUserPasswordById(String user_id) throws Exception {
		return userInfoDao.selectUserPasswordById(user_id);
	}
	
	@Override
	public UserInfo selectUserInfoByNo(int user_no) throws Exception {
		return userInfoDao.selectUserInfoByNo(user_no);
	}
	
	@Override
	public int updateUserInfoById(UserInfo userInfo) throws Exception {
		return userInfoDao.updateUserInfoById(userInfo);
	}

	@Override
	public int deleteUserInfoByNo(int user_no) throws Exception {
		return userInfoDao.deleteUserInfoByNo(user_no);
	}
	@Override
	// 현재 user_no
	public int selectCurrentUserNo() throws Exception{
		return userInfoDao.selectCurrentUserNo();
	}

	@Override
	public List<UserInfo> selectAll() throws Exception {
		
		return userInfoDao.selectAll();
	}
}

