package com.avengers.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avengers.user.dto.UserInfo;
import com.avengers.user.mapper.UserInfoMapper;

@Repository("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {

	@Autowired
	UserInfoMapper userInfoMapper;

	@Override
	public UserInfo userLogin(UserInfo userInfo) throws Exception {
		return userInfoMapper.userLogin(userInfo);
	}

	@Override
	public int insertUserInfo(UserInfo userInfo) throws Exception {
		return userInfoMapper.insertUserInfo(userInfo);
	}

	@Override
	public UserInfo selectUserInfoByNo(int user_no) throws Exception {
		return userInfoMapper.selectUserInfoByNo(user_no);
	}

	@Override
	public UserInfo selectUserIdByEmail(String user_email) throws Exception {
		return userInfoMapper.selectUserIdByEmail(user_email);
	}

	@Override
	public UserInfo selectUserPasswordById(String user_id) throws Exception {
		return userInfoMapper.selectUserPasswordById(user_id);
	}

	@Override
	public int updateUserInfoById(UserInfo userInfo) throws Exception {
		return userInfoMapper.updateUserInfo(userInfo);
	}

	@Override
	public int deleteUserInfoByNo(int user_no) throws Exception {
		return userInfoMapper.deleteUserInfoByNo(user_no);
	}
	
	// 현재 user_no
	@Override
	public int selectCurrentUserNo() throws Exception {
		return userInfoMapper.selectCurrentUserNo();
	}

	@Override
	public List<UserInfo> selectAll() throws Exception {
		return userInfoMapper.selectAll();
	};

}